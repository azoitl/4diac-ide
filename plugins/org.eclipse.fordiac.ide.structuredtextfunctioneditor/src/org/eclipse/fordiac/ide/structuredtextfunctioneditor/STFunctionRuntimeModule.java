/*******************************************************************************
 * Copyright (c) 2022 Primetals Technologies GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians
 *       - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.structuredtextfunctioneditor;

import org.eclipse.fordiac.ide.structuredtextfunctioneditor.converter.STFunctionValueConverters;
import org.eclipse.xtext.conversion.IValueConverterService;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class STFunctionRuntimeModule extends AbstractSTFunctionRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return STFunctionValueConverters.class;
	}
}
