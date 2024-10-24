/*******************************************************************************
 * Copyright (c) 2016, 2024 fortiss GmbH, Johannes Kepler University Linz,
 *                          Primetals Technologies Germany GmbH,
 *                          Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *   Daniel Lindhuber, Bianca Wiesmayr
 *               - connections across subapp borders
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.policies;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.fordiac.ide.application.commands.BorderCrossingReconnectCommand;
import org.eclipse.fordiac.ide.application.commands.CreateSubAppCrossingConnectionsCommand;
import org.eclipse.fordiac.ide.gef.FixedAnchor;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.model.commands.change.AbstractReconnectConnectionCommand;
import org.eclipse.fordiac.ide.model.commands.create.AbstractConnectionCreateCommand;
import org.eclipse.fordiac.ide.model.libraryElement.CompositeFBType;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

public abstract class InterfaceElementEditPolicy extends GraphicalNodeEditPolicy {

	@Override
	public InterfaceEditPart getHost() {
		return (InterfaceEditPart) super.getHost();
	}

	@Override
	protected final Command getConnectionCreateCommand(final CreateConnectionRequest request) {
		final AbstractConnectionCreateCommand command = createConnectionCreateCommand();
		if (command != null) {
			command.setSource(getHost().getModel());
		}
		request.setStartCommand(command);
		return command;
	}

	protected abstract AbstractConnectionCreateCommand createConnectionCreateCommand();

	@Override
	protected Command getConnectionCompleteCommand(final CreateConnectionRequest request) {
		final AbstractConnectionCreateCommand command = (AbstractConnectionCreateCommand) request.getStartCommand();
		command.setDestination(getHost().getModel());

		final FBNetwork newParent = checkConnectionParent(command.getSource(), command.getDestination(),
				command.getParent());
		if (newParent != null) {
			command.setParent(newParent);
			return command;
		}
		// if we are here it is not a direct connection try border crossing command
		return CreateSubAppCrossingConnectionsCommand.createProcessBorderCrossingConnection(command.getSource(),
				command.getDestination());
	}

	@Override
	protected Command getReconnectTargetCommand(final ReconnectRequest request) {
		return createReconnectCommand(request, false);
	}

	@Override
	protected Command getReconnectSourceCommand(final ReconnectRequest request) {
		return createReconnectCommand(request, true);
	}

	private Command createReconnectCommand(final ReconnectRequest request, final boolean isSourceReconnect) {
		final var conn = (Connection) request.getConnectionEditPart().getModel();
		final var sourcePin = conn.getSource();
		final var targetPin = conn.getDestination();
		final var newPin = getHost().getModel();

		// border crossing source reconnect
		if (isSourceReconnect && isBorderCrossing(newPin, targetPin, conn.getFBNetwork())) {
			return new BorderCrossingReconnectCommand(newPin, targetPin, conn, true);
		}

		// border crossing destination reconnect
		if (!isSourceReconnect && isBorderCrossing(newPin, sourcePin, conn.getFBNetwork())) {
			return new BorderCrossingReconnectCommand(sourcePin, newPin, conn, false);
		}

		// local reconnect
		final AbstractReconnectConnectionCommand cmd = createReconnectCommand(conn, isSourceReconnect, newPin);
		final FBNetwork newParent = checkConnectionParent(cmd.getNewSource(), cmd.getNewDestination(), cmd.getParent());
		if (newParent != null) {
			cmd.setParent(newParent);
			return cmd;
		}
		return null;
	}

	private static boolean isBorderCrossing(final IInterfaceElement srcPin, final IInterfaceElement destPin,
			final FBNetwork fbNetwork) {
		return (null == checkConnectionParent(srcPin, destPin, fbNetwork));
	}

	protected FBNetwork getParentNetwork() {
		return getHost().getRoot().getAdapter(FBNetwork.class);
	}

	protected abstract AbstractReconnectConnectionCommand createReconnectCommand(final Connection connection,
			final boolean isSourceReconnect, final IInterfaceElement newTarget);

	private static FBNetwork checkConnectionParent(final IInterfaceElement source, final IInterfaceElement destination,
			final FBNetwork parent) {
		final FBNetwork srcParent = getFBNetwork4Pin(source);
		final FBNetwork dstParent = getFBNetwork4Pin(destination);

		if ((srcParent != null) && (dstParent != null)) {
			if (srcParent == dstParent) {
				return checkParentInSameNetwork(source, destination, parent, srcParent);
			}
			if ((source.getFBNetworkElement() instanceof final SubApp subapp)
					&& (subapp.getSubAppNetwork() == dstParent)) {
				// we have a connection from a subapp pin to an internal FB
				return dstParent;
			}
			if ((destination.getFBNetworkElement() instanceof final SubApp subapp)
					&& (subapp.getSubAppNetwork() == srcParent)) {
				// we have a connection from a subapp pin to an internal FB
				return srcParent;
			}
		}
		return null;
	}

	private static FBNetwork checkParentInSameNetwork(final IInterfaceElement src, final IInterfaceElement dest,
			final FBNetwork parent, final FBNetwork srcParent) {
		if (src.getFBNetworkElement() instanceof final SubApp srcSubApp
				&& dest.getFBNetworkElement() instanceof final SubApp destSubApp && srcSubApp == destSubApp
				&& !srcSubApp.isTyped() && srcSubApp.getSubAppNetwork() != parent) {
			// we have a connection request for a pin to pin untyped expanded subapp
			// connection
			if (src.isIsInput()) {
				// for input to input connections use the inner network
				return srcSubApp.getSubAppNetwork();
			}
			// for output to input connections use the outer network
			return srcParent;
		}

		if (srcParent == parent) {
			return parent;
		}
		if ((src.getFBNetworkElement() instanceof final SubApp subApp) && (subApp.getSubAppNetwork() == parent)) {
			// we have a subapp pin to pin connection inside of a subapp
			return parent;
		}
		// we have a connection in an unfolded subapp
		return srcParent;
	}

	private static FBNetwork getFBNetwork4Pin(final IInterfaceElement pin) {
		if (pin != null) {
			if (pin.getFBNetworkElement() != null) {
				return pin.getFBNetworkElement().getFbNetwork();
			}
			if (pin.eContainer().eContainer() instanceof final CompositeFBType cfbType) {
				return cfbType.getFBNetwork();
			}
		}
		return null;
	}

	@Override
	protected ConnectionAnchor getSourceConnectionAnchor(final CreateConnectionRequest request) {
		final IInterfaceElement ie = getHost().getModel();
		if (ie.isIsInput() && ie.getFBNetworkElement() instanceof final SubApp subapp && subapp.isUnfolded()) {
			// we are unfolded and this is an internal connection
			return new FixedAnchor(getHostFigure(), false);
		}
		return super.getSourceConnectionAnchor(request);
	}
}
