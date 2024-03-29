// Generated from /Users/aishayakupova/Documents/MT3/src/main/java/antlr/GoodLang.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GoodLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NAME=6, FUN_NAME_START=7, WS=8, 
		NUMBER=9, SIGN_1=10, SIGN_2=11, BKT_1=12, BKT_2=13, COMPARASON=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "NAME", "FUN_NAME_START", "WS", 
			"NUMBER", "SIGN_1", "SIGN_2", "BKT_1", "BKT_2", "COMPARASON"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'if ('", "'{'", "'}'", null, null, null, null, null, 
			null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NAME", "FUN_NAME_START", "WS", "NUMBER", 
			"SIGN_1", "SIGN_2", "BKT_1", "BKT_2", "COMPARASON"
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


	public GoodLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GoodLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7.\n\7\r\7\16\7/\3\7\7\7\63\n\7\f\7\16\7"+
		"\66\13\7\3\b\6\b9\n\b\r\b\16\b:\3\b\7\b>\n\b\f\b\16\bA\13\b\3\b\3\b\3"+
		"\t\6\tF\n\t\r\t\16\tG\3\t\3\t\3\n\7\nM\n\n\f\n\16\nP\13\n\3\n\6\nS\n\n"+
		"\r\n\16\nT\3\n\3\n\6\nY\n\n\r\n\16\nZ\7\n]\n\n\f\n\16\n`\13\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17s\n\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\3\2\t\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\3\2\63;\4"+
		"\2,,\61\61\4\2--//\4\2>>@@\2\u0080\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t(\3\2\2\2\13*\3\2\2\2\r-\3\2\2"+
		"\2\178\3\2\2\2\21E\3\2\2\2\23N\3\2\2\2\25a\3\2\2\2\27c\3\2\2\2\31e\3\2"+
		"\2\2\33g\3\2\2\2\35r\3\2\2\2\37 \7.\2\2 \4\3\2\2\2!\"\7?\2\2\"\6\3\2\2"+
		"\2#$\7k\2\2$%\7h\2\2%&\7\"\2\2&\'\7*\2\2\'\b\3\2\2\2()\7}\2\2)\n\3\2\2"+
		"\2*+\7\177\2\2+\f\3\2\2\2,.\t\2\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\64\3\2\2\2\61\63\t\3\2\2\62\61\3\2\2\2\63\66\3\2\2\2\64\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\16\3\2\2\2\66\64\3\2\2\2\679\t\2\2\28\67\3\2"+
		"\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;?\3\2\2\2<>\t\3\2\2=<\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7*\2\2C\20\3\2\2\2DF\t"+
		"\4\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\b\t\2\2J\22"+
		"\3\2\2\2KM\t\5\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2P"+
		"N\3\2\2\2QS\t\3\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U^\3\2\2\2"+
		"VX\7\60\2\2WY\t\3\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2"+
		"\2\\V\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\24\3\2\2\2`^\3\2\2\2ab\t"+
		"\6\2\2b\26\3\2\2\2cd\t\7\2\2d\30\3\2\2\2ef\7*\2\2f\32\3\2\2\2gh\7+\2\2"+
		"h\34\3\2\2\2is\t\b\2\2jk\7?\2\2ks\7?\2\2lm\7#\2\2ms\7?\2\2no\7>\2\2os"+
		"\7?\2\2pq\7@\2\2qs\7?\2\2ri\3\2\2\2rj\3\2\2\2rl\3\2\2\2rn\3\2\2\2rp\3"+
		"\2\2\2s\36\3\2\2\2\17\2-/\648:?GNTZ^r\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}