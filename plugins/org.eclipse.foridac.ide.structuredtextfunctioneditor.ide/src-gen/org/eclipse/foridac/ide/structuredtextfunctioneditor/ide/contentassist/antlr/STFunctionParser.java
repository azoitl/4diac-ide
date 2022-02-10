/*
 * generated by Xtext 2.25.0
 */
package org.eclipse.foridac.ide.structuredtextfunctioneditor.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.foridac.ide.structuredtextfunctioneditor.ide.contentassist.antlr.internal.InternalSTFunctionParser;
import org.eclipse.foridac.ide.structuredtextfunctioneditor.services.STFunctionGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class STFunctionParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(STFunctionGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, STFunctionGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getFunctionDefinitionAccess().getAlternatives_4(), "rule__FunctionDefinition__Alternatives_4");
			builder.put(grammarAccess.getVarDeclarationAccess().getAlternatives_4_1(), "rule__VarDeclaration__Alternatives_4_1");
			builder.put(grammarAccess.getInitializerExpressionAccess().getAlternatives(), "rule__InitializerExpression__Alternatives");
			builder.put(grammarAccess.getSTStatementAccess().getAlternatives(), "rule__STStatement__Alternatives");
			builder.put(grammarAccess.getSTStatementAccess().getAlternatives_0_0(), "rule__STStatement__Alternatives_0_0");
			builder.put(grammarAccess.getSTCallArgumentAccess().getAlternatives(), "rule__STCallArgument__Alternatives");
			builder.put(grammarAccess.getSTUnaryExpressionAccess().getAlternatives(), "rule__STUnaryExpression__Alternatives");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getAlternatives_1(), "rule__STAccessExpression__Alternatives_1");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getMemberAlternatives_1_0_2_0(), "rule__STAccessExpression__MemberAlternatives_1_0_2_0");
			builder.put(grammarAccess.getSTPrimaryExpressionAccess().getAlternatives(), "rule__STPrimaryExpression__Alternatives");
			builder.put(grammarAccess.getSTLiteralExpressionsAccess().getAlternatives(), "rule__STLiteralExpressions__Alternatives");
			builder.put(grammarAccess.getSTNumericLiteralTypeAccess().getAlternatives(), "rule__STNumericLiteralType__Alternatives");
			builder.put(grammarAccess.getSTNumericLiteralAccess().getValueAlternatives_1_0(), "rule__STNumericLiteral__ValueAlternatives_1_0");
			builder.put(grammarAccess.getSTDateLiteralTypeAccess().getAlternatives(), "rule__STDateLiteralType__Alternatives");
			builder.put(grammarAccess.getSTTimeLiteralTypeAccess().getAlternatives(), "rule__STTimeLiteralType__Alternatives");
			builder.put(grammarAccess.getSTStringLiteralAccess().getValueAlternatives_1_0(), "rule__STStringLiteral__ValueAlternatives_1_0");
			builder.put(grammarAccess.getSTAnyTypeAccess().getAlternatives(), "rule__STAnyType__Alternatives");
			builder.put(grammarAccess.getSTAnyBuiltinTypeAccess().getAlternatives(), "rule__STAnyBuiltinType__Alternatives");
			builder.put(grammarAccess.getSTAnyBitTypeAccess().getAlternatives(), "rule__STAnyBitType__Alternatives");
			builder.put(grammarAccess.getSTAnyNumTypeAccess().getAlternatives(), "rule__STAnyNumType__Alternatives");
			builder.put(grammarAccess.getSTAnyDurationTypeAccess().getAlternatives(), "rule__STAnyDurationType__Alternatives");
			builder.put(grammarAccess.getSTAnyDateTypeAccess().getAlternatives(), "rule__STAnyDateType__Alternatives");
			builder.put(grammarAccess.getSTDateTypeAccess().getAlternatives(), "rule__STDateType__Alternatives");
			builder.put(grammarAccess.getSTTimeOfDayTypeAccess().getAlternatives(), "rule__STTimeOfDayType__Alternatives");
			builder.put(grammarAccess.getSTDateAndTimeTypeAccess().getAlternatives(), "rule__STDateAndTimeType__Alternatives");
			builder.put(grammarAccess.getSTAnyCharsTypeAccess().getAlternatives(), "rule__STAnyCharsType__Alternatives");
			builder.put(grammarAccess.getBoolLiteralAccess().getAlternatives(), "rule__BoolLiteral__Alternatives");
			builder.put(grammarAccess.getNumberAccess().getAlternatives_0(), "rule__Number__Alternatives_0");
			builder.put(grammarAccess.getNumberAccess().getAlternatives_2_1(), "rule__Number__Alternatives_2_1");
			builder.put(grammarAccess.getTimeAccess().getAlternatives_1(), "rule__Time__Alternatives_1");
			builder.put(grammarAccess.getAndOperatorAccess().getAlternatives(), "rule__AndOperator__Alternatives");
			builder.put(grammarAccess.getEqualityOperatorAccess().getAlternatives(), "rule__EqualityOperator__Alternatives");
			builder.put(grammarAccess.getCompareOperatorAccess().getAlternatives(), "rule__CompareOperator__Alternatives");
			builder.put(grammarAccess.getAddSubOperatorAccess().getAlternatives(), "rule__AddSubOperator__Alternatives");
			builder.put(grammarAccess.getMulDivModOperatorAccess().getAlternatives(), "rule__MulDivModOperator__Alternatives");
			builder.put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
			builder.put(grammarAccess.getSTMultiBitAccessSpecifierAccess().getAlternatives(), "rule__STMultiBitAccessSpecifier__Alternatives");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getGroup(), "rule__FunctionDefinition__Group__0");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getGroup_3(), "rule__FunctionDefinition__Group_3__0");
			builder.put(grammarAccess.getVarDeclarationBlockAccess().getGroup(), "rule__VarDeclarationBlock__Group__0");
			builder.put(grammarAccess.getVarTempDeclarationBlockAccess().getGroup(), "rule__VarTempDeclarationBlock__Group__0");
			builder.put(grammarAccess.getVarInputDeclarationBlockAccess().getGroup(), "rule__VarInputDeclarationBlock__Group__0");
			builder.put(grammarAccess.getVarOutputDeclarationBlockAccess().getGroup(), "rule__VarOutputDeclarationBlock__Group__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup(), "rule__VarDeclaration__Group__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_2(), "rule__VarDeclaration__Group_2__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_4(), "rule__VarDeclaration__Group_4__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_4_1_0(), "rule__VarDeclaration__Group_4_1_0__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_4_1_0_2(), "rule__VarDeclaration__Group_4_1_0_2__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_4_1_1(), "rule__VarDeclaration__Group_4_1_1__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_4_1_1_2(), "rule__VarDeclaration__Group_4_1_1_2__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_6(), "rule__VarDeclaration__Group_6__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_7(), "rule__VarDeclaration__Group_7__0");
			builder.put(grammarAccess.getArrayInitializerExpressionAccess().getGroup(), "rule__ArrayInitializerExpression__Group__0");
			builder.put(grammarAccess.getArrayInitializerExpressionAccess().getGroup_2(), "rule__ArrayInitializerExpression__Group_2__0");
			builder.put(grammarAccess.getArrayInitElementAccess().getGroup(), "rule__ArrayInitElement__Group__0");
			builder.put(grammarAccess.getArrayInitElementAccess().getGroup_1(), "rule__ArrayInitElement__Group_1__0");
			builder.put(grammarAccess.getSTStatementAccess().getGroup_0(), "rule__STStatement__Group_0__0");
			builder.put(grammarAccess.getSTStatementAccess().getGroup_0_0_7(), "rule__STStatement__Group_0_0_7__0");
			builder.put(grammarAccess.getSTStatementAccess().getGroup_0_0_8(), "rule__STStatement__Group_0_0_8__0");
			builder.put(grammarAccess.getSTStatementAccess().getGroup_0_0_9(), "rule__STStatement__Group_0_0_9__0");
			builder.put(grammarAccess.getSTStatementAccess().getGroup_1(), "rule__STStatement__Group_1__0");
			builder.put(grammarAccess.getSTAssignmentStatementAccess().getGroup(), "rule__STAssignmentStatement__Group__0");
			builder.put(grammarAccess.getSTCallNamedInputArgumentAccess().getGroup(), "rule__STCallNamedInputArgument__Group__0");
			builder.put(grammarAccess.getSTCallNamedOutputArgumentAccess().getGroup(), "rule__STCallNamedOutputArgument__Group__0");
			builder.put(grammarAccess.getSTIfStatementAccess().getGroup(), "rule__STIfStatement__Group__0");
			builder.put(grammarAccess.getSTElseIfPartAccess().getGroup(), "rule__STElseIfPart__Group__0");
			builder.put(grammarAccess.getSTCaseStatementAccess().getGroup(), "rule__STCaseStatement__Group__0");
			builder.put(grammarAccess.getSTCaseCasesAccess().getGroup(), "rule__STCaseCases__Group__0");
			builder.put(grammarAccess.getSTCaseCasesAccess().getGroup_1(), "rule__STCaseCases__Group_1__0");
			builder.put(grammarAccess.getSTElsePartAccess().getGroup(), "rule__STElsePart__Group__0");
			builder.put(grammarAccess.getSTForStatementAccess().getGroup(), "rule__STForStatement__Group__0");
			builder.put(grammarAccess.getSTForStatementAccess().getGroup_6(), "rule__STForStatement__Group_6__0");
			builder.put(grammarAccess.getSTWhileStatementAccess().getGroup(), "rule__STWhileStatement__Group__0");
			builder.put(grammarAccess.getSTRepeatStatementAccess().getGroup(), "rule__STRepeatStatement__Group__0");
			builder.put(grammarAccess.getSTSubrangeExpressionAccess().getGroup(), "rule__STSubrangeExpression__Group__0");
			builder.put(grammarAccess.getSTSubrangeExpressionAccess().getGroup_1(), "rule__STSubrangeExpression__Group_1__0");
			builder.put(grammarAccess.getSTSubrangeExpressionAccess().getGroup_1_0(), "rule__STSubrangeExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTOrExpressionAccess().getGroup(), "rule__STOrExpression__Group__0");
			builder.put(grammarAccess.getSTOrExpressionAccess().getGroup_1(), "rule__STOrExpression__Group_1__0");
			builder.put(grammarAccess.getSTOrExpressionAccess().getGroup_1_0(), "rule__STOrExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTXorExpressionAccess().getGroup(), "rule__STXorExpression__Group__0");
			builder.put(grammarAccess.getSTXorExpressionAccess().getGroup_1(), "rule__STXorExpression__Group_1__0");
			builder.put(grammarAccess.getSTXorExpressionAccess().getGroup_1_0(), "rule__STXorExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTAndExpressionAccess().getGroup(), "rule__STAndExpression__Group__0");
			builder.put(grammarAccess.getSTAndExpressionAccess().getGroup_1(), "rule__STAndExpression__Group_1__0");
			builder.put(grammarAccess.getSTAndExpressionAccess().getGroup_1_0(), "rule__STAndExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTEqualityExpressionAccess().getGroup(), "rule__STEqualityExpression__Group__0");
			builder.put(grammarAccess.getSTEqualityExpressionAccess().getGroup_1(), "rule__STEqualityExpression__Group_1__0");
			builder.put(grammarAccess.getSTEqualityExpressionAccess().getGroup_1_0(), "rule__STEqualityExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTComparisonExpressionAccess().getGroup(), "rule__STComparisonExpression__Group__0");
			builder.put(grammarAccess.getSTComparisonExpressionAccess().getGroup_1(), "rule__STComparisonExpression__Group_1__0");
			builder.put(grammarAccess.getSTComparisonExpressionAccess().getGroup_1_0(), "rule__STComparisonExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTAddSubExpressionAccess().getGroup(), "rule__STAddSubExpression__Group__0");
			builder.put(grammarAccess.getSTAddSubExpressionAccess().getGroup_1(), "rule__STAddSubExpression__Group_1__0");
			builder.put(grammarAccess.getSTAddSubExpressionAccess().getGroup_1_0(), "rule__STAddSubExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTMulDivModExpressionAccess().getGroup(), "rule__STMulDivModExpression__Group__0");
			builder.put(grammarAccess.getSTMulDivModExpressionAccess().getGroup_1(), "rule__STMulDivModExpression__Group_1__0");
			builder.put(grammarAccess.getSTMulDivModExpressionAccess().getGroup_1_0(), "rule__STMulDivModExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTPowerExpressionAccess().getGroup(), "rule__STPowerExpression__Group__0");
			builder.put(grammarAccess.getSTPowerExpressionAccess().getGroup_1(), "rule__STPowerExpression__Group_1__0");
			builder.put(grammarAccess.getSTPowerExpressionAccess().getGroup_1_0(), "rule__STPowerExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTUnaryExpressionAccess().getGroup_1(), "rule__STUnaryExpression__Group_1__0");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getGroup(), "rule__STAccessExpression__Group__0");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getGroup_1_0(), "rule__STAccessExpression__Group_1_0__0");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getGroup_1_1(), "rule__STAccessExpression__Group_1_1__0");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getGroup_1_1_3(), "rule__STAccessExpression__Group_1_1_3__0");
			builder.put(grammarAccess.getSTPrimaryExpressionAccess().getGroup_0(), "rule__STPrimaryExpression__Group_0__0");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getGroup(), "rule__STFeatureExpression__Group__0");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getGroup_2(), "rule__STFeatureExpression__Group_2__0");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getGroup_2_1(), "rule__STFeatureExpression__Group_2_1__0");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getGroup_2_1_1(), "rule__STFeatureExpression__Group_2_1_1__0");
			builder.put(grammarAccess.getSTMultibitPartialExpressionAccess().getGroup(), "rule__STMultibitPartialExpression__Group__0");
			builder.put(grammarAccess.getSTNumericLiteralAccess().getGroup(), "rule__STNumericLiteral__Group__0");
			builder.put(grammarAccess.getSTNumericLiteralAccess().getGroup_0(), "rule__STNumericLiteral__Group_0__0");
			builder.put(grammarAccess.getSTDateLiteralAccess().getGroup(), "rule__STDateLiteral__Group__0");
			builder.put(grammarAccess.getSTTimeLiteralAccess().getGroup(), "rule__STTimeLiteral__Group__0");
			builder.put(grammarAccess.getSTTimeOfDayLiteralAccess().getGroup(), "rule__STTimeOfDayLiteral__Group__0");
			builder.put(grammarAccess.getSTDateAndTimeLiteralAccess().getGroup(), "rule__STDateAndTimeLiteral__Group__0");
			builder.put(grammarAccess.getSTStringLiteralAccess().getGroup(), "rule__STStringLiteral__Group__0");
			builder.put(grammarAccess.getSTStringLiteralAccess().getGroup_0(), "rule__STStringLiteral__Group_0__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getNumberAccess().getGroup(), "rule__Number__Group__0");
			builder.put(grammarAccess.getNumberAccess().getGroup_2(), "rule__Number__Group_2__0");
			builder.put(grammarAccess.getDateAccess().getGroup(), "rule__Date__Group__0");
			builder.put(grammarAccess.getTimeOfDayAccess().getGroup(), "rule__TimeOfDay__Group__0");
			builder.put(grammarAccess.getTimeOfDayAccess().getGroup_5(), "rule__TimeOfDay__Group_5__0");
			builder.put(grammarAccess.getTimeAccess().getGroup(), "rule__Time__Group__0");
			builder.put(grammarAccess.getSTFunctionAccess().getFunctionsAssignment(), "rule__STFunction__FunctionsAssignment");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getNameAssignment_2(), "rule__FunctionDefinition__NameAssignment_2");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getReturnTypeAssignment_3_1(), "rule__FunctionDefinition__ReturnTypeAssignment_3_1");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getVarDeclarationsAssignment_4_0(), "rule__FunctionDefinition__VarDeclarationsAssignment_4_0");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getVarTempDeclarationsAssignment_4_1(), "rule__FunctionDefinition__VarTempDeclarationsAssignment_4_1");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getVarInpuDeclarationsAssignment_4_2(), "rule__FunctionDefinition__VarInpuDeclarationsAssignment_4_2");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getVarOutputDeclarationsAssignment_4_3(), "rule__FunctionDefinition__VarOutputDeclarationsAssignment_4_3");
			builder.put(grammarAccess.getFunctionDefinitionAccess().getCodeAssignment_5(), "rule__FunctionDefinition__CodeAssignment_5");
			builder.put(grammarAccess.getCodeAccess().getStatementsAssignment(), "rule__Code__StatementsAssignment");
			builder.put(grammarAccess.getVarDeclarationBlockAccess().getConstantAssignment_2(), "rule__VarDeclarationBlock__ConstantAssignment_2");
			builder.put(grammarAccess.getVarDeclarationBlockAccess().getVarDeclarationsAssignment_3(), "rule__VarDeclarationBlock__VarDeclarationsAssignment_3");
			builder.put(grammarAccess.getVarTempDeclarationBlockAccess().getConstantAssignment_2(), "rule__VarTempDeclarationBlock__ConstantAssignment_2");
			builder.put(grammarAccess.getVarTempDeclarationBlockAccess().getVarDeclarationsAssignment_3(), "rule__VarTempDeclarationBlock__VarDeclarationsAssignment_3");
			builder.put(grammarAccess.getVarInputDeclarationBlockAccess().getConstantAssignment_2(), "rule__VarInputDeclarationBlock__ConstantAssignment_2");
			builder.put(grammarAccess.getVarInputDeclarationBlockAccess().getVarDeclarationsAssignment_3(), "rule__VarInputDeclarationBlock__VarDeclarationsAssignment_3");
			builder.put(grammarAccess.getVarOutputDeclarationBlockAccess().getConstantAssignment_2(), "rule__VarOutputDeclarationBlock__ConstantAssignment_2");
			builder.put(grammarAccess.getVarOutputDeclarationBlockAccess().getVarDeclarationsAssignment_3(), "rule__VarOutputDeclarationBlock__VarDeclarationsAssignment_3");
			builder.put(grammarAccess.getVarDeclarationAccess().getNameAssignment_1(), "rule__VarDeclaration__NameAssignment_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getLocatedAtAssignment_2_1(), "rule__VarDeclaration__LocatedAtAssignment_2_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getArrayAssignment_4_0(), "rule__VarDeclaration__ArrayAssignment_4_0");
			builder.put(grammarAccess.getVarDeclarationAccess().getRangesAssignment_4_1_0_1(), "rule__VarDeclaration__RangesAssignment_4_1_0_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getRangesAssignment_4_1_0_2_1(), "rule__VarDeclaration__RangesAssignment_4_1_0_2_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getCountAssignment_4_1_1_1(), "rule__VarDeclaration__CountAssignment_4_1_1_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getCountAssignment_4_1_1_2_1(), "rule__VarDeclaration__CountAssignment_4_1_1_2_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getTypeAssignment_5(), "rule__VarDeclaration__TypeAssignment_5");
			builder.put(grammarAccess.getVarDeclarationAccess().getMaxLengthAssignment_6_1(), "rule__VarDeclaration__MaxLengthAssignment_6_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getDefaultValueAssignment_7_1(), "rule__VarDeclaration__DefaultValueAssignment_7_1");
			builder.put(grammarAccess.getArrayInitializerExpressionAccess().getValuesAssignment_1(), "rule__ArrayInitializerExpression__ValuesAssignment_1");
			builder.put(grammarAccess.getArrayInitializerExpressionAccess().getValuesAssignment_2_1(), "rule__ArrayInitializerExpression__ValuesAssignment_2_1");
			builder.put(grammarAccess.getArrayInitElementAccess().getIndexOrInitExpressionAssignment_0(), "rule__ArrayInitElement__IndexOrInitExpressionAssignment_0");
			builder.put(grammarAccess.getArrayInitElementAccess().getInitExpressionAssignment_1_1(), "rule__ArrayInitElement__InitExpressionAssignment_1_1");
			builder.put(grammarAccess.getSTAssignmentStatementAccess().getLeftAssignment_0(), "rule__STAssignmentStatement__LeftAssignment_0");
			builder.put(grammarAccess.getSTAssignmentStatementAccess().getRightAssignment_2(), "rule__STAssignmentStatement__RightAssignment_2");
			builder.put(grammarAccess.getSTCallStatementAccess().getCallAssignment(), "rule__STCallStatement__CallAssignment");
			builder.put(grammarAccess.getSTCallUnnamedArgumentAccess().getArgAssignment(), "rule__STCallUnnamedArgument__ArgAssignment");
			builder.put(grammarAccess.getSTCallNamedInputArgumentAccess().getTargetAssignment_0(), "rule__STCallNamedInputArgument__TargetAssignment_0");
			builder.put(grammarAccess.getSTCallNamedInputArgumentAccess().getSourceAssignment_2(), "rule__STCallNamedInputArgument__SourceAssignment_2");
			builder.put(grammarAccess.getSTCallNamedOutputArgumentAccess().getNotAssignment_0(), "rule__STCallNamedOutputArgument__NotAssignment_0");
			builder.put(grammarAccess.getSTCallNamedOutputArgumentAccess().getSourceAssignment_1(), "rule__STCallNamedOutputArgument__SourceAssignment_1");
			builder.put(grammarAccess.getSTCallNamedOutputArgumentAccess().getTargetAssignment_3(), "rule__STCallNamedOutputArgument__TargetAssignment_3");
			builder.put(grammarAccess.getSTIfStatementAccess().getConditionAssignment_1(), "rule__STIfStatement__ConditionAssignment_1");
			builder.put(grammarAccess.getSTIfStatementAccess().getStatementsAssignment_3(), "rule__STIfStatement__StatementsAssignment_3");
			builder.put(grammarAccess.getSTIfStatementAccess().getElseifsAssignment_4(), "rule__STIfStatement__ElseifsAssignment_4");
			builder.put(grammarAccess.getSTIfStatementAccess().getElseAssignment_5(), "rule__STIfStatement__ElseAssignment_5");
			builder.put(grammarAccess.getSTElseIfPartAccess().getConditionAssignment_1(), "rule__STElseIfPart__ConditionAssignment_1");
			builder.put(grammarAccess.getSTElseIfPartAccess().getStatementsAssignment_3(), "rule__STElseIfPart__StatementsAssignment_3");
			builder.put(grammarAccess.getSTCaseStatementAccess().getSelectorAssignment_1(), "rule__STCaseStatement__SelectorAssignment_1");
			builder.put(grammarAccess.getSTCaseStatementAccess().getCasesAssignment_3(), "rule__STCaseStatement__CasesAssignment_3");
			builder.put(grammarAccess.getSTCaseStatementAccess().getElseAssignment_4(), "rule__STCaseStatement__ElseAssignment_4");
			builder.put(grammarAccess.getSTCaseCasesAccess().getConditionsAssignment_0(), "rule__STCaseCases__ConditionsAssignment_0");
			builder.put(grammarAccess.getSTCaseCasesAccess().getConditionsAssignment_1_1(), "rule__STCaseCases__ConditionsAssignment_1_1");
			builder.put(grammarAccess.getSTCaseCasesAccess().getStatementsAssignment_3(), "rule__STCaseCases__StatementsAssignment_3");
			builder.put(grammarAccess.getSTElsePartAccess().getStatementsAssignment_2(), "rule__STElsePart__StatementsAssignment_2");
			builder.put(grammarAccess.getSTForStatementAccess().getVariableAssignment_1(), "rule__STForStatement__VariableAssignment_1");
			builder.put(grammarAccess.getSTForStatementAccess().getFromAssignment_3(), "rule__STForStatement__FromAssignment_3");
			builder.put(grammarAccess.getSTForStatementAccess().getToAssignment_5(), "rule__STForStatement__ToAssignment_5");
			builder.put(grammarAccess.getSTForStatementAccess().getByAssignment_6_1(), "rule__STForStatement__ByAssignment_6_1");
			builder.put(grammarAccess.getSTForStatementAccess().getStatementsAssignment_8(), "rule__STForStatement__StatementsAssignment_8");
			builder.put(grammarAccess.getSTWhileStatementAccess().getConditionAssignment_1(), "rule__STWhileStatement__ConditionAssignment_1");
			builder.put(grammarAccess.getSTWhileStatementAccess().getStatementsAssignment_3(), "rule__STWhileStatement__StatementsAssignment_3");
			builder.put(grammarAccess.getSTRepeatStatementAccess().getStatementsAssignment_1(), "rule__STRepeatStatement__StatementsAssignment_1");
			builder.put(grammarAccess.getSTRepeatStatementAccess().getConditionAssignment_3(), "rule__STRepeatStatement__ConditionAssignment_3");
			builder.put(grammarAccess.getSTSubrangeExpressionAccess().getOpAssignment_1_0_1(), "rule__STSubrangeExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTSubrangeExpressionAccess().getRightAssignment_1_1(), "rule__STSubrangeExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTOrExpressionAccess().getOpAssignment_1_0_1(), "rule__STOrExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTOrExpressionAccess().getRightAssignment_1_1(), "rule__STOrExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTXorExpressionAccess().getOpAssignment_1_0_1(), "rule__STXorExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTXorExpressionAccess().getRightAssignment_1_1(), "rule__STXorExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTAndExpressionAccess().getOpAssignment_1_0_1(), "rule__STAndExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTAndExpressionAccess().getRightAssignment_1_1(), "rule__STAndExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTEqualityExpressionAccess().getOpAssignment_1_0_1(), "rule__STEqualityExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTEqualityExpressionAccess().getRightAssignment_1_1(), "rule__STEqualityExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTComparisonExpressionAccess().getOpAssignment_1_0_1(), "rule__STComparisonExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTComparisonExpressionAccess().getRightAssignment_1_1(), "rule__STComparisonExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTAddSubExpressionAccess().getOpAssignment_1_0_1(), "rule__STAddSubExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTAddSubExpressionAccess().getRightAssignment_1_1(), "rule__STAddSubExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTMulDivModExpressionAccess().getOpAssignment_1_0_1(), "rule__STMulDivModExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTMulDivModExpressionAccess().getRightAssignment_1_1(), "rule__STMulDivModExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTPowerExpressionAccess().getOpAssignment_1_0_1(), "rule__STPowerExpression__OpAssignment_1_0_1");
			builder.put(grammarAccess.getSTPowerExpressionAccess().getRightAssignment_1_1(), "rule__STPowerExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getSTUnaryExpressionAccess().getOpAssignment_1_1(), "rule__STUnaryExpression__OpAssignment_1_1");
			builder.put(grammarAccess.getSTUnaryExpressionAccess().getExpressionAssignment_1_2(), "rule__STUnaryExpression__ExpressionAssignment_1_2");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getMemberAssignment_1_0_2(), "rule__STAccessExpression__MemberAssignment_1_0_2");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getIndexAssignment_1_1_2(), "rule__STAccessExpression__IndexAssignment_1_1_2");
			builder.put(grammarAccess.getSTAccessExpressionAccess().getIndexAssignment_1_1_3_1(), "rule__STAccessExpression__IndexAssignment_1_1_3_1");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getFeatureAssignment_1(), "rule__STFeatureExpression__FeatureAssignment_1");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getParametersAssignment_2_1_0(), "rule__STFeatureExpression__ParametersAssignment_2_1_0");
			builder.put(grammarAccess.getSTFeatureExpressionAccess().getParametersAssignment_2_1_1_1(), "rule__STFeatureExpression__ParametersAssignment_2_1_1_1");
			builder.put(grammarAccess.getSTMultibitPartialExpressionAccess().getSpecifierAssignment_1(), "rule__STMultibitPartialExpression__SpecifierAssignment_1");
			builder.put(grammarAccess.getSTMultibitPartialExpressionAccess().getIndexAssignment_2(), "rule__STMultibitPartialExpression__IndexAssignment_2");
			builder.put(grammarAccess.getSTNumericLiteralAccess().getTypeAssignment_0_0(), "rule__STNumericLiteral__TypeAssignment_0_0");
			builder.put(grammarAccess.getSTNumericLiteralAccess().getValueAssignment_1(), "rule__STNumericLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getSTDateLiteralAccess().getTypeAssignment_0(), "rule__STDateLiteral__TypeAssignment_0");
			builder.put(grammarAccess.getSTDateLiteralAccess().getValueAssignment_2(), "rule__STDateLiteral__ValueAssignment_2");
			builder.put(grammarAccess.getSTTimeLiteralAccess().getTypeAssignment_0(), "rule__STTimeLiteral__TypeAssignment_0");
			builder.put(grammarAccess.getSTTimeLiteralAccess().getValueAssignment_2(), "rule__STTimeLiteral__ValueAssignment_2");
			builder.put(grammarAccess.getSTTimeOfDayLiteralAccess().getTypeAssignment_0(), "rule__STTimeOfDayLiteral__TypeAssignment_0");
			builder.put(grammarAccess.getSTTimeOfDayLiteralAccess().getValueAssignment_2(), "rule__STTimeOfDayLiteral__ValueAssignment_2");
			builder.put(grammarAccess.getSTDateAndTimeLiteralAccess().getTypeAssignment_0(), "rule__STDateAndTimeLiteral__TypeAssignment_0");
			builder.put(grammarAccess.getSTDateAndTimeLiteralAccess().getDateValueAssignment_2(), "rule__STDateAndTimeLiteral__DateValueAssignment_2");
			builder.put(grammarAccess.getSTDateAndTimeLiteralAccess().getTimeOfDayValueAssignment_4(), "rule__STDateAndTimeLiteral__TimeOfDayValueAssignment_4");
			builder.put(grammarAccess.getSTStringLiteralAccess().getTypeAssignment_0_0(), "rule__STStringLiteral__TypeAssignment_0_0");
			builder.put(grammarAccess.getSTStringLiteralAccess().getValueAssignment_1(), "rule__STStringLiteral__ValueAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private STFunctionGrammarAccess grammarAccess;

	@Override
	protected InternalSTFunctionParser createParser() {
		InternalSTFunctionParser result = new InternalSTFunctionParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public STFunctionGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(STFunctionGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
