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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CONTRAINTES=8, 
		NOM=9, PRENOM=10, NOM_PRENOM=11, NEWLINE=12, WS=13, ENTIER=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "CONTRAINTES", 
			"LOWERCASE", "UPPERCASE", "NOM", "PRENOM", "NOM_PRENOM", "NEWLINE", "WS", 
			"ENTIER"
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
			null, null, null, null, null, null, null, null, "CONTRAINTES", "NOM", 
			"PRENOM", "NOM_PRENOM", "NEWLINE", "WS", "ENTIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\tk\n\t\3\n\3\n\3\13\3\13\3\f\3\f\6\fs\n\f\r\f\16\ft\3\r\5\rx\n\r\3\r"+
		"\3\r\6\r|\n\r\r\r\16\r}\3\16\3\16\3\16\3\16\3\17\5\17\u0085\n\17\3\17"+
		"\3\17\3\20\6\20\u008a\n\20\r\20\16\20\u008b\3\20\3\20\3\21\6\21\u0091"+
		"\n\21\r\21\16\21\u0092\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2"+
		"\25\2\27\13\31\f\33\r\35\16\37\17!\20\3\2\5\3\2c|\3\2C\\\4\2\13\13\"\""+
		"\2\u009c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5/\3\2\2\2\7"+
		"\66\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17M\3\2\2\2\21j\3\2\2\2"+
		"\23l\3\2\2\2\25n\3\2\2\2\27r\3\2\2\2\31w\3\2\2\2\33\177\3\2\2\2\35\u0084"+
		"\3\2\2\2\37\u0089\3\2\2\2!\u0090\3\2\2\2#$\7F\2\2$%\7K\2\2%&\7U\2\2&\'"+
		"\7R\2\2\'(\7Q\2\2()\7U\2\2)*\7K\2\2*+\7V\2\2+,\7K\2\2,-\7Q\2\2-.\7P\2"+
		"\2.\4\3\2\2\2/\60\7E\2\2\60\61\7N\2\2\61\62\7C\2\2\62\63\7U\2\2\63\64"+
		"\7U\2\2\64\65\7G\2\2\65\6\3\2\2\2\66\67\7E\2\2\678\7Q\2\289\7P\2\29:\7"+
		"V\2\2:;\7T\2\2;<\7C\2\2<=\7K\2\2=>\7P\2\2>?\7V\2\2?@\7G\2\2@A\7U\2\2A"+
		"\b\3\2\2\2BC\7}\2\2C\n\3\2\2\2DE\7\177\2\2E\f\3\2\2\2FG\7T\2\2GH\7c\2"+
		"\2HI\7p\2\2IJ\7i\2\2JK\7g\2\2KL\7g\2\2L\16\3\2\2\2MN\7=\2\2N\20\3\2\2"+
		"\2OP\7f\2\2PQ\7g\2\2QR\7x\2\2RS\7c\2\2ST\7p\2\2Tk\7v\2\2UV\7c\2\2VW\7"+
		"w\2\2WX\7\"\2\2XY\7h\2\2YZ\7q\2\2Z[\7p\2\2[k\7f\2\2\\]\7n\2\2]^\7q\2\2"+
		"^_\7k\2\2_`\7p\2\2`a\7\"\2\2ab\7f\2\2bk\7g\2\2cd\7r\2\2de\7t\2\2ef\7\u00ea"+
		"\2\2fg\7u\2\2gh\7\"\2\2hi\7f\2\2ik\7g\2\2jO\3\2\2\2jU\3\2\2\2j\\\3\2\2"+
		"\2jc\3\2\2\2k\22\3\2\2\2lm\t\2\2\2m\24\3\2\2\2no\t\3\2\2o\26\3\2\2\2p"+
		"s\5\25\13\2qs\7/\2\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2"+
		"u\30\3\2\2\2vx\5\25\13\2wv\3\2\2\2wx\3\2\2\2x{\3\2\2\2y|\5\23\n\2z|\7"+
		"/\2\2{y\3\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\32\3\2\2\2\177"+
		"\u0080\5\27\f\2\u0080\u0081\7a\2\2\u0081\u0082\5\31\r\2\u0082\34\3\2\2"+
		"\2\u0083\u0085\7\17\2\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\7\f\2\2\u0087\36\3\2\2\2\u0088\u008a\t\4\2"+
		"\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\20\2\2\u008e \3\2\2\2\u008f"+
		"\u0091\4\62;\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\"\3\2\2\2\f\2jrtw{}\u0084\u008b\u0092\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}