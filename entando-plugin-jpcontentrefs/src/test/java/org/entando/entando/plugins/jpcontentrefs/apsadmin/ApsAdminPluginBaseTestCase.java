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
package org.entando.entando.plugins.jpcontentrefs.apsadmin;

import com.agiletec.ConfigTestUtils;
import com.agiletec.apsadmin.ApsAdminBaseTestCase;
import org.entando.entando.plugins.jpcontentrefs.PluginConfigTestUtils;

public class ApsAdminPluginBaseTestCase extends ApsAdminBaseTestCase {
	
	@Override
	protected ConfigTestUtils getConfigUtils() {
		return new PluginConfigTestUtils();
	}
	
}
