// Generated from uebMathParser.g4 by ANTLR 4.9.2
 package org.dotlessbraille.antlr4; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class uebMathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STARTING_MODE=1, START_NUMERIC_MODE=2, START_NUMERIC_PASSAGE=3, G1PassageInd=4, 
		G1WordInd=5, CapsPassageInd=6, CapsWordInd=7, CapitalLetter=8, MODIF=9, 
		SPLOW=10, LOWCON=11, ILC5=12, ILC45=13, ILC456=14, FLC46=15, FLC56=16, 
		STRONG_WS=17, STRONG_GS=18, APOS_END=19, APOS_UC_END=20, BINOP=21, MLSQRTO=22, 
		MLSQRTC=23, OGROUP=24, CGROUP=25, MLFRACS=26, MLFRACIL=27, MLFRACE=28, 
		MLSUB=29, MLSUP=30, MLROWS=31, MLROWE=32, SPACED_SYMBOLS=33, COMP_SYMBOLS=34, 
		LEFTangleOrLT=35, RIGHTangleOrGT=36, PR_TOKEN=37, COMMA_ROOT=38, DOT4=39, 
		DOT5=40, DOT6=41, DOTS45=42, DOTS56=43, DOTS46=44, DOTS456=45, DOT2=46, 
		DOTS23=47, DOTS25=48, DOTS256=49, DOTS235=50, DOTS2356=51, DOTS236=52, 
		DOTS356=53, DOTS26=54, DOTS35=55, ROOT=56, PERIOD_ROOT=57, SLASH_ROOT=58, 
		AND_ROOT=59, FOR_ROOT=60, OF_ROOT=61, THE_ROOT=62, WITH_ROOT=63, CapsTermInd=64, 
		G1SymInd=65, G1TermInd=66, SFB=67, CHSF=68, SHSF=69, SFCC=70, STSF=71, 
		OURSELVES=72, THSF=73, ERSF=74, ONESELF=75, THMSLVS=76, CONCV=77, ALPHA_SEQ=78, 
		LETTERA=79, LETTERB=80, UPDIGS=81, LETTERK=82, MOST_LETTERS=83, DOTS34=84, 
		DOTS36=85, DOTS126=86, DOTS345=87, DOTS346=88, DOT3=89, DOTS146=90, DOTS156=91, 
		OForFRACS=92, THE=93, WITHorFRCE=94, DOTS16=95, DOTS1456=96, DOTS1256=97, 
		DOTS12456=98, DOTS246=99, DOTS1246=100, INDENT=101, SPACE=102, NEWLINE=103, 
		MISC=104, EXIT_NUMERIC_PASSAGE=105, LETTERS_NOT_DIGITS=106, LETTER_NOT_DIGIT=107, 
		DIGITS=108, NP_NEWLINE=109, NUMERIC_LABEL=110, SIMPLE_FRACTION_LINE=111, 
		MFRACS=112, MFRACIL=113, MFRACE=114, NPSPACE=115, NPNEWLINE=116, COMMENT=117, 
		NP_PR_TOKEN_1=118, NP_ROOT=119, NP_MISC=120, NUM_SIMPLE_FRAC_LINEx=121, 
		NUM_CONT_NUM_SPACE=122, NUM_CONT=123, NUM_SPACE_DIGIT=124, NDIG_SEQ=125, 
		NUM_SIMPLE_FRAC_LINE=126, END_NM_with_FRACE=127, END_NM_with_G1=128, END_NM_with_G1TERM=129, 
		END_NM_with_SPACE=130, END_NM_with_WINNL=131, END_NM_with_DASH=132, END_NM_with_HYPHEN=133, 
		END_NM_with_ALPHA=134, END_NM_with_K2Z=135, NM_FRACE=136, NMFRACIL=137, 
		PR_TOKEN_1=138, PR_TOKEN_2=139, PR_TOKEN_3=140, ROOT_1=141, NUM_MISC=142, 
		END_SPECG1_with_G1TERM=143, ANOTHER_SPACE=144, CAP_ZED=145, LATIN_LETTER=146, 
		FUN_NAME=147, SHORTFORM=148, SFA=149, SFC=150;
	public static final int
		RULE_text = 0, RULE_lineStart = 1, RULE_lineMiddle = 2, RULE_lineEnd = 3, 
		RULE_lineDone = 4, RULE_line = 5, RULE_strong_ws = 6, RULE_digits = 7, 
		RULE_lowsigncon = 8, RULE_lowAlone = 9, RULE_standingAlone = 10, RULE_flc = 11, 
		RULE_ilc = 12, RULE_strong_gs = 13, RULE_largeSign = 14, RULE_newline = 15, 
		RULE_space = 16, RULE_indent = 17, RULE_separator = 18, RULE_trailingSep = 19, 
		RULE_thismode = 20, RULE_startMode = 21, RULE_endMode = 22, RULE_binop = 23, 
		RULE_numIndicator = 24, RULE_simpleFraction = 25, RULE_frac = 26, RULE_item = 27, 
		RULE_angleBracket = 28, RULE_compSymbols = 29, RULE_comp = 30, RULE_tcAlphaSeq = 31, 
		RULE_alphaSeq = 32, RULE_comma = 33, RULE_simpleWord = 34, RULE_ff = 35, 
		RULE_word = 36, RULE_wordStart = 37, RULE_wordMiddle = 38, RULE_wordEnding = 39, 
		RULE_flcERROR = 40, RULE_expr2 = 41, RULE_oGroup = 42, RULE_cGroup = 43, 
		RULE_g1MathRoots = 44, RULE_fracStart = 45, RULE_fracEnd = 46, RULE_fracLine = 47, 
		RULE_mLsub = 48, RULE_mLsup = 49, RULE_brlogrp = 50, RULE_brlcgrp = 51, 
		RULE_supExpr = 52, RULE_subsupExpr = 53, RULE_subExpr = 54, RULE_cfrac = 55, 
		RULE_numModeItem = 56, RULE_numModeContent = 57, RULE_g1WrdOrPssg = 58, 
		RULE_g1TERM = 59, RULE_numericPassage = 60, RULE_endNumPassage = 61, RULE_hyphen = 62, 
		RULE_dash = 63, RULE_long_dash = 64, RULE_shortForms = 65, RULE_justALetter = 66, 
		RULE_singleLetter = 67, RULE_ucLetters = 68, RULE_saLetters = 69, RULE_standAloneCon = 70, 
		RULE_preNoQuotes = 71, RULE_preLow = 72, RULE_preAlone = 73, RULE_postOk = 74, 
		RULE_postAlone = 75, RULE_oops = 76;
	private static String[] makeRuleNames() {
		return new String[] {
			"text", "lineStart", "lineMiddle", "lineEnd", "lineDone", "line", "strong_ws", 
			"digits", "lowsigncon", "lowAlone", "standingAlone", "flc", "ilc", "strong_gs", 
			"largeSign", "newline", "space", "indent", "separator", "trailingSep", 
			"thismode", "startMode", "endMode", "binop", "numIndicator", "simpleFraction", 
			"frac", "item", "angleBracket", "compSymbols", "comp", "tcAlphaSeq", 
			"alphaSeq", "comma", "simpleWord", "ff", "word", "wordStart", "wordMiddle", 
			"wordEnding", "flcERROR", "expr2", "oGroup", "cGroup", "g1MathRoots", 
			"fracStart", "fracEnd", "fracLine", "mLsub", "mLsup", "brlogrp", "brlcgrp", 
			"supExpr", "subsupExpr", "subExpr", "cfrac", "numModeItem", "numModeContent", 
			"g1WrdOrPssg", "g1TERM", "numericPassage", "endNumPassage", "hyphen", 
			"dash", "long_dash", "shortForms", "justALetter", "singleLetter", "ucLetters", 
			"saLetters", "standAloneCon", "preNoQuotes", "preLow", "preAlone", "postOk", 
			"postAlone", "oops"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'Z'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STARTING_MODE", "START_NUMERIC_MODE", "START_NUMERIC_PASSAGE", 
			"G1PassageInd", "G1WordInd", "CapsPassageInd", "CapsWordInd", "CapitalLetter", 
			"MODIF", "SPLOW", "LOWCON", "ILC5", "ILC45", "ILC456", "FLC46", "FLC56", 
			"STRONG_WS", "STRONG_GS", "APOS_END", "APOS_UC_END", "BINOP", "MLSQRTO", 
			"MLSQRTC", "OGROUP", "CGROUP", "MLFRACS", "MLFRACIL", "MLFRACE", "MLSUB", 
			"MLSUP", "MLROWS", "MLROWE", "SPACED_SYMBOLS", "COMP_SYMBOLS", "LEFTangleOrLT", 
			"RIGHTangleOrGT", "PR_TOKEN", "COMMA_ROOT", "DOT4", "DOT5", "DOT6", "DOTS45", 
			"DOTS56", "DOTS46", "DOTS456", "DOT2", "DOTS23", "DOTS25", "DOTS256", 
			"DOTS235", "DOTS2356", "DOTS236", "DOTS356", "DOTS26", "DOTS35", "ROOT", 
			"PERIOD_ROOT", "SLASH_ROOT", "AND_ROOT", "FOR_ROOT", "OF_ROOT", "THE_ROOT", 
			"WITH_ROOT", "CapsTermInd", "G1SymInd", "G1TermInd", "SFB", "CHSF", "SHSF", 
			"SFCC", "STSF", "OURSELVES", "THSF", "ERSF", "ONESELF", "THMSLVS", "CONCV", 
			"ALPHA_SEQ", "LETTERA", "LETTERB", "UPDIGS", "LETTERK", "MOST_LETTERS", 
			"DOTS34", "DOTS36", "DOTS126", "DOTS345", "DOTS346", "DOT3", "DOTS146", 
			"DOTS156", "OForFRACS", "THE", "WITHorFRCE", "DOTS16", "DOTS1456", "DOTS1256", 
			"DOTS12456", "DOTS246", "DOTS1246", "INDENT", "SPACE", "NEWLINE", "MISC", 
			"EXIT_NUMERIC_PASSAGE", "LETTERS_NOT_DIGITS", "LETTER_NOT_DIGIT", "DIGITS", 
			"NP_NEWLINE", "NUMERIC_LABEL", "SIMPLE_FRACTION_LINE", "MFRACS", "MFRACIL", 
			"MFRACE", "NPSPACE", "NPNEWLINE", "COMMENT", "NP_PR_TOKEN_1", "NP_ROOT", 
			"NP_MISC", "NUM_SIMPLE_FRAC_LINEx", "NUM_CONT_NUM_SPACE", "NUM_CONT", 
			"NUM_SPACE_DIGIT", "NDIG_SEQ", "NUM_SIMPLE_FRAC_LINE", "END_NM_with_FRACE", 
			"END_NM_with_G1", "END_NM_with_G1TERM", "END_NM_with_SPACE", "END_NM_with_WINNL", 
			"END_NM_with_DASH", "END_NM_with_HYPHEN", "END_NM_with_ALPHA", "END_NM_with_K2Z", 
			"NM_FRACE", "NMFRACIL", "PR_TOKEN_1", "PR_TOKEN_2", "PR_TOKEN_3", "ROOT_1", 
			"NUM_MISC", "END_SPECG1_with_G1TERM", "ANOTHER_SPACE", "CAP_ZED", "LATIN_LETTER", 
			"FUN_NAME", "SHORTFORM", "SFA", "SFC"
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
	public String getGrammarFileName() { return "uebMathParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 boolean line_cont = false;
	                  boolean numericMode = false;
	                  boolean specialG1Mode = false;
	                  boolean g1Wrd = false;
	                  boolean g1Passage = false;
	                  boolean g1WrdOrPassage = false;
	                  boolean numPassage = false; 
	                 
	public uebMathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TextContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_text);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(154);
					line();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class LineStartContext extends ParserRuleContext {
		public LowAloneContext lowAlone() {
			return getRuleContext(LowAloneContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<IndentContext> indent() {
			return getRuleContexts(IndentContext.class);
		}
		public IndentContext indent(int i) {
			return getRuleContext(IndentContext.class,i);
		}
		public SimpleWordContext simpleWord() {
			return getRuleContext(SimpleWordContext.class,0);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public StandingAloneContext standingAlone() {
			return getRuleContext(StandingAloneContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public List<SeparatorContext> separator() {
			return getRuleContexts(SeparatorContext.class);
		}
		public SeparatorContext separator(int i) {
			return getRuleContext(SeparatorContext.class,i);
		}
		public List<G1WrdOrPssgContext> g1WrdOrPssg() {
			return getRuleContexts(G1WrdOrPssgContext.class);
		}
		public G1WrdOrPssgContext g1WrdOrPssg(int i) {
			return getRuleContext(G1WrdOrPssgContext.class,i);
		}
		public LineStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLineStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLineStart(this);
		}
	}

	public final LineStartContext lineStart() throws RecognitionException {
		LineStartContext _localctx = new LineStartContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lineStart);
		int _la;
		try {
			int _alt;
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (INDENT - 101)) | (1L << (SPACE - 101)) | (1L << (NPSPACE - 101)) | (1L << (END_NM_with_SPACE - 101)))) != 0)) {
					{
					setState(161);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SPACE:
					case NPSPACE:
					case END_NM_with_SPACE:
						{
						setState(159);
						space();
						}
						break;
					case INDENT:
						{
						setState(160);
						indent();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				lowAlone();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(169);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case DOT5:
						case DOT6:
						case DOTS36:
						case INDENT:
						case SPACE:
						case NPSPACE:
						case END_NM_with_SPACE:
						case END_NM_with_DASH:
						case END_NM_with_HYPHEN:
							{
							setState(167);
							separator();
							}
							break;
						case G1PassageInd:
						case G1WordInd:
							{
							setState(168);
							g1WrdOrPssg();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(173);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(174);
					simpleWord();
					}
					break;
				case 2:
					{
					setState(175);
					word();
					}
					break;
				case 3:
					{
					setState(176);
					standingAlone();
					}
					break;
				case 4:
					{
					setState(177);
					item();
					}
					break;
				}
				}
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

	public static class LineMiddleContext extends ParserRuleContext {
		public LowAloneContext lowAlone() {
			return getRuleContext(LowAloneContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<IndentContext> indent() {
			return getRuleContexts(IndentContext.class);
		}
		public IndentContext indent(int i) {
			return getRuleContext(IndentContext.class,i);
		}
		public SimpleWordContext simpleWord() {
			return getRuleContext(SimpleWordContext.class,0);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public StandingAloneContext standingAlone() {
			return getRuleContext(StandingAloneContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public List<SeparatorContext> separator() {
			return getRuleContexts(SeparatorContext.class);
		}
		public SeparatorContext separator(int i) {
			return getRuleContext(SeparatorContext.class,i);
		}
		public List<G1WrdOrPssgContext> g1WrdOrPssg() {
			return getRuleContexts(G1WrdOrPssgContext.class);
		}
		public G1WrdOrPssgContext g1WrdOrPssg(int i) {
			return getRuleContext(G1WrdOrPssgContext.class,i);
		}
		public LineMiddleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineMiddle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLineMiddle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLineMiddle(this);
		}
	}

	public final LineMiddleContext lineMiddle() throws RecognitionException {
		LineMiddleContext _localctx = new LineMiddleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lineMiddle);
		int _la;
		try {
			int _alt;
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(184);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SPACE:
					case NPSPACE:
					case END_NM_with_SPACE:
						{
						setState(182);
						space();
						}
						break;
					case INDENT:
						{
						setState(183);
						indent();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (INDENT - 101)) | (1L << (SPACE - 101)) | (1L << (NPSPACE - 101)) | (1L << (END_NM_with_SPACE - 101)))) != 0) );
				setState(188);
				lowAlone();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(191); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(190);
						separator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(193); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(195);
						g1WrdOrPssg();
						}
						} 
					}
					setState(200);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(201);
					simpleWord();
					}
					break;
				case 2:
					{
					setState(202);
					word();
					}
					break;
				case 3:
					{
					setState(203);
					standingAlone();
					}
					break;
				case 4:
					{
					setState(204);
					item();
					}
					break;
				}
				}
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

	public static class LineEndContext extends ParserRuleContext {
		public SimpleWordContext simpleWord() {
			return getRuleContext(SimpleWordContext.class,0);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public StandingAloneContext standingAlone() {
			return getRuleContext(StandingAloneContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public List<SeparatorContext> separator() {
			return getRuleContexts(SeparatorContext.class);
		}
		public SeparatorContext separator(int i) {
			return getRuleContext(SeparatorContext.class,i);
		}
		public List<G1WrdOrPssgContext> g1WrdOrPssg() {
			return getRuleContexts(G1WrdOrPssgContext.class);
		}
		public G1WrdOrPssgContext g1WrdOrPssg(int i) {
			return getRuleContext(G1WrdOrPssgContext.class,i);
		}
		public List<TrailingSepContext> trailingSep() {
			return getRuleContexts(TrailingSepContext.class);
		}
		public TrailingSepContext trailingSep(int i) {
			return getRuleContext(TrailingSepContext.class,i);
		}
		public LowAloneContext lowAlone() {
			return getRuleContext(LowAloneContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<IndentContext> indent() {
			return getRuleContexts(IndentContext.class);
		}
		public IndentContext indent(int i) {
			return getRuleContext(IndentContext.class,i);
		}
		public LineEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLineEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLineEnd(this);
		}
	}

	public final LineEndContext lineEnd() throws RecognitionException {
		LineEndContext _localctx = new LineEndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lineEnd);
		int _la;
		try {
			int _alt;
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(210); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(209);
						separator();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(212); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(214);
						g1WrdOrPssg();
						}
						} 
					}
					setState(219);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(220);
					simpleWord();
					}
					break;
				case 2:
					{
					setState(221);
					word();
					}
					break;
				case 3:
					{
					setState(222);
					standingAlone();
					}
					break;
				case 4:
					{
					setState(223);
					item();
					}
					break;
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(226);
						trailingSep();
						}
						} 
					}
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (INDENT - 101)) | (1L << (SPACE - 101)) | (1L << (NPSPACE - 101)) | (1L << (END_NM_with_SPACE - 101)))) != 0)) {
					{
					setState(234);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SPACE:
					case NPSPACE:
					case END_NM_with_SPACE:
						{
						setState(232);
						space();
						}
						break;
					case INDENT:
						{
						setState(233);
						indent();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				lowAlone();
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(242);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case SPACE:
						case NPSPACE:
						case END_NM_with_SPACE:
							{
							setState(240);
							space();
							}
							break;
						case INDENT:
							{
							setState(241);
							indent();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
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

	public static class LineDoneContext extends ParserRuleContext {
		public NewlineContext newline() {
			return getRuleContext(NewlineContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public LineDoneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineDone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLineDone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLineDone(this);
		}
	}

	public final LineDoneContext lineDone() throws RecognitionException {
		LineDoneContext _localctx = new LineDoneContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lineDone);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SPACE - 102)) | (1L << (NPSPACE - 102)) | (1L << (END_NM_with_SPACE - 102)))) != 0)) {
				{
				{
				setState(249);
				space();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(255);
			newline();
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

	public static class LineContext extends ParserRuleContext {
		public NewlineContext newline() {
			return getRuleContext(NewlineContext.class,0);
		}
		public List<SpaceContext> space() {
			return getRuleContexts(SpaceContext.class);
		}
		public SpaceContext space(int i) {
			return getRuleContext(SpaceContext.class,i);
		}
		public List<IndentContext> indent() {
			return getRuleContexts(IndentContext.class);
		}
		public IndentContext indent(int i) {
			return getRuleContext(IndentContext.class,i);
		}
		public LineStartContext lineStart() {
			return getRuleContext(LineStartContext.class,0);
		}
		public LineDoneContext lineDone() {
			return getRuleContext(LineDoneContext.class,0);
		}
		public LineEndContext lineEnd() {
			return getRuleContext(LineEndContext.class,0);
		}
		public List<LineMiddleContext> lineMiddle() {
			return getRuleContexts(LineMiddleContext.class);
		}
		public LineMiddleContext lineMiddle(int i) {
			return getRuleContext(LineMiddleContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		int _la;
		try {
			int _alt;
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & ((1L << (INDENT - 101)) | (1L << (SPACE - 101)) | (1L << (NPSPACE - 101)) | (1L << (END_NM_with_SPACE - 101)))) != 0)) {
					{
					setState(259);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SPACE:
					case NPSPACE:
					case END_NM_with_SPACE:
						{
						setState(257);
						space();
						}
						break;
					case INDENT:
						{
						setState(258);
						indent();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(264);
				newline();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				lineStart();
				setState(266);
				lineDone();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				lineStart();
				setState(269);
				lineEnd();
				setState(270);
				lineDone();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(272);
				lineStart();
				setState(274); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(273);
						lineMiddle();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(276); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(278);
				lineEnd();
				setState(279);
				lineDone();
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

	public static class Strong_wsContext extends ParserRuleContext {
		public TerminalNode STRONG_WS() { return getToken(uebMathParser.STRONG_WS, 0); }
		public Strong_wsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strong_ws; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterStrong_ws(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitStrong_ws(this);
		}
	}

	public final Strong_wsContext strong_ws() throws RecognitionException {
		Strong_wsContext _localctx = new Strong_wsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_strong_ws);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(STRONG_WS);
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

	public static class DigitsContext extends ParserRuleContext {
		public List<TerminalNode> START_NUMERIC_MODE() { return getTokens(uebMathParser.START_NUMERIC_MODE); }
		public TerminalNode START_NUMERIC_MODE(int i) {
			return getToken(uebMathParser.START_NUMERIC_MODE, i);
		}
		public List<TerminalNode> NDIG_SEQ() { return getTokens(uebMathParser.NDIG_SEQ); }
		public TerminalNode NDIG_SEQ(int i) {
			return getToken(uebMathParser.NDIG_SEQ, i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(uebMathParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(uebMathParser.DIGITS, i);
		}
		public DigitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_digits; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterDigits(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitDigits(this);
		}
	}

	public final DigitsContext digits() throws RecognitionException {
		DigitsContext _localctx = new DigitsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_digits);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(289);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						setState(285);
						match(START_NUMERIC_MODE);
						}
						break;
					case 2:
						{
						setState(286);
						match(NDIG_SEQ);
						}
						break;
					case 3:
						{
						setState(287);
						if (!(numPassage)) throw new FailedPredicateException(this, "numPassage");
						setState(288);
						match(DIGITS);
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(291); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class LowsignconContext extends ParserRuleContext {
		public TerminalNode LOWCON() { return getToken(uebMathParser.LOWCON, 0); }
		public TerminalNode SPLOW() { return getToken(uebMathParser.SPLOW, 0); }
		public LowsignconContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowsigncon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLowsigncon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLowsigncon(this);
		}
	}

	public final LowsignconContext lowsigncon() throws RecognitionException {
		LowsignconContext _localctx = new LowsignconContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lowsigncon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_la = _input.LA(1);
			if ( !(_la==SPLOW || _la==LOWCON) ) {
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

	public static class LowAloneContext extends ParserRuleContext {
		public LowsignconContext lowsigncon() {
			return getRuleContext(LowsignconContext.class,0);
		}
		public List<PreNoQuotesContext> preNoQuotes() {
			return getRuleContexts(PreNoQuotesContext.class);
		}
		public PreNoQuotesContext preNoQuotes(int i) {
			return getRuleContext(PreNoQuotesContext.class,i);
		}
		public List<PostOkContext> postOk() {
			return getRuleContexts(PostOkContext.class);
		}
		public PostOkContext postOk(int i) {
			return getRuleContext(PostOkContext.class,i);
		}
		public LowAloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowAlone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLowAlone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLowAlone(this);
		}
	}

	public final LowAloneContext lowAlone() throws RecognitionException {
		LowAloneContext _localctx = new LowAloneContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lowAlone);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OGROUP) {
				{
				{
				setState(295);
				preNoQuotes();
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(301);
			lowsigncon();
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(302);
					postOk();
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
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

	public static class StandingAloneContext extends ParserRuleContext {
		public StandAloneConContext standAloneCon() {
			return getRuleContext(StandAloneConContext.class,0);
		}
		public List<PreAloneContext> preAlone() {
			return getRuleContexts(PreAloneContext.class);
		}
		public PreAloneContext preAlone(int i) {
			return getRuleContext(PreAloneContext.class,i);
		}
		public List<PostAloneContext> postAlone() {
			return getRuleContexts(PostAloneContext.class);
		}
		public PostAloneContext postAlone(int i) {
			return getRuleContext(PostAloneContext.class,i);
		}
		public TerminalNode CapsPassageInd() { return getToken(uebMathParser.CapsPassageInd, 0); }
		public TerminalNode CapsWordInd() { return getToken(uebMathParser.CapsWordInd, 0); }
		public StandingAloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standingAlone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterStandingAlone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitStandingAlone(this);
		}
	}

	public final StandingAloneContext standingAlone() throws RecognitionException {
		StandingAloneContext _localctx = new StandingAloneContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_standingAlone);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(308);
					preAlone();
					}
					} 
				}
				setState(313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			{
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(314);
				_la = _input.LA(1);
				if ( !(_la==CapsPassageInd || _la==CapsWordInd) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(317);
			standAloneCon();
			}
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(319);
					postAlone();
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class FlcContext extends ParserRuleContext {
		public TerminalNode FLC46() { return getToken(uebMathParser.FLC46, 0); }
		public TerminalNode FLC56() { return getToken(uebMathParser.FLC56, 0); }
		public FlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFlc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFlc(this);
		}
	}

	public final FlcContext flc() throws RecognitionException {
		FlcContext _localctx = new FlcContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_flc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			setState(326);
			_la = _input.LA(1);
			if ( !(_la==FLC46 || _la==FLC56) ) {
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

	public static class IlcContext extends ParserRuleContext {
		public TerminalNode ILC5() { return getToken(uebMathParser.ILC5, 0); }
		public TerminalNode ILC45() { return getToken(uebMathParser.ILC45, 0); }
		public TerminalNode ILC456() { return getToken(uebMathParser.ILC456, 0); }
		public IlcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ilc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterIlc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitIlc(this);
		}
	}

	public final IlcContext ilc() throws RecognitionException {
		IlcContext _localctx = new IlcContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ilc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			setState(329);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ILC5) | (1L << ILC45) | (1L << ILC456))) != 0)) ) {
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

	public static class Strong_gsContext extends ParserRuleContext {
		public TerminalNode STRONG_GS() { return getToken(uebMathParser.STRONG_GS, 0); }
		public Strong_gsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strong_gs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterStrong_gs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitStrong_gs(this);
		}
	}

	public final Strong_gsContext strong_gs() throws RecognitionException {
		Strong_gsContext _localctx = new Strong_gsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_strong_gs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			setState(332);
			match(STRONG_GS);
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

	public static class LargeSignContext extends ParserRuleContext {
		public TerminalNode AND_ROOT() { return getToken(uebMathParser.AND_ROOT, 0); }
		public TerminalNode FOR_ROOT() { return getToken(uebMathParser.FOR_ROOT, 0); }
		public TerminalNode OF_ROOT() { return getToken(uebMathParser.OF_ROOT, 0); }
		public TerminalNode THE_ROOT() { return getToken(uebMathParser.THE_ROOT, 0); }
		public TerminalNode WITH_ROOT() { return getToken(uebMathParser.WITH_ROOT, 0); }
		public LargeSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_largeSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLargeSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLargeSign(this);
		}
	}

	public final LargeSignContext largeSign() throws RecognitionException {
		LargeSignContext _localctx = new LargeSignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_largeSign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			setState(335);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND_ROOT) | (1L << FOR_ROOT) | (1L << OF_ROOT) | (1L << THE_ROOT) | (1L << WITH_ROOT))) != 0)) ) {
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

	public static class NewlineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(uebMathParser.NEWLINE, 0); }
		public TerminalNode END_NM_with_WINNL() { return getToken(uebMathParser.END_NM_with_WINNL, 0); }
		public NewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitNewline(this);
		}
	}

	public final NewlineContext newline() throws RecognitionException {
		NewlineContext _localctx = new NewlineContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_newline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			_la = _input.LA(1);
			if ( !(_la==NEWLINE || _la==END_NM_with_WINNL) ) {
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

	public static class SpaceContext extends ParserRuleContext {
		public TerminalNode END_NM_with_SPACE() { return getToken(uebMathParser.END_NM_with_SPACE, 0); }
		public TerminalNode NPSPACE() { return getToken(uebMathParser.NPSPACE, 0); }
		public TerminalNode SPACE() { return getToken(uebMathParser.SPACE, 0); }
		public SpaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSpace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSpace(this);
		}
	}

	public final SpaceContext space() throws RecognitionException {
		SpaceContext _localctx = new SpaceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_space);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !(((((_la - 102)) & ~0x3f) == 0 && ((1L << (_la - 102)) & ((1L << (SPACE - 102)) | (1L << (NPSPACE - 102)) | (1L << (END_NM_with_SPACE - 102)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			g1Wrd = false;
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

	public static class IndentContext extends ParserRuleContext {
		public TerminalNode INDENT() { return getToken(uebMathParser.INDENT, 0); }
		public IndentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterIndent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitIndent(this);
		}
	}

	public final IndentContext indent() throws RecognitionException {
		IndentContext _localctx = new IndentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_indent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(INDENT);
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

	public static class SeparatorContext extends ParserRuleContext {
		public SpaceContext space() {
			return getRuleContext(SpaceContext.class,0);
		}
		public HyphenContext hyphen() {
			return getRuleContext(HyphenContext.class,0);
		}
		public DashContext dash() {
			return getRuleContext(DashContext.class,0);
		}
		public Long_dashContext long_dash() {
			return getRuleContext(Long_dashContext.class,0);
		}
		public IndentContext indent() {
			return getRuleContext(IndentContext.class,0);
		}
		public SeparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_separator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSeparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSeparator(this);
		}
	}

	public final SeparatorContext separator() throws RecognitionException {
		SeparatorContext _localctx = new SeparatorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_separator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SPACE:
			case NPSPACE:
			case END_NM_with_SPACE:
				{
				setState(344);
				space();
				}
				break;
			case DOTS36:
			case END_NM_with_HYPHEN:
				{
				setState(345);
				hyphen();
				}
				break;
			case DOT6:
			case END_NM_with_DASH:
				{
				setState(346);
				dash();
				}
				break;
			case DOT5:
				{
				setState(347);
				long_dash();
				}
				break;
			case INDENT:
				{
				setState(348);
				indent();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TrailingSepContext extends ParserRuleContext {
		public List<SeparatorContext> separator() {
			return getRuleContexts(SeparatorContext.class);
		}
		public SeparatorContext separator(int i) {
			return getRuleContext(SeparatorContext.class,i);
		}
		public TrailingSepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trailingSep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterTrailingSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitTrailingSep(this);
		}
	}

	public final TrailingSepContext trailingSep() throws RecognitionException {
		TrailingSepContext _localctx = new TrailingSepContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_trailingSep);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(351);
					separator();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(354); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class ThismodeContext extends ParserRuleContext {
		public TerminalNode STARTING_MODE() { return getToken(uebMathParser.STARTING_MODE, 0); }
		public ThismodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thismode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterThismode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitThismode(this);
		}
	}

	public final ThismodeContext thismode() throws RecognitionException {
		ThismodeContext _localctx = new ThismodeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_thismode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(STARTING_MODE);
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

	public static class StartModeContext extends ParserRuleContext {
		public ThismodeContext thismode() {
			return getRuleContext(ThismodeContext.class,0);
		}
		public StartModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterStartMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitStartMode(this);
		}
	}

	public final StartModeContext startMode() throws RecognitionException {
		StartModeContext _localctx = new StartModeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_startMode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			thismode();
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

	public static class EndModeContext extends ParserRuleContext {
		public G1TERMContext g1TERM() {
			return getRuleContext(G1TERMContext.class,0);
		}
		public EndNumPassageContext endNumPassage() {
			return getRuleContext(EndNumPassageContext.class,0);
		}
		public EndModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterEndMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitEndMode(this);
		}
	}

	public final EndModeContext endMode() throws RecognitionException {
		EndModeContext _localctx = new EndModeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_endMode);
		try {
			setState(362);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case G1TermInd:
			case END_NM_with_G1TERM:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				g1TERM();
				}
				break;
			case EXIT_NUMERIC_PASSAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				endNumPassage();
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

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode BINOP() { return getToken(uebMathParser.BINOP, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitBinop(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_binop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(BINOP);
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

	public static class NumIndicatorContext extends ParserRuleContext {
		public TerminalNode START_NUMERIC_MODE() { return getToken(uebMathParser.START_NUMERIC_MODE, 0); }
		public NumIndicatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numIndicator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterNumIndicator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitNumIndicator(this);
		}
	}

	public final NumIndicatorContext numIndicator() throws RecognitionException {
		NumIndicatorContext _localctx = new NumIndicatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_numIndicator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(START_NUMERIC_MODE);
			numericMode=true;
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

	public static class SimpleFractionContext extends ParserRuleContext {
		public NumIndicatorContext numIndicator() {
			return getRuleContext(NumIndicatorContext.class,0);
		}
		public TerminalNode NUM_SIMPLE_FRAC_LINE() { return getToken(uebMathParser.NUM_SIMPLE_FRAC_LINE, 0); }
		public List<DigitsContext> digits() {
			return getRuleContexts(DigitsContext.class);
		}
		public DigitsContext digits(int i) {
			return getRuleContext(DigitsContext.class,i);
		}
		public SimpleFractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleFraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSimpleFraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSimpleFraction(this);
		}
	}

	public final SimpleFractionContext simpleFraction() throws RecognitionException {
		SimpleFractionContext _localctx = new SimpleFractionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_simpleFraction);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(369);
			numIndicator();
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(370);
					digits();
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(376);
			match(NUM_SIMPLE_FRAC_LINE);
			setState(378); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(377);
					digits();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(380); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class FracContext extends ParserRuleContext {
		public FracStartContext fracStart() {
			return getRuleContext(FracStartContext.class,0);
		}
		public FracLineContext fracLine() {
			return getRuleContext(FracLineContext.class,0);
		}
		public FracEndContext fracEnd() {
			return getRuleContext(FracEndContext.class,0);
		}
		public List<SimpleFractionContext> simpleFraction() {
			return getRuleContexts(SimpleFractionContext.class);
		}
		public SimpleFractionContext simpleFraction(int i) {
			return getRuleContext(SimpleFractionContext.class,i);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public FracContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frac; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFrac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFrac(this);
		}
	}

	public final FracContext frac() throws RecognitionException {
		FracContext _localctx = new FracContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_frac);
		try {
			int _alt;
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MLFRACS:
			case OF_ROOT:
			case OForFRACS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(382);
				fracStart();
				setState(389);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(383);
					simpleFraction();
					}
					break;
				case 2:
					{
					setState(385); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(384);
							expr2(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(387); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				setState(391);
				fracLine();
				setState(398);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(392);
					simpleFraction();
					}
					break;
				case 2:
					{
					setState(394); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(393);
							expr2(0);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(396); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				}
				setState(400);
				fracEnd();
				}
				}
				break;
			case START_NUMERIC_MODE:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				simpleFraction();
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

	public static class ItemContext extends ParserRuleContext {
		public NumericPassageContext numericPassage() {
			return getRuleContext(NumericPassageContext.class,0);
		}
		public EndNumPassageContext endNumPassage() {
			return getRuleContext(EndNumPassageContext.class,0);
		}
		public DigitsContext digits() {
			return getRuleContext(DigitsContext.class,0);
		}
		public StartModeContext startMode() {
			return getRuleContext(StartModeContext.class,0);
		}
		public FracContext frac() {
			return getRuleContext(FracContext.class,0);
		}
		public CfracContext cfrac() {
			return getRuleContext(CfracContext.class,0);
		}
		public CompContext comp() {
			return getRuleContext(CompContext.class,0);
		}
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public SupExprContext supExpr() {
			return getRuleContext(SupExprContext.class,0);
		}
		public SubExprContext subExpr() {
			return getRuleContext(SubExprContext.class,0);
		}
		public SubsupExprContext subsupExpr() {
			return getRuleContext(SubsupExprContext.class,0);
		}
		public TerminalNode LETTER_NOT_DIGIT() { return getToken(uebMathParser.LETTER_NOT_DIGIT, 0); }
		public FlcERRORContext flcERROR() {
			return getRuleContext(FlcERRORContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(405);
				numericPassage();
				}
				break;
			case 2:
				{
				setState(406);
				endNumPassage();
				}
				break;
			case 3:
				{
				setState(407);
				digits();
				}
				break;
			case 4:
				{
				setState(408);
				startMode();
				}
				break;
			case 5:
				{
				setState(409);
				frac();
				}
				break;
			case 6:
				{
				setState(410);
				cfrac();
				}
				break;
			case 7:
				{
				setState(411);
				comp();
				}
				break;
			case 8:
				{
				setState(412);
				expr2(0);
				}
				break;
			case 9:
				{
				setState(413);
				supExpr(0);
				}
				break;
			case 10:
				{
				setState(414);
				subExpr(0);
				}
				break;
			case 11:
				{
				setState(415);
				subsupExpr();
				}
				break;
			case 12:
				{
				setState(416);
				match(LETTER_NOT_DIGIT);
				}
				break;
			case 13:
				{
				setState(417);
				flcERROR();
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

	public static class AngleBracketContext extends ParserRuleContext {
		public List<TerminalNode> LEFTangleOrLT() { return getTokens(uebMathParser.LEFTangleOrLT); }
		public TerminalNode LEFTangleOrLT(int i) {
			return getToken(uebMathParser.LEFTangleOrLT, i);
		}
		public List<TerminalNode> RIGHTangleOrGT() { return getTokens(uebMathParser.RIGHTangleOrGT); }
		public TerminalNode RIGHTangleOrGT(int i) {
			return getToken(uebMathParser.RIGHTangleOrGT, i);
		}
		public AngleBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angleBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterAngleBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitAngleBracket(this);
		}
	}

	public final AngleBracketContext angleBracket() throws RecognitionException {
		AngleBracketContext _localctx = new AngleBracketContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_angleBracket);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(420);
					_la = _input.LA(1);
					if ( !(_la==LEFTangleOrLT || _la==RIGHTangleOrGT) ) {
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
				setState(423); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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

	public static class CompSymbolsContext extends ParserRuleContext {
		public TerminalNode SPACED_SYMBOLS() { return getToken(uebMathParser.SPACED_SYMBOLS, 0); }
		public TerminalNode COMP_SYMBOLS() { return getToken(uebMathParser.COMP_SYMBOLS, 0); }
		public AngleBracketContext angleBracket() {
			return getRuleContext(AngleBracketContext.class,0);
		}
		public CompSymbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compSymbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterCompSymbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitCompSymbols(this);
		}
	}

	public final CompSymbolsContext compSymbols() throws RecognitionException {
		CompSymbolsContext _localctx = new CompSymbolsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_compSymbols);
		try {
			setState(428);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SPACED_SYMBOLS:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				match(SPACED_SYMBOLS);
				}
				break;
			case COMP_SYMBOLS:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				match(COMP_SYMBOLS);
				}
				break;
			case LEFTangleOrLT:
			case RIGHTangleOrGT:
				enterOuterAlt(_localctx, 3);
				{
				setState(427);
				angleBracket();
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

	public static class CompContext extends ParserRuleContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public CompSymbolsContext compSymbols() {
			return getRuleContext(CompSymbolsContext.class,0);
		}
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			expr2(0);
			setState(431);
			compSymbols();
			setState(432);
			expr2(0);
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

	public static class TcAlphaSeqContext extends ParserRuleContext {
		public TerminalNode CapitalLetter() { return getToken(uebMathParser.CapitalLetter, 0); }
		public TerminalNode ALPHA_SEQ() { return getToken(uebMathParser.ALPHA_SEQ, 0); }
		public TcAlphaSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tcAlphaSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterTcAlphaSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitTcAlphaSeq(this);
		}
	}

	public final TcAlphaSeqContext tcAlphaSeq() throws RecognitionException {
		TcAlphaSeqContext _localctx = new TcAlphaSeqContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tcAlphaSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			match(CapitalLetter);
			setState(435);
			match(ALPHA_SEQ);
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

	public static class AlphaSeqContext extends ParserRuleContext {
		public TerminalNode ALPHA_SEQ() { return getToken(uebMathParser.ALPHA_SEQ, 0); }
		public AlphaSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphaSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterAlphaSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitAlphaSeq(this);
		}
	}

	public final AlphaSeqContext alphaSeq() throws RecognitionException {
		AlphaSeqContext _localctx = new AlphaSeqContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_alphaSeq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(ALPHA_SEQ);
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

	public static class CommaContext extends ParserRuleContext {
		public TerminalNode DOT2() { return getToken(uebMathParser.DOT2, 0); }
		public TerminalNode COMMA_ROOT() { return getToken(uebMathParser.COMMA_ROOT, 0); }
		public CommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitComma(this);
		}
	}

	public final CommaContext comma() throws RecognitionException {
		CommaContext _localctx = new CommaContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_comma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_la = _input.LA(1);
			if ( !(_la==COMMA_ROOT || _la==DOT2) ) {
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

	public static class SimpleWordContext extends ParserRuleContext {
		public IlcContext ilc() {
			return getRuleContext(IlcContext.class,0);
		}
		public LargeSignContext largeSign() {
			return getRuleContext(LargeSignContext.class,0);
		}
		public TcAlphaSeqContext tcAlphaSeq() {
			return getRuleContext(TcAlphaSeqContext.class,0);
		}
		public AlphaSeqContext alphaSeq() {
			return getRuleContext(AlphaSeqContext.class,0);
		}
		public TerminalNode SPLOW() { return getToken(uebMathParser.SPLOW, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public TerminalNode APOS_END() { return getToken(uebMathParser.APOS_END, 0); }
		public CommaContext comma() {
			return getRuleContext(CommaContext.class,0);
		}
		public PostAloneContext postAlone() {
			return getRuleContext(PostAloneContext.class,0);
		}
		public SimpleWordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleWord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSimpleWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSimpleWord(this);
		}
	}

	public final SimpleWordContext simpleWord() throws RecognitionException {
		SimpleWordContext _localctx = new SimpleWordContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_simpleWord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(441);
				match(DOT6);
				}
				break;
			}
			setState(449);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(444);
				ilc();
				}
				break;
			case 2:
				{
				setState(445);
				largeSign();
				}
				break;
			case 3:
				{
				setState(446);
				tcAlphaSeq();
				}
				break;
			case 4:
				{
				setState(447);
				alphaSeq();
				}
				break;
			case 5:
				{
				setState(448);
				match(SPLOW);
				}
				break;
			}
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==APOS_END) {
				{
				setState(451);
				match(APOS_END);
				}
			}

			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(454);
				comma();
				}
				break;
			case 2:
				{
				setState(455);
				postAlone();
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

	public static class FfContext extends ParserRuleContext {
		public TerminalNode DOTS235() { return getToken(uebMathParser.DOTS235, 0); }
		public FfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFf(this);
		}
	}

	public final FfContext ff() throws RecognitionException {
		FfContext _localctx = new FfContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(DOTS235);
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

	public static class WordContext extends ParserRuleContext {
		public WordStartContext wordStart() {
			return getRuleContext(WordStartContext.class,0);
		}
		public WordEndingContext wordEnding() {
			return getRuleContext(WordEndingContext.class,0);
		}
		public CommaContext comma() {
			return getRuleContext(CommaContext.class,0);
		}
		public PostAloneContext postAlone() {
			return getRuleContext(PostAloneContext.class,0);
		}
		public List<WordMiddleContext> wordMiddle() {
			return getRuleContexts(WordMiddleContext.class);
		}
		public WordMiddleContext wordMiddle(int i) {
			return getRuleContext(WordMiddleContext.class,i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitWord(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_word);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(460);
			wordStart();
			setState(464);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(461);
					wordMiddle();
					}
					} 
				}
				setState(466);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			setState(467);
			wordEnding();
			}
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(469);
				comma();
				}
				break;
			case 2:
				{
				setState(470);
				postAlone();
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

	public static class WordStartContext extends ParserRuleContext {
		public TcAlphaSeqContext tcAlphaSeq() {
			return getRuleContext(TcAlphaSeqContext.class,0);
		}
		public AlphaSeqContext alphaSeq() {
			return getRuleContext(AlphaSeqContext.class,0);
		}
		public ShortFormsContext shortForms() {
			return getRuleContext(ShortFormsContext.class,0);
		}
		public SingleLetterContext singleLetter() {
			return getRuleContext(SingleLetterContext.class,0);
		}
		public TerminalNode LETTERS_NOT_DIGITS() { return getToken(uebMathParser.LETTERS_NOT_DIGITS, 0); }
		public Strong_wsContext strong_ws() {
			return getRuleContext(Strong_wsContext.class,0);
		}
		public TerminalNode ROOT() { return getToken(uebMathParser.ROOT, 0); }
		public TerminalNode UPDIGS() { return getToken(uebMathParser.UPDIGS, 0); }
		public TerminalNode SLASH_ROOT() { return getToken(uebMathParser.SLASH_ROOT, 0); }
		public IlcContext ilc() {
			return getRuleContext(IlcContext.class,0);
		}
		public LargeSignContext largeSign() {
			return getRuleContext(LargeSignContext.class,0);
		}
		public Strong_gsContext strong_gs() {
			return getRuleContext(Strong_gsContext.class,0);
		}
		public LowsignconContext lowsigncon() {
			return getRuleContext(LowsignconContext.class,0);
		}
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public WordStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterWordStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitWordStart(this);
		}
	}

	public final WordStartContext wordStart() throws RecognitionException {
		WordStartContext _localctx = new WordStartContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_wordStart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(474);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(473);
				match(DOT6);
				}
				break;
			}
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(476);
				tcAlphaSeq();
				}
				break;
			case 2:
				{
				setState(477);
				alphaSeq();
				}
				break;
			case 3:
				{
				setState(478);
				shortForms();
				}
				break;
			case 4:
				{
				setState(479);
				singleLetter();
				}
				break;
			case 5:
				{
				setState(480);
				match(LETTERS_NOT_DIGITS);
				}
				break;
			case 6:
				{
				setState(481);
				strong_ws();
				}
				break;
			case 7:
				{
				setState(482);
				match(ROOT);
				}
				break;
			case 8:
				{
				setState(483);
				match(UPDIGS);
				}
				break;
			case 9:
				{
				setState(484);
				match(SLASH_ROOT);
				}
				break;
			case 10:
				{
				setState(485);
				ilc();
				}
				break;
			case 11:
				{
				setState(486);
				largeSign();
				}
				break;
			case 12:
				{
				setState(487);
				strong_gs();
				}
				break;
			case 13:
				{
				setState(488);
				lowsigncon();
				}
				break;
			}
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

	public static class WordMiddleContext extends ParserRuleContext {
		public AlphaSeqContext alphaSeq() {
			return getRuleContext(AlphaSeqContext.class,0);
		}
		public ShortFormsContext shortForms() {
			return getRuleContext(ShortFormsContext.class,0);
		}
		public SingleLetterContext singleLetter() {
			return getRuleContext(SingleLetterContext.class,0);
		}
		public FfContext ff() {
			return getRuleContext(FfContext.class,0);
		}
		public TerminalNode LETTERS_NOT_DIGITS() { return getToken(uebMathParser.LETTERS_NOT_DIGITS, 0); }
		public Strong_wsContext strong_ws() {
			return getRuleContext(Strong_wsContext.class,0);
		}
		public TerminalNode ROOT() { return getToken(uebMathParser.ROOT, 0); }
		public TerminalNode UPDIGS() { return getToken(uebMathParser.UPDIGS, 0); }
		public TerminalNode SLASH_ROOT() { return getToken(uebMathParser.SLASH_ROOT, 0); }
		public FlcContext flc() {
			return getRuleContext(FlcContext.class,0);
		}
		public IlcContext ilc() {
			return getRuleContext(IlcContext.class,0);
		}
		public LargeSignContext largeSign() {
			return getRuleContext(LargeSignContext.class,0);
		}
		public Strong_gsContext strong_gs() {
			return getRuleContext(Strong_gsContext.class,0);
		}
		public LowsignconContext lowsigncon() {
			return getRuleContext(LowsignconContext.class,0);
		}
		public WordMiddleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordMiddle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterWordMiddle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitWordMiddle(this);
		}
	}

	public final WordMiddleContext wordMiddle() throws RecognitionException {
		WordMiddleContext _localctx = new WordMiddleContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_wordMiddle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(491);
				alphaSeq();
				}
				break;
			case 2:
				{
				setState(492);
				shortForms();
				}
				break;
			case 3:
				{
				setState(493);
				singleLetter();
				}
				break;
			case 4:
				{
				setState(494);
				ff();
				}
				break;
			case 5:
				{
				setState(495);
				match(LETTERS_NOT_DIGITS);
				}
				break;
			case 6:
				{
				setState(496);
				strong_ws();
				}
				break;
			case 7:
				{
				setState(497);
				match(ROOT);
				}
				break;
			case 8:
				{
				setState(498);
				match(UPDIGS);
				}
				break;
			case 9:
				{
				setState(499);
				match(SLASH_ROOT);
				}
				break;
			case 10:
				{
				setState(500);
				flc();
				}
				break;
			case 11:
				{
				setState(501);
				ilc();
				}
				break;
			case 12:
				{
				setState(502);
				largeSign();
				}
				break;
			case 13:
				{
				setState(503);
				strong_gs();
				}
				break;
			case 14:
				{
				setState(504);
				lowsigncon();
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

	public static class WordEndingContext extends ParserRuleContext {
		public AlphaSeqContext alphaSeq() {
			return getRuleContext(AlphaSeqContext.class,0);
		}
		public ShortFormsContext shortForms() {
			return getRuleContext(ShortFormsContext.class,0);
		}
		public SingleLetterContext singleLetter() {
			return getRuleContext(SingleLetterContext.class,0);
		}
		public TerminalNode LETTERS_NOT_DIGITS() { return getToken(uebMathParser.LETTERS_NOT_DIGITS, 0); }
		public Strong_wsContext strong_ws() {
			return getRuleContext(Strong_wsContext.class,0);
		}
		public TerminalNode ROOT() { return getToken(uebMathParser.ROOT, 0); }
		public TerminalNode UPDIGS() { return getToken(uebMathParser.UPDIGS, 0); }
		public TerminalNode SLASH_ROOT() { return getToken(uebMathParser.SLASH_ROOT, 0); }
		public FlcContext flc() {
			return getRuleContext(FlcContext.class,0);
		}
		public IlcContext ilc() {
			return getRuleContext(IlcContext.class,0);
		}
		public LargeSignContext largeSign() {
			return getRuleContext(LargeSignContext.class,0);
		}
		public Strong_gsContext strong_gs() {
			return getRuleContext(Strong_gsContext.class,0);
		}
		public TerminalNode APOS_END() { return getToken(uebMathParser.APOS_END, 0); }
		public WordEndingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordEnding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterWordEnding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitWordEnding(this);
		}
	}

	public final WordEndingContext wordEnding() throws RecognitionException {
		WordEndingContext _localctx = new WordEndingContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_wordEnding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(507);
				alphaSeq();
				}
				break;
			case 2:
				{
				setState(508);
				shortForms();
				}
				break;
			case 3:
				{
				setState(509);
				singleLetter();
				}
				break;
			case 4:
				{
				setState(510);
				match(LETTERS_NOT_DIGITS);
				}
				break;
			case 5:
				{
				setState(511);
				strong_ws();
				}
				break;
			case 6:
				{
				setState(512);
				match(ROOT);
				}
				break;
			case 7:
				{
				setState(513);
				match(UPDIGS);
				}
				break;
			case 8:
				{
				setState(514);
				match(SLASH_ROOT);
				}
				break;
			case 9:
				{
				setState(515);
				flc();
				}
				break;
			case 10:
				{
				setState(516);
				ilc();
				}
				break;
			case 11:
				{
				setState(517);
				largeSign();
				}
				break;
			case 12:
				{
				setState(518);
				strong_gs();
				}
				break;
			}
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(521);
				match(APOS_END);
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

	public static class FlcERRORContext extends ParserRuleContext {
		public FlcContext flc() {
			return getRuleContext(FlcContext.class,0);
		}
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public List<WordEndingContext> wordEnding() {
			return getRuleContexts(WordEndingContext.class);
		}
		public WordEndingContext wordEnding(int i) {
			return getRuleContext(WordEndingContext.class,i);
		}
		public FlcERRORContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flcERROR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFlcERROR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFlcERROR(this);
		}
	}

	public final FlcERRORContext flcERROR() throws RecognitionException {
		FlcERRORContext _localctx = new FlcERRORContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_flcERROR);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(524);
				match(DOT6);
				}
				break;
			}
			setState(527);
			flc();
			setState(531);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(528);
					wordEnding();
					}
					} 
				}
				setState(533);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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

	public static class Expr2Context extends ParserRuleContext {
		public DigitsContext digits() {
			return getRuleContext(DigitsContext.class,0);
		}
		public CommaContext comma() {
			return getRuleContext(CommaContext.class,0);
		}
		public SpaceContext space() {
			return getRuleContext(SpaceContext.class,0);
		}
		public AngleBracketContext angleBracket() {
			return getRuleContext(AngleBracketContext.class,0);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public OGroupContext oGroup() {
			return getRuleContext(OGroupContext.class,0);
		}
		public TerminalNode OGROUP() { return getToken(uebMathParser.OGROUP, 0); }
		public CGroupContext cGroup() {
			return getRuleContext(CGroupContext.class,0);
		}
		public TerminalNode CGROUP() { return getToken(uebMathParser.CGROUP, 0); }
		public JustALetterContext justALetter() {
			return getRuleContext(JustALetterContext.class,0);
		}
		public SingleLetterContext singleLetter() {
			return getRuleContext(SingleLetterContext.class,0);
		}
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public TerminalNode PR_TOKEN() { return getToken(uebMathParser.PR_TOKEN, 0); }
		public G1MathRootsContext g1MathRoots() {
			return getRuleContext(G1MathRootsContext.class,0);
		}
		public TerminalNode ROOT() { return getToken(uebMathParser.ROOT, 0); }
		public TerminalNode DOTS56() { return getToken(uebMathParser.DOTS56, 0); }
		public BrlogrpContext brlogrp() {
			return getRuleContext(BrlogrpContext.class,0);
		}
		public BrlcgrpContext brlcgrp() {
			return getRuleContext(BrlcgrpContext.class,0);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		return expr2(0);
	}

	private Expr2Context expr2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr2Context _localctx = new Expr2Context(_ctx, _parentState);
		Expr2Context _prevctx = _localctx;
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expr2, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(535);
				digits();
				}
				break;
			case 2:
				{
				setState(536);
				comma();
				setState(538);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
				case 1:
					{
					setState(537);
					space();
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(540);
				angleBracket();
				}
				break;
			case 4:
				{
				setState(543);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
				case 1:
					{
					setState(541);
					oGroup();
					}
					break;
				case 2:
					{
					setState(542);
					match(OGROUP);
					}
					break;
				}
				setState(545);
				expr2(0);
				setState(548);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(546);
					cGroup();
					}
					break;
				case 2:
					{
					setState(547);
					match(CGROUP);
					}
					break;
				}
				}
				break;
			case 5:
				{
				setState(550);
				justALetter();
				}
				break;
			case 6:
				{
				setState(551);
				singleLetter();
				}
				break;
			case 7:
				{
				setState(552);
				word();
				}
				break;
			case 8:
				{
				setState(553);
				match(PR_TOKEN);
				}
				break;
			case 9:
				{
				setState(554);
				g1MathRoots();
				}
				break;
			case 10:
				{
				setState(555);
				oGroup();
				}
				break;
			case 11:
				{
				setState(556);
				match(OGROUP);
				}
				break;
			case 12:
				{
				setState(557);
				cGroup();
				}
				break;
			case 13:
				{
				setState(558);
				match(CGROUP);
				}
				break;
			case 14:
				{
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOTS56) {
					{
					setState(559);
					match(DOTS56);
					}
				}

				setState(562);
				match(ROOT);
				}
				break;
			case 15:
				{
				setState(563);
				brlogrp();
				setState(564);
				expr2(0);
				setState(565);
				brlcgrp();
				}
				break;
			case 16:
				{
				setState(567);
				brlogrp();
				}
				break;
			case 17:
				{
				setState(568);
				brlcgrp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(579);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(577);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						_localctx = new Expr2Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(571);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(572);
						binop();
						setState(573);
						expr2(20);
						}
						break;
					case 2:
						{
						_localctx = new Expr2Context(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr2);
						setState(575);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						{
						setState(576);
						expr2(0);
						}
						}
						break;
					}
					} 
				}
				setState(581);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class OGroupContext extends ParserRuleContext {
		public TerminalNode OGROUP() { return getToken(uebMathParser.OGROUP, 0); }
		public OGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterOGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitOGroup(this);
		}
	}

	public final OGroupContext oGroup() throws RecognitionException {
		OGroupContext _localctx = new OGroupContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_oGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
			setState(583);
			match(OGROUP);
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

	public static class CGroupContext extends ParserRuleContext {
		public TerminalNode CGROUP() { return getToken(uebMathParser.CGROUP, 0); }
		public CGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterCGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitCGroup(this);
		}
	}

	public final CGroupContext cGroup() throws RecognitionException {
		CGroupContext _localctx = new CGroupContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_cGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
			setState(586);
			match(CGROUP);
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

	public static class G1MathRootsContext extends ParserRuleContext {
		public TerminalNode DOTS235() { return getToken(uebMathParser.DOTS235, 0); }
		public G1MathRootsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g1MathRoots; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterG1MathRoots(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitG1MathRoots(this);
		}
	}

	public final G1MathRootsContext g1MathRoots() throws RecognitionException {
		G1MathRootsContext _localctx = new G1MathRootsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_g1MathRoots);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
			setState(589);
			match(DOTS235);
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

	public static class FracStartContext extends ParserRuleContext {
		public TerminalNode OForFRACS() { return getToken(uebMathParser.OForFRACS, 0); }
		public TerminalNode OF_ROOT() { return getToken(uebMathParser.OF_ROOT, 0); }
		public TerminalNode MLFRACS() { return getToken(uebMathParser.MLFRACS, 0); }
		public FracStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fracStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFracStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFracStart(this);
		}
	}

	public final FracStartContext fracStart() throws RecognitionException {
		FracStartContext _localctx = new FracStartContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_fracStart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_la = _input.LA(1);
			if ( !(_la==MLFRACS || _la==OF_ROOT || _la==OForFRACS) ) {
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

	public static class FracEndContext extends ParserRuleContext {
		public TerminalNode WITHorFRCE() { return getToken(uebMathParser.WITHorFRCE, 0); }
		public TerminalNode WITH_ROOT() { return getToken(uebMathParser.WITH_ROOT, 0); }
		public TerminalNode END_NM_with_G1() { return getToken(uebMathParser.END_NM_with_G1, 0); }
		public TerminalNode MLFRACE() { return getToken(uebMathParser.MLFRACE, 0); }
		public TerminalNode NM_FRACE() { return getToken(uebMathParser.NM_FRACE, 0); }
		public TerminalNode END_NM_with_FRACE() { return getToken(uebMathParser.END_NM_with_FRACE, 0); }
		public FracEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fracEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFracEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFracEnd(this);
		}
	}

	public final FracEndContext fracEnd() throws RecognitionException {
		FracEndContext _localctx = new FracEndContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_fracEnd);
		int _la;
		try {
			setState(600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WITH_ROOT:
			case WITHorFRCE:
			case END_NM_with_G1:
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_NM_with_G1) {
					{
					setState(593);
					match(END_NM_with_G1);
					}
				}

				setState(596);
				_la = _input.LA(1);
				if ( !(_la==WITH_ROOT || _la==WITHorFRCE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case MLFRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(597);
				match(MLFRACE);
				}
				break;
			case NM_FRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(598);
				match(NM_FRACE);
				}
				break;
			case END_NM_with_FRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(599);
				match(END_NM_with_FRACE);
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

	public static class FracLineContext extends ParserRuleContext {
		public TerminalNode MLFRACIL() { return getToken(uebMathParser.MLFRACIL, 0); }
		public TerminalNode NMFRACIL() { return getToken(uebMathParser.NMFRACIL, 0); }
		public FracLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fracLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterFracLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitFracLine(this);
		}
	}

	public final FracLineContext fracLine() throws RecognitionException {
		FracLineContext _localctx = new FracLineContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fracLine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_la = _input.LA(1);
			if ( !(_la==MLFRACIL || _la==NMFRACIL) ) {
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

	public static class MLsubContext extends ParserRuleContext {
		public TerminalNode MLSUB() { return getToken(uebMathParser.MLSUB, 0); }
		public TerminalNode DOTS35() { return getToken(uebMathParser.DOTS35, 0); }
		public MLsubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mLsub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterMLsub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitMLsub(this);
		}
	}

	public final MLsubContext mLsub() throws RecognitionException {
		MLsubContext _localctx = new MLsubContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_mLsub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(604);
				match(MLSUB);
				}
				break;
			case 2:
				{
				setState(605);
				if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
				setState(606);
				match(DOTS35);
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

	public static class MLsupContext extends ParserRuleContext {
		public TerminalNode MLSUP() { return getToken(uebMathParser.MLSUP, 0); }
		public MLsupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mLsup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterMLsup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitMLsup(this);
		}
	}

	public final MLsupContext mLsup() throws RecognitionException {
		MLsupContext _localctx = new MLsupContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_mLsup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(MLSUP);
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

	public static class BrlogrpContext extends ParserRuleContext {
		public TerminalNode MLROWS() { return getToken(uebMathParser.MLROWS, 0); }
		public TerminalNode DOTS126() { return getToken(uebMathParser.DOTS126, 0); }
		public BrlogrpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brlogrp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterBrlogrp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitBrlogrp(this);
		}
	}

	public final BrlogrpContext brlogrp() throws RecognitionException {
		BrlogrpContext _localctx = new BrlogrpContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_brlogrp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(611);
				match(MLROWS);
				}
				break;
			case 2:
				{
				setState(612);
				if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
				setState(613);
				match(DOTS126);
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

	public static class BrlcgrpContext extends ParserRuleContext {
		public TerminalNode MLROWE() { return getToken(uebMathParser.MLROWE, 0); }
		public TerminalNode DOTS345() { return getToken(uebMathParser.DOTS345, 0); }
		public BrlcgrpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brlcgrp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterBrlcgrp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitBrlcgrp(this);
		}
	}

	public final BrlcgrpContext brlcgrp() throws RecognitionException {
		BrlcgrpContext _localctx = new BrlcgrpContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_brlcgrp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(616);
				match(MLROWE);
				}
				break;
			case 2:
				{
				setState(617);
				if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
				setState(618);
				match(DOTS345);
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

	public static class SupExprContext extends ParserRuleContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public FracStartContext fracStart() {
			return getRuleContext(FracStartContext.class,0);
		}
		public FracLineContext fracLine() {
			return getRuleContext(FracLineContext.class,0);
		}
		public FracEndContext fracEnd() {
			return getRuleContext(FracEndContext.class,0);
		}
		public BrlogrpContext brlogrp() {
			return getRuleContext(BrlogrpContext.class,0);
		}
		public List<SupExprContext> supExpr() {
			return getRuleContexts(SupExprContext.class);
		}
		public SupExprContext supExpr(int i) {
			return getRuleContext(SupExprContext.class,i);
		}
		public BrlcgrpContext brlcgrp() {
			return getRuleContext(BrlcgrpContext.class,0);
		}
		public MLsupContext mLsup() {
			return getRuleContext(MLsupContext.class,0);
		}
		public SupExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSupExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSupExpr(this);
		}
	}

	public final SupExprContext supExpr() throws RecognitionException {
		return supExpr(0);
	}

	private SupExprContext supExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SupExprContext _localctx = new SupExprContext(_ctx, _parentState);
		SupExprContext _prevctx = _localctx;
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_supExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(622);
				expr2(0);
				}
				break;
			case 2:
				{
				setState(624);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(623);
					brlogrp();
					}
					break;
				}
				setState(626);
				fracStart();
				setState(629); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(629);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
						case 1:
							{
							setState(627);
							expr2(0);
							}
							break;
						case 2:
							{
							setState(628);
							supExpr(0);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(631); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(633);
				fracLine();
				setState(636); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(636);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
						case 1:
							{
							setState(634);
							expr2(0);
							}
							break;
						case 2:
							{
							setState(635);
							supExpr(0);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(638); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(640);
				fracEnd();
				setState(642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
				case 1:
					{
					setState(641);
					brlcgrp();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(654);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(652);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
					case 1:
						{
						_localctx = new SupExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_supExpr);
						setState(646);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(647);
						mLsup();
						setState(648);
						supExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new SupExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_supExpr);
						setState(650);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(651);
						supExpr(3);
						}
						break;
					}
					} 
				}
				setState(656);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SubsupExprContext extends ParserRuleContext {
		public SubExprContext subExpr() {
			return getRuleContext(SubExprContext.class,0);
		}
		public List<MLsupContext> mLsup() {
			return getRuleContexts(MLsupContext.class);
		}
		public MLsupContext mLsup(int i) {
			return getRuleContext(MLsupContext.class,i);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public SubsupExprContext subsupExpr() {
			return getRuleContext(SubsupExprContext.class,0);
		}
		public SubsupExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subsupExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSubsupExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSubsupExpr(this);
		}
	}

	public final SubsupExprContext subsupExpr() throws RecognitionException {
		SubsupExprContext _localctx = new SubsupExprContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_subsupExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			subExpr(0);
			setState(658);
			mLsup();
			setState(659);
			expr2(0);
			setState(660);
			subsupExpr();
			setState(661);
			mLsup();
			setState(662);
			expr2(0);
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

	public static class SubExprContext extends ParserRuleContext {
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public FracStartContext fracStart() {
			return getRuleContext(FracStartContext.class,0);
		}
		public FracLineContext fracLine() {
			return getRuleContext(FracLineContext.class,0);
		}
		public FracEndContext fracEnd() {
			return getRuleContext(FracEndContext.class,0);
		}
		public BrlogrpContext brlogrp() {
			return getRuleContext(BrlogrpContext.class,0);
		}
		public List<SubExprContext> subExpr() {
			return getRuleContexts(SubExprContext.class);
		}
		public SubExprContext subExpr(int i) {
			return getRuleContext(SubExprContext.class,i);
		}
		public BrlcgrpContext brlcgrp() {
			return getRuleContext(BrlcgrpContext.class,0);
		}
		public MLsubContext mLsub() {
			return getRuleContext(MLsubContext.class,0);
		}
		public SubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSubExpr(this);
		}
	}

	public final SubExprContext subExpr() throws RecognitionException {
		return subExpr(0);
	}

	private SubExprContext subExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SubExprContext _localctx = new SubExprContext(_ctx, _parentState);
		SubExprContext _prevctx = _localctx;
		int _startState = 108;
		enterRecursionRule(_localctx, 108, RULE_subExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(665);
				expr2(0);
				}
				break;
			case 2:
				{
				setState(667);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(666);
					brlogrp();
					}
					break;
				}
				setState(669);
				fracStart();
				setState(672); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(672);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
						case 1:
							{
							setState(670);
							expr2(0);
							}
							break;
						case 2:
							{
							setState(671);
							subExpr(0);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(674); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(676);
				fracLine();
				setState(679); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(679);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
						case 1:
							{
							setState(677);
							expr2(0);
							}
							break;
						case 2:
							{
							setState(678);
							subExpr(0);
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(681); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(683);
				fracEnd();
				setState(685);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(684);
					brlcgrp();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(697);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(695);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
					case 1:
						{
						_localctx = new SubExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subExpr);
						setState(689);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(690);
						mLsub();
						setState(691);
						subExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new SubExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_subExpr);
						setState(693);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(694);
						subExpr(3);
						}
						break;
					}
					} 
				}
				setState(699);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CfracContext extends ParserRuleContext {
		public FracStartContext fracStart() {
			return getRuleContext(FracStartContext.class,0);
		}
		public FracLineContext fracLine() {
			return getRuleContext(FracLineContext.class,0);
		}
		public FracEndContext fracEnd() {
			return getRuleContext(FracEndContext.class,0);
		}
		public List<Expr2Context> expr2() {
			return getRuleContexts(Expr2Context.class);
		}
		public Expr2Context expr2(int i) {
			return getRuleContext(Expr2Context.class,i);
		}
		public List<FracContext> frac() {
			return getRuleContexts(FracContext.class);
		}
		public FracContext frac(int i) {
			return getRuleContext(FracContext.class,i);
		}
		public CfracContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cfrac; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterCfrac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitCfrac(this);
		}
	}

	public final CfracContext cfrac() throws RecognitionException {
		CfracContext _localctx = new CfracContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_cfrac);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			fracStart();
			setState(703); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(703);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
					case 1:
						{
						setState(701);
						expr2(0);
						}
						break;
					case 2:
						{
						setState(702);
						frac();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(705); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(707);
			fracLine();
			setState(710); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(710);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
					case 1:
						{
						setState(708);
						expr2(0);
						}
						break;
					case 2:
						{
						setState(709);
						frac();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(712); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(714);
			fracEnd();
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

	public static class NumModeItemContext extends ParserRuleContext {
		public TerminalNode START_NUMERIC_MODE() { return getToken(uebMathParser.START_NUMERIC_MODE, 0); }
		public NumModeContentContext numModeContent() {
			return getRuleContext(NumModeContentContext.class,0);
		}
		public NumModeItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numModeItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterNumModeItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitNumModeItem(this);
		}
	}

	public final NumModeItemContext numModeItem() throws RecognitionException {
		NumModeItemContext _localctx = new NumModeItemContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_numModeItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			match(START_NUMERIC_MODE);
			setState(717);
			numModeContent();
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

	public static class NumModeContentContext extends ParserRuleContext {
		public TerminalNode NUM_SPACE_DIGIT() { return getToken(uebMathParser.NUM_SPACE_DIGIT, 0); }
		public TerminalNode NDIG_SEQ() { return getToken(uebMathParser.NDIG_SEQ, 0); }
		public TerminalNode NUM_SIMPLE_FRAC_LINE() { return getToken(uebMathParser.NUM_SIMPLE_FRAC_LINE, 0); }
		public TerminalNode NUM_CONT_NUM_SPACE() { return getToken(uebMathParser.NUM_CONT_NUM_SPACE, 0); }
		public TerminalNode NUM_CONT() { return getToken(uebMathParser.NUM_CONT, 0); }
		public NumModeContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numModeContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterNumModeContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitNumModeContent(this);
		}
	}

	public final NumModeContentContext numModeContent() throws RecognitionException {
		NumModeContentContext _localctx = new NumModeContentContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_numModeContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			_la = _input.LA(1);
			if ( !(((((_la - 122)) & ~0x3f) == 0 && ((1L << (_la - 122)) & ((1L << (NUM_CONT_NUM_SPACE - 122)) | (1L << (NUM_CONT - 122)) | (1L << (NUM_SPACE_DIGIT - 122)) | (1L << (NDIG_SEQ - 122)) | (1L << (NUM_SIMPLE_FRAC_LINE - 122)))) != 0)) ) {
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

	public static class G1WrdOrPssgContext extends ParserRuleContext {
		public TerminalNode G1PassageInd() { return getToken(uebMathParser.G1PassageInd, 0); }
		public TerminalNode G1WordInd() { return getToken(uebMathParser.G1WordInd, 0); }
		public G1WrdOrPssgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g1WrdOrPssg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterG1WrdOrPssg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitG1WrdOrPssg(this);
		}
	}

	public final G1WrdOrPssgContext g1WrdOrPssg() throws RecognitionException {
		G1WrdOrPssgContext _localctx = new G1WrdOrPssgContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_g1WrdOrPssg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case G1PassageInd:
				{
				setState(721);
				match(G1PassageInd);
				g1Passage = true;
				              System.out.println("G1Passage");
				}
				break;
			case G1WordInd:
				{
				setState(723);
				match(G1WordInd);
				g1Wrd = true;
				              System.out.println("G1Word");
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			g1WrdOrPassage = true;
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

	public static class G1TERMContext extends ParserRuleContext {
		public TerminalNode G1TermInd() { return getToken(uebMathParser.G1TermInd, 0); }
		public TerminalNode END_NM_with_G1TERM() { return getToken(uebMathParser.END_NM_with_G1TERM, 0); }
		public G1TERMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g1TERM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterG1TERM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitG1TERM(this);
		}
	}

	public final G1TERMContext g1TERM() throws RecognitionException {
		G1TERMContext _localctx = new G1TERMContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_g1TERM);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			_la = _input.LA(1);
			if ( !(_la==G1TermInd || _la==END_NM_with_G1TERM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			g1WrdOrPassage = false;
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

	public static class NumericPassageContext extends ParserRuleContext {
		public TerminalNode START_NUMERIC_PASSAGE() { return getToken(uebMathParser.START_NUMERIC_PASSAGE, 0); }
		public NumericPassageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericPassage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterNumericPassage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitNumericPassage(this);
		}
	}

	public final NumericPassageContext numericPassage() throws RecognitionException {
		NumericPassageContext _localctx = new NumericPassageContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_numericPassage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(START_NUMERIC_PASSAGE);
			numPassage = true;
			                                       g1Passage = true;
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

	public static class EndNumPassageContext extends ParserRuleContext {
		public TerminalNode EXIT_NUMERIC_PASSAGE() { return getToken(uebMathParser.EXIT_NUMERIC_PASSAGE, 0); }
		public EndNumPassageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endNumPassage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterEndNumPassage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitEndNumPassage(this);
		}
	}

	public final EndNumPassageContext endNumPassage() throws RecognitionException {
		EndNumPassageContext _localctx = new EndNumPassageContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_endNumPassage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(EXIT_NUMERIC_PASSAGE);
			numPassage = false;
			                                      g1Passage = false;
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

	public static class HyphenContext extends ParserRuleContext {
		public TerminalNode DOTS36() { return getToken(uebMathParser.DOTS36, 0); }
		public TerminalNode END_NM_with_HYPHEN() { return getToken(uebMathParser.END_NM_with_HYPHEN, 0); }
		public HyphenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hyphen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterHyphen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitHyphen(this);
		}
	}

	public final HyphenContext hyphen() throws RecognitionException {
		HyphenContext _localctx = new HyphenContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_hyphen);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738);
			_la = _input.LA(1);
			if ( !(_la==DOTS36 || _la==END_NM_with_HYPHEN) ) {
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

	public static class DashContext extends ParserRuleContext {
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public TerminalNode DOTS36() { return getToken(uebMathParser.DOTS36, 0); }
		public TerminalNode END_NM_with_DASH() { return getToken(uebMathParser.END_NM_with_DASH, 0); }
		public DashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterDash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitDash(this);
		}
	}

	public final DashContext dash() throws RecognitionException {
		DashContext _localctx = new DashContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_dash);
		try {
			setState(743);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT6:
				enterOuterAlt(_localctx, 1);
				{
				setState(740);
				match(DOT6);
				setState(741);
				match(DOTS36);
				}
				break;
			case END_NM_with_DASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				match(END_NM_with_DASH);
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

	public static class Long_dashContext extends ParserRuleContext {
		public TerminalNode DOT5() { return getToken(uebMathParser.DOT5, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public TerminalNode DOTS36() { return getToken(uebMathParser.DOTS36, 0); }
		public Long_dashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_long_dash; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterLong_dash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitLong_dash(this);
		}
	}

	public final Long_dashContext long_dash() throws RecognitionException {
		Long_dashContext _localctx = new Long_dashContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_long_dash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(DOT5);
			setState(746);
			match(DOT6);
			setState(747);
			match(DOTS36);
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

	public static class ShortFormsContext extends ParserRuleContext {
		public TerminalNode CHSF() { return getToken(uebMathParser.CHSF, 0); }
		public TerminalNode SHSF() { return getToken(uebMathParser.SHSF, 0); }
		public TerminalNode STSF() { return getToken(uebMathParser.STSF, 0); }
		public TerminalNode OURSELVES() { return getToken(uebMathParser.OURSELVES, 0); }
		public TerminalNode THSF() { return getToken(uebMathParser.THSF, 0); }
		public TerminalNode ERSF() { return getToken(uebMathParser.ERSF, 0); }
		public TerminalNode ONESELF() { return getToken(uebMathParser.ONESELF, 0); }
		public TerminalNode THMSLVS() { return getToken(uebMathParser.THMSLVS, 0); }
		public TerminalNode CONCV() { return getToken(uebMathParser.CONCV, 0); }
		public TerminalNode SHORTFORM() { return getToken(uebMathParser.SHORTFORM, 0); }
		public TerminalNode SFA() { return getToken(uebMathParser.SFA, 0); }
		public TerminalNode SFB() { return getToken(uebMathParser.SFB, 0); }
		public TerminalNode SFC() { return getToken(uebMathParser.SFC, 0); }
		public TerminalNode SFCC() { return getToken(uebMathParser.SFCC, 0); }
		public ShortFormsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortForms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterShortForms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitShortForms(this);
		}
	}

	public final ShortFormsContext shortForms() throws RecognitionException {
		ShortFormsContext _localctx = new ShortFormsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_shortForms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (SFB - 67)) | (1L << (CHSF - 67)) | (1L << (SHSF - 67)) | (1L << (SFCC - 67)) | (1L << (STSF - 67)) | (1L << (OURSELVES - 67)) | (1L << (THSF - 67)) | (1L << (ERSF - 67)) | (1L << (ONESELF - 67)) | (1L << (THMSLVS - 67)) | (1L << (CONCV - 67)))) != 0) || ((((_la - 148)) & ~0x3f) == 0 && ((1L << (_la - 148)) & ((1L << (SHORTFORM - 148)) | (1L << (SFA - 148)) | (1L << (SFC - 148)))) != 0)) ) {
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

	public static class JustALetterContext extends ParserRuleContext {
		public TerminalNode LETTERA() { return getToken(uebMathParser.LETTERA, 0); }
		public TerminalNode LETTERB() { return getToken(uebMathParser.LETTERB, 0); }
		public TerminalNode UPDIGS() { return getToken(uebMathParser.UPDIGS, 0); }
		public TerminalNode MOST_LETTERS() { return getToken(uebMathParser.MOST_LETTERS, 0); }
		public TerminalNode LETTERK() { return getToken(uebMathParser.LETTERK, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public TerminalNode DOTS56() { return getToken(uebMathParser.DOTS56, 0); }
		public JustALetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justALetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterJustALetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitJustALetter(this);
		}
	}

	public final JustALetterContext justALetter() throws RecognitionException {
		JustALetterContext _localctx = new JustALetterContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_justALetter);
		int _la;
		try {
			setState(761);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(751);
				if (!(g1WrdOrPassage)) throw new FailedPredicateException(this, "g1WrdOrPassage");
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT6) {
					{
					setState(752);
					match(DOT6);
					}
				}

				setState(755);
				_la = _input.LA(1);
				if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0)) ) {
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(756);
				match(DOTS56);
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT6) {
					{
					setState(757);
					match(DOT6);
					}
				}

				setState(760);
				_la = _input.LA(1);
				if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	public static class SingleLetterContext extends ParserRuleContext {
		public UcLettersContext ucLetters() {
			return getRuleContext(UcLettersContext.class,0);
		}
		public TerminalNode MODIF() { return getToken(uebMathParser.MODIF, 0); }
		public TerminalNode LETTERA() { return getToken(uebMathParser.LETTERA, 0); }
		public TerminalNode LETTERB() { return getToken(uebMathParser.LETTERB, 0); }
		public TerminalNode UPDIGS() { return getToken(uebMathParser.UPDIGS, 0); }
		public TerminalNode MOST_LETTERS() { return getToken(uebMathParser.MOST_LETTERS, 0); }
		public TerminalNode LETTERK() { return getToken(uebMathParser.LETTERK, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public SingleLetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleLetter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSingleLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSingleLetter(this);
		}
	}

	public final SingleLetterContext singleLetter() throws RecognitionException {
		SingleLetterContext _localctx = new SingleLetterContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_singleLetter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			setState(770);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT6:
			case LETTERA:
			case LETTERB:
			case UPDIGS:
			case LETTERK:
			case MOST_LETTERS:
				{
				{
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT6) {
					{
					setState(764);
					match(DOT6);
					}
				}

				setState(767);
				_la = _input.LA(1);
				if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0)) ) {
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
			case CapitalLetter:
				{
				setState(768);
				ucLetters();
				}
				break;
			case MODIF:
				{
				setState(769);
				match(MODIF);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class UcLettersContext extends ParserRuleContext {
		public TerminalNode CapitalLetter() { return getToken(uebMathParser.CapitalLetter, 0); }
		public UcLettersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ucLetters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterUcLetters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitUcLetters(this);
		}
	}

	public final UcLettersContext ucLetters() throws RecognitionException {
		UcLettersContext _localctx = new UcLettersContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_ucLetters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(CapitalLetter);
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

	public static class SaLettersContext extends ParserRuleContext {
		public List<TerminalNode> LETTERA() { return getTokens(uebMathParser.LETTERA); }
		public TerminalNode LETTERA(int i) {
			return getToken(uebMathParser.LETTERA, i);
		}
		public List<TerminalNode> LETTERB() { return getTokens(uebMathParser.LETTERB); }
		public TerminalNode LETTERB(int i) {
			return getToken(uebMathParser.LETTERB, i);
		}
		public List<TerminalNode> UPDIGS() { return getTokens(uebMathParser.UPDIGS); }
		public TerminalNode UPDIGS(int i) {
			return getToken(uebMathParser.UPDIGS, i);
		}
		public List<TerminalNode> MOST_LETTERS() { return getTokens(uebMathParser.MOST_LETTERS); }
		public TerminalNode MOST_LETTERS(int i) {
			return getToken(uebMathParser.MOST_LETTERS, i);
		}
		public List<TerminalNode> LETTERK() { return getTokens(uebMathParser.LETTERK); }
		public TerminalNode LETTERK(int i) {
			return getToken(uebMathParser.LETTERK, i);
		}
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public SaLettersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saLetters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterSaLetters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitSaLetters(this);
		}
	}

	public final SaLettersContext saLetters() throws RecognitionException {
		SaLettersContext _localctx = new SaLettersContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_saLetters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT6) {
				{
				setState(774);
				match(DOT6);
				}
			}

			setState(777);
			_la = _input.LA(1);
			if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(779); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(778);
				_la = _input.LA(1);
				if ( !(((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(781); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (LETTERA - 79)) | (1L << (LETTERB - 79)) | (1L << (UPDIGS - 79)) | (1L << (LETTERK - 79)) | (1L << (MOST_LETTERS - 79)))) != 0) );
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

	public static class StandAloneConContext extends ParserRuleContext {
		public Strong_wsContext strong_ws() {
			return getRuleContext(Strong_wsContext.class,0);
		}
		public SaLettersContext saLetters() {
			return getRuleContext(SaLettersContext.class,0);
		}
		public ShortFormsContext shortForms() {
			return getRuleContext(ShortFormsContext.class,0);
		}
		public SingleLetterContext singleLetter() {
			return getRuleContext(SingleLetterContext.class,0);
		}
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public StandAloneConContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_standAloneCon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterStandAloneCon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitStandAloneCon(this);
		}
	}

	public final StandAloneConContext standAloneCon() throws RecognitionException {
		StandAloneConContext _localctx = new StandAloneConContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_standAloneCon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
			{
			setState(785);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(784);
				match(DOT6);
				}
				break;
			}
			setState(792);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(787);
				strong_ws();
				}
				break;
			case 2:
				{
				setState(788);
				saLetters();
				}
				break;
			case 3:
				{
				setState(789);
				shortForms();
				}
				break;
			case 4:
				{
				setState(790);
				if (!(!g1WrdOrPassage)) throw new FailedPredicateException(this, "!g1WrdOrPassage");
				setState(791);
				singleLetter();
				}
				break;
			}
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

	public static class PreNoQuotesContext extends ParserRuleContext {
		public List<TerminalNode> OGROUP() { return getTokens(uebMathParser.OGROUP); }
		public TerminalNode OGROUP(int i) {
			return getToken(uebMathParser.OGROUP, i);
		}
		public PreNoQuotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preNoQuotes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterPreNoQuotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitPreNoQuotes(this);
		}
	}

	public final PreNoQuotesContext preNoQuotes() throws RecognitionException {
		PreNoQuotesContext _localctx = new PreNoQuotesContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_preNoQuotes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(795); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(794);
					match(OGROUP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(797); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
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

	public static class PreLowContext extends ParserRuleContext {
		public PreNoQuotesContext preNoQuotes() {
			return getRuleContext(PreNoQuotesContext.class,0);
		}
		public TerminalNode DOTS236() { return getToken(uebMathParser.DOTS236, 0); }
		public TerminalNode DOT5() { return getToken(uebMathParser.DOT5, 0); }
		public TerminalNode DOTS2356() { return getToken(uebMathParser.DOTS2356, 0); }
		public TerminalNode DOT3() { return getToken(uebMathParser.DOT3, 0); }
		public TerminalNode DOTS456() { return getToken(uebMathParser.DOTS456, 0); }
		public TerminalNode DOTS45() { return getToken(uebMathParser.DOTS45, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public PreLowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preLow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterPreLow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitPreLow(this);
		}
	}

	public final PreLowContext preLow() throws RecognitionException {
		PreLowContext _localctx = new PreLowContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_preLow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT6:
			case DOTS45:
			case DOTS456:
			case DOTS236:
				{
				{
				setState(800);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) {
					{
					setState(799);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(802);
				match(DOTS236);
				}
				}
				break;
			case DOT5:
			case DOT3:
				{
				setState(806);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT5:
					{
					setState(803);
					match(DOT5);
					setState(804);
					match(DOTS2356);
					}
					break;
				case DOT3:
					{
					setState(805);
					match(DOT3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case OGROUP:
				break;
			default:
				break;
			}
			setState(810);
			preNoQuotes();
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

	public static class PreAloneContext extends ParserRuleContext {
		public TerminalNode CapsPassageInd() { return getToken(uebMathParser.CapsPassageInd, 0); }
		public PreNoQuotesContext preNoQuotes() {
			return getRuleContext(PreNoQuotesContext.class,0);
		}
		public TerminalNode DOTS236() { return getToken(uebMathParser.DOTS236, 0); }
		public TerminalNode DOT5() { return getToken(uebMathParser.DOT5, 0); }
		public TerminalNode DOTS2356() { return getToken(uebMathParser.DOTS2356, 0); }
		public TerminalNode DOT3() { return getToken(uebMathParser.DOT3, 0); }
		public TerminalNode DOTS456() { return getToken(uebMathParser.DOTS456, 0); }
		public TerminalNode DOTS45() { return getToken(uebMathParser.DOTS45, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public PreAloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preAlone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterPreAlone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitPreAlone(this);
		}
	}

	public final PreAloneContext preAlone() throws RecognitionException {
		PreAloneContext _localctx = new PreAloneContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_preAlone);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OGROUP:
				{
				{
				setState(812);
				preNoQuotes();
				}
				}
				break;
			case DOT6:
			case DOTS45:
			case DOTS456:
			case DOTS236:
				{
				{
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) {
					{
					setState(813);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(816);
				match(DOTS236);
				}
				}
				break;
			case DOT5:
			case DOT3:
				{
				setState(820);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT5:
					{
					setState(817);
					match(DOT5);
					setState(818);
					match(DOTS2356);
					}
					break;
				case DOT3:
					{
					setState(819);
					match(DOT3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case CapsPassageInd:
				{
				setState(822);
				match(CapsPassageInd);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PostOkContext extends ParserRuleContext {
		public TerminalNode DOTS345() { return getToken(uebMathParser.DOTS345, 0); }
		public TerminalNode DOT5() { return getToken(uebMathParser.DOT5, 0); }
		public TerminalNode DOTS46() { return getToken(uebMathParser.DOTS46, 0); }
		public TerminalNode DOTS456() { return getToken(uebMathParser.DOTS456, 0); }
		public PostOkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postOk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterPostOk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitPostOk(this);
		}
	}

	public final PostOkContext postOk() throws RecognitionException {
		PostOkContext _localctx = new PostOkContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_postOk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT5) | (1L << DOTS46) | (1L << DOTS456))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(826);
			match(DOTS345);
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

	public static class PostAloneContext extends ParserRuleContext {
		public CommaContext comma() {
			return getRuleContext(CommaContext.class,0);
		}
		public TerminalNode DOTS23() { return getToken(uebMathParser.DOTS23, 0); }
		public TerminalNode DOTS25() { return getToken(uebMathParser.DOTS25, 0); }
		public List<TerminalNode> DOTS256() { return getTokens(uebMathParser.DOTS256); }
		public TerminalNode DOTS256(int i) {
			return getToken(uebMathParser.DOTS256, i);
		}
		public TerminalNode DOTS235() { return getToken(uebMathParser.DOTS235, 0); }
		public TerminalNode DOTS236() { return getToken(uebMathParser.DOTS236, 0); }
		public TerminalNode DOTS356() { return getToken(uebMathParser.DOTS356, 0); }
		public TerminalNode DOT5() { return getToken(uebMathParser.DOT5, 0); }
		public TerminalNode DOTS2356() { return getToken(uebMathParser.DOTS2356, 0); }
		public TerminalNode DOT3() { return getToken(uebMathParser.DOT3, 0); }
		public List<TerminalNode> CGROUP() { return getTokens(uebMathParser.CGROUP); }
		public TerminalNode CGROUP(int i) {
			return getToken(uebMathParser.CGROUP, i);
		}
		public TerminalNode DOTS456() { return getToken(uebMathParser.DOTS456, 0); }
		public TerminalNode DOTS45() { return getToken(uebMathParser.DOTS45, 0); }
		public TerminalNode DOT6() { return getToken(uebMathParser.DOT6, 0); }
		public PostAloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postAlone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterPostAlone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitPostAlone(this);
		}
	}

	public final PostAloneContext postAlone() throws RecognitionException {
		PostAloneContext _localctx = new PostAloneContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_postAlone);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(857);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA_ROOT:
			case DOT2:
			case DOTS23:
			case DOTS25:
			case DOTS256:
			case DOTS235:
			case DOTS236:
				{
				setState(841);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA_ROOT:
				case DOT2:
					{
					setState(828);
					comma();
					}
					break;
				case DOTS23:
					{
					setState(829);
					match(DOTS23);
					}
					break;
				case DOTS25:
					{
					setState(830);
					match(DOTS25);
					}
					break;
				case DOTS256:
					{
					setState(831);
					match(DOTS256);
					setState(836);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(832);
							match(DOTS256);
							setState(833);
							match(DOTS256);
							}
							} 
						}
						setState(838);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
					}
					}
					break;
				case DOTS235:
					{
					setState(839);
					match(DOTS235);
					}
					break;
				case DOTS236:
					{
					setState(840);
					match(DOTS236);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case CGROUP:
				{
				setState(844); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(843);
						match(CGROUP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(846); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case DOT6:
			case DOTS45:
			case DOTS456:
			case DOTS356:
				{
				{
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) {
					{
					setState(848);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOT6) | (1L << DOTS45) | (1L << DOTS456))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(851);
				match(DOTS356);
				}
				}
				break;
			case DOT5:
			case DOT3:
				{
				setState(855);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT5:
					{
					setState(852);
					match(DOT5);
					setState(853);
					match(DOTS2356);
					}
					break;
				case DOT3:
					{
					setState(854);
					match(DOT3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class OopsContext extends ParserRuleContext {
		public TerminalNode MISC() { return getToken(uebMathParser.MISC, 0); }
		public OopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).enterOops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uebMathParserListener ) ((uebMathParserListener)listener).exitOops(this);
		}
	}

	public final OopsContext oops() throws RecognitionException {
		OopsContext _localctx = new OopsContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_oops);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			match(MISC);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return digits_sempred((DigitsContext)_localctx, predIndex);
		case 11:
			return flc_sempred((FlcContext)_localctx, predIndex);
		case 12:
			return ilc_sempred((IlcContext)_localctx, predIndex);
		case 13:
			return strong_gs_sempred((Strong_gsContext)_localctx, predIndex);
		case 14:
			return largeSign_sempred((LargeSignContext)_localctx, predIndex);
		case 41:
			return expr2_sempred((Expr2Context)_localctx, predIndex);
		case 42:
			return oGroup_sempred((OGroupContext)_localctx, predIndex);
		case 43:
			return cGroup_sempred((CGroupContext)_localctx, predIndex);
		case 44:
			return g1MathRoots_sempred((G1MathRootsContext)_localctx, predIndex);
		case 48:
			return mLsub_sempred((MLsubContext)_localctx, predIndex);
		case 50:
			return brlogrp_sempred((BrlogrpContext)_localctx, predIndex);
		case 51:
			return brlcgrp_sempred((BrlcgrpContext)_localctx, predIndex);
		case 52:
			return supExpr_sempred((SupExprContext)_localctx, predIndex);
		case 54:
			return subExpr_sempred((SubExprContext)_localctx, predIndex);
		case 66:
			return justALetter_sempred((JustALetterContext)_localctx, predIndex);
		case 67:
			return singleLetter_sempred((SingleLetterContext)_localctx, predIndex);
		case 70:
			return standAloneCon_sempred((StandAloneConContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean digits_sempred(DigitsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return numPassage;
		}
		return true;
	}
	private boolean flc_sempred(FlcContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return !g1WrdOrPassage;
		}
		return true;
	}
	private boolean ilc_sempred(IlcContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return !g1WrdOrPassage;
		}
		return true;
	}
	private boolean strong_gs_sempred(Strong_gsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return !g1WrdOrPassage;
		}
		return true;
	}
	private boolean largeSign_sempred(LargeSignContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return !g1WrdOrPassage;
		}
		return true;
	}
	private boolean expr2_sempred(Expr2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 19);
		case 6:
			return precpred(_ctx, 18);
		}
		return true;
	}
	private boolean oGroup_sempred(OGroupContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean cGroup_sempred(CGroupContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean g1MathRoots_sempred(G1MathRootsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean mLsub_sempred(MLsubContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean brlogrp_sempred(BrlogrpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean brlcgrp_sempred(BrlcgrpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean supExpr_sempred(SupExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 4);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean subExpr_sempred(SubExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean justALetter_sempred(JustALetterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return g1WrdOrPassage;
		}
		return true;
	}
	private boolean singleLetter_sempred(SingleLetterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return !g1WrdOrPassage;
		}
		return true;
	}
	private boolean standAloneCon_sempred(StandAloneConContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return !g1WrdOrPassage;
		case 20:
			return !g1WrdOrPassage;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0098\u0360\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\6\2\u009e\n\2\r\2\16\2\u009f\3\3"+
		"\3\3\7\3\u00a4\n\3\f\3\16\3\u00a7\13\3\3\3\3\3\3\3\7\3\u00ac\n\3\f\3\16"+
		"\3\u00af\13\3\3\3\3\3\3\3\3\3\5\3\u00b5\n\3\5\3\u00b7\n\3\3\4\3\4\6\4"+
		"\u00bb\n\4\r\4\16\4\u00bc\3\4\3\4\3\4\6\4\u00c2\n\4\r\4\16\4\u00c3\3\4"+
		"\7\4\u00c7\n\4\f\4\16\4\u00ca\13\4\3\4\3\4\3\4\3\4\5\4\u00d0\n\4\5\4\u00d2"+
		"\n\4\3\5\6\5\u00d5\n\5\r\5\16\5\u00d6\3\5\7\5\u00da\n\5\f\5\16\5\u00dd"+
		"\13\5\3\5\3\5\3\5\3\5\5\5\u00e3\n\5\3\5\7\5\u00e6\n\5\f\5\16\5\u00e9\13"+
		"\5\3\5\3\5\7\5\u00ed\n\5\f\5\16\5\u00f0\13\5\3\5\3\5\3\5\7\5\u00f5\n\5"+
		"\f\5\16\5\u00f8\13\5\5\5\u00fa\n\5\3\6\7\6\u00fd\n\6\f\6\16\6\u0100\13"+
		"\6\3\6\3\6\3\7\3\7\7\7\u0106\n\7\f\7\16\7\u0109\13\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\6\7\u0115\n\7\r\7\16\7\u0116\3\7\3\7\3\7\5\7\u011c"+
		"\n\7\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u0124\n\t\r\t\16\t\u0125\3\n\3\n\3\13"+
		"\7\13\u012b\n\13\f\13\16\13\u012e\13\13\3\13\3\13\7\13\u0132\n\13\f\13"+
		"\16\13\u0135\13\13\3\f\7\f\u0138\n\f\f\f\16\f\u013b\13\f\3\f\5\f\u013e"+
		"\n\f\3\f\3\f\3\f\7\f\u0143\n\f\f\f\16\f\u0146\13\f\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\5\24\u0160\n\24\3\25\6\25\u0163\n\25\r\25"+
		"\16\25\u0164\3\26\3\26\3\27\3\27\3\30\3\30\5\30\u016d\n\30\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\7\33\u0176\n\33\f\33\16\33\u0179\13\33\3\33\3"+
		"\33\6\33\u017d\n\33\r\33\16\33\u017e\3\34\3\34\3\34\6\34\u0184\n\34\r"+
		"\34\16\34\u0185\5\34\u0188\n\34\3\34\3\34\3\34\6\34\u018d\n\34\r\34\16"+
		"\34\u018e\5\34\u0191\n\34\3\34\3\34\3\34\5\34\u0196\n\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01a5\n\35\3\36"+
		"\6\36\u01a8\n\36\r\36\16\36\u01a9\3\37\3\37\3\37\5\37\u01af\n\37\3 \3"+
		" \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\5$\u01bd\n$\3$\3$\3$\3$\3$\5$\u01c4"+
		"\n$\3$\5$\u01c7\n$\3$\3$\5$\u01cb\n$\3%\3%\3&\3&\7&\u01d1\n&\f&\16&\u01d4"+
		"\13&\3&\3&\3&\3&\5&\u01da\n&\3\'\5\'\u01dd\n\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01ec\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\5(\u01fc\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u020a"+
		"\n)\3)\5)\u020d\n)\3*\5*\u0210\n*\3*\3*\7*\u0214\n*\f*\16*\u0217\13*\3"+
		"+\3+\3+\3+\5+\u021d\n+\3+\3+\3+\5+\u0222\n+\3+\3+\3+\5+\u0227\n+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0233\n+\3+\3+\3+\3+\3+\3+\3+\5+\u023c\n"+
		"+\3+\3+\3+\3+\3+\3+\7+\u0244\n+\f+\16+\u0247\13+\3,\3,\3,\3-\3-\3-\3."+
		"\3.\3.\3/\3/\3\60\5\60\u0255\n\60\3\60\3\60\3\60\3\60\5\60\u025b\n\60"+
		"\3\61\3\61\3\62\3\62\3\62\5\62\u0262\n\62\3\63\3\63\3\64\3\64\3\64\5\64"+
		"\u0269\n\64\3\65\3\65\3\65\5\65\u026e\n\65\3\66\3\66\3\66\5\66\u0273\n"+
		"\66\3\66\3\66\3\66\6\66\u0278\n\66\r\66\16\66\u0279\3\66\3\66\3\66\6\66"+
		"\u027f\n\66\r\66\16\66\u0280\3\66\3\66\5\66\u0285\n\66\5\66\u0287\n\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u028f\n\66\f\66\16\66\u0292\13\66"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\58\u029e\n8\38\38\38\68\u02a3"+
		"\n8\r8\168\u02a4\38\38\38\68\u02aa\n8\r8\168\u02ab\38\38\58\u02b0\n8\5"+
		"8\u02b2\n8\38\38\38\38\38\38\78\u02ba\n8\f8\168\u02bd\138\39\39\39\69"+
		"\u02c2\n9\r9\169\u02c3\39\39\39\69\u02c9\n9\r9\169\u02ca\39\39\3:\3:\3"+
		":\3;\3;\3<\3<\3<\3<\5<\u02d8\n<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3"+
		"@\3A\3A\3A\5A\u02ea\nA\3B\3B\3B\3B\3C\3C\3D\3D\5D\u02f4\nD\3D\3D\3D\5"+
		"D\u02f9\nD\3D\5D\u02fc\nD\3E\3E\5E\u0300\nE\3E\3E\3E\5E\u0305\nE\3F\3"+
		"F\3G\5G\u030a\nG\3G\3G\6G\u030e\nG\rG\16G\u030f\3H\3H\5H\u0314\nH\3H\3"+
		"H\3H\3H\3H\5H\u031b\nH\3I\6I\u031e\nI\rI\16I\u031f\3J\5J\u0323\nJ\3J\3"+
		"J\3J\3J\5J\u0329\nJ\5J\u032b\nJ\3J\3J\3K\3K\5K\u0331\nK\3K\3K\3K\3K\5"+
		"K\u0337\nK\3K\5K\u033a\nK\3L\3L\3L\3M\3M\3M\3M\3M\3M\7M\u0345\nM\fM\16"+
		"M\u0348\13M\3M\3M\5M\u034c\nM\3M\6M\u034f\nM\rM\16M\u0350\3M\5M\u0354"+
		"\nM\3M\3M\3M\3M\5M\u035a\nM\5M\u035c\nM\3N\3N\3N\2\5TjnO\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\2\25\3\2\f\r\3\2\b\t\3\2\21\22\3\2\16\20\3\2"+
		"=A\4\2ii\u0085\u0085\5\2hhuu\u0084\u0084\3\2%&\4\2((\60\60\5\2\34\34?"+
		"?^^\4\2AA``\4\2\35\35\u008b\u008b\3\2|\u0080\4\2DD\u0083\u0083\4\2WW\u0087"+
		"\u0087\4\2EO\u0096\u0098\3\2QU\4\2+,//\4\2**./\2\u03e4\2\u009d\3\2\2\2"+
		"\4\u00b6\3\2\2\2\6\u00d1\3\2\2\2\b\u00f9\3\2\2\2\n\u00fe\3\2\2\2\f\u011b"+
		"\3\2\2\2\16\u011d\3\2\2\2\20\u0123\3\2\2\2\22\u0127\3\2\2\2\24\u012c\3"+
		"\2\2\2\26\u0139\3\2\2\2\30\u0147\3\2\2\2\32\u014a\3\2\2\2\34\u014d\3\2"+
		"\2\2\36\u0150\3\2\2\2 \u0153\3\2\2\2\"\u0155\3\2\2\2$\u0158\3\2\2\2&\u015f"+
		"\3\2\2\2(\u0162\3\2\2\2*\u0166\3\2\2\2,\u0168\3\2\2\2.\u016c\3\2\2\2\60"+
		"\u016e\3\2\2\2\62\u0170\3\2\2\2\64\u0173\3\2\2\2\66\u0195\3\2\2\28\u01a4"+
		"\3\2\2\2:\u01a7\3\2\2\2<\u01ae\3\2\2\2>\u01b0\3\2\2\2@\u01b4\3\2\2\2B"+
		"\u01b7\3\2\2\2D\u01b9\3\2\2\2F\u01bc\3\2\2\2H\u01cc\3\2\2\2J\u01ce\3\2"+
		"\2\2L\u01dc\3\2\2\2N\u01fb\3\2\2\2P\u0209\3\2\2\2R\u020f\3\2\2\2T\u023b"+
		"\3\2\2\2V\u0248\3\2\2\2X\u024b\3\2\2\2Z\u024e\3\2\2\2\\\u0251\3\2\2\2"+
		"^\u025a\3\2\2\2`\u025c\3\2\2\2b\u0261\3\2\2\2d\u0263\3\2\2\2f\u0268\3"+
		"\2\2\2h\u026d\3\2\2\2j\u0286\3\2\2\2l\u0293\3\2\2\2n\u02b1\3\2\2\2p\u02be"+
		"\3\2\2\2r\u02ce\3\2\2\2t\u02d1\3\2\2\2v\u02d7\3\2\2\2x\u02db\3\2\2\2z"+
		"\u02de\3\2\2\2|\u02e1\3\2\2\2~\u02e4\3\2\2\2\u0080\u02e9\3\2\2\2\u0082"+
		"\u02eb\3\2\2\2\u0084\u02ef\3\2\2\2\u0086\u02fb\3\2\2\2\u0088\u02fd\3\2"+
		"\2\2\u008a\u0306\3\2\2\2\u008c\u0309\3\2\2\2\u008e\u0311\3\2\2\2\u0090"+
		"\u031d\3\2\2\2\u0092\u032a\3\2\2\2\u0094\u0339\3\2\2\2\u0096\u033b\3\2"+
		"\2\2\u0098\u035b\3\2\2\2\u009a\u035d\3\2\2\2\u009c\u009e\5\f\7\2\u009d"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\3\3\2\2\2\u00a1\u00a4\5\"\22\2\u00a2\u00a4\5$\23\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00b7\5\24"+
		"\13\2\u00a9\u00ac\5&\24\2\u00aa\u00ac\5v<\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b4\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b5\5F$\2\u00b1\u00b5"+
		"\5J&\2\u00b2\u00b5\5\26\f\2\u00b3\u00b5\58\35\2\u00b4\u00b0\3\2\2\2\u00b4"+
		"\u00b1\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b7\3\2"+
		"\2\2\u00b6\u00a5\3\2\2\2\u00b6\u00ad\3\2\2\2\u00b7\5\3\2\2\2\u00b8\u00bb"+
		"\5\"\22\2\u00b9\u00bb\5$\23\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\u00bf\5\24\13\2\u00bf\u00d2\3\2\2\2\u00c0\u00c2\5&\24\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c7\5v<\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cf\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00d0\5F$\2\u00cc\u00d0\5J&\2\u00cd\u00d0"+
		"\5\26\f\2\u00ce\u00d0\58\35\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2"+
		"\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00ba"+
		"\3\2\2\2\u00d1\u00c1\3\2\2\2\u00d2\7\3\2\2\2\u00d3\u00d5\5&\24\2\u00d4"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\5v<\2\u00d9\u00d8\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e2\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e3\5F$\2\u00df\u00e3\5J&\2\u00e0\u00e3\5\26\f"+
		"\2\u00e1\u00e3\58\35\2\u00e2\u00de\3\2\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e7\3\2\2\2\u00e4\u00e6\5(\25\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00fa\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\5\"\22\2\u00eb"+
		"\u00ed\5$\23\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2"+
		"\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f6\5\24\13\2\u00f2\u00f5\5\"\22\2\u00f3\u00f5"+
		"\5$\23\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2"+
		"\2\2\u00f9\u00d4\3\2\2\2\u00f9\u00ee\3\2\2\2\u00fa\t\3\2\2\2\u00fb\u00fd"+
		"\5\"\22\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2"+
		"\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102"+
		"\5 \21\2\u0102\13\3\2\2\2\u0103\u0106\5\"\22\2\u0104\u0106\5$\23\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u011c\5 \21\2\u010b\u010c\5\4\3\2\u010c\u010d\5\n\6\2\u010d\u011c\3\2"+
		"\2\2\u010e\u010f\5\4\3\2\u010f\u0110\5\b\5\2\u0110\u0111\5\n\6\2\u0111"+
		"\u011c\3\2\2\2\u0112\u0114\5\4\3\2\u0113\u0115\5\6\4\2\u0114\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0119\5\b\5\2\u0119\u011a\5\n\6\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0107\3\2\2\2\u011b\u010b\3\2\2\2\u011b\u010e\3\2\2\2\u011b"+
		"\u0112\3\2\2\2\u011c\r\3\2\2\2\u011d\u011e\7\23\2\2\u011e\17\3\2\2\2\u011f"+
		"\u0124\7\4\2\2\u0120\u0124\7\177\2\2\u0121\u0122\6\t\2\2\u0122\u0124\7"+
		"n\2\2\u0123\u011f\3\2\2\2\u0123\u0120\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\21\3\2\2"+
		"\2\u0127\u0128\t\2\2\2\u0128\23\3\2\2\2\u0129\u012b\5\u0090I\2\u012a\u0129"+
		"\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0133\5\22\n\2\u0130\u0132\5"+
		"\u0096L\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2"+
		"\u0133\u0134\3\2\2\2\u0134\25\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0138"+
		"\5\u0094K\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2"+
		"\2\u0139\u013a\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013e"+
		"\t\3\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\5\u008eH\2\u0140\u0144\3\2\2\2\u0141\u0143\5\u0098M\2\u0142\u0141"+
		"\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\27\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\6\r\3\2\u0148\u0149\t\4\2"+
		"\2\u0149\31\3\2\2\2\u014a\u014b\6\16\4\2\u014b\u014c\t\5\2\2\u014c\33"+
		"\3\2\2\2\u014d\u014e\6\17\5\2\u014e\u014f\7\24\2\2\u014f\35\3\2\2\2\u0150"+
		"\u0151\6\20\6\2\u0151\u0152\t\6\2\2\u0152\37\3\2\2\2\u0153\u0154\t\7\2"+
		"\2\u0154!\3\2\2\2\u0155\u0156\t\b\2\2\u0156\u0157\b\22\1\2\u0157#\3\2"+
		"\2\2\u0158\u0159\7g\2\2\u0159%\3\2\2\2\u015a\u0160\5\"\22\2\u015b\u0160"+
		"\5~@\2\u015c\u0160\5\u0080A\2\u015d\u0160\5\u0082B\2\u015e\u0160\5$\23"+
		"\2\u015f\u015a\3\2\2\2\u015f\u015b\3\2\2\2\u015f\u015c\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u015f\u015e\3\2\2\2\u0160\'\3\2\2\2\u0161\u0163\5&\24\2\u0162"+
		"\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2"+
		"\2\2\u0165)\3\2\2\2\u0166\u0167\7\3\2\2\u0167+\3\2\2\2\u0168\u0169\5*"+
		"\26\2\u0169-\3\2\2\2\u016a\u016d\5x=\2\u016b\u016d\5|?\2\u016c\u016a\3"+
		"\2\2\2\u016c\u016b\3\2\2\2\u016d/\3\2\2\2\u016e\u016f\7\27\2\2\u016f\61"+
		"\3\2\2\2\u0170\u0171\7\4\2\2\u0171\u0172\b\32\1\2\u0172\63\3\2\2\2\u0173"+
		"\u0177\5\62\32\2\u0174\u0176\5\20\t\2\u0175\u0174\3\2\2\2\u0176\u0179"+
		"\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u017a\3\2\2\2\u0179"+
		"\u0177\3\2\2\2\u017a\u017c\7\u0080\2\2\u017b\u017d\5\20\t\2\u017c\u017b"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\65\3\2\2\2\u0180\u0187\5\\/\2\u0181\u0188\5\64\33\2\u0182\u0184\5T+\2"+
		"\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186"+
		"\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0181\3\2\2\2\u0187\u0183\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u0190\5`\61\2\u018a\u0191\5\64\33\2\u018b\u018d\5"+
		"T+\2\u018c\u018b\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018a\3\2\2\2\u0190\u018c\3\2"+
		"\2\2\u0191\u0192\3\2\2\2\u0192\u0193\5^\60\2\u0193\u0196\3\2\2\2\u0194"+
		"\u0196\5\64\33\2\u0195\u0180\3\2\2\2\u0195\u0194\3\2\2\2\u0196\67\3\2"+
		"\2\2\u0197\u01a5\5z>\2\u0198\u01a5\5|?\2\u0199\u01a5\5\20\t\2\u019a\u01a5"+
		"\5,\27\2\u019b\u01a5\5\66\34\2\u019c\u01a5\5p9\2\u019d\u01a5\5> \2\u019e"+
		"\u01a5\5T+\2\u019f\u01a5\5j\66\2\u01a0\u01a5\5n8\2\u01a1\u01a5\5l\67\2"+
		"\u01a2\u01a5\7m\2\2\u01a3\u01a5\5R*\2\u01a4\u0197\3\2\2\2\u01a4\u0198"+
		"\3\2\2\2\u01a4\u0199\3\2\2\2\u01a4\u019a\3\2\2\2\u01a4\u019b\3\2\2\2\u01a4"+
		"\u019c\3\2\2\2\u01a4\u019d\3\2\2\2\u01a4\u019e\3\2\2\2\u01a4\u019f\3\2"+
		"\2\2\u01a4\u01a0\3\2\2\2\u01a4\u01a1\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4"+
		"\u01a3\3\2\2\2\u01a59\3\2\2\2\u01a6\u01a8\t\t\2\2\u01a7\u01a6\3\2\2\2"+
		"\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa;\3"+
		"\2\2\2\u01ab\u01af\7#\2\2\u01ac\u01af\7$\2\2\u01ad\u01af\5:\36\2\u01ae"+
		"\u01ab\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01ad\3\2\2\2\u01af=\3\2\2\2"+
		"\u01b0\u01b1\5T+\2\u01b1\u01b2\5<\37\2\u01b2\u01b3\5T+\2\u01b3?\3\2\2"+
		"\2\u01b4\u01b5\7\n\2\2\u01b5\u01b6\7P\2\2\u01b6A\3\2\2\2\u01b7\u01b8\7"+
		"P\2\2\u01b8C\3\2\2\2\u01b9\u01ba\t\n\2\2\u01baE\3\2\2\2\u01bb\u01bd\7"+
		"+\2\2\u01bc\u01bb\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01c3\3\2\2\2\u01be"+
		"\u01c4\5\32\16\2\u01bf\u01c4\5\36\20\2\u01c0\u01c4\5@!\2\u01c1\u01c4\5"+
		"B\"\2\u01c2\u01c4\7\f\2\2\u01c3\u01be\3\2\2\2\u01c3\u01bf\3\2\2\2\u01c3"+
		"\u01c0\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c6\3\2"+
		"\2\2\u01c5\u01c7\7\25\2\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01ca\3\2\2\2\u01c8\u01cb\5D#\2\u01c9\u01cb\5\u0098M\2\u01ca\u01c8\3"+
		"\2\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cbG\3\2\2\2\u01cc\u01cd"+
		"\7\64\2\2\u01cdI\3\2\2\2\u01ce\u01d2\5L\'\2\u01cf\u01d1\5N(\2\u01d0\u01cf"+
		"\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3"+
		"\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\5P)\2\u01d6\u01d9\3\2\2"+
		"\2\u01d7\u01da\5D#\2\u01d8\u01da\5\u0098M\2\u01d9\u01d7\3\2\2\2\u01d9"+
		"\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01daK\3\2\2\2\u01db\u01dd\7+\2\2\u01dc"+
		"\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01eb\3\2\2\2\u01de\u01ec\5@"+
		"!\2\u01df\u01ec\5B\"\2\u01e0\u01ec\5\u0084C\2\u01e1\u01ec\5\u0088E\2\u01e2"+
		"\u01ec\7l\2\2\u01e3\u01ec\5\16\b\2\u01e4\u01ec\7:\2\2\u01e5\u01ec\7S\2"+
		"\2\u01e6\u01ec\7<\2\2\u01e7\u01ec\5\32\16\2\u01e8\u01ec\5\36\20\2\u01e9"+
		"\u01ec\5\34\17\2\u01ea\u01ec\5\22\n\2\u01eb\u01de\3\2\2\2\u01eb\u01df"+
		"\3\2\2\2\u01eb\u01e0\3\2\2\2\u01eb\u01e1\3\2\2\2\u01eb\u01e2\3\2\2\2\u01eb"+
		"\u01e3\3\2\2\2\u01eb\u01e4\3\2\2\2\u01eb\u01e5\3\2\2\2\u01eb\u01e6\3\2"+
		"\2\2\u01eb\u01e7\3\2\2\2\u01eb\u01e8\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01ecM\3\2\2\2\u01ed\u01fc\5B\"\2\u01ee\u01fc\5\u0084C"+
		"\2\u01ef\u01fc\5\u0088E\2\u01f0\u01fc\5H%\2\u01f1\u01fc\7l\2\2\u01f2\u01fc"+
		"\5\16\b\2\u01f3\u01fc\7:\2\2\u01f4\u01fc\7S\2\2\u01f5\u01fc\7<\2\2\u01f6"+
		"\u01fc\5\30\r\2\u01f7\u01fc\5\32\16\2\u01f8\u01fc\5\36\20\2\u01f9\u01fc"+
		"\5\34\17\2\u01fa\u01fc\5\22\n\2\u01fb\u01ed\3\2\2\2\u01fb\u01ee\3\2\2"+
		"\2\u01fb\u01ef\3\2\2\2\u01fb\u01f0\3\2\2\2\u01fb\u01f1\3\2\2\2\u01fb\u01f2"+
		"\3\2\2\2\u01fb\u01f3\3\2\2\2\u01fb\u01f4\3\2\2\2\u01fb\u01f5\3\2\2\2\u01fb"+
		"\u01f6\3\2\2\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fb\u01fa\3\2\2\2\u01fcO\3\2\2\2\u01fd\u020a\5B\"\2\u01fe\u020a"+
		"\5\u0084C\2\u01ff\u020a\5\u0088E\2\u0200\u020a\7l\2\2\u0201\u020a\5\16"+
		"\b\2\u0202\u020a\7:\2\2\u0203\u020a\7S\2\2\u0204\u020a\7<\2\2\u0205\u020a"+
		"\5\30\r\2\u0206\u020a\5\32\16\2\u0207\u020a\5\36\20\2\u0208\u020a\5\34"+
		"\17\2\u0209\u01fd\3\2\2\2\u0209\u01fe\3\2\2\2\u0209\u01ff\3\2\2\2\u0209"+
		"\u0200\3\2\2\2\u0209\u0201\3\2\2\2\u0209\u0202\3\2\2\2\u0209\u0203\3\2"+
		"\2\2\u0209\u0204\3\2\2\2\u0209\u0205\3\2\2\2\u0209\u0206\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020a\u020c\3\2\2\2\u020b\u020d\7\25"+
		"\2\2\u020c\u020b\3\2\2\2\u020c\u020d\3\2\2\2\u020dQ\3\2\2\2\u020e\u0210"+
		"\7+\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211"+
		"\u0215\5\30\r\2\u0212\u0214\5P)\2\u0213\u0212\3\2\2\2\u0214\u0217\3\2"+
		"\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216S\3\2\2\2\u0217\u0215"+
		"\3\2\2\2\u0218\u0219\b+\1\2\u0219\u023c\5\20\t\2\u021a\u021c\5D#\2\u021b"+
		"\u021d\5\"\22\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u023c\3"+
		"\2\2\2\u021e\u023c\5:\36\2\u021f\u0222\5V,\2\u0220\u0222\7\32\2\2\u0221"+
		"\u021f\3\2\2\2\u0221\u0220\3\2\2\2\u0222\u0223\3\2\2\2\u0223\u0226\5T"+
		"+\2\u0224\u0227\5X-\2\u0225\u0227\7\33\2\2\u0226\u0224\3\2\2\2\u0226\u0225"+
		"\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u023c\3\2\2\2\u0228\u023c\5\u0086D"+
		"\2\u0229\u023c\5\u0088E\2\u022a\u023c\5J&\2\u022b\u023c\7\'\2\2\u022c"+
		"\u023c\5Z.\2\u022d\u023c\5V,\2\u022e\u023c\7\32\2\2\u022f\u023c\5X-\2"+
		"\u0230\u023c\7\33\2\2\u0231\u0233\7-\2\2\u0232\u0231\3\2\2\2\u0232\u0233"+
		"\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u023c\7:\2\2\u0235\u0236\5f\64\2\u0236"+
		"\u0237\5T+\2\u0237\u0238\5h\65\2\u0238\u023c\3\2\2\2\u0239\u023c\5f\64"+
		"\2\u023a\u023c\5h\65\2\u023b\u0218\3\2\2\2\u023b\u021a\3\2\2\2\u023b\u021e"+
		"\3\2\2\2\u023b\u0221\3\2\2\2\u023b\u0228\3\2\2\2\u023b\u0229\3\2\2\2\u023b"+
		"\u022a\3\2\2\2\u023b\u022b\3\2\2\2\u023b\u022c\3\2\2\2\u023b\u022d\3\2"+
		"\2\2\u023b\u022e\3\2\2\2\u023b\u022f\3\2\2\2\u023b\u0230\3\2\2\2\u023b"+
		"\u0232\3\2\2\2\u023b\u0235\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023a\3\2"+
		"\2\2\u023c\u0245\3\2\2\2\u023d\u023e\f\25\2\2\u023e\u023f\5\60\31\2\u023f"+
		"\u0240\5T+\26\u0240\u0244\3\2\2\2\u0241\u0242\f\24\2\2\u0242\u0244\5T"+
		"+\2\u0243\u023d\3\2\2\2\u0243\u0241\3\2\2\2\u0244\u0247\3\2\2\2\u0245"+
		"\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246U\3\2\2\2\u0247\u0245\3\2\2\2"+
		"\u0248\u0249\6,\t\2\u0249\u024a\7\32\2\2\u024aW\3\2\2\2\u024b\u024c\6"+
		"-\n\2\u024c\u024d\7\33\2\2\u024dY\3\2\2\2\u024e\u024f\6.\13\2\u024f\u0250"+
		"\7\64\2\2\u0250[\3\2\2\2\u0251\u0252\t\13\2\2\u0252]\3\2\2\2\u0253\u0255"+
		"\7\u0082\2\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255\u0256\3\2\2"+
		"\2\u0256\u025b\t\f\2\2\u0257\u025b\7\36\2\2\u0258\u025b\7\u008a\2\2\u0259"+
		"\u025b\7\u0081\2\2\u025a\u0254\3\2\2\2\u025a\u0257\3\2\2\2\u025a\u0258"+
		"\3\2\2\2\u025a\u0259\3\2\2\2\u025b_\3\2\2\2\u025c\u025d\t\r\2\2\u025d"+
		"a\3\2\2\2\u025e\u0262\7\37\2\2\u025f\u0260\6\62\f\2\u0260\u0262\79\2\2"+
		"\u0261\u025e\3\2\2\2\u0261\u025f\3\2\2\2\u0262c\3\2\2\2\u0263\u0264\7"+
		" \2\2\u0264e\3\2\2\2\u0265\u0269\7!\2\2\u0266\u0267\6\64\r\2\u0267\u0269"+
		"\7X\2\2\u0268\u0265\3\2\2\2\u0268\u0266\3\2\2\2\u0269g\3\2\2\2\u026a\u026e"+
		"\7\"\2\2\u026b\u026c\6\65\16\2\u026c\u026e\7Y\2\2\u026d\u026a\3\2\2\2"+
		"\u026d\u026b\3\2\2\2\u026ei\3\2\2\2\u026f\u0270\b\66\1\2\u0270\u0287\5"+
		"T+\2\u0271\u0273\5f\64\2\u0272\u0271\3\2\2\2\u0272\u0273\3\2\2\2\u0273"+
		"\u0274\3\2\2\2\u0274\u0277\5\\/\2\u0275\u0278\5T+\2\u0276\u0278\5j\66"+
		"\2\u0277\u0275\3\2\2\2\u0277\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0277"+
		"\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027e\5`\61\2\u027c"+
		"\u027f\5T+\2\u027d\u027f\5j\66\2\u027e\u027c\3\2\2\2\u027e\u027d\3\2\2"+
		"\2\u027f\u0280\3\2\2\2\u0280\u027e\3\2\2\2\u0280\u0281\3\2\2\2\u0281\u0282"+
		"\3\2\2\2\u0282\u0284\5^\60\2\u0283\u0285\5h\65\2\u0284\u0283\3\2\2\2\u0284"+
		"\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286\u026f\3\2\2\2\u0286\u0272\3\2"+
		"\2\2\u0287\u0290\3\2\2\2\u0288\u0289\f\6\2\2\u0289\u028a\5d\63\2\u028a"+
		"\u028b\5j\66\7\u028b\u028f\3\2\2\2\u028c\u028d\f\4\2\2\u028d\u028f\5j"+
		"\66\5\u028e\u0288\3\2\2\2\u028e\u028c\3\2\2\2\u028f\u0292\3\2\2\2\u0290"+
		"\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291k\3\2\2\2\u0292\u0290\3\2\2\2"+
		"\u0293\u0294\5n8\2\u0294\u0295\5d\63\2\u0295\u0296\5T+\2\u0296\u0297\5"+
		"l\67\2\u0297\u0298\5d\63\2\u0298\u0299\5T+\2\u0299m\3\2\2\2\u029a\u029b"+
		"\b8\1\2\u029b\u02b2\5T+\2\u029c\u029e\5f\64\2\u029d\u029c\3\2\2\2\u029d"+
		"\u029e\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u02a2\5\\/\2\u02a0\u02a3\5T+"+
		"\2\u02a1\u02a3\5n8\2\u02a2\u02a0\3\2\2\2\u02a2\u02a1\3\2\2\2\u02a3\u02a4"+
		"\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6"+
		"\u02a9\5`\61\2\u02a7\u02aa\5T+\2\u02a8\u02aa\5n8\2\u02a9\u02a7\3\2\2\2"+
		"\u02a9\u02a8\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac"+
		"\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02af\5^\60\2\u02ae\u02b0\5h\65\2\u02af"+
		"\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b2\3\2\2\2\u02b1\u029a\3\2"+
		"\2\2\u02b1\u029d\3\2\2\2\u02b2\u02bb\3\2\2\2\u02b3\u02b4\f\6\2\2\u02b4"+
		"\u02b5\5b\62\2\u02b5\u02b6\5n8\7\u02b6\u02ba\3\2\2\2\u02b7\u02b8\f\4\2"+
		"\2\u02b8\u02ba\5n8\5\u02b9\u02b3\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bd"+
		"\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bco\3\2\2\2\u02bd"+
		"\u02bb\3\2\2\2\u02be\u02c1\5\\/\2\u02bf\u02c2\5T+\2\u02c0\u02c2\5\66\34"+
		"\2\u02c1\u02bf\3\2\2\2\u02c1\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c1"+
		"\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\5`\61\2\u02c6"+
		"\u02c9\5T+\2\u02c7\u02c9\5\66\34\2\u02c8\u02c6\3\2\2\2\u02c8\u02c7\3\2"+
		"\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"\u02cc\3\2\2\2\u02cc\u02cd\5^\60\2\u02cdq\3\2\2\2\u02ce\u02cf\7\4\2\2"+
		"\u02cf\u02d0\5t;\2\u02d0s\3\2\2\2\u02d1\u02d2\t\16\2\2\u02d2u\3\2\2\2"+
		"\u02d3\u02d4\7\6\2\2\u02d4\u02d8\b<\1\2\u02d5\u02d6\7\7\2\2\u02d6\u02d8"+
		"\b<\1\2\u02d7\u02d3\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9"+
		"\u02da\b<\1\2\u02daw\3\2\2\2\u02db\u02dc\t\17\2\2\u02dc\u02dd\b=\1\2\u02dd"+
		"y\3\2\2\2\u02de\u02df\7\5\2\2\u02df\u02e0\b>\1\2\u02e0{\3\2\2\2\u02e1"+
		"\u02e2\7k\2\2\u02e2\u02e3\b?\1\2\u02e3}\3\2\2\2\u02e4\u02e5\t\20\2\2\u02e5"+
		"\177\3\2\2\2\u02e6\u02e7\7+\2\2\u02e7\u02ea\7W\2\2\u02e8\u02ea\7\u0086"+
		"\2\2\u02e9\u02e6\3\2\2\2\u02e9\u02e8\3\2\2\2\u02ea\u0081\3\2\2\2\u02eb"+
		"\u02ec\7*\2\2\u02ec\u02ed\7+\2\2\u02ed\u02ee\7W\2\2\u02ee\u0083\3\2\2"+
		"\2\u02ef\u02f0\t\21\2\2\u02f0\u0085\3\2\2\2\u02f1\u02f3\6D\23\2\u02f2"+
		"\u02f4\7+\2\2\u02f3\u02f2\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f5\3\2"+
		"\2\2\u02f5\u02fc\t\22\2\2\u02f6\u02f8\7-\2\2\u02f7\u02f9\7+\2\2\u02f8"+
		"\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fc\t\22"+
		"\2\2\u02fb\u02f1\3\2\2\2\u02fb\u02f6\3\2\2\2\u02fc\u0087\3\2\2\2\u02fd"+
		"\u0304\6E\24\2\u02fe\u0300\7+\2\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2"+
		"\2\2\u0300\u0301\3\2\2\2\u0301\u0305\t\22\2\2\u0302\u0305\5\u008aF\2\u0303"+
		"\u0305\7\13\2\2\u0304\u02ff\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0303\3"+
		"\2\2\2\u0305\u0089\3\2\2\2\u0306\u0307\7\n\2\2\u0307\u008b\3\2\2\2\u0308"+
		"\u030a\7+\2\2\u0309\u0308\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030b\3\2"+
		"\2\2\u030b\u030d\t\22\2\2\u030c\u030e\t\22\2\2\u030d\u030c\3\2\2\2\u030e"+
		"\u030f\3\2\2\2\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u008d\3\2"+
		"\2\2\u0311\u0313\6H\25\2\u0312\u0314\7+\2\2\u0313\u0312\3\2\2\2\u0313"+
		"\u0314\3\2\2\2\u0314\u031a\3\2\2\2\u0315\u031b\5\16\b\2\u0316\u031b\5"+
		"\u008cG\2\u0317\u031b\5\u0084C\2\u0318\u0319\6H\26\2\u0319\u031b\5\u0088"+
		"E\2\u031a\u0315\3\2\2\2\u031a\u0316\3\2\2\2\u031a\u0317\3\2\2\2\u031a"+
		"\u0318\3\2\2\2\u031b\u008f\3\2\2\2\u031c\u031e\7\32\2\2\u031d\u031c\3"+
		"\2\2\2\u031e\u031f\3\2\2\2\u031f\u031d\3\2\2\2\u031f\u0320\3\2\2\2\u0320"+
		"\u0091\3\2\2\2\u0321\u0323\t\23\2\2\u0322\u0321\3\2\2\2\u0322\u0323\3"+
		"\2\2\2\u0323\u0324\3\2\2\2\u0324\u032b\7\66\2\2\u0325\u0326\7*\2\2\u0326"+
		"\u0329\7\65\2\2\u0327\u0329\7[\2\2\u0328\u0325\3\2\2\2\u0328\u0327\3\2"+
		"\2\2\u0329\u032b\3\2\2\2\u032a\u0322\3\2\2\2\u032a\u0328\3\2\2\2\u032a"+
		"\u032b\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032d\5\u0090I\2\u032d\u0093"+
		"\3\2\2\2\u032e\u033a\5\u0090I\2\u032f\u0331\t\23\2\2\u0330\u032f\3\2\2"+
		"\2\u0330\u0331\3\2\2\2\u0331\u0332\3\2\2\2\u0332\u033a\7\66\2\2\u0333"+
		"\u0334\7*\2\2\u0334\u0337\7\65\2\2\u0335\u0337\7[\2\2\u0336\u0333\3\2"+
		"\2\2\u0336\u0335\3\2\2\2\u0337\u033a\3\2\2\2\u0338\u033a\7\b\2\2\u0339"+
		"\u032e\3\2\2\2\u0339\u0330\3\2\2\2\u0339\u0336\3\2\2\2\u0339\u0338\3\2"+
		"\2\2\u033a\u0095\3\2\2\2\u033b\u033c\t\24\2\2\u033c\u033d\7Y\2\2\u033d"+
		"\u0097\3\2\2\2\u033e\u034c\5D#\2\u033f\u034c\7\61\2\2\u0340\u034c\7\62"+
		"\2\2\u0341\u0346\7\63\2\2\u0342\u0343\7\63\2\2\u0343\u0345\7\63\2\2\u0344"+
		"\u0342\3\2\2\2\u0345\u0348\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2"+
		"\2\2\u0347\u034c\3\2\2\2\u0348\u0346\3\2\2\2\u0349\u034c\7\64\2\2\u034a"+
		"\u034c\7\66\2\2\u034b\u033e\3\2\2\2\u034b\u033f\3\2\2\2\u034b\u0340\3"+
		"\2\2\2\u034b\u0341\3\2\2\2\u034b\u0349\3\2\2\2\u034b\u034a\3\2\2\2\u034c"+
		"\u035c\3\2\2\2\u034d\u034f\7\33\2\2\u034e\u034d\3\2\2\2\u034f\u0350\3"+
		"\2\2\2\u0350\u034e\3\2\2\2\u0350\u0351\3\2\2\2\u0351\u035c\3\2\2\2\u0352"+
		"\u0354\t\23\2\2\u0353\u0352\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0355\3"+
		"\2\2\2\u0355\u035c\7\67\2\2\u0356\u0357\7*\2\2\u0357\u035a\7\65\2\2\u0358"+
		"\u035a\7[\2\2\u0359\u0356\3\2\2\2\u0359\u0358\3\2\2\2\u035a\u035c\3\2"+
		"\2\2\u035b\u034b\3\2\2\2\u035b\u034e\3\2\2\2\u035b\u0353\3\2\2\2\u035b"+
		"\u0359\3\2\2\2\u035c\u0099\3\2\2\2\u035d\u035e\7j\2\2\u035e\u009b\3\2"+
		"\2\2x\u009f\u00a3\u00a5\u00ab\u00ad\u00b4\u00b6\u00ba\u00bc\u00c3\u00c8"+
		"\u00cf\u00d1\u00d6\u00db\u00e2\u00e7\u00ec\u00ee\u00f4\u00f6\u00f9\u00fe"+
		"\u0105\u0107\u0116\u011b\u0123\u0125\u012c\u0133\u0139\u013d\u0144\u015f"+
		"\u0164\u016c\u0177\u017e\u0185\u0187\u018e\u0190\u0195\u01a4\u01a9\u01ae"+
		"\u01bc\u01c3\u01c6\u01ca\u01d2\u01d9\u01dc\u01eb\u01fb\u0209\u020c\u020f"+
		"\u0215\u021c\u0221\u0226\u0232\u023b\u0243\u0245\u0254\u025a\u0261\u0268"+
		"\u026d\u0272\u0277\u0279\u027e\u0280\u0284\u0286\u028e\u0290\u029d\u02a2"+
		"\u02a4\u02a9\u02ab\u02af\u02b1\u02b9\u02bb\u02c1\u02c3\u02c8\u02ca\u02d7"+
		"\u02e9\u02f3\u02f8\u02fb\u02ff\u0304\u0309\u030f\u0313\u031a\u031f\u0322"+
		"\u0328\u032a\u0330\u0336\u0339\u0346\u034b\u0350\u0353\u0359\u035b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}