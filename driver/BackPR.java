package org.dotlessbraille.antlr4;
//import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.tree.*;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;

//import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.dotlessbraille.transtables.KeepTrack;
import org.dotlessbraille.transtables.SymbolsSequence;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.manifold.LineNumberProvider;
import org.dotlessbraille.manifold.LineNumberTracker;
import org.dotlessbraille.manifold.KeepTrack2;
import org.dotlessbraille.utilities.Tape6;

/** Main program and Parse tree listener.
*/
class Translator extends simpleParserBaseListener
                         implements LineNumberProvider {

 public static Tape6 myOutput = new Tape6("UEBbaktrans.txt");

 static String[] ruleNames;
 static boolean showRuleNames;

 static boolean printTree              = true;
 static boolean debugComments          = false;
 static boolean traceStandingAloneWord = true;
 static boolean trace                  = true;
 static boolean numDebug               = false;
 static boolean printInputText         = false;
 static boolean skipItem               = true;
 static boolean ignoreComments         = false;
 static boolean debug                  = false;
 // static boolean inNemMath = false;
 
 static boolean numLineCont = false;  //FIX THIS!!!
 static boolean hideSep = false;

 static void setRuleNames( ){
    ruleNames = simpleParser.ruleNames;
    if (!showRuleNames) return;
    for (int rn=0; rn<ruleNames.length; rn++){
      System.out.println( "Rule: "+rn+" "+ruleNames[rn] );
    }
  }
     
 

   KeepTrack statusManager;
   BufferedTokenStream allTokens; //Support comment channel
   TokenStreamRewriter rewriter;
   LineNumberTracker lnt;
   SymbolsSequence symSeq;
   //int lineNumber;

   Translator( KeepTrack statusManager, 
               BufferedTokenStream allTokens) {
    this.statusManager = statusManager;
    this.allTokens = allTokens;
    rewriter = new TokenStreamRewriter( allTokens );
    symSeq = new SymbolsSequence();
    //lineNumber = 0;
   }

    //Insist on only one tracker???
   public void addTracker( LineNumberTracker lnt ){
    this.lnt = lnt;
   }



//  ===========BACKTRANSLATION ANNOTATIONS SAVED HERE============
/**   See v4 Ref. p. 123   ParserTreeProperty is an 
    ANTLR helper class that uses an
    IdentityHashMap to store the annotation 
    results for **specific** nodes, i.e.
    not just nodes with the same context.
*/
      // "ink" is back-translation
    ParseTreeProperty<String> ink = new ParseTreeProperty<String>();
    void setInk(ParseTree ctx, String s) {ink.put(ctx, s);}
    String getInk(ParseTree ctx) {return ink.get(ctx);}

      //"info" is any optional additional information
    ParseTreeProperty<String> info = new ParseTreeProperty<String>();
    void setInfo(ParseTree ctx, String s) {info.put(ctx, s);}
    String getInfo(ParseTree ctx) {return ink.get(ctx);}
      
//  ========PARSE TREE NODES BACKTRANSLATION STARTS HERE=========
     //  --0. 'text' is name of grammar's root node--
@Override 
 public void enterText( simpleParser.TextContext ctx)  {
   System.out.println();
   System.out.println( "        Starting to annote input: enterText ..." );
   System.out.println( "Input contains: "+ctx.getChildCount()+" lines." );
   if (lnt == null){
    System.out.println( " LOGIC ERROR--No registered LineNumberTracker!" );
    System.exit( 0 );
   }
   lnt.startingFirstLine( 0 );
   int ruleIndex = ctx.getRuleIndex();
   System.out.println( "enterText--ruleName: "+ruleNames[ruleIndex] );
  }

@Override
 public void exitText( simpleParser.TextContext ctx)  {
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

  // 01. -->'line' is phrase name grammar gives to root node children<--
@Override
 public void enterLine( simpleParser.LineContext ctx ){

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
 public void exitLine( simpleParser.LineContext ctx ) {

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

//======================================================
//  Early out-of-date Nemeth backtranslator for
// Nemeth with UEB -- TODO: replace with BackNem
//======================================================
 // Nemeth start and end display indicators *may* be placed
 //on a line by themselves.
@Override 
public void exitNemethStartDisplay(simpleParser.NemethStartDisplayContext ctx) { 
 System.out.println( "\n  Nemeth Start Display Indicator" );
 String brl = ctx.getText();
 System.out.println( "Nem indicator--brl: |"+brl+"|" );
  //Must be consistent with NemethIndicator braille, NOT parser
 String fbrl = "D"+brl; //2 Inds with same braille
 String ink =
   statusManager.backTrans( fbrl, KeepTrack.Trans.NEM_DISPLAY_IND );
 System.out.println( "Nem indicator--ink: "+ink );
 setInk( ctx, ink );
}
@Override 
public void exitNemethStartInline(simpleParser.NemethStartInlineContext ctx) { 
 System.out.println( "\n  Nemeth Start Display Indicator" );
 String brl = ctx.getText();
 System.out.println( "Nem indicator--brl: |"+brl+"|" );
  //Must be consistent with NemethIndicator braille, NOT parser
 //String fbrl = brl; //2 Inds with same braille
 String ink =
   statusManager.backTrans( brl, KeepTrack.Trans.NEM_INLINE_IND );
 System.out.println( "Nem indicator--ink: "+ink );
 setInk( ctx, ink );
}

@Override 
 public void enterNemethGeneric(simpleParser.NemethGenericContext ctx) { 
 System.out.println( "enter Nemeth Generic " );
 System.out.println( "  brl: |"+ctx.getText()+"|");
}
	
@Override 
 public void exitNemethGeneric(simpleParser.NemethGenericContext ctx) { }

@Override
public void exitNemSyms(simpleParser.NemSymsContext ctx) {
  System.out.println( "\n Nemeth Symbols" );
  String brl = ctx.getText();
  System.out.println( "Nem symbols--brl: |"+brl+"|" );
  int cnt = ctx.getChildCount();
  String ink;
  StringBuilder buf = new StringBuilder();
  for (int i=0; i<cnt; i++){
   brl = ctx.getChild(i).getText();
   if (!brl.equals( " .k ")){
    ink = brl;
   } else {
    ink = " = ";
   }
   buf.append( ink );
   setInk( ctx.getChild(i), ink );
  }
  System.out.println( "Print expr: "+buf.toString() );
  setInk( ctx, buf.toString() );
 }

//NEED TO HAVE ITEM THAT IS A COMPLETE "WORD" ???

/**
Normally you would use the generated accessor methods
instead. For example, if you have a rule foo : bar;, 
instead of using
if (fooContext.getChild(1) instanceof BarContext) you would use
 if (fooContext.bar() != null). 
– Sam Harwell Jul 13 '13 at 1:26

  symseq: ( numfrag | item | nemethGeneric )+ ;

*/
//======================================================
// End of early out-of-date Nemeth backtranslator.
//======================================================


@Override
 public void enterSymseq(simpleParser.SymseqContext ctx) { 
  System.out.println( "\n          Starting next symbols-sequence..." );
  symSeq.init();
  int cnt = ctx.getChildCount();
  System.out.println( "Sym-seq child nodes: "+cnt );
  String brl;
  ArrayList <String> theSeq = new ArrayList <String> ();
  //boolean nemGen = false;
 
 List<simpleParser.NemethGenericContext> nemList = ctx.nemethGeneric();
 if (nemList == null){
   System.out.println( "nemList is null" );
 } else {
   System.out.println( "nemList size: "+nemList.size() );
   if (nemList.size()> 0){
    inNemMath = true;
    System.out.println( "1st in list: "+nemList.get( 0 ).getText() );
  }
 }
 
 if (inNemMath) {
   setInk( ctx, "<math>"+ctx.getText()+"</math>" );
   return;
 }
  for (int i=0; i<cnt; i++){
    brl = ctx.getChild(i).getText();
   theSeq.add( brl );
   int pos = i;
    //it should analyze the whole sequence
   //symSeq.analyze( brl, pos );
  }
  System.out.println( "BackPr--to SymbolsSequence.checkSeq()" );
  if (!inNemMath) symSeq.checkSeq( theSeq );
   //it should analyze the whole sequence
  //boolean b = symSeq.result();
 }
@Override
 public void exitSymseq(simpleParser.SymseqContext ctx) { 

  if (inNemMath){
   inNemMath = false;
   return;
  }
  System.out.println( "\n          Concatenating symbols-sequence..." );
  System.out.println( "SymSeq report: "+symSeq.getCnt( ) );
  String brl = ctx.getText();
  System.out.println( "Sym-seq--brl: |"+brl+"|" );
  int cnt = ctx.getChildCount();
  System.out.println( "Sym-seq child nodes: "+cnt );
  String ink;
  StringBuilder buf = new StringBuilder();
  for (int i=0; i<cnt; i++){
   ink = getInk( ctx.getChild(i) );
   System.out.println( "Sym-seq--ink: |"+ink+"|" );
   buf.append( ink );
  }
  setInk( ctx, buf.toString() );
 }
	
  // -->2.0 'numfrag' is one of several types of  
  //        symbols-sequences that can comprise a line-->
  // (Parser grammar knows valid numeric symbols !)
  // This is a complete item.
@Override
 public void exitNumfrag(simpleParser.NumfragContext ctx) {
  System.out.println( "\n          Translating Numfrag" );
  
  int cnt = ctx.getChildCount();
  symSeq.numfragReport( cnt );
  String brl = ctx.getText();
  System.out.println( "    Braille input: "+ brl );
  String ink = null;

    //Check entire sequence first in case it could represent
    //an available Unicode character for vulgar fraction 
    //Parser grammar only returns 1- or 2-char seq??
    //If not backtranslator returns null
  if (brl.length() > 3 ){
    ink = statusManager.backTrans( brl, KeepTrack.Trans.NUMERIC_SEQ );
    if (!ink.equals("")){
     System.out.println( "Is a vulgar fraction." );
     setInk( ctx, ink );
   //statusManager.numfragDone( true ); //ALWAYS TRUE?
     return;
    } else {
     System.out.println( "Input not a vulgar fraction." );
    }
  }

    //Back translate individual symbols
  StringBuilder buf = new StringBuilder();
  //String ink;

  boolean justInd = false;
  int ix = cnt-1;
    //Check for numeric fragment with just a start ind/symbol
  if (cnt == 1){
   justInd = true;
   ix = cnt;
  }
   
  for (int i=0; i<ix; i++){
   brl = ctx.getChild(i).getText();
   //ink = statusManager.numericMode( brl );
   ink =  statusManager.backTrans( brl, KeepTrack.Trans.NUMERIC_SYM,
     ctx.getChild( i ));
   if (ink == null){
        System.out.println( "Numfrag logic error--cannot "+
                            "translate braille: "+ brl );
        ink="|"+brl+"|";
   } else {
       System.out.println( "Numeric fragment--brl: "+brl+" ink: "+ink );
   }
   setInk( ctx.getChild(i), ink );
   buf.append( ink );
  }
   //Last symbol done separately unless only symbol
  
  if (!justInd){
   brl = ctx.getChild( cnt-1 ).getText();   
   ink = statusManager.numfragDone( brl );
   System.out.println( "Numfrag last--brl: "+brl+" ink: "+ink );
   buf.append( ink );
  }
  setInk( ctx, buf.toString() );
 }

@Override
 public void enterStandAloneCon(simpleParser.StandAloneConContext ctx) {
  System.out.println( "->>>enterStandAloneCon" );
 }

@Override 
public void exitStandAloneCon(simpleParser.StandAloneConContext ctx) {
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
 
  /** --2.1 'standingAlone' is one of several types of 
          symbols-sequencrd that can comprise a line--
          Its different types of children are 
          back-translated at their lelvel
 */
@Override
 public void exitStandingAlone(simpleParser.StandingAloneContext ctx){

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

// -->3.0 'preAlone' are optional symbols and indicators whick
//        can precede a standalone letter or letter sequence 
//        Caps word indicator has its own grammar phrase.
@Override 
 public void exitCapsWordInd(simpleParser.CapsWordIndContext ctx) {
  System.out.println( "\n    Handle CapsWordInd before Standing Alone" );
  String brl = ctx.getText();
  String ink =   //statusManager.processIndicators( brl );
   statusManager.backTrans( brl, KeepTrack.Trans.INDICATOR );
  setInk( ctx, ink );
 }

@Override
 public void exitPreAlone(simpleParser.PreAloneContext ctx) { 
     System.out.println(
      "\n           Finish next StandingAlone prefix symbol " );
      //Grammar defines each prefix symbol as a
      //separate node, single token
    String brl = ctx.getText();
    String ink =
     statusManager.backTrans( brl, KeepTrack.Trans.SA_PREFIX );
    //String ink = statusManager.handleSAPrefix( brl );
    System.out.println( "PreAlone brl: "+ctx.getText()+" ink: "+ink);
    setInk( ctx, ink );
}

// -->3.0 'saLetters' is either a single Latin letter (not preceded with a
//        any Grade 1 indicator) that in contracted braille
//        would be backtranslated as a single-letter
//        whole-word contraction or a sequence of such letters that
//        would be backtranslated as a shortform word.<--
@Override 
 public void exitSaLetters(simpleParser.SaLettersContext ctx) {
  if (traceStandingAloneWord){
   System.out.println( "\n           Handle standing alone word"+
    "--exitSaLetters" ); 
   int ruleIndex = ctx.getRuleIndex();
   System.out.println( "  ruleName: "+ruleNames[ruleIndex] );
  }           
  String brl = ctx.getText();
  String ink =
   statusManager.backTrans( brl, KeepTrack.Trans.SA_SEQ );
  if (traceStandingAloneWord){
   System.out.println( "Backtranslated brl: "+brl+" to: "+ink );
   setInk( ctx, ink );
  }
 }

 //Only those shortforms that incorporate other contractions
 //The may need special handling?
@Override
 public void exitShortForms(simpleParser.ShortFormsContext ctx) {
  if (traceStandingAloneWord){
   System.out.println( "\n           Handle shortforms w/ cons" ); 
  }           
  String brl = ctx.getText();
  String ink =
   statusManager.backTrans( brl, KeepTrack.Trans.SA_SEQ );
  if (traceStandingAloneWord){
   System.out.println( "Backtranslated brl: "+brl+" to: "+ink );
   setInk( ctx, ink );
  }
 }
 //Special case in parser as of 4/21/18, probably not necessary
@Override 
 public void exitStrong_ws(simpleParser.Strong_wsContext ctx) {
  if (traceStandingAloneWord){
   System.out.println( "\n           Handle strong wordsigns" ); 
  }           
  String brl = ctx.getText();
  String ink =
   statusManager.backTrans( brl, KeepTrack.Trans.SA_SEQ );
  if (traceStandingAloneWord){
   System.out.println( "Backtranslated brl: "+brl+" to: "+ink );
   setInk( ctx, ink );
  }
 }


// -->3.2 'postAlone' are optional symbols and indicators which
//        can follow a standalone letter or letter sequence 
@Override 
 public void exitPostAlone(simpleParser.PostAloneContext ctx) { 
 System.out.println( "\n    ***exitPostAlone***" );
 String brl = ctx.getText();
    String ink =
     statusManager.backTrans( brl, KeepTrack.Trans.SA_POSTFIX );
 //String ink = statusManager.handleSAPostfix( brl );
 System.out.println( "PostAlone brl: "+brl+
                      " ink: "+ink);
 setInk( ctx, ink );
}

@Override
 public void enterItem(simpleParser.ItemContext ctx) { 
  //With a bit of change in the parser we can use enterItem to keep track of
  //the start and end of the "word" portion of an item
  //so as to deal with context-dependent contractions!!!
 }

           //      ****EVERYTHING ELSE**** 
// --> An 'item' consists of any number of arbitrary prefix-root 
//     or root-only symbols or rootless symbols that the parser 
//     doesn't treat recognize more specifically.  It may or
//     not be an actual UEB symbol and/or in a grammatically
//     valid context.
//
@Override 
 public void exitItem( simpleParser.ItemContext ctx ) {
  if( inNemMath) return;
  System.out.println( "\n***exitItem***" );

  //No need to check as max scope is item (NOT CONTINUED)
  //capWordInd = false;

//Children all back-translated at lower level  
  int cnt = ctx.getChildCount();
  System.out.println( "Item count: "+cnt+
    " text: "+ctx.getText() );
  StringBuilder itemTrans = new StringBuilder();
  String ink;
  for (int i=0; i<cnt; i++){
    ink = getInk( ctx.getChild(i) );
    itemTrans.append( ink );
  }

//This only appropriate if item has no pre or post???
     // Add LIFO stack of any remaining end tags 
     // for TF Word indicators
     String after =
      statusManager.backTrans( "", KeepTrack.Trans.IF_AFTER ); 
     if (after != null) {
      itemTrans.append( after );
     }
     System.out.println( "itemTrans: "+itemTrans.toString() );
     setInk( ctx, itemTrans.toString() );
  return;
}

@Override
 public void exitRootlessToken(simpleParser.RootlessTokenContext ctx) { 
  System.out.println( "\n  Starting rootlessToken" );
  int cnt = ctx.getChildCount();
  String brl = ctx.getText();
  System.out.println( "Item count: "+cnt+" text: "+brl );
  String ink = //statusManager.backTransToken( brl );
       statusManager.backTrans( brl, KeepTrack.Trans.INDICATOR );
  System.out.println( "Returned ink: |"+ink+"|" );
  setInk( ctx, ink );
}


@Override 
 public void exitPr_token(simpleParser.Pr_tokenContext ctx) { 
  if (inNemMath) return;
  System.out.println( "\n    ***starting exitPr***" );
  System.out.println( "Rule index: "+ctx.getRuleIndex() );
  int cnt = ctx.getChildCount();
  //for (int i = 0; i<cnt; i++){
   //RuleContext rtx = ctx.getChild(i);
   //int r = rtx.getRuleIndex();
   //System.out.println( "Child: "+i+" rule: "+ruleNames[r] );
  //}
  String brl = ctx.getText();
  System.out.println( "Item count: "+cnt+" text: "+brl );
  String ink = //statusManager.backTransToken( brl );
       statusManager.backTrans( brl, KeepTrack.Trans.GENERIC_TOKEN,
        symSeq );
  System.out.println( "pr_token Translated as: "+ink );
  setInk( ctx, ink);
}//End exitPr

//Trailing separator is parent of separator used to distinguish
// separators at end of line -- lower levels do actual 
// backtranslation
 @Override
 public void exitTrailingSep(simpleParser.TrailingSepContext ctx) {
	 
 System.out.println( "\n   ***TrailingSep***" );
  int cnt = ctx.getChildCount();
  //if (!hideSep)
   System.out.println( "Trailng separator count: "+cnt+
                       " text: |"+ctx.getText()+"|" );
  String ink;
  StringBuilder buf = new StringBuilder();
  
  for (int i=0; i<cnt; i++){
   ink = getInk( ctx.getChild(i) );
   buf.append( ink );
  } 
  setInk( ctx, buf.toString() );
}
@Override
 public void exitSeparator(simpleParser.SeparatorContext ctx) { 
 if (!hideSep) System.out.println( "\n***exitSeparator***" );
  int cnt = ctx.getChildCount();
  if (!hideSep)
   System.out.println( "Separator count: "+cnt+
                       " brl: |"+ctx.getText()+"|" );
  String ink;
  StringBuilder buf = new StringBuilder();
   //Process each token in this item
  for (int i=0; i<cnt; i++){
   String brl = ctx.getChild(i).getText();
   if (!hideSep)
    System.out.println( "\n  Item no. "+i+" brl: |"+brl+"|" );
   ink = statusManager.backTrans( brl, KeepTrack.Trans.SEPARATOR );
   System.out.println( "\n  Item no. "+i+" ink: |"+ink+"|" );
  //backTransSeparator( brl );
   //setInk( ctx.getChild(i), ink );
   buf.append( ink );
  }
  setInk( ctx, buf.toString() );
}
/**
//Insert print spaces for braille spaces
//@Override
 public void exitSpace( simpleParser.SpaceContext ctx) {
   //System.out.println( " Inserting a print space. ");
   //setInk( ctx, " " );
*/
//Concantenates in input order previously determined translations
//(saved as annotations) of all the child nodes of the input node.
public void concat( ParserRuleContext ctx ){
 StringBuilder buf = new StringBuilder();
 int cnt = ctx.getChildCount();
  for (int i=0; i<cnt; i++){
    String ink = getInk( ctx.getChild(i) );
    buf.append( ink );
  }
  setInk( ctx, buf.toString() );
}
  String lineComment( simpleParser.LineContext ctx,
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

}//End Inner Class Translator.

//===========================================================
  public static void main( String[] args ) throws Exception {
//===========================================================

 System.out.println( "\n    Welcome to Basic UEB backtranslator!" );
 System.out.println( "      Uses ANTLR 4.7.1 for parsing." );

 String inputFile = null;
 CharStream input = null;
 if ( args.length > 0 ) inputFile = args[0];
 if (inputFile == null){
    System.out.println( "\n    -->Enter North Am. ASCII Braille; "+
                        "use small letters." );
    System.out.println( "    -->End input with CTRL-z "+
                      "as only symbol on last line.\n" );
    Reader myReader = new InputStreamReader( System.in, "UTF-8");
    CodePointCharStream cpcs = CharStreams.fromReader( myReader );
    input = cpcs;
 } else {
    File f = new File( inputFile );
    if (f.exists() && !f.isDirectory() )  {
       input = CharStreams.fromFileName( inputFile );
    } else {
       System.out.println( "\n OOPS! Cannot find input file: "
                           +inputFile );
       System.exit( 0 );
    }
  }

/**  I. Connect lexer and parser and instruct parser to
        build a parse tree.  
*/
        simpleLexer lexer = new simpleLexer( input );

        //  Supposedly allows parser to re-write its output
        //CommonTokenStream tokens = new TokenRewriteStream(lexer);
        CommonTokenStream tokens = new CommonTokenStream( lexer );

        simpleParser parser = new simpleParser( tokens ); 
        parser.setBuildParseTree( true );
		
/**  II. Start tree with the topmost rule in the Parser 
         grammar.  (Rule #0 if grammar starts with that one.)
*/
         ParseTree tree = parser.text();
         if (printTree){
           System.out.println( "     PARSE TREE: ");
           System.out.println( 
	                 tree.toStringTree( parser ));
           System.out.println();
           String x = tree.toStringTree( parser);
           System.out.println( wrap( x, 40) );
         }

    //System.out.println( "(text\n "+" (line\n "+"  (item\n " );
    // Optionally print tree in text form
    //if (printTree) System.out.println( "      "+
	               //tree.toStringTree(parser).substring(17));
    //prettyPrint( tree.toStringTree( parser ));

/**  III. Insert logic to walk and annotate tree here....*/

          PendingCapInds capInfo = new PendingCapInds();
          boolean uncontracted = true;   //SHOULD BE AN OPTION SOON

       //Communication point for backtranslation
          KeepTrack kt = new KeepTrack( capInfo, uncontracted, 0 );
          kt.makeTables( false, false );
           //Back translator, i.e. annotator, must extend baseListener 
          Translator bt = new Translator( kt, tokens );
          KeepTrack2 kt2 = new KeepTrack2( bt );
          BackPR.setRuleNames();
     
     ParseTreeWalker walker = new ParseTreeWalker();
     walker.walk(bt, tree);

/**  IV. Display backtranslation  */

     System.out.println();
     System.out.println( "      ***Backtranslation***" );
     System.out.println(" Back-translated print input from annotated tree: ");
     System.out.println( bt.getInk( tree ) );
     myOutput.println( bt.getInk( tree ) );
     myOutput.finish( );
 }//End Main.//

//================================================
//        Methods to display tree
//================================================

private static final String linebreak = "\n"; // or "\r\n";

  //Found on stack (lost link, thanks whoever!)
public static String wrap(String string, int lineLength) {
    StringBuilder b = new StringBuilder();
    for (String line : string.split(Pattern.quote(linebreak))) {
        b.append(wrapLine(line, lineLength));
    }
    return b.toString();
}

private static String wrapLine(String line, int lineLength) {
    if (line.length() == 0) return linebreak;
    if (line.length() <= lineLength) return line + linebreak;
    String[] words = line.split(" ");
    StringBuilder allLines = new StringBuilder();
    StringBuilder trimmedLine = new StringBuilder();
    for (String word : words) {
        if (trimmedLine.length() + 1 + word.length() <= lineLength) {
            trimmedLine.append(word).append(" ");
        } else {
            if (trimmedLine.toString().startsWith( "(item" )){
              trimmedLine = trimmedLine.insert( 0, " " );
            }
            allLines.append(trimmedLine).append(linebreak);
            trimmedLine = new StringBuilder();
            trimmedLine.append(word).append(" ");
        }
    }
    if (trimmedLine.length() > 0) {
        allLines.append(trimmedLine);
    }
    allLines.append(linebreak);
    
    
    return allLines.toString();
}
}//End Outer Class BackPR.