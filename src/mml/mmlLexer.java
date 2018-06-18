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
		MROOT=22, MUNDER=23, LAY=24, ROW=25, MO=26, MN=27, MI=28, Name=29, S=30, 
		PI=31;
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
		"MSUP", "MSUBSUP", "MSUB", "MSQRT", "MROOT", "MUNDER", "LAY", "ROW", "MO", 
		"MN", "MI", "Name", "S", "HEXDIGIT", "DIGIT", "NameChar", "NameStartChar", 
		"PI", "IGNORE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'>'", 
		null, "'/>'", "'/'", "'='", null, "'mfrac'", "'msup'", "'msubsup'", "'msub'", 
		"'msqrt'", "'mroot'", "'munder'", null, "'mrow'", "'mo'", "'mn'", "'mi'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMENT", "CDATA", "DTD", "EntityRef", "CharRef", "SEA_WS", "OPEN", 
		"XMLDeclOpen", "INTEG", "TEXT", "CLOSE", "SPECIAL_CLOSE", "SLASH_CLOSE", 
		"SLASH", "EQUALS", "STRING", "MFRAC", "MSUP", "MSUBSUP", "MSUB", "MSQRT", 
		"MROOT", "MUNDER", "LAY", "ROW", "MO", "MN", "MI", "Name", "S", "PI"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u015a\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3n\n\3\f\3\16\3q\13\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\7\4{\n\4\f\4\16\4~\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\6\6\u008c\n\6\r\6\16\6\u008d\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\6\6\u0097\n\6\r\6\16\6\u0098\3\6\3\6\5\6\u009d\n\6\3\7\3\7\5\7\u00a1"+
		"\n\7\3\7\6\7\u00a4\n\7\r\7\16\7\u00a5\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\6\r\u00c3\n\r\r\r\16\r\u00c4\3\16\6\16\u00c8\n\16\r\16"+
		"\16\16\u00c9\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u00e0\n\24\f\24\16\24"+
		"\u00e3\13\24\3\24\3\24\3\24\7\24\u00e8\n\24\f\24\16\24\u00eb\13\24\3\24"+
		"\5\24\u00ee\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u012a\n\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\7!\u013c\n!\f!\16!\u013f\13!"+
		"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\5%\u014d\n%\3&\5&\u0150\n&\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\5[o|\2)\5\3\7\4\t\5\13\6\r\7\17\2\21\b"+
		"\23\2\25\t\27\n\31\2\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25"+
		"\61\26\63\27\65\30\67\319\32;\33=\34?\35A\36C\37E G\2I\2K\2M\2O!Q\2\5"+
		"\2\3\4\f\4\2\13\13\"\"\4\2((>>\4\2$$>>\4\2))>>\5\2\13\f\17\17\"\"\5\2"+
		"\62;CHch\3\2\62;\4\2/\60aa\5\2\u00b9\u00b9\u0302\u0371\u2041\u2042\n\2"+
		"<<C\\c|\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\2"+
		"\u0164\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2\2\2\3)\3"+
		"\2\2\2\3+\3\2\2\2\3-\3\2\2\2\3/\3\2\2\2\3\61\3\2\2\2\3\63\3\2\2\2\3\65"+
		"\3\2\2\2\3\67\3\2\2\2\39\3\2\2\2\3;\3\2\2\2\3=\3\2\2\2\3?\3\2\2\2\3A\3"+
		"\2\2\2\3C\3\2\2\2\3E\3\2\2\2\4O\3\2\2\2\4Q\3\2\2\2\5S\3\2\2\2\7b\3\2\2"+
		"\2\tv\3\2\2\2\13\u0083\3\2\2\2\r\u009c\3\2\2\2\17\u00a3\3\2\2\2\21\u00a7"+
		"\3\2\2\2\23\u00a9\3\2\2\2\25\u00ab\3\2\2\2\27\u00af\3\2\2\2\31\u00b9\3"+
		"\2\2\2\33\u00c2\3\2\2\2\35\u00c7\3\2\2\2\37\u00cb\3\2\2\2!\u00cf\3\2\2"+
		"\2#\u00d4\3\2\2\2%\u00d9\3\2\2\2\'\u00db\3\2\2\2)\u00ed\3\2\2\2+\u00ef"+
		"\3\2\2\2-\u00f5\3\2\2\2/\u00fa\3\2\2\2\61\u0102\3\2\2\2\63\u0107\3\2\2"+
		"\2\65\u010d\3\2\2\2\67\u0113\3\2\2\29\u0129\3\2\2\2;\u012b\3\2\2\2=\u0130"+
		"\3\2\2\2?\u0133\3\2\2\2A\u0136\3\2\2\2C\u0139\3\2\2\2E\u0140\3\2\2\2G"+
		"\u0144\3\2\2\2I\u0146\3\2\2\2K\u014c\3\2\2\2M\u014f\3\2\2\2O\u0151\3\2"+
		"\2\2Q\u0156\3\2\2\2ST\7>\2\2TU\7#\2\2UV\7/\2\2VW\7/\2\2W[\3\2\2\2XZ\13"+
		"\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2][\3\2\2\2^"+
		"_\7/\2\2_`\7/\2\2`a\7@\2\2a\6\3\2\2\2bc\7>\2\2cd\7#\2\2de\7]\2\2ef\7E"+
		"\2\2fg\7F\2\2gh\7C\2\2hi\7V\2\2ij\7C\2\2jk\7]\2\2ko\3\2\2\2ln\13\2\2\2"+
		"ml\3\2\2\2nq\3\2\2\2op\3\2\2\2om\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7_\2\2"+
		"st\7_\2\2tu\7@\2\2u\b\3\2\2\2vw\7>\2\2wx\7#\2\2x|\3\2\2\2y{\13\2\2\2z"+
		"y\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080"+
		"\7@\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\4\2\2\u0082\n\3\2\2\2\u0083"+
		"\u0084\7(\2\2\u0084\u0085\5C!\2\u0085\u0086\7=\2\2\u0086\f\3\2\2\2\u0087"+
		"\u0088\7(\2\2\u0088\u0089\7%\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5I$\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7=\2\2\u0090\u009d\3\2\2\2\u0091"+
		"\u0092\7(\2\2\u0092\u0093\7%\2\2\u0093\u0094\7z\2\2\u0094\u0096\3\2\2"+
		"\2\u0095\u0097\5G#\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7=\2\2\u009b"+
		"\u009d\3\2\2\2\u009c\u0087\3\2\2\2\u009c\u0091\3\2\2\2\u009d\16\3\2\2"+
		"\2\u009e\u00a4\t\2\2\2\u009f\u00a1\7\17\2\2\u00a0\u009f\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\7\f\2\2\u00a3\u009e\3\2"+
		"\2\2\u00a3\u00a0\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\20\3\2\2\2\u00a7\u00a8\5\17\7\2\u00a8\22\3\2\2\2"+
		"\u00a9\u00aa\7>\2\2\u00aa\24\3\2\2\2\u00ab\u00ac\5\23\t\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\b\n\3\2\u00ae\26\3\2\2\2\u00af\u00b0\7>\2\2\u00b0"+
		"\u00b1\7A\2\2\u00b1\u00b2\7z\2\2\u00b2\u00b3\7o\2\2\u00b3\u00b4\7n\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b6\5E\"\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\b\13\3\2\u00b8\30\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\u00bb\7A\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\5C!\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\f\4"+
		"\2\u00bf\u00c0\b\f\5\2\u00c0\32\3\2\2\2\u00c1\u00c3\5I$\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\34\3\2\2\2\u00c6\u00c8\n\3\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2"+
		"\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\36\3\2\2\2\u00cb\u00cc"+
		"\7@\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\17\6\2\u00ce \3\2\2\2\u00cf"+
		"\u00d0\7A\2\2\u00d0\u00d1\7@\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\20"+
		"\6\2\u00d3\"\3\2\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d8\b\21\6\2\u00d8$\3\2\2\2\u00d9\u00da\7\61\2\2\u00da"+
		"&\3\2\2\2\u00db\u00dc\7?\2\2\u00dc(\3\2\2\2\u00dd\u00e1\7$\2\2\u00de\u00e0"+
		"\n\4\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00ee\7$"+
		"\2\2\u00e5\u00e9\7)\2\2\u00e6\u00e8\n\5\2\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\7)\2\2\u00ed\u00dd\3\2\2\2\u00ed"+
		"\u00e5\3\2\2\2\u00ee*\3\2\2\2\u00ef\u00f0\7o\2\2\u00f0\u00f1\7h\2\2\u00f1"+
		"\u00f2\7t\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7e\2\2\u00f4,\3\2\2\2\u00f5"+
		"\u00f6\7o\2\2\u00f6\u00f7\7u\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7r\2\2"+
		"\u00f9.\3\2\2\2\u00fa\u00fb\7o\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7w\2"+
		"\2\u00fd\u00fe\7d\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7w\2\2\u0100\u0101"+
		"\7r\2\2\u0101\60\3\2\2\2\u0102\u0103\7o\2\2\u0103\u0104\7u\2\2\u0104\u0105"+
		"\7w\2\2\u0105\u0106\7d\2\2\u0106\62\3\2\2\2\u0107\u0108\7o\2\2\u0108\u0109"+
		"\7u\2\2\u0109\u010a\7s\2\2\u010a\u010b\7t\2\2\u010b\u010c\7v\2\2\u010c"+
		"\64\3\2\2\2\u010d\u010e\7o\2\2\u010e\u010f\7t\2\2\u010f\u0110\7q\2\2\u0110"+
		"\u0111\7q\2\2\u0111\u0112\7v\2\2\u0112\66\3\2\2\2\u0113\u0114\7o\2\2\u0114"+
		"\u0115\7w\2\2\u0115\u0116\7p\2\2\u0116\u0117\7f\2\2\u0117\u0118\7g\2\2"+
		"\u0118\u0119\7t\2\2\u01198\3\2\2\2\u011a\u011b\7o\2\2\u011b\u011c\7q\2"+
		"\2\u011c\u011d\7x\2\2\u011d\u011e\7g\2\2\u011e\u012a\7t\2\2\u011f\u0120"+
		"\7o\2\2\u0120\u0121\7w\2\2\u0121\u0122\7p\2\2\u0122\u0123\7f\2\2\u0123"+
		"\u0124\7g\2\2\u0124\u0125\7t\2\2\u0125\u0126\7q\2\2\u0126\u0127\7x\2\2"+
		"\u0127\u0128\7g\2\2\u0128\u012a\7t\2\2\u0129\u011a\3\2\2\2\u0129\u011f"+
		"\3\2\2\2\u012a:\3\2\2\2\u012b\u012c\7o\2\2\u012c\u012d\7t\2\2\u012d\u012e"+
		"\7q\2\2\u012e\u012f\7y\2\2\u012f<\3\2\2\2\u0130\u0131\7o\2\2\u0131\u0132"+
		"\7q\2\2\u0132>\3\2\2\2\u0133\u0134\7o\2\2\u0134\u0135\7p\2\2\u0135@\3"+
		"\2\2\2\u0136\u0137\7o\2\2\u0137\u0138\7k\2\2\u0138B\3\2\2\2\u0139\u013d"+
		"\5M&\2\u013a\u013c\5K%\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013eD\3\2\2\2\u013f\u013d\3\2\2\2"+
		"\u0140\u0141\t\6\2\2\u0141\u0142\3\2\2\2\u0142\u0143\b\"\2\2\u0143F\3"+
		"\2\2\2\u0144\u0145\t\7\2\2\u0145H\3\2\2\2\u0146\u0147\t\b\2\2\u0147J\3"+
		"\2\2\2\u0148\u014d\5M&\2\u0149\u014d\t\t\2\2\u014a\u014d\5I$\2\u014b\u014d"+
		"\t\n\2\2\u014c\u0148\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014b\3\2\2\2\u014dL\3\2\2\2\u014e\u0150\t\13\2\2\u014f\u014e\3\2\2\2"+
		"\u0150N\3\2\2\2\u0151\u0152\7A\2\2\u0152\u0153\7@\2\2\u0153\u0154\3\2"+
		"\2\2\u0154\u0155\b\'\6\2\u0155P\3\2\2\2\u0156\u0157\13\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\u0159\b(\4\2\u0159R\3\2\2\2\27\2\3\4[o|\u008d\u0098\u009c"+
		"\u00a0\u00a3\u00a5\u00c4\u00c9\u00e1\u00e9\u00ed\u0129\u013d\u014c\u014f"+
		"\7\b\2\2\7\3\2\5\2\2\7\4\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}