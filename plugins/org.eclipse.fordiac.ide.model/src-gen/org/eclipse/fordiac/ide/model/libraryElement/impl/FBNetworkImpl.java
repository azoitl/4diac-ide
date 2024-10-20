/**
 * *******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *               2022 Martin Erich Jobst
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger, Martin Jobst
 *      - initial API and implementation and/or initial documentation
 * *******************************************************************************
 */
package org.eclipse.fordiac.ide.model.libraryElement.impl;

import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterConnection;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.DataConnection;
import org.eclipse.fordiac.ide.model.libraryElement.EventConnection;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FB Network</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.FBNetworkImpl#getNetworkElements <em>Network Elements</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.FBNetworkImpl#getDataConnections <em>Data Connections</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.FBNetworkImpl#getEventConnections <em>Event Connections</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.FBNetworkImpl#getAdapterConnections <em>Adapter Connections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FBNetworkImpl extends EObjectImpl implements FBNetwork {
	/**
	 * The cached value of the '{@link #getNetworkElements() <em>Network Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FBNetworkElement> networkElements;

	/**
	 * The cached value of the '{@link #getDataConnections() <em>Data Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<DataConnection> dataConnections;

	/**
	 * The cached value of the '{@link #getEventConnections() <em>Event Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<EventConnection> eventConnections;

	/**
	 * The cached value of the '{@link #getAdapterConnections() <em>Adapter Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdapterConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<AdapterConnection> adapterConnections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FBNetworkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.FB_NETWORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FBNetworkElement> getNetworkElements() {
		if (networkElements == null) {
			networkElements = new EObjectContainmentEList<FBNetworkElement>(FBNetworkElement.class, this, LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS);
		}
		return networkElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataConnection> getDataConnections() {
		if (dataConnections == null) {
			dataConnections = new EObjectContainmentWithInverseEList<DataConnection>(DataConnection.class, this, LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS, LibraryElementPackage.DATA_CONNECTION__FB_NETWORK);
		}
		return dataConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventConnection> getEventConnections() {
		if (eventConnections == null) {
			eventConnections = new EObjectContainmentWithInverseEList.Resolving<EventConnection>(EventConnection.class, this, LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS, LibraryElementPackage.EVENT_CONNECTION__FB_NETWORK);
		}
		return eventConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AdapterConnection> getAdapterConnections() {
		if (adapterConnections == null) {
			adapterConnections = new EObjectContainmentWithInverseEList<AdapterConnection>(AdapterConnection.class, this, LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS, LibraryElementPackage.ADAPTER_CONNECTION__FB_NETWORK);
		}
		return adapterConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addConnection(final Connection connection) {
		org.eclipse.fordiac.ide.model.Annotations.addConnection(this, connection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeConnection(final Connection connection) {
		org.eclipse.fordiac.ide.model.Annotations.removeConnection(this, connection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isApplicationNetwork() {
		return org.eclipse.fordiac.ide.model.Annotations.isApplicationNetwork(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSubApplicationNetwork() {
		return org.eclipse.fordiac.ide.model.Annotations.isSubApplicationNetwork(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResourceNetwork() {
		return org.eclipse.fordiac.ide.model.Annotations.isResourceNetwork(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCFBTypeNetwork() {
		return org.eclipse.fordiac.ide.model.Annotations.isCFBTypeNetwork(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AutomationSystem getAutomationSystem() {
		return org.eclipse.fordiac.ide.model.Annotations.getAutomationSystem(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Application getApplication() {
		return org.eclipse.fordiac.ide.model.Annotations.getApplication(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FB getFBNamed(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.getFBNamed(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubApp getSubAppNamed(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.getSubAppNamed(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FBNetworkElement getElementNamed(final String name) {
		return org.eclipse.fordiac.ide.model.Annotations.getElementNamed(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getConnectionIndex(final Connection connection) {
		return org.eclipse.fordiac.ide.model.Annotations.getConnectionIndex(this, connection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCollisions(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		return org.eclipse.fordiac.ide.model.libraryElement.impl.FBNetworkAnnotations.validateCollisions(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataConnections()).basicAdd(otherEnd, msgs);
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEventConnections()).basicAdd(otherEnd, msgs);
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAdapterConnections()).basicAdd(otherEnd, msgs);
			default:
				return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addConnectionWithIndex(final Connection connection, final int index) {
		org.eclipse.fordiac.ide.model.Annotations.addConnectionWithIndex(this, connection, index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS:
				return ((InternalEList<?>)getNetworkElements()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				return ((InternalEList<?>)getDataConnections()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return ((InternalEList<?>)getEventConnections()).basicRemove(otherEnd, msgs);
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return ((InternalEList<?>)getAdapterConnections()).basicRemove(otherEnd, msgs);
			default:
				return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS:
				return getNetworkElements();
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				return getDataConnections();
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return getEventConnections();
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return getAdapterConnections();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS:
				getNetworkElements().clear();
				getNetworkElements().addAll((Collection<? extends FBNetworkElement>)newValue);
				return;
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				getDataConnections().clear();
				getDataConnections().addAll((Collection<? extends DataConnection>)newValue);
				return;
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				getEventConnections().clear();
				getEventConnections().addAll((Collection<? extends EventConnection>)newValue);
				return;
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
				getAdapterConnections().addAll((Collection<? extends AdapterConnection>)newValue);
				return;
			default:
				super.eSet(featureID, newValue);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS:
				getNetworkElements().clear();
				return;
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				getDataConnections().clear();
				return;
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				getEventConnections().clear();
				return;
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				getAdapterConnections().clear();
				return;
			default:
				super.eUnset(featureID);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.FB_NETWORK__NETWORK_ELEMENTS:
				return networkElements != null && !networkElements.isEmpty();
			case LibraryElementPackage.FB_NETWORK__DATA_CONNECTIONS:
				return dataConnections != null && !dataConnections.isEmpty();
			case LibraryElementPackage.FB_NETWORK__EVENT_CONNECTIONS:
				return eventConnections != null && !eventConnections.isEmpty();
			case LibraryElementPackage.FB_NETWORK__ADAPTER_CONNECTIONS:
				return adapterConnections != null && !adapterConnections.isEmpty();
			default:
				return super.eIsSet(featureID);
		}
	}

} //FBNetworkImpl
