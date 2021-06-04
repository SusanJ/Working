package org.dotlessbraille.driver;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Token;

import org.dotlessbraille.manifold.LineNumberTracker;
import org.dotlessbraille.manifold.LineNumberProvider;
import org.dotlessbraille.transtables.KeepTrack;
import org.dotlessbraille.transtables.Letter;
import org.dotlessbraille.transtables.SpecialSymbols;
import org.dotlessbraille.transtables.UpperNumber;
import org.dotlessbraille.utilities.Tape6;
import org.dotlessbraille.antlr4.uebMathParserBaseListener;
import org.dotlessbraille.antlr4.uebMathParser;

import java.util.List;


class NewBack extends uebMathParserBaseListener
                         implements LineNumberProvider {

 public static Tape6 myOutput = new Tape6("UEBbaktrans.txt");

 static String[] ruleNames;
 static boolean showRuleNames;
 int expr2Count = 0;  //Idea is knowing probably math
 boolean printInputText = true;
 LineNumberTracker lnt;
 static boolean numLineCont = false;  //FIX THIS!!!
 static boolean ignoreComments         = true;
static boolean debugComments          = false;
 KeepTrack statusManager;
 Tape6 mmlOut;
 private static final String linebreak = "\r\n"; // or "\n";

static String mathDisp=
"<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">";
static String xmath = "</math>";
static String mrow = "<mrow>";
static String mxrow = "</mrow>";

 public static String invisX = "<mo>&#x2062;</mo>";
 public static String appleFun = "<mo>&#x2061;</mo>";
 public static String bevMfrac = "<mfrac bevelled=\"true\">";

static String mfrac = "<mfrac>";
static String xmfrac = "</mfrac>";
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
    String getInfo(ParseTree ctx) {return ink.get(ctx);}

  public void addTracker( LineNumberTracker lnt ){
    this.lnt = lnt;
   }

//  ========PARSE TREE NODES BACKTRANSLATION STARTS HERE=========
    

 //  --0. 'text' is arbitrary name of grammar's root node--
@Override 
 public void enterText( uebMathParser.TextContext ctx)  {
   System.out.println();
   System.out.println( "        Starting to annote input: enterText ..." );
   System.out.println( "Input contains: "+ctx.getChildCount()+" lines." );
   if (lnt == null){
    System.out.println( " LOGIC ERROR--No registered LineNumberTracker!" );
    System.exit( 0 );
   }
   lnt.startingFirstLine( 0 );
   int ruleIndex = ctx.getRuleIndex();
//Buggy
  // System.out.println( "enterText--ruleName: "+ruleNames[ruleIndex] );
  }

@Override
 public void exitText( uebMathParser.TextContext ctx)  {
   System.out.println( "\n        Finishing up annotation: exitText..." );

   if (printInputText) System.out.println( "brl: "+ctx.getText() );
   myOutput.println( "UEB input: "+ctx.getText() );
   int cnt = ctx.getChildCount();
  
     //Concatenate all lines (already annotated)
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

         //---------------------------------
  // 01. -->'line' is phrase name grammar gives to root node children<--
@Override
 public void enterLine( uebMathParser.LineContext ctx ){

   int maniLineNum = lnt.nextLineStarted();
   //statusManager.incrementLinesDone();
   System.out.println( "\n         Starting enterLine for "
                      +"line no. "+statusManager.getCurrentLineNumber() );
   System.out.print( "ASCII Braille input: "+ctx.getText() );

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

   System.out.println( "\n         Finishing current line..." );
   //System.out.println( "brl: "+ctx.getText() );
   int cnt = ctx.getChildCount();
   System.out.println( "No. of child nodes "+
           "including any separator(s) and EOL: "+ cnt );

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
   
   //System.out.println( "Line concat: "+buf.toString() );
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
  System.out.println( "Braille: "+brl+" Ink: "+ink );
  StringBuilder mink = new StringBuilder( "<MROW>" );
  mink.append( ink );
  mink.append( "</MROW" );
  setInk( ctx, mink.toString() );
 mmlOut.out( mink.toString() );
}

//                    FRACTIONS

@Override 
public void enterSimpleFraction(uebMathParser.SimpleFractionContext ctx) { 
  System.out.println();
  System.out.println( "==>enterSimpleFrac child cnt: "+ctx.getChildCount() );
  setInk( ctx, bevMfrac );
  String txt0 = ctx.getChild(0).getText();
  
  String backT = UpperNumber.backTrans( txt0.toString() ); 
  System.out.println( "SF "+txt0+" BT "+backT);
  setInk( ctx.getChild(0), backT );
 }
@Override 
public void exitSimpleFraction(uebMathParser.SimpleFractionContext ctx) { 
 //String ink = conCat( ctx, "simpleFraction", true );
 StringBuilder buf =new StringBuilder( getInk( ctx ) );
 buf.append( getInk( ctx.getChild(0) ));
 buf.append( getInk( ctx.getChild(2) ));
 buf.append( xmfrac );
 String ink = buf.toString();
 System.out.println( "==>exitrSimpleFrac ink: "+ink );
 setInk( ctx, ink );
}



@Override 
public void enterFrac(uebMathParser.FracContext ctx) {
  System.out.println();
  System.out.println( "====>enterFrac child cnt: "+ctx.getChildCount() ); }

@Override 
public void exitFrac(uebMathParser.FracContext ctx) {
   int cnt = ctx.getChildCount();
    System.out.println( "   ====>ExitFrac, child cnt: "+cnt);

    String ink = conCat( ctx, "frac", true );

    //System.out.println( "Braille: "+brl );
  
  StringBuilder ml = new StringBuilder( "<MROW>" );
  ml.append( ink );
  ml.append( "</MROW>" );
  setInk( ctx, ml.toString() );
  System.out.println( "   -->ExitComp, ink: "+ ml.toString() );
 }
@Override 
public void enterFracStart(uebMathParser.FracStartContext ctx) { 
 System.out.println( "==========EnterFracStart");
}
@Override 
public void exitFracStart(uebMathParser.FracStartContext ctx) { 
 System.out.println( "==========ExitFracStart");
 setInk( ctx, "<MFRAC><MROW>"+linebreak );
}

@Override 
public void enterFracEnd(uebMathParser.FracEndContext ctx) { 
 System.out.println( "==========EnterFracEnd");
}
@Override 
public void exitFracEnd(uebMathParser.FracEndContext ctx) {
 System.out.println( "==========ExitFracEnd");
 setInk( ctx, "</ROW></MFRAC>" );  
}

@Override 
public void enterFracLine(uebMathParser.FracLineContext ctx) { 
 System.out.println( "==========EnterFracLine");
}
@Override 
public void exitFracLine(uebMathParser.FracLineContext ctx) { 
 System.out.println( "==========ExitFracLine");
 setInk( ctx, "</ROW>"+linebreak+"<ROW>" ); 
}


//    expr2  Various expressions
@Override 
public void enterExpr2(uebMathParser.Expr2Context ctx) { 
 expr2Count = expr2Count+1;
 System.out.println( "   -->EnterExpr2, Expr2Count: "+expr2Count);

}

@Override 
public void exitExpr2(uebMathParser.Expr2Context ctx) {
    int cnt = ctx.getChildCount();
    System.out.println( "   -->ExitExpr2, cnt: "+cnt);

    String ink = conCat( ctx, "expr2", true );

    //System.out.println( "Braille: "+brl );
  
  StringBuilder ml = new StringBuilder( "<ROW>" );
  ml.append( ink );
  ml.append( "</ROW>" );
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
    System.out.println( "   -->ExitComp, child cnt: "+cnt);

    String ink = conCat( ctx, "comp", true );

    //System.out.println( "Braille: "+brl );
  
  StringBuilder ml = new StringBuilder( "<ROW>" );
  ml.append( ink );
  ml.append( "</ROW>" );
  setInk( ctx, ml.toString() );
  System.out.println( "   -->ExitComp, ink: "+ ml.toString() );
 
}
String conCatAsRow( ParseTree ctx, String label,
                    boolean show, boolean saveAnnot ){

  String ink = conCat( ctx, label, show);

  StringBuilder ml = new StringBuilder( "<ROW>" );
  ml.append( ink );
  ml.append( "</ROW>" );

  if (saveAnnot) setInk( ctx, ml.toString() );
  return ml.toString();
}
String conCat( ParseTree ctx, String label, boolean show ){

    //Concatenate children of this node for which all children 
    //should have alredy been backtranslated at lower levels
   String ink;
   StringBuilder buf = new StringBuilder();
   int cnt = ctx.getChildCount();
   System.out.println( "===ConCat for: "+label+" cnt = "+cnt );
   for (int i=0; i<cnt; i++){
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
@Override 
public void enterCompSymbols(uebMathParser.CompSymbolsContext ctx){
  System.out.println( "   enterCompSymbols child cnt: "+ctx.getChildCount() );
  String brl = ctx.getChild(0).getText();
  String ink = SpecialSymbols.getSpecial( brl );
  System.out.println( "Braille: |"+brl+"| Ink: "+ink );
  StringBuilder mink = new StringBuilder( "<MO>" );
  mink.append( ink );
  mink.append( "</MO>" );
  setInk( ctx, mink.toString() );
 }

@Override
 public void exitCompSymbols(uebMathParser.CompSymbolsContext ctx) {
   String ink = getInk( ctx );
   System.out.println( "eexitCompSymbols: "+ink);
}	



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
//               BINARY OPERATIONS
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
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

//        SINGLE LETTERS NOT ACTING AS CONTRACTIONS

@Override 
public void enterWord(uebMathParser.WordContext ctx) { 
 int cnt = ctx.getChildCount();
 System.out.println( "EnterWord, cnt: "+cnt+"expr2Count: "+ expr2Count);
}

@Override public void exitWord(uebMathParser.WordContext ctx) {
System.out.println( "ExitWord -- expr2Count: "+ expr2Count);
String ink = conCat( ctx, "word", true );
System.out.println( "ExitWord -- ink: "+ink );
 setInk( ctx, ink );
}
@Override 
public void enterSingleLetter(uebMathParser.SingleLetterContext ctx) { 
}
@Override 
public void exitSingleLetter(uebMathParser.SingleLetterContext ctx) {
   String brl = ctx.getText();
   System.out.println( "exitSingleLetter braille: "+brl );
   //Assume just a letter MI if in an expression
   if (expr2Count <= 0) System.out.println( "exitSingleLetter -- not expr???");
   String ink = backALetter( brl );
   System.out.println( "exitSingleLetter ink: "+ink );
   StringBuilder mink = new StringBuilder( mi );
   mink.append( ink );
   mink.append( xmi );
   setInk( ctx, mink.toString() );
} 
	
String backALetter( String brl ){
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