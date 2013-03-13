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

/**
 * This class parses the configuration of jpmyportal
 * @author E. Mezzano
 *
 */
package com.agiletec.plugins.jpmyportal.aps.system.services.userconfig.parse;

import java.io.StringReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.agiletec.aps.system.ApsSystemUtils;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.plugins.jpmyportal.aps.system.services.userconfig.model.MyPortalConfig;

/*
<?xml version="1.0" encoding="UTF-8"?>
<myportalConfig ajaxEnabled="true" >
	<showlets>
		<showlet code="jpmyportal_void" />
		<showlet code="inEvidenza" />
		<showlet code="latestAnnounces" />
		<showlet code="latestEvents" />
		<showlet code="latestNews" />
		<showlet code="employee_search" />
		<showlet code="employee_search_advanced" />
	</showlets>
</myportalConfig>
*/

public class MyPortalConfigDOM {
	
	public MyPortalConfig extractConfig(String xml) throws ApsSystemException {
		Element root = this.getRootElement(xml);
		MyPortalConfig config = new MyPortalConfig();
		
		String ajaxEnabled = root.getAttributeValue(AJAXENABLED_ATTR);
		config.setAjaxEnabled("true".equals(ajaxEnabled));
		
		this.extractShowletConfig(root, config);
		
		return config;
	}
	
	/**
	 * Create an xml containing the MyPortal configuration.
	 * @param config The MyPortal configuration.
	 * @return The xml containing the configuration.
	 * @throws ApsSystemException In case of errors.
	 */
	public String createConfigXml(MyPortalConfig config) throws ApsSystemException {
		Element root = this.createConfigElement(config);
		Document doc = new Document(root);
		String xml = new XMLOutputter().outputString(doc);
		return xml;
	}
	
	private void extractShowletConfig(Element root, MyPortalConfig config) {
		Element element = root.getChild(ALLOWED_SHOWLETS_ELEM);
		
		Set<String> allowedShowlets = new TreeSet<String>();
		List<Element> codeElements = element.getChildren(SHOWLET_ELEM);
		for (Element codeElem : codeElements) {
			String code = codeElem.getAttributeValue(SHOWLET_CODE_ATTR);
			allowedShowlets.add(code);
		}
		config.setAllowedShowlets(allowedShowlets);
	}
	
	/**
	 * Create the configuration element for the myportal service.
	 * @param config The configuration of myportal service
	 * @return the configuration of this plugin.
	 */
	private Element createConfigElement(MyPortalConfig config) {
		Element configElem = new Element(ROOT);
		
		configElem.setAttribute(AJAXENABLED_ATTR, String.valueOf(config.isAjaxEnabled()));
		
		Element allowedShowletsElem = this.createShowletsElement(config);
		configElem.addContent(allowedShowletsElem);
		
		return configElem;
	}
	
	private Element createShowletsElement(MyPortalConfig config) {
		Element showletsElement = new Element(ALLOWED_SHOWLETS_ELEM);
		
		Set<String> showlets = config.getAllowedShowlets();
		for (String showletCode : showlets) {
			Element showletElem = new Element(SHOWLET_ELEM);
			showletElem.setAttribute(SHOWLET_CODE_ATTR, showletCode);
			showletsElement.addContent(showletElem);
		}
		return showletsElement;
	}
	
	/**
	 * Returns the XML element from a given text.
	 * @param xmlText The text containing an Xml.
	 * @return The XML element from a given text.
	 * @throws ApsSystemException In case of parsing exceptions.
	 */
	private Element getRootElement(String xmlText) throws ApsSystemException {
		SAXBuilder builder = new SAXBuilder();
		builder.setValidation(false);
		StringReader reader = new StringReader(xmlText);
		Element root = null;
		try {
			Document doc = builder.build(reader);
			root = doc.getRootElement();
		} catch (Throwable t) {
			ApsSystemUtils.getLogger().severe("Error parsing xml: " + t.getMessage());
			throw new ApsSystemException("Error parsing xml", t);
		}
		return root;
	}
	
	private static final String ROOT = "myportalConfig";
	
	private static final String AJAXENABLED_ATTR = "ajaxEnabled";
	
	private static final String ALLOWED_SHOWLETS_ELEM = "showlets";
	private static final String SHOWLET_ELEM = "showlet";
	private static final String SHOWLET_CODE_ATTR = "code";
	
}