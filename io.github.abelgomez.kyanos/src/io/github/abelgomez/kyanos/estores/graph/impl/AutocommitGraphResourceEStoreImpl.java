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
package io.github.abelgomez.kyanos.estores.graph.impl;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.InternalEObject.EStore;
import org.eclipse.emf.ecore.resource.Resource;

import io.github.abelgomez.kyanos.core.graph.impl.KyanosGraph;

public class AutocommitGraphResourceEStoreImpl extends DirectWriteGraphResourceEStoreImpl {

	/**
	 * Default number of allowed modifications (100000) between commits on the
	 * underlying graph
	 */
	protected static final int OPS_BETWEEN_COMMITS_DEFAULT = 100000;

	/**
	 * Number of allowed modifications between commits on the underlying graph
	 * for this {@link AutocommitGraphResourceEStoreImpl}
	 */
	protected final int OPS_BETWEEN_COMMITS;

	/**
	 * Current number of modifications modulo {@link #OPS_BETWEEN_COMMITS}
	 */
	protected static int opCount = 0;

	/**
	 * Constructor for this {@link KyanosGraph}-based {@link EStore}. Allows to
	 * specify the number of allowed modification on the underlying graph before
	 * calling the {@link KyanosGraph#commit()} method automatically.
	 * 
	 * @param resource
	 * @param graph
	 * @param opsBetweenCommits
	 */
	public AutocommitGraphResourceEStoreImpl(Resource.Internal resource, KyanosGraph graph, int opsBetweenCommits) {
		super(resource, graph);
		this.OPS_BETWEEN_COMMITS = opsBetweenCommits;
	}

	/**
	 * Constructor for this {@link KyanosGraph}-based {@link EStore}. Allows to
	 * make {@link #OPS_BETWEEN_COMMITS_DEFAULT} modifications on the underlying
	 * graph before calling the {@link KyanosGraph#commit()} method
	 * automatically.
	 * 
	 * @param resource
	 * @param graph
	 */
	public AutocommitGraphResourceEStoreImpl(Resource.Internal resource, KyanosGraph graph) {
		this(resource, graph, OPS_BETWEEN_COMMITS_DEFAULT);
	}

	@Override
	public void add(InternalEObject object, EStructuralFeature feature, int index, Object value) {
		super.add(object, feature, index, value);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
	}

	@Override
	public Object set(InternalEObject object, EStructuralFeature feature, int index, Object value) {
		Object returnValue = super.set(object, feature, index, value);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
		return returnValue;
	}

	@Override
	public Object move(InternalEObject object, EStructuralFeature feature, int targetIndex, int sourceIndex) {
		Object returnValue = super.move(object, feature, targetIndex, sourceIndex);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
		return returnValue;
	}

	@Override
	public Object remove(InternalEObject object, EStructuralFeature feature, int index) {
		Object returnValue = super.remove(object, feature, index);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
		return returnValue;
	}

	@Override
	public void unset(InternalEObject object, EStructuralFeature feature) {
		super.unset(object, feature);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
	}

	@Override
	public void clear(InternalEObject object, EStructuralFeature feature) {
		super.clear(object, feature);
		opCount = (opCount + 1) % OPS_BETWEEN_COMMITS;
		if (opCount == 0) {
			graph.commit();
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		graph.commit();
	}
}
