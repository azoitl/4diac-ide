/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ST Feature Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STFeatureExpression#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STFeatureExpression#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTFeatureExpression()
 * @model
 * @generated
 */
public interface STFeatureExpression extends STExpression
{
  /**
   * Returns the value of the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' reference.
   * @see #setFeature(INamedElement)
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTFeatureExpression_Feature()
   * @model
   * @generated
   */
  INamedElement getFeature();

  /**
   * Sets the value of the '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STFeatureExpression#getFeature <em>Feature</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' reference.
   * @see #getFeature()
   * @generated
   */
  void setFeature(INamedElement value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallArgument}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTFeatureExpression_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<STCallArgument> getParameters();

} // STFeatureExpression
