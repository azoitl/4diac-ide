/*******************************************************************************
 * Copyright (c) 2022 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Daniel Lindhuber
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.elk.connection;

import org.eclipse.fordiac.ide.application.editparts.ConnectionEditPart;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.model.libraryElement.Group;

public class StandardConnectionRoutingHelper extends AbstractConnectionRoutingHelper {

	public static final StandardConnectionRoutingHelper INSTANCE = new StandardConnectionRoutingHelper();

	@Override
	void saveConnections(final ConnectionLayoutMapping mapping, final InterfaceEditPart ie) {
		for (final Object obj : ie.getTargetConnections()) {
			final ConnectionEditPart conn = (ConnectionEditPart) obj;
			final Group sourceGroup = getGroupFromModel(conn.getSource().getParent().getModel());
			final Group targetGroup = getGroupFromModel(conn.getTarget().getParent().getModel());

			if (sourceGroup == null && targetGroup == null) {
				mapping.getConnections().add(conn);
			}
		}
	}

}
