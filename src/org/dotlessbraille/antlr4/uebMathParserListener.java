// Generated from uebMathParser.g4 by ANTLR 4.9.2
 package org.dotlessbraille.antlr4; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link uebMathParser}.
 */
public interface uebMathParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link uebMathParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(uebMathParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(uebMathParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lineStart}.
	 * @param ctx the parse tree
	 */
	void enterLineStart(uebMathParser.LineStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lineStart}.
	 * @param ctx the parse tree
	 */
	void exitLineStart(uebMathParser.LineStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lineMiddle}.
	 * @param ctx the parse tree
	 */
	void enterLineMiddle(uebMathParser.LineMiddleContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lineMiddle}.
	 * @param ctx the parse tree
	 */
	void exitLineMiddle(uebMathParser.LineMiddleContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lineEnd}.
	 * @param ctx the parse tree
	 */
	void enterLineEnd(uebMathParser.LineEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lineEnd}.
	 * @param ctx the parse tree
	 */
	void exitLineEnd(uebMathParser.LineEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lineDone}.
	 * @param ctx the parse tree
	 */
	void enterLineDone(uebMathParser.LineDoneContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lineDone}.
	 * @param ctx the parse tree
	 */
	void exitLineDone(uebMathParser.LineDoneContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(uebMathParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(uebMathParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#strong_ws}.
	 * @param ctx the parse tree
	 */
	void enterStrong_ws(uebMathParser.Strong_wsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#strong_ws}.
	 * @param ctx the parse tree
	 */
	void exitStrong_ws(uebMathParser.Strong_wsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#digits}.
	 * @param ctx the parse tree
	 */
	void enterDigits(uebMathParser.DigitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#digits}.
	 * @param ctx the parse tree
	 */
	void exitDigits(uebMathParser.DigitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lowsigncon}.
	 * @param ctx the parse tree
	 */
	void enterLowsigncon(uebMathParser.LowsignconContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lowsigncon}.
	 * @param ctx the parse tree
	 */
	void exitLowsigncon(uebMathParser.LowsignconContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#lowAlone}.
	 * @param ctx the parse tree
	 */
	void enterLowAlone(uebMathParser.LowAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#lowAlone}.
	 * @param ctx the parse tree
	 */
	void exitLowAlone(uebMathParser.LowAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#standingAlone}.
	 * @param ctx the parse tree
	 */
	void enterStandingAlone(uebMathParser.StandingAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#standingAlone}.
	 * @param ctx the parse tree
	 */
	void exitStandingAlone(uebMathParser.StandingAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#flc}.
	 * @param ctx the parse tree
	 */
	void enterFlc(uebMathParser.FlcContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#flc}.
	 * @param ctx the parse tree
	 */
	void exitFlc(uebMathParser.FlcContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#ilc}.
	 * @param ctx the parse tree
	 */
	void enterIlc(uebMathParser.IlcContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#ilc}.
	 * @param ctx the parse tree
	 */
	void exitIlc(uebMathParser.IlcContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#strong_gs}.
	 * @param ctx the parse tree
	 */
	void enterStrong_gs(uebMathParser.Strong_gsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#strong_gs}.
	 * @param ctx the parse tree
	 */
	void exitStrong_gs(uebMathParser.Strong_gsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#largeSign}.
	 * @param ctx the parse tree
	 */
	void enterLargeSign(uebMathParser.LargeSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#largeSign}.
	 * @param ctx the parse tree
	 */
	void exitLargeSign(uebMathParser.LargeSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#newline}.
	 * @param ctx the parse tree
	 */
	void enterNewline(uebMathParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#newline}.
	 * @param ctx the parse tree
	 */
	void exitNewline(uebMathParser.NewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#space}.
	 * @param ctx the parse tree
	 */
	void enterSpace(uebMathParser.SpaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#space}.
	 * @param ctx the parse tree
	 */
	void exitSpace(uebMathParser.SpaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#indent}.
	 * @param ctx the parse tree
	 */
	void enterIndent(uebMathParser.IndentContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#indent}.
	 * @param ctx the parse tree
	 */
	void exitIndent(uebMathParser.IndentContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#separator}.
	 * @param ctx the parse tree
	 */
	void enterSeparator(uebMathParser.SeparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#separator}.
	 * @param ctx the parse tree
	 */
	void exitSeparator(uebMathParser.SeparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#trailingSep}.
	 * @param ctx the parse tree
	 */
	void enterTrailingSep(uebMathParser.TrailingSepContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#trailingSep}.
	 * @param ctx the parse tree
	 */
	void exitTrailingSep(uebMathParser.TrailingSepContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#thismode}.
	 * @param ctx the parse tree
	 */
	void enterThismode(uebMathParser.ThismodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#thismode}.
	 * @param ctx the parse tree
	 */
	void exitThismode(uebMathParser.ThismodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#startMode}.
	 * @param ctx the parse tree
	 */
	void enterStartMode(uebMathParser.StartModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#startMode}.
	 * @param ctx the parse tree
	 */
	void exitStartMode(uebMathParser.StartModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#endMode}.
	 * @param ctx the parse tree
	 */
	void enterEndMode(uebMathParser.EndModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#endMode}.
	 * @param ctx the parse tree
	 */
	void exitEndMode(uebMathParser.EndModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(uebMathParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(uebMathParser.BinopContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#numIndicator}.
	 * @param ctx the parse tree
	 */
	void enterNumIndicator(uebMathParser.NumIndicatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#numIndicator}.
	 * @param ctx the parse tree
	 */
	void exitNumIndicator(uebMathParser.NumIndicatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#simpleFraction}.
	 * @param ctx the parse tree
	 */
	void enterSimpleFraction(uebMathParser.SimpleFractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#simpleFraction}.
	 * @param ctx the parse tree
	 */
	void exitSimpleFraction(uebMathParser.SimpleFractionContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#frac}.
	 * @param ctx the parse tree
	 */
	void enterFrac(uebMathParser.FracContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#frac}.
	 * @param ctx the parse tree
	 */
	void exitFrac(uebMathParser.FracContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(uebMathParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(uebMathParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#angleBracket}.
	 * @param ctx the parse tree
	 */
	void enterAngleBracket(uebMathParser.AngleBracketContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#angleBracket}.
	 * @param ctx the parse tree
	 */
	void exitAngleBracket(uebMathParser.AngleBracketContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#compSymbols}.
	 * @param ctx the parse tree
	 */
	void enterCompSymbols(uebMathParser.CompSymbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#compSymbols}.
	 * @param ctx the parse tree
	 */
	void exitCompSymbols(uebMathParser.CompSymbolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#comp}.
	 * @param ctx the parse tree
	 */
	void enterComp(uebMathParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#comp}.
	 * @param ctx the parse tree
	 */
	void exitComp(uebMathParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#tcAlphaSeq}.
	 * @param ctx the parse tree
	 */
	void enterTcAlphaSeq(uebMathParser.TcAlphaSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#tcAlphaSeq}.
	 * @param ctx the parse tree
	 */
	void exitTcAlphaSeq(uebMathParser.TcAlphaSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#alphaSeq}.
	 * @param ctx the parse tree
	 */
	void enterAlphaSeq(uebMathParser.AlphaSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#alphaSeq}.
	 * @param ctx the parse tree
	 */
	void exitAlphaSeq(uebMathParser.AlphaSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#comma}.
	 * @param ctx the parse tree
	 */
	void enterComma(uebMathParser.CommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#comma}.
	 * @param ctx the parse tree
	 */
	void exitComma(uebMathParser.CommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#simpleWord}.
	 * @param ctx the parse tree
	 */
	void enterSimpleWord(uebMathParser.SimpleWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#simpleWord}.
	 * @param ctx the parse tree
	 */
	void exitSimpleWord(uebMathParser.SimpleWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#ff}.
	 * @param ctx the parse tree
	 */
	void enterFf(uebMathParser.FfContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#ff}.
	 * @param ctx the parse tree
	 */
	void exitFf(uebMathParser.FfContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(uebMathParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(uebMathParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#wordStart}.
	 * @param ctx the parse tree
	 */
	void enterWordStart(uebMathParser.WordStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#wordStart}.
	 * @param ctx the parse tree
	 */
	void exitWordStart(uebMathParser.WordStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#wordMiddle}.
	 * @param ctx the parse tree
	 */
	void enterWordMiddle(uebMathParser.WordMiddleContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#wordMiddle}.
	 * @param ctx the parse tree
	 */
	void exitWordMiddle(uebMathParser.WordMiddleContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#wordEnding}.
	 * @param ctx the parse tree
	 */
	void enterWordEnding(uebMathParser.WordEndingContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#wordEnding}.
	 * @param ctx the parse tree
	 */
	void exitWordEnding(uebMathParser.WordEndingContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#flcERROR}.
	 * @param ctx the parse tree
	 */
	void enterFlcERROR(uebMathParser.FlcERRORContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#flcERROR}.
	 * @param ctx the parse tree
	 */
	void exitFlcERROR(uebMathParser.FlcERRORContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr2(uebMathParser.Expr2Context ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr2(uebMathParser.Expr2Context ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#oGroup}.
	 * @param ctx the parse tree
	 */
	void enterOGroup(uebMathParser.OGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#oGroup}.
	 * @param ctx the parse tree
	 */
	void exitOGroup(uebMathParser.OGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#cGroup}.
	 * @param ctx the parse tree
	 */
	void enterCGroup(uebMathParser.CGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#cGroup}.
	 * @param ctx the parse tree
	 */
	void exitCGroup(uebMathParser.CGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#g1MathRoots}.
	 * @param ctx the parse tree
	 */
	void enterG1MathRoots(uebMathParser.G1MathRootsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#g1MathRoots}.
	 * @param ctx the parse tree
	 */
	void exitG1MathRoots(uebMathParser.G1MathRootsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#fracStart}.
	 * @param ctx the parse tree
	 */
	void enterFracStart(uebMathParser.FracStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#fracStart}.
	 * @param ctx the parse tree
	 */
	void exitFracStart(uebMathParser.FracStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#fracEnd}.
	 * @param ctx the parse tree
	 */
	void enterFracEnd(uebMathParser.FracEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#fracEnd}.
	 * @param ctx the parse tree
	 */
	void exitFracEnd(uebMathParser.FracEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#fracLine}.
	 * @param ctx the parse tree
	 */
	void enterFracLine(uebMathParser.FracLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#fracLine}.
	 * @param ctx the parse tree
	 */
	void exitFracLine(uebMathParser.FracLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#mLsub}.
	 * @param ctx the parse tree
	 */
	void enterMLsub(uebMathParser.MLsubContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#mLsub}.
	 * @param ctx the parse tree
	 */
	void exitMLsub(uebMathParser.MLsubContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#mLsup}.
	 * @param ctx the parse tree
	 */
	void enterMLsup(uebMathParser.MLsupContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#mLsup}.
	 * @param ctx the parse tree
	 */
	void exitMLsup(uebMathParser.MLsupContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#brlogrp}.
	 * @param ctx the parse tree
	 */
	void enterBrlogrp(uebMathParser.BrlogrpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#brlogrp}.
	 * @param ctx the parse tree
	 */
	void exitBrlogrp(uebMathParser.BrlogrpContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#brlcgrp}.
	 * @param ctx the parse tree
	 */
	void enterBrlcgrp(uebMathParser.BrlcgrpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#brlcgrp}.
	 * @param ctx the parse tree
	 */
	void exitBrlcgrp(uebMathParser.BrlcgrpContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#supExpr}.
	 * @param ctx the parse tree
	 */
	void enterSupExpr(uebMathParser.SupExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#supExpr}.
	 * @param ctx the parse tree
	 */
	void exitSupExpr(uebMathParser.SupExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#subsupExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubsupExpr(uebMathParser.SubsupExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#subsupExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubsupExpr(uebMathParser.SubsupExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#subExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(uebMathParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#subExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(uebMathParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#cfrac}.
	 * @param ctx the parse tree
	 */
	void enterCfrac(uebMathParser.CfracContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#cfrac}.
	 * @param ctx the parse tree
	 */
	void exitCfrac(uebMathParser.CfracContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#numModeItem}.
	 * @param ctx the parse tree
	 */
	void enterNumModeItem(uebMathParser.NumModeItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#numModeItem}.
	 * @param ctx the parse tree
	 */
	void exitNumModeItem(uebMathParser.NumModeItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#numModeContent}.
	 * @param ctx the parse tree
	 */
	void enterNumModeContent(uebMathParser.NumModeContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#numModeContent}.
	 * @param ctx the parse tree
	 */
	void exitNumModeContent(uebMathParser.NumModeContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#g1WrdOrPssg}.
	 * @param ctx the parse tree
	 */
	void enterG1WrdOrPssg(uebMathParser.G1WrdOrPssgContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#g1WrdOrPssg}.
	 * @param ctx the parse tree
	 */
	void exitG1WrdOrPssg(uebMathParser.G1WrdOrPssgContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#g1TERM}.
	 * @param ctx the parse tree
	 */
	void enterG1TERM(uebMathParser.G1TERMContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#g1TERM}.
	 * @param ctx the parse tree
	 */
	void exitG1TERM(uebMathParser.G1TERMContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#numericPassage}.
	 * @param ctx the parse tree
	 */
	void enterNumericPassage(uebMathParser.NumericPassageContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#numericPassage}.
	 * @param ctx the parse tree
	 */
	void exitNumericPassage(uebMathParser.NumericPassageContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#endNumPassage}.
	 * @param ctx the parse tree
	 */
	void enterEndNumPassage(uebMathParser.EndNumPassageContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#endNumPassage}.
	 * @param ctx the parse tree
	 */
	void exitEndNumPassage(uebMathParser.EndNumPassageContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#hyphen}.
	 * @param ctx the parse tree
	 */
	void enterHyphen(uebMathParser.HyphenContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#hyphen}.
	 * @param ctx the parse tree
	 */
	void exitHyphen(uebMathParser.HyphenContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#dash}.
	 * @param ctx the parse tree
	 */
	void enterDash(uebMathParser.DashContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#dash}.
	 * @param ctx the parse tree
	 */
	void exitDash(uebMathParser.DashContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#long_dash}.
	 * @param ctx the parse tree
	 */
	void enterLong_dash(uebMathParser.Long_dashContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#long_dash}.
	 * @param ctx the parse tree
	 */
	void exitLong_dash(uebMathParser.Long_dashContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#shortForms}.
	 * @param ctx the parse tree
	 */
	void enterShortForms(uebMathParser.ShortFormsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#shortForms}.
	 * @param ctx the parse tree
	 */
	void exitShortForms(uebMathParser.ShortFormsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#justALetter}.
	 * @param ctx the parse tree
	 */
	void enterJustALetter(uebMathParser.JustALetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#justALetter}.
	 * @param ctx the parse tree
	 */
	void exitJustALetter(uebMathParser.JustALetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#singleLetter}.
	 * @param ctx the parse tree
	 */
	void enterSingleLetter(uebMathParser.SingleLetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#singleLetter}.
	 * @param ctx the parse tree
	 */
	void exitSingleLetter(uebMathParser.SingleLetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#ucLetters}.
	 * @param ctx the parse tree
	 */
	void enterUcLetters(uebMathParser.UcLettersContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#ucLetters}.
	 * @param ctx the parse tree
	 */
	void exitUcLetters(uebMathParser.UcLettersContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#saLetters}.
	 * @param ctx the parse tree
	 */
	void enterSaLetters(uebMathParser.SaLettersContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#saLetters}.
	 * @param ctx the parse tree
	 */
	void exitSaLetters(uebMathParser.SaLettersContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#standAloneCon}.
	 * @param ctx the parse tree
	 */
	void enterStandAloneCon(uebMathParser.StandAloneConContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#standAloneCon}.
	 * @param ctx the parse tree
	 */
	void exitStandAloneCon(uebMathParser.StandAloneConContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#preNoQuotes}.
	 * @param ctx the parse tree
	 */
	void enterPreNoQuotes(uebMathParser.PreNoQuotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#preNoQuotes}.
	 * @param ctx the parse tree
	 */
	void exitPreNoQuotes(uebMathParser.PreNoQuotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#preLow}.
	 * @param ctx the parse tree
	 */
	void enterPreLow(uebMathParser.PreLowContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#preLow}.
	 * @param ctx the parse tree
	 */
	void exitPreLow(uebMathParser.PreLowContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#preAlone}.
	 * @param ctx the parse tree
	 */
	void enterPreAlone(uebMathParser.PreAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#preAlone}.
	 * @param ctx the parse tree
	 */
	void exitPreAlone(uebMathParser.PreAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#postOk}.
	 * @param ctx the parse tree
	 */
	void enterPostOk(uebMathParser.PostOkContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#postOk}.
	 * @param ctx the parse tree
	 */
	void exitPostOk(uebMathParser.PostOkContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#postAlone}.
	 * @param ctx the parse tree
	 */
	void enterPostAlone(uebMathParser.PostAloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#postAlone}.
	 * @param ctx the parse tree
	 */
	void exitPostAlone(uebMathParser.PostAloneContext ctx);
	/**
	 * Enter a parse tree produced by {@link uebMathParser#oops}.
	 * @param ctx the parse tree
	 */
	void enterOops(uebMathParser.OopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uebMathParser#oops}.
	 * @param ctx the parse tree
	 */
	void exitOops(uebMathParser.OopsContext ctx);
}