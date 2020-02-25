/*******************************************************************************
 * Copyright (c) 2013, 2015 fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.ui.IElementFactory;
import org.eclipse.ui.IMemento;

public abstract class AbstractUntypedEditorInputFactory implements IElementFactory {

	/**
	 * Tag for the automation system name.
	 */
	private static final String TAG_AUTOMATION_SYSTEM = "SYSTEM"; //$NON-NLS-1$
	private static final String TAG_PROJECT = "PROJECT"; //$NON-NLS-1$

	protected static void saveAutomationSystem(IMemento memento, AutomationSystem system) {
		if (null != system) {
			memento.putString(TAG_AUTOMATION_SYSTEM, system.getSystemFile().getProjectRelativePath().toString());
			memento.putString(TAG_PROJECT, system.getSystemFile().getProject().getName());
		}
	}

	protected static AutomationSystem loadAutomationSystemName(IMemento memento) {
		String projectName = memento.getString(TAG_PROJECT);
		String systemPath = memento.getString(TAG_AUTOMATION_SYSTEM);

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (null != project) {
			IFile file = project.getFile(systemPath);
			return SystemManager.INSTANCE.getSystem(file);
		}
		return null;
	}

}
