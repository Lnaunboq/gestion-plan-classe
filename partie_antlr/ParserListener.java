// Generated from Parser.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ParserParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ParserParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#parsing}.
	 * @param ctx the parse tree
	 */
	void enterParsing(ParserParser.ParsingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#parsing}.
	 * @param ctx the parse tree
	 */
	void exitParsing(ParserParser.ParsingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#declDisposition}.
	 * @param ctx the parse tree
	 */
	void enterDeclDisposition(ParserParser.DeclDispositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#declDisposition}.
	 * @param ctx the parse tree
	 */
	void exitDeclDisposition(ParserParser.DeclDispositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#declEleves}.
	 * @param ctx the parse tree
	 */
	void enterDeclEleves(ParserParser.DeclElevesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#declEleves}.
	 * @param ctx the parse tree
	 */
	void exitDeclEleves(ParserParser.DeclElevesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#declContrainte}.
	 * @param ctx the parse tree
	 */
	void enterDeclContrainte(ParserParser.DeclContrainteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#declContrainte}.
	 * @param ctx the parse tree
	 */
	void exitDeclContrainte(ParserParser.DeclContrainteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#blocDisposition}.
	 * @param ctx the parse tree
	 */
	void enterBlocDisposition(ParserParser.BlocDispositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#blocDisposition}.
	 * @param ctx the parse tree
	 */
	void exitBlocDisposition(ParserParser.BlocDispositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#regleAmenagement}.
	 * @param ctx the parse tree
	 */
	void enterRegleAmenagement(ParserParser.RegleAmenagementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#regleAmenagement}.
	 * @param ctx the parse tree
	 */
	void exitRegleAmenagement(ParserParser.RegleAmenagementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#blocEleves}.
	 * @param ctx the parse tree
	 */
	void enterBlocEleves(ParserParser.BlocElevesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#blocEleves}.
	 * @param ctx the parse tree
	 */
	void exitBlocEleves(ParserParser.BlocElevesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#eleve}.
	 * @param ctx the parse tree
	 */
	void enterEleve(ParserParser.EleveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#eleve}.
	 * @param ctx the parse tree
	 */
	void exitEleve(ParserParser.EleveContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#blocContraintes}.
	 * @param ctx the parse tree
	 */
	void enterBlocContraintes(ParserParser.BlocContraintesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#blocContraintes}.
	 * @param ctx the parse tree
	 */
	void exitBlocContraintes(ParserParser.BlocContraintesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#contraintes}.
	 * @param ctx the parse tree
	 */
	void enterContraintes(ParserParser.ContraintesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#contraintes}.
	 * @param ctx the parse tree
	 */
	void exitContraintes(ParserParser.ContraintesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(ParserParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(ParserParser.FinInstructionContext ctx);
}