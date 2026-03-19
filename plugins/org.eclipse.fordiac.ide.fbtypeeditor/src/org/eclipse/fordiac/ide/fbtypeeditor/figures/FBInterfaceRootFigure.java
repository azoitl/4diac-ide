/*******************************************************************************
 * Copyright (c) 2026 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.figures;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class FBInterfaceRootFigure extends FreeformLayer {

	private static final int WITH_PADDING = 5;
	private static final int COMMENT_PADDING = 8;
	private static final int MAX_COMMENT_SIZE = 400;

	private final Figure inputCommentsColumn;
	private final Figure inputTypesColumn;
	private final WithColumnFigure inputWithColumn;
	private final Figure fbColumn;
	private final WithColumnFigure outputWithColumn;
	private final Figure outputTypesColumn;
	private final Figure outputCommentsColumn;

	public FBInterfaceRootFigure(final int inputWithColumnWidth, final int outputWithColumnWidth) {
		setBorder(new MarginBorder(10));
		setLayoutManager(new FreeformLayout());
		setOpaque(false);

		final Figure fig = new Figure() {
			@Override
			protected void paintChildren(final Graphics graphics) {
				// draw fbColumn first so that we can draw on top of the shadow
				fbColumn.paint(graphics);
				getChildren().stream().filter(child -> child != fbColumn && child.isVisible())
						.forEach(child -> child.paint(graphics));
			}
		};

		final ToolbarLayout layout = new ToolbarLayout(true);
		fig.setLayoutManager(layout);
		add(fig);
		setConstraint(fig, new Rectangle(0, 0, -1, -1));

		inputCommentsColumn = createColumn(new PinPropColumnLayout(true, COMMENT_PADDING, MAX_COMMENT_SIZE));
		inputTypesColumn = createColumn(new PinPropColumnLayout(true, WITH_PADDING));
		inputWithColumn = new WithColumnFigure(true, inputWithColumnWidth);
		fbColumn = createColumn(new StackLayout());
		outputWithColumn = new WithColumnFigure(false, outputWithColumnWidth);
		outputTypesColumn = createColumn(new PinPropColumnLayout(false, WITH_PADDING));
		outputCommentsColumn = createColumn(new PinPropColumnLayout(false, COMMENT_PADDING, MAX_COMMENT_SIZE));

		fig.add(inputCommentsColumn);
		fig.add(inputTypesColumn);
		fig.add(inputWithColumn);
		fig.add(fbColumn);
		fig.add(outputWithColumn);
		fig.add(outputTypesColumn);
		fig.add(outputCommentsColumn);
	}

	public Figure getInputCommentsColumn() {
		return inputCommentsColumn;
	}

	public Figure getInputTypesColumn() {
		return inputTypesColumn;
	}

	public Figure getInputWithColumn() {
		return inputWithColumn;
	}

	public Figure getFBColumn() {
		return fbColumn;
	}

	public Figure getOutputWithColumn() {
		return outputWithColumn;
	}

	public Figure getOutputTypesColumn() {
		return outputTypesColumn;
	}

	public Figure getOutputCommentsColumn() {
		return outputCommentsColumn;
	}

	public void setInputWithColumnWidth(final int columnWith) {
		inputWithColumn.setColumnWidth(columnWith);
	}

	public void setOutputWithColumnWidth(final int columnWith) {
		outputWithColumn.setColumnWidth(columnWith);
	}

	@Override
	protected void paintFigure(final Graphics graphics) {
		super.paintFigure(graphics);

		final var rows = getAllCommentFigures().map(IFigure::getBounds)
				.collect(Collectors.toMap(rect -> Integer.valueOf(rect.y), rect -> rect, (rect1, rect2) -> rect1))
				.values().stream().sorted(Comparator.comparingInt(rect -> rect.y)).toList();

		if (rows.isEmpty()) {
			return;
		}

		final Rectangle bounds = getBounds();
		graphics.pushState();
		graphics.setBackgroundColor(new Color(245, 245, 245));

		for (int i = 1; i < rows.size(); i += 2) { // Start at 1, skip every other
			graphics.fillRectangle(bounds.x, rows.get(i).y, bounds.width, rows.get(i).height);
		}

		graphics.popState();
	}

	private static Figure createColumn(final LayoutManager layoutManager) {
		final Figure column = new Figure();
		column.setLayoutManager(layoutManager);
		return column;
	}

	Stream<IFigure> getAllCommentFigures() {
		return Stream.concat(getInputCommentsColumn().getChildren().stream(),
				getOutputCommentsColumn().getChildren().stream());
	}

}
