/*******************************************************************************
 * Copyright (c) 2018 Abel Gómez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Abel Gómez - initial API and implementation
 *******************************************************************************/
package io.github.abelgomez.kyanos.core.impl;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import io.github.abelgomez.kyanos.KyanosURI;
import io.github.abelgomez.kyanos.core.KyanosResourceFactory;
import io.github.abelgomez.kyanos.graph.impl.KyanosGraphResourceImpl;
import io.github.abelgomez.kyanos.hbase.impl.KyanosHbaseResourceImpl;
import io.github.abelgomez.kyanos.map.impl.KyanosMapResourceImpl;

public class KyanosResourceFactoryImpl implements KyanosResourceFactory {

	@Override
	public Resource createResource(URI uri) {
		if (StringUtils.equals(KyanosURI.KYANOS_GRAPH_SCHEME, uri.scheme())) {
			return new KyanosGraphResourceImpl(uri);
		} else if (StringUtils.equals(KyanosURI.KYANOS_MAP_SCHEME, uri.scheme())) {
			return new KyanosMapResourceImpl(uri);
		} else if (StringUtils.equals(KyanosURI.KYANOS_HBASE_SCHEME, uri.scheme())) {
			return new KyanosHbaseResourceImpl(uri);
		} else {
			return null;
		}
	}

}
