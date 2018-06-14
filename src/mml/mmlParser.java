// Generated from mmlParser.g4 by ANTLR 4.7.1
 package mml; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, CDATA=2, DTD=3, EntityRef=4, CharRef=5, SEA_WS=6, OPEN=7, XMLDeclOpen=8, 
		INTEG=9, TEXT=10, CLOSE=11, SPECIAL_CLOSE=12, SLASH_CLOSE=13, SLASH=14, 
		EQUALS=15, STRING=16, MFRAC=17, MSUP=18, MSUB=19, LAY=20, ROW=21, MO=22, 
		MN=23, MI=24, Name=25, S=26, PI=27, MATH=28, MSQRT=29;
	public static final int
		RULE_document = 0, RULE_prolog = 1, RULE_rcontent = 2, RULE_content = 3, 
		RULE_fraccontent = 4, RULE_supment = 5, RULE_msupStart = 6, RULE_msupEnd = 7, 
		RULE_subment = 8, RULE_msubStart = 9, RULE_msubEnd = 10, RULE_layment = 11, 
		RULE_fracment = 12, RULE_mfracStart = 13, RULE_mfracEnd = 14, RULE_rowment = 15, 
		RULE_mrowStart = 16, RULE_mrowEnd = 17, RULE_tokment = 18, RULE_element = 19, 
		RULE_reference = 20, RULE_attribute = 21, RULE_justWS = 22, RULE_tok = 23, 
		RULE_chardata = 24, RULE_misc = 25;
	public static final String[] ruleNames = {
		"document", "prolog", "rcontent", "content", "fraccontent", "supment", 
		"msupStart", "msupEnd", "subment", "msubStart", "msubEnd", "layment", 
		"fracment", "mfracStart", "mfracEnd", "rowment", "mrowStart", "mrowEnd", 
		"tokment", "element", "reference", "attribute", "justWS", "tok", "chardata", 
		"misc"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'>'", 
		null, "'/>'", "'/'", "'='", null, "'mfrac'", "'msup'", "'msub'", "'msubsup'", 
		"'mrow'", "'mo'", "'mn'", "'mi'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "OPEN", 
		"XMLDeclOpen", "INTEG", "TEXT", "CLOSE", "SPECIAL_CLOSE", "SLASH_CLOSE", 
		"SLASH", "EQUALS", "STRING", "MFRAC", "MSUP", "MSUB", "LAY", "ROW", "MO", 
		"MN", "MI", "Name", "S", "PI", "MATH", "MSQRT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "mmlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public PrologContext prolog() {
			return getRuleContext(PrologContext.class,0);
		}
		public List<MiscContext> misc() {
			return getRuleContexts(MiscContext.class);
		}
		public MiscContext misc(int i) {
			return getRuleContext(MiscContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==XMLDeclOpen) {
				{
				setState(52);
				prolog();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << SEA_WS) | (1L << PI))) != 0)) {
				{
				{
				setState(55);
				misc();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			element();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << SEA_WS) | (1L << PI))) != 0)) {
				{
				{
				setState(62);
				misc();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrologContext extends ParserRuleContext {
		public TerminalNode XMLDeclOpen() { return getToken(mmlParser.XMLDeclOpen, 0); }
		public TerminalNode SPECIAL_CLOSE() { return getToken(mmlParser.SPECIAL_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public PrologContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prolog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterProlog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitProlog(this);
		}
	}

	public final PrologContext prolog() throws RecognitionException {
		PrologContext _localctx = new PrologContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prolog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(XMLDeclOpen);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(69);
				attribute();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(SPECIAL_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RcontentContext extends ParserRuleContext {
		public List<ChardataContext> chardata() {
			return getRuleContexts(ChardataContext.class);
		}
		public ChardataContext chardata(int i) {
			return getRuleContext(ChardataContext.class,i);
		}
		public List<RowmentContext> rowment() {
			return getRuleContexts(RowmentContext.class);
		}
		public RowmentContext rowment(int i) {
			return getRuleContext(RowmentContext.class,i);
		}
		public RcontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rcontent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterRcontent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitRcontent(this);
		}
	}

	public final RcontentContext rcontent() throws RecognitionException {
		RcontentContext _localctx = new RcontentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rcontent);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEA_WS) | (1L << INTEG) | (1L << TEXT))) != 0)) {
				{
				setState(77);
				chardata();
				}
			}

			setState(84); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					{
					setState(80);
					rowment();
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEA_WS) | (1L << INTEG) | (1L << TEXT))) != 0)) {
						{
						setState(81);
						chardata();
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(86); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public List<ChardataContext> chardata() {
			return getRuleContexts(ChardataContext.class);
		}
		public ChardataContext chardata(int i) {
			return getRuleContext(ChardataContext.class,i);
		}
		public List<FracmentContext> fracment() {
			return getRuleContexts(FracmentContext.class);
		}
		public FracmentContext fracment(int i) {
			return getRuleContext(FracmentContext.class,i);
		}
		public List<SupmentContext> supment() {
			return getRuleContexts(SupmentContext.class);
		}
		public SupmentContext supment(int i) {
			return getRuleContext(SupmentContext.class,i);
		}
		public List<SubmentContext> subment() {
			return getRuleContexts(SubmentContext.class);
		}
		public SubmentContext subment(int i) {
			return getRuleContext(SubmentContext.class,i);
		}
		public List<LaymentContext> layment() {
			return getRuleContexts(LaymentContext.class);
		}
		public LaymentContext layment(int i) {
			return getRuleContext(LaymentContext.class,i);
		}
		public List<RowmentContext> rowment() {
			return getRuleContexts(RowmentContext.class);
		}
		public RowmentContext rowment(int i) {
			return getRuleContext(RowmentContext.class,i);
		}
		public List<TokmentContext> tokment() {
			return getRuleContexts(TokmentContext.class);
		}
		public TokmentContext tokment(int i) {
			return getRuleContext(TokmentContext.class,i);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public List<TerminalNode> CDATA() { return getTokens(mmlParser.CDATA); }
		public TerminalNode CDATA(int i) {
			return getToken(mmlParser.CDATA, i);
		}
		public List<TerminalNode> PI() { return getTokens(mmlParser.PI); }
		public TerminalNode PI(int i) {
			return getToken(mmlParser.PI, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(mmlParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(mmlParser.COMMENT, i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_content);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEA_WS) | (1L << INTEG) | (1L << TEXT))) != 0)) {
				{
				setState(88);
				chardata();
				}
			}

			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						setState(91);
						fracment();
						}
						break;
					case 2:
						{
						setState(92);
						supment();
						}
						break;
					case 3:
						{
						setState(93);
						subment();
						}
						break;
					case 4:
						{
						setState(94);
						layment();
						}
						break;
					case 5:
						{
						setState(95);
						rowment();
						}
						break;
					case 6:
						{
						setState(96);
						tokment();
						}
						break;
					case 7:
						{
						setState(97);
						element();
						}
						break;
					case 8:
						{
						setState(98);
						reference();
						}
						break;
					case 9:
						{
						setState(99);
						match(CDATA);
						}
						break;
					case 10:
						{
						setState(100);
						match(PI);
						}
						break;
					case 11:
						{
						setState(101);
						match(COMMENT);
						}
						break;
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEA_WS) | (1L << INTEG) | (1L << TEXT))) != 0)) {
						{
						setState(104);
						chardata();
						}
					}

					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FraccontentContext extends ParserRuleContext {
		public FracmentContext fracment() {
			return getRuleContext(FracmentContext.class,0);
		}
		public SupmentContext supment() {
			return getRuleContext(SupmentContext.class,0);
		}
		public SubmentContext subment() {
			return getRuleContext(SubmentContext.class,0);
		}
		public LaymentContext layment() {
			return getRuleContext(LaymentContext.class,0);
		}
		public RowmentContext rowment() {
			return getRuleContext(RowmentContext.class,0);
		}
		public TokmentContext tokment() {
			return getRuleContext(TokmentContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public List<JustWSContext> justWS() {
			return getRuleContexts(JustWSContext.class);
		}
		public JustWSContext justWS(int i) {
			return getRuleContext(JustWSContext.class,i);
		}
		public FraccontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fraccontent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterFraccontent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitFraccontent(this);
		}
	}

	public final FraccontentContext fraccontent() throws RecognitionException {
		FraccontentContext _localctx = new FraccontentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fraccontent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEA_WS) {
				{
				setState(112);
				justWS();
				}
			}

			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(115);
				fracment();
				}
				break;
			case 2:
				{
				setState(116);
				supment();
				}
				break;
			case 3:
				{
				setState(117);
				subment();
				}
				break;
			case 4:
				{
				setState(118);
				layment();
				}
				break;
			case 5:
				{
				setState(119);
				rowment();
				}
				break;
			case 6:
				{
				setState(120);
				tokment();
				}
				break;
			case 7:
				{
				setState(121);
				element();
				}
				break;
			}
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(124);
				justWS();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SupmentContext extends ParserRuleContext {
		public MsupStartContext msupStart() {
			return getRuleContext(MsupStartContext.class,0);
		}
		public MsupEndContext msupEnd() {
			return getRuleContext(MsupEndContext.class,0);
		}
		public List<FraccontentContext> fraccontent() {
			return getRuleContexts(FraccontentContext.class);
		}
		public FraccontentContext fraccontent(int i) {
			return getRuleContext(FraccontentContext.class,i);
		}
		public SupmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterSupment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitSupment(this);
		}
	}

	public final SupmentContext supment() throws RecognitionException {
		SupmentContext _localctx = new SupmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_supment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			msupStart();
			{
			setState(128);
			fraccontent();
			setState(129);
			fraccontent();
			}
			setState(131);
			msupEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MsupStartContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode MSUP() { return getToken(mmlParser.MSUP, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MsupStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msupStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMsupStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMsupStart(this);
		}
	}

	public final MsupStartContext msupStart() throws RecognitionException {
		MsupStartContext _localctx = new MsupStartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_msupStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(OPEN);
			setState(134);
			match(MSUP);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(135);
				attribute();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MsupEndContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public TerminalNode MSUP() { return getToken(mmlParser.MSUP, 0); }
		public MsupEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msupEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMsupEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMsupEnd(this);
		}
	}

	public final MsupEndContext msupEnd() throws RecognitionException {
		MsupEndContext _localctx = new MsupEndContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_msupEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(OPEN);
			setState(144);
			match(SLASH);
			setState(145);
			match(MSUP);
			setState(146);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubmentContext extends ParserRuleContext {
		public MsubStartContext msubStart() {
			return getRuleContext(MsubStartContext.class,0);
		}
		public MsubEndContext msubEnd() {
			return getRuleContext(MsubEndContext.class,0);
		}
		public List<FraccontentContext> fraccontent() {
			return getRuleContexts(FraccontentContext.class);
		}
		public FraccontentContext fraccontent(int i) {
			return getRuleContext(FraccontentContext.class,i);
		}
		public SubmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterSubment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitSubment(this);
		}
	}

	public final SubmentContext subment() throws RecognitionException {
		SubmentContext _localctx = new SubmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_subment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			msubStart();
			{
			setState(149);
			fraccontent();
			setState(150);
			fraccontent();
			}
			setState(152);
			msubEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MsubStartContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode MSUB() { return getToken(mmlParser.MSUB, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MsubStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msubStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMsubStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMsubStart(this);
		}
	}

	public final MsubStartContext msubStart() throws RecognitionException {
		MsubStartContext _localctx = new MsubStartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_msubStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(OPEN);
			setState(155);
			match(MSUB);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(156);
				attribute();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MsubEndContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public TerminalNode MSUB() { return getToken(mmlParser.MSUB, 0); }
		public MsubEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msubEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMsubEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMsubEnd(this);
		}
	}

	public final MsubEndContext msubEnd() throws RecognitionException {
		MsubEndContext _localctx = new MsubEndContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_msubEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(OPEN);
			setState(165);
			match(SLASH);
			setState(166);
			match(MSUB);
			setState(167);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LaymentContext extends ParserRuleContext {
		public List<TerminalNode> OPEN() { return getTokens(mmlParser.OPEN); }
		public TerminalNode OPEN(int i) {
			return getToken(mmlParser.OPEN, i);
		}
		public List<TerminalNode> LAY() { return getTokens(mmlParser.LAY); }
		public TerminalNode LAY(int i) {
			return getToken(mmlParser.LAY, i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public LaymentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterLayment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitLayment(this);
		}
	}

	public final LaymentContext layment() throws RecognitionException {
		LaymentContext _localctx = new LaymentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_layment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(OPEN);
			setState(170);
			match(LAY);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(171);
				attribute();
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			match(CLOSE);
			setState(178);
			content();
			setState(179);
			match(OPEN);
			setState(180);
			match(SLASH);
			setState(181);
			match(LAY);
			setState(182);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FracmentContext extends ParserRuleContext {
		public MfracStartContext mfracStart() {
			return getRuleContext(MfracStartContext.class,0);
		}
		public MfracEndContext mfracEnd() {
			return getRuleContext(MfracEndContext.class,0);
		}
		public List<FraccontentContext> fraccontent() {
			return getRuleContexts(FraccontentContext.class);
		}
		public FraccontentContext fraccontent(int i) {
			return getRuleContext(FraccontentContext.class,i);
		}
		public FracmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fracment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterFracment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitFracment(this);
		}
	}

	public final FracmentContext fracment() throws RecognitionException {
		FracmentContext _localctx = new FracmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fracment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			mfracStart();
			{
			setState(185);
			fraccontent();
			setState(186);
			fraccontent();
			}
			setState(188);
			mfracEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MfracStartContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode MFRAC() { return getToken(mmlParser.MFRAC, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MfracStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mfracStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMfracStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMfracStart(this);
		}
	}

	public final MfracStartContext mfracStart() throws RecognitionException {
		MfracStartContext _localctx = new MfracStartContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mfracStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(OPEN);
			setState(191);
			match(MFRAC);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(192);
				attribute();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MfracEndContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public TerminalNode MFRAC() { return getToken(mmlParser.MFRAC, 0); }
		public MfracEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mfracEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMfracEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMfracEnd(this);
		}
	}

	public final MfracEndContext mfracEnd() throws RecognitionException {
		MfracEndContext _localctx = new MfracEndContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mfracEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(OPEN);
			setState(201);
			match(SLASH);
			setState(202);
			match(MFRAC);
			setState(203);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowmentContext extends ParserRuleContext {
		public MrowStartContext mrowStart() {
			return getRuleContext(MrowStartContext.class,0);
		}
		public MrowEndContext mrowEnd() {
			return getRuleContext(MrowEndContext.class,0);
		}
		public RcontentContext rcontent() {
			return getRuleContext(RcontentContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public RowmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterRowment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitRowment(this);
		}
	}

	public final RowmentContext rowment() throws RecognitionException {
		RowmentContext _localctx = new RowmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rowment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			mrowStart();
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(206);
				rcontent();
				}
				break;
			case 2:
				{
				setState(207);
				content();
				}
				break;
			}
			setState(210);
			mrowEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MrowStartContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode ROW() { return getToken(mmlParser.ROW, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MrowStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mrowStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMrowStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMrowStart(this);
		}
	}

	public final MrowStartContext mrowStart() throws RecognitionException {
		MrowStartContext _localctx = new MrowStartContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_mrowStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(OPEN);
			setState(213);
			match(ROW);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(214);
				attribute();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MrowEndContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(mmlParser.OPEN, 0); }
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public TerminalNode ROW() { return getToken(mmlParser.ROW, 0); }
		public MrowEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mrowEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMrowEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMrowEnd(this);
		}
	}

	public final MrowEndContext mrowEnd() throws RecognitionException {
		MrowEndContext _localctx = new MrowEndContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mrowEnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(OPEN);
			setState(223);
			match(SLASH);
			setState(224);
			match(ROW);
			setState(225);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokmentContext extends ParserRuleContext {
		public List<TerminalNode> OPEN() { return getTokens(mmlParser.OPEN); }
		public TerminalNode OPEN(int i) {
			return getToken(mmlParser.OPEN, i);
		}
		public List<TokContext> tok() {
			return getRuleContexts(TokContext.class);
		}
		public TokContext tok(int i) {
			return getRuleContext(TokContext.class,i);
		}
		public ChardataContext chardata() {
			return getRuleContext(ChardataContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TokmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterTokment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitTokment(this);
		}
	}

	public final TokmentContext tokment() throws RecognitionException {
		TokmentContext _localctx = new TokmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_tokment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(OPEN);
			setState(228);
			tok();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(229);
				attribute();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(CLOSE);
			setState(236);
			chardata();
			setState(237);
			match(OPEN);
			setState(238);
			match(SLASH);
			setState(239);
			tok();
			setState(240);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public List<TerminalNode> OPEN() { return getTokens(mmlParser.OPEN); }
		public TerminalNode OPEN(int i) {
			return getToken(mmlParser.OPEN, i);
		}
		public List<TerminalNode> Name() { return getTokens(mmlParser.Name); }
		public TerminalNode Name(int i) {
			return getToken(mmlParser.Name, i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(mmlParser.SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_element);
		int _la;
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(OPEN);
				setState(243);
				match(Name);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Name) {
					{
					{
					setState(244);
					attribute();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(CLOSE);
				setState(251);
				content();
				setState(252);
				match(OPEN);
				setState(253);
				match(SLASH);
				setState(254);
				match(Name);
				setState(255);
				match(CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(OPEN);
				setState(258);
				match(Name);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Name) {
					{
					{
					setState(259);
					attribute();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(265);
				match(SLASH_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode EntityRef() { return getToken(mmlParser.EntityRef, 0); }
		public TerminalNode CharRef() { return getToken(mmlParser.CharRef, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !(_la==EntityRef || _la==CharRef) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(mmlParser.Name, 0); }
		public TerminalNode STRING() { return getToken(mmlParser.STRING, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(Name);
			setState(271);
			match(EQUALS);
			setState(272);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JustWSContext extends ParserRuleContext {
		public TerminalNode SEA_WS() { return getToken(mmlParser.SEA_WS, 0); }
		public JustWSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justWS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterJustWS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitJustWS(this);
		}
	}

	public final JustWSContext justWS() throws RecognitionException {
		JustWSContext _localctx = new JustWSContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_justWS);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(SEA_WS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TokContext extends ParserRuleContext {
		public TerminalNode MI() { return getToken(mmlParser.MI, 0); }
		public TerminalNode MN() { return getToken(mmlParser.MN, 0); }
		public TerminalNode MO() { return getToken(mmlParser.MO, 0); }
		public TokContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tok; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterTok(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitTok(this);
		}
	}

	public final TokContext tok() throws RecognitionException {
		TokContext _localctx = new TokContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tok);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MO) | (1L << MN) | (1L << MI))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChardataContext extends ParserRuleContext {
		public ChardataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chardata; }
	 
		public ChardataContext() { }
		public void copyFrom(ChardataContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends ChardataContext {
		public TerminalNode INTEG() { return getToken(mmlParser.INTEG, 0); }
		public IntegerContext(ChardataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitInteger(this);
		}
	}
	public static class TextContext extends ChardataContext {
		public TerminalNode TEXT() { return getToken(mmlParser.TEXT, 0); }
		public TextContext(ChardataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitText(this);
		}
	}
	public static class WhitespaceContext extends ChardataContext {
		public JustWSContext justWS() {
			return getRuleContext(JustWSContext.class,0);
		}
		public WhitespaceContext(ChardataContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterWhitespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitWhitespace(this);
		}
	}

	public final ChardataContext chardata() throws RecognitionException {
		ChardataContext _localctx = new ChardataContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_chardata);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEG:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				match(INTEG);
				}
				break;
			case TEXT:
				_localctx = new TextContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(TEXT);
				}
				break;
			case SEA_WS:
				_localctx = new WhitespaceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				justWS();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MiscContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(mmlParser.COMMENT, 0); }
		public TerminalNode PI() { return getToken(mmlParser.PI, 0); }
		public TerminalNode SEA_WS() { return getToken(mmlParser.SEA_WS, 0); }
		public MiscContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_misc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).enterMisc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mmlParserListener ) ((mmlParserListener)listener).exitMisc(this);
		}
	}

	public final MiscContext misc() throws RecognitionException {
		MiscContext _localctx = new MiscContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_misc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << SEA_WS) | (1L << PI))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0120\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\5\28\n\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\3\3\3\3\4\5"+
		"\4Q\n\4\3\4\3\4\5\4U\n\4\6\4W\n\4\r\4\16\4X\3\5\5\5\\\n\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5i\n\5\3\5\5\5l\n\5\7\5n\n\5\f\5\16"+
		"\5q\13\5\3\6\5\6t\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6}\n\6\3\6\5\6\u0080"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u008b\n\b\f\b\16\b\u008e"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\7\13\u00a0\n\13\f\13\16\13\u00a3\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00c4\n\17\f"+
		"\17\16\17\u00c7\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\5\21\u00d3\n\21\3\21\3\21\3\22\3\22\3\22\7\22\u00da\n\22\f\22\16\22\u00dd"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00e9\n"+
		"\24\f\24\16\24\u00ec\13\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\7\25\u00f8\n\25\f\25\16\25\u00fb\13\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u0107\n\25\f\25\16\25\u010a\13\25\3\25"+
		"\5\25\u010d\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\32\5\32\u011c\n\32\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\5\3\2\6\7\3\2\30\32\5\2\3\3\b\b"+
		"\35\35\2\u012d\2\67\3\2\2\2\4F\3\2\2\2\6P\3\2\2\2\b[\3\2\2\2\ns\3\2\2"+
		"\2\f\u0081\3\2\2\2\16\u0087\3\2\2\2\20\u0091\3\2\2\2\22\u0096\3\2\2\2"+
		"\24\u009c\3\2\2\2\26\u00a6\3\2\2\2\30\u00ab\3\2\2\2\32\u00ba\3\2\2\2\34"+
		"\u00c0\3\2\2\2\36\u00ca\3\2\2\2 \u00cf\3\2\2\2\"\u00d6\3\2\2\2$\u00e0"+
		"\3\2\2\2&\u00e5\3\2\2\2(\u010c\3\2\2\2*\u010e\3\2\2\2,\u0110\3\2\2\2."+
		"\u0114\3\2\2\2\60\u0116\3\2\2\2\62\u011b\3\2\2\2\64\u011d\3\2\2\2\668"+
		"\5\4\3\2\67\66\3\2\2\2\678\3\2\2\28<\3\2\2\29;\5\64\33\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?C\5(\25\2@B\5\64\33\2A"+
		"@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2EC\3\2\2\2FJ\7\n\2\2"+
		"GI\5,\27\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2"+
		"MN\7\16\2\2N\5\3\2\2\2OQ\5\62\32\2PO\3\2\2\2PQ\3\2\2\2QV\3\2\2\2RT\5 "+
		"\21\2SU\5\62\32\2TS\3\2\2\2TU\3\2\2\2UW\3\2\2\2VR\3\2\2\2WX\3\2\2\2XV"+
		"\3\2\2\2XY\3\2\2\2Y\7\3\2\2\2Z\\\5\62\32\2[Z\3\2\2\2[\\\3\2\2\2\\o\3\2"+
		"\2\2]i\5\32\16\2^i\5\f\7\2_i\5\22\n\2`i\5\30\r\2ai\5 \21\2bi\5&\24\2c"+
		"i\5(\25\2di\5*\26\2ei\7\4\2\2fi\7\35\2\2gi\7\3\2\2h]\3\2\2\2h^\3\2\2\2"+
		"h_\3\2\2\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2\2hc\3\2\2\2hd\3\2\2\2he\3\2\2\2"+
		"hf\3\2\2\2hg\3\2\2\2ik\3\2\2\2jl\5\62\32\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2"+
		"\2mh\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\t\3\2\2\2qo\3\2\2\2rt\5.\30"+
		"\2sr\3\2\2\2st\3\2\2\2t|\3\2\2\2u}\5\32\16\2v}\5\f\7\2w}\5\22\n\2x}\5"+
		"\30\r\2y}\5 \21\2z}\5&\24\2{}\5(\25\2|u\3\2\2\2|v\3\2\2\2|w\3\2\2\2|x"+
		"\3\2\2\2|y\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\177\3\2\2\2~\u0080\5.\30\2\177"+
		"~\3\2\2\2\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\u0082\5\16\b\2\u0082"+
		"\u0083\5\n\6\2\u0083\u0084\5\n\6\2\u0084\u0085\3\2\2\2\u0085\u0086\5\20"+
		"\t\2\u0086\r\3\2\2\2\u0087\u0088\7\t\2\2\u0088\u008c\7\24\2\2\u0089\u008b"+
		"\5,\27\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\r"+
		"\2\2\u0090\17\3\2\2\2\u0091\u0092\7\t\2\2\u0092\u0093\7\20\2\2\u0093\u0094"+
		"\7\24\2\2\u0094\u0095\7\r\2\2\u0095\21\3\2\2\2\u0096\u0097\5\24\13\2\u0097"+
		"\u0098\5\n\6\2\u0098\u0099\5\n\6\2\u0099\u009a\3\2\2\2\u009a\u009b\5\26"+
		"\f\2\u009b\23\3\2\2\2\u009c\u009d\7\t\2\2\u009d\u00a1\7\25\2\2\u009e\u00a0"+
		"\5,\27\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\r"+
		"\2\2\u00a5\25\3\2\2\2\u00a6\u00a7\7\t\2\2\u00a7\u00a8\7\20\2\2\u00a8\u00a9"+
		"\7\25\2\2\u00a9\u00aa\7\r\2\2\u00aa\27\3\2\2\2\u00ab\u00ac\7\t\2\2\u00ac"+
		"\u00b0\7\26\2\2\u00ad\u00af\5,\27\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3"+
		"\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7\r\2\2\u00b4\u00b5\5\b\5\2\u00b5\u00b6\7\t"+
		"\2\2\u00b6\u00b7\7\20\2\2\u00b7\u00b8\7\26\2\2\u00b8\u00b9\7\r\2\2\u00b9"+
		"\31\3\2\2\2\u00ba\u00bb\5\34\17\2\u00bb\u00bc\5\n\6\2\u00bc\u00bd\5\n"+
		"\6\2\u00bd\u00be\3\2\2\2\u00be\u00bf\5\36\20\2\u00bf\33\3\2\2\2\u00c0"+
		"\u00c1\7\t\2\2\u00c1\u00c5\7\23\2\2\u00c2\u00c4\5,\27\2\u00c3\u00c2\3"+
		"\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\r\2\2\u00c9\35\3\2\2"+
		"\2\u00ca\u00cb\7\t\2\2\u00cb\u00cc\7\20\2\2\u00cc\u00cd\7\23\2\2\u00cd"+
		"\u00ce\7\r\2\2\u00ce\37\3\2\2\2\u00cf\u00d2\5\"\22\2\u00d0\u00d3\5\6\4"+
		"\2\u00d1\u00d3\5\b\5\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d5\5$\23\2\u00d5!\3\2\2\2\u00d6\u00d7\7\t\2\2\u00d7"+
		"\u00db\7\27\2\2\u00d8\u00da\5,\27\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3"+
		"\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00df\7\r\2\2\u00df#\3\2\2\2\u00e0\u00e1\7\t\2\2"+
		"\u00e1\u00e2\7\20\2\2\u00e2\u00e3\7\27\2\2\u00e3\u00e4\7\r\2\2\u00e4%"+
		"\3\2\2\2\u00e5\u00e6\7\t\2\2\u00e6\u00ea\5\60\31\2\u00e7\u00e9\5,\27\2"+
		"\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\r\2\2\u00ee"+
		"\u00ef\5\62\32\2\u00ef\u00f0\7\t\2\2\u00f0\u00f1\7\20\2\2\u00f1\u00f2"+
		"\5\60\31\2\u00f2\u00f3\7\r\2\2\u00f3\'\3\2\2\2\u00f4\u00f5\7\t\2\2\u00f5"+
		"\u00f9\7\33\2\2\u00f6\u00f8\5,\27\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3"+
		"\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u00fd\7\r\2\2\u00fd\u00fe\5\b\5\2\u00fe\u00ff\7\t"+
		"\2\2\u00ff\u0100\7\20\2\2\u0100\u0101\7\33\2\2\u0101\u0102\7\r\2\2\u0102"+
		"\u010d\3\2\2\2\u0103\u0104\7\t\2\2\u0104\u0108\7\33\2\2\u0105\u0107\5"+
		",\27\2\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010d\7\17"+
		"\2\2\u010c\u00f4\3\2\2\2\u010c\u0103\3\2\2\2\u010d)\3\2\2\2\u010e\u010f"+
		"\t\2\2\2\u010f+\3\2\2\2\u0110\u0111\7\33\2\2\u0111\u0112\7\21\2\2\u0112"+
		"\u0113\7\22\2\2\u0113-\3\2\2\2\u0114\u0115\7\b\2\2\u0115/\3\2\2\2\u0116"+
		"\u0117\t\3\2\2\u0117\61\3\2\2\2\u0118\u011c\7\13\2\2\u0119\u011c\7\f\2"+
		"\2\u011a\u011c\5.\30\2\u011b\u0118\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\63\3\2\2\2\u011d\u011e\t\4\2\2\u011e\65\3\2\2\2\33\67<"+
		"CJPTX[hkos|\177\u008c\u00a1\u00b0\u00c5\u00d2\u00db\u00ea\u00f9\u0108"+
		"\u010c\u011b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}