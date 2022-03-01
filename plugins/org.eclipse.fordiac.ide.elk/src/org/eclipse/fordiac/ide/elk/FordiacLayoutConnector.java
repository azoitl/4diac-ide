/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University Linz
 * 				 2020 Primetals Technologies Germany GmbH
 * 				 2021, 2022 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Daniel Lindhuber, Bianca Wiesmayr, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.elk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.NodeLabelPlacement;
import org.eclipse.elk.core.service.IDiagramLayoutConnector;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkBendPoint;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkGraphElement;
import org.eclipse.elk.graph.ElkLabel;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.properties.IProperty;
import org.eclipse.elk.graph.properties.IPropertyHolder;
import org.eclipse.elk.graph.properties.Property;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.eclipse.fordiac.ide.application.editparts.AbstractFBNElementEditPart;
import org.eclipse.fordiac.ide.application.editparts.ConnectionEditPart;
import org.eclipse.fordiac.ide.application.editparts.EditorWithInterfaceEditPart;
import org.eclipse.fordiac.ide.application.editparts.GroupContentEditPart;
import org.eclipse.fordiac.ide.application.editparts.GroupEditPart;
import org.eclipse.fordiac.ide.application.editparts.SubAppForFBNetworkEditPart;
import org.eclipse.fordiac.ide.application.editparts.UnfoldedSubappContentEditPart;
import org.eclipse.fordiac.ide.elk.commands.LayoutCommand;
import org.eclipse.fordiac.ide.gef.editparts.AbstractFBNetworkEditPart;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.gef.editparts.ValueEditPart;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.Group;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.InterfaceList;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.Position;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.IWorkbenchPart;

public class FordiacLayoutConnector implements IDiagramLayoutConnector {

	/* used for building the elk graph */
	private static final IProperty<AbstractFBNetworkEditPart> NETWORK_EDIT_PART = new Property<>("gef.networkEditPart"); //$NON-NLS-1$
	private static final IProperty<CommandStack> COMMAND_STACK = new Property<>("gef.commandStack"); //$NON-NLS-1$
	private static final IProperty<List<ConnectionEditPart>> CONNECTIONS = new Property<>("gef.connections"); //$NON-NLS-1$
	private static final IProperty<List<ConnectionEditPart>> HIERARCHY_CROSSING_CONNECTIONS = new Property<>("gef.hierarchyCrossingConnections"); //$NON-NLS-1$
	private static final IProperty<Map<ConnectionEditPart, List<ElkEdge>>> HIERARCHY_CROSSING_CONNECTIONS_MAPPING = new Property<>("gef.hierarchyCrossingConnectionsMapping"); //$NON-NLS-1$
	private static final IProperty<Map<ElkEdge, ConnectionEditPart>> HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING = new Property<>("gef.hierarchyCrossingConnectionsReverseMapping"); //$NON-NLS-1$
	private static final IProperty<Map<GraphicalEditPart, ElkGraphElement>> REVERSE_MAPPING = new Property<>("gef.reverseMapping"); //$NON-NLS-1$
	// allows us to group all connections from one interface to one dummy port
	private static final IProperty<Map<ElkPort, ElkPort>> DUMMY_PORTS = new Property<>("gef.dummyPorts"); //$NON-NLS-1$
	// will contain all the data for the layout command
	private static final IProperty<FordiacLayoutData> LAYOUT_DATA = new Property<>("gef.layoutData"); //$NON-NLS-1$

	private static final PrecisionPoint START_POINT = new PrecisionPoint();
	private static final PrecisionPoint END_POINT = new PrecisionPoint();

	@Override
	public LayoutMapping buildLayoutGraph(final IWorkbenchPart workbenchPart, final Object diagramPart) {
		final LayoutMapping mapping = initMapping(workbenchPart);
		findRootEditPart(mapping, workbenchPart);

		if (mapping.getProperty(NETWORK_EDIT_PART) != null) {
			createGraphRoot(mapping);
			buildGraphRecursively(mapping, mapping.getLayoutGraph(), (GraphicalEditPart) mapping.getParentElement());
			processConnections(mapping);
			processHierarchyCrossingConnections(mapping);
		}

		return mapping;
	}

	private static LayoutMapping initMapping(final IWorkbenchPart workbenchPart) {
		final LayoutMapping mapping = new LayoutMapping(workbenchPart);
		mapping.setProperty(COMMAND_STACK, workbenchPart.getAdapter(CommandStack.class));
		mapping.setProperty(CONNECTIONS, new ArrayList<>());
		mapping.setProperty(HIERARCHY_CROSSING_CONNECTIONS, new ArrayList<>());
		mapping.setProperty(HIERARCHY_CROSSING_CONNECTIONS_MAPPING, new HashMap<>());
		mapping.setProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING, new HashMap<>());
		mapping.setProperty(REVERSE_MAPPING, new HashMap<>());
		mapping.setProperty(DUMMY_PORTS, new HashMap<>());
		mapping.setProperty(LAYOUT_DATA, new FordiacLayoutData());
		return mapping;
	}

	private static void findRootEditPart(final LayoutMapping mapping, final IWorkbenchPart workbenchPart) {
		final Object ep = workbenchPart.getAdapter(GraphicalViewer.class)
							.getRootEditPart()
							.getChildren()
							.get(0);
		mapping.setProperty(NETWORK_EDIT_PART, (AbstractFBNetworkEditPart) ep);
	}

	private static void createGraphRoot(final LayoutMapping mapping) {
		final AbstractFBNetworkEditPart networkEditPart = mapping.getProperty(NETWORK_EDIT_PART);
		final ElkNode graph = FordiacLayoutFactory.createFordiacLayoutGraph();
		setGraphBounds(graph, networkEditPart);
		mapping.setLayoutGraph(graph);
		mapping.setParentElement(networkEditPart);
		mapping.getGraphMap().put(graph, networkEditPart);
		mapping.getProperty(REVERSE_MAPPING).put(networkEditPart, graph);
	}

	private static void setGraphBounds(final ElkNode graph, final AbstractFBNetworkEditPart networkEditPart) {
		Rectangle bounds = null;
		if (networkEditPart instanceof EditorWithInterfaceEditPart) {
			@SuppressWarnings("unchecked")
			final Object figure = ((IFigure) networkEditPart.getFigure().getChildren().get(0)).getChildren()
					.stream()
					.filter(FreeformLayer.class::isInstance)
					.findFirst()
					.orElse(null);
			if (figure instanceof IFigure) {
				bounds = ((IFigure) figure).getBounds();
			}
		} else {
			bounds = networkEditPart.getFigure().getBounds();
		}

		if (bounds != null) {
			graph.setLocation(bounds.preciseX(), bounds.preciseY());
			graph.setDimensions(bounds.preciseWidth(), bounds.preciseHeight());
		}
	}

	@SuppressWarnings("unchecked")
	private static void buildGraphRecursively(final LayoutMapping mapping, final ElkNode parentLayoutNode, final GraphicalEditPart currentEditPart) {
		for (final Object child : currentEditPart.getChildren()) {
			// skip unfolded subapps
			if (child instanceof UnfoldedSubappContentEditPart) {
				continue;
			}
			if (child instanceof GroupEditPart) {
				final GroupEditPart group = (GroupEditPart) child;
				final ElkNode node = createGroupNode(mapping, group, parentLayoutNode);
				buildGraphRecursively(mapping, node, group);
			}
			// forward the call
			if (child instanceof GroupContentEditPart) {
				buildGraphRecursively(mapping, parentLayoutNode, (GraphicalEditPart) child);
			}
			if (child instanceof AbstractFBNElementEditPart) {
				final AbstractFBNElementEditPart childEditPart = (AbstractFBNElementEditPart) child;
				final ElkNode node = createNode(mapping, childEditPart, parentLayoutNode);
				buildGraphRecursively(mapping, node, childEditPart);
			}
			if (child instanceof InterfaceEditPart) {
				final InterfaceEditPart ep = ((InterfaceEditPart) child);
				if (isUnfoldedSubAppInterface(ep) && !ep.isInput()) {
					// target connections would be inside the subapp and do not need to be saved
					continue;
				}
				// since we iterate over every interface its enough to only save target connections
				ep.getTargetConnections().forEach(conn -> saveConnection(mapping, conn));
				if (ep.getParent() instanceof EditorWithInterfaceEditPart) {
					/* add all editor interfaces to the elk graph to ensure the right order in the sidebar */
					getPort(new Point(0, 0), ep, mapping); /* point is irrelevant since the interface element gets moved along the graph border (sidebar) */
				}
			}
			if (child instanceof ValueEditPart) {
				createValueLabels(mapping, (ValueEditPart) child);
			}
		}
	}
	
	private static boolean isUnfoldedSubAppInterface(final InterfaceEditPart ep) {
		if (ep.getParent() instanceof SubAppForFBNetworkEditPart) {
			final SubApp model = ((SubAppForFBNetworkEditPart) ep.getParent()).getModel();
			return model.isUnfolded();
		}
		return false;
	}

	private static void saveConnection(final LayoutMapping mapping, final Object conn) {
		if (conn instanceof ConnectionEditPart && !mapping.getProperty(CONNECTIONS).contains(conn)) {
			final ConnectionEditPart connEditPart = (ConnectionEditPart) conn;
			final Object sourceContainer = connEditPart.getSource().getParent().getParent();
			final Object targetContainer = connEditPart.getTarget().getParent().getParent();
			// save connections for later
			if ((sourceContainer instanceof GroupContentEditPart || targetContainer instanceof GroupContentEditPart)
					&& sourceContainer != targetContainer) {
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS).add(connEditPart);	
			} else {
				mapping.getProperty(CONNECTIONS).add(connEditPart);		
			}
		}
	}
	
	private static ElkNode createGroupNode(final LayoutMapping mapping, final GroupEditPart editPart, final ElkNode parent) {
		final ElkNode node = FordiacLayoutFactory.createFordiacLayoutNode(editPart, parent);
		
		final Rectangle bounds = editPart.getFigure().getBounds();
		node.setLocation(bounds.x, bounds.y);
		node.setDimensions(bounds.preciseWidth(), bounds.preciseHeight());
	
		final ElkLabel label = ElkGraphUtil.createLabel(editPart.getModel().getName(), node);
		final Rectangle commentBounds = editPart.getCommentBounds();
		if (commentBounds != null) {
			final int BORDER_THICKNESS = 2;
			label.setDimensions(commentBounds.preciseWidth() + BORDER_THICKNESS, commentBounds.preciseHeight() + BORDER_THICKNESS);
		}
		node.setProperty(CoreOptions.NODE_LABELS_PLACEMENT, NodeLabelPlacement.insideTopCenter());
		label.setProperty(CoreOptions.NODE_LABELS_PLACEMENT, NodeLabelPlacement.insideTopCenter());

		mapping.getGraphMap().put(node, editPart);
		mapping.getProperty(REVERSE_MAPPING).put(editPart, node);

		return node;
	}

	private static ElkNode createNode(final LayoutMapping mapping, final AbstractFBNElementEditPart editPart, final ElkNode parent) {
		final ElkNode node = FordiacLayoutFactory.createFordiacLayoutNode(editPart, parent);
		final Rectangle bounds = editPart.getFigure().getFBBounds();
		node.setLocation(bounds.x, bounds.y);
		node.setDimensions(bounds.preciseWidth(), bounds.preciseHeight());
		final ElkLabel label = ElkGraphUtil.createLabel(editPart.getModel().getName(), node);
		final Rectangle labelBounds = editPart.getFigure().getLabelBounds();
		label.setDimensions(labelBounds.width(), labelBounds.height());

		mapping.getGraphMap().put(node, editPart);
		mapping.getProperty(REVERSE_MAPPING).put(editPart, node);

		return node;
	}

	private static void processConnections(final LayoutMapping mapping) {
		for (final ConnectionEditPart conn : mapping.getProperty(CONNECTIONS)) {
			final org.eclipse.draw2d.Connection connFig = conn.getFigure();

			START_POINT.setLocation(connFig.getSourceAnchor().getLocation(connFig.getSourceAnchor().getReferencePoint()));
			END_POINT.setLocation(connFig.getTargetAnchor().getLocation(connFig.getTargetAnchor().getReferencePoint()));

			connFig.translateToRelative(START_POINT);
			connFig.translateToRelative(END_POINT);

			final ElkPort sourcePort = getPort(START_POINT, (InterfaceEditPart) conn.getSource(), mapping);
			final ElkPort destinationPort = getPort(END_POINT, (InterfaceEditPart) conn.getTarget(), mapping);

			final ElkEdge edge = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), sourcePort, destinationPort);
			mapping.getGraphMap().put(edge, conn);
			mapping.getProperty(REVERSE_MAPPING).put(conn, edge);
		}
	}
	
	private static void processHierarchyCrossingConnections(final LayoutMapping mapping) {
		/*
		 * The idea for hierarchy crossing connections (in the context of groups) is to split
		 * the connection in two and connect them with a dummy port on the group node.
		 */
		for (final ConnectionEditPart conn : mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS)) {
			final Object sourceContainer = conn.getSource().getParent().getParent();
			final Object targetContainer = conn.getTarget().getParent().getParent();
			
			final org.eclipse.draw2d.Connection connFig = conn.getFigure();
			START_POINT.setLocation(connFig.getSourceAnchor().getLocation(connFig.getSourceAnchor().getReferencePoint()));
			END_POINT.setLocation(connFig.getTargetAnchor().getLocation(connFig.getTargetAnchor().getReferencePoint()));
			connFig.translateToRelative(START_POINT);
			connFig.translateToRelative(END_POINT);
			
			final boolean incoming = targetContainer instanceof GroupContentEditPart;
			final boolean outgoing = sourceContainer instanceof GroupContentEditPart;
			
			// from group to group
			if (incoming && outgoing) {
				final EditPart sourceGroup = ((EditPart)sourceContainer).getParent();
				final EditPart targetGroup = ((EditPart)targetContainer).getParent();
				
				final ElkGraphElement sourceGroupNode = mapping.getProperty(REVERSE_MAPPING).get(sourceGroup);
				final ElkGraphElement targetGroupNode = mapping.getProperty(REVERSE_MAPPING).get(targetGroup);
				
				final ElkPort sourcePort = getPort(START_POINT, (InterfaceEditPart) conn.getSource(), mapping);
				final ElkPort targetPort = getPort(END_POINT, (InterfaceEditPart) conn.getTarget(), mapping);
				
				ElkPort sourceGroupDummyPort = mapping.getProperty(DUMMY_PORTS).get(sourcePort);
				ElkPort targetGroupDummyPort = mapping.getProperty(DUMMY_PORTS).get(targetPort);
				
				if (sourceGroupDummyPort == null) {
					// not yet created
					sourceGroupDummyPort = ElkGraphUtil.createPort((ElkNode) sourceGroupNode);
					mapping.getProperty(DUMMY_PORTS).put(sourcePort, sourceGroupDummyPort);
				}
				if (targetGroupDummyPort == null) {
					// not yet created
					targetGroupDummyPort = ElkGraphUtil.createPort((ElkNode) targetGroupNode);
					mapping.getProperty(DUMMY_PORTS).put(targetPort, targetGroupDummyPort);
				}
				
				final ElkEdge edge1 = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), sourcePort, sourceGroupDummyPort);
				final ElkEdge edge2 = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), sourceGroupDummyPort, targetGroupDummyPort);
				final ElkEdge edge3 = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), targetGroupDummyPort, targetPort);
				
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).put(edge1, conn);
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).put(edge2, conn);
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).put(edge3, conn);
				
				final List<ElkEdge> list = new LinkedList<>();
				list.add(edge1);
				list.add(edge2);
				list.add(edge3);
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_MAPPING).put(conn, list);
			} else if (incoming || outgoing) { // to/from network to/from group
				final EditPart group = incoming ? ((EditPart)targetContainer).getParent() : ((EditPart)sourceContainer).getParent();
				final ElkGraphElement groupNode = mapping.getProperty(REVERSE_MAPPING).get(group);
				
				final ElkPort sourcePort = getPort(START_POINT, (InterfaceEditPart) conn.getSource(), mapping);
				final ElkPort targetPort = getPort(END_POINT, (InterfaceEditPart) conn.getTarget(), mapping);
				
				ElkPort dummyPort = mapping.getProperty(DUMMY_PORTS).get(incoming ? targetPort : sourcePort);
				if (dummyPort == null) {
					// not yet created
					dummyPort = ElkGraphUtil.createPort((ElkNode) groupNode);
					mapping.getProperty(DUMMY_PORTS).put(incoming ? targetPort : sourcePort, dummyPort);
				}
				
				final ElkEdge edge1 = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), sourcePort, dummyPort);
				final ElkEdge edge2 = FordiacLayoutFactory.createFordiacLayoutEdge(conn, mapping.getLayoutGraph(), dummyPort, targetPort);
				
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).put(edge1, conn);
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).put(edge2, conn);
				
				final List<ElkEdge> list = new LinkedList<>();
				list.add(edge1);
				list.add(edge2);
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_MAPPING).put(conn, list);
			}
		}
	}

	private static ElkPort getPort(final Point point, final InterfaceEditPart interfaceEditPart, final LayoutMapping mapping) {
		return (ElkPort) mapping.getProperty(REVERSE_MAPPING).computeIfAbsent(interfaceEditPart, ie -> createPort(point, interfaceEditPart, mapping));
	}

	private static ElkPort createPort(final Point point, final InterfaceEditPart interfaceEditPart, final LayoutMapping mapping) {
		final EditPart parent = interfaceEditPart.getParent();
		final ElkNode parentNode = (ElkNode) mapping.getProperty(REVERSE_MAPPING).get(parent);
		final ElkPort port = FordiacLayoutFactory.createFordiacLayoutPort(interfaceEditPart, parentNode, point);
		mapping.getGraphMap().put(port, interfaceEditPart.getModel());
		return port;
	}

	private static void createValueLabels(final LayoutMapping mapping, final ValueEditPart valueEditPart) {
		final Object iePart = valueEditPart.getViewer().getEditPartRegistry()
				.get(valueEditPart.getModel().getVarDeclaration());
		final Point point = ((InterfaceEditPart) iePart).getFigure().getBounds().getTopLeft();
		final ElkPort port = getPort(point, (InterfaceEditPart) iePart, mapping);
		final ElkLabel label = ElkGraphUtil.createLabel(valueEditPart.getModel().getValue(), port);
		final Rectangle bounds = valueEditPart.getFigure().getBounds();
		label.setLocation(bounds.preciseX() - port.getX() - port.getParent().getX(),
				bounds.preciseY() - port.getY() - port.getParent().getY());
		label.setDimensions(bounds.preciseWidth(), bounds.preciseHeight());
	}

	@Override
	public void applyLayout(final LayoutMapping mapping, final IPropertyHolder settings) {
		final int INSTANCE_COMMENT_OFFSET = 8;
		calculateNodePositionsRecursively(mapping, mapping.getLayoutGraph(), 0, INSTANCE_COMMENT_OFFSET);
		createPinOffsetData(mapping);
		final Command layoutCommand = new LayoutCommand(mapping.getProperty(LAYOUT_DATA));
		mapping.getProperty(COMMAND_STACK).execute(layoutCommand);
	}

	private static void createPinOffsetData(final LayoutMapping mapping) {
		if (!mapping.getLayoutGraph().getPorts().isEmpty()) {
			final InterfaceList interfaceList = (InterfaceList) ((IInterfaceElement) mapping.getGraphMap()
					.get(mapping.getLayoutGraph().getPorts().get(0))).eContainer();

			final List<IInterfaceElement> allIEs = interfaceList.getAllInterfaceElements();

			mapping.getLayoutGraph().getPorts().forEach(port -> {
				final IInterfaceElement pin = (IInterfaceElement) mapping.getGraphMap().get(port);
				final int index = allIEs.indexOf(pin);
				int padding = (int) port.getY();
				if (index > 0 && pin.isIsInput() == allIEs.get(index - 1).isIsInput()) {
					final IInterfaceElement abovePin = allIEs.get(index - 1);
					final ElkPort abovePort = (ElkPort) mapping.getGraphMap().inverse().get(abovePin);
					padding -= (int) abovePort.getY() + port.getHeight(); // the port height represents the edit parts
				}
				/* For the first input var, additional padding has to be added. This results in "ugly" adapter
				 * connections but fixes data connections. The exact reason for this additional offset is not yet
				 * known. */
				if (isFirstInputVar(interfaceList, pin)) {
					padding += 8;
				}
				mapping.getProperty(LAYOUT_DATA).addPin(pin, Integer.valueOf(padding));
			});
		}
	}

	private static boolean isFirstInputVar(final InterfaceList interfaceList, final IInterfaceElement pin) {
		return !interfaceList.getInputVars().isEmpty() && pin.equals(interfaceList.getInputVars().get(0));
	}

	private void calculateNodePositionsRecursively(final LayoutMapping mapping, final ElkNode node, final double parentX, final double parentY) {
		final GraphicalEditPart ep = (GraphicalEditPart) mapping.getGraphMap().get(node);
		final int calculatedX = (int) (node.getX() + parentX);
		final int calculatedY = (int) (node.getY() + parentY);
		// TODO rewrite condition
		if (!(ep instanceof AbstractFBNetworkEditPart 
				&& !(ep instanceof UnfoldedSubappContentEditPart)
				&& !(ep instanceof GroupEditPart))) {
			final Position pos = LibraryElementFactory.eINSTANCE.createPosition();
			pos.setX(calculatedX);
			pos.setY(calculatedY);
			mapping.getProperty(LAYOUT_DATA).addPosition((FBNetworkElement) ep.getModel(), pos);
			if (ep instanceof GroupEditPart) {
				mapping.getProperty(LAYOUT_DATA).addGroup((Group) ep.getModel(), (int) node.getHeight(), (int) node.getWidth());
			}
		}
		for (final ElkEdge edge : node.getContainedEdges()) {
			ConnectionEditPart connEp = (ConnectionEditPart) mapping.getGraphMap().get(edge);
			if (connEp == null) {
				connEp = mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_REVERSE_MAPPING).get(edge);
				final List<ElkEdge> edgeList = mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_MAPPING).get(connEp);
				if (edgeList == null) {
					continue; // crossing edge has already been processed
				}
				final ElkPort startPort = (ElkPort) edgeList.get(0).getSources().get(0);
				final ElkPort endPort = (ElkPort) edgeList.get(edgeList.size() - 1).getTargets().get(0);
				final List<ElkBendPoint> bendPoints = new LinkedList<>();
				for (final ElkEdge e : edgeList) {
					// is in group
					if (e.getContainingNode() != node) {
						// bendpoints inside groups are relative to the group and not the network
						for (final ElkBendPoint point : e.getSections().get(0).getBendPoints()) {
							point.setX(point.getX() + e.getContainingNode().getX());
							point.setY(point.getY() + e.getContainingNode().getY());
						}
					}
					bendPoints.addAll(e.getSections().get(0).getBendPoints());
				}
				// 4 bendpoints result in a five-segment connection, everything above that needs to be trimmed down
				if (bendPoints.size() > 4) {
					final List<ElkBendPoint> list = new ArrayList<>(4);
					list.add(bendPoints.get(0));
					list.add(bendPoints.get(1));
					list.add(bendPoints.get(bendPoints.size() - 1)); // last element
					list.add(bendPoints.get(bendPoints.size() - 2)); // second last element
					bendPoints.retainAll(list);
				}
				mapping.getProperty(LAYOUT_DATA).addConnectionPoints(connEp.getModel(), createCrossingPointList(node, startPort, endPort, bendPoints));
				mapping.getProperty(HIERARCHY_CROSSING_CONNECTIONS_MAPPING).remove(connEp); // remove so other iterations don't process it again
			} else {
				final ElkPort startPort = (ElkPort) edge.getSources().get(0);
				final ElkPort endPort = (ElkPort) edge.getTargets().get(0);
				final List<ElkBendPoint> bendPoints = edge.getSections().get(0).getBendPoints();
				
				mapping.getProperty(LAYOUT_DATA).addConnectionPoints(connEp.getModel(), createPointList(node, startPort, endPort, bendPoints, calculatedX, calculatedY));				
			}
		}
		// position inside of group -> relative
		// outside -> absolute
		if (ep instanceof GroupEditPart) {
			final int groupCommentHeight = (int) node.getLabels().get(0).getHeight();
			node.getChildren().forEach(child -> calculateNodePositionsRecursively(mapping, child, 0, -groupCommentHeight));
		} else {			
			node.getChildren().forEach(child -> calculateNodePositionsRecursively(mapping, child, calculatedX, calculatedY));
		}
	}
	
	private static PointList createPointList(final ElkNode node, final ElkPort startPort, final ElkPort endPort,
			final List<ElkBendPoint> bendPoints, final int calculatedX, final int calculatedY) {
		final PointList list = new PointList();
		if (startPort.getParent() == node) {
			// hierarchical port
			list.addPoint((int) (startPort.getX() + calculatedX), (int) (startPort.getY() + calculatedY));
		} else {
			// simple port
			list.addPoint((int) (startPort.getX() + startPort.getParent().getX() + calculatedX), (int) (startPort.getY() + startPort.getParent().getY() + calculatedY));
		}
		for (final ElkBendPoint point : bendPoints) {
			list.addPoint((int) (point.getX() + calculatedX), (int) (point.getY() + calculatedY));
		}
		if (endPort.getParent() == node) {
			// hierarchical port
			list.addPoint((int) (endPort.getX() + calculatedX), (int) (endPort.getY() + calculatedY));
		} else {
			// simple port
			list.addPoint((int) (endPort.getX() + endPort.getParent().getX() + calculatedX), (int) (endPort.getY() + endPort.getParent().getY() + calculatedY));
		}
		return list;
	}
	
	private static PointList createCrossingPointList(final ElkNode node, final ElkPort startPort, final ElkPort endPort,
			final List<ElkBendPoint> bendPoints) {
		final PointList list = new PointList();
		list.addPoint(toAbsolute(startPort.getX(), startPort.getY(), startPort.getParent()));
		for (final ElkBendPoint point : bendPoints) {
			// the "parent" (node) is the containing node of the edge, which in most cases is the network itself
			list.addPoint(toAbsolute(point.getX(), point.getY(), node));
		}
		list.addPoint(toAbsolute(endPort.getX(), endPort.getY(), endPort.getParent()));
		return list;
	}
	
	private static PrecisionPoint toAbsolute(final double startX, final double startY, final ElkNode parent) {
		double x = startX;
		double y = startY;
		ElkNode tmp = parent;
		while (tmp != null) {
			x += tmp.getX();
			y += tmp.getY();
			tmp = tmp.getParent();
		}
		return new PrecisionPoint(x, y);
	}

}