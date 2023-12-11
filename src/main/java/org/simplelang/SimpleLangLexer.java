package org.simplelang;
// Generated from src/main/java/org/simplelang/SimpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, WHILE=4, FOR=5, PTR=6, TRUE=7, FALSE=8, TYPE=9, 
		EQ=10, DSEMIC=11, PLUS=12, MINUS=13, MUL=14, DIV=15, LARROW=16, LESS=17, 
		GREAT=18, CMP_EQ=19, CMP_NEQ=20, AND=21, OR=22, NOT=23, LPAR=24, RPAR=25, 
		LCURL=26, RCURL=27, QMARK=28, COMMA=29, COMMENT=30, WS=31, NL=32, INT=33, 
		FLOAT=34, CHAR=35, ID=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "WHILE", "FOR", "PTR", "TRUE", "FALSE", "TYPE", 
			"EQ", "DSEMIC", "PLUS", "MINUS", "MUL", "DIV", "LARROW", "LESS", "GREAT", 
			"CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", "LCURL", "RCURL", 
			"QMARK", "COMMA", "COMMENT", "WS", "NL", "INT", "FLOAT", "CHAR", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'proc'", "'ret'", "'at'", "'while'", "'for'", "'addr'", "'true'", 
			"'false'", null, "':='", "'::'", "'+'", "'-'", "'*'", "'/'", "'<-'", 
			"'<'", "'>'", "'='", "'/='", "'and'", "'or'", "'not'", "'('", "')'", 
			"'{'", "'}'", "'?'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "WHILE", "FOR", "PTR", "TRUE", "FALSE", "TYPE", 
			"EQ", "DSEMIC", "PLUS", "MINUS", "MUL", "DIV", "LARROW", "LESS", "GREAT", 
			"CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", "LCURL", "RCURL", 
			"QMARK", "COMMA", "COMMENT", "WS", "NL", "INT", "FLOAT", "CHAR", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

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
		"\u0004\u0000$\u00f2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0089\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u00c1\b\u001d\n\u001d\f\u001d\u00c4\t\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0003\u001e\u00cd\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u00d4\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0003 \u00d9\b \u0001 \u0004 \u00dc\b \u000b \f \u00dd\u0001!"+
		"\u0003!\u00e1\b!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0003#\u00ec\b#\u0001#\u0004#\u00ef\b#\u000b#\f#\u00f0\u0001"+
		"\u00c2\u0000$\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"E#G$\u0001\u0000\u0004\u0003\u0000\t\t\r\r  \u0001\u000009\u0003"+
		"\u000009AZaz\u0002\u0000AZaz\u00fd\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000"+
		"\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000"+
		";\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001"+
		"\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000"+
		"\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0001"+
		"I\u0001\u0000\u0000\u0000\u0003N\u0001\u0000\u0000\u0000\u0005R\u0001"+
		"\u0000\u0000\u0000\u0007U\u0001\u0000\u0000\u0000\t[\u0001\u0000\u0000"+
		"\u0000\u000b_\u0001\u0000\u0000\u0000\rd\u0001\u0000\u0000\u0000\u000f"+
		"i\u0001\u0000\u0000\u0000\u0011\u0088\u0001\u0000\u0000\u0000\u0013\u008a"+
		"\u0001\u0000\u0000\u0000\u0015\u008d\u0001\u0000\u0000\u0000\u0017\u0090"+
		"\u0001\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000\u001b\u0094"+
		"\u0001\u0000\u0000\u0000\u001d\u0096\u0001\u0000\u0000\u0000\u001f\u0098"+
		"\u0001\u0000\u0000\u0000!\u009b\u0001\u0000\u0000\u0000#\u009d\u0001\u0000"+
		"\u0000\u0000%\u009f\u0001\u0000\u0000\u0000\'\u00a1\u0001\u0000\u0000"+
		"\u0000)\u00a4\u0001\u0000\u0000\u0000+\u00a8\u0001\u0000\u0000\u0000-"+
		"\u00ab\u0001\u0000\u0000\u0000/\u00af\u0001\u0000\u0000\u00001\u00b1\u0001"+
		"\u0000\u0000\u00003\u00b3\u0001\u0000\u0000\u00005\u00b5\u0001\u0000\u0000"+
		"\u00007\u00b7\u0001\u0000\u0000\u00009\u00b9\u0001\u0000\u0000\u0000;"+
		"\u00bb\u0001\u0000\u0000\u0000=\u00cc\u0001\u0000\u0000\u0000?\u00d3\u0001"+
		"\u0000\u0000\u0000A\u00d8\u0001\u0000\u0000\u0000C\u00e0\u0001\u0000\u0000"+
		"\u0000E\u00e6\u0001\u0000\u0000\u0000G\u00eb\u0001\u0000\u0000\u0000I"+
		"J\u0005p\u0000\u0000JK\u0005r\u0000\u0000KL\u0005o\u0000\u0000LM\u0005"+
		"c\u0000\u0000M\u0002\u0001\u0000\u0000\u0000NO\u0005r\u0000\u0000OP\u0005"+
		"e\u0000\u0000PQ\u0005t\u0000\u0000Q\u0004\u0001\u0000\u0000\u0000RS\u0005"+
		"a\u0000\u0000ST\u0005t\u0000\u0000T\u0006\u0001\u0000\u0000\u0000UV\u0005"+
		"w\u0000\u0000VW\u0005h\u0000\u0000WX\u0005i\u0000\u0000XY\u0005l\u0000"+
		"\u0000YZ\u0005e\u0000\u0000Z\b\u0001\u0000\u0000\u0000[\\\u0005f\u0000"+
		"\u0000\\]\u0005o\u0000\u0000]^\u0005r\u0000\u0000^\n\u0001\u0000\u0000"+
		"\u0000_`\u0005a\u0000\u0000`a\u0005d\u0000\u0000ab\u0005d\u0000\u0000"+
		"bc\u0005r\u0000\u0000c\f\u0001\u0000\u0000\u0000de\u0005t\u0000\u0000"+
		"ef\u0005r\u0000\u0000fg\u0005u\u0000\u0000gh\u0005e\u0000\u0000h\u000e"+
		"\u0001\u0000\u0000\u0000ij\u0005f\u0000\u0000jk\u0005a\u0000\u0000kl\u0005"+
		"l\u0000\u0000lm\u0005s\u0000\u0000mn\u0005e\u0000\u0000n\u0010\u0001\u0000"+
		"\u0000\u0000op\u0005i\u0000\u0000pq\u0005n\u0000\u0000q\u0089\u0005t\u0000"+
		"\u0000rs\u0005f\u0000\u0000st\u0005l\u0000\u0000tu\u0005o\u0000\u0000"+
		"uv\u0005a\u0000\u0000v\u0089\u0005t\u0000\u0000wx\u0005b\u0000\u0000x"+
		"y\u0005o\u0000\u0000yz\u0005o\u0000\u0000z\u0089\u0005l\u0000\u0000{|"+
		"\u0005c\u0000\u0000|}\u0005h\u0000\u0000}~\u0005a\u0000\u0000~\u0089\u0005"+
		"r\u0000\u0000\u007f\u0080\u0005A\u0000\u0000\u0080\u0081\u0005r\u0000"+
		"\u0000\u0081\u0082\u0005r\u0000\u0000\u0082\u0083\u0005a\u0000\u0000\u0083"+
		"\u0089\u0005y\u0000\u0000\u0084\u0085\u0005v\u0000\u0000\u0085\u0086\u0005"+
		"o\u0000\u0000\u0086\u0087\u0005i\u0000\u0000\u0087\u0089\u0005d\u0000"+
		"\u0000\u0088o\u0001\u0000\u0000\u0000\u0088r\u0001\u0000\u0000\u0000\u0088"+
		"w\u0001\u0000\u0000\u0000\u0088{\u0001\u0000\u0000\u0000\u0088\u007f\u0001"+
		"\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u0012\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005:\u0000\u0000\u008b\u008c\u0005=\u0000"+
		"\u0000\u008c\u0014\u0001\u0000\u0000\u0000\u008d\u008e\u0005:\u0000\u0000"+
		"\u008e\u008f\u0005:\u0000\u0000\u008f\u0016\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005+\u0000\u0000\u0091\u0018\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005-\u0000\u0000\u0093\u001a\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"*\u0000\u0000\u0095\u001c\u0001\u0000\u0000\u0000\u0096\u0097\u0005/\u0000"+
		"\u0000\u0097\u001e\u0001\u0000\u0000\u0000\u0098\u0099\u0005<\u0000\u0000"+
		"\u0099\u009a\u0005-\u0000\u0000\u009a \u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0005<\u0000\u0000\u009c\"\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		">\u0000\u0000\u009e$\u0001\u0000\u0000\u0000\u009f\u00a0\u0005=\u0000"+
		"\u0000\u00a0&\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005/\u0000\u0000\u00a2"+
		"\u00a3\u0005=\u0000\u0000\u00a3(\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"a\u0000\u0000\u00a5\u00a6\u0005n\u0000\u0000\u00a6\u00a7\u0005d\u0000"+
		"\u0000\u00a7*\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005o\u0000\u0000\u00a9"+
		"\u00aa\u0005r\u0000\u0000\u00aa,\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"n\u0000\u0000\u00ac\u00ad\u0005o\u0000\u0000\u00ad\u00ae\u0005t\u0000"+
		"\u0000\u00ae.\u0001\u0000\u0000\u0000\u00af\u00b0\u0005(\u0000\u0000\u00b0"+
		"0\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005)\u0000\u0000\u00b22\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0005{\u0000\u0000\u00b44\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0005}\u0000\u0000\u00b66\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005?\u0000\u0000\u00b88\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005"+
		",\u0000\u0000\u00ba:\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005/\u0000"+
		"\u0000\u00bc\u00bd\u0005/\u0000\u0000\u00bd\u00be\u0005{\u0000\u0000\u00be"+
		"\u00c2\u0001\u0000\u0000\u0000\u00bf\u00c1\t\u0000\u0000\u0000\u00c0\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0005}\u0000\u0000\u00c6\u00c7\u0005/\u0000\u0000\u00c7\u00c8\u0005/"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0006\u001d"+
		"\u0000\u0000\u00ca<\u0001\u0000\u0000\u0000\u00cb\u00cd\u0007\u0000\u0000"+
		"\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0006\u001e\u0000\u0000\u00cf>\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005\r\u0000\u0000\u00d1\u00d4\u0005\n\u0000\u0000\u00d2"+
		"\u00d4\u0005\n\u0000\u0000\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0006\u001f\u0000\u0000\u00d6@\u0001\u0000\u0000\u0000\u00d7\u00d9\u0005"+
		"-\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000"+
		"\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00dc\u0007\u0001"+
		"\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000"+
		"\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000"+
		"\u0000\u0000\u00deB\u0001\u0000\u0000\u0000\u00df\u00e1\u0005-\u0000\u0000"+
		"\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0003A \u0000\u00e3\u00e4"+
		"\u0005.\u0000\u0000\u00e4\u00e5\u0003A \u0000\u00e5D\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0005\'\u0000\u0000\u00e7\u00e8\u0007\u0002\u0000\u0000"+
		"\u00e8\u00e9\u0005\'\u0000\u0000\u00e9F\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ec\u0005_\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00ef"+
		"\u0007\u0003\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f1H\u0001\u0000\u0000\u0000\n\u0000\u0088"+
		"\u00c2\u00cc\u00d3\u00d8\u00dd\u00e0\u00eb\u00f0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}