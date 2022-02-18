/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ST Case Cases</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseCases#getConditions <em>Conditions</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseCases#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTCaseCases()
 * @model
 * @generated
 */
public interface STCaseCases extends EObject
{
  /**
   * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conditions</em>' containment reference list.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTCaseCases_Conditions()
   * @model containment="true"
   * @generated
   */
  EList<STExpression> getConditions();

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STStatement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTCaseCases_Statements()
   * @model containment="true"
   * @generated
   */
  EList<STStatement> getStatements();

} // STCaseCases
