// Generated from uebMathLexer.g4 by ANTLR 4.9.2
package org.dotlessbraille.antlr4;
import org.dotlessbraille.transtables.WordOrPartWord;
 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class uebMathLexer extends Lexer {
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
		END_SPECG1_with_G1TERM=143, ANOTHER_SPACE=144, CAP_ZED=145;
	public static final int
		COMMENTS=2;
	public static final int
		NUMERIC_PASSAGE=1, NUMERIC=2, SPECIAL_G1=3, ANOTHER=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "COMMENTS"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "NUMERIC_PASSAGE", "NUMERIC", "SPECIAL_G1", "ANOTHER"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"STARTING_MODE", "START_NUMERIC_MODE", "START_NUMERIC_PASSAGE", "G1PassageInd", 
			"G1WordInd", "CapsPassageInd", "CapsWordInd", "CapitalLetter", "MODIF", 
			"LOWWORD", "SPLOW", "LOWCON", "ILC5", "ILC45", "ILC456", "FLC46", "FLC56", 
			"STRONG_WS", "STRONG_GS", "END_LETTER", "END_PAIR", "APOS_END", "APOS_UC_END", 
			"BINOP", "MLSQRTO", "MLSQRTC", "OGROUP", "CGROUP", "GFRACO", "GFRACC", 
			"MLFRACS", "MLFRACIL", "MLFRACE", "SUBSCRIPT", "MLSUB", "SUPERSCRIPT", 
			"MLSUP", "MLROWS", "MLROWE", "SPECIALSYM", "CompareSigns", "PossibleAngleBracket", 
			"SPACED_SYMBOLS", "COMP_SYMBOLS", "LEFTangleOrLT", "RIGHTangleOrGT", 
			"PR_TOKEN", "COMMA_ROOT", "HASH", "ATSIGN", "DOT4", "NDQUO", "DOT5", 
			"CAPS_IND", "DOT6", "CARET", "DOTS45", "SEMICOLON", "DOTS56", "ABPERIOD", 
			"DOTS46", "USCORE", "DOTS456", "COL2_PREFIX", "NOCAPorG1_PREFIX", "PREFIX", 
			"LOW_ONE", "DOT2", "LOW_TWO", "DOTS23", "LOW_THREE", "DOTS25", "FULL_STOP", 
			"DOTS256", "LOW_SIX", "DOTS235", "LOW_SEVEN", "DOTS2356", "LOW_EIGHT", 
			"DOTS236", "LOW_ZERO", "DOTS356", "LOW_FIVE", "DOTS26", "LOW_NINE", "DOTS35", 
			"ANY_LOW", "ROOT", "PERIOD_ROOT", "SLASH_ROOT", "AND_ROOT", "FOR_ROOT", 
			"OF_ROOT", "THE_ROOT", "WITH_ROOT", "CapsTermInd", "G1SymInd", "G1TermInd", 
			"SFB", "CHSF", "SHSF", "SFCC", "STSF", "OURSELVES", "THSF", "ERSF", "ONESELF", 
			"THMSLVS", "CONCV", "LETA", "LETB", "UPD", "LETK", "MOST", "ALPHA_SEQ", 
			"LETTERA", "LETTERB", "UPDIGS", "LETTERK", "MOST_LETTERS", "FRAC_LINEorST", 
			"DOTS34", "HYPorMINUS", "DOTS36", "LESSTHAN", "DOTS126", "GREATERTHAN", 
			"DOTS345", "PLUS_SIGN", "DOTS346", "APOS", "DOT3", "PCENT", "DOTS146", 
			"COLON", "DOTS156", "AMPER", "EQSIGN", "OPAREN", "EXCLAM", "CPAREN", 
			"OBRAK", "CBRAK", "DOLLAR", "ASTER", "QMARK", "BSLASH", "AND", "FOR", 
			"OForFRACS", "THE", "WITHorFRCE", "DOTS16", "DOTS1456", "DOTS1256", "DOTS12456", 
			"DOTS246", "DOTS1246", "ASPACE", "INDENT", "SPACE", "WINNL", "NEWLINE", 
			"MISC", "EXIT_NUMERIC_PASSAGE", "LETTERS_NOT_DIGITS", "LETTER_NOT_DIGIT", 
			"DIGITS", "NP_NEWLINE", "NUMERIC_LABEL", "SIMPLE_FRACTION_LINE", "MFRACS", 
			"MFRACIL", "MFRACE", "NPSPACE", "NPNEWLINE", "COMMENT", "NP_PR_TOKEN_1", 
			"NP_ROOT", "NP_MISC", "NUM_SIMPLE_FRAC_LINEx", "NUM_CONT_NUM_SPACE", 
			"NUM_CONT", "NUM_SPACE_DIGIT", "NDIG_SEQ", "NUM_SIMPLE_FRAC_LINE", "END_NM_with_FRACE", 
			"END_NM_with_G1", "END_NM_with_G1TERM", "END_NM_with_SPACE", "END_NM_with_WINNL", 
			"END_NM_with_DASH", "END_NM_with_HYPHEN", "END_NM_with_ALPHA", "END_NM_with_K2Z", 
			"NM_FRACE", "NMFRACIL", "PR_TOKEN_1", "PR_TOKEN_2", "PR_TOKEN_3", "ROOT_1", 
			"NUM_MISC", "END_SPECG1_with_G1TERM", "ANOTHER_SPACE", "CAP_ZED"
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
			"NUM_MISC", "END_SPECG1_with_G1TERM", "ANOTHER_SPACE", "CAP_ZED"
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

	 

	   public static boolean inSpecialG1Mode = false;
	   public static boolean inRegularG1Mode = false;
	   public static boolean isSFA( String seq ){
	    String tmp = seq.toLowerCase();
	    if (tmp.equals( "brl" )) return true;
	    if (tmp.equals( "grt" )) return true;
	    return false;
	   }
	   public static boolean isSFC( String seq ){
	    if (seq.length()!= 2) return false;
	    String tmp = seq.toLowerCase();
	      //UEB Rule 10.9.3
	    if (tmp.equals( "bl" )) return true;
	    if (tmp.equals( "fr" )) return true;
	    if (tmp.equals( "gd" )) return true;
	    if (tmp.equals( "lt" )) return true;
	    if (tmp.equals( "ll" )) return true;
	    if (tmp.equals( "qk" )) return true;
	    //check for:  bl, fr, gd, lt, ll, qk
	    return false;
	   }
	   public static boolean isShortform( String seq ){
	     //{System.out.println( "SEQ: "+seq );
	     WordOrPartWord.makePartWordTable( true, true);
	     return WordOrPartWord.isShortform( seq );
	     }
	   public  boolean alone(){
	    int i = getCharIndex();
	    // System.out.println( "i: "+i); or just check +1?
	    if (i < 1 ) return false;
	    String chk =
	     _input.getText(new Interval( getCharIndex()-1, 
	                                  getCharIndex()+1) );
	     boolean b = (chk.startsWith(" ") && chk.endsWith(" "));
	     return b;} 

	public boolean okDenom(){
	     String chk1 =
	     _input.getText(new Interval( getCharIndex()-1, 
	                                  getCharIndex()) );
	   //if (!chk1.startsWith("/")) return false;
	   //return false;  //x
	   return true;
	 } 
	  public boolean okDenom1(){
	    String chk1 =
	     _input.getText(new Interval( getCharIndex()-1, 
	                                  getCharIndex()) );
	   System.out.println( "okDenom--chk1: |"+chk1+"|" );
	   String ok = "abcdefghijABCDEFGHIJ14";
	   if (!chk1.startsWith("/")) return true;
	   int pos = ok.indexOf( chk1.substring( 1,2 ));
	    System.out.println( "okDenom--pos: |"+pos+"|" );
	   return false;  //Std
	   //return true;
	 }
	   public boolean okDenomx(){
	    String ok = "abcdefghijABCDEFGHIJ14";
	    String chk1 =
	     _input.getText(new Interval( getCharIndex()-1, 
	                                  getCharIndex()) );
	    //String chk1 = _input.getText(getCharIndex()+1);
	    System.out.println( "okDenom--chk1: |"+chk1+"|" );
	    if (!chk1.startsWith("/")) return true;
	    int pos = ok.indexOf( chk1.substring( 1,2 ));
	    System.out.println( "okDenom--pos: |"+pos+"|" );
	    System.out.println( "okDenom--chk1ss: "+chk1.substring( 1,2 ));
	    boolean b = false;
	    if (pos > -1) b = true;
	    System.out.println( "okDenom start b: "+b);
	     //Numeric character  
	     
	    if (b) return b;

	     System.out.println( "okDenom num space check." );
	     //Numeric space
	    // b = chk1.startsWith( "\"" );
	     b = chk1.substring( 1,2 ).equals("\"");
	     if (b) return b;
	System.out.println( "okDenom returning false." );
	     return false;
	    /**System.out.println( "okDenom starting check 2." );
	    String chk2 =
	     _input.getText(new Interval( getCharIndex()-1, 
	                                  getCharIndex()+1) );
	    System.out.println( "okDenom--chk2: |"+chk2+"|" );
	    
	    int pos2 = ok.indexOf( chk2.substring( 0,1 ));
	    System.out.println( "okDenom--pos2: |"+pos2+"|" );
	    b = false;
	    if (pos2 > -1) b = true;
	    System.out.println( "okDenom last check returns: "+b);
	    return b;}
	*/
	 }

	public uebMathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "uebMathLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 42:
			SPACED_SYMBOLS_action((RuleContext)_localctx, actionIndex);
			break;
		case 114:
			ALPHA_SEQ_action((RuleContext)_localctx, actionIndex);
			break;
		case 179:
			NP_MISC_action((RuleContext)_localctx, actionIndex);
			break;
		case 188:
			END_NM_with_G1TERM_action((RuleContext)_localctx, actionIndex);
			break;
		case 189:
			END_NM_with_SPACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 190:
			END_NM_with_WINNL_action((RuleContext)_localctx, actionIndex);
			break;
		case 191:
			END_NM_with_DASH_action((RuleContext)_localctx, actionIndex);
			break;
		case 192:
			END_NM_with_HYPHEN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void SPACED_SYMBOLS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println( "LA(1)= "+_input.LA(1));
			break;
		}
	}
	private void ALPHA_SEQ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 if (isSFA( getText() )){
			             setType( uebMathParser.SFA ); 
			            } else if (isSFC( getText() )){
			               setType( uebMathParser.SFC );
			            } else if (isShortform( getText() )){
			               setType( uebMathParser.SHORTFORM );
			            } 
			           
			break;
		}
	}
	private void NP_MISC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			System.out.println( "Bad input");
			                                 System.exit( 0 ); 
			break;
		}
	}
	private void END_NM_with_G1TERM_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			inSpecialG1Mode = false;
			break;
		}
	}
	private void END_NM_with_SPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			inSpecialG1Mode = false;
			break;
		}
	}
	private void END_NM_with_WINNL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			inSpecialG1Mode = false;
			break;
		}
	}
	private void END_NM_with_DASH_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			inSpecialG1Mode = false;
			break;
		}
	}
	private void END_NM_with_HYPHEN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			inSpecialG1Mode = false;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return SPLOW_sempred((RuleContext)_localctx, predIndex);
		case 180:
			return NUM_SIMPLE_FRAC_LINEx_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean SPLOW_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return alone();
		}
		return true;
	}
	private boolean NUM_SIMPLE_FRAC_LINEx_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return !okDenom();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u0093\u04fb\b\1\b"+
		"\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t"+
		"\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t"+
		"(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t"+
		"\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t"+
		":\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4"+
		"F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\t"+
		"Q\4R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\"+
		"\4]\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h"+
		"\th\4i\ti\4j\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts"+
		"\4t\tt\4u\tu\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177"+
		"\t\177\4\u0080\t\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083"+
		"\4\u0084\t\u0084\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088"+
		"\t\u0088\4\u0089\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c"+
		"\4\u008d\t\u008d\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091"+
		"\t\u0091\4\u0092\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095"+
		"\4\u0096\t\u0096\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a"+
		"\t\u009a\4\u009b\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e"+
		"\4\u009f\t\u009f\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3"+
		"\t\u00a3\4\u00a4\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7"+
		"\4\u00a8\t\u00a8\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac"+
		"\t\u00ac\4\u00ad\t\u00ad\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0"+
		"\4\u00b1\t\u00b1\4\u00b2\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5"+
		"\t\u00b5\4\u00b6\t\u00b6\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9"+
		"\4\u00ba\t\u00ba\4\u00bb\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be"+
		"\t\u00be\4\u00bf\t\u00bf\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2"+
		"\4\u00c3\t\u00c3\4\u00c4\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7"+
		"\t\u00c7\4\u00c8\t\u00c8\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb"+
		"\4\u00cc\t\u00cc\4\u00cd\t\u00cd\4\u00ce\t\u00ce\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u01b0\n\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\6\4\u01ba\n\4\r\4\16\4\u01bb\3\4\5\4\u01bf\n\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\5"+
		"\n\u01d5\n\n\3\n\3\n\3\n\5\n\u01da\n\n\3\n\3\n\3\n\5\n\u01df\n\n\3\n\3"+
		"\n\3\n\3\n\5\n\u01e5\n\n\3\n\3\n\3\13\5\13\u01ea\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u01f2\n\13\3\f\3\f\5\f\u01f6\n\f\3\f\3\f\3\f\3\f\5"+
		"\f\u01fc\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0207\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u020f\n\17\3\20\3\20\3\20\5\20\u0214"+
		"\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\5\23\u021d\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u0225\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u022d"+
		"\n\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u023d\n\26\3\27\3\27\3\27\5\27\u0242\n\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u024b\n\30\3\31\3\31\3\31\3\31\3\31\5\31\u0252"+
		"\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u025d\n\34\3\34"+
		"\3\34\3\35\3\35\3\35\5\35\u0264\n\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\5)\u0287\n)\3*\3*\3*\3+\3+\3+\3+\3+\3+\5+\u0292\n+\3,"+
		"\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u029f\n,\3,\3,\3-\3-\3.\3.\3.\3/\3/"+
		"\3/\3\60\6\60\u02ac\n\60\r\60\16\60\u02ad\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\5\60\u02b8\n\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3"+
		"?\3?\3@\3@\3A\3A\3A\3A\3A\3A\3A\5A\u02e1\nA\3B\3B\3B\3B\3B\3B\5B\u02e9"+
		"\nB\3C\3C\5C\u02ed\nC\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K"+
		"\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W"+
		"\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\5X\u0321\nX\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y"+
		"\3Y\3Y\3Y\3Y\3Y\3Y\3Y\5Y\u0332\nY\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3"+
		"_\3`\3`\3a\3a\3a\3b\3b\3c\3c\3c\3d\3d\3d\3e\3e\3e\3f\3f\3f\3g\3g\3g\3"+
		"h\3h\3h\3h\5h\u035a\nh\3h\3h\3h\5h\u035f\nh\3i\3i\3i\3i\3i\3i\3i\5i\u0368"+
		"\ni\3j\3j\3j\3j\5j\u036e\nj\3j\3j\3j\3j\3j\3j\5j\u0376\nj\5j\u0378\nj"+
		"\3k\3k\3k\3k\3k\3k\3k\5k\u0381\nk\3k\3k\3k\3k\5k\u0387\nk\3l\3l\3l\3l"+
		"\3l\5l\u038e\nl\3m\3m\3m\3m\3m\3m\3m\5m\u0397\nm\3n\3n\3n\3n\5n\u039d"+
		"\nn\3o\3o\3p\3p\3q\5q\u03a4\nq\3r\3r\3s\3s\3t\3t\3t\3t\3t\3t\5t\u03b0"+
		"\nt\3t\3t\3t\3t\3t\6t\u03b7\nt\rt\16t\u03b8\3t\3t\3u\3u\3v\3v\3w\5w\u03c2"+
		"\nw\3x\3x\3y\3y\5y\u03c8\ny\3z\3z\3{\3{\3|\3|\3}\3}\3~\3~\3\177\3\177"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0083\3\u0083\3\u0084"+
		"\3\u0084\3\u0085\3\u0085\3\u0086\3\u0086\3\u0087\3\u0087\3\u0088\3\u0088"+
		"\3\u0089\3\u0089\3\u008a\3\u008a\3\u008b\3\u008b\3\u008c\3\u008c\3\u008d"+
		"\3\u008d\3\u008e\3\u008e\3\u008f\3\u008f\3\u0090\3\u0090\3\u0091\3\u0091"+
		"\3\u0092\3\u0092\3\u0093\3\u0093\3\u0094\3\u0094\3\u0095\3\u0095\3\u0096"+
		"\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098\3\u0099\3\u0099\3\u009a\3\u009a"+
		"\3\u009b\3\u009b\3\u009c\3\u009c\3\u009d\3\u009d\3\u009e\3\u009e\3\u009f"+
		"\3\u009f\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\6\u00a1\u041b\n\u00a1"+
		"\r\u00a1\16\u00a1\u041c\3\u00a2\3\u00a2\3\u00a3\6\u00a3\u0422\n\u00a3"+
		"\r\u00a3\16\u00a3\u0423\3\u00a4\3\u00a4\3\u00a5\3\u00a5\3\u00a6\3\u00a6"+
		"\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a7"+
		"\6\u00a7\u0435\n\u00a7\r\u00a7\16\u00a7\u0436\3\u00a8\3\u00a8\3\u00a8"+
		"\3\u00a9\6\u00a9\u043d\n\u00a9\r\u00a9\16\u00a9\u043e\3\u00aa\3\u00aa"+
		"\3\u00ab\3\u00ab\6\u00ab\u0445\n\u00ab\r\u00ab\16\u00ab\u0446\3\u00ab"+
		"\5\u00ab\u044a\n\u00ab\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ae\3\u00ae"+
		"\3\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2"+
		"\3\u00b2\3\u00b2\7\u00b2\u045d\n\u00b2\f\u00b2\16\u00b2\u0460\13\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b3\6\u00b3\u0468\n\u00b3"+
		"\r\u00b3\16\u00b3\u0469\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u046f\n\u00b3"+
		"\3\u00b3\3\u00b3\3\u00b4\3\u00b4\5\u00b4\u0475\n\u00b4\3\u00b4\3\u00b4"+
		"\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6"+
		"\3\u00b6\3\u00b7\3\u00b7\3\u00b7\3\u00b7\3\u00b8\3\u00b8\3\u00b8\3\u00b9"+
		"\3\u00b9\3\u00b9\3\u00ba\6\u00ba\u048e\n\u00ba\r\u00ba\16\u00ba\u048f"+
		"\3\u00bb\3\u00bb\3\u00bc\3\u00bc\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00bd"+
		"\3\u00bd\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00be\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00bf\3\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c0\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c3\3\u00c3\6\u00c3\u04b9\n\u00c3\r\u00c3\16\u00c3\u04ba"+
		"\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5"+
		"\3\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c6\3\u00c7\6\u00c7\u04cd"+
		"\n\u00c7\r\u00c7\16\u00c7\u04ce\3\u00c7\3\u00c7\3\u00c7\3\u00c7\5\u00c7"+
		"\u04d5\n\u00c7\3\u00c7\3\u00c7\3\u00c8\3\u00c8\5\u00c8\u04db\n\u00c8\3"+
		"\u00c8\3\u00c8\3\u00c9\3\u00c9\6\u00c9\u04e1\n\u00c9\r\u00c9\16\u00c9"+
		"\u04e2\3\u00c9\3\u00c9\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00ca\3\u00ca"+
		"\3\u00cb\3\u00cb\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cc\3\u00cc\3\u00cc"+
		"\3\u00cd\3\u00cd\3\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u045e\2\u00cf\7\3\t"+
		"\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\2\33\f\35\r\37\16!\17#\20%\21"+
		"\'\22)\23+\24-\2/\2\61\25\63\26\65\27\67\309\31;\32=\33?\2A\2C\34E\35"+
		"G\36I\2K\37M\2O Q!S\"U\2W\2Y\2[#]$_%a&c\'e(g\2i\2k)m\2o*q\2s+u\2w,y\2"+
		"{-}\2\177.\u0081\2\u0083/\u0085\2\u0087\2\u0089\2\u008b\2\u008d\60\u008f"+
		"\2\u0091\61\u0093\2\u0095\62\u0097\2\u0099\63\u009b\2\u009d\64\u009f\2"+
		"\u00a1\65\u00a3\2\u00a5\66\u00a7\2\u00a9\67\u00ab\2\u00ad8\u00af\2\u00b1"+
		"9\u00b3\2\u00b5:\u00b7;\u00b9<\u00bb=\u00bd>\u00bf?\u00c1@\u00c3A\u00c5"+
		"B\u00c7C\u00c9D\u00cbE\u00cdF\u00cfG\u00d1H\u00d3I\u00d5J\u00d7K\u00d9"+
		"L\u00dbM\u00ddN\u00dfO\u00e1\2\u00e3\2\u00e5\2\u00e7\2\u00e9\2\u00ebP"+
		"\u00edQ\u00efR\u00f1S\u00f3T\u00f5U\u00f7\2\u00f9V\u00fb\2\u00fdW\u00ff"+
		"\2\u0101X\u0103\2\u0105Y\u0107\2\u0109Z\u010b\2\u010d[\u010f\2\u0111\\"+
		"\u0113\2\u0115]\u0117\2\u0119\2\u011b\2\u011d\2\u011f\2\u0121\2\u0123"+
		"\2\u0125\2\u0127\2\u0129\2\u012b\2\u012d\2\u012f\2\u0131^\u0133_\u0135"+
		"`\u0137a\u0139b\u013bc\u013dd\u013fe\u0141f\u0143\2\u0145g\u0147h\u0149"+
		"\2\u014bi\u014dj\u014fk\u0151l\u0153m\u0155n\u0157o\u0159p\u015bq\u015d"+
		"r\u015fs\u0161t\u0163u\u0165v\u0167w\u0169x\u016by\u016dz\u016f{\u0171"+
		"|\u0173}\u0175~\u0177\177\u0179\u0080\u017b\u0081\u017d\u0082\u017f\u0083"+
		"\u0181\u0084\u0183\u0085\u0185\u0086\u0187\u0087\u0189\u0088\u018b\u0089"+
		"\u018d\u008a\u018f\u008b\u0191\u008c\u0193\u008d\u0195\u008e\u0197\u008f"+
		"\u0199\u0090\u019b\u0091\u019d\u0092\u019f\u0093\7\2\3\4\5\6\34\6\2\63"+
		"\63\66\66CLcl\4\2C\\c|\5\2,-//\65\65\7\2&(,-\61\61\65\65__\4\2//\63\64"+
		"\b\2FHfhjjmwyy{{\6\2WWYYwwyy\f\2EEJJOOUUYYeejjoouuyy\n\2FGPPUV[[fgppu"+
		"v{{\16\2GGIINNPPUV[[ggiinnppuv{{\6\2FFUVffuv\4\2PPpp\6\2OOUUoouu\4\2F"+
		"Fff\4\2HHhh\4\2OOoo\4\2CCcc\4\2DDdd\4\2ELel\4\2MMmm\4\2N\\n|\4\2\f\f\17"+
		"\17\4\2CLcl\6\2\63\63\66\66C\\c|\4\2M\\m|\5\2\63\63\66\66cl\2\u0545\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2K\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a"+
		"\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2s\3\2\2\2\2w\3\2"+
		"\2\2\2{\3\2\2\2\2\177\3\2\2\2\2\u0083\3\2\2\2\2\u008d\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0099\3\2\2\2\2\u009d\3\2\2\2\2\u00a1\3\2\2"+
		"\2\2\u00a5\3\2\2\2\2\u00a9\3\2\2\2\2\u00ad\3\2\2\2\2\u00b1\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2"+
		"\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7"+
		"\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2"+
		"\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9"+
		"\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00eb\3\2\2"+
		"\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5"+
		"\3\2\2\2\2\u00f9\3\2\2\2\2\u00fd\3\2\2\2\2\u0101\3\2\2\2\2\u0105\3\2\2"+
		"\2\2\u0109\3\2\2\2\2\u010d\3\2\2\2\2\u0111\3\2\2\2\2\u0115\3\2\2\2\2\u0131"+
		"\3\2\2\2\2\u0133\3\2\2\2\2\u0135\3\2\2\2\2\u0137\3\2\2\2\2\u0139\3\2\2"+
		"\2\2\u013b\3\2\2\2\2\u013d\3\2\2\2\2\u013f\3\2\2\2\2\u0141\3\2\2\2\2\u0145"+
		"\3\2\2\2\2\u0147\3\2\2\2\2\u014b\3\2\2\2\2\u014d\3\2\2\2\3\u014f\3\2\2"+
		"\2\3\u0151\3\2\2\2\3\u0153\3\2\2\2\3\u0155\3\2\2\2\3\u0157\3\2\2\2\3\u0159"+
		"\3\2\2\2\3\u015b\3\2\2\2\3\u015d\3\2\2\2\3\u015f\3\2\2\2\3\u0161\3\2\2"+
		"\2\3\u0163\3\2\2\2\3\u0165\3\2\2\2\3\u0167\3\2\2\2\3\u0169\3\2\2\2\3\u016b"+
		"\3\2\2\2\3\u016d\3\2\2\2\4\u016f\3\2\2\2\4\u0171\3\2\2\2\4\u0173\3\2\2"+
		"\2\4\u0175\3\2\2\2\4\u0177\3\2\2\2\4\u0179\3\2\2\2\4\u017b\3\2\2\2\4\u017d"+
		"\3\2\2\2\4\u017f\3\2\2\2\4\u0181\3\2\2\2\4\u0183\3\2\2\2\4\u0185\3\2\2"+
		"\2\4\u0187\3\2\2\2\4\u0189\3\2\2\2\4\u018b\3\2\2\2\4\u018d\3\2\2\2\4\u018f"+
		"\3\2\2\2\4\u0191\3\2\2\2\4\u0193\3\2\2\2\4\u0195\3\2\2\2\4\u0197\3\2\2"+
		"\2\4\u0199\3\2\2\2\5\u019b\3\2\2\2\6\u019d\3\2\2\2\6\u019f\3\2\2\2\7\u01af"+
		"\3\2\2\2\t\u01b1\3\2\2\2\13\u01b6\3\2\2\2\r\u01c2\3\2\2\2\17\u01c6\3\2"+
		"\2\2\21\u01c9\3\2\2\2\23\u01cd\3\2\2\2\25\u01d0\3\2\2\2\27\u01e4\3\2\2"+
		"\2\31\u01e9\3\2\2\2\33\u01f3\3\2\2\2\35\u01fd\3\2\2\2\37\u01ff\3\2\2\2"+
		"!\u0208\3\2\2\2#\u0210\3\2\2\2%\u0215\3\2\2\2\'\u0218\3\2\2\2)\u021c\3"+
		"\2\2\2+\u022c\3\2\2\2-\u022e\3\2\2\2/\u023c\3\2\2\2\61\u023e\3\2\2\2\63"+
		"\u0243\3\2\2\2\65\u024c\3\2\2\2\67\u0253\3\2\2\29\u0256\3\2\2\2;\u025c"+
		"\3\2\2\2=\u0263\3\2\2\2?\u0267\3\2\2\2A\u026a\3\2\2\2C\u026d\3\2\2\2E"+
		"\u026f\3\2\2\2G\u0272\3\2\2\2I\u0274\3\2\2\2K\u0277\3\2\2\2M\u0279\3\2"+
		"\2\2O\u027c\3\2\2\2Q\u027e\3\2\2\2S\u0281\3\2\2\2U\u0286\3\2\2\2W\u0288"+
		"\3\2\2\2Y\u0291\3\2\2\2[\u0293\3\2\2\2]\u02a2\3\2\2\2_\u02a4\3\2\2\2a"+
		"\u02a7\3\2\2\2c\u02ab\3\2\2\2e\u02b9\3\2\2\2g\u02bb\3\2\2\2i\u02bd\3\2"+
		"\2\2k\u02bf\3\2\2\2m\u02c1\3\2\2\2o\u02c3\3\2\2\2q\u02c5\3\2\2\2s\u02c7"+
		"\3\2\2\2u\u02c9\3\2\2\2w\u02cb\3\2\2\2y\u02cd\3\2\2\2{\u02cf\3\2\2\2}"+
		"\u02d1\3\2\2\2\177\u02d3\3\2\2\2\u0081\u02d5\3\2\2\2\u0083\u02d7\3\2\2"+
		"\2\u0085\u02e0\3\2\2\2\u0087\u02e8\3\2\2\2\u0089\u02ec\3\2\2\2\u008b\u02ee"+
		"\3\2\2\2\u008d\u02f0\3\2\2\2\u008f\u02f2\3\2\2\2\u0091\u02f4\3\2\2\2\u0093"+
		"\u02f6\3\2\2\2\u0095\u02f8\3\2\2\2\u0097\u02fa\3\2\2\2\u0099\u02fc\3\2"+
		"\2\2\u009b\u02fe\3\2\2\2\u009d\u0300\3\2\2\2\u009f\u0302\3\2\2\2\u00a1"+
		"\u0304\3\2\2\2\u00a3\u0306\3\2\2\2\u00a5\u0308\3\2\2\2\u00a7\u030a\3\2"+
		"\2\2\u00a9\u030c\3\2\2\2\u00ab\u030e\3\2\2\2\u00ad\u0310\3\2\2\2\u00af"+
		"\u0312\3\2\2\2\u00b1\u0314\3\2\2\2\u00b3\u0320\3\2\2\2\u00b5\u0331\3\2"+
		"\2\2\u00b7\u0333\3\2\2\2\u00b9\u0335\3\2\2\2\u00bb\u0337\3\2\2\2\u00bd"+
		"\u0339\3\2\2\2\u00bf\u033b\3\2\2\2\u00c1\u033d\3\2\2\2\u00c3\u033f\3\2"+
		"\2\2\u00c5\u0341\3\2\2\2\u00c7\u0344\3\2\2\2\u00c9\u0346\3\2\2\2\u00cb"+
		"\u0349\3\2\2\2\u00cd\u034c\3\2\2\2\u00cf\u034f\3\2\2\2\u00d1\u0352\3\2"+
		"\2\2\u00d3\u035e\3\2\2\2\u00d5\u0360\3\2\2\2\u00d7\u0377\3\2\2\2\u00d9"+
		"\u0386\3\2\2\2\u00db\u0388\3\2\2\2\u00dd\u038f\3\2\2\2\u00df\u0398\3\2"+
		"\2\2\u00e1\u039e\3\2\2\2\u00e3\u03a0\3\2\2\2\u00e5\u03a3\3\2\2\2\u00e7"+
		"\u03a5\3\2\2\2\u00e9\u03a7\3\2\2\2\u00eb\u03af\3\2\2\2\u00ed\u03bc\3\2"+
		"\2\2\u00ef\u03be\3\2\2\2\u00f1\u03c1\3\2\2\2\u00f3\u03c3\3\2\2\2\u00f5"+
		"\u03c7\3\2\2\2\u00f7\u03c9\3\2\2\2\u00f9\u03cb\3\2\2\2\u00fb\u03cd\3\2"+
		"\2\2\u00fd\u03cf\3\2\2\2\u00ff\u03d1\3\2\2\2\u0101\u03d3\3\2\2\2\u0103"+
		"\u03d5\3\2\2\2\u0105\u03d7\3\2\2\2\u0107\u03d9\3\2\2\2\u0109\u03db\3\2"+
		"\2\2\u010b\u03dd\3\2\2\2\u010d\u03df\3\2\2\2\u010f\u03e1\3\2\2\2\u0111"+
		"\u03e3\3\2\2\2\u0113\u03e5\3\2\2\2\u0115\u03e7\3\2\2\2\u0117\u03e9\3\2"+
		"\2\2\u0119\u03eb\3\2\2\2\u011b\u03ed\3\2\2\2\u011d\u03ef\3\2\2\2\u011f"+
		"\u03f1\3\2\2\2\u0121\u03f3\3\2\2\2\u0123\u03f5\3\2\2\2\u0125\u03f7\3\2"+
		"\2\2\u0127\u03f9\3\2\2\2\u0129\u03fb\3\2\2\2\u012b\u03fd\3\2\2\2\u012d"+
		"\u03ff\3\2\2\2\u012f\u0401\3\2\2\2\u0131\u0403\3\2\2\2\u0133\u0405\3\2"+
		"\2\2\u0135\u0407\3\2\2\2\u0137\u0409\3\2\2\2\u0139\u040b\3\2\2\2\u013b"+
		"\u040d\3\2\2\2\u013d\u040f\3\2\2\2\u013f\u0411\3\2\2\2\u0141\u0413\3\2"+
		"\2\2\u0143\u0415\3\2\2\2\u0145\u0417\3\2\2\2\u0147\u041e\3\2\2\2\u0149"+
		"\u0421\3\2\2\2\u014b\u0425\3\2\2\2\u014d\u0427\3\2\2\2\u014f\u0429\3\2"+
		"\2\2\u0151\u0430\3\2\2\2\u0153\u0438\3\2\2\2\u0155\u043c\3\2\2\2\u0157"+
		"\u0440\3\2\2\2\u0159\u0442\3\2\2\2\u015b\u044b\3\2\2\2\u015d\u044d\3\2"+
		"\2\2\u015f\u044f\3\2\2\2\u0161\u0452\3\2\2\2\u0163\u0454\3\2\2\2\u0165"+
		"\u0456\3\2\2\2\u0167\u0458\3\2\2\2\u0169\u0467\3\2\2\2\u016b\u0474\3\2"+
		"\2\2\u016d\u0478\3\2\2\2\u016f\u047d\3\2\2\2\u0171\u0482\3\2\2\2\u0173"+
		"\u0486\3\2\2\2\u0175\u0489\3\2\2\2\u0177\u048d\3\2\2\2\u0179\u0491\3\2"+
		"\2\2\u017b\u0493\3\2\2\2\u017d\u0497\3\2\2\2\u017f\u049b\3\2\2\2\u0181"+
		"\u04a1\3\2\2\2\u0183\u04a6\3\2\2\2\u0185\u04ab\3\2\2\2\u0187\u04b1\3\2"+
		"\2\2\u0189\u04b6\3\2\2\2\u018b\u04be\3\2\2\2\u018d\u04c2\3\2\2\2\u018f"+
		"\u04c6\3\2\2\2\u0191\u04cc\3\2\2\2\u0193\u04d8\3\2\2\2\u0195\u04de\3\2"+
		"\2\2\u0197\u04e8\3\2\2\2\u0199\u04ec\3\2\2\2\u019b\u04f0\3\2\2\2\u019d"+
		"\u04f5\3\2\2\2\u019f\u04f9\3\2\2\2\u01a1\u01a2\7f\2\2\u01a2\u01a3\7g\2"+
		"\2\u01a3\u01a4\7h\2\2\u01a4\u01a5\7c\2\2\u01a5\u01a6\7w\2\2\u01a6\u01a7"+
		"\7n\2\2\u01a7\u01a8\7v\2\2\u01a8\u01a9\7a\2\2\u01a9\u01aa\7o\2\2\u01aa"+
		"\u01ab\7q\2\2\u01ab\u01ac\7f\2\2\u01ac\u01b0\7g\2\2\u01ad\u01ae\7i\2\2"+
		"\u01ae\u01b0\7\64\2\2\u01af\u01a1\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\b"+
		"\3\2\2\2\u01b1\u01b2\5g\62\2\u01b2\u01b3\t\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b5\b\3\2\2\u01b5\n\3\2\2\2\u01b6\u01b7\5g\62\2\u01b7\u01b9\5g\62\2"+
		"\u01b8\u01ba\5\u0143\u00a0\2\u01b9\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bf\5\u014b"+
		"\u00a4\2\u01be\u01bd\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c1\b\4\3\2\u01c1\f\3\2\2\2\u01c2\u01c3\5{<\2\u01c3\u01c4\5{<\2\u01c4"+
		"\u01c5\5{<\2\u01c5\16\3\2\2\2\u01c6\u01c7\5{<\2\u01c7\u01c8\5{<\2\u01c8"+
		"\20\3\2\2\2\u01c9\u01ca\5s8\2\u01ca\u01cb\5s8\2\u01cb\u01cc\5s8\2\u01cc"+
		"\22\3\2\2\2\u01cd\u01ce\5s8\2\u01ce\u01cf\5s8\2\u01cf\24\3\2\2\2\u01d0"+
		"\u01d1\5s8\2\u01d1\u01d2\t\3\2\2\u01d2\26\3\2\2\2\u01d3\u01d5\5s8\2\u01d4"+
		"\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7B"+
		"\2\2\u01d7\u01e5\t\4\2\2\u01d8\u01da\5s8\2\u01d9\u01d8\3\2\2\2\u01d9\u01da"+
		"\3\2\2\2\u01da\u01db\3\2\2\2\u01db\u01dc\7`\2\2\u01dc\u01e5\t\5\2\2\u01dd"+
		"\u01df\5s8\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e0\3\2\2"+
		"\2\u01e0\u01e1\7`\2\2\u01e1\u01e2\7a\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5"+
		"\t\6\2\2\u01e4\u01d4\3\2\2\2\u01e4\u01d9\3\2\2\2\u01e4\u01de\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\u01e7\t\3\2\2\u01e7\30\3\2\2\2\u01e8\u01ea\5s8\2"+
		"\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01f1\3\2\2\2\u01eb\u01f2"+
		"\5\u008fF\2\u01ec\u01f2\5\u00abT\2\u01ed\u01f2\5\u009fN\2\u01ee\u01f2"+
		"\5\u00a3P\2\u01ef\u01f2\5\u00afV\2\u01f0\u01f2\5\u00a7R\2\u01f1\u01eb"+
		"\3\2\2\2\u01f1\u01ec\3\2\2\2\u01f1\u01ed\3\2\2\2\u01f1\u01ee\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2\32\3\2\2\2\u01f3\u01f5\6\f\2"+
		"\2\u01f4\u01f6\5s8\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01fb"+
		"\3\2\2\2\u01f7\u01fc\5\u008bD\2\u01f8\u01fc\5\u009fN\2\u01f9\u01fc\5\u00a3"+
		"P\2\u01fa\u01fc\5\u00a7R\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\34\3\2\2\2\u01fd\u01fe\5\31\13"+
		"\2\u01fe\36\3\2\2\2\u01ff\u0206\5m\65\2\u0200\u0207\t\7\2\2\u0201\u0207"+
		"\5\u0127\u0092\2\u0202\u0207\5\u0129\u0093\2\u0203\u0207\5\u0113\u0088"+
		"\2\u0204\u0207\5\u012b\u0094\2\u0205\u0207\5\u011d\u008d\2\u0206\u0200"+
		"\3\2\2\2\u0206\u0201\3\2\2\2\u0206\u0202\3\2\2\2\u0206\u0203\3\2\2\2\u0206"+
		"\u0204\3\2\2\2\u0206\u0205\3\2\2\2\u0207 \3\2\2\2\u0208\u020e\5u9\2\u0209"+
		"\u020f\t\b\2\2\u020a\u020f\5\u0127\u0092\2\u020b\u020f\5\u0129\u0093\2"+
		"\u020c\u020f\5\u0113\u0088\2\u020d\u020f\5\u011d\u008d\2\u020e\u0209\3"+
		"\2\2\2\u020e\u020a\3\2\2\2\u020e\u020b\3\2\2\2\u020e\u020c\3\2\2\2\u020e"+
		"\u020d\3\2\2\2\u020f\"\3\2\2\2\u0210\u0213\5\u0081?\2\u0211\u0214\t\t"+
		"\2\2\u0212\u0214\5\u011d\u008d\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2"+
		"\2\u0214$\3\2\2\2\u0215\u0216\5}=\2\u0216\u0217\t\n\2\2\u0217&\3\2\2\2"+
		"\u0218\u0219\5y;\2\u0219\u021a\t\13\2\2\u021a(\3\2\2\2\u021b\u021d\5s"+
		"8\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0224\3\2\2\2\u021e"+
		"\u0225\5\u0137\u009a\2\u021f\u0225\5\u0111\u0087\2\u0220\u0225\5\u0139"+
		"\u009b\2\u0221\u0225\5\u0115\u0089\2\u0222\u0225\5\u013b\u009c\2\u0223"+
		"\u0225\5\u00f9{\2\u0224\u021e\3\2\2\2\u0224\u021f\3\2\2\2\u0224\u0220"+
		"\3\2\2\2\u0224\u0221\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0223\3\2\2\2\u0225"+
		"*\3\2\2\2\u0226\u022d\5\u0141\u009f\2\u0227\u022d\5\u013d\u009d\2\u0228"+
		"\u022d\5\u013f\u009e\2\u0229\u022d\5\u0101\177\2\u022a\u022d\5\u0109\u0083"+
		"\2\u022b\u022d\5\u0105\u0081\2\u022c\u0226\3\2\2\2\u022c\u0227\3\2\2\2"+
		"\u022c\u0228\3\2\2\2\u022c\u0229\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022b"+
		"\3\2\2\2\u022d,\3\2\2\2\u022e\u022f\t\f\2\2\u022f.\3\2\2\2\u0230\u0231"+
		"\7n\2\2\u0231\u023d\7n\2\2\u0232\u0233\7N\2\2\u0233\u023d\7N\2\2\u0234"+
		"\u0235\7t\2\2\u0235\u023d\7g\2\2\u0236\u0237\7T\2\2\u0237\u023d\7G\2\2"+
		"\u0238\u0239\7x\2\2\u0239\u023d\7g\2\2\u023a\u023b\7X\2\2\u023b\u023d"+
		"\7G\2\2\u023c\u0230\3\2\2\2\u023c\u0232\3\2\2\2\u023c\u0234\3\2\2\2\u023c"+
		"\u0236\3\2\2\2\u023c\u0238\3\2\2\2\u023c\u023a\3\2\2\2\u023d\60\3\2\2"+
		"\2\u023e\u0241\5\u010d\u0085\2\u023f\u0242\5/\26\2\u0240\u0242\5-\25\2"+
		"\u0241\u023f\3\2\2\2\u0241\u0240\3\2\2\2\u0242\62\3\2\2\2\u0243\u024a"+
		"\5\u010d\u0085\2\u0244\u0245\5\23\b\2\u0245\u0246\5/\26\2\u0246\u024b"+
		"\3\2\2\2\u0247\u0248\5s8\2\u0248\u0249\5-\25\2\u0249\u024b\3\2\2\2\u024a"+
		"\u0244\3\2\2\2\u024a\u0247\3\2\2\2\u024b\64\3\2\2\2\u024c\u0251\5o\66"+
		"\2\u024d\u0252\5\u009dM\2\u024e\u0252\5\u00fd}\2\u024f\u0252\5\u00f9{"+
		"\2\u0250\u0252\5\u00a5Q\2\u0251\u024d\3\2\2\2\u0251\u024e\3\2\2\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0250\3\2\2\2\u0252\66\3\2\2\2\u0253\u0254\5{<\2"+
		"\u0254\u0255\5\u0111\u0087\2\u02558\3\2\2\2\u0256\u0257\5{<\2\u0257\u0258"+
		"\5\u0109\u0083\2\u0258:\3\2\2\2\u0259\u025d\5o\66\2\u025a\u025d\5\177"+
		">\2\u025b\u025d\5\u0083@\2\u025c\u0259\3\2\2\2\u025c\u025a\3\2\2\2\u025c"+
		"\u025b\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\5\u0101\177\2\u025f<\3"+
		"\2\2\2\u0260\u0264\5o\66\2\u0261\u0264\5\177>\2\u0262\u0264\5\u0083@\2"+
		"\u0263\u0260\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0262\3\2\2\2\u0264\u0265"+
		"\3\2\2\2\u0265\u0266\5\u0105\u0081\2\u0266>\3\2\2\2\u0267\u0268\5{<\2"+
		"\u0268\u0269\5\u011b\u008c\2\u0269@\3\2\2\2\u026a\u026b\5{<\2\u026b\u026c"+
		"\5\u011f\u008e\2\u026cB\3\2\2\2\u026d\u026e\5?\36\2\u026eD\3\2\2\2\u026f"+
		"\u0270\5\177>\2\u0270\u0271\5\u00f9{\2\u0271F\3\2\2\2\u0272\u0273\5A\37"+
		"\2\u0273H\3\2\2\2\u0274\u0275\5{<\2\u0275\u0276\5\u00adU\2\u0276J\3\2"+
		"\2\2\u0277\u0278\5I#\2\u0278L\3\2\2\2\u0279\u027a\5{<\2\u027a\u027b\5"+
		"\u00b1W\2\u027bN\3\2\2\2\u027c\u027d\5M%\2\u027dP\3\2\2\2\u027e\u027f"+
		"\5{<\2\u027f\u0280\5\u0101\177\2\u0280R\3\2\2\2\u0281\u0282\5{<\2\u0282"+
		"\u0283\5\u0105\u0081\2\u0283T\3\2\2\2\u0284\u0287\5?\36\2\u0285\u0287"+
		"\5A\37\2\u0286\u0284\3\2\2\2\u0286\u0285\3\2\2\2\u0287V\3\2\2\2\u0288"+
		"\u0289\5o\66\2\u0289\u028a\5\u00a1O\2\u028aX\3\2\2\2\u028b\u028c\5k\64"+
		"\2\u028c\u028d\5\u0101\177\2\u028d\u0292\3\2\2\2\u028e\u028f\5k\64\2\u028f"+
		"\u0290\5\u0105\u0081\2\u0290\u0292\3\2\2\2\u0291\u028b\3\2\2\2\u0291\u028e"+
		"\3\2\2\2\u0292Z\3\2\2\2\u0293\u029e\5\u0143\u00a0\2\u0294\u0295\5o\66"+
		"\2\u0295\u0296\5\u00a1O\2\u0296\u0297\b,\4\2\u0297\u029f\3\2\2\2\u0298"+
		"\u0299\5k\64\2\u0299\u029a\5\u0101\177\2\u029a\u029f\3\2\2\2\u029b\u029c"+
		"\5k\64\2\u029c\u029d\5\u0105\u0081\2\u029d\u029f\3\2\2\2\u029e\u0294\3"+
		"\2\2\2\u029e\u0298\3\2\2\2\u029e\u029b\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\u02a1\5\u0143\u00a0\2\u02a1\\\3\2\2\2\u02a2\u02a3\5W*\2\u02a3^\3\2\2"+
		"\2\u02a4\u02a5\5k\64\2\u02a5\u02a6\5\u0101\177\2\u02a6`\3\2\2\2\u02a7"+
		"\u02a8\5k\64\2\u02a8\u02a9\5\u0105\u0081\2\u02a9b\3\2\2\2\u02aa\u02ac"+
		"\5\u0087B\2\u02ab\u02aa\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ab\3\2\2"+
		"\2\u02ad\u02ae\3\2\2\2\u02ae\u02b7\3\2\2\2\u02af\u02b8\5\u00b5Y\2\u02b0"+
		"\u02b8\5e\61\2\u02b1\u02b8\5\u00b7Z\2\u02b2\u02b8\5\u00b9[\2\u02b3\u02b8"+
		"\5\u00bf^\2\u02b4\u02b8\5\u00c3`\2\u02b5\u02b6\4c|\2\u02b6\u02b8\4C\\"+
		"\2\u02b7\u02af\3\2\2\2\u02b7\u02b0\3\2\2\2\u02b7\u02b1\3\2\2\2\u02b7\u02b2"+
		"\3\2\2\2\u02b7\u02b3\3\2\2\2\u02b7\u02b4\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b8"+
		"d\3\2\2\2\u02b9\u02ba\5\u008dE\2\u02baf\3\2\2\2\u02bb\u02bc\7%\2\2\u02bc"+
		"h\3\2\2\2\u02bd\u02be\7B\2\2\u02bej\3\2\2\2\u02bf\u02c0\5i\63\2\u02c0"+
		"l\3\2\2\2\u02c1\u02c2\7$\2\2\u02c2n\3\2\2\2\u02c3\u02c4\5m\65\2\u02c4"+
		"p\3\2\2\2\u02c5\u02c6\7.\2\2\u02c6r\3\2\2\2\u02c7\u02c8\5q\67\2\u02c8"+
		"t\3\2\2\2\u02c9\u02ca\7`\2\2\u02cav\3\2\2\2\u02cb\u02cc\5u9\2\u02ccx\3"+
		"\2\2\2\u02cd\u02ce\7=\2\2\u02cez\3\2\2\2\u02cf\u02d0\5y;\2\u02d0|\3\2"+
		"\2\2\u02d1\u02d2\7\60\2\2\u02d2~\3\2\2\2\u02d3\u02d4\5}=\2\u02d4\u0080"+
		"\3\2\2\2\u02d5\u02d6\7a\2\2\u02d6\u0082\3\2\2\2\u02d7\u02d8\5\u0081?\2"+
		"\u02d8\u0084\3\2\2\2\u02d9\u02e1\5k\64\2\u02da\u02e1\5o\66\2\u02db\u02e1"+
		"\5s8\2\u02dc\u02e1\5w:\2\u02dd\u02e1\5{<\2\u02de\u02e1\5\177>\2\u02df"+
		"\u02e1\5\u0083@\2\u02e0\u02d9\3\2\2\2\u02e0\u02da\3\2\2\2\u02e0\u02db"+
		"\3\2\2\2\u02e0\u02dc\3\2\2\2\u02e0\u02dd\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0"+
		"\u02df\3\2\2\2\u02e1\u0086\3\2\2\2\u02e2\u02e9\5g\62\2\u02e3\u02e9\5k"+
		"\64\2\u02e4\u02e9\5o\66\2\u02e5\u02e9\5w:\2\u02e6\u02e9\5\177>\2\u02e7"+
		"\u02e9\5\u0083@\2\u02e8\u02e2\3\2\2\2\u02e8\u02e3\3\2\2\2\u02e8\u02e4"+
		"\3\2\2\2\u02e8\u02e5\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3\2\2\2\u02e9"+
		"\u0088\3\2\2\2\u02ea\u02ed\5g\62\2\u02eb\u02ed\5\u0085A\2\u02ec\u02ea"+
		"\3\2\2\2\u02ec\u02eb\3\2\2\2\u02ed\u008a\3\2\2\2\u02ee\u02ef\7\63\2\2"+
		"\u02ef\u008c\3\2\2\2\u02f0\u02f1\5\u008bD\2\u02f1\u008e\3\2\2\2\u02f2"+
		"\u02f3\7\64\2\2\u02f3\u0090\3\2\2\2\u02f4\u02f5\5\u008fF\2\u02f5\u0092"+
		"\3\2\2\2\u02f6\u02f7\7\65\2\2\u02f7\u0094\3\2\2\2\u02f8\u02f9\5\u0093"+
		"H\2\u02f9\u0096\3\2\2\2\u02fa\u02fb\7\66\2\2\u02fb\u0098\3\2\2\2\u02fc"+
		"\u02fd\5\u0097J\2\u02fd\u009a\3\2\2\2\u02fe\u02ff\78\2\2\u02ff\u009c\3"+
		"\2\2\2\u0300\u0301\5\u009bL\2\u0301\u009e\3\2\2\2\u0302\u0303\79\2\2\u0303"+
		"\u00a0\3\2\2\2\u0304\u0305\5\u009fN\2\u0305\u00a2\3\2\2\2\u0306\u0307"+
		"\7:\2\2\u0307\u00a4\3\2\2\2\u0308\u0309\5\u00a3P\2\u0309\u00a6\3\2\2\2"+
		"\u030a\u030b\7\62\2\2\u030b\u00a8\3\2\2\2\u030c\u030d\5\u00a7R\2\u030d"+
		"\u00aa\3\2\2\2\u030e\u030f\7\67\2\2\u030f\u00ac\3\2\2\2\u0310\u0311\5"+
		"\u00abT\2\u0311\u00ae\3\2\2\2\u0312\u0313\7;\2\2\u0313\u00b0\3\2\2\2\u0314"+
		"\u0315\5\u00afV\2\u0315\u00b2\3\2\2\2\u0316\u0321\5\u008bD\2\u0317\u0321"+
		"\5\u008fF\2\u0318\u0321\5\u0093H\2\u0319\u0321\5\u0097J\2\u031a\u0321"+
		"\5\u00abT\2\u031b\u0321\5\u009bL\2\u031c\u0321\5\u009fN\2\u031d\u0321"+
		"\5\u00a3P\2\u031e\u0321\5\u00afV\2\u031f\u0321\5\u00a7R\2\u0320\u0316"+
		"\3\2\2\2\u0320\u0317\3\2\2\2\u0320\u0318\3\2\2\2\u0320\u0319\3\2\2\2\u0320"+
		"\u031a\3\2\2\2\u0320\u031b\3\2\2\2\u0320\u031c\3\2\2\2\u0320\u031d\3\2"+
		"\2\2\u0320\u031e\3\2\2\2\u0320\u031f\3\2\2\2\u0321\u00b4\3\2\2\2\u0322"+
		"\u0332\5\u00a9S\2\u0323\u0332\5\u00fd}\2\u0324\u0332\5\u00adU\2\u0325"+
		"\u0332\5\u00b1W\2\u0326\u0332\5\u0091G\2\u0327\u0332\5\u0095I\2\u0328"+
		"\u0332\5\u009dM\2\u0329\u0332\5\u00a5Q\2\u032a\u0332\5\u00a1O\2\u032b"+
		"\u0332\5\u010d\u0085\2\u032c\u0332\5\u013d\u009d\2\u032d\u0332\5\u013f"+
		"\u009e\2\u032e\u0332\5\u0141\u009f\2\u032f\u0332\5\u013b\u009c\2\u0330"+
		"\u0332\5\u0115\u0089\2\u0331\u0322\3\2\2\2\u0331\u0323\3\2\2\2\u0331\u0324"+
		"\3\2\2\2\u0331\u0325\3\2\2\2\u0331\u0326\3\2\2\2\u0331\u0327\3\2\2\2\u0331"+
		"\u0328\3\2\2\2\u0331\u0329\3\2\2\2\u0331\u032a\3\2\2\2\u0331\u032b\3\2"+
		"\2\2\u0331\u032c\3\2\2\2\u0331\u032d\3\2\2\2\u0331\u032e\3\2\2\2\u0331"+
		"\u032f\3\2\2\2\u0331\u0330\3\2\2\2\u0332\u00b6\3\2\2\2\u0333\u0334\5\u0099"+
		"K\2\u0334\u00b8\3\2\2\2\u0335\u0336\5\u00f7z\2\u0336\u00ba\3\2\2\2\u0337"+
		"\u0338\5\u012d\u0095\2\u0338\u00bc\3\2\2\2\u0339\u033a\5\u012f\u0096\2"+
		"\u033a\u00be\3\2\2\2\u033b\u033c\5\u0131\u0097\2\u033c\u00c0\3\2\2\2\u033d"+
		"\u033e\5\u0133\u0098\2\u033e\u00c2\3\2\2\2\u033f\u0340\5\u0135\u0099\2"+
		"\u0340\u00c4\3\2\2\2\u0341\u0342\5s8\2\u0342\u0343\5\u010d\u0085\2\u0343"+
		"\u00c6\3\2\2\2\u0344\u0345\5{<\2\u0345\u00c8\3\2\2\2\u0346\u0347\5{<\2"+
		"\u0347\u0348\5\u010d\u0085\2\u0348\u00ca\3\2\2\2\u0349\u034a\5\u0127\u0092"+
		"\2\u034a\u034b\t\r\2\2\u034b\u00cc\3\2\2\2\u034c\u034d\t\16\2\2\u034d"+
		"\u034e\5\u0127\u0092\2\u034e\u00ce\3\2\2\2\u034f\u0350\5\u010f\u0086\2"+
		"\u0350\u0351\t\17\2\2\u0351\u00d0\3\2\2\2\u0352\u0353\t\20\2\2\u0353\u0354"+
		"\5\u00f7z\2\u0354\u00d2\3\2\2\2\u0355\u0356\7c\2\2\u0356\u035a\7i\2\2"+
		"\u0357\u0358\7C\2\2\u0358\u035a\7I\2\2\u0359\u0355\3\2\2\2\u0359\u0357"+
		"\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035f\5\u00f7z\2\u035c\u035d\t\21\2"+
		"\2\u035d\u035f\5\u00f7z\2\u035e\u0359\3\2\2\2\u035e\u035c\3\2\2\2\u035f"+
		"\u00d4\3\2\2\2\u0360\u0367\5\u012b\u0094\2\u0361\u0362\7t\2\2\u0362\u0363"+
		"\7x\2\2\u0363\u0368\7u\2\2\u0364\u0365\7T\2\2\u0365\u0366\7X\2\2\u0366"+
		"\u0368\7U\2\2\u0367\u0361\3\2\2\2\u0367\u0364\3\2\2\2\u0368\u00d6\3\2"+
		"\2\2\u0369\u036a\7c\2\2\u036a\u036e\7n\2\2\u036b\u036c\7C\2\2\u036c\u036e"+
		"\7N\2\2\u036d\u0369\3\2\2\2\u036d\u036b\3\2\2\2\u036e\u036f\3\2\2\2\u036f"+
		"\u0378\5\u0129\u0093\2\u0370\u0375\5\u0129\u0093\2\u0371\u0372\7{\2\2"+
		"\u0372\u0376\7h\2\2\u0373\u0374\7[\2\2\u0374\u0376\7H\2\2\u0375\u0371"+
		"\3\2\2\2\u0375\u0373\3\2\2\2\u0376\u0378\3\2\2\2\u0377\u036d\3\2\2\2\u0377"+
		"\u0370\3\2\2\2\u0378\u00d8\3\2\2\2\u0379\u037a\7r\2\2\u037a\u037b\5\u0123"+
		"\u0090\2\u037b\u0380\3\2\2\2\u037c\u0381\7j\2\2\u037d\u037e\7e\2\2\u037e"+
		"\u037f\7x\2\2\u037f\u0381\7i\2\2\u0380\u037c\3\2\2\2\u0380\u037d\3\2\2"+
		"\2\u0381\u0387\3\2\2\2\u0382\u0383\7j\2\2\u0383\u0384\5\u0123\u0090\2"+
		"\u0384\u0385\7h\2\2\u0385\u0387\3\2\2\2\u0386\u0379\3\2\2\2\u0386\u0382"+
		"\3\2\2\2\u0387\u00da\3\2\2\2\u0388\u038d\5o\66\2\u0389\u038a\7q\2\2\u038a"+
		"\u038e\7h\2\2\u038b\u038c\7Q\2\2\u038c\u038e\7H\2\2\u038d\u0389\3\2\2"+
		"\2\u038d\u038b\3\2\2\2\u038e\u00dc\3\2\2\2\u038f\u0396\5\u011d\u008d\2"+
		"\u0390\u0391\7o\2\2\u0391\u0392\7x\2\2\u0392\u0397\7u\2\2\u0393\u0394"+
		"\7O\2\2\u0394\u0395\7X\2\2\u0395\u0397\7U\2\2\u0396\u0390\3\2\2\2\u0396"+
		"\u0393\3\2\2\2\u0397\u00de\3\2\2\2\u0398\u0399\7\65\2\2\u0399\u039a\7"+
		"e\2\2\u039a\u039c\7x\2\2\u039b\u039d\7i\2\2\u039c\u039b\3\2\2\2\u039c"+
		"\u039d\3\2\2\2\u039d\u00e0\3\2\2\2\u039e\u039f\t\22\2\2\u039f\u00e2\3"+
		"\2\2\2\u03a0\u03a1\t\23\2\2\u03a1\u00e4\3\2\2\2\u03a2\u03a4\t\24\2\2\u03a3"+
		"\u03a2\3\2\2\2\u03a4\u00e6\3\2\2\2\u03a5\u03a6\t\25\2\2\u03a6\u00e8\3"+
		"\2\2\2\u03a7\u03a8\t\26\2\2\u03a8\u00ea\3\2\2\2\u03a9\u03b0\5\u00e1o\2"+
		"\u03aa\u03b0\5\u00e3p\2\u03ab\u03b0\5\u00e5q\2\u03ac\u03b0\5\u00e7r\2"+
		"\u03ad\u03b0\5\u00e9s\2\u03ae\u03b0\5\u0189\u00c3\2\u03af\u03a9\3\2\2"+
		"\2\u03af\u03aa\3\2\2\2\u03af\u03ab\3\2\2\2\u03af\u03ac\3\2\2\2\u03af\u03ad"+
		"\3\2\2\2\u03af\u03ae\3\2\2\2\u03b0\u03b6\3\2\2\2\u03b1\u03b7\5\u00e1o"+
		"\2\u03b2\u03b7\5\u00e3p\2\u03b3\u03b7\5\u00e5q\2\u03b4\u03b7\5\u00e7r"+
		"\2\u03b5\u03b7\5\u00e9s\2\u03b6\u03b1\3\2\2\2\u03b6\u03b2\3\2\2\2\u03b6"+
		"\u03b3\3\2\2\2\u03b6\u03b4\3\2\2\2\u03b6\u03b5\3\2\2\2\u03b7\u03b8\3\2"+
		"\2\2\u03b8\u03b6\3\2\2\2\u03b8\u03b9\3\2\2\2\u03b9\u03ba\3\2\2\2\u03ba"+
		"\u03bb\bt\5\2\u03bb\u00ec\3\2\2\2\u03bc\u03bd\t\22\2\2\u03bd\u00ee\3\2"+
		"\2\2\u03be\u03bf\t\23\2\2\u03bf\u00f0\3\2\2\2\u03c0\u03c2\t\24\2\2\u03c1"+
		"\u03c0\3\2\2\2\u03c2\u00f2\3\2\2\2\u03c3\u03c4\t\25\2\2\u03c4\u00f4\3"+
		"\2\2\2\u03c5\u03c8\t\26\2\2\u03c6\u03c8\5\u018b\u00c4\2\u03c7\u03c5\3"+
		"\2\2\2\u03c7\u03c6\3\2\2\2\u03c8\u00f6\3\2\2\2\u03c9\u03ca\7\61\2\2\u03ca"+
		"\u00f8\3\2\2\2\u03cb\u03cc\5\u00f7z\2\u03cc\u00fa\3\2\2\2\u03cd\u03ce"+
		"\7/\2\2\u03ce\u00fc\3\2\2\2\u03cf\u03d0\5\u00fb|\2\u03d0\u00fe\3\2\2\2"+
		"\u03d1\u03d2\7>\2\2\u03d2\u0100\3\2\2\2\u03d3\u03d4\5\u00ff~\2\u03d4\u0102"+
		"\3\2\2\2\u03d5\u03d6\7@\2\2\u03d6\u0104\3\2\2\2\u03d7\u03d8\5\u0103\u0080"+
		"\2\u03d8\u0106\3\2\2\2\u03d9\u03da\7-\2\2\u03da\u0108\3\2\2\2\u03db\u03dc"+
		"\5\u0107\u0082\2\u03dc\u010a\3\2\2\2\u03dd\u03de\7)\2\2\u03de\u010c\3"+
		"\2\2\2\u03df\u03e0\5\u010b\u0084\2\u03e0\u010e\3\2\2\2\u03e1\u03e2\7\'"+
		"\2\2\u03e2\u0110\3\2\2\2\u03e3\u03e4\5\u010f\u0086\2\u03e4\u0112\3\2\2"+
		"\2\u03e5\u03e6\7<\2\2\u03e6\u0114\3\2\2\2\u03e7\u03e8\5\u0113\u0088\2"+
		"\u03e8\u0116\3\2\2\2\u03e9\u03ea\7(\2\2\u03ea\u0118\3\2\2\2\u03eb\u03ec"+
		"\7?\2\2\u03ec\u011a\3\2\2\2\u03ed\u03ee\7*\2\2\u03ee\u011c\3\2\2\2\u03ef"+
		"\u03f0\7#\2\2\u03f0\u011e\3\2\2\2\u03f1\u03f2\7+\2\2\u03f2\u0120\3\2\2"+
		"\2\u03f3\u03f4\7]\2\2\u03f4\u0122\3\2\2\2\u03f5\u03f6\7_\2\2\u03f6\u0124"+
		"\3\2\2\2\u03f7\u03f8\7&\2\2\u03f8\u0126\3\2\2\2\u03f9\u03fa\7,\2\2\u03fa"+
		"\u0128\3\2\2\2\u03fb\u03fc\7A\2\2\u03fc\u012a\3\2\2\2\u03fd\u03fe\7^\2"+
		"\2\u03fe\u012c\3\2\2\2\u03ff\u0400\5\u0117\u008a\2\u0400\u012e\3\2\2\2"+
		"\u0401\u0402\5\u0119\u008b\2\u0402\u0130\3\2\2\2\u0403\u0404\5\u011b\u008c"+
		"\2\u0404\u0132\3\2\2\2\u0405\u0406\5\u011d\u008d\2\u0406\u0134\3\2\2\2"+
		"\u0407\u0408\5\u011f\u008e\2\u0408\u0136\3\2\2\2\u0409\u040a\5\u0127\u0092"+
		"\2\u040a\u0138\3\2\2\2\u040b\u040c\5\u0129\u0093\2\u040c\u013a\3\2\2\2"+
		"\u040d\u040e\5\u012b\u0094\2\u040e\u013c\3\2\2\2\u040f\u0410\5\u0123\u0090"+
		"\2\u0410\u013e\3\2\2\2\u0411\u0412\5\u0121\u008f\2\u0412\u0140\3\2\2\2"+
		"\u0413\u0414\5\u0125\u0091\2\u0414\u0142\3\2\2\2\u0415\u0416\7\"\2\2\u0416"+
		"\u0144\3\2\2\2\u0417\u0418\5\u0143\u00a0\2\u0418\u041a\5\u0143\u00a0\2"+
		"\u0419\u041b\5\u0143\u00a0\2\u041a\u0419\3\2\2\2\u041b\u041c\3\2\2\2\u041c"+
		"\u041a\3\2\2\2\u041c\u041d\3\2\2\2\u041d\u0146\3\2\2\2\u041e\u041f\5\u0143"+
		"\u00a0\2\u041f\u0148\3\2\2\2\u0420\u0422\t\27\2\2\u0421\u0420\3\2\2\2"+
		"\u0422\u0423\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0424\3\2\2\2\u0424\u014a"+
		"\3\2\2\2\u0425\u0426\5\u0149\u00a3\2\u0426\u014c\3\2\2\2\u0427\u0428\4"+
		"\"\u0081\2\u0428\u014e\3\2\2\2\u0429\u042a\5\u0149\u00a3\2\u042a\u042b"+
		"\5\u0143\u00a0\2\u042b\u042c\5g\62\2\u042c\u042d\5s8\2\u042d\u042e\3\2"+
		"\2\2\u042e\u042f\b\u00a6\6\2\u042f\u0150\3\2\2\2\u0430\u0431\5{<\2\u0431"+
		"\u0432\5{<\2\u0432\u0434\t\30\2\2\u0433\u0435\t\30\2\2\u0434\u0433\3\2"+
		"\2\2\u0435\u0436\3\2\2\2\u0436\u0434\3\2\2\2\u0436\u0437\3\2\2\2\u0437"+
		"\u0152\3\2\2\2\u0438\u0439\5{<\2\u0439\u043a\t\30\2\2\u043a\u0154\3\2"+
		"\2\2\u043b\u043d\t\30\2\2\u043c\u043b\3\2\2\2\u043d\u043e\3\2\2\2\u043e"+
		"\u043c\3\2\2\2\u043e\u043f\3\2\2\2\u043f\u0156\3\2\2\2\u0440\u0441\5\u0149"+
		"\u00a3\2\u0441\u0158\3\2\2\2\u0442\u0444\5g\62\2\u0443\u0445\t\30\2\2"+
		"\u0444\u0443\3\2\2\2\u0445\u0446\3\2\2\2\u0446\u0444\3\2\2\2\u0446\u0447"+
		"\3\2\2\2\u0447\u0449\3\2\2\2\u0448\u044a\5\u0099K\2\u0449\u0448\3\2\2"+
		"\2\u0449\u044a\3\2\2\2\u044a\u015a\3\2\2\2\u044b\u044c\5\u00f7z\2\u044c"+
		"\u015c\3\2\2\2\u044d\u044e\5\u011b\u008c\2\u044e\u015e\3\2\2\2\u044f\u0450"+
		"\5\177>\2\u0450\u0451\5\u00f7z\2\u0451\u0160\3\2\2\2\u0452\u0453\5\u011f"+
		"\u008e\2\u0453\u0162\3\2\2\2\u0454\u0455\5\u0143\u00a0\2\u0455\u0164\3"+
		"\2\2\2\u0456\u0457\5\u0149\u00a3\2\u0457\u0166\3\2\2\2\u0458\u0459\7\61"+
		"\2\2\u0459\u045a\7\61\2\2\u045a\u045e\3\2\2\2\u045b\u045d\13\2\2\2\u045c"+
		"\u045b\3\2\2\2\u045d\u0460\3\2\2\2\u045e\u045f\3\2\2\2\u045e\u045c\3\2"+
		"\2\2\u045f\u0461\3\2\2\2\u0460\u045e\3\2\2\2\u0461\u0462\7\61\2\2\u0462"+
		"\u0463\7\61\2\2\u0463\u0464\3\2\2\2\u0464\u0465\b\u00b2\7\2\u0465\u0168"+
		"\3\2\2\2\u0466\u0468\5\u0089C\2\u0467\u0466\3\2\2\2\u0468\u0469\3\2\2"+
		"\2\u0469\u0467\3\2\2\2\u0469\u046a\3\2\2\2\u046a\u046e\3\2\2\2\u046b\u046f"+
		"\5\u00b5Y\2\u046c\u046f\3\2\2\2\u046d\u046f\t\31\2\2\u046e\u046b\3\2\2"+
		"\2\u046e\u046c\3\2\2\2\u046e\u046d\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471"+
		"\b\u00b3\6\2\u0471\u016a\3\2\2\2\u0472\u0475\5\u00b5Y\2\u0473\u0475\t"+
		"\3\2\2\u0474\u0472\3\2\2\2\u0474\u0473\3\2\2\2\u0475\u0476\3\2\2\2\u0476"+
		"\u0477\b\u00b4\6\2\u0477\u016c\3\2\2\2\u0478\u0479\4\"\u0081\2\u0479\u047a"+
		"\b\u00b5\b\2\u047a\u047b\3\2\2\2\u047b\u047c\b\u00b5\6\2\u047c\u016e\3"+
		"\2\2\2\u047d\u047e\6\u00b6\3\2\u047e\u047f\5\u00f7z\2\u047f\u0480\3\2"+
		"\2\2\u0480\u0481\b\u00b6\6\2\u0481\u0170\3\2\2\2\u0482\u0483\5o\66\2\u0483"+
		"\u0484\5o\66\2\u0484\u0485\5\u0149\u00a3\2\u0485\u0172\3\2\2\2\u0486\u0487"+
		"\5o\66\2\u0487\u0488\5\u0149\u00a3\2\u0488\u0174\3\2\2\2\u0489\u048a\5"+
		"o\66\2\u048a\u048b\t\30\2\2\u048b\u0176\3\2\2\2\u048c\u048e\t\2\2\2\u048d"+
		"\u048c\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u048d\3\2\2\2\u048f\u0490\3\2"+
		"\2\2\u0490\u0178\3\2\2\2\u0491\u0492\5\u00f7z\2\u0492\u017a\3\2\2\2\u0493"+
		"\u0494\5\u0135\u0099\2\u0494\u0495\3\2\2\2\u0495\u0496\b\u00bc\6\2\u0496"+
		"\u017c\3\2\2\2\u0497\u0498\5{<\2\u0498\u0499\3\2\2\2\u0499\u049a\b\u00bd"+
		"\6\2\u049a\u017e\3\2\2\2\u049b\u049c\5s8\2\u049c\u049d\5\u010d\u0085\2"+
		"\u049d\u049e\b\u00be\t\2\u049e\u049f\3\2\2\2\u049f\u04a0\b\u00be\6\2\u04a0"+
		"\u0180\3\2\2\2\u04a1\u04a2\5\u0147\u00a2\2\u04a2\u04a3\b\u00bf\n\2\u04a3"+
		"\u04a4\3\2\2\2\u04a4\u04a5\b\u00bf\6\2\u04a5\u0182\3\2\2\2\u04a6\u04a7"+
		"\5\u0149\u00a3\2\u04a7\u04a8\b\u00c0\13\2\u04a8\u04a9\3\2\2\2\u04a9\u04aa"+
		"\b\u00c0\6\2\u04aa\u0184\3\2\2\2\u04ab\u04ac\5s8\2\u04ac\u04ad\5\u00fd"+
		"}\2\u04ad\u04ae\b\u00c1\f\2\u04ae\u04af\3\2\2\2\u04af\u04b0\b\u00c1\6"+
		"\2\u04b0\u0186\3\2\2\2\u04b1\u04b2\5\u010d\u0085\2\u04b2\u04b3\b\u00c2"+
		"\r\2\u04b3\u04b4\3\2\2\2\u04b4\u04b5\b\u00c2\6\2\u04b5\u0188\3\2\2\2\u04b6"+
		"\u04b8\t\32\2\2\u04b7\u04b9\t\3\2\2\u04b8\u04b7\3\2\2\2\u04b9\u04ba\3"+
		"\2\2\2\u04ba\u04b8\3\2\2\2\u04ba\u04bb\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc"+
		"\u04bd\b\u00c3\6\2\u04bd\u018a\3\2\2\2\u04be\u04bf\t\32\2\2\u04bf\u04c0"+
		"\3\2\2\2\u04c0\u04c1\b\u00c4\6\2\u04c1\u018c\3\2\2\2\u04c2\u04c3\5A\37"+
		"\2\u04c3\u04c4\3\2\2\2\u04c4\u04c5\b\u00c5\6\2\u04c5\u018e\3\2\2\2\u04c6"+
		"\u04c7\5\177>\2\u04c7\u04c8\5\u00f7z\2\u04c8\u04c9\3\2\2\2\u04c9\u04ca"+
		"\b\u00c6\6\2\u04ca\u0190\3\2\2\2\u04cb\u04cd\5\u0089C\2\u04cc\u04cb\3"+
		"\2\2\2\u04cd\u04ce\3\2\2\2\u04ce\u04cc\3\2\2\2\u04ce\u04cf\3\2\2\2\u04cf"+
		"\u04d4\3\2\2\2\u04d0\u04d5\5\u00b5Y\2\u04d1\u04d5\t\32\2\2\u04d2\u04d5"+
		"\5e\61\2\u04d3\u04d5\5\u00c3`\2\u04d4\u04d0\3\2\2\2\u04d4\u04d1\3\2\2"+
		"\2\u04d4\u04d2\3\2\2\2\u04d4\u04d3\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7"+
		"\b\u00c7\6\2\u04d7\u0192\3\2\2\2\u04d8\u04da\5\u0085A\2\u04d9\u04db\t"+
		"\31\2\2\u04da\u04d9\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04dd\b\u00c8\16"+
		"\2\u04dd\u0194\3\2\2\2\u04de\u04e0\5\u0089C\2\u04df\u04e1\5\u0089C\2\u04e0"+
		"\u04df\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2\u04e0\3\2\2\2\u04e2\u04e3\3\2"+
		"\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e5\t\33\2\2\u04e5\u04e6\3\2\2\2\u04e6"+
		"\u04e7\b\u00c9\16\2\u04e7\u0196\3\2\2\2\u04e8\u04e9\5\u00b5Y\2\u04e9\u04ea"+
		"\3\2\2\2\u04ea\u04eb\b\u00ca\6\2\u04eb\u0198\3\2\2\2\u04ec\u04ed\4\"\u0081"+
		"\2\u04ed\u04ee\3\2\2\2\u04ee\u04ef\b\u00cb\6\2\u04ef\u019a\3\2\2\2\u04f0"+
		"\u04f1\5s8\2\u04f1\u04f2\5\u010d\u0085\2\u04f2\u04f3\3\2\2\2\u04f3\u04f4"+
		"\b\u00cc\6\2\u04f4\u019c\3\2\2\2\u04f5\u04f6\5\u0143\u00a0\2\u04f6\u04f7"+
		"\3\2\2\2\u04f7\u04f8\b\u00cd\17\2\u04f8\u019e\3\2\2\2\u04f9\u04fa\7\\"+
		"\2\2\u04fa\u01a0\3\2\2\2J\2\3\4\5\6\u01af\u01bb\u01be\u01d4\u01d9\u01de"+
		"\u01e4\u01e9\u01f1\u01f5\u01fb\u0206\u020e\u0213\u021c\u0224\u022c\u023c"+
		"\u0241\u024a\u0251\u025c\u0263\u0286\u0291\u029e\u02ad\u02b7\u02e0\u02e8"+
		"\u02ec\u0320\u0331\u0359\u035e\u0367\u036d\u0375\u0377\u0380\u0386\u038d"+
		"\u0396\u039c\u03a3\u03af\u03b6\u03b8\u03c1\u03c7\u041c\u0423\u0436\u043e"+
		"\u0446\u0449\u045e\u0469\u046e\u0474\u048d\u048f\u04ba\u04ce\u04d4\u04da"+
		"\u04e2\20\4\4\2\4\3\2\3,\2\3t\3\4\2\2\2\4\2\3\u00b5\4\3\u00be\5\3\u00bf"+
		"\6\3\u00c0\7\3\u00c1\b\3\u00c2\t\4\5\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}