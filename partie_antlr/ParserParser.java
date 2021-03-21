// Generated from Parser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, CONTRAINTES=9, 
		IDENTIFIANT=10, NEWLINE=11, WS=12, ENTIER=13;
	public static final int
		RULE_start = 0, RULE_parsing = 1, RULE_declDisposition = 2, RULE_declEleves = 3, 
		RULE_declContrainte = 4, RULE_blocDisposition = 5, RULE_regleAmenagement = 6, 
		RULE_blocEleves = 7, RULE_eleve = 8, RULE_blocContraintes = 9, RULE_contraintes = 10, 
		RULE_finInstruction = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "parsing", "declDisposition", "declEleves", "declContrainte", 
			"blocDisposition", "regleAmenagement", "blocEleves", "eleve", "blocContraintes", 
			"contraintes", "finInstruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DISPOSITION'", "'CLASSE'", "'CONTRAINTES'", "'{'", "'}'", "'rangees'", 
			"'Rangee'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "CONTRAINTES", 
			"IDENTIFIANT", "NEWLINE", "WS", "ENTIER"
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

	@Override
	public String getGrammarFileName() { return "Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    private String fonctionEvalContrainteSimple (String eleve, String constraint, ConstraintBuilder constraintBuilder, Classroom classe) { //évalue la contrainte donnée par son abbréviation
	      if (classe.getStudent(eleve) != null){ //si l'élève existe dans la classe
	        if ( constraint.equals("D") ){
	            constraintBuilder.build("au rang", classe.getStudent(eleve), 1); //on positionne la contrainte sur l'eleve au premier rang
	            return eleve + " va devant ";
	        } else if ( constraint.equals("F") ){
	            constraintBuilder.build("au rang", classe.getStudent(eleve), classe.getRowNumber()-1); //on positionne la contrainte sur l'eleve au dernier rang
	            return eleve + " va au fond.";
	        } else if ( constraint.equals("L") ){
	            return " loin de ";
	        } else if ( constraint.equals("P") ){
	                return " près de ";
	        } else {
	           System.err.println("Contraine incorrecte : '"+constraint+"'");
	           throw new IllegalArgumentException("Opérateur arithmÃ©tique incorrect : '"+constraint+"'");
	        }
	      }
	      else {
	        return "L\'élève \"" + eleve + "\" n\'a pas été trouvé dans la classe.";
	      }
	    }

	    private String fonctionEvalContrainteDouble (String eleve1, String eleve2, String constraint, ConstraintBuilder constraintBuilder, Classroom classe) {
	      if (classe.getStudent(eleve1) != null && eleve2 !=null){ //si les élèves existent dans la classe
	        if ( constraint.equals("L") ){
	            constraintBuilder.build("loin de", classe.getStudent(eleve1), classe.getStudent(eleve2));
	            return eleve1 + " loin de " + eleve2;
	        } else if ( constraint.equals("P") ){
	            constraintBuilder.build("a cote de", classe.getStudent(eleve1), classe.getStudent(eleve2));
	            return eleve1 + " près de " + eleve2;
	        } else {
	           System.err.println("Contraine incorrecte : '"+constraint+"'");
	           throw new IllegalArgumentException("Opérateur arithmÃ©tique incorrect : '"+constraint+"'");
	        }
	      }
	      else {
	        return "L élève " + eleve1 + " ou " + eleve2 + "n a pas été trouvé dans la classe.";
	      }
	    }

	    public Classroom classe;
	    private ConstraintBuilder constraintBuilder = new ConstraintBuilder();

	public ParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ParsingContext parsing() {
			return getRuleContext(ParsingContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ParserParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			parsing();
			setState(25);
			match(EOF);
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

	public static class ParsingContext extends ParserRuleContext {
		public String code;
		public DeclDispositionContext declDisposition;
		public DeclElevesContext declEleves;
		public DeclContrainteContext declContrainte;
		public List<DeclDispositionContext> declDisposition() {
			return getRuleContexts(DeclDispositionContext.class);
		}
		public DeclDispositionContext declDisposition(int i) {
			return getRuleContext(DeclDispositionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ParserParser.NEWLINE, i);
		}
		public List<DeclElevesContext> declEleves() {
			return getRuleContexts(DeclElevesContext.class);
		}
		public DeclElevesContext declEleves(int i) {
			return getRuleContext(DeclElevesContext.class,i);
		}
		public List<DeclContrainteContext> declContrainte() {
			return getRuleContexts(DeclContrainteContext.class);
		}
		public DeclContrainteContext declContrainte(int i) {
			return getRuleContext(DeclContrainteContext.class,i);
		}
		public ParsingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parsing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterParsing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitParsing(this);
		}
	}

	public final ParsingContext parsing() throws RecognitionException {
		ParsingContext _localctx = new ParsingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parsing);
		 ((ParsingContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				((ParsingContext)_localctx).declDisposition = declDisposition();
				 _localctx.code += ((ParsingContext)_localctx).declDisposition.code; 
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(35);
					match(NEWLINE);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(41);
				((ParsingContext)_localctx).declEleves = declEleves();
				 _localctx.code += ((ParsingContext)_localctx).declEleves.code; 
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(49);
				match(NEWLINE);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(55);
				((ParsingContext)_localctx).declContrainte = declContrainte();
				 _localctx.code += ((ParsingContext)_localctx).declContrainte.code; 
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "\n---fin de l\'interprétation---\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class DeclDispositionContext extends ParserRuleContext {
		public String code;
		public BlocDispositionContext blocDisposition;
		public BlocDispositionContext blocDisposition() {
			return getRuleContext(BlocDispositionContext.class,0);
		}
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public DeclDispositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declDisposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDeclDisposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDeclDisposition(this);
		}
	}

	public final DeclDispositionContext declDisposition() throws RecognitionException {
		DeclDispositionContext _localctx = new DeclDispositionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declDisposition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__0);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(66);
				finInstruction();
				}
			}

			setState(69);
			((DeclDispositionContext)_localctx).blocDisposition = blocDisposition();
			setState(70);
			finInstruction();

			          ((DeclDispositionContext)_localctx).code =  ((DeclDispositionContext)_localctx).blocDisposition.code;
			        
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

	public static class DeclElevesContext extends ParserRuleContext {
		public String code;
		public BlocElevesContext blocEleves;
		public BlocElevesContext blocEleves() {
			return getRuleContext(BlocElevesContext.class,0);
		}
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public DeclElevesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declEleves; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDeclEleves(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDeclEleves(this);
		}
	}

	public final DeclElevesContext declEleves() throws RecognitionException {
		DeclElevesContext _localctx = new DeclElevesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declEleves);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__1);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(74);
				finInstruction();
				}
			}

			setState(77);
			((DeclElevesContext)_localctx).blocEleves = blocEleves();
			setState(78);
			finInstruction();

			          ((DeclElevesContext)_localctx).code =  ((DeclElevesContext)_localctx).blocEleves.code;
			        
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

	public static class DeclContrainteContext extends ParserRuleContext {
		public String code;
		public BlocContraintesContext blocContraintes;
		public BlocContraintesContext blocContraintes() {
			return getRuleContext(BlocContraintesContext.class,0);
		}
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public DeclContrainteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declContrainte; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDeclContrainte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDeclContrainte(this);
		}
	}

	public final DeclContrainteContext declContrainte() throws RecognitionException {
		DeclContrainteContext _localctx = new DeclContrainteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declContrainte);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(T__2);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(82);
				finInstruction();
				}
			}

			setState(85);
			((DeclContrainteContext)_localctx).blocContraintes = blocContraintes();
			setState(86);
			finInstruction();

			          ((DeclContrainteContext)_localctx).code =  ((DeclContrainteContext)_localctx).blocContraintes.code;
			        
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

	public static class BlocDispositionContext extends ParserRuleContext {
		public String code;
		public RegleAmenagementContext regleAmenagement;
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public List<RegleAmenagementContext> regleAmenagement() {
			return getRuleContexts(RegleAmenagementContext.class);
		}
		public RegleAmenagementContext regleAmenagement(int i) {
			return getRuleContext(RegleAmenagementContext.class,i);
		}
		public BlocDispositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocDisposition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBlocDisposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBlocDisposition(this);
		}
	}

	public final BlocDispositionContext blocDisposition() throws RecognitionException {
		BlocDispositionContext _localctx = new BlocDispositionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_blocDisposition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((BlocDispositionContext)_localctx).code =  "Disposion de la salle :\n";
			setState(90);
			match(T__3);
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(91);
				finInstruction();
				}
				break;
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==ENTIER) {
				{
				{
				setState(94);
				((BlocDispositionContext)_localctx).regleAmenagement = regleAmenagement();
				_localctx.code += ((BlocDispositionContext)_localctx).regleAmenagement.code + "\n";
				setState(96);
				finInstruction();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(103);
				finInstruction();
				}
			}

			setState(106);
			match(T__4);
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

	public static class RegleAmenagementContext extends ParserRuleContext {
		public String code;
		public Token ENTIER;
		public Token num;
		public Token nbr;
		public List<TerminalNode> ENTIER() { return getTokens(ParserParser.ENTIER); }
		public TerminalNode ENTIER(int i) {
			return getToken(ParserParser.ENTIER, i);
		}
		public RegleAmenagementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regleAmenagement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterRegleAmenagement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitRegleAmenagement(this);
		}
	}

	public final RegleAmenagementContext regleAmenagement() throws RecognitionException {
		RegleAmenagementContext _localctx = new RegleAmenagementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_regleAmenagement);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				((RegleAmenagementContext)_localctx).ENTIER = match(ENTIER);
				setState(109);
				match(T__5);

				        ((RegleAmenagementContext)_localctx).code =  "La classe contient " + (((RegleAmenagementContext)_localctx).ENTIER!=null?((RegleAmenagementContext)_localctx).ENTIER.getText():null) + " rangées.";
				        classe = new Classroom(Integer.parseInt((((RegleAmenagementContext)_localctx).ENTIER!=null?((RegleAmenagementContext)_localctx).ENTIER.getText():null))); //on transforme l'objet ENTIER en type int puis on le passe à Classroom qui a besoin de connaître son nombre de rangée pour être instanciée
				      
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__6);
				setState(112);
				((RegleAmenagementContext)_localctx).num = match(ENTIER);
				setState(113);
				((RegleAmenagementContext)_localctx).nbr = match(ENTIER);

				        ((RegleAmenagementContext)_localctx).code =  "La rangée numéro " + (((RegleAmenagementContext)_localctx).num!=null?((RegleAmenagementContext)_localctx).num.getText():null) + " possède " + (((RegleAmenagementContext)_localctx).nbr!=null?((RegleAmenagementContext)_localctx).nbr.getText():null) + " tables.";
				        //Méthode pour déclarer à la classe une nouvelle rangée;
				        classe.setNumberOfPlace(Integer.parseInt((((RegleAmenagementContext)_localctx).num!=null?((RegleAmenagementContext)_localctx).num.getText():null)), Integer.parseInt((((RegleAmenagementContext)_localctx).nbr!=null?((RegleAmenagementContext)_localctx).nbr.getText():null)));
				      
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

	public static class BlocElevesContext extends ParserRuleContext {
		public String code;
		public EleveContext eleve;
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public List<EleveContext> eleve() {
			return getRuleContexts(EleveContext.class);
		}
		public EleveContext eleve(int i) {
			return getRuleContext(EleveContext.class,i);
		}
		public BlocElevesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocEleves; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBlocEleves(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBlocEleves(this);
		}
	}

	public final BlocElevesContext blocEleves() throws RecognitionException {
		BlocElevesContext _localctx = new BlocElevesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_blocEleves);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((BlocElevesContext)_localctx).code =  "\nListe des élèves :\n";
			setState(118);
			match(T__3);
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(119);
				finInstruction();
				}
				break;
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIANT) {
				{
				{
				setState(122);
				((BlocElevesContext)_localctx).eleve = eleve();
				_localctx.code += ((BlocElevesContext)_localctx).eleve.code  + "\n";
				setState(124);
				finInstruction();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(131);
				finInstruction();
				}
			}

			setState(134);
			match(T__4);
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

	public static class EleveContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public TerminalNode IDENTIFIANT() { return getToken(ParserParser.IDENTIFIANT, 0); }
		public EleveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eleve; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterEleve(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitEleve(this);
		}
	}

	public final EleveContext eleve() throws RecognitionException {
		EleveContext _localctx = new EleveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_eleve);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((EleveContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			((EleveContext)_localctx).code =  (((EleveContext)_localctx).IDENTIFIANT!=null?((EleveContext)_localctx).IDENTIFIANT.getText():null);
			      classe.addStudent((((EleveContext)_localctx).IDENTIFIANT!=null?((EleveContext)_localctx).IDENTIFIANT.getText():null));
			      
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

	public static class BlocContraintesContext extends ParserRuleContext {
		public String code;
		public ContraintesContext contraintes;
		public List<FinInstructionContext> finInstruction() {
			return getRuleContexts(FinInstructionContext.class);
		}
		public FinInstructionContext finInstruction(int i) {
			return getRuleContext(FinInstructionContext.class,i);
		}
		public List<ContraintesContext> contraintes() {
			return getRuleContexts(ContraintesContext.class);
		}
		public ContraintesContext contraintes(int i) {
			return getRuleContext(ContraintesContext.class,i);
		}
		public BlocContraintesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blocContraintes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBlocContraintes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBlocContraintes(this);
		}
	}

	public final BlocContraintesContext blocContraintes() throws RecognitionException {
		BlocContraintesContext _localctx = new BlocContraintesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blocContraintes);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((BlocContraintesContext)_localctx).code =  "\nListe des contraintes :\n";
			setState(140);
			match(T__3);
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(141);
				finInstruction();
				}
				break;
			}
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					((BlocContraintesContext)_localctx).contraintes = contraintes();
					_localctx.code += ((BlocContraintesContext)_localctx).contraintes.code;
					setState(146);
					finInstruction();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7 || _la==NEWLINE) {
				{
				setState(153);
				finInstruction();
				}
			}

			setState(156);
			match(T__4);

				 System.out.println(classe.evaluate(constraintBuilder.getConstraints()));
			      
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

	public static class ContraintesContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public Token CONTRAINTES;
		public Token eleve1;
		public Token eleve2;
		public List<TerminalNode> IDENTIFIANT() { return getTokens(ParserParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(ParserParser.IDENTIFIANT, i);
		}
		public TerminalNode CONTRAINTES() { return getToken(ParserParser.CONTRAINTES, 0); }
		public ContraintesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contraintes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterContraintes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitContraintes(this);
		}
	}

	public final ContraintesContext contraintes() throws RecognitionException {
		ContraintesContext _localctx = new ContraintesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_contraintes);
		try {
			int _alt;
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				((ContraintesContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(160);
				((ContraintesContext)_localctx).CONTRAINTES = match(CONTRAINTES);

				        ((ContraintesContext)_localctx).code =  fonctionEvalContrainteSimple((((ContraintesContext)_localctx).IDENTIFIANT!=null?((ContraintesContext)_localctx).IDENTIFIANT.getText():null), (((ContraintesContext)_localctx).CONTRAINTES!=null?((ContraintesContext)_localctx).CONTRAINTES.getText():null), constraintBuilder, classe) + "\n"; //c'est la fonctionEval qui se charge d'ajouter la contrainte à la classe si elle est valide
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				((ContraintesContext)_localctx).eleve1 = match(IDENTIFIANT);
				setState(163);
				((ContraintesContext)_localctx).CONTRAINTES = match(CONTRAINTES);
				setState(164);
				((ContraintesContext)_localctx).eleve2 = match(IDENTIFIANT);

				        ((ContraintesContext)_localctx).code =  fonctionEvalContrainteDouble((((ContraintesContext)_localctx).eleve1!=null?((ContraintesContext)_localctx).eleve1.getText():null), (((ContraintesContext)_localctx).eleve2!=null?((ContraintesContext)_localctx).eleve2.getText():null), (((ContraintesContext)_localctx).CONTRAINTES!=null?((ContraintesContext)_localctx).CONTRAINTES.getText():null), constraintBuilder, classe) + "\n"; //on a préféré faire deux fonctions d'évaluation qu'une surcharge en fonction du nombre d'étudiants passés
				      
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(166);
						matchWildcard();
						}
						} 
					}
					setState(171);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}

					((ContraintesContext)_localctx).code =  "Syntaxe de contrainte non reconnue !";
					
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(ParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ParserParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(175);
					_la = _input.LA(1);
					if ( !(_la==T__7 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(178); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17\u00b7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3\3"+
		"\3\3\4\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\5\3\5\5\5N\n\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\5\6V\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7_\n\7\3\7\3\7\3\7\3\7\7"+
		"\7e\n\7\f\7\16\7h\13\7\3\7\5\7k\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\bv\n\b\3\t\3\t\3\t\5\t{\n\t\3\t\3\t\3\t\3\t\7\t\u0081\n\t\f\t\16"+
		"\t\u0084\13\t\3\t\5\t\u0087\n\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13"+
		"\u0091\n\13\3\13\3\13\3\13\3\13\7\13\u0097\n\13\f\13\16\13\u009a\13\13"+
		"\3\13\5\13\u009d\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00aa\n\f\f\f\16\f\u00ad\13\f\3\f\5\f\u00b0\n\f\3\r\6\r\u00b3\n\r\r"+
		"\r\16\r\u00b4\3\r\3\u00ab\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\4\2\n"+
		"\n\r\r\2\u00c0\2\32\3\2\2\2\4\"\3\2\2\2\6C\3\2\2\2\bK\3\2\2\2\nS\3\2\2"+
		"\2\f[\3\2\2\2\16u\3\2\2\2\20w\3\2\2\2\22\u008a\3\2\2\2\24\u008d\3\2\2"+
		"\2\26\u00af\3\2\2\2\30\u00b2\3\2\2\2\32\33\5\4\3\2\33\34\7\2\2\3\34\3"+
		"\3\2\2\2\35\36\5\6\4\2\36\37\b\3\1\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2\2"+
		"\" \3\2\2\2\"#\3\2\2\2#(\3\2\2\2$\"\3\2\2\2%\'\7\r\2\2&%\3\2\2\2\'*\3"+
		"\2\2\2(&\3\2\2\2()\3\2\2\2)\60\3\2\2\2*(\3\2\2\2+,\5\b\5\2,-\b\3\1\2-"+
		"/\3\2\2\2.+\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\66\3\2\2"+
		"\2\62\60\3\2\2\2\63\65\7\r\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2"+
		"\66\67\3\2\2\2\67>\3\2\2\28\66\3\2\2\29:\5\n\6\2:;\b\3\1\2;=\3\2\2\2<"+
		"9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\b\3\1\2"+
		"B\5\3\2\2\2CE\7\3\2\2DF\5\30\r\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\5\f\7"+
		"\2HI\5\30\r\2IJ\b\4\1\2J\7\3\2\2\2KM\7\4\2\2LN\5\30\r\2ML\3\2\2\2MN\3"+
		"\2\2\2NO\3\2\2\2OP\5\20\t\2PQ\5\30\r\2QR\b\5\1\2R\t\3\2\2\2SU\7\5\2\2"+
		"TV\5\30\r\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\5\24\13\2XY\5\30\r\2YZ\b\6"+
		"\1\2Z\13\3\2\2\2[\\\b\7\1\2\\^\7\6\2\2]_\5\30\r\2^]\3\2\2\2^_\3\2\2\2"+
		"_f\3\2\2\2`a\5\16\b\2ab\b\7\1\2bc\5\30\r\2ce\3\2\2\2d`\3\2\2\2eh\3\2\2"+
		"\2fd\3\2\2\2fg\3\2\2\2gj\3\2\2\2hf\3\2\2\2ik\5\30\r\2ji\3\2\2\2jk\3\2"+
		"\2\2kl\3\2\2\2lm\7\7\2\2m\r\3\2\2\2no\7\17\2\2op\7\b\2\2pv\b\b\1\2qr\7"+
		"\t\2\2rs\7\17\2\2st\7\17\2\2tv\b\b\1\2un\3\2\2\2uq\3\2\2\2v\17\3\2\2\2"+
		"wx\b\t\1\2xz\7\6\2\2y{\5\30\r\2zy\3\2\2\2z{\3\2\2\2{\u0082\3\2\2\2|}\5"+
		"\22\n\2}~\b\t\1\2~\177\5\30\r\2\177\u0081\3\2\2\2\u0080|\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0086\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0087\5\30\r\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7\7\2\2\u0089\21\3\2\2"+
		"\2\u008a\u008b\7\f\2\2\u008b\u008c\b\n\1\2\u008c\23\3\2\2\2\u008d\u008e"+
		"\b\13\1\2\u008e\u0090\7\6\2\2\u008f\u0091\5\30\r\2\u0090\u008f\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0098\3\2\2\2\u0092\u0093\5\26\f\2\u0093\u0094"+
		"\b\13\1\2\u0094\u0095\5\30\r\2\u0095\u0097\3\2\2\2\u0096\u0092\3\2\2\2"+
		"\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009d\5\30\r\2\u009c\u009b\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\7\2\2\u009f\u00a0"+
		"\b\13\1\2\u00a0\25\3\2\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3\7\13\2\2\u00a3"+
		"\u00b0\b\f\1\2\u00a4\u00a5\7\f\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7\7"+
		"\f\2\2\u00a7\u00b0\b\f\1\2\u00a8\u00aa\13\2\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\b\f\1\2\u00af\u00a1\3\2\2\2\u00af"+
		"\u00a4\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0\27\3\2\2\2\u00b1\u00b3\t\2\2"+
		"\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\31\3\2\2\2\27\"(\60\66>EMU^fjuz\u0082\u0086\u0090\u0098"+
		"\u009c\u00ab\u00af\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}