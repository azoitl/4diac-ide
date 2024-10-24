/*******************************************************************************
 * Copyright (c) 2023 Martin Erich Jobst
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Jobst - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.gef.editparts;

import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

public class TypeDeclarationDirectEditManager extends TextDirectEditManager {
	private final VarDeclaration varDeclaration;

	public TypeDeclarationDirectEditManager(final GraphicalEditPart source, final CellEditorLocator locator,
			final VarDeclaration varDeclaration) {
		super(source, locator);
		this.varDeclaration = varDeclaration;
	}

	@Override
	protected CellEditor createCellEditorOn(final Composite composite) {
		return new TypeDeclarationCellEditor(composite, varDeclaration);
	}

	@Override
	protected void initCellEditor() {
		super.initCellEditor();
		getCellEditor().setValue(varDeclaration.getFullTypeName());
	}
}
