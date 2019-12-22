/*******************************************************************************
 * Copyright (c) 2019 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Bianca Wiesmayr - initial implementation
 *******************************************************************************/

package org.eclipse.fordiac.ide.ui.widget;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.viewers.TextCellEditor;

public class CustomTextCellEditor extends TextCellEditor {

	public CustomTextCellEditor(Composite parent) {
		super(parent);
	}

	@Override
	protected int getDoubleClickTimeout() {
		return 0;
	}
}
