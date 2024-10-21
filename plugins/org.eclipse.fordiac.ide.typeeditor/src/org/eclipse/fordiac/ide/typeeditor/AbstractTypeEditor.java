/*******************************************************************************
 * Copyright (c) 2008, 2024 Profactor GmbH, TU Wien ACIN, fortiss GmbH,
 * 							Johannes Kepler University, Linz,
 * 							Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger
 *        - initial API and implementation and/or initial documentation
 *   Peter Gsellmann - incorporating simple fb
 *   Daniel Lindhuber, Bianca Wiesmayr - cleanup
 *   Patrick Aigner  - change dialog integration
 *   Alois Zoitl     - extracted and generalized from FBTypeEditor
 *******************************************************************************/
package org.eclipse.fordiac.ide.typeeditor;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Objects;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.application.editors.FBNetworkEditor;
import org.eclipse.fordiac.ide.gef.annotation.FordiacMarkerGraphicalAnnotationModel;
import org.eclipse.fordiac.ide.gef.annotation.GraphicalAnnotationModel;
import org.eclipse.fordiac.ide.gef.validation.ValidationJob;
import org.eclipse.fordiac.ide.model.edit.ITypeEntryEditor;
import org.eclipse.fordiac.ide.model.edit.TypeEntryAdapter;
import org.eclipse.fordiac.ide.model.libraryElement.Algorithm;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.Method;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.model.typelibrary.TypeEntry;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibraryManager;
import org.eclipse.fordiac.ide.typeeditor.internal.TypeEditorPageFactory;
import org.eclipse.fordiac.ide.ui.FordiacLogHelper;
import org.eclipse.fordiac.ide.ui.editors.AbstractCloseAbleFormEditor;
import org.eclipse.fordiac.ide.ui.editors.EditorUtils;
import org.eclipse.fordiac.ide.ui.widget.SelectionTabbedPropertySheetPage;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.xtext.ui.editor.XtextEditor;

public abstract class AbstractTypeEditor extends AbstractCloseAbleFormEditor implements CommandStackEventListener,
		ITabbedPropertySheetPageContributor, ITypeEntryEditor, ISelectionListener {

	private static TypeEditorPageFactory typeEditorPageFactory = new TypeEditorPageFactory();

	private final CommandStack commandStack = new CommandStack();
	private Collection<ITypeEditorPage> editorPages;
	private final TypeEntryAdapter adapter = new TypeEntryAdapter(this);
	private GraphicalAnnotationModel annotationModel;
	private ValidationJob validationJob;

	@Override
	protected void addPages() {
		editorPages = typeEditorPageFactory.getEditors(getType());
		final TypeEditorInput ei = getEditorInput();
		for (final ITypeEditorPage typeEditorPage : editorPages) {
			try {
				// set command stack has to be done before the page is added
				typeEditorPage.setCommonCommandStack(getCommandStack());
				final int index = addPage(typeEditorPage, ei);
				setPageText(index, typeEditorPage.getTitle());
				setPageImage(index, typeEditorPage.getTitleImage());
			} catch (final PartInitException e) {
				FordiacLogHelper.logError(e.getMessage(), e);
			}
		}
	}

	private TypeEditorInput checkEditorInput(final IEditorInput editorInput) {
		if (editorInput instanceof final TypeEditorInput typeEI) {
			return typeEI;
		}

		if (editorInput instanceof final IFileEditorInput fileEI) {
			final TypeEntry typeEntry = TypeLibraryManager.INSTANCE.getTypeEntryForFile(fileEI.getFile());
			final LibraryElement type = (typeEntry != null) ? typeEntry.getTypeEditable() : null;
			// FIXME replace with EcoreUtil.copy(typeEntry.getType()) when type editable is
			// removed
			return new TypeEditorInput(type, typeEntry);
		}

		return null;
	}

	@Override
	public void createPartControl(final Composite parent) {
		if (getType() != null) {
			super.createPartControl(parent);
		} else {
			showLoadErrorMessage(parent);
		}
	}

	@Override
	protected IEditorSite createSite(final IEditorPart editor) {
		return new TypeMultiPageEditorSite(this, editor);
	}

	@Override
	public void dispose() {
		final TypeEntry typeEntry = getTypeEntry();
		if ((typeEntry != null) && typeEntry.eAdapters().contains(adapter)) {
			typeEntry.eAdapters().remove(adapter);
		}
		if (validationJob != null) {
			validationJob.dispose();
		}
		if (annotationModel != null) {
			annotationModel.dispose();
		}

		// get these values here before calling super dispose
		final boolean dirty = isDirty();

		if (null != getSite()) {
			getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
		}

		super.dispose();

		if (dirty && typeEntry != null) {
			// purge editable type from typelib after super.dispose() so that no notifiers
			// will be called
			typeEntry.setTypeEditable(null);
		}

		getCommandStack().removeCommandStackEventListener(this);
	}

	public CommandStack getCommandStack() {
		return commandStack;
	}

	@Override
	public <T> T getAdapter(final Class<T> adapter) {
		if (adapter == LibraryElement.class) {
			return adapter.cast(getType());
		}
		if (adapter == CommandStack.class) {
			return adapter.cast(getCommandStack());
		}
		if (adapter == IPropertySheetPage.class) {
			return adapter.cast(new SelectionTabbedPropertySheetPage(this));
		}
		if (adapter == IGotoMarker.class) {
			return adapter.cast(this);
		}
		if (adapter == GraphicalAnnotationModel.class) {
			return adapter.cast(annotationModel);
		}

		if (isEditorActive()) {
			// we should only call super if the editor is active otherwise we may get
			// disposed errors
			T result = super.getAdapter(adapter);
			if (result == null && shouldCheckAllEditors(adapter)) {
				result = getEditorPages().stream().map(innerEditor -> Adapters.adapt(innerEditor, adapter))
						.filter(Objects::nonNull).findFirst().orElse(null);
			}
			return result;
		}
		return null;
	}

	@Override
	public TypeEditorInput getEditorInput() {
		return (TypeEditorInput) super.getEditorInput();
	}

	protected Collection<ITypeEditorPage> getEditorPages() {
		return editorPages;
	}

	@Override
	public String getTitleToolTip() {
		final String tooltip = (getTypeEntry() != null) ? getTypeEntry().getFullTypeName() + "\n" : ""; //$NON-NLS-1$ //$NON-NLS-2$
		return tooltip + super.getTitleToolTip();
	}

	protected LibraryElement getType() {
		final TypeEditorInput ei = getEditorInput();
		return (ei != null) ? ei.getContent() : null;
	}

	protected TypeEntry getTypeEntry() {
		final TypeEditorInput ei = getEditorInput();
		return (ei != null) ? ei.getTypeEntry() : null;
	}

	public void handleContentOutlineSelection(final ISelection selection) {
		if ((selection instanceof final IStructuredSelection sel) && !selection.isEmpty()) {
			final Object selectedElement = sel.getFirstElement();
			int i = 0;
			for (final ITypeEditorPage editorPart : getEditorPages()) {
				if (editorPart.outlineSelectionChanged(selectedElement)) {
					if (getActivePage() != i) {
						setActivePage(i);
					}
					break;
				}
				i++;
			}
		}
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput editorInput) throws PartInitException {
		final TypeEditorInput typeEditorInput = checkEditorInput(editorInput);

		if (isValidTypeEditorInput(typeEditorInput)) {
			typeEditorInput.getTypeEntry().eAdapters().add(adapter);
			annotationModel = new FordiacMarkerGraphicalAnnotationModel(typeEditorInput.getTypeEntry().getFile());
			validationJob = new ValidationJob(getPartName(), getCommandStack(), annotationModel);
		}
		getCommandStack().addCommandStackEventListener(this);
		super.init(site, typeEditorInput);
		site.getWorkbenchWindow().getSelectionService().addSelectionListener(this);
	}

	private boolean isEditorActive() {
		final int index = getActivePage();
		return index != -1 && !((CTabFolder) getContainer()).getItem(index).isDisposed();
	}

	@SuppressWarnings("static-method") // allow subclasses to perform additional checks
	private boolean isValidTypeEditorInput(final TypeEditorInput typeEditorInput) {
		return typeEditorInput != null && typeEditorInput.getContent() != null
				&& typeEditorInput.getTypeEntry() != null;
	}

	@Override
	protected void pageChange(final int newPageIndex) {
		super.pageChange(newPageIndex);
		getSite().getPage().getNavigationHistory().markLocation(this);
	}

	@Override
	public void reloadType() {
		final LibraryElement newFBType = getTypeEntry().getTypeEditable();
		final LibraryElement curType = getType();
		if (newFBType != curType) {
			if ((curType != null) && getTypeEntry().eAdapters().contains(adapter)) {
				getTypeEntry().eAdapters().remove(adapter);
			}
			getEditorInput().setType(newFBType);
			getEditorPages().stream().forEach(ITypeEditorPage::reloadType);
			final IEditorPart activeEditor = getActiveEditor();
			if (activeEditor instanceof final ITypeEditorPage editorPage) {
				Display.getDefault().asyncExec(() -> EditorUtils.refreshPropertySheetWithSelection(this,
						activeEditor.getAdapter(GraphicalViewer.class), editorPage.getSelectableObject()));
			}
			getCommandStack().flush();
			getTypeEntry().eAdapters().add(adapter);
			setPartName(getTypeEntry().getTypeName());
		}
	}

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		if (this.equals(getSite().getPage().getActiveEditor()) && !(part instanceof PropertySheet)) {
			if (selection instanceof final StructuredSelection structSel
					&& structSel.getFirstElement() instanceof final URI uri) {
				final EObject selectedElement = getType().eResource().getEObject(uri.fragment());
				if (selectedElement instanceof FBNetworkElement || selectedElement instanceof Algorithm
						|| selectedElement instanceof Method || selectedElement instanceof VarDeclaration) {
					handleContentOutlineSelection(new StructuredSelection(selectedElement));
				}
			} else {
				handleContentOutlineSelection(selection);
			}
		}
	}

	@Override
	public void setFocus() {
		super.setFocus();
		adapter.checkFileReload();
	}

	@Override
	public void setInput(final IEditorInput input) {
		if (input != null) {
			setPartName(TypeEntry.getTypeNameFromFileName(input.getName()));
		}

		if (input instanceof FileEditorInput) {
			// we have a new file
			if (getEditorPages() != null) {
				getEditorPages().stream().filter(IReusableEditor.class::isInstance).map(IReusableEditor.class::cast)
						.forEach(e -> e.setInput(getEditorInput()));
			}
			setInputWithNotify(getEditorInput());
		} else {
			setInputWithNotify(input);
		}
	}

	public void showLoadErrorMessage(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(composite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(composite);

		final Image image = Display.getDefault().getSystemImage(SWT.ICON_ERROR);
		final Label imageLabel = new Label(composite, SWT.NULL);
		image.setBackground(imageLabel.getBackground());
		imageLabel.setImage(image);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BEGINNING).applyTo(imageLabel);

		final Label messageLabel = new Label(composite, SWT.NONE);
		messageLabel.setText(MessageFormat.format(Messages.TypeEditor_CouldNotLoadType, getEditorInput().getName()));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(messageLabel);
	}

	private static <T> boolean shouldCheckAllEditors(final Class<T> adapter) {
		return (adapter == ITextEditor.class) || (adapter == XtextEditor.class) || (adapter == FBNetworkEditor.class);
	}

	@Override
	public void stackChanged(final CommandStackEvent event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

}
