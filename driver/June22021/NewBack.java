package org.dotlessbraille.driver;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;


import org.dotlessbraille.manifold.LineNumberTracker;
import org.dotlessbraille.manifold.LineNumberProvider;
import org.dotlessbraille.transtables.KeepTrack;

import org.dotlessbraille.transtables.LargeWord;
import org.dotlessbraille.transtables.Letter;
import org.dotlessbraille.jsonInput.ModifiedLetter;
import org.dotlessbraille.transtables.PartWord;
import org.dotlessbraille.transtables.Punctuation;
import org.dotlessbraille.transtables.SpecialSymbols;
import org.dotlessbraille.transtables.UpperNumber;
import org.dotlessbraille.transtables.Word;
import org.dotlessbraille.transtables.WordOrPartWord;

import org.dotlessbraille.utilities.Tape6;
import org.dotlessbraille.antlr4.uebMathParserBaseListener;
import org.dotlessbraille.antlr4.uebMathParser;

import java.util.List;


class NewBack extends uebMathParserBaseListener
                         implements LineNumberProvider {

 public static Tape6 myOutput;
 public static Tape6 logFile = new Tape6( "Logfile.txt");
 static String[] ruleNames;
 static boolean showRuleNames;
 String currentLineBrl = null;
 boolean logIt = true;
 boolean showDebug = true;
 boolean debug = true;
 boolean debugSL = true;
 boolean showEnter = true;
 boolean showExit = true;
 boolean showInput4Line = false;
 boolean debugSep = false;
 boolean visitTermNode = false;
 Vocabulary VOCABULARY;
 int expr2Count = 0;  //Idea is knowing probably math
 boolean printInputText = true;
 LineNumberTracker lnt;
 static boolean numLineCont = false;  //FIX THIS!!!
 static boolean ignoreComments         = true;
static boolean debugComments          = false;
 static String simple = "Simple";
 KeepTrack statusManager;
 Tape6 mmlOut;
 private static final String linebreak = "\r\n"; // or "\n";

static String mathDisp=
"<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">";
static String xmath = "</math>";
static String mrow = "<mrow>";
static String xmrow = "</mrow>";

 public static String invisX = "<mo>&#x2062;</mo>";
 public static String appleFun = "<mo>&#x2061;</mo>";
 public static String bevMfrac = "<mfrac bevelled=\"true\">";

static String mfrac  = "<mfrac>";
static String xmfrac = "</mfrac>";

static String msub     = "<msub>";
static String xmsub    = "</msub>";
static String msubsup  = "<msubsup>";
static String xmsubsup = "</msubsup>";
static String msup     = "<msup>";
static String xmsup    = "</msup>";

static String mn = "<mn>";
static String xmn = "</mn>";
static String mo = "<mo>";
static String xmo = "</mo>";
static String mi = "<mi>";
static String xmi = "</mi>";

 BufferedTokenStream allTokens; //To support a comment channel

  NewBack( KeepTrack statusManager, 
           BufferedTokenStream allTokens,
           Tape6 mmlOut) {
           
    this.statusManager = statusManager;
    this.allTokens = allTokens;
    this.mmlOut = mmlOut;
    this.VOCABULARY= uebMathParser.VOCABULARY;
    setRuleNames();

}
  static void setRuleNames(){
    ruleNames = uebMathParser.ruleNames;
    if (!showRuleNames) return;
    for (int rn=0; rn<ruleNames.length; rn++){
      System.out.println( "Rule: "+rn+" "+ruleNames[rn] );
    }
  } 

//  ===========BACKTRANSLATION ANNOTATIONS SAVED HERE============
/**   See v4 Ref. p. 123   ParserTreeProperty is an 
    ANTLR helper class that uses an
    IdentityHashMap to store the annotation 
    results for **specific** nodes, i.e.
    not just nodes with the same context.
    Annotation can be any type, not just String.
*/
      // "ink" is back-translation
    ParseTreeProperty<String> ink = new ParseTreeProperty<String>();
    void setInk(ParseTree ctx, String s) {ink.put(ctx, s);}
    String getInk(ParseTree ctx) {return ink.get(ctx);}

      //"info" is any optional additional information
    ParseTreeProperty<String> info = new ParseTreeProperty<String>();
    void setInfo(ParseTree ctx, String s) {info.put(ctx, s);}
    String getInfo(ParseTree ctx) {return info.get(ctx);}

  public void addTracker( LineNumberTracker lnt ){
    this.lnt = lnt;
   }

//  ========PARSE TREE NODES BACKTRANSLATION STARTS HERE=========
//  --0. 'text' is arbitrary name of grammar's root node--
@Override 
 public void enterText( uebMathParser.TextContext ctx )  {
   if (showEnter){
    System.out.println();
    System.out.println( "        Starting to annote input: enterText ..." );
  //System.out.println( "Input contains: "+ctx.getChildCount()+
  //                     " lines." );
   }
   if (logIt){
    logFile.out( "Starting to annote input: enterText ..." );
    logFile.out( "Input contains: "+ctx.getChildCount()+" lines." );
   }

   if (lnt == null){
    System.out.println(
       " LOGIC ERROR--No registered  LineNumberTracker!" );          
    System.exit( 0 );
   }
   lnt.startingFirstLine( 0 );
   int ruleIndex = ctx.getRuleIndex();

  //System.out.println( "enterText--ruleName: "+ruleNames[ruleIndex] );
  }


@Override
 public void exitText( uebMathParser.TextContext ctx)  {
     if (showExit) System.out.println(  
      "\n        Finishing up annotation: exitText..." );

   if (printInputText) System.out.println( "brl: "+ctx.getText() );
   mmlOut.println( "UEB input: "+ctx.getText() );
   int cnt = ctx.getChildCount();
  
     //Concatenate all lines (already annotated) //CLEAN
   String ink;
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<cnt; i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
      buf.append( ink );
    } else {
     buf.append( "" );
    }
   } 
   setInk( ctx, buf.toString() );
   System.out.println( "exitText final: "+buf.toString() );
 }//End exitText.
@Override 
public void enterLineStart(uebMathParser.LineStartContext ctx) {
 if (showEnter ) System.out.println( " EnterLineStart" );
  currentLineBrl = ctx.getText();
}
@Override 
public void exitLineStart(uebMathParser.LineStartContext ctx) {
 if ( showExit ) System.out.println( " ExitLineStart" ); 
  String ink;
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<ctx.getChildCount(); i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
      buf.append( ink );
    } else {
     buf.append( "" );
    }
   } 
   setInk( ctx, buf.toString() );
}
@Override
public void enterLineMiddle(uebMathParser.LineMiddleContext ctx) {
 if (showEnter ) System.out.println( " EnterLineMiddle" );
}
@Override public 
void exitLineMiddle(uebMathParser.LineMiddleContext ctx) {
 if (showExit ) System.out.println( " ExitLineMiddle" );
  String ink;
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<ctx.getChildCount(); i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
      buf.append( ink );
    } else {
     buf.append( "" );
    }
   } 
   setInk( ctx, buf.toString() );
}
@Override 
public void enterLineEnd(uebMathParser.LineEndContext ctx) { 
  if (showEnter ) System.out.println( " EnterLineEnd" );
}
@Override 
public void exitLineEnd(uebMathParser.LineEndContext ctx) { 
 if (showExit ) System.out.println( " ExitLineEnd" );
   String ink;
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<ctx.getChildCount(); i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
      buf.append( ink );
    } else {
     buf.append( "" );
    }
   } 
   if (debug) System.out.println( "LineEnd ink: "+buf.toString() );
   setInk( ctx, buf.toString() );
}
@Override 
public void enterLineDone(uebMathParser.LineDoneContext ctx) { 
 if (showEnter ) System.out.println( " EnterLineDone" );
}
@Override 
public void exitLineDone(uebMathParser.LineDoneContext ctx) {
 if (showExit ) System.out.println( " ExitLineDone" );
}



         //---------------------------------
  // 01. -->'line' is phrase name in lexer grammar 

@Override
 public void enterLine( uebMathParser.LineContext ctx ){

   int maniLineNum = lnt.nextLineStarted();
   //statusManager.incrementLinesDone();
   //System.out.println( "---------------------------------");
   if (showEnter) System.out.println( 
       "\n         Starting enterLine for "
       +"line no. "+statusManager.getCurrentLineNumber() );
    if (showInput4Line){ 
     System.out.print( "ASCII Braille input: "+ctx.getText() );
    }
    if (logIt){ 
     logFile.out( "ASCII Braille input: "+ctx.getText() );
    }

    // FIX FIX Need to tell grammar about continued number
    //   and move this to status guy
   if (numLineCont) {
    System.out.println( " numLineCont: "+numLineCont );
   }
   boolean contNum = false;
   //  Check whether previous line was a continued numeric item
   // such as a long number
   if (numLineCont){
    contNum = true;
    numLineCont = false;
   } else {
    contNum = false;
   }
}
@Override
 public void exitLine( uebMathParser.LineContext ctx ) {

   if (showExit) {
    System.out.println( "\n         Finishing current line..." );
   }
   //System.out.println( "brl: "+ctx.getText() );
   int cnt = ctx.getChildCount();
   if (logIt){
    logFile.out( "No. of child nodes "+
           "including any separator(s) and EOL: "+ cnt );
   }

   String cmtInfo = null;
   if (!ignoreComments){
    cmtInfo = lineComment( ctx, 2 );
   }

    //Concatenate various items in this line; all (except EOF)
    //should have been backtranslated at lower levels
   String ink;
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<cnt-1; i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
     buf.append( ink );
    } else {
     System.out.println( "Braille for this line's child item no. "+i+
        "  was not backtranslated: "+
        "|"+ctx.getChild(i).getText()+"|" );
     buf.append( "" );  //Hmmm.....
    }
   } 
   
    String after =
      statusManager.backTrans( "", KeepTrack.Trans.EOL_AFTER ); 
     if (after != null) {
      buf.append( after );
     }
   
  if(debug) System.out.println( "Line concat: "+buf.toString() );
   if (cmtInfo != null) {
     buf.append( "      ");
     buf.append( cmtInfo );
    }
   buf.append("\n");  //New line at end of line
   setInk( ctx, buf.toString() );

   statusManager.incrementLinesDone();
 }//End exitLine.

//Items are one possible children of a line

@Override
public void enterItem(uebMathParser.ItemContext ctx){
int cnt = ctx.getChildCount();
 System.out.println( "Enter item, cnt: "+cnt);
}

@Override
public void exitItem(uebMathParser.ItemContext ctx){
//Cnt should always be 1
System.out.println();
  System.out.println( "   ****exitItem child cnt: "+ctx.getChildCount() );
  String brl = ctx.getChild(0).getText();
  String ink = getInk( ctx.getChild(0) );

  System.out.println( "EXIT ITEM Braille: "+brl+" Ink: "+ink );
  StringBuilder mink = new StringBuilder( mathDisp);
  mink.append( ink );
  mink.append(xmath  );
  setInk( ctx, mink.toString() );
 mmlOut.out( mink.toString() );
}

//        ----------CONTRACTIONS-----------
    // "Large" signs, words or partwords in any context
@Override 
public void enterLargeSign(uebMathParser.LargeSignContext ctx) {
  String brl = ctx.getChild(0).getText();
  String cap = getInfo( ctx.getParent() );
  if (debug) {
   System.out.println( "          enterLargeSign: "+cap);
   System.out.println( "parent text: "+ctx.getParent().getText());
}
  String ink = TransWrapper.bakLarge( brl, cap );
/**
  if (cap == null){
   ink = backLARGElc( brl );
  } else if (cap.equals(",")){
   ink = backLARGEtc( brl );
  } else {
   ink = backLARGElc( brl );
  }
*/
  setInk( ctx, ink ); }
@Override 
public void exitLargeSign(uebMathParser.LargeSignContext ctx) {
 if (debug){
  System.out.println( "exitLargeSign--ink: "+ getInk( ctx ) );
 }
 return;
}
@Override 
public void enterLowAlone(uebMathParser.LowAloneContext ctx) { 
 if (showEnter) System.out.println( "enterLowAlone" );
}

@Override 
public void exitLowAlone(uebMathParser.LowAloneContext ctx) { 
 if (showExit) System.out.println( "exit" );
 String ink = TransWrapper.btLOW( ctx.getText() );
 if (debug) System.out.println("lowAlone brl: "+ctx.getText() 
    +"lowAlone ink: "+ink );
 setInk( ctx, ink );
}
	

      //Large sign contraction backtanslation
      //Just the contraction, no indicators
static String backLARGElc( String brl ){
 return LargeWord.backLC( brl );
}
static String backLARGEtc( String brl ){
 return LargeWord.backTC( brl );
}
static String backLARGEuc( String brl ){
 return LargeWord.backUC( brl );
}

//Currently does not check position of flc or tc
//but it should not be at beginning of word

@Override 
public void enterFlc(uebMathParser.FlcContext ctx) { 
 int cnt = ctx.getChildCount();
 if (cnt != 1){
  System.out.println( "Unexpected--flc has :"+cnt+
    " child nodes. ");
  }
 if (debug) System.out.println( "enterFlc" );
}
@Override 
public void exitFlc(uebMathParser.FlcContext ctx) {
 String brl = ctx.getChild(0).getText(); 
 if (debug) System.out.println( "exitFlc" );
 String ink = backFLC( brl );
 setInk( ctx, ink );
}
//  Strong groupsigns are single cell contractions that
// can be used anywhere as a part of a word
//  FINISH BY ADDING TC LOGIC!!!
@Override 
public void enterStrong_gs(uebMathParser.Strong_gsContext ctx) {
 String brl = ctx.getText();
 if (showEnter){
  System.out.println( "enterStrong_gs brl: "+brl );
 }
 String ink = TransWrapper.btStrongGS( brl, false );
 if (debug){
  System.out.println( "enterStrong_gs ink: "+ink );
 }
 setInk( ctx, ink);
}

@Override 
public void exitStrong_gs(uebMathParser.Strong_gsContext ctx) { }



@Override 
public void enterStrong_ws(uebMathParser.Strong_wsContext ctx) {
 String isWord = getInfo( ctx.getParent() );
 if (isWord == null) return;
 if (!isWord.equals( "alone" )) return; 
 // Braille wordsign is standing alone so backtranslate as whole word
 String brl = ctx.getText();
 String ink = TransWrapper.bakLetterAsWord( brl );
/**
 if (brl.length()==2 && brl.startsWith( "," )) {
   brl=brl.substring(1);
   ink = TransWrapper.backLetOrGSAsWord( brl,
         TransWrapper.wordCase.TC );
 } else {
  ink = TransWrapper.backLetOrGSAsWord( brl,
                    TransWrapper.wordCase.TC );
 }
*/
 if (debug){
  System.out.println( "enterStrong_ws, whole word : "+ink );
 }
 setInk(ctx, ink);
}
@Override 
public void exitStrong_ws( uebMathParser.Strong_wsContext ctx ) {
 //Backtranslation as whole word already done.
 if (getInk( ctx ) != null) return;
 String ink = TransWrapper.btStrongGS( ctx.getText(), false );
 if (debug) System.out.println( "   ink: "+ink );
 setInk( ctx, ink );
 }

//public static String backStrongGS( String brl, boolean tc ){
 //return PartWord.backStrongGS( brl, tc);
//}
public static String backFLC( String brl ){
 return PartWord.backFLC( brl );
}	
@Override public void enterIlc(uebMathParser.IlcContext ctx) {
   
  //Check if done in "word" node
  if (getInk(ctx.getParent().getParent()) != null) return;
  int cnt = ctx.getChildCount();
  if (debug ){
   System.out.println( "enterIlc cnt: "+cnt );
  }
  String cap = getInfo(ctx.getParent() ); 
  
  String brl = ctx.getChild(0).getText();
  if (debug) System.out.println( "enterIlc brl: "+brl );
  String ink = null;
  if (cap == null){
   ink = backILClc( brl );
  } else {
   ink = backILCtc( brl );
  }
  setInk( ctx, ink );
}

@Override 
public void exitIlc(uebMathParser.IlcContext ctx) {
 String ink = getInk( ctx );
 if (debug) System.out.println( "exitIlc ink: "+ ink );
}

      //Initial letter contraction
      //Just the contraction, no indicators
static String backILClc( String brl ){
 return WordOrPartWord.ilcBackLC( brl );
}
static String backILCtc( String brl ){
 return WordOrPartWord.ilcBackTC( brl );
}
static String backILCuc( String brl ){
 return WordOrPartWord.ilcBackUC( brl );
}

@Override 
public void enterAlphaSeq(uebMathParser.AlphaSeqContext ctx) { 
 if (showEnter) System.out.println( "   Enter AlphaSeq" );

 //Only simple word parent reports text; if so this a complete word
 //that might be an App1 alphabetic word. 
 boolean simple = false;
 String pinfo= getInfo( ctx.getParent() );
 if (pinfo == null) return;
 if (pinfo.equals(ctx.getText() ) ){
  if (debug){
    System.out.println( "Parent: "+getInfo( ctx.getParent() ) );
    System.out.println( "This alphaSeq: "+ctx.getText() );
  }
  simple = true;
 }
 if (!simple) return;
 String brl = ctx.getText();
 boolean app1 = TransWrapper.isApp1Word( brl );
 if (!app1) return;

 String ink = TransWrapper.btApp1Word( brl );
 System.out.println( "App1 alphabetic word: "+ink );
 setInk( ctx, ink );
 return;
}

/**
  int ic = 0;
  if (info != null) ic=1;
  String brl = ctx.getChild(ic).getText();
  String ink = null; 
  if (debug){
   System.out.println( "          enterAlpha--cap: "+info );
   System.out.println( "          enterAlpha--brl: "+brl );
  }
  if (info == null){
   ink = backAlphaSeq( brl, false );
  } else if (info.equals(",")){
   ink = backAlphaSeq( brl, true ); 
  }
  setInk( ctx, ink );
*/

@Override 
public void exitAlphaSeq(uebMathParser.AlphaSeqContext ctx) {
 if (showExit) System.out.println( "   Exit AlphaSeq" );
 if ( getInk( ctx) != null) return;
 String ink = TransWrapper.backAlphaSeq( ctx.getText(), false );
 setInk( ctx, ink );
}
@Override 
public void enterTcAlphaSeq(uebMathParser.TcAlphaSeqContext ctx) {
if (showEnter) System.out.println( "   Enter tcAlphaSeq" );

 //Only simple word parent reports text; if so this a complete word
 //that might be an App1 alphabetic word. 
 boolean simple = false;
 String chk = ctx.getParent().getText();
 if (chk != null){
 if (chk.equals(ctx.getText() ) ){
  if (debug){
    System.out.println( "Parent: "+getInfo( ctx.getParent() ) );
    System.out.println( "This TCalphaSeq: "+ctx.getText() );
  }
  simple = true;
 }}
 if (!simple) return;
 String cap = ctx.getChild( 0).getText();
 String rest = ctx.getChild(1).getText();
 //boolean app1 = TransWrapper.isApp1Word( brl );
 //if (!app1) return;

 String ink = TransWrapper.btApp1Word( cap, rest );
 if (ink == null) return;
 if (debug) System.out.println( "App1 tc alphabetic word: "+ink );
 setInk( ctx, ink );
}

@Override 
public void exitTcAlphaSeq(uebMathParser.TcAlphaSeqContext ctx) {
 if (showExit) System.out.println( "   Exit tcAlphaSeq: " +ctx.getText() );
 if ( getInk( ctx) != null) return;
 String cap = ctx.getChild( 0).getText();
 String rest = ctx.getChild(1).getText();
 String ink = TransWrapper.backAlphaSeq( cap, rest );
 if (debug) System.out.println( "tcAlphaSeq--ink: "+ink);
 setInk( ctx, ink );
}


	

      //Word consisting of just letters, lc or tc
static String backAlphaSeq( String brl, boolean tc ){
 return Letter.backTransAlphaSeq( brl, tc );
}
//             +++SUBSCRIPTS and SUPERSCRIPTS+++
@Override 
public void enterSubExpr(uebMathParser.SubExprContext ctx) {
 int cnt = ctx.getChildCount();
 System.out.println( "enterSubExpr-cnt: " +cnt); 
 setInk( ctx, msub ); //On 1 or just 3???
}
@Override 
public void exitSubExpr(uebMathParser.SubExprContext ctx) {
 System.out.println( "exitSubExpr" );
 int cnt = ctx.getChildCount();
 ParseTree child = ctx.getChild(0);
 if (cnt == 1){
  System.out.println( "Child brl: "+child.getText()+
                      " ink: "+getInk( child ) );
  setInk( ctx, getInk( child ));
 } else if (cnt == 3 ){
  StringBuilder buf = new StringBuilder( getInk( ctx ) );
  buf.append( getInk( child ) );
  buf.append( getInk( ctx.getChild(2) ));
  buf.append( xmsub);
  System.out.println(    "sup: "+buf.toString() );
  setInk( ctx, buf.toString() );
 } else {
  System.out.println( "Unexpected child coount: "+cnt );
 }
}

@Override 
public void enterSupExpr(uebMathParser.SupExprContext ctx) {
 int cnt = ctx.getChildCount();
 System.out.println( "enterSupExpr-cnt: " +cnt); 
 setInk( ctx, msup );
}
@Override 
public void exitSupExpr(uebMathParser.SupExprContext ctx) {
 System.out.println( "exitSupExpr" );
 int cnt = ctx.getChildCount();
 ParseTree child = ctx.getChild(0);
 if (cnt == 1){
    System.out.println( "Child brl: "+child.getText()+
            " ink: "+getInk( child ) );
    setInk( ctx, getInk( child ));
 } else if (cnt == 3 ){
   StringBuilder buf = new StringBuilder( getInk( ctx ) );
   buf.append( getInk( child ) );
   buf.append( getInk( ctx.getChild(2) ));
   buf.append( xmsup);
   System.out.println(    "sup: "+buf.toString() );
   setInk( ctx, buf.toString() );
 } else {
  System.out.println( "Unexpedted child coount: "+cnt );
 }
}

@Override 
public void enterSubsupExpr(uebMathParser.SubsupExprContext ctx) { 
 int cnt = ctx.getChildCount();
 System.out.println( "enterSubsupExpr-cnt: " +cnt); 
 setInk( ctx, msubsup );
}

@Override
public void exitSubsupExpr(uebMathParser.SubsupExprContext ctx) {
}


//                    +++FRACTIONS+++

@Override 
public void enterSimpleFraction(uebMathParser.SimpleFractionContext ctx) { 
  System.out.println();
  System.out.println( "==>enterSimpleFrac child cnt: "+ctx.getChildCount() );
  setInk( ctx, bevMfrac );
  String txt0 = ctx.getChild(0).getText();
  
  String backT = UpperNumber.backTrans( txt0.toString() ); 
  StringBuilder ink = new StringBuilder( bevMfrac );
   ink.append( mn );
   ink.append( backT );  
   ink.append( xmn );
   setInk( ctx, ink.toString() );
  System.out.println( "SF "+txt0+" BT "+ink.toString());
  setInk( ctx.getChild(0), ink.toString() );
 }
@Override 
public void exitSimpleFraction(uebMathParser.SimpleFractionContext ctx) { 
 //String ink = conCat( ctx, "simpleFraction", true, 0 );
 StringBuilder buf =new StringBuilder( getInk( ctx ) );
 //buf.append( getInk( ctx.getChild(0) ));
 buf.append( getInk( ctx.getChild(2) ));
 buf.append( xmfrac );
 String ink = buf.toString();
 System.out.println( "==>exitSimpleFrac ink: "+ink );
 setInk( ctx, ink );
}

@Override 
public void enterCfrac(uebMathParser.CfracContext ctx) {
  System.out.println();
  int cnt = ctx.getChildCount();
  System.out.println( "  ===>>enterCfrac child cnt: "+ctx.getChildCount() ); 
  for (int i=0; i<cnt; i++ ){
   System.out.println( "i-th Child text : "+i+"  "+ctx.getChild(i).getText() );
  }
 }

@Override 
public void exitCfrac(uebMathParser.CfracContext ctx) {
  int cnt = ctx.getChildCount();
  System.out.println( "  ===>>exitCfrac child cnt: "+ctx.getChildCount() ); 
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<cnt; i++ ){
    String tmp = ctx.getChild(i).getText();
    System.out.print( "i: "+i+" text: "+tmp );
    if (tmp.startsWith( "#" )){
      buf.append( getInk( ctx.getChild(i) )); //simple fraction.
    } else {
      buf.append( conCat( ctx.getChild(i), "cfrac", true, 0 ) );
    }
  }
  String ink = buf.toString();
  System.out.println( "CFRAC INK: "+ink );
  setInk( ctx, ink );
 }

@Override 
public void enterFrac(uebMathParser.FracContext ctx) {
  System.out.println();
  int cnt = ctx.getChildCount();
  System.out.println( "====>enterFrac child cnt: "+ctx.getChildCount() ); 
  for (int i=0; i<cnt; i++ ){
   System.out.println( "i-th Child text : "+i+"  "+ctx.getChild(i).getText() );
  }
}

@Override 
public void exitFrac(uebMathParser.FracContext ctx) {

   int cnt = ctx.getChildCount();
    System.out.println( "   ====>ExitFrac, child cnt: "+cnt);
 
   StringBuilder buf = new StringBuilder();
   for (int i=0; i<cnt; i++ ){
    String tmp = ctx.getChild(i).getText();
    System.out.print( "i: "+i+" text: "+tmp );
    if (tmp.startsWith( "#" )){
      buf.append( getInk( ctx.getChild(i) )); //simple fraction.
    } else {
      buf.append( conCat( ctx.getChild(i), "frac", true, 0 ) );
    }
    
   // int type  = ctx.getChild(i).getType();
    //System.out.print( "i: "+i+" type: "+ctx.getChild(i).getType() );
   }

    //System.out.println( "Braille: "+brl );
  
  //StringBuilder ml = new StringBuilder( mrow );
  //ml.append( ink );
 // ml.append( "xmrow" );
  setInk( ctx, buf.toString() );
  System.out.println( "   -->ExitFrac, ink: "+ buf.toString() );
 }

@Override 
public void enterFracStart(uebMathParser.FracStartContext ctx) { 
 System.out.println( "==========EnterFracStart brl");
 setInk( ctx, mfrac+mrow+linebreak );
 setInk( ctx.getChild(0), mfrac+mrow+linebreak );
}
@Override 
public void exitFracStart(uebMathParser.FracStartContext ctx) { 
 System.out.println( "==========ExitFracStart");
 System.out.println( "Node text: "+ctx.getText() );
 System.out.println( "Child text: "+ctx.getChild(0).getText());
 System.out.println( "Saved ink: "+getInk( ctx )); 
 
}

@Override 
public void enterFracEnd(uebMathParser.FracEndContext ctx) { 
 System.out.println( "==========EnterFracEnd");
 String ink = xmrow+xmfrac;
 setInk( ctx, ink);
 setInk( ctx.getChild(0), ink); 
}
@Override 
public void exitFracEnd(uebMathParser.FracEndContext ctx) {
 System.out.println( "==========ExitFracEnd");
 //setInk( ctx, xmrow+xmfrac ); 
 System.out.println( "Saved ink: "+getInk( ctx )); 
}

@Override 
public void enterFracLine(uebMathParser.FracLineContext ctx) { 
 System.out.println( "==========EnterFracLine");
 String ink = xmrow+linebreak+mrow; 
 setInk( ctx, ink ); 
 setInk( ctx.getChild(0), ink );
}
@Override 
public void exitFracLine(uebMathParser.FracLineContext ctx) { 
 System.out.println( "==========ExitFracLine");
 System.out.println( "Saved ink: "+getInk( ctx ));
}


//    expr2  ===MATH EXPRESSSIONS==
public void enterExpr2(uebMathParser.Expr2Context ctx) { 
 expr2Count = expr2Count+1;
 System.out.println( "   -->EnterExpr2, Expr2Count: "+expr2Count);

}

@Override 
public void exitExpr2(uebMathParser.Expr2Context ctx) {
    int cnt = ctx.getChildCount();
    System.out.println( "   -->ExitExpr2, cnt: "+cnt);

    String ink = conCat( ctx, "expr2", true, 0 );

    //System.out.println( "Braille: "+brl );
  
  StringBuilder ml = new StringBuilder( mrow );
  ml.append( ink );
  ml.append( xmrow );
  setInk( ctx, ml.toString() );
  System.out.println( "   -->ExitExpr2, ink: "+ ml.toString() );
  expr2Count = expr2Count-1;
}
   //GOING LOWER IN TREE TO DO ITEMS THAT COMPRISE A LINE



//   "comp" are expressons involving composition indicators like '='
@Override 
public void enterComp(uebMathParser.CompContext ctx) {

  System.out.println();
  System.out.println( "   enterComp child cnt: "+ctx.getChildCount() );
  
 }
@Override 
public void exitComp(uebMathParser.CompContext ctx) {
    int cnt = ctx.getChildCount();
    System.out.println( "   -->ExiComp, child cnt: "+cnt);

    String ink = conCat( ctx, "comp", true, 0 );

    //System.out.println( "Braille: "+brl );
  
  StringBuilder ml = new StringBuilder( mrow );
  ml.append( ink );
  ml.append( xmrow );
  setInk( ctx, ml.toString() );
  System.out.println( "   -->ExitComp, ink: "+ ml.toString() );
}

//   Convenience method for concatenated translated values
String conCatAsRow( ParseTree ctx, String label,
                    boolean show, boolean saveAnnot, int i0 ){

  String ink = conCat( ctx, label, show, i0);

  StringBuilder ml = new StringBuilder( mrow );
  ml.append( ink );
  ml.append( xmrow );

  if (saveAnnot) setInk( ctx, ml.toString() );
  return ml.toString();
}
String conCat( ParseTree ctx, 
        String label, boolean show, int i0 ){

    //Concatenate children of this node for which all children 
    //should have alredy been backtranslated at lower levels
   String ink;
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   System.out.println( "===ConCat for: "+label+" cnt = "+cnt );
   for (int i=i0; i<cnt; i++){
    ink = getInk( ctx.getChild(i) );
    if (ink != null) {
     buf.append( ink );
    } else {
     System.out.println( "Braille for child item no. "+i+
        "  was not backtranslated: "+
        "|"+ctx.getChild(i).getText()+"|" );
     buf.append( "" );  //Hmmm.....
    }
    if (show) System.out.println( "===ConCat Child no. "+i+" ink: "+ink);
   } 
  return buf.toString();
}

    //    SPECIAL SYMBOLS
@Override 
public void enterCompSymbols(uebMathParser.CompSymbolsContext ctx){
  System.out.println( "   enterCompSymbols child cnt: "+ctx.getChildCount() );
  String brl = ctx.getChild(0).getText();
  String ink = SpecialSymbols.getSpecial( brl );
  System.out.println( "Braille: |"+brl+"| Ink: "+ink );
  StringBuilder mink = new StringBuilder( mo );
  mink.append( ink );
  mink.append( xmo );
  setInk( ctx, mink.toString() );
 }

@Override
 public void exitCompSymbols(uebMathParser.CompSymbolsContext ctx) {
   String ink = getInk( ctx );
   System.out.println( "exitCompSymbols: "+ink);
}
//      MATHML TOKENS
@Override 
public void enterG1MathRoots(uebMathParser.G1MathRootsContext ctx) {
 System.out.println( "<><><>EnterG1MathRoots"); 
 String brl = ctx.getText();
 String ink = btMNO( brl, true);
 setInk( ctx, ink );
 //setInk( ctx.getChild(), ink );
}

@Override 
public void exitG1MathRoots(uebMathParser.G1MathRootsContext ctx) { }

      //OPEN and CLOSE GROUPINg SYMBOLS	
@Override 
public void enterOGroup(uebMathParser.OGroupContext ctx) { 
 System.out.println( "<><><>EnterOGroup");
 String brl = ctx.getText();
 String ink = btPunc( brl, true );
 setInk( ctx, ink );
}

@Override 
public void exitOGroup(uebMathParser.OGroupContext ctx) {
 System.out.println( "<><><>ExitOGroup" );
}

@Override 
public void enterCGroup(uebMathParser.CGroupContext ctx) {
 System.out.println( "<><><>EnterCGroup" ); 
 System.out.println( "<><><>EnterOGroup");
 String brl = ctx.getText();
 String ink = btPunc( brl, true );
 setInk( ctx, ink );
}

@Override public void exitCGroup(uebMathParser.CGroupContext ctx) {
 System.out.println( "<><><>ExitCGroup" );
 }


//     Backtranslate punctuation as MO token
String btPunc( String brl, boolean show ){
 String ink = Punctuation.getAnyPunc(  brl );
 if (show) System.out.println( "Punctuation brl: "+brl+
     " ink: " +ink );
  StringBuilder mink = new StringBuilder( mo );
  mink.append( ink );
  mink.append( xmo );
  return mink.toString();
}
//     Backtranslate special symbol as MO token
String btMNO( String brl, boolean show ){
 String ink = SpecialSymbols.getSpecial(  brl );
 if (show) System.out.println( "Punctuation brl: "+brl+
     " ink: " +ink );
  StringBuilder mink = new StringBuilder( mo );
  mink.append( ink );
  mink.append( xmo );
  return mink.toString();
}
@Override 
public void enterStandAloneCon(uebMathParser.StandAloneConContext ctx) { 
 setInfo( ctx, "alone" ); //So child contracti0ns know they are words
}
//    Finsh standing alone contraction
@Override 
public void exitStandAloneCon(uebMathParser.StandAloneConContext ctx) {
 System.out.println( "->>>exitStandAloneCon" );
    //Concatenate information from child nodes
 System.out.println( "\n          Gather up child nodes." );
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   for (int i=0; i<cnt; i++){
    String ink = getInk( ctx.getChild(i));
    buf.append( ink );
   }
   System.out.println( "StandAloneCon backTranslation: "+buf.toString() );
   setInk( ctx, buf.toString() );
 }
 //-----------------------------------------------------------------

  /** --2.1 'standingAlone' is one of several types of 
          symbols-sequences that can comprise a line--
          Its different types of children are 
          back-translated at their level
 */
@Override
 public void exitStandingAlone(uebMathParser.StandingAloneContext ctx){

   System.out.println( "\n          Gather up standing alone items." );
 
     //Concatenate information from child nodes
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   for (int i=0; i<cnt; i++){
    String ink = getInk( ctx.getChild(i));
    buf.append( ink );
   }
   System.out.println( "StandAlone backTranslation: "+buf.toString() );
   setInk( ctx, buf.toString() );
}

//   Backtranslate digits as MN tokens
@Override 
public void enterDigits(uebMathParser.DigitsContext ctx) {
  System.out.println();
  System.out.println( "   enterDigits child cnt: "+ctx.getChildCount() );
   String txt;
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   for (int i=0; i<cnt; i++){
    txt = ctx.getChild(i).getText();
    System.out.println("  i: "+i+" txt: "+txt);
    buf.append( txt );
   }
   String backT = UpperNumber.backTrans( buf.toString() ); 
   System.out.println( "DIGITS: "+buf+" ink: "+backT );
   StringBuilder ink = new StringBuilder( mn );

   ink.append( backT );
   ink.append( xmn );
   setInk( ctx, ink.toString() );
}
	@Override public void exitDigits(uebMathParser.DigitsContext ctx) {
   String ink = getInk( ctx );
   System.out.println( "Exit digits: "+ink );
 }
String btMN( ParseTree ctx ){
   String txt;
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   for (int i=0; i<cnt; i++){
    txt = ctx.getChild(i).getText();
    System.out.println("  i: "+i+" txt: "+txt);
    buf.append( txt );
   }
   String backT = UpperNumber.backTrans( buf.toString() ); 
   System.out.println( "btMN: "+buf+" ink: "+backT );
   StringBuilder ink = new StringBuilder( mn );
   ink.append( backT );
   ink.append( xmn );
   return ink.toString();
}
//               BINARY OPERATION
@Override public void enterBinop(uebMathParser.BinopContext ctx) { 
  System.out.println();
  System.out.println( "   enterBinop child cnt: "+ctx.getChildCount() );
  String brl = ctx.getChild(0).getText();
  String ink = SpecialSymbols.getSpecial( brl );
  System.out.println( "Braille: "+brl+" Ink: "+ink );
  StringBuilder mink = new StringBuilder( mo );
  mink.append( ink );
  mink.append( xmo );
  setInk( ctx, mink.toString() );
}
	 
	@Override public void exitBinop(uebMathParser.BinopContext ctx) { 
 String ink = getInk( ctx );
   System.out.println( "Exit binop: "+ink );
}


//            WORDS

@Override 
public void enterSimpleWord(uebMathParser.SimpleWordContext ctx) { 
//FIX A SIMPLE WORD COULD BE A (be) shortform
//tcAlphaSeq: CapitalLetter ALPHA_SEQ;
//alphaSeq: ALPHA_SEQ
//comma: DOT2|COMMA_ROOT;
//simpleWord: DOT6?(ilc|largeSign|tcAlphaSeq|alphaSeq)
  //               (comma|postAlone)?;
// Note that an "alphaSeq", i.e. a sequence of letters, could be
//either an Appendix 1 word or an ordinary uncontracted word
// or one of the (be) words which are not reported by the lexer

 if (showEnter) System.out.println( "    enterSimpleWord" );
 if (debug){
  System.out.println( "Child cnt: "+ ctx.getChildCount());
  System.out.println( "Simple word: "+ctx.getText() );
}
//Sets flag so child knows parent is a "simple word" rather
// than a "word"

if (ctx.getChildCount() == 1){
 String brl = ctx.getChild(0).getText();
 boolean sf = TransWrapper.isShortform( brl );;
 if(!sf  || !brl.startsWith( "2" )) {
  setInfo( ctx, ctx.getText() );
  return;
 }
 String ink = TransWrapper.btShortform( brl, TransWrapper.wordCase.LC);
 setInk( ctx, ink );
 return;
}

 String test = ctx.getChild(0).getText();
 boolean beSF = false;
 int ss = 0;
 if (test.equals( "," )) ss = 1;
 String justText = ctx.getChild(0).getText().substring(ss);
 if (test.equals(  "," )) {
  setInfo( ctx, test );
  System.out.println( "Set info: "+test+" "+getInfo(ctx));
  int wordLen = ctx.getChild(1).getText().length();
  if (ctx.getText().length() == 2) return;
//Need type of child FIX!!!
 }

 if (ctx.getChildCount() == 1 && test.length() > 2){
   String ink = TransWrapper.btApp1Word( test);                        
   System.out.println( "app1 ink: "+ink );
   setInfo( ctx, ink );
   return;
 //} else if (ctx.getChildCount() == 2){
   //String rest = ctx.getChild(1).getText();
   //String ink = TransWrapper.btApp1Word( test, rest );                        
  // System.out.println( "app1 ink: "+ink );
   //setInfo( ctx, ink );
   //return;
 } 

 
 //App1 words could start with CapitalLetter token 
 if (ctx.getChildCount() == 2){
    String ink = TransWrapper.btApp1Word( ctx.getChild(0).getText(), 
                             ctx.getChild(1).getText() );
  System.out.println( "app1 ink: "+ink );
 }
}
@Override 
public void exitSimpleWord(uebMathParser.SimpleWordContext ctx) {
 if (showExit) System.out.println( "    exitSimpleWord" );
 //If child completed translation
 if (getInk( ctx.getChild(0)) != null){
  setInk( ctx, getInk( ctx.getChild(0) ));
 return;
}
 int i0 = 0;
 if (ctx.getChildCount() == 2) i0 = 1; // TC word has preceding DOT6
 String ink = getInk( ctx.getChild(i0) );
 if (debug) System.out.println( "Simple ink: "+ink ); 
 setInk( ctx, ink );
}
public void 
enterShortForms(uebMathParser.ShortFormsContext ctx) { 
}
@Override public void exitShortForms(uebMathParser.ShortFormsContext ctx) {
 }

//            +++WORD+++

// Word node first does some special checks for the entire string
//to identfy certain words
@Override 
public void enterWord(uebMathParser.WordContext ctx) { 
  int ruleIndex = ctx.getRuleIndex();
  if (debug){
   System.out.println( "enterWprd--ruleName: "+ruleNames[ruleIndex] );
   int pruleIndex = ctx.getParent().getRuleIndex();
   System.out.println( "enterText--pruleName: "+ruleNames[pruleIndex] );
  }
  int cnt = ctx.getChildCount();
  System.out.println( "EnterWord, cnt: "+cnt+" expr2Count: "+ expr2Count);

//Check for leading caps letter or word indicator
 int ss = 0;
 if (ctx.getText().startsWith( ",,")){
  ss = 2;
  setInfo(ctx, ",," );
 } else if (ctx.getText().startsWith( "." )){
  ss = 1;
  setInfo( ctx, "," );
 }
 
 if (debug) System.out.println( "ss: "+ss+" txt: "+ctx.getText() );
 String brl = ctx.getText().substring(ss);
 if (debug) System.out.println(" Word checking: "+brl );

 if (brl.startsWith( "2" )) { //low word "be"
   if (brl.length() == 2){
     System.out.println( "Word: "+brl+" might be (be) shortform." );
     boolean b = TransWrapper.isShortform( brl );
     System.out.println( "Is sf: "+ b );
  
     if( b ){
       TransWrapper.wordCase opt = TransWrapper.wordCase.LC;
       if (ss == 1) opt = TransWrapper.wordCase.TC;
       if (ss == 2) opt = TransWrapper.wordCase.UC;
       String ink = TransWrapper.btShortform( brl, opt );
       if (debug) System.out.println( "ink: "+ink );
       setInk( ctx, ink );
       return;
    }
   }
  };

  String ink = null;
  if (debug){
   System.out.println( "Enter word -- checking for App1." );
  }

  boolean isApp1 = TransWrapper.isApp1Word( brl );
  System.out.println( brl+" is App1: "+isApp1 );

  if (ss == 0){
    ink = TransWrapper.btApp1Word( brl ); 
    if (ink != null) {
     if (debug) System.out.println( "ink: "+ink );
     setInk( ctx, ink);
     return;
    }
  } else if (ss == 1){ 
    ink = TransWrapper.btApp1Word( ",", brl );
    if (ink != null) {
     setInk( ctx, ink);
     return;
    }
  } else if (ss == 2){ 
    ink = TransWrapper.btApp1Word( ",,", brl );
    if (ink != null) {
     setInk( ctx, ink);
     return;
    }
  };

}


@Override 
public void exitWord(uebMathParser.WordContext ctx) {
System.out.println( "ExitWord -- expr2Count: "+ expr2Count);
if (getInk( ctx ) != null ) return;
int cnt = ctx.getChildCount();
if (cnt == 1){
 setInk( ctx, getInk( ctx.getChild(0) ));
 return;
}
int i0 = 0;
String cap = getInfo( ctx );
if (cap != null) i0 = 1;

String ink = conCat( ctx, "word", true, i0 );
System.out.println( "ExitWord -- ink: "+ink );
 setInk( ctx, ink );
}

@Override 
public void enterWordStart(uebMathParser.WordStartContext ctx) {
 if (showEnter) System.out.println( "enterWordStart" );
}
@Override 
public void exitWordStart(uebMathParser.WordStartContext ctx) {
 if (showExit) System.out.println( "exitWordStart" );
 String ink  = conCat( ctx, "exitWordStart", false, 0 );
 setInk( ctx, ink);
}
@Override 
public void enterWordMiddle(uebMathParser.WordMiddleContext ctx) {
 if (showEnter) System.out.println( "enterWordMiddle" );
}
@Override 
public void exitWordMiddle(uebMathParser.WordMiddleContext ctx) {
 if (showExit) System.out.println( "exitWordMiddle" );
 String ink  = conCat( ctx, "exitWordMiddle", false, 0 );
 setInk( ctx, ink);
}
@Override 
public void enterWordEnding(uebMathParser.WordEndingContext ctx) {
  if (showEnter) System.out.println( "enterWordEnding" );
 }
@Override 
public void exitWordEnding(uebMathParser.WordEndingContext ctx) { 
  if (showExit) System.out.println( "exitWordEnding" );
  String ink  = conCat( ctx, "exitWordEnding", false, 0 );
  setInk( ctx, ink);
}



@Override 
public void enterSingleLetter(uebMathParser.SingleLetterContext ctx) {
 String isWord = getInfo( ctx.getParent() );
 if (isWord == null) return;
 if (!isWord.equals( "alone" )) return;
 String ink = TransWrapper.bakLetterAsWord( ctx.getText() );
 if (debugSL){
  System.out.println( "  enterSingleLetter--ink: "+ink );
 }
 setInk( ctx, ink );
}
@Override 
public void exitSingleLetter(uebMathParser.SingleLetterContext ctx) {
   //Use as whole-word addressed in enterSingleLetter
   if (getInk( ctx ) != null ) return;
   String brl = ctx.getText();
   System.out.println( "exitSingleLetter braille: "+brl );
   //Assume just a letter MI if in an expression
   boolean inExpr = true;
   if (expr2Count <= 0) {
    System.out.println( "exitSingleLetter -- not in expr");
    inExpr = false;
   }
  // System.out.println( "Child type: "+ctx.getChild(0).getType() );
   String ink = backALetter( brl );
   System.out.println( "exitSingleLetter ink: "+ink );
   if (inExpr){
    StringBuilder mink = new StringBuilder( mi );
    mink.append( ink );
    mink.append( xmi );
    setInk( ctx, mink.toString() );
   } else {
    setInk( ctx, ink );
   }
} 
//  FIX CAUSES POINTER ERROR WITH ,A
//static String backLetterAsWord( String brl ){
 //return Word.backLC( brl );
//}
//   Backtranslate ordinary and modified letters	
String backALetter( String brl ){
  boolean modif =
   brl.startsWith( ",@") || brl.startsWith( ",^")
   || brl.startsWith( "@" ) || brl.startsWith( "^") ;
  if (modif) return ModifiedLetter.btModLetter(brl);
 
//put error checks here!!!
//hard-wired  ;,l  or ;l or ,l or l where l is any braille letter

   String ink = null;
  if (brl.length() == 1){
   ink = Letter.backTrans2lc(brl);
  } else if (brl.length() == 2){
    if (brl.startsWith( ";" )){
     ink = Letter.backTrans2lc(brl.substring(1,2));
    } else {
     ink = Letter.backTrans2UC(brl.substring(1,2));
    }
  } else if (brl.length() == 3){
    ink = Letter.backTrans2UC(brl.substring(2,3));

  }
  ;
  System.out.println( "LetterBT--Braille: "+brl+" Ink: "+ink );
  return ink;
  //StringBuilder mink = new StringBuilder( "<MI>" );
  //mink.append( ink );
  //mink.append( "</MI>" );
  //setInk( ctx, mink.toString() );
}
//                check this!!!
public void enterJustALetter(uebMathParser.JustALetterContext ctx){
  System.out.println();
  System.out.println( "   enterJustALetter child cnt: "+ctx.getChildCount() );
  String brl = ctx.getChild(0).getText();
  String ink = null;

//put error checks here!!!
//hard-wired  ;,l  or ;l or ,l or l where l is any braille letter
  if (brl.length() == 1){
   ink = Letter.backTrans2lc(brl);
  } else if (brl.length() == 2){
    if (brl.startsWith( ";" )){
     ink = Letter.backTrans2lc(brl.substring(1,2));
    } else {
     ink = Letter.backTrans2UC(brl.substring(1,2));
    }
  } else if (brl.length() == 3){
    ink = Letter.backTrans2UC(brl.substring(2,3));

  }
  ;
  System.out.println( "Braille: "+brl+" Ink: "+ink );
  StringBuilder mink = new StringBuilder( "<MI>" );
  mink.append( ink );
  mink.append( "</MI>" );
  setInk( ctx, mink.toString() );
}

public void exitJustALetter(uebMathParser.JustALetterContext ctx){
   String ink = getInk( ctx );
   System.out.println( "exitJustALetter: "+ink );
}

@Override 
public void enterSpace(uebMathParser.SpaceContext ctx) { }
@Override 
public void exitSpace(uebMathParser.SpaceContext ctx) { 
 String brl = ctx.getText();
 StringBuilder buf = new StringBuilder( " ");
 if (brl.length() > 1 ){
  for (int i=1; i<brl.length(); i++){
   buf.append( " " );
  }
 };
 setInk( ctx, buf.toString() );
}
@Override 
public void enterIndent(uebMathParser.IndentContext ctx) {
 if (showEnter) System.out.println( "enterIndent" );
 setInk( ctx, "<p>" );
}
@Override 
public void exitIndent(uebMathParser.IndentContext ctx) {
 if (showExit) System.out.println( "exitIndent" );
}

@Override 
public void enterSeparator(uebMathParser.SeparatorContext ctx) {
 if (showEnter) System.out.println( "enterSeparator" );
}
@Override 
public void exitSeparator(uebMathParser.SeparatorContext ctx) {
 if (showExit) System.out.println( "exitSeparator" );
 String ink = conCat( ctx, "separator", debugSep, 0 );
 setInk( ctx, ink );
 }


@Override 
public void visitTerminal(TerminalNode node) {
 if (!visitTermNode) return;
 System.out.println( "IN VIST TERMINAL NODE" );  
 
  Token tok = node.getSymbol();
  //if (showTermNode){
   String name = 
     VOCABULARY.getSymbolicName( tok.getType() );
   String brl = tok.getText();
   System.out.println( "Text: "+brl );
   System.out.println( "Terminal node: "+name );
  //}

 }
//=================
//  Logic for extracting information from any special channel
//  where lexer "hides" certain information
//=================

 String lineComment( uebMathParser.LineContext ctx,
     int channelIndex ) {

    Token startOfBrl = ctx.getStart();
    Token endOfBrl = ctx.getStop();
    int bComment = startOfBrl.getTokenIndex();
    int eComment = endOfBrl.getTokenIndex();

   if (debugComments) System.out.println( "bComment: "+bComment+
                        " eComment: "+eComment );
    List<Token> manual;
    Token cmt;
    String cmtInfo = null;

    // There could be separator(s) after a comment and 
    // before the newline at the end of the line.
    // Current logic requires the newline to be sent to the 
    // default token channel, not to the comment channel 
    // so comment is must be enclosed. Thus locating comment 
    // requires searching backwards from the EOL.

  for ( int j = eComment; j> bComment; j--){
    if (debugComments) System.out.println( "Token index: "+j );
    manual =
      allTokens.getHiddenTokensToLeft( j , channelIndex  );

    if (manual == null){
     if (debugComments)
     System.out.println( "Nothing hidden immediately to left." );
    } else {
      cmt = manual.get( 0 );
      if (cmt != null){
       cmtInfo = cmt.getText();
       if (debugComments)
       System.out.println( "cmt: "+cmt.getText() );
       break;
      }
    }
  }
    return cmtInfo;
}
}//End Class NewBack