/*******************************************************************************
 * Copyright (c) 2023 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Bianca Wiesmayr - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.systemconfiguration.segment.Communication;

import org.eclipse.fordiac.ide.systemconfiguration.segment.TsnParameters;

public class Annotations {
	// TsnWindow
	public static String getTsnWindowName(final TsnWindow w) {
		return TsnParameters.TSN_WINDOW_NAME + ((TsnConfiguration) w.eContainer()).getWindows().indexOf(w);
	}

	private Annotations() {
		throw new UnsupportedOperationException("do not instantiate this class"); ////$NON-NLS-1$
	}
}
