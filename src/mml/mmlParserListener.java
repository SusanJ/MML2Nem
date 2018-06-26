// Generated from mmlParser.g4 by ANTLR 4.7.1
 package mml; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mmlParser}.
 */
public interface mmlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mmlParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(mmlParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(mmlParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#prolog}.
	 * @param ctx the parse tree
	 */
	void enterProlog(mmlParser.PrologContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#prolog}.
	 * @param ctx the parse tree
	 */
	void exitProlog(mmlParser.PrologContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#rcontent}.
	 * @param ctx the parse tree
	 */
	void enterRcontent(mmlParser.RcontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#rcontent}.
	 * @param ctx the parse tree
	 */
	void exitRcontent(mmlParser.RcontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(mmlParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(mmlParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#fraccontent}.
	 * @param ctx the parse tree
	 */
	void enterFraccontent(mmlParser.FraccontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#fraccontent}.
	 * @param ctx the parse tree
	 */
	void exitFraccontent(mmlParser.FraccontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#basecontent}.
	 * @param ctx the parse tree
	 */
	void enterBasecontent(mmlParser.BasecontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#basecontent}.
	 * @param ctx the parse tree
	 */
	void exitBasecontent(mmlParser.BasecontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#subcontent}.
	 * @param ctx the parse tree
	 */
	void enterSubcontent(mmlParser.SubcontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#subcontent}.
	 * @param ctx the parse tree
	 */
	void exitSubcontent(mmlParser.SubcontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#supcontent}.
	 * @param ctx the parse tree
	 */
	void enterSupcontent(mmlParser.SupcontentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#supcontent}.
	 * @param ctx the parse tree
	 */
	void exitSupcontent(mmlParser.SupcontentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#underment}.
	 * @param ctx the parse tree
	 */
	void enterUnderment(mmlParser.UndermentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#underment}.
	 * @param ctx the parse tree
	 */
	void exitUnderment(mmlParser.UndermentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#munderStart}.
	 * @param ctx the parse tree
	 */
	void enterMunderStart(mmlParser.MunderStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#munderStart}.
	 * @param ctx the parse tree
	 */
	void exitMunderStart(mmlParser.MunderStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#munderEnd}.
	 * @param ctx the parse tree
	 */
	void enterMunderEnd(mmlParser.MunderEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#munderEnd}.
	 * @param ctx the parse tree
	 */
	void exitMunderEnd(mmlParser.MunderEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#overment}.
	 * @param ctx the parse tree
	 */
	void enterOverment(mmlParser.OvermentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#overment}.
	 * @param ctx the parse tree
	 */
	void exitOverment(mmlParser.OvermentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#moverStart}.
	 * @param ctx the parse tree
	 */
	void enterMoverStart(mmlParser.MoverStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#moverStart}.
	 * @param ctx the parse tree
	 */
	void exitMoverStart(mmlParser.MoverStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#moverEnd}.
	 * @param ctx the parse tree
	 */
	void enterMoverEnd(mmlParser.MoverEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#moverEnd}.
	 * @param ctx the parse tree
	 */
	void exitMoverEnd(mmlParser.MoverEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#undoverment}.
	 * @param ctx the parse tree
	 */
	void enterUndoverment(mmlParser.UndovermentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#undoverment}.
	 * @param ctx the parse tree
	 */
	void exitUndoverment(mmlParser.UndovermentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#munderoverStart}.
	 * @param ctx the parse tree
	 */
	void enterMunderoverStart(mmlParser.MunderoverStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#munderoverStart}.
	 * @param ctx the parse tree
	 */
	void exitMunderoverStart(mmlParser.MunderoverStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#munderoverEnd}.
	 * @param ctx the parse tree
	 */
	void enterMunderoverEnd(mmlParser.MunderoverEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#munderoverEnd}.
	 * @param ctx the parse tree
	 */
	void exitMunderoverEnd(mmlParser.MunderoverEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#supment}.
	 * @param ctx the parse tree
	 */
	void enterSupment(mmlParser.SupmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#supment}.
	 * @param ctx the parse tree
	 */
	void exitSupment(mmlParser.SupmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msupStart}.
	 * @param ctx the parse tree
	 */
	void enterMsupStart(mmlParser.MsupStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msupStart}.
	 * @param ctx the parse tree
	 */
	void exitMsupStart(mmlParser.MsupStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msupEnd}.
	 * @param ctx the parse tree
	 */
	void enterMsupEnd(mmlParser.MsupEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msupEnd}.
	 * @param ctx the parse tree
	 */
	void exitMsupEnd(mmlParser.MsupEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#subment}.
	 * @param ctx the parse tree
	 */
	void enterSubment(mmlParser.SubmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#subment}.
	 * @param ctx the parse tree
	 */
	void exitSubment(mmlParser.SubmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msubStart}.
	 * @param ctx the parse tree
	 */
	void enterMsubStart(mmlParser.MsubStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msubStart}.
	 * @param ctx the parse tree
	 */
	void exitMsubStart(mmlParser.MsubStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msubEnd}.
	 * @param ctx the parse tree
	 */
	void enterMsubEnd(mmlParser.MsubEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msubEnd}.
	 * @param ctx the parse tree
	 */
	void exitMsubEnd(mmlParser.MsubEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#subsupment}.
	 * @param ctx the parse tree
	 */
	void enterSubsupment(mmlParser.SubsupmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#subsupment}.
	 * @param ctx the parse tree
	 */
	void exitSubsupment(mmlParser.SubsupmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msubsupStart}.
	 * @param ctx the parse tree
	 */
	void enterMsubsupStart(mmlParser.MsubsupStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msubsupStart}.
	 * @param ctx the parse tree
	 */
	void exitMsubsupStart(mmlParser.MsubsupStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msubsupEnd}.
	 * @param ctx the parse tree
	 */
	void enterMsubsupEnd(mmlParser.MsubsupEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msubsupEnd}.
	 * @param ctx the parse tree
	 */
	void exitMsubsupEnd(mmlParser.MsubsupEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#sqrtment}.
	 * @param ctx the parse tree
	 */
	void enterSqrtment(mmlParser.SqrtmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#sqrtment}.
	 * @param ctx the parse tree
	 */
	void exitSqrtment(mmlParser.SqrtmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msqrtStart}.
	 * @param ctx the parse tree
	 */
	void enterMsqrtStart(mmlParser.MsqrtStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msqrtStart}.
	 * @param ctx the parse tree
	 */
	void exitMsqrtStart(mmlParser.MsqrtStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#msqrtEnd}.
	 * @param ctx the parse tree
	 */
	void enterMsqrtEnd(mmlParser.MsqrtEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#msqrtEnd}.
	 * @param ctx the parse tree
	 */
	void exitMsqrtEnd(mmlParser.MsqrtEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#rootment}.
	 * @param ctx the parse tree
	 */
	void enterRootment(mmlParser.RootmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#rootment}.
	 * @param ctx the parse tree
	 */
	void exitRootment(mmlParser.RootmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mrootStart}.
	 * @param ctx the parse tree
	 */
	void enterMrootStart(mmlParser.MrootStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mrootStart}.
	 * @param ctx the parse tree
	 */
	void exitMrootStart(mmlParser.MrootStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mrootEnd}.
	 * @param ctx the parse tree
	 */
	void enterMrootEnd(mmlParser.MrootEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mrootEnd}.
	 * @param ctx the parse tree
	 */
	void exitMrootEnd(mmlParser.MrootEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#layment}.
	 * @param ctx the parse tree
	 */
	void enterLayment(mmlParser.LaymentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#layment}.
	 * @param ctx the parse tree
	 */
	void exitLayment(mmlParser.LaymentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#fracment}.
	 * @param ctx the parse tree
	 */
	void enterFracment(mmlParser.FracmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#fracment}.
	 * @param ctx the parse tree
	 */
	void exitFracment(mmlParser.FracmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mfracStart}.
	 * @param ctx the parse tree
	 */
	void enterMfracStart(mmlParser.MfracStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mfracStart}.
	 * @param ctx the parse tree
	 */
	void exitMfracStart(mmlParser.MfracStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mfracEnd}.
	 * @param ctx the parse tree
	 */
	void enterMfracEnd(mmlParser.MfracEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mfracEnd}.
	 * @param ctx the parse tree
	 */
	void exitMfracEnd(mmlParser.MfracEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#rowment}.
	 * @param ctx the parse tree
	 */
	void enterRowment(mmlParser.RowmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#rowment}.
	 * @param ctx the parse tree
	 */
	void exitRowment(mmlParser.RowmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mrowStart}.
	 * @param ctx the parse tree
	 */
	void enterMrowStart(mmlParser.MrowStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mrowStart}.
	 * @param ctx the parse tree
	 */
	void exitMrowStart(mmlParser.MrowStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#mrowEnd}.
	 * @param ctx the parse tree
	 */
	void enterMrowEnd(mmlParser.MrowEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#mrowEnd}.
	 * @param ctx the parse tree
	 */
	void exitMrowEnd(mmlParser.MrowEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#tokment}.
	 * @param ctx the parse tree
	 */
	void enterTokment(mmlParser.TokmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#tokment}.
	 * @param ctx the parse tree
	 */
	void exitTokment(mmlParser.TokmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(mmlParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(mmlParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#paraStart}.
	 * @param ctx the parse tree
	 */
	void enterParaStart(mmlParser.ParaStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#paraStart}.
	 * @param ctx the parse tree
	 */
	void exitParaStart(mmlParser.ParaStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#paraEnd}.
	 * @param ctx the parse tree
	 */
	void enterParaEnd(mmlParser.ParaEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#paraEnd}.
	 * @param ctx the parse tree
	 */
	void exitParaEnd(mmlParser.ParaEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(mmlParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(mmlParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(mmlParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(mmlParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(mmlParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(mmlParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#justWS}.
	 * @param ctx the parse tree
	 */
	void enterJustWS(mmlParser.JustWSContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#justWS}.
	 * @param ctx the parse tree
	 */
	void exitJustWS(mmlParser.JustWSContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#tok}.
	 * @param ctx the parse tree
	 */
	void enterTok(mmlParser.TokContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#tok}.
	 * @param ctx the parse tree
	 */
	void exitTok(mmlParser.TokContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integer}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterInteger(mmlParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitInteger(mmlParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterText(mmlParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitText(mmlParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whitespace}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void enterWhitespace(mmlParser.WhitespaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whitespace}
	 * labeled alternative in {@link mmlParser#chardata}.
	 * @param ctx the parse tree
	 */
	void exitWhitespace(mmlParser.WhitespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link mmlParser#misc}.
	 * @param ctx the parse tree
	 */
	void enterMisc(mmlParser.MiscContext ctx);
	/**
	 * Exit a parse tree produced by {@link mmlParser#misc}.
	 * @param ctx the parse tree
	 */
	void exitMisc(mmlParser.MiscContext ctx);
}