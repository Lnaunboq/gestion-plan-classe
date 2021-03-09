// Generated from Parser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NOM=8, PRENOM=9, 
		NOM_PRENOM=10, CONTRAINTES=11, NEWLINE=12, WS=13, ENTIER=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "LOWERCASE", 
			"UPPERCASE", "NOM", "PRENOM", "NOM_PRENOM", "CONTRAINTES", "NEWLINE", 
			"WS", "ENTIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DISPOSITION'", "'CLASSE'", "'CONTRAINTES'", "'{'", "'}'", "'Rangee'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "NOM", "PRENOM", "NOM_PRENOM", 
			"CONTRAINTES", "NEWLINE", "WS", "ENTIER"
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


	public ParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Parser.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\6\13V\n\13\r"+
		"\13\16\13W\3\f\5\f[\n\f\3\f\3\f\6\f_\n\f\r\f\16\f`\3\r\3\r\6\re\n\r\r"+
		"\r\16\rf\3\r\3\r\5\rk\n\r\3\r\3\r\6\ro\n\r\r\r\16\rp\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008e\n\16\3\17"+
		"\5\17\u0091\n\17\3\17\3\17\3\20\6\20\u0096\n\20\r\20\16\20\u0097\3\20"+
		"\3\20\3\21\6\21\u009d\n\21\r\21\16\21\u009e\2\2\22\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\2\23\2\25\n\27\13\31\f\33\r\35\16\37\17!\20\3\2\5\3\2c"+
		"|\3\2C\\\4\2\13\13\"\"\2\u00ad\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3"+
		"\2\2\2\5/\3\2\2\2\7\66\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17M\3"+
		"\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25U\3\2\2\2\27Z\3\2\2\2\31d\3\2\2\2\33"+
		"\u008d\3\2\2\2\35\u0090\3\2\2\2\37\u0095\3\2\2\2!\u009c\3\2\2\2#$\7F\2"+
		"\2$%\7K\2\2%&\7U\2\2&\'\7R\2\2\'(\7Q\2\2()\7U\2\2)*\7K\2\2*+\7V\2\2+,"+
		"\7K\2\2,-\7Q\2\2-.\7P\2\2.\4\3\2\2\2/\60\7E\2\2\60\61\7N\2\2\61\62\7C"+
		"\2\2\62\63\7U\2\2\63\64\7U\2\2\64\65\7G\2\2\65\6\3\2\2\2\66\67\7E\2\2"+
		"\678\7Q\2\289\7P\2\29:\7V\2\2:;\7T\2\2;<\7C\2\2<=\7K\2\2=>\7P\2\2>?\7"+
		"V\2\2?@\7G\2\2@A\7U\2\2A\b\3\2\2\2BC\7}\2\2C\n\3\2\2\2DE\7\177\2\2E\f"+
		"\3\2\2\2FG\7T\2\2GH\7c\2\2HI\7p\2\2IJ\7i\2\2JK\7g\2\2KL\7g\2\2L\16\3\2"+
		"\2\2MN\7=\2\2N\20\3\2\2\2OP\t\2\2\2P\22\3\2\2\2QR\t\3\2\2R\24\3\2\2\2"+
		"SV\5\23\n\2TV\7/\2\2US\3\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2"+
		"X\26\3\2\2\2Y[\5\23\n\2ZY\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\_\5\21\t\2]_\7"+
		"/\2\2^\\\3\2\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\30\3\2\2\2b"+
		"e\5\23\n\2ce\7/\2\2db\3\2\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"gh\3\2\2\2hj\7a\2\2ik\5\23\n\2ji\3\2\2\2jk\3\2\2\2kn\3\2\2\2lo\5\21\t"+
		"\2mo\7/\2\2nl\3\2\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\32\3\2"+
		"\2\2rs\7f\2\2st\7g\2\2tu\7x\2\2uv\7c\2\2vw\7p\2\2w\u008e\7v\2\2xy\7c\2"+
		"\2yz\7w\2\2z{\7\"\2\2{|\7h\2\2|}\7q\2\2}~\7p\2\2~\u008e\7f\2\2\177\u0080"+
		"\7n\2\2\u0080\u0081\7q\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083"+
		"\u0084\7\"\2\2\u0084\u0085\7f\2\2\u0085\u008e\7g\2\2\u0086\u0087\7r\2"+
		"\2\u0087\u0088\7t\2\2\u0088\u0089\7\u00ea\2\2\u0089\u008a\7u\2\2\u008a"+
		"\u008b\7\"\2\2\u008b\u008c\7f\2\2\u008c\u008e\7g\2\2\u008dr\3\2\2\2\u008d"+
		"x\3\2\2\2\u008d\177\3\2\2\2\u008d\u0086\3\2\2\2\u008e\34\3\2\2\2\u008f"+
		"\u0091\7\17\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3"+
		"\2\2\2\u0092\u0093\7\f\2\2\u0093\36\3\2\2\2\u0094\u0096\t\4\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\b\20\2\2\u009a \3\2\2\2\u009b\u009d"+
		"\4\62;\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\"\3\2\2\2\21\2UWZ^`dfjnp\u008d\u0090\u0097\u009e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}