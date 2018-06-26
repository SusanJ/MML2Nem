// Generated from mmlLexer.g4 by ANTLR 4.7.1
 package mml; 
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mmlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, CDATA=2, DTD=3, EntityRef=4, CharRef=5, SEA_WS=6, OPEN=7, XMLDeclOpen=8, 
		INTEG=9, TEXT=10, CLOSE=11, SPECIAL_CLOSE=12, SLASH_CLOSE=13, SLASH=14, 
		EQUALS=15, STRING=16, MFRAC=17, MSUP=18, MSUBSUP=19, MSUB=20, MSQRT=21, 
		MROOT=22, MUNDER=23, MOVER=24, MUNDEROVER=25, LAY=26, ROW=27, MO=28, MN=29, 
		MI=30, PARA=31, Name=32, S=33, PI=34;
	public static final int
		INSIDE=1, PROC_INSTR=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE", "PROC_INSTR"
	};

	public static final String[] ruleNames = {
		"COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "WHITE_SPACE", "SEA_WS", 
		"LESS_THAN", "OPEN", "XMLDeclOpen", "SPECIAL_OPEN", "INTEG", "TEXT", "CLOSE", 
		"SPECIAL_CLOSE", "SLASH_CLOSE", "SLASH", "EQUALS", "STRING", "MFRAC", 
		"MSUP", "MSUBSUP", "MSUB", "MSQRT", "MROOT", "MUNDER", "MOVER", "MUNDEROVER", 
		"LAY", "ROW", "MO", "MN", "MI", "PARA", "Name", "S", "HEXDIGIT", "DIGIT", 
		"NameChar", "NameStartChar", "PI", "IGNORE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'>'", 
		null, "'/>'", "'/'", "'='", null, "'mfrac'", "'msup'", "'msubsup'", "'msub'", 
		"'msqrt'", "'mroot'", "'munder'", "'mover'", "'munderover'", "'mmultiscripts'", 
		"'mrow'", "'mo'", "'mn'", "'mi'", "'para'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "OPEN", 
		"XMLDeclOpen", "INTEG", "TEXT", "CLOSE", "SPECIAL_CLOSE", "SLASH_CLOSE", 
		"SLASH", "EQUALS", "STRING", "MFRAC", "MSUP", "MSUBSUP", "MSUB", "MSQRT", 
		"MROOT", "MUNDER", "MOVER", "MUNDEROVER", "LAY", "ROW", "MO", "MN", "MI", 
		"PARA", "Name", "S", "PI"
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

	   // place this class member only in lexer
	Map<String,Integer> mmltags = new HashMap<String,Integer>() {{
	    put("math",  mmlParser.MATH);
	    put("msqrt", mmlParser.MSQRT);
	    put("mn",    mmlParser.MN);
	    put("mo",    mmlParser.MO);
	    put("mi",    mmlParser.MI);
	}};


	public mmlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mmlLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u0173\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\3\2\3\2\3\2\3\2\3\2\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3t\n\3\f\3\16\3w\13\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\u0081\n\4\f\4\16\4\u0084\13\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\6\6\u0092\n\6\r\6\16\6\u0093"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u009d\n\6\r\6\16\6\u009e\3\6\3\6\5\6"+
		"\u00a3\n\6\3\7\3\7\5\7\u00a7\n\7\3\7\6\7\u00aa\n\7\r\7\16\7\u00ab\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\r\u00c9\n\r\r\r\16\r\u00ca"+
		"\3\16\6\16\u00ce\n\16\r\16\16\16\u00cf\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7"+
		"\24\u00e6\n\24\f\24\16\24\u00e9\13\24\3\24\3\24\3\24\7\24\u00ee\n\24\f"+
		"\24\16\24\u00f1\13\24\3\24\5\24\u00f4\n\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$"+
		"\7$\u0155\n$\f$\16$\u0158\13$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\5"+
		"(\u0166\n(\3)\5)\u0169\n)\3*\3*\3*\3*\3*\3+\3+\3+\3+\5au\u0082\2,\5\3"+
		"\7\4\t\5\13\6\r\7\17\2\21\b\23\2\25\t\27\n\31\2\33\13\35\f\37\r!\16#\17"+
		"%\20\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35A\36"+
		"C\37E G!I\"K#M\2O\2Q\2S\2U$W\2\5\2\3\4\f\4\2\13\13\"\"\4\2((>>\4\2$$>"+
		">\4\2))>>\5\2\13\f\17\17\"\"\5\2\62;CHch\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9"+
		"\u0302\u0371\u2041\u2042\n\2<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801"+
		"\uf902\ufdd1\ufdf2\uffff\2\u017c\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3"+
		"%\3\2\2\2\3\'\3\2\2\2\3)\3\2\2\2\3+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61"+
		"\3\2\2\2\3\63\3\2\2\2\3\65\3\2\2\2\3\67\3\2\2\2\39\3\2\2\2\3;\3\2\2\2"+
		"\3=\3\2\2\2\3?\3\2\2\2\3A\3\2\2\2\3C\3\2\2\2\3E\3\2\2\2\3G\3\2\2\2\3I"+
		"\3\2\2\2\3K\3\2\2\2\4U\3\2\2\2\4W\3\2\2\2\5Y\3\2\2\2\7h\3\2\2\2\t|\3\2"+
		"\2\2\13\u0089\3\2\2\2\r\u00a2\3\2\2\2\17\u00a9\3\2\2\2\21\u00ad\3\2\2"+
		"\2\23\u00af\3\2\2\2\25\u00b1\3\2\2\2\27\u00b5\3\2\2\2\31\u00bf\3\2\2\2"+
		"\33\u00c8\3\2\2\2\35\u00cd\3\2\2\2\37\u00d1\3\2\2\2!\u00d5\3\2\2\2#\u00da"+
		"\3\2\2\2%\u00df\3\2\2\2\'\u00e1\3\2\2\2)\u00f3\3\2\2\2+\u00f5\3\2\2\2"+
		"-\u00fb\3\2\2\2/\u0100\3\2\2\2\61\u0108\3\2\2\2\63\u010d\3\2\2\2\65\u0113"+
		"\3\2\2\2\67\u0119\3\2\2\29\u0120\3\2\2\2;\u0126\3\2\2\2=\u0131\3\2\2\2"+
		"?\u013f\3\2\2\2A\u0144\3\2\2\2C\u0147\3\2\2\2E\u014a\3\2\2\2G\u014d\3"+
		"\2\2\2I\u0152\3\2\2\2K\u0159\3\2\2\2M\u015d\3\2\2\2O\u015f\3\2\2\2Q\u0165"+
		"\3\2\2\2S\u0168\3\2\2\2U\u016a\3\2\2\2W\u016f\3\2\2\2YZ\7>\2\2Z[\7#\2"+
		"\2[\\\7/\2\2\\]\7/\2\2]a\3\2\2\2^`\13\2\2\2_^\3\2\2\2`c\3\2\2\2ab\3\2"+
		"\2\2a_\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7/\2\2ef\7/\2\2fg\7@\2\2g\6\3\2\2"+
		"\2hi\7>\2\2ij\7#\2\2jk\7]\2\2kl\7E\2\2lm\7F\2\2mn\7C\2\2no\7V\2\2op\7"+
		"C\2\2pq\7]\2\2qu\3\2\2\2rt\13\2\2\2sr\3\2\2\2tw\3\2\2\2uv\3\2\2\2us\3"+
		"\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7_\2\2yz\7_\2\2z{\7@\2\2{\b\3\2\2\2|}\7>"+
		"\2\2}~\7#\2\2~\u0082\3\2\2\2\177\u0081\13\2\2\2\u0080\177\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7@\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\b\4\2\2\u0088\n\3\2\2\2\u0089\u008a\7(\2\2\u008a\u008b\5I$\2\u008b"+
		"\u008c\7=\2\2\u008c\f\3\2\2\2\u008d\u008e\7(\2\2\u008e\u008f\7%\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u0092\5O\'\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\7=\2\2\u0096\u00a3\3\2\2\2\u0097\u0098\7(\2\2\u0098\u0099\7%\2"+
		"\2\u0099\u009a\7z\2\2\u009a\u009c\3\2\2\2\u009b\u009d\5M&\2\u009c\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7=\2\2\u00a1\u00a3\3\2\2\2\u00a2\u008d\3\2"+
		"\2\2\u00a2\u0097\3\2\2\2\u00a3\16\3\2\2\2\u00a4\u00aa\t\2\2\2\u00a5\u00a7"+
		"\7\17\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2"+
		"\u00a8\u00aa\7\f\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a6\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\20\3\2\2\2\u00ad"+
		"\u00ae\5\17\7\2\u00ae\22\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\24\3\2\2\2\u00b1"+
		"\u00b2\5\23\t\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\b\n\3\2\u00b4\26\3\2\2"+
		"\2\u00b5\u00b6\7>\2\2\u00b6\u00b7\7A\2\2\u00b7\u00b8\7z\2\2\u00b8\u00b9"+
		"\7o\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\5K%\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\b\13\3\2\u00be\30\3\2\2\2\u00bf\u00c0\7>\2"+
		"\2\u00c0\u00c1\7A\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\5I$\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\b\f\4\2\u00c5\u00c6\b\f\5\2\u00c6\32\3\2\2\2\u00c7"+
		"\u00c9\5O\'\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2"+
		"\2\2\u00ca\u00cb\3\2\2\2\u00cb\34\3\2\2\2\u00cc\u00ce\n\3\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\36\3\2\2\2\u00d1\u00d2\7@\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\17\6"+
		"\2\u00d4 \3\2\2\2\u00d5\u00d6\7A\2\2\u00d6\u00d7\7@\2\2\u00d7\u00d8\3"+
		"\2\2\2\u00d8\u00d9\b\20\6\2\u00d9\"\3\2\2\2\u00da\u00db\7\61\2\2\u00db"+
		"\u00dc\7@\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\b\21\6\2\u00de$\3\2\2\2"+
		"\u00df\u00e0\7\61\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7?\2\2\u00e2(\3\2\2\2"+
		"\u00e3\u00e7\7$\2\2\u00e4\u00e6\n\4\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00f4\7$\2\2\u00eb\u00ef\7)\2\2\u00ec\u00ee\n\5\2"+
		"\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\7)\2\2\u00f3"+
		"\u00e3\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f4*\3\2\2\2\u00f5\u00f6\7o\2\2\u00f6"+
		"\u00f7\7h\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7e\2\2"+
		"\u00fa,\3\2\2\2\u00fb\u00fc\7o\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7w\2"+
		"\2\u00fe\u00ff\7r\2\2\u00ff.\3\2\2\2\u0100\u0101\7o\2\2\u0101\u0102\7"+
		"u\2\2\u0102\u0103\7w\2\2\u0103\u0104\7d\2\2\u0104\u0105\7u\2\2\u0105\u0106"+
		"\7w\2\2\u0106\u0107\7r\2\2\u0107\60\3\2\2\2\u0108\u0109\7o\2\2\u0109\u010a"+
		"\7u\2\2\u010a\u010b\7w\2\2\u010b\u010c\7d\2\2\u010c\62\3\2\2\2\u010d\u010e"+
		"\7o\2\2\u010e\u010f\7u\2\2\u010f\u0110\7s\2\2\u0110\u0111\7t\2\2\u0111"+
		"\u0112\7v\2\2\u0112\64\3\2\2\2\u0113\u0114\7o\2\2\u0114\u0115\7t\2\2\u0115"+
		"\u0116\7q\2\2\u0116\u0117\7q\2\2\u0117\u0118\7v\2\2\u0118\66\3\2\2\2\u0119"+
		"\u011a\7o\2\2\u011a\u011b\7w\2\2\u011b\u011c\7p\2\2\u011c\u011d\7f\2\2"+
		"\u011d\u011e\7g\2\2\u011e\u011f\7t\2\2\u011f8\3\2\2\2\u0120\u0121\7o\2"+
		"\2\u0121\u0122\7q\2\2\u0122\u0123\7x\2\2\u0123\u0124\7g\2\2\u0124\u0125"+
		"\7t\2\2\u0125:\3\2\2\2\u0126\u0127\7o\2\2\u0127\u0128\7w\2\2\u0128\u0129"+
		"\7p\2\2\u0129\u012a\7f\2\2\u012a\u012b\7g\2\2\u012b\u012c\7t\2\2\u012c"+
		"\u012d\7q\2\2\u012d\u012e\7x\2\2\u012e\u012f\7g\2\2\u012f\u0130\7t\2\2"+
		"\u0130<\3\2\2\2\u0131\u0132\7o\2\2\u0132\u0133\7o\2\2\u0133\u0134\7w\2"+
		"\2\u0134\u0135\7n\2\2\u0135\u0136\7v\2\2\u0136\u0137\7k\2\2\u0137\u0138"+
		"\7u\2\2\u0138\u0139\7e\2\2\u0139\u013a\7t\2\2\u013a\u013b\7k\2\2\u013b"+
		"\u013c\7r\2\2\u013c\u013d\7v\2\2\u013d\u013e\7u\2\2\u013e>\3\2\2\2\u013f"+
		"\u0140\7o\2\2\u0140\u0141\7t\2\2\u0141\u0142\7q\2\2\u0142\u0143\7y\2\2"+
		"\u0143@\3\2\2\2\u0144\u0145\7o\2\2\u0145\u0146\7q\2\2\u0146B\3\2\2\2\u0147"+
		"\u0148\7o\2\2\u0148\u0149\7p\2\2\u0149D\3\2\2\2\u014a\u014b\7o\2\2\u014b"+
		"\u014c\7k\2\2\u014cF\3\2\2\2\u014d\u014e\7r\2\2\u014e\u014f\7c\2\2\u014f"+
		"\u0150\7t\2\2\u0150\u0151\7c\2\2\u0151H\3\2\2\2\u0152\u0156\5S)\2\u0153"+
		"\u0155\5Q(\2\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2"+
		"\2\u0156\u0157\3\2\2\2\u0157J\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a"+
		"\t\6\2\2\u015a\u015b\3\2\2\2\u015b\u015c\b%\2\2\u015cL\3\2\2\2\u015d\u015e"+
		"\t\7\2\2\u015eN\3\2\2\2\u015f\u0160\t\b\2\2\u0160P\3\2\2\2\u0161\u0166"+
		"\5S)\2\u0162\u0166\t\t\2\2\u0163\u0166\5O\'\2\u0164\u0166\t\n\2\2\u0165"+
		"\u0161\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0164\3\2"+
		"\2\2\u0166R\3\2\2\2\u0167\u0169\t\13\2\2\u0168\u0167\3\2\2\2\u0169T\3"+
		"\2\2\2\u016a\u016b\7A\2\2\u016b\u016c\7@\2\2\u016c\u016d\3\2\2\2\u016d"+
		"\u016e\b*\6\2\u016eV\3\2\2\2\u016f\u0170\13\2\2\2\u0170\u0171\3\2\2\2"+
		"\u0171\u0172\b+\4\2\u0172X\3\2\2\2\26\2\3\4au\u0082\u0093\u009e\u00a2"+
		"\u00a6\u00a9\u00ab\u00ca\u00cf\u00e7\u00ef\u00f3\u0156\u0165\u0168\7\b"+
		"\2\2\7\3\2\5\2\2\7\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}