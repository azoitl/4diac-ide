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
 *   Alois Zoitl - implemented Handler for Goto Pin Below command/shortcut
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.handlers;

import static org.eclipse.fordiac.ide.model.ui.editors.HandlerHelper.getCommandStack;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.fordiac.ide.application.editparts.AbstractContainerContentEditPart;
import org.eclipse.fordiac.ide.application.editparts.IContainerEditPart;
import org.eclipse.fordiac.ide.application.editparts.UntypedSubAppInterfaceElementEditPart;
import org.eclipse.fordiac.ide.application.policies.ContainerContentLayoutPolicy;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

public class TrimHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IContainerEditPart containerEditPart = getContainerEditPart(HandlerUtil.getCurrentSelection(event));

		final IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if ((containerEditPart != null) && (editor != null)) {
			final GraphicalEditPart contentEP = containerEditPart.getContentEP();

			if (contentEP != null) {
				final Rectangle contentContainerBounds = ContainerContentLayoutPolicy.getContainerAreaBounds(contentEP);
				final Rectangle groupContentBounds = containerEditPart.getMinContentBounds();
				final int adjustedCommentWidth = adjustCommentWidth(containerEditPart.getCommentWidth(),
						containerEditPart.getChildren());
				groupContentBounds.setWidth(Math.max(groupContentBounds.width, adjustedCommentWidth));
				final Command cmd = ContainerContentLayoutPolicy.createChangeBoundsCommand(
						(FBNetworkElement) containerEditPart.getModel(), contentContainerBounds, groupContentBounds);
				getCommandStack(editor).execute(cmd);
			}
		}
		return Status.OK_STATUS;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		final ISelection selection = (ISelection) HandlerUtil.getVariable(evaluationContext,
				ISources.ACTIVE_CURRENT_SELECTION_NAME);
		setBaseEnabled(getContainerEditPart(selection) != null);
	}

	private static IContainerEditPart getContainerEditPart(final ISelection selection) {
		if (selection instanceof final IStructuredSelection structSel) {
			if (structSel.size() == 1) {
				final Object firstElement = structSel.getFirstElement();
				if (firstElement instanceof final IContainerEditPart containerEP) {
					if (!(containerEP.getModel() instanceof SubApp)) {
						return containerEP;
					}
					// if we have a subapp only accept if it is expanded
					if (((SubApp) containerEP.getModel()).isUnfolded()) {
						return containerEP;
					}
				}
				if (firstElement instanceof AbstractContainerContentEditPart) {
					return (IContainerEditPart) ((EditPart) firstElement).getParent();
				}
			}
		}
		return null;
	}

	private static int adjustCommentWidth(final int commentWidth, final List<? extends EditPart> children) {
		final int widestInput = children.stream().filter(Objects::nonNull)
				.filter(UntypedSubAppInterfaceElementEditPart.class::isInstance)
				.map(UntypedSubAppInterfaceElementEditPart.class::cast).filter(InterfaceEditPart::isInput)
				.map(GraphicalEditPart.class::cast).mapToInt(e -> e.getFigure().getBounds().width()).max().orElse(0);
		final int widestOutput = children.stream().filter(Objects::nonNull)
				.filter(UntypedSubAppInterfaceElementEditPart.class::isInstance)
				.map(UntypedSubAppInterfaceElementEditPart.class::cast)
				.filter(Predicate.not(InterfaceEditPart::isInput)).map(GraphicalEditPart.class::cast)
				.mapToInt(e -> e.getFigure().getBounds().width()).max().orElse(0);
		return commentWidth - widestInput - widestOutput;
	}

}
