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
package fr.inria.atlanmod.kyanos.core.impl;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.kyanos.KyanosURI;
import fr.inria.atlanmod.kyanos.core.KyanosResourceFactory;
import fr.inria.atlanmod.kyanos.core.graph.impl.KyanosGraphResourceImpl;
import fr.inria.atlanmod.kyanos.core.map.impl.KyanosMapResourceImpl;

public class KyanosResourceFactoryImpl implements KyanosResourceFactory {

	@Override
	public Resource createResource(URI uri) {
		if (StringUtils.equals(KyanosURI.KYANOS_GRAPH_SCHEME, uri.scheme())) {
			return new KyanosGraphResourceImpl(uri);
		} else if (StringUtils.equals(KyanosURI.KYANOS_MAP_SCHEME, uri.scheme())) {
			return new KyanosMapResourceImpl(uri);
		} else {
			return null;
		}
	}

}
