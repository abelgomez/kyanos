/*******************************************************************************
 * Copyright (c) 2018 Abel G�mez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Abel G�mez - initial API and implementation
 *******************************************************************************/
package io.github.abelgomez.kyanos.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;

import io.github.abelgomez.kyanos.core.impl.KyanosEFactoryImpl;


public interface KyanosEFactory extends EFactory {

	public static KyanosEFactory eINSTANCE = new KyanosEFactoryImpl();

	@Override
	public KyanosEObject create(EClass eClass);
	
}
