/**
 * generated by Xtext 2.25.0
 */
package org.eclipse.fordiac.ide.structuredtextcore.sTCore.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;

import org.eclipse.fordiac.ide.structuredtextcore.sTCore.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCorePackage
 * @generated
 */
public class STCoreAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static STCorePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STCoreAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = STCorePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected STCoreSwitch<Adapter> modelSwitch =
    new STCoreSwitch<Adapter>()
    {
      @Override
      public Adapter caseCode(Code object)
      {
        return createCodeAdapter();
      }
      @Override
      public Adapter caseVarDeclarationBlock(VarDeclarationBlock object)
      {
        return createVarDeclarationBlockAdapter();
      }
      @Override
      public Adapter caseInitializerExpression(InitializerExpression object)
      {
        return createInitializerExpressionAdapter();
      }
      @Override
      public Adapter caseArrayInitializerExpression(ArrayInitializerExpression object)
      {
        return createArrayInitializerExpressionAdapter();
      }
      @Override
      public Adapter caseArrayInitElement(ArrayInitElement object)
      {
        return createArrayInitElementAdapter();
      }
      @Override
      public Adapter caseSTStatement(STStatement object)
      {
        return createSTStatementAdapter();
      }
      @Override
      public Adapter caseSTAssignmentStatement(STAssignmentStatement object)
      {
        return createSTAssignmentStatementAdapter();
      }
      @Override
      public Adapter caseSTCallStatement(STCallStatement object)
      {
        return createSTCallStatementAdapter();
      }
      @Override
      public Adapter caseSTCallArgument(STCallArgument object)
      {
        return createSTCallArgumentAdapter();
      }
      @Override
      public Adapter caseSTCallUnnamedArgument(STCallUnnamedArgument object)
      {
        return createSTCallUnnamedArgumentAdapter();
      }
      @Override
      public Adapter caseSTCallNamedInputArgument(STCallNamedInputArgument object)
      {
        return createSTCallNamedInputArgumentAdapter();
      }
      @Override
      public Adapter caseSTCallNamedOutputArgument(STCallNamedOutputArgument object)
      {
        return createSTCallNamedOutputArgumentAdapter();
      }
      @Override
      public Adapter caseSTIfStatement(STIfStatement object)
      {
        return createSTIfStatementAdapter();
      }
      @Override
      public Adapter caseSTElseIfPart(STElseIfPart object)
      {
        return createSTElseIfPartAdapter();
      }
      @Override
      public Adapter caseSTCaseStatement(STCaseStatement object)
      {
        return createSTCaseStatementAdapter();
      }
      @Override
      public Adapter caseSTCaseCases(STCaseCases object)
      {
        return createSTCaseCasesAdapter();
      }
      @Override
      public Adapter caseSTElsePart(STElsePart object)
      {
        return createSTElsePartAdapter();
      }
      @Override
      public Adapter caseSTForStatement(STForStatement object)
      {
        return createSTForStatementAdapter();
      }
      @Override
      public Adapter caseSTWhileStatement(STWhileStatement object)
      {
        return createSTWhileStatementAdapter();
      }
      @Override
      public Adapter caseSTRepeatStatement(STRepeatStatement object)
      {
        return createSTRepeatStatementAdapter();
      }
      @Override
      public Adapter caseSTExpression(STExpression object)
      {
        return createSTExpressionAdapter();
      }
      @Override
      public Adapter caseSTNumericLiteral(STNumericLiteral object)
      {
        return createSTNumericLiteralAdapter();
      }
      @Override
      public Adapter caseSTDateLiteral(STDateLiteral object)
      {
        return createSTDateLiteralAdapter();
      }
      @Override
      public Adapter caseSTTimeLiteral(STTimeLiteral object)
      {
        return createSTTimeLiteralAdapter();
      }
      @Override
      public Adapter caseSTTimeOfDayLiteral(STTimeOfDayLiteral object)
      {
        return createSTTimeOfDayLiteralAdapter();
      }
      @Override
      public Adapter caseSTDateAndTimeLiteral(STDateAndTimeLiteral object)
      {
        return createSTDateAndTimeLiteralAdapter();
      }
      @Override
      public Adapter caseSTStringLiteral(STStringLiteral object)
      {
        return createSTStringLiteralAdapter();
      }
      @Override
      public Adapter caseSTVarDeclaration(STVarDeclaration object)
      {
        return createSTVarDeclarationAdapter();
      }
      @Override
      public Adapter caseSTReturn(STReturn object)
      {
        return createSTReturnAdapter();
      }
      @Override
      public Adapter caseSTContinue(STContinue object)
      {
        return createSTContinueAdapter();
      }
      @Override
      public Adapter caseSTExit(STExit object)
      {
        return createSTExitAdapter();
      }
      @Override
      public Adapter caseSTNop(STNop object)
      {
        return createSTNopAdapter();
      }
      @Override
      public Adapter caseSTBinaryExpression(STBinaryExpression object)
      {
        return createSTBinaryExpressionAdapter();
      }
      @Override
      public Adapter caseSTUnaryExpression(STUnaryExpression object)
      {
        return createSTUnaryExpressionAdapter();
      }
      @Override
      public Adapter caseSTMemberAccessExpression(STMemberAccessExpression object)
      {
        return createSTMemberAccessExpressionAdapter();
      }
      @Override
      public Adapter caseSTArrayAccessExpression(STArrayAccessExpression object)
      {
        return createSTArrayAccessExpressionAdapter();
      }
      @Override
      public Adapter caseSTFeatureExpression(STFeatureExpression object)
      {
        return createSTFeatureExpressionAdapter();
      }
      @Override
      public Adapter caseSTMultibitPartialExpression(STMultibitPartialExpression object)
      {
        return createSTMultibitPartialExpressionAdapter();
      }
      @Override
      public Adapter caseINamedElement(INamedElement object)
      {
        return createINamedElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.Code <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.Code
   * @generated
   */
  public Adapter createCodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.VarDeclarationBlock <em>Var Declaration Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.VarDeclarationBlock
   * @generated
   */
  public Adapter createVarDeclarationBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.InitializerExpression <em>Initializer Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.InitializerExpression
   * @generated
   */
  public Adapter createInitializerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.ArrayInitializerExpression <em>Array Initializer Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.ArrayInitializerExpression
   * @generated
   */
  public Adapter createArrayInitializerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.ArrayInitElement <em>Array Init Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.ArrayInitElement
   * @generated
   */
  public Adapter createArrayInitElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STStatement <em>ST Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STStatement
   * @generated
   */
  public Adapter createSTStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STAssignmentStatement <em>ST Assignment Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STAssignmentStatement
   * @generated
   */
  public Adapter createSTAssignmentStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallStatement <em>ST Call Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallStatement
   * @generated
   */
  public Adapter createSTCallStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallArgument <em>ST Call Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallArgument
   * @generated
   */
  public Adapter createSTCallArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallUnnamedArgument <em>ST Call Unnamed Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallUnnamedArgument
   * @generated
   */
  public Adapter createSTCallUnnamedArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallNamedInputArgument <em>ST Call Named Input Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallNamedInputArgument
   * @generated
   */
  public Adapter createSTCallNamedInputArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallNamedOutputArgument <em>ST Call Named Output Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCallNamedOutputArgument
   * @generated
   */
  public Adapter createSTCallNamedOutputArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STIfStatement <em>ST If Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STIfStatement
   * @generated
   */
  public Adapter createSTIfStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STElseIfPart <em>ST Else If Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STElseIfPart
   * @generated
   */
  public Adapter createSTElseIfPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseStatement <em>ST Case Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseStatement
   * @generated
   */
  public Adapter createSTCaseStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseCases <em>ST Case Cases</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STCaseCases
   * @generated
   */
  public Adapter createSTCaseCasesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STElsePart <em>ST Else Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STElsePart
   * @generated
   */
  public Adapter createSTElsePartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STForStatement <em>ST For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STForStatement
   * @generated
   */
  public Adapter createSTForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STWhileStatement <em>ST While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STWhileStatement
   * @generated
   */
  public Adapter createSTWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STRepeatStatement <em>ST Repeat Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STRepeatStatement
   * @generated
   */
  public Adapter createSTRepeatStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STExpression <em>ST Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STExpression
   * @generated
   */
  public Adapter createSTExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STNumericLiteral <em>ST Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STNumericLiteral
   * @generated
   */
  public Adapter createSTNumericLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STDateLiteral <em>ST Date Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STDateLiteral
   * @generated
   */
  public Adapter createSTDateLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STTimeLiteral <em>ST Time Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STTimeLiteral
   * @generated
   */
  public Adapter createSTTimeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STTimeOfDayLiteral <em>ST Time Of Day Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STTimeOfDayLiteral
   * @generated
   */
  public Adapter createSTTimeOfDayLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STDateAndTimeLiteral <em>ST Date And Time Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STDateAndTimeLiteral
   * @generated
   */
  public Adapter createSTDateAndTimeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STStringLiteral <em>ST String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STStringLiteral
   * @generated
   */
  public Adapter createSTStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STVarDeclaration <em>ST Var Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STVarDeclaration
   * @generated
   */
  public Adapter createSTVarDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STReturn <em>ST Return</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STReturn
   * @generated
   */
  public Adapter createSTReturnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STContinue <em>ST Continue</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STContinue
   * @generated
   */
  public Adapter createSTContinueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STExit <em>ST Exit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STExit
   * @generated
   */
  public Adapter createSTExitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STNop <em>ST Nop</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STNop
   * @generated
   */
  public Adapter createSTNopAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STBinaryExpression <em>ST Binary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STBinaryExpression
   * @generated
   */
  public Adapter createSTBinaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression <em>ST Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STUnaryExpression
   * @generated
   */
  public Adapter createSTUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STMemberAccessExpression <em>ST Member Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STMemberAccessExpression
   * @generated
   */
  public Adapter createSTMemberAccessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STArrayAccessExpression <em>ST Array Access Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STArrayAccessExpression
   * @generated
   */
  public Adapter createSTArrayAccessExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STFeatureExpression <em>ST Feature Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STFeatureExpression
   * @generated
   */
  public Adapter createSTFeatureExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.structuredtextcore.sTCore.STMultibitPartialExpression <em>ST Multibit Partial Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.structuredtextcore.sTCore.STMultibitPartialExpression
   * @generated
   */
  public Adapter createSTMultibitPartialExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.fordiac.ide.model.libraryElement.INamedElement <em>INamed Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.fordiac.ide.model.libraryElement.INamedElement
   * @generated
   */
  public Adapter createINamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //STCoreAdapterFactory
