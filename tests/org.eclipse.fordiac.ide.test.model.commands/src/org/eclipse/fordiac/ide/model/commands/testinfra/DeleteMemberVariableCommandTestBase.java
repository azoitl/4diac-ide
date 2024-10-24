/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Bianca Wiesmayr
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands.testinfra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fordiac.ide.model.FordiacKeywords;
import org.eclipse.fordiac.ide.model.data.DataFactory;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.model.typelibrary.DataTypeLibrary;
import org.junit.jupiter.params.provider.Arguments;

public abstract class DeleteMemberVariableCommandTestBase
extends CommandTestBase<DeleteMemberVariableCommandTestBase.State> {
	protected static DataTypeLibrary datatypeLib = new DataTypeLibrary();
	protected static List<VarDeclaration> varList = new ArrayList<>();

	// create a state description that holds the struct and the command
	public static class State extends CommandTestBase.StateBase {

		private final StructuredType struct;

		public StructuredType getStructuredType() {
			return struct;
		}

		public State() {
			struct = DataFactory.eINSTANCE.createStructuredType();
			fillStruct();
			// TODO add user-defined datatypes to datatype library for testing
		}

		private void fillStruct() {
			if (varList.isEmpty()) {
				final DataType bool = datatypeLib.getType(FordiacKeywords.BOOL);
				final VarDeclaration varDecl1 = LibraryElementFactory.eINSTANCE.createVarDeclaration();
				varDecl1.setName("VAR1"); //$NON-NLS-1$
				varDecl1.setType(bool);
				varList.add(varDecl1);

				final VarDeclaration varDecl2 = LibraryElementFactory.eINSTANCE.createVarDeclaration();
				varDecl2.setName("VAR2"); //$NON-NLS-1$
				varDecl2.setType(bool);
				varList.add(varDecl2);

				final VarDeclaration varDecl3 = LibraryElementFactory.eINSTANCE.createVarDeclaration();
				varDecl3.setName("VAR3"); //$NON-NLS-1$
				varDecl3.setType(bool);
				varList.add(varDecl3);

				final VarDeclaration struct1 = LibraryElementFactory.eINSTANCE.createVarDeclaration();
				struct1.setName("STRUCT1"); //$NON-NLS-1$
				struct1.setType(datatypeLib.getStructuredType(FordiacKeywords.ANY_STRUCT));
				varList.add(struct1);

				final VarDeclaration varDecl5 = LibraryElementFactory.eINSTANCE.createVarDeclaration();
				varDecl5.setName("VAR4"); //$NON-NLS-1$
				varDecl5.setType(bool);
				varList.add(varDecl5);
			}

			getStructuredType().getMemberVariables().addAll(varList);
		}

		public State(final State s) {
			struct = EcoreUtil.copy(s.struct);
		}

		@Override
		public Object getClone() {
			return new State(this);
		}
	}

	protected static Collection<Arguments> describeCommand(final String description, final StateInitializer<?> initializer,
			final StateVerifier<?> initialVerifier, final List<ExecutionDescription<?>> commands) {
		return describeCommand(description, initializer, initialVerifier, commands, CommandTestBase::defaultUndoCommand,
				CommandTestBase::defaultRedoCommand);
	}

	protected static void verifyDefaultInitialValues(final State state, final State oldState, final TestFunction t) {
		t.test(state.getStructuredType());
		t.test(state.getStructuredType().getMemberVariables().size(), varList.size());
	}

	// define here the list of test sequences
	// multiple execution descriptions are possible -> define in test class
	protected static Collection<Arguments> createCommands(final List<ExecutionDescription<?>> deletionExecutionDescriptions) {
		final Collection<Arguments> commands = new ArrayList<>();
		// test series 1
		commands.addAll(describeCommand("Autofilled Command", // //$NON-NLS-1$
				State::new, //
				(StateVerifier<State>) DeleteMemberVariableCommandTestBase::verifyDefaultInitialValues, //
				deletionExecutionDescriptions //
				));
		return commands;
	}

}
