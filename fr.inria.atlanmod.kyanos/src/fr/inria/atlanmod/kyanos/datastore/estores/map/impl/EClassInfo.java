/*******************************************************************************
 * Copyright (c) 2014 Abel G�mez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Abel G�mez - initial API and implementation
 ******************************************************************************/
package fr.inria.atlanmod.kyanos.datastore.estores.map.impl;

import java.io.Serializable;

class EClassInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String nsURI;
	
	public String className;
	
	public EClassInfo(String nsURI, String className) {
		this.nsURI = nsURI;
		this.className = className;
	}
}

