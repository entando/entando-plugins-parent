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
package com.agiletec.plugins.jpnewsletter.apsadmin.newsletter;

import java.util.List;

public interface INewsletterFinderAction {
	
	/**
	 * Restituisce la lista identificativi di contenuti che deve essere erogata dall'interfaccia di 
	 * visualizzazione dei contenuti. La lista deve essere filtrata secondo i parametri di ricerca impostati.
	 * @return La lista di contenuti che deve essere erogata dall'interfaccia di 
	 * visualizzazione dei contenuti.
	 */
	public List<String> getContents();
	
	/**
	 * Esegue la rimozione del contenuto alla coda della newsletter.
	 * @return Il codice del risultato dell'azione.
	 */
	public String removeFromQueue();
	
	/**
	 * Esegue l'aggiunta del contenuto alla coda della newsletter.
	 * @return Il codice del risultato dell'azione.
	 */
	public String addToQueue();
	
}