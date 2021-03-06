/*
*
* Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
* This file is part of Entando software. 
* Entando is a free software; 
* You can redistribute it and/or modify it
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
package com.agiletec.plugins.jpshowletreplicator.aps.tags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.entando.entando.aps.system.services.widgettype.WidgetType;

import com.agiletec.aps.system.ApsSystemUtils;
import com.agiletec.aps.system.RequestContext;
import com.agiletec.aps.system.SystemConstants;
import com.agiletec.aps.system.services.page.IPage;
import com.agiletec.aps.system.services.page.IPageManager;
import com.agiletec.aps.tags.ExecWidgetTag;
import com.agiletec.aps.util.ApsWebApplicationUtils;
import com.agiletec.aps.system.services.page.Widget;

/**
 * @author E.Santoboni
 */
public class WidgetReplicatorTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		ServletRequest req =  this.pageContext.getRequest();
		RequestContext reqCtx = (RequestContext) req.getAttribute(RequestContext.REQCTX);
		try {
			Widget currentShowlet = (Widget) reqCtx.getExtraParam(SystemConstants.EXTRAPAR_CURRENT_WIDGET);
			String pageCode = currentShowlet.getConfig().getProperty("pageCodeParam");
			IPageManager pageManager = (IPageManager) ApsWebApplicationUtils.getBean(SystemConstants.PAGE_MANAGER, this.pageContext);
			IPage targetPage = pageManager.getPage(pageCode);
			if (null != targetPage) {
				String frameIdString = currentShowlet.getConfig().getProperty("frameIdParam");
				int frameId = Integer.parseInt(frameIdString);
				Widget[] showlets = targetPage.getWidgets();
				if (showlets.length>=frameId) {
					Widget targetShowlet = targetPage.getWidgets()[frameId];
					if (null != targetShowlet) {
						reqCtx.addExtraParam(SystemConstants.EXTRAPAR_CURRENT_WIDGET, targetShowlet);
						WidgetType WidgetType = targetShowlet.getType();
						if (WidgetType.isLogic()) {
							WidgetType = WidgetType.getParentType();
						}
						String pluginCode = WidgetType.getPluginCode();
						boolean isPluginShowlet = (null != pluginCode && pluginCode.trim().length()>0);
						StringBuffer jspPath = new StringBuffer("/WEB-INF/");
						if (isPluginShowlet) {
							jspPath.append("plugins/").append(pluginCode.trim()).append("/");
						}
						jspPath.append(ExecWidgetTag.WIDGET_LOCATION).append(WidgetType.getCode()).append(".jsp");

						this.pageContext.include(jspPath.toString());
					}
				}
			}
		} catch (Throwable t) {
			String msg = "Errore in preelaborazione showlets";
			ApsSystemUtils.logThrowable(t, this, "doEndTag", msg);
			throw new JspException(msg, t);
		}
		return EVAL_PAGE;
	}

}