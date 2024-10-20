/*******************************************************************************
 * Copyright (c) 2022 Martin Erich Jobst
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
package org.eclipse.fordiac.ide.export.plugin;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.fordiac.ide.export.language.ILanguageSupportFactory;

public class LanguageSupportFactoryRegistryReader {
	public static final String FACTORY_ID = "language.supportFactory"; //$NON-NLS-1$
	public static final String ATT_CLASS = "class"; //$NON-NLS-1$
	public static final String ATT_FILTER = "filter"; //$NON-NLS-1$
	public static final String ATT_TYPE = "type"; //$NON-NLS-1$
	public static final String CHILD_SOURCE = "source"; //$NON-NLS-1$

	public void readRegistry() {
		final var config = RegistryFactory.getRegistry().getConfigurationElementsFor(ExportPlugin.PLUGIN_ID,
				FACTORY_ID);
		for (final var element : config) {
			readFactory(element);
		}
	}

	private void readFactory(final IConfigurationElement element) {
		ILanguageSupportFactory factory = null;
		try {
			factory = (ILanguageSupportFactory) element.createExecutableExtension(ATT_CLASS);
		} catch (final Exception e) {
			log(element, "The factory instance could not be created", e); //$NON-NLS-1$
		}
		final String filter = element.getAttribute(ATT_FILTER);
		if (factory != null) {
			final var sources = element.getChildren(CHILD_SOURCE);
			for (final var source : sources) {
				readSource(element, factory, filter, source);
			}
		}
	}

	private void readSource(final IConfigurationElement element, final ILanguageSupportFactory factory, final String filter,
			final IConfigurationElement source) {
		final var type = source.getAttribute(ATT_TYPE);
		Class<?> sourceClass = null;
		try {
			sourceClass = CommonPlugin.loadClass(element.getDeclaringExtension().getContributor().getName(),
					type);
		} catch (final ClassNotFoundException e) {
			log(element, "The factory source type attribute does not specify a valid class", e); //$NON-NLS-1$
		}
		if (sourceClass != null) {
			final var previousFactory = ILanguageSupportFactory.Registry.INSTANCE.registerFactory(filter,
					sourceClass, factory);
			if (previousFactory != null) {
				log(element, String.format("A factory %s was already registered for the source type %s", //$NON-NLS-1$
						previousFactory.getClass().getName(), sourceClass.getName()));
			}
		}
	}

	private void log(final IConfigurationElement element, final String message) {
		Platform.getLog(getClass()).error(String.format("%s in extension %s from plugin %s", message, //$NON-NLS-1$
				element.getDeclaringExtension().getExtensionPointUniqueIdentifier(),
				element.getDeclaringExtension().getContributor().getName()));
	}

	private void log(final IConfigurationElement element, final String message, final Throwable t) {
		Platform.getLog(getClass()).error(String.format("%s in extension %s from plugin %s", message, //$NON-NLS-1$
				element.getDeclaringExtension().getExtensionPointUniqueIdentifier(),
				element.getDeclaringExtension().getContributor().getName()), t);
	}
}
