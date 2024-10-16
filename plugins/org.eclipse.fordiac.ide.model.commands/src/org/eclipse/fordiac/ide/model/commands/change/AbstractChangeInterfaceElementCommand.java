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
package org.eclipse.fordiac.ide.model.commands.change;

import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.model.commands.ScopedCommand;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.gef.commands.Command;

public abstract class AbstractChangeInterfaceElementCommand extends Command implements ScopedCommand {
	private final IInterfaceElement interfaceElement;

	protected AbstractChangeInterfaceElementCommand(final IInterfaceElement interfaceElement) {
		this.interfaceElement = Objects.requireNonNull(interfaceElement);
	}

	@Override
	public final void execute() {
		doExecute();
	}

	@Override
	public final void undo() {
		doUndo();
	}

	@Override
	public final void redo() {
		doRedo();
	}

	protected abstract void doExecute();

	protected abstract void doRedo();

	protected abstract void doUndo();

	public IInterfaceElement getInterfaceElement() {
		return interfaceElement;
	}

	protected boolean isSubAppPinAndConnected() {
		return interfaceElement.getFBNetworkElement() instanceof SubApp
				&& (!interfaceElement.getInputConnections().isEmpty()
						|| !interfaceElement.getOutputConnections().isEmpty());
	}

	@Override
	public Set<EObject> getAffectedObjects() {
		return Set.of(interfaceElement);
	}
}
