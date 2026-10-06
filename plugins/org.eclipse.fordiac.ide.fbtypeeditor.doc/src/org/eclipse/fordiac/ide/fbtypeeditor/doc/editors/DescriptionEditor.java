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
 *   Alois Zoitl, Lukas Wais
 *                - initial API and implementation and/or initial documentation
 *   Lukas Wais   - implemented base64 image inserting
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.doc.editors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.fordiac.ide.model.ui.editors.LibraryElementProvider;
import org.eclipse.fordiac.ide.typeeditor.ITypeEditorPage;
import org.eclipse.fordiac.ide.ui.imageprovider.FordiacImage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class DescriptionEditor extends EditorPart implements ITypeEditorPage {

	private Browser browser;

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// nothing to be done
	}

	@Override
	public void doSaveAs() {
		// nothing to be done
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		setInput(input);
		setSite(site);
		setPartName("Description"); //$NON-NLS-1$
		setTitleImage(FordiacImage.ICON_DOCUMENTATION_EDITOR.getImage());
	}

	@Override
	public boolean isDirty() {
		return LibraryElementProvider.INSTANCE.canSaveLibraryElement(getEditorInput());
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(final Composite parent) {
		browser = new Browser(parent, SWT.NONE);
		browser.setText(getType().getDocumentation());
	}

	@Override
	public void setFocus() {
		if (browser != null && !browser.isDisposed()) {
			browser.setFocus();
		}
	}

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		// nothing to be done
	}

	@Override
	public void gotoMarker(final IMarker marker) {
		// For now we don't handle markers in this editor
	}

	@Override
	public boolean isMarkerTarget(final IMarker marker) {
		// For now we don't handle markers in this editor
		return false;
	}

	@Override
	public boolean outlineSelectionChanged(final Object selectedElement) {
		return false;
	}

	@Override
	public void setInput(final IEditorInput input) {
		super.setInputWithNotify(input);
	}

	@Override
	public void reloadType() {
		if (browser != null && !browser.isDisposed()) {
			browser.setText(getType().getDocumentation());
		}
	}

	@Override
	public Object getSelectableObject() {
		return null;
	}

}
