/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ST Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTUnaryExpression()
 * @model
 * @generated
 */
public interface STUnaryExpression extends STExpression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.UnaryOperator
   * @see #setOp(UnaryOperator)
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTUnaryExpression_Op()
   * @model
   * @generated
   */
  UnaryOperator getOp();

  /**
   * Sets the value of the '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.UnaryOperator
   * @see #getOp()
   * @generated
   */
  void setOp(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(STExpression)
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage#getSTUnaryExpression_Expression()
   * @model containment="true"
   * @generated
   */
  STExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(STExpression value);

} // STUnaryExpression
