/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University Linz
 *               2023 Martin Erich Jobst
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *   Martin Jobst - add constructor with member list
 *******************************************************************************/
package org.eclipse.fordiac.ide.export.forte_ng.struct

import java.nio.file.Path
import org.eclipse.fordiac.ide.export.forte_ng.ForteNgExportFilter
import org.eclipse.fordiac.ide.model.data.StructuredType

class StructuredTypeHeaderTemplate extends StructBaseTemplate {


	new(StructuredType type, String name, Path prefix) {
		super(type, name, prefix)
	}

	override generate() '''
		«generateHeader»

		«generateIncludeGuardStart»

		«generateHeaderIncludes»

		class «structClassName»: public CIEC_STRUCT {
		  DECLARE_FIRMWARE_DATATYPE(«type.name»)

		  public:
		    «structClassName»();

		    «structClassName»(«generateConstructorParameters»);

		    virtual ~«structClassName»() = default;

            «type.memberVariables.generateAccessors("getMember")»

		  private:
		    static const CStringDictionary::TStringId scmElementTypes[];
		    static const CStringDictionary::TStringId scmElementNames[];

		};

		«generateIncludeGuardEnd»

	'''

	def protected generateHeaderIncludes() '''
		#include "forte_struct.h"
		
		«getDependencies(#{ForteNgExportFilter.OPTION_HEADER -> Boolean.TRUE}).generateDependencyIncludes»
		
		«type.compilerInfo?.header»
	'''
}
