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