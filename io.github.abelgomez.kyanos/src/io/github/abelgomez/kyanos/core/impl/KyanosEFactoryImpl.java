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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import io.github.abelgomez.kyanos.core.KyanosEFactory;
import io.github.abelgomez.kyanos.core.KyanosInternalEObject;

public class KyanosEFactoryImpl extends EFactoryImpl implements KyanosEFactory {

	@Override
	public KyanosInternalEObject create(EClass eClass) {
		KyanosEObjectImpl eObject = new KyanosEObjectImpl();
		eObject.eSetClass(eClass);
		return eObject;
	}
}
