/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage
 * @generated
 */
public interface STCoreFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  STCoreFactory eINSTANCE = org.eclipse.fordiac.ide.structuredtextcore.sTCore.impl.STCoreFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Code</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code</em>'.
   * @generated
   */
  Code createCode();

  /**
   * Returns a new object of class '<em>Var Declaration Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Declaration Block</em>'.
   * @generated
   */
  VarDeclarationBlock createVarDeclarationBlock();

  /**
   * Returns a new object of class '<em>Initializer Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initializer Expression</em>'.
   * @generated
   */
  InitializerExpression createInitializerExpression();

  /**
   * Returns a new object of class '<em>Array Initializer Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Initializer Expression</em>'.
   * @generated
   */
  ArrayInitializerExpression createArrayInitializerExpression();

  /**
   * Returns a new object of class '<em>Array Init Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Init Element</em>'.
   * @generated
   */
  ArrayInitElement createArrayInitElement();

  /**
   * Returns a new object of class '<em>ST Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Statement</em>'.
   * @generated
   */
  STStatement createSTStatement();

  /**
   * Returns a new object of class '<em>ST Assignment Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Assignment Statement</em>'.
   * @generated
   */
  STAssignmentStatement createSTAssignmentStatement();

  /**
   * Returns a new object of class '<em>ST If Statment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST If Statment</em>'.
   * @generated
   */
  STIfStatment createSTIfStatment();

  /**
   * Returns a new object of class '<em>ST Else If Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Else If Part</em>'.
   * @generated
   */
  STElseIfPart createSTElseIfPart();

  /**
   * Returns a new object of class '<em>ST Case Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Case Statement</em>'.
   * @generated
   */
  STCaseStatement createSTCaseStatement();

  /**
   * Returns a new object of class '<em>ST Case Cases</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Case Cases</em>'.
   * @generated
   */
  STCaseCases createSTCaseCases();

  /**
   * Returns a new object of class '<em>ST Else Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Else Part</em>'.
   * @generated
   */
  STElsePart createSTElsePart();

  /**
   * Returns a new object of class '<em>ST For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST For Statement</em>'.
   * @generated
   */
  STForStatement createSTForStatement();

  /**
   * Returns a new object of class '<em>ST While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST While Statement</em>'.
   * @generated
   */
  STWhileStatement createSTWhileStatement();

  /**
   * Returns a new object of class '<em>ST Repeat Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Repeat Statement</em>'.
   * @generated
   */
  STRepeatStatement createSTRepeatStatement();

  /**
   * Returns a new object of class '<em>ST Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Expression</em>'.
   * @generated
   */
  STExpression createSTExpression();

  /**
   * Returns a new object of class '<em>ST Numeric Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Numeric Literal</em>'.
   * @generated
   */
  STNumericLiteral createSTNumericLiteral();

  /**
   * Returns a new object of class '<em>ST Date Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Date Literal</em>'.
   * @generated
   */
  STDateLiteral createSTDateLiteral();

  /**
   * Returns a new object of class '<em>ST Time Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Time Literal</em>'.
   * @generated
   */
  STTimeLiteral createSTTimeLiteral();

  /**
   * Returns a new object of class '<em>ST Time Of Day Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Time Of Day Literal</em>'.
   * @generated
   */
  STTimeOfDayLiteral createSTTimeOfDayLiteral();

  /**
   * Returns a new object of class '<em>ST Date And Time Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Date And Time Literal</em>'.
   * @generated
   */
  STDateAndTimeLiteral createSTDateAndTimeLiteral();

  /**
   * Returns a new object of class '<em>ST String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST String Literal</em>'.
   * @generated
   */
  STStringLiteral createSTStringLiteral();

  /**
   * Returns a new object of class '<em>Var Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Declaration</em>'.
   * @generated
   */
  VarDeclaration createVarDeclaration();

  /**
   * Returns a new object of class '<em>ST Return</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Return</em>'.
   * @generated
   */
  STReturn createSTReturn();

  /**
   * Returns a new object of class '<em>ST Continue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Continue</em>'.
   * @generated
   */
  STContinue createSTContinue();

  /**
   * Returns a new object of class '<em>ST Exit</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Exit</em>'.
   * @generated
   */
  STExit createSTExit();

  /**
   * Returns a new object of class '<em>ST Nop</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Nop</em>'.
   * @generated
   */
  STNop createSTNop();

  /**
   * Returns a new object of class '<em>ST Binary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Binary Expression</em>'.
   * @generated
   */
  STBinaryExpression createSTBinaryExpression();

  /**
   * Returns a new object of class '<em>ST Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Unary Expression</em>'.
   * @generated
   */
  STUnaryExpression createSTUnaryExpression();

  /**
   * Returns a new object of class '<em>ST Member Access Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Member Access Expression</em>'.
   * @generated
   */
  STMemberAccessExpression createSTMemberAccessExpression();

  /**
   * Returns a new object of class '<em>ST Array Access Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Array Access Expression</em>'.
   * @generated
   */
  STArrayAccessExpression createSTArrayAccessExpression();

  /**
   * Returns a new object of class '<em>ST Feature Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Feature Expression</em>'.
   * @generated
   */
  STFeatureExpression createSTFeatureExpression();

  /**
   * Returns a new object of class '<em>ST Multibit Partial Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ST Multibit Partial Expression</em>'.
   * @generated
   */
  STMultibitPartialExpression createSTMultibitPartialExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  STCorePackage getSTCorePackage();

} //STCoreFactory
