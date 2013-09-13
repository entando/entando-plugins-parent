/*
 *
 * Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
 *
 * This file is part of Entando software.
 * Entando is a free software; 
 * you can redistribute it and/or modify it
 * under the terms of the GNU General Public License (GPL) as published by the Free Software Foundation; version 2.
 * 
 * See the file License for the specific language governing permissions   
 * and limitations under the License
 * 
 * 
 * 
 * Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
 *
 */
package com.agiletec.plugins.jpmyportalplus.apsadmin.config;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.entando.entando.aps.system.services.widgettype.IWidgetTypeManager;
import org.entando.entando.aps.system.services.widgettype.WidgetType;
import org.entando.entando.aps.system.services.widgettype.WidgetTypeParameter;

import com.agiletec.aps.system.ApsSystemUtils;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.util.SelectItem;
import com.agiletec.apsadmin.portal.AbstractPortalAction;
import com.agiletec.plugins.jpmyportalplus.aps.system.services.config.IMyPortalConfigManager;
import com.agiletec.plugins.jpmyportalplus.aps.system.services.config.model.MyPortalConfig;

/**
 * @author E.Santoboni
 */
public class ConfigAction extends AbstractPortalAction implements IConfigAction {
	
	@Override
	public void validate() {
		super.validate();
		Set<String> widgetTypeCodes = this.getShowletTypeCodes();
		IWidgetTypeManager widgetTypeManager = this.getWidgetTypeManager();
		for (String widgetCode : widgetTypeCodes) {
			if (!this.isShowletAllowed(widgetTypeManager.getWidgetType(widgetCode))) {
				this.addFieldError("showlets", this.getText("errors.jpmyportalConfig.widgets.notValid", new String[] { widgetCode }));
			}
		}
	}
	
	@Override
	public String edit() {
		try {
			MyPortalConfig config = this.getMyPortalConfigManager().getConfig();
			this.populateForm(config);
		} catch (Throwable t) {
			ApsSystemUtils.logThrowable(t, this, "edit");
			return FAILURE;
		}
		return SUCCESS;
	}
	
	/**
	 * @deprecated Use {@link #addWidget()} instead
	 */
	@Override
	public String addShowlet() {
		return addWidget();
	}

	@Override
	public String addWidget() {
		try {
			String widgetCode = this.getShowletCode();
			WidgetType type = this.getWidgetTypeManager().getWidgetType(widgetCode);
			if (this.isShowletAllowed(type)) {
				this.getShowletTypeCodes().add(widgetCode);
			} else {
				this.addFieldError("showletCode", this.getText("Errors.jpmyportalConfig.WidgetType.notValid", new String[] { widgetCode }));
				return INPUT;
			}
		} catch (Throwable t) {
			ApsSystemUtils.logThrowable(t, this, "addWidget");
			return FAILURE;
		}
		return SUCCESS;
	}
	
	/**
	 * @deprecated Use {@link #removeWidget()} instead
	 */
	@Override
	public String removeShowlet() {
		return removeWidget();
	}

	@Override
	public String removeWidget() {
		try {
			String widgetCode = this.getShowletCode();
			if (widgetCode != null) {
				this.getShowletTypeCodes().remove(widgetCode);
			}
		} catch (Throwable t) {
			ApsSystemUtils.logThrowable(t, this, "removeWidget");
			return FAILURE;
		}
		return SUCCESS;
	}
	
	@Override
	public String save() {
		try {
			MyPortalConfig config = this.prepareConfig();
			this.getMyPortalConfigManager().saveConfig(config);
			this.addActionMessage(this.getText("jpmyportalplus.message.configSavedOk"));
		} catch (Throwable t) {
			ApsSystemUtils.logThrowable(t, this, "save");
			return FAILURE;
		}
		return SUCCESS;
	}
	
	private void populateForm(MyPortalConfig config) {
		Set<String> allowedShowlets = config.getAllowedShowlets();
		IWidgetTypeManager showletTypeManager = this.getWidgetTypeManager();
		Set<String> showlets = new TreeSet<String>();
		for (String showletCode : allowedShowlets) {
			if (this.isShowletAllowed(showletTypeManager.getWidgetType(showletCode))) {
				showlets.add(showletCode);
			}
		}
		this.setShowletTypeCodes(showlets);
	}
	
	@Override
	protected void addFlavourShowletType(String mapCode, WidgetType type, Map<String, List<SelectItem>> mapping) {
		if (null == type) return;
		List<WidgetTypeParameter> typeParameters = type.getTypeParameters();
		if (!type.isUserType() && !type.isLogic() && (null != typeParameters && typeParameters.size() > 0)) return;
		if (type.getCode().equals(this.getMyPortalConfigManager().getVoidShowletCode())) return;
		super.addFlavourShowletType(mapCode, type, mapping);
	}
	
	private MyPortalConfig prepareConfig() throws ApsSystemException {
		MyPortalConfig config = new MyPortalConfig();
		config.setAllowedShowlets(this.getShowletTypeCodes());
		return config;
	}
	
	public WidgetType getShowletType(String showletCode) {
		return this.getWidgetTypeManager().getWidgetType(showletCode);
	}
	
	private boolean isShowletAllowed(WidgetType WidgetType) {
		return WidgetType != null && 
				(WidgetType.isLogic() || WidgetType.isUserType() || WidgetType.getTypeParameters()==null || WidgetType.getTypeParameters().isEmpty());
	}
	
	public Set<String> getShowletTypeCodes() {
		return _showletTypeCodes;
	}
	public void setShowletTypeCodes(Set<String> showletTypeCodes) {
		this._showletTypeCodes = showletTypeCodes;
	}
	
	public String getShowletCode() {
		return _showletCode;
	}
	public void setShowletCode(String showletCode) {
		this._showletCode = showletCode;
	}
	
	protected IMyPortalConfigManager getMyPortalConfigManager() {
		return _myPortalConfigManager;
	}
	public void setMyPortalConfigManager(IMyPortalConfigManager myPortalConfigManager) {
		this._myPortalConfigManager = myPortalConfigManager;
	}
	
	private Set<String> _showletTypeCodes = new TreeSet<String>();
	
	private String _showletCode;
	
	private IMyPortalConfigManager _myPortalConfigManager;
	
}