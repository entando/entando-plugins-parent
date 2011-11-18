/*
*
* Copyright 2005 AgileTec s.r.l. (http://www.agiletec.it) All rights reserved.
*
* This file is part of jAPS software.
* jAPS is a free software; 
* you can redistribute it and/or modify it
* under the terms of the GNU General Public License (GPL) as published by the Free Software Foundation; version 2.
* 
* See the file License for the specific language governing permissions   
* and limitations under the License
* 
* 
* 
* Copyright 2005 AgileTec s.r.l. (http://www.agiletec.it) All rights reserved.
*
*/
package com.agiletec.plugins.jpaddressbook.aps.system.services.addressbook.model;

import com.agiletec.aps.system.common.entity.model.ApsEntityRecord;

/**
 * @author E.Santoboni
 */
public class ContactRecord extends ApsEntityRecord {
	
	public String getOwner() {
		return _owner;
	}
	public void setOwner(String owner) {
		this._owner = owner;
	}
	
	public boolean isPublicContact() {
		return _publicContact;
	}
	public void setPublicContact(boolean publicContact) {
		this._publicContact = publicContact;
	}
	
	private String _owner;
	private boolean _publicContact;
	
}
