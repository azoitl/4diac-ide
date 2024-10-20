/*******************************************************************************
 * Copyright (c) 2008, 2009, 2013 - 2016 Profactor GmbH, fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.ecc.editors;

import org.eclipse.fordiac.ide.fbtypeeditor.ecc.Messages;
import org.eclipse.fordiac.ide.gef.preferences.PaletteFlyoutPreferences;
import org.eclipse.fordiac.ide.ui.imageprovider.FordiacImage;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.jface.resource.ImageDescriptor;

public final class ECCPaletteFactory {
	public static final PaletteFlyoutPreferences PALETTE_PREFERENCES = new PaletteFlyoutPreferences(
			"ECCPaletteFactory.Location", //$NON-NLS-1$
			"ECCPaletteFactory.Size", //$NON-NLS-1$
			"ECCPaletteFactory.State"); //$NON-NLS-1$

	public static PaletteRoot createPalette() {
		final PaletteRoot palette = new PaletteRoot();
		fillPalette(palette);
		return palette;
	}

	private static void fillPalette(final PaletteRoot palette) {
		final PaletteGroup eccGroup = new PaletteGroup(Messages.ECCPaletteFactory_LABEL_ECCGroup);
		ImageDescriptor desc = FordiacImage.ICON_EC_STATE.getImageDescriptor();
		CombinedTemplateCreationEntry combined = new CombinedTemplateCreationEntry(
				Messages.ECCPaletteFactory_LABEL_State, Messages.ECCPaletteFactory_TOOLTIP_State,
				new StateCreationFactory(), desc, desc);
		eccGroup.add(combined);
		desc = FordiacImage.ICON_EC_ACTION.getImageDescriptor();
		combined = new CombinedTemplateCreationEntry(Messages.ECCPaletteFactory_LABEL_Action,
				Messages.ECCPaletteFactory_TOOLTIP_Action, new ActionCreationFactory(), desc, desc);
		eccGroup.add(combined);
		palette.add(eccGroup);
	}

	private ECCPaletteFactory() {
		throw new UnsupportedOperationException("Class ECCPaletterFactory should not be created!\n"); //$NON-NLS-1$
	}
}
