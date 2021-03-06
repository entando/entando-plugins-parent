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
package com.agiletec.plugins.jpmyportalplus;

import com.agiletec.plugins.jpmyportalplus.aps.system.services.config.TestMyPortalConfigManager;
import com.agiletec.plugins.jpmyportalplus.aps.system.services.pagemodel.TestPageModelManager;
import com.agiletec.plugins.jpmyportalplus.aps.system.services.userconfig.TestPageUserConfigManager;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Change me with a suitable description");

		suite.addTestSuite(TestMyPortalConfigManager.class);
		suite.addTestSuite(TestPageModelManager.class);
		suite.addTestSuite(TestPageUserConfigManager.class);
		
		return suite;
	}
	
}
