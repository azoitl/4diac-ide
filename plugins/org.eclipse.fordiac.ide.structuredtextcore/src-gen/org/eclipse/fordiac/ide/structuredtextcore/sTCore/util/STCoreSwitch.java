/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;

import org.eclipse.fordiac.ide.structuredtextcore.sTCore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage
 * @generated
 */
public class STCoreSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static STCorePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STCoreSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = STCorePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case STCorePackage.CODE:
      {
        Code code = (Code)theEObject;
        T result = caseCode(code);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.VAR_DECLARATION_BLOCK:
      {
        VarDeclarationBlock varDeclarationBlock = (VarDeclarationBlock)theEObject;
        T result = caseVarDeclarationBlock(varDeclarationBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.INITIALIZER_EXPRESSION:
      {
        InitializerExpression initializerExpression = (InitializerExpression)theEObject;
        T result = caseInitializerExpression(initializerExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ARRAY_INITIALIZER_EXPRESSION:
      {
        ArrayInitializerExpression arrayInitializerExpression = (ArrayInitializerExpression)theEObject;
        T result = caseArrayInitializerExpression(arrayInitializerExpression);
        if (result == null) result = caseInitializerExpression(arrayInitializerExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ARRAY_INIT_ELEMENT:
      {
        ArrayInitElement arrayInitElement = (ArrayInitElement)theEObject;
        T result = caseArrayInitElement(arrayInitElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_STATEMENT:
      {
        STStatement stStatement = (STStatement)theEObject;
        T result = caseSTStatement(stStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_ASSIGNMENT_STATEMENT:
      {
        STAssignmentStatement stAssignmentStatement = (STAssignmentStatement)theEObject;
        T result = caseSTAssignmentStatement(stAssignmentStatement);
        if (result == null) result = caseSTStatement(stAssignmentStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_IF_STATMENT:
      {
        STIfStatment stIfStatment = (STIfStatment)theEObject;
        T result = caseSTIfStatment(stIfStatment);
        if (result == null) result = caseSTStatement(stIfStatment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_ELSE_IF_PART:
      {
        STElseIfPart stElseIfPart = (STElseIfPart)theEObject;
        T result = caseSTElseIfPart(stElseIfPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_CASE_STATEMENT:
      {
        STCaseStatement stCaseStatement = (STCaseStatement)theEObject;
        T result = caseSTCaseStatement(stCaseStatement);
        if (result == null) result = caseSTStatement(stCaseStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_CASE_CASES:
      {
        STCaseCases stCaseCases = (STCaseCases)theEObject;
        T result = caseSTCaseCases(stCaseCases);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_ELSE_PART:
      {
        STElsePart stElsePart = (STElsePart)theEObject;
        T result = caseSTElsePart(stElsePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_FOR_STATEMENT:
      {
        STForStatement stForStatement = (STForStatement)theEObject;
        T result = caseSTForStatement(stForStatement);
        if (result == null) result = caseSTStatement(stForStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_WHILE_STATEMENT:
      {
        STWhileStatement stWhileStatement = (STWhileStatement)theEObject;
        T result = caseSTWhileStatement(stWhileStatement);
        if (result == null) result = caseSTStatement(stWhileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_REPEAT_STATEMENT:
      {
        STRepeatStatement stRepeatStatement = (STRepeatStatement)theEObject;
        T result = caseSTRepeatStatement(stRepeatStatement);
        if (result == null) result = caseSTStatement(stRepeatStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_EXPRESSION:
      {
        STExpression stExpression = (STExpression)theEObject;
        T result = caseSTExpression(stExpression);
        if (result == null) result = caseInitializerExpression(stExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_NUMERIC_LITERAL:
      {
        STNumericLiteral stNumericLiteral = (STNumericLiteral)theEObject;
        T result = caseSTNumericLiteral(stNumericLiteral);
        if (result == null) result = caseSTExpression(stNumericLiteral);
        if (result == null) result = caseInitializerExpression(stNumericLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_DATE_LITERAL:
      {
        STDateLiteral stDateLiteral = (STDateLiteral)theEObject;
        T result = caseSTDateLiteral(stDateLiteral);
        if (result == null) result = caseSTExpression(stDateLiteral);
        if (result == null) result = caseInitializerExpression(stDateLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_TIME_LITERAL:
      {
        STTimeLiteral stTimeLiteral = (STTimeLiteral)theEObject;
        T result = caseSTTimeLiteral(stTimeLiteral);
        if (result == null) result = caseSTExpression(stTimeLiteral);
        if (result == null) result = caseInitializerExpression(stTimeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_TIME_OF_DAY_LITERAL:
      {
        STTimeOfDayLiteral stTimeOfDayLiteral = (STTimeOfDayLiteral)theEObject;
        T result = caseSTTimeOfDayLiteral(stTimeOfDayLiteral);
        if (result == null) result = caseSTExpression(stTimeOfDayLiteral);
        if (result == null) result = caseInitializerExpression(stTimeOfDayLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_DATE_AND_TIME_LITERAL:
      {
        STDateAndTimeLiteral stDateAndTimeLiteral = (STDateAndTimeLiteral)theEObject;
        T result = caseSTDateAndTimeLiteral(stDateAndTimeLiteral);
        if (result == null) result = caseSTExpression(stDateAndTimeLiteral);
        if (result == null) result = caseInitializerExpression(stDateAndTimeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_STRING_LITERAL:
      {
        STStringLiteral stStringLiteral = (STStringLiteral)theEObject;
        T result = caseSTStringLiteral(stStringLiteral);
        if (result == null) result = caseSTExpression(stStringLiteral);
        if (result == null) result = caseInitializerExpression(stStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.VAR_DECLARATION:
      {
        VarDeclaration varDeclaration = (VarDeclaration)theEObject;
        T result = caseVarDeclaration(varDeclaration);
        if (result == null) result = caseINamedElement(varDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_RETURN:
      {
        STReturn stReturn = (STReturn)theEObject;
        T result = caseSTReturn(stReturn);
        if (result == null) result = caseSTStatement(stReturn);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_CONTINUE:
      {
        STContinue stContinue = (STContinue)theEObject;
        T result = caseSTContinue(stContinue);
        if (result == null) result = caseSTStatement(stContinue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_EXIT:
      {
        STExit stExit = (STExit)theEObject;
        T result = caseSTExit(stExit);
        if (result == null) result = caseSTStatement(stExit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_NOP:
      {
        STNop stNop = (STNop)theEObject;
        T result = caseSTNop(stNop);
        if (result == null) result = caseSTStatement(stNop);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_BINARY_EXPRESSION:
      {
        STBinaryExpression stBinaryExpression = (STBinaryExpression)theEObject;
        T result = caseSTBinaryExpression(stBinaryExpression);
        if (result == null) result = caseSTExpression(stBinaryExpression);
        if (result == null) result = caseInitializerExpression(stBinaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_UNARY_EXPRESSION:
      {
        STUnaryExpression stUnaryExpression = (STUnaryExpression)theEObject;
        T result = caseSTUnaryExpression(stUnaryExpression);
        if (result == null) result = caseSTExpression(stUnaryExpression);
        if (result == null) result = caseInitializerExpression(stUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_MEMBER_ACCESS_EXPRESSION:
      {
        STMemberAccessExpression stMemberAccessExpression = (STMemberAccessExpression)theEObject;
        T result = caseSTMemberAccessExpression(stMemberAccessExpression);
        if (result == null) result = caseSTExpression(stMemberAccessExpression);
        if (result == null) result = caseInitializerExpression(stMemberAccessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_ARRAY_ACCESS_EXPRESSION:
      {
        STArrayAccessExpression stArrayAccessExpression = (STArrayAccessExpression)theEObject;
        T result = caseSTArrayAccessExpression(stArrayAccessExpression);
        if (result == null) result = caseSTExpression(stArrayAccessExpression);
        if (result == null) result = caseInitializerExpression(stArrayAccessExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_FEATURE_EXPRESSION:
      {
        STFeatureExpression stFeatureExpression = (STFeatureExpression)theEObject;
        T result = caseSTFeatureExpression(stFeatureExpression);
        if (result == null) result = caseSTExpression(stFeatureExpression);
        if (result == null) result = caseInitializerExpression(stFeatureExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case STCorePackage.ST_MULTIBIT_PARTIAL_EXPRESSION:
      {
        STMultibitPartialExpression stMultibitPartialExpression = (STMultibitPartialExpression)theEObject;
        T result = caseSTMultibitPartialExpression(stMultibitPartialExpression);
        if (result == null) result = caseSTExpression(stMultibitPartialExpression);
        if (result == null) result = caseInitializerExpression(stMultibitPartialExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Code</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Code</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCode(Code object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Declaration Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Declaration Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarDeclarationBlock(VarDeclarationBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Initializer Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Initializer Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitializerExpression(InitializerExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Initializer Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Initializer Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayInitializerExpression(ArrayInitializerExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Init Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Init Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayInitElement(ArrayInitElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTStatement(STStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Assignment Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Assignment Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTAssignmentStatement(STAssignmentStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST If Statment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST If Statment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTIfStatment(STIfStatment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Else If Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Else If Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTElseIfPart(STElseIfPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Case Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Case Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTCaseStatement(STCaseStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Case Cases</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Case Cases</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTCaseCases(STCaseCases object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Else Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Else Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTElsePart(STElsePart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTForStatement(STForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTWhileStatement(STWhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Repeat Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Repeat Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTRepeatStatement(STRepeatStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTExpression(STExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Numeric Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Numeric Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTNumericLiteral(STNumericLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Date Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Date Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTDateLiteral(STDateLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Time Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Time Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTTimeLiteral(STTimeLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Time Of Day Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Time Of Day Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTTimeOfDayLiteral(STTimeOfDayLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Date And Time Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Date And Time Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTDateAndTimeLiteral(STDateAndTimeLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTStringLiteral(STStringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarDeclaration(VarDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Return</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Return</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTReturn(STReturn object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Continue</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Continue</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTContinue(STContinue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Exit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Exit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTExit(STExit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Nop</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Nop</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTNop(STNop object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Binary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Binary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTBinaryExpression(STBinaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTUnaryExpression(STUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Member Access Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Member Access Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTMemberAccessExpression(STMemberAccessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Array Access Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Array Access Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTArrayAccessExpression(STArrayAccessExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Feature Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Feature Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTFeatureExpression(STFeatureExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ST Multibit Partial Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ST Multibit Partial Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSTMultibitPartialExpression(STMultibitPartialExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>INamed Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>INamed Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseINamedElement(INamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //STCoreSwitch
