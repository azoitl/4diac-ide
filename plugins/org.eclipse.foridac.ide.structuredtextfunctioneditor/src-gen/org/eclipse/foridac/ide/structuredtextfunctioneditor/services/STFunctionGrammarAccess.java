/*
 * generated by Xtext 2.25.0
 */
package org.eclipse.foridac.ide.structuredtextfunctioneditor.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.fordiac.ide.structuredtextcore.services.STCoreGrammarAccess;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class STFunctionGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class STFunctionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.foridac.ide.structuredtextfunctioneditor.STFunction.STFunction");
		private final Assignment cFunctionsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cFunctionsFunctionDefinitionParserRuleCall_0 = (RuleCall)cFunctionsAssignment.eContents().get(0);
		
		//STFunction:
		//    functions+=FunctionDefinition*;
		@Override public ParserRule getRule() { return rule; }
		
		//functions+=FunctionDefinition*
		public Assignment getFunctionsAssignment() { return cFunctionsAssignment; }
		
		//FunctionDefinition
		public RuleCall getFunctionsFunctionDefinitionParserRuleCall_0() { return cFunctionsFunctionDefinitionParserRuleCall_0; }
	}
	public class FunctionDefinitionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.foridac.ide.structuredtextfunctioneditor.STFunction.FunctionDefinition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cFUNCTIONKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cColonKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cReturnTypeAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final CrossReference cReturnTypeDataTypeCrossReference_2_1_0 = (CrossReference)cReturnTypeAssignment_2_1.eContents().get(0);
		private final RuleCall cReturnTypeDataTypeIDTerminalRuleCall_2_1_0_1 = (RuleCall)cReturnTypeDataTypeCrossReference_2_1_0.eContents().get(1);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cVarDeclarationsAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cVarDeclarationsVarDeclarationParserRuleCall_3_0_0 = (RuleCall)cVarDeclarationsAssignment_3_0.eContents().get(0);
		private final Assignment cVarTempDeclarationsAssignment_3_1 = (Assignment)cAlternatives_3.eContents().get(1);
		private final RuleCall cVarTempDeclarationsVarTempDeclarationBlockParserRuleCall_3_1_0 = (RuleCall)cVarTempDeclarationsAssignment_3_1.eContents().get(0);
		private final Assignment cVarInpuDeclarationsAssignment_3_2 = (Assignment)cAlternatives_3.eContents().get(2);
		private final RuleCall cVarInpuDeclarationsVarInputDeclarationBlockParserRuleCall_3_2_0 = (RuleCall)cVarInpuDeclarationsAssignment_3_2.eContents().get(0);
		private final Assignment cVarOutputDeclarationsAssignment_3_3 = (Assignment)cAlternatives_3.eContents().get(3);
		private final RuleCall cVarOutputDeclarationsVarOutputDeclarationBlockParserRuleCall_3_3_0 = (RuleCall)cVarOutputDeclarationsAssignment_3_3.eContents().get(0);
		private final Assignment cCodeAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cCodeSTStatementParserRuleCall_4_0 = (RuleCall)cCodeAssignment_4.eContents().get(0);
		private final Keyword cEND_FUNCTIONKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//FunctionDefinition:
		//    'FUNCTION' name=ID (':' returnType=[datatype::DataType])?
		//        (varDeclarations+=VarDeclaration | varTempDeclarations+=VarTempDeclarationBlock |
		//        varInpuDeclarations+=VarInputDeclarationBlock | varOutputDeclarations+=VarOutputDeclarationBlock)*
		//        code += STStatement*
		//    'END_FUNCTION';
		@Override public ParserRule getRule() { return rule; }
		
		//'FUNCTION' name=ID (':' returnType=[datatype::DataType])?
		//    (varDeclarations+=VarDeclaration | varTempDeclarations+=VarTempDeclarationBlock |
		//    varInpuDeclarations+=VarInputDeclarationBlock | varOutputDeclarations+=VarOutputDeclarationBlock)*
		//    code += STStatement*
		//'END_FUNCTION'
		public Group getGroup() { return cGroup; }
		
		//'FUNCTION'
		public Keyword getFUNCTIONKeyword_0() { return cFUNCTIONKeyword_0; }
		
		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }
		
		//(':' returnType=[datatype::DataType])?
		public Group getGroup_2() { return cGroup_2; }
		
		//':'
		public Keyword getColonKeyword_2_0() { return cColonKeyword_2_0; }
		
		//returnType=[datatype::DataType]
		public Assignment getReturnTypeAssignment_2_1() { return cReturnTypeAssignment_2_1; }
		
		//[datatype::DataType]
		public CrossReference getReturnTypeDataTypeCrossReference_2_1_0() { return cReturnTypeDataTypeCrossReference_2_1_0; }
		
		//ID
		public RuleCall getReturnTypeDataTypeIDTerminalRuleCall_2_1_0_1() { return cReturnTypeDataTypeIDTerminalRuleCall_2_1_0_1; }
		
		//(varDeclarations+=VarDeclaration | varTempDeclarations+=VarTempDeclarationBlock |
		//varInpuDeclarations+=VarInputDeclarationBlock | varOutputDeclarations+=VarOutputDeclarationBlock)*
		public Alternatives getAlternatives_3() { return cAlternatives_3; }
		
		//varDeclarations+=VarDeclaration
		public Assignment getVarDeclarationsAssignment_3_0() { return cVarDeclarationsAssignment_3_0; }
		
		//VarDeclaration
		public RuleCall getVarDeclarationsVarDeclarationParserRuleCall_3_0_0() { return cVarDeclarationsVarDeclarationParserRuleCall_3_0_0; }
		
		//varTempDeclarations+=VarTempDeclarationBlock
		public Assignment getVarTempDeclarationsAssignment_3_1() { return cVarTempDeclarationsAssignment_3_1; }
		
		//VarTempDeclarationBlock
		public RuleCall getVarTempDeclarationsVarTempDeclarationBlockParserRuleCall_3_1_0() { return cVarTempDeclarationsVarTempDeclarationBlockParserRuleCall_3_1_0; }
		
		//varInpuDeclarations+=VarInputDeclarationBlock
		public Assignment getVarInpuDeclarationsAssignment_3_2() { return cVarInpuDeclarationsAssignment_3_2; }
		
		//VarInputDeclarationBlock
		public RuleCall getVarInpuDeclarationsVarInputDeclarationBlockParserRuleCall_3_2_0() { return cVarInpuDeclarationsVarInputDeclarationBlockParserRuleCall_3_2_0; }
		
		//varOutputDeclarations+=VarOutputDeclarationBlock
		public Assignment getVarOutputDeclarationsAssignment_3_3() { return cVarOutputDeclarationsAssignment_3_3; }
		
		//VarOutputDeclarationBlock
		public RuleCall getVarOutputDeclarationsVarOutputDeclarationBlockParserRuleCall_3_3_0() { return cVarOutputDeclarationsVarOutputDeclarationBlockParserRuleCall_3_3_0; }
		
		//code += STStatement*
		public Assignment getCodeAssignment_4() { return cCodeAssignment_4; }
		
		//STStatement
		public RuleCall getCodeSTStatementParserRuleCall_4_0() { return cCodeSTStatementParserRuleCall_4_0; }
		
		//'END_FUNCTION'
		public Keyword getEND_FUNCTIONKeyword_5() { return cEND_FUNCTIONKeyword_5; }
	}
	
	
	private final STFunctionElements pSTFunction;
	private final FunctionDefinitionElements pFunctionDefinition;
	
	private final Grammar grammar;
	
	private final STCoreGrammarAccess gaSTCore;

	@Inject
	public STFunctionGrammarAccess(GrammarProvider grammarProvider,
			STCoreGrammarAccess gaSTCore) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaSTCore = gaSTCore;
		this.pSTFunction = new STFunctionElements();
		this.pFunctionDefinition = new FunctionDefinitionElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.foridac.ide.structuredtextfunctioneditor.STFunction".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public STCoreGrammarAccess getSTCoreGrammarAccess() {
		return gaSTCore;
	}

	
	//STFunction:
	//    functions+=FunctionDefinition*;
	public STFunctionElements getSTFunctionAccess() {
		return pSTFunction;
	}
	
	public ParserRule getSTFunctionRule() {
		return getSTFunctionAccess().getRule();
	}
	
	//FunctionDefinition:
	//    'FUNCTION' name=ID (':' returnType=[datatype::DataType])?
	//        (varDeclarations+=VarDeclaration | varTempDeclarations+=VarTempDeclarationBlock |
	//        varInpuDeclarations+=VarInputDeclarationBlock | varOutputDeclarations+=VarOutputDeclarationBlock)*
	//        code += STStatement*
	//    'END_FUNCTION';
	public FunctionDefinitionElements getFunctionDefinitionAccess() {
		return pFunctionDefinition;
	}
	
	public ParserRule getFunctionDefinitionRule() {
		return getFunctionDefinitionAccess().getRule();
	}
	
	//Code:
	//    statements+=STStatement*;
	public STCoreGrammarAccess.CodeElements getCodeAccess() {
		return gaSTCore.getCodeAccess();
	}
	
	public ParserRule getCodeRule() {
		return getCodeAccess().getRule();
	}
	
	//VarDeclarationBlock returns VarDeclarationBlock:
	//    {VarDeclarationBlock} 'VAR' (constant?='CONSTANT')?
	//    varDeclarations+=VarDeclaration*
	//    'END_VAR';
	public STCoreGrammarAccess.VarDeclarationBlockElements getVarDeclarationBlockAccess() {
		return gaSTCore.getVarDeclarationBlockAccess();
	}
	
	public ParserRule getVarDeclarationBlockRule() {
		return getVarDeclarationBlockAccess().getRule();
	}
	
	//VarTempDeclarationBlock returns VarDeclarationBlock:
	//    {VarDeclarationBlock} 'VAR_TEMP' (constant?='CONSTANT')?
	//    varDeclarations+=VarDeclaration*
	//    'END_VAR';
	public STCoreGrammarAccess.VarTempDeclarationBlockElements getVarTempDeclarationBlockAccess() {
		return gaSTCore.getVarTempDeclarationBlockAccess();
	}
	
	public ParserRule getVarTempDeclarationBlockRule() {
		return getVarTempDeclarationBlockAccess().getRule();
	}
	
	//VarInputDeclarationBlock returns VarDeclarationBlock:
	//    {VarDeclarationBlock} 'VAR_INPUT' (constant?='CONSTANT')?
	//    varDeclarations+=VarDeclaration*
	//    'END_VAR';
	public STCoreGrammarAccess.VarInputDeclarationBlockElements getVarInputDeclarationBlockAccess() {
		return gaSTCore.getVarInputDeclarationBlockAccess();
	}
	
	public ParserRule getVarInputDeclarationBlockRule() {
		return getVarInputDeclarationBlockAccess().getRule();
	}
	
	//VarOutputDeclarationBlock returns VarDeclarationBlock:
	//    {VarDeclarationBlock} 'VAR_OUTPUT' (constant?='CONSTANT')?
	//    varDeclarations+=VarDeclaration*
	//    'END_VAR';
	public STCoreGrammarAccess.VarOutputDeclarationBlockElements getVarOutputDeclarationBlockAccess() {
		return gaSTCore.getVarOutputDeclarationBlockAccess();
	}
	
	public ParserRule getVarOutputDeclarationBlockRule() {
		return getVarOutputDeclarationBlockAccess().getRule();
	}
	
	//VarDeclaration returns libraryElement::INamedElement:
	//    {VarDeclaration}
	//    name=ID ('AT' locatedAt=[libraryElement::INamedElement])? ':' (array?='ARRAY' (('[' ranges+=(STExpression) (','
	//    ranges+=STExpression)* ']') | ('[' count+='*' (',' count+='*')* ']')) 'OF')? (type=[libraryElement::LibraryElement]) ('[' maxLength=STExpression ']')? (':='
	//    defaultValue=InitializerExpression)? ';';
	public STCoreGrammarAccess.VarDeclarationElements getVarDeclarationAccess() {
		return gaSTCore.getVarDeclarationAccess();
	}
	
	public ParserRule getVarDeclarationRule() {
		return getVarDeclarationAccess().getRule();
	}
	
	//InitializerExpression:
	//    STExpression | ArrayInitializerExpression;
	public STCoreGrammarAccess.InitializerExpressionElements getInitializerExpressionAccess() {
		return gaSTCore.getInitializerExpressionAccess();
	}
	
	public ParserRule getInitializerExpressionRule() {
		return getInitializerExpressionAccess().getRule();
	}
	
	//ArrayInitializerExpression:
	//    '[' values+=ArrayInitElement (',' values+=ArrayInitElement)* ']';
	public STCoreGrammarAccess.ArrayInitializerExpressionElements getArrayInitializerExpressionAccess() {
		return gaSTCore.getArrayInitializerExpressionAccess();
	}
	
	public ParserRule getArrayInitializerExpressionRule() {
		return getArrayInitializerExpressionAccess().getRule();
	}
	
	//ArrayInitElement:
	//    indexOrInitExpression=STExpression ('(' initExpression=STExpression ')')?;
	public STCoreGrammarAccess.ArrayInitElementElements getArrayInitElementAccess() {
		return gaSTCore.getArrayInitElementAccess();
	}
	
	public ParserRule getArrayInitElementRule() {
		return getArrayInitElementAccess().getRule();
	}
	
	//STStatement:
	//    (STIfStatment |
	//    STCaseStatement |
	//    STForStatement |
	//    STWhileStatement |
	//    STRepeatStatement |
	//    STAssignmentStatement |
	//    {STReturn} 'RETURN' |
	//    {STContinue} 'CONTINUE' |
	//    {STExit} 'EXIT') ';' |
	//    {STNop} ';';
	public STCoreGrammarAccess.STStatementElements getSTStatementAccess() {
		return gaSTCore.getSTStatementAccess();
	}
	
	public ParserRule getSTStatementRule() {
		return getSTStatementAccess().getRule();
	}
	
	//STAssignmentStatement:
	//    left=STAccessExpression ':=' right=STExpression
	//;
	public STCoreGrammarAccess.STAssignmentStatementElements getSTAssignmentStatementAccess() {
		return gaSTCore.getSTAssignmentStatementAccess();
	}
	
	public ParserRule getSTAssignmentStatementRule() {
		return getSTAssignmentStatementAccess().getRule();
	}
	
	//STIfStatment:
	//    'IF' condition=STExpression 'THEN' statements+=STStatement* elseifs+=(STElseIfPart)* (else=STElsePart)? 'END_IF';
	public STCoreGrammarAccess.STIfStatmentElements getSTIfStatmentAccess() {
		return gaSTCore.getSTIfStatmentAccess();
	}
	
	public ParserRule getSTIfStatmentRule() {
		return getSTIfStatmentAccess().getRule();
	}
	
	//STElseIfPart:
	//    'ELSIF' condition=STExpression 'THEN' statements+=STStatement*;
	public STCoreGrammarAccess.STElseIfPartElements getSTElseIfPartAccess() {
		return gaSTCore.getSTElseIfPartAccess();
	}
	
	public ParserRule getSTElseIfPartRule() {
		return getSTElseIfPartAccess().getRule();
	}
	
	//STCaseStatement:
	//    'CASE' selector=STExpression 'OF' cases+=STCaseCases+ (else=STElsePart)? 'END_CASE';
	public STCoreGrammarAccess.STCaseStatementElements getSTCaseStatementAccess() {
		return gaSTCore.getSTCaseStatementAccess();
	}
	
	public ParserRule getSTCaseStatementRule() {
		return getSTCaseStatementAccess().getRule();
	}
	
	//STCaseCases:
	//    conditions+=STExpression (',' conditions+=STExpression)* ':'=> statements+=STStatement*;
	public STCoreGrammarAccess.STCaseCasesElements getSTCaseCasesAccess() {
		return gaSTCore.getSTCaseCasesAccess();
	}
	
	public ParserRule getSTCaseCasesRule() {
		return getSTCaseCasesAccess().getRule();
	}
	
	//STElsePart:
	//    {STElsePart} 'ELSE' statements+=STStatement*;
	public STCoreGrammarAccess.STElsePartElements getSTElsePartAccess() {
		return gaSTCore.getSTElsePartAccess();
	}
	
	public ParserRule getSTElsePartRule() {
		return getSTElsePartAccess().getRule();
	}
	
	//STForStatement:
	//    'FOR' for=STExpression 'TO' to=STExpression ('BY' by=STExpression)? 'DO'
	//    statements+=STStatement*
	//    'END_FOR';
	public STCoreGrammarAccess.STForStatementElements getSTForStatementAccess() {
		return gaSTCore.getSTForStatementAccess();
	}
	
	public ParserRule getSTForStatementRule() {
		return getSTForStatementAccess().getRule();
	}
	
	//STWhileStatement:
	//    'WHILE' condition=STExpression 'DO'
	//    statements+=STStatement*
	//    'END_WHILE';
	public STCoreGrammarAccess.STWhileStatementElements getSTWhileStatementAccess() {
		return gaSTCore.getSTWhileStatementAccess();
	}
	
	public ParserRule getSTWhileStatementRule() {
		return getSTWhileStatementAccess().getRule();
	}
	
	//STRepeatStatement:
	//    'REPEAT'
	//    statements+=STStatement*
	//    'UNTIL' condition=STExpression
	//    'END_REPEAT';
	public STCoreGrammarAccess.STRepeatStatementElements getSTRepeatStatementAccess() {
		return gaSTCore.getSTRepeatStatementAccess();
	}
	
	public ParserRule getSTRepeatStatementRule() {
		return getSTRepeatStatementAccess().getRule();
	}
	
	//STExpression returns STExpression:
	//    STSubrangeExpression;
	public STCoreGrammarAccess.STExpressionElements getSTExpressionAccess() {
		return gaSTCore.getSTExpressionAccess();
	}
	
	public ParserRule getSTExpressionRule() {
		return getSTExpressionAccess().getRule();
	}
	
	//enum SubrangeOperator returns BinaryOperator: Range='..';
	public STCoreGrammarAccess.SubrangeOperatorElements getSubrangeOperatorAccess() {
		return gaSTCore.getSubrangeOperatorAccess();
	}
	
	public EnumRule getSubrangeOperatorRule() {
		return getSubrangeOperatorAccess().getRule();
	}
	
	//STSubrangeExpression returns STExpression:
	//    STOrExpression (({STBinaryExpression.left=current} op=SubrangeOperator) right=STOrExpression)*;
	public STCoreGrammarAccess.STSubrangeExpressionElements getSTSubrangeExpressionAccess() {
		return gaSTCore.getSTSubrangeExpressionAccess();
	}
	
	public ParserRule getSTSubrangeExpressionRule() {
		return getSTSubrangeExpressionAccess().getRule();
	}
	
	//enum OrOperator returns BinaryOperator: OR;
	public STCoreGrammarAccess.OrOperatorElements getOrOperatorAccess() {
		return gaSTCore.getOrOperatorAccess();
	}
	
	public EnumRule getOrOperatorRule() {
		return getOrOperatorAccess().getRule();
	}
	
	//STOrExpression returns STExpression:
	//    STXorExpression (({STBinaryExpression.left=current} op=OrOperator) right=STXorExpression)*;
	public STCoreGrammarAccess.STOrExpressionElements getSTOrExpressionAccess() {
		return gaSTCore.getSTOrExpressionAccess();
	}
	
	public ParserRule getSTOrExpressionRule() {
		return getSTOrExpressionAccess().getRule();
	}
	
	//enum XorOperator returns BinaryOperator: XOR;
	public STCoreGrammarAccess.XorOperatorElements getXorOperatorAccess() {
		return gaSTCore.getXorOperatorAccess();
	}
	
	public EnumRule getXorOperatorRule() {
		return getXorOperatorAccess().getRule();
	}
	
	//STXorExpression returns STExpression:
	//    STAndExpression (({STBinaryExpression.left=current} op=XorOperator) right=STAndExpression)*;
	public STCoreGrammarAccess.STXorExpressionElements getSTXorExpressionAccess() {
		return gaSTCore.getSTXorExpressionAccess();
	}
	
	public ParserRule getSTXorExpressionRule() {
		return getSTXorExpressionAccess().getRule();
	}
	
	//enum AndOperator returns BinaryOperator: AND | AMPERSAND='&';
	public STCoreGrammarAccess.AndOperatorElements getAndOperatorAccess() {
		return gaSTCore.getAndOperatorAccess();
	}
	
	public EnumRule getAndOperatorRule() {
		return getAndOperatorAccess().getRule();
	}
	
	//STAndExpression returns STExpression:
	//    STEqualityExpression (({STBinaryExpression.left=current} op=AndOperator) right=STEqualityExpression)*;
	public STCoreGrammarAccess.STAndExpressionElements getSTAndExpressionAccess() {
		return gaSTCore.getSTAndExpressionAccess();
	}
	
	public ParserRule getSTAndExpressionRule() {
		return getSTAndExpressionAccess().getRule();
	}
	
	//enum EqualityOperator returns BinaryOperator: EQ='=' | NE='<>';
	public STCoreGrammarAccess.EqualityOperatorElements getEqualityOperatorAccess() {
		return gaSTCore.getEqualityOperatorAccess();
	}
	
	public EnumRule getEqualityOperatorRule() {
		return getEqualityOperatorAccess().getRule();
	}
	
	//STEqualityExpression returns STExpression:
	//    STComparisonExpression (({STBinaryExpression.left=current} op=EqualityOperator) right=STComparisonExpression)*;
	public STCoreGrammarAccess.STEqualityExpressionElements getSTEqualityExpressionAccess() {
		return gaSTCore.getSTEqualityExpressionAccess();
	}
	
	public ParserRule getSTEqualityExpressionRule() {
		return getSTEqualityExpressionAccess().getRule();
	}
	
	//enum CompareOperator returns BinaryOperator: LT='<' | LE='<=' | GT='>' | GE='>=';
	public STCoreGrammarAccess.CompareOperatorElements getCompareOperatorAccess() {
		return gaSTCore.getCompareOperatorAccess();
	}
	
	public EnumRule getCompareOperatorRule() {
		return getCompareOperatorAccess().getRule();
	}
	
	//STComparisonExpression returns STExpression:
	//    STAddSubExpression (({STBinaryExpression.left=current} op=CompareOperator) right=STAddSubExpression)*;
	public STCoreGrammarAccess.STComparisonExpressionElements getSTComparisonExpressionAccess() {
		return gaSTCore.getSTComparisonExpressionAccess();
	}
	
	public ParserRule getSTComparisonExpressionRule() {
		return getSTComparisonExpressionAccess().getRule();
	}
	
	//enum AddSubOperator returns BinaryOperator: ADD='+' | SUB='-';
	public STCoreGrammarAccess.AddSubOperatorElements getAddSubOperatorAccess() {
		return gaSTCore.getAddSubOperatorAccess();
	}
	
	public EnumRule getAddSubOperatorRule() {
		return getAddSubOperatorAccess().getRule();
	}
	
	//STAddSubExpression returns STExpression:
	//    STMulDivModExpression (({STBinaryExpression.left=current} op=AddSubOperator) right=STMulDivModExpression)*;
	public STCoreGrammarAccess.STAddSubExpressionElements getSTAddSubExpressionAccess() {
		return gaSTCore.getSTAddSubExpressionAccess();
	}
	
	public ParserRule getSTAddSubExpressionRule() {
		return getSTAddSubExpressionAccess().getRule();
	}
	
	//enum MulDivModOperator returns BinaryOperator: MUL='*' | DIV='/' | MOD;
	public STCoreGrammarAccess.MulDivModOperatorElements getMulDivModOperatorAccess() {
		return gaSTCore.getMulDivModOperatorAccess();
	}
	
	public EnumRule getMulDivModOperatorRule() {
		return getMulDivModOperatorAccess().getRule();
	}
	
	//STMulDivModExpression returns STExpression:
	//    STPowerExpression (({STBinaryExpression.left=current} op=MulDivModOperator) right=STPowerExpression)*;
	public STCoreGrammarAccess.STMulDivModExpressionElements getSTMulDivModExpressionAccess() {
		return gaSTCore.getSTMulDivModExpressionAccess();
	}
	
	public ParserRule getSTMulDivModExpressionRule() {
		return getSTMulDivModExpressionAccess().getRule();
	}
	
	//enum PowerOperator returns BinaryOperator: POWER='**';
	public STCoreGrammarAccess.PowerOperatorElements getPowerOperatorAccess() {
		return gaSTCore.getPowerOperatorAccess();
	}
	
	public EnumRule getPowerOperatorRule() {
		return getPowerOperatorAccess().getRule();
	}
	
	//STPowerExpression returns STExpression:
	//    STUnaryExpression (({STBinaryExpression.left=current} op=PowerOperator) right=STUnaryExpression)*;
	public STCoreGrammarAccess.STPowerExpressionElements getSTPowerExpressionAccess() {
		return gaSTCore.getSTPowerExpressionAccess();
	}
	
	public ParserRule getSTPowerExpressionRule() {
		return getSTPowerExpressionAccess().getRule();
	}
	
	//enum UnaryOperator returns UnaryOperator: MINUS='-' | PLUS='+' | NOT;
	public STCoreGrammarAccess.UnaryOperatorElements getUnaryOperatorAccess() {
		return gaSTCore.getUnaryOperatorAccess();
	}
	
	public EnumRule getUnaryOperatorRule() {
		return getUnaryOperatorAccess().getRule();
	}
	
	//STUnaryExpression returns STExpression:
	//    => STAccessExpression | ({STUnaryExpression} op=UnaryOperator expression=STUnaryExpression);
	public STCoreGrammarAccess.STUnaryExpressionElements getSTUnaryExpressionAccess() {
		return gaSTCore.getSTUnaryExpressionAccess();
	}
	
	public ParserRule getSTUnaryExpressionRule() {
		return getSTUnaryExpressionAccess().getRule();
	}
	
	//STAccessExpression returns STExpression:
	//    STPrimaryExpression (({STMemberAccessExpression.receiver=current} '.' member=(STFeatureExpression |
	//    STMultibitPartialExpression)) |
	//    ({STArrayAccessExpression.receiver=current} '[' index+=STExpression (',' index+=STExpression)* ']'))*;
	public STCoreGrammarAccess.STAccessExpressionElements getSTAccessExpressionAccess() {
		return gaSTCore.getSTAccessExpressionAccess();
	}
	
	public ParserRule getSTAccessExpressionRule() {
		return getSTAccessExpressionAccess().getRule();
	}
	
	//STPrimaryExpression returns STExpression:
	//    '(' STExpression ')' | STFeatureExpression | STLiteralExpressions;
	public STCoreGrammarAccess.STPrimaryExpressionElements getSTPrimaryExpressionAccess() {
		return gaSTCore.getSTPrimaryExpressionAccess();
	}
	
	public ParserRule getSTPrimaryExpressionRule() {
		return getSTPrimaryExpressionAccess().getRule();
	}
	
	//STFeatureExpression returns STExpression:
	//    {STFeatureExpression} feature=[libraryElement::INamedElement] ( => '(' (parameters+=STExpression (',' parameters+=STExpression)* )? ')' )?;
	public STCoreGrammarAccess.STFeatureExpressionElements getSTFeatureExpressionAccess() {
		return gaSTCore.getSTFeatureExpressionAccess();
	}
	
	public ParserRule getSTFeatureExpressionRule() {
		return getSTFeatureExpressionAccess().getRule();
	}
	
	//enum STMultiBitAccessSpecifier:
	//    L='%L' | D='%D' | W='%W' | B='%B' | X='%X';
	public STCoreGrammarAccess.STMultiBitAccessSpecifierElements getSTMultiBitAccessSpecifierAccess() {
		return gaSTCore.getSTMultiBitAccessSpecifierAccess();
	}
	
	public EnumRule getSTMultiBitAccessSpecifierRule() {
		return getSTMultiBitAccessSpecifierAccess().getRule();
	}
	
	//STMultibitPartialExpression returns STExpression:
	//    {STMultibitPartialExpression} (specifier=STMultiBitAccessSpecifier)? index=INT;
	public STCoreGrammarAccess.STMultibitPartialExpressionElements getSTMultibitPartialExpressionAccess() {
		return gaSTCore.getSTMultibitPartialExpressionAccess();
	}
	
	public ParserRule getSTMultibitPartialExpressionRule() {
		return getSTMultibitPartialExpressionAccess().getRule();
	}
	
	//STLiteralExpressions returns STExpression:
	//    STNumericLiteral |
	//    STDateLiteral |
	//    STTimeLiteral |
	//    STTimeOfDayLiteral |
	//    STDateAndTimeLiteral |
	//    STStringLiteral;
	public STCoreGrammarAccess.STLiteralExpressionsElements getSTLiteralExpressionsAccess() {
		return gaSTCore.getSTLiteralExpressionsAccess();
	}
	
	public ParserRule getSTLiteralExpressionsRule() {
		return getSTLiteralExpressionsAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STNumericLiteralType returns datatype::DataType:
	//    'BOOL#' |
	//    'BYTE#' |
	//    'WORD#' |
	//    'DWORD#' |
	//    'LWORD#' |
	//    'SINT#' |
	//    'INT#' |
	//    'DINT#' |
	//    'LINT#' |
	//    'USINT#' |
	//    'UINT#' |
	//    'UDINT#' |
	//    'ULINT#' |
	//    'REAL#' |
	//    'LREAL#'
	//;
	public STCoreGrammarAccess.STNumericLiteralTypeElements getSTNumericLiteralTypeAccess() {
		return gaSTCore.getSTNumericLiteralTypeAccess();
	}
	
	public ParserRule getSTNumericLiteralTypeRule() {
		return getSTNumericLiteralTypeAccess().getRule();
	}
	
	//STNumericLiteral:
	//    (type=STNumericLiteralType)?
	//    value=(BoolLiteral | Number | NON_DECIMAL);
	public STCoreGrammarAccess.STNumericLiteralElements getSTNumericLiteralAccess() {
		return gaSTCore.getSTNumericLiteralAccess();
	}
	
	public ParserRule getSTNumericLiteralRule() {
		return getSTNumericLiteralAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STDateLiteralType returns datatype::DataType:
	//    'DATE#' |
	//    'LDATE#' |
	//    'D#' |
	//    'LD#'
	//;
	public STCoreGrammarAccess.STDateLiteralTypeElements getSTDateLiteralTypeAccess() {
		return gaSTCore.getSTDateLiteralTypeAccess();
	}
	
	public ParserRule getSTDateLiteralTypeRule() {
		return getSTDateLiteralTypeAccess().getRule();
	}
	
	//STDateLiteral:
	//    type=STDateLiteralType value=Date;
	public STCoreGrammarAccess.STDateLiteralElements getSTDateLiteralAccess() {
		return gaSTCore.getSTDateLiteralAccess();
	}
	
	public ParserRule getSTDateLiteralRule() {
		return getSTDateLiteralAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STTimeLiteralType returns datatype::DataType:
	//    'TIME#' |
	//    'LTIME#' |
	//    'T#' |
	//    'LT#'
	//;
	public STCoreGrammarAccess.STTimeLiteralTypeElements getSTTimeLiteralTypeAccess() {
		return gaSTCore.getSTTimeLiteralTypeAccess();
	}
	
	public ParserRule getSTTimeLiteralTypeRule() {
		return getSTTimeLiteralTypeAccess().getRule();
	}
	
	//STTimeLiteral:
	//    type=STTimeLiteralType value=Time;
	public STCoreGrammarAccess.STTimeLiteralElements getSTTimeLiteralAccess() {
		return gaSTCore.getSTTimeLiteralAccess();
	}
	
	public ParserRule getSTTimeLiteralRule() {
		return getSTTimeLiteralAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STTimeOfDayLiteralType returns datatype::DataType:
	//    'TIME_OF_DAY#' |
	//    'TOD#' |
	//    'LTOD#'
	//;
	public STCoreGrammarAccess.STTimeOfDayLiteralTypeElements getSTTimeOfDayLiteralTypeAccess() {
		return gaSTCore.getSTTimeOfDayLiteralTypeAccess();
	}
	
	public ParserRule getSTTimeOfDayLiteralTypeRule() {
		return getSTTimeOfDayLiteralTypeAccess().getRule();
	}
	
	//STTimeOfDayLiteral:
	//    type=STTimeOfDayLiteralType value=TimeOfDay;
	public STCoreGrammarAccess.STTimeOfDayLiteralElements getSTTimeOfDayLiteralAccess() {
		return gaSTCore.getSTTimeOfDayLiteralAccess();
	}
	
	public ParserRule getSTTimeOfDayLiteralRule() {
		return getSTTimeOfDayLiteralAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STDateAndTimeLiteralType returns datatype::DataType:
	//    'DATE_AND_TIME#' |
	//    'LDATE_AND_TIME#' |
	//    'DT#' |
	//    'LDT#'
	//;
	public STCoreGrammarAccess.STDateAndTimeLiteralTypeElements getSTDateAndTimeLiteralTypeAccess() {
		return gaSTCore.getSTDateAndTimeLiteralTypeAccess();
	}
	
	public ParserRule getSTDateAndTimeLiteralTypeRule() {
		return getSTDateAndTimeLiteralTypeAccess().getRule();
	}
	
	//STDateAndTimeLiteral:
	//    type=STDateAndTimeLiteralType dateValue=Date '-' timeOfDayValue=TimeOfDay;
	public STCoreGrammarAccess.STDateAndTimeLiteralElements getSTDateAndTimeLiteralAccess() {
		return gaSTCore.getSTDateAndTimeLiteralAccess();
	}
	
	public ParserRule getSTDateAndTimeLiteralRule() {
		return getSTDateAndTimeLiteralAccess().getRule();
	}
	
	//// DataType is abstract, so no object creation! ValueConverter will provide the concrete type
	//STStringLiteralType returns datatype::DataType:
	//    'STRING#' |
	//    'WSTRING#' |
	//    'CHAR#' |
	//    'WCHAR#'
	//;
	public STCoreGrammarAccess.STStringLiteralTypeElements getSTStringLiteralTypeAccess() {
		return gaSTCore.getSTStringLiteralTypeAccess();
	}
	
	public ParserRule getSTStringLiteralTypeRule() {
		return getSTStringLiteralTypeAccess().getRule();
	}
	
	//STStringLiteral:
	//    (type=STStringLiteralType)? value=(STRING|WSTRING);
	public STCoreGrammarAccess.STStringLiteralElements getSTStringLiteralAccess() {
		return gaSTCore.getSTStringLiteralAccess();
	}
	
	public ParserRule getSTStringLiteralRule() {
		return getSTStringLiteralAccess().getRule();
	}
	
	//QualifiedName:
	//    ID ('.' ID)*;
	public STCoreGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaSTCore.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}
	
	//// BOOLs are internally always stored as numerical value. 0 = FALSE, 1 = TRUE
	//BoolLiteral returns ecore::EBigDecimal:
	//    'TRUE' | 'FALSE'
	//;
	public STCoreGrammarAccess.BoolLiteralElements getBoolLiteralAccess() {
		return gaSTCore.getBoolLiteralAccess();
	}
	
	public ParserRule getBoolLiteralRule() {
		return getBoolLiteralAccess().getRule();
	}
	
	//Number returns ecore::EBigDecimal:
	//    ('+' | '-')? INT (=> '.' (EXT_INT | INT))?;
	public STCoreGrammarAccess.NumberElements getNumberAccess() {
		return gaSTCore.getNumberAccess();
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}
	
	//Date returns ecore::EDate:
	//    INT '-' INT '-' INT;
	public STCoreGrammarAccess.DateElements getDateAccess() {
		return gaSTCore.getDateAccess();
	}
	
	public ParserRule getDateRule() {
		return getDateAccess().getRule();
	}
	
	//TimeOfDay:
	//    INT ':' INT ':' INT (=> '.' INT)?;
	public STCoreGrammarAccess.TimeOfDayElements getTimeOfDayAccess() {
		return gaSTCore.getTimeOfDayAccess();
	}
	
	public ParserRule getTimeOfDayRule() {
		return getTimeOfDayAccess().getRule();
	}
	
	//Time:
	//    (Number ('D' | 'H' | 'M' | 'S' | 'MS' | 'US' | 'NS') ('_')?)+;
	public STCoreGrammarAccess.TimeElements getTimeAccess() {
		return gaSTCore.getTimeAccess();
	}
	
	public ParserRule getTimeRule() {
		return getTimeAccess().getRule();
	}
	
	//terminal fragment HEX_DIGIT:
	//    '0'..'9' | 'a'..'f' | 'A'..'F' | '_';
	public TerminalRule getHEX_DIGITRule() {
		return gaSTCore.getHEX_DIGITRule();
	}
	
	//terminal NON_DECIMAL returns ecore::EBigDecimal:
	//    ('2#' | '8#' | '16#') HEX_DIGIT+;
	public TerminalRule getNON_DECIMALRule() {
		return gaSTCore.getNON_DECIMALRule();
	}
	
	//terminal EXT_INT:
	//    INT ('e' | 'E') ('-' | '+')? INT;
	public TerminalRule getEXT_INTRule() {
		return gaSTCore.getEXT_INTRule();
	}
	
	//terminal INT returns ecore::EBigInteger:
	//    ('0'..'9') ('_'? '0'..'9')*;
	public TerminalRule getINTRule() {
		return gaSTCore.getINTRule();
	}
	
	//terminal ID:
	//    '^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaSTCore.getIDRule();
	}
	
	//terminal STRING returns ecore::EString:
	//    '"' ('$' . /* 'L'|'N'|'P'|'R'|'T'|'"'|'$' */ | !('$' | '"'))* '"';
	public TerminalRule getSTRINGRule() {
		return gaSTCore.getSTRINGRule();
	}
	
	//terminal WSTRING returns ecore::EString:
	//    "'" ('$' . /* "L"|"N"|"P"|"R"|"T"|"'"|"$" */ | !('$' | "'"))* "'";
	public TerminalRule getWSTRINGRule() {
		return gaSTCore.getWSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//    '/*'->'*/' | '(*'->'*)';
	public TerminalRule getML_COMMENTRule() {
		return gaSTCore.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT:
	//    '//' !('\n' | '\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaSTCore.getSL_COMMENTRule();
	}
	
	//terminal WS:
	//    (' ' | '\t' | '\r' | '\n')+;
	public TerminalRule getWSRule() {
		return gaSTCore.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//    .;
	public TerminalRule getANY_OTHERRule() {
		return gaSTCore.getANY_OTHERRule();
	}
}
