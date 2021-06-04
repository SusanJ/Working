package org.dotlessbraille.transtables;

//import java.util.Stack;
//import org.dotlessbraille.indicatoruse.CapsHandler;
//import org.dotlessbraille.indicatoruse.TypeformsHandler;

import org.antlr.v4.runtime.tree.ParseTree;

import org.dotlessbraille.indicatoruse.BackInd;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.InitializeIndicators;
//import org.dotlessbraille.jsonInput.ReadJS;
import org.dotlessbraille.manifold.KeepTrack2;

// This class manages  backtranslation of symbols and any 
//communication with BackInd

public class KeepTrack{ 
 
 //  Tree walker uses these enums to request appropriate
 // backtranslation process based on parser grammar         
 public enum Trans { SA_PREFIX, SA_SEQ, SA_POSTFIX, INDICATOR, 
                     NUMERIC_SEQ, NUMERIC_SYM, LAST_NUMERIC_SYM,
                     IF_AFTER, EOL_AFTER, GENERIC_TOKEN, SEPARATOR,
                     NEM_DISPLAY_IND, NEM_INLINE_IND }

  //Uncontracted braille uses no contractions
  //Grade 1 is a mode in contracted braille
 public static boolean uncontracted = true;

 public static String g1SpecBrl = ";;;;";
 public static String g1SymInd = ";";
 
 boolean showUseDLinInk = true;
 boolean showMenDLinInk = true;

 boolean trace = true;
 boolean traceG1 = true;
 boolean traceNum = false;
 boolean traceSA = false;
 boolean traceAfter = false;

 //boolean nummode = false;
 //boolean defaultUEB = true;
 //boolean dlMention = false;
 //boolean lastWasSubSup = false;

 boolean wwContractions = true;
 boolean showDL = true;
 
 PendingCapInds capInfo;
 LetterBT letterBT;
 SALetterBT saLetterBT;
 //CapsHandler capsHandler;

 BackInd backInd;
 Info4KT info4KT = new Info4KT();
 ContractionHandler conHandler;
 

     //====Constructor====//
 
 public KeepTrack( PendingCapInds capInfo,
                   boolean isUncontracted,
                   int linesDone ){


  this.capInfo = capInfo;
  this.letterBT = new LetterBT( capInfo );
  this.saLetterBT = new SALetterBT( capInfo, traceSA );
  //capsHandler = new CapsHandler( capInfo );
  conHandler = new ContractionHandler( capInfo );
  setUncon( isUncontracted );
  Info4KT.setLinesDone( linesDone );
  backInd = new BackInd ( capInfo,
                          isUncontracted );
 }

           //**Communication**//

public void incrementLinesDone(){
 Info4KT.incLinesDone();
}
public int getLinesDone(){
 return Info4KT.getLinesDone();
}
public int getCurrentLineNumber(){
 return getLinesDone()+1;
}

void setLastWasSubSup( boolean toSet ){
 System.out.println( "KT--Set lastWasSubSup: "+toSet );
 KeepTrack2.setLastWasSubSup( toSet );
}

static void setUncon( boolean isUncon ){
  uncontracted = isUncon;
}
static boolean getUncon(){
 return uncontracted;
}
static boolean isContracted(){
 return !uncontracted;
}

private void separatorEncountered( boolean isSep ){
 capInfo.separatorEncountered( isSep );
 KeepTrack2.separatorEncountered();
}
private String spaceEncountered( String ink ){
 KeepTrack2.spaceEncountered( ink );
 StringBuilder after = new StringBuilder();

 //String endTag = SubSupIndicator.spaceEncountered();
 String endTag = info4KT.spaceEncountered4SS();
 System.out.println( "KT.spaceEnc. -- SS endTag: "+ endTag );
 if (endTag != null) after.append( endTag );

 //String tfEndStack = TypeformsHandler.tfEndTagsAfterWord();
 String tfEndStack = info4KT.tfEndTagsAfterWord();
 if (tfEndStack != null) after.append( tfEndStack );
 after.append( ink );
 return after.toString();
}
private void spaceEncountered(){
 KeepTrack2.spaceEncountered();
 System.out.println( "Space encountered...." );
 capInfo.separatorEncountered( true );
 //info4KT.spaceEncountered4G1();
 //Grade1Indicator.spaceEncountered();
}

private String afterSymbol(){
 String ink = info4KT.tfAfterSymbol();
 //String ink = TypeformsHandler.afterSymbol();
 //return TypeformsHandler.afterSymbol();
 return ink;
}

 //   A subscript or superscript indicator
 // can be terminated by the close enclosure symbol
 // that matches any open one immediately
 // following the indicator.  It is also
 // terminated by the end of a numeric item or a space.
 // (There are additional possibilites for technical
 // material not addressed here.)
 //  If subsub start just encountered checks for
 // open fence and supplies matching close
private void updateSubSup( String brl ){
 System.out.println( "KT updateSS lastWasSubsup: "+
 KeepTrack2.getLastWasSubSup() );
 if (!KeepTrack2.getLastWasSubSup()) return;
 System.out.println( "KT: updateSS brl: "+brl );
 String close = Punctuation.ifPreGetPost( brl );
 if (close != null){
  System.out.println( "matching close: "+close );
  //SubSupIndicator.setWaitingFor( close );
  info4KT.setWaitingFor( close );
 }
 //lastWasSubSup = false;
 setLastWasSubSup( false );
}

 //Checks whether the just-translated input is
 //the matching close indicator for a
 //pending (single-level) subscript or superscript
private String finishSubSup( String brl ){
 //return SubSupIndicator.getAfterTag( brl );
 return info4KT.getAfterTagSS( brl );
}
private void finishSubSup( ){
 //if (!SubSupIndicator.subSupIsPending()) return;
 if (!info4KT.subSupIsPending()) return;
}

public String backTrans( String brl, Trans btMethod, ParseTree ctx ){
  return backTrans( brl, btMethod );
}

     //Invoked by tree walker
  // Last numeric character, backtrans and check
  //if it terminates a script
public String numfragDone( String brl ){
 String ink = UpperNumber.getInk( brl );
 if (ink == null) return null; //Shouldn't happen?
    //String tag = SubSupIndicator.afterNumfrag();
 KeepTrack2.numfragDone();
 String tag = info4KT.afterNumfrag();
 if (tag == null) return ink;
 StringBuilder buf = new StringBuilder( ink );
 return buf.append( tag ).toString();
}

/** ***********************************************
     Main entry point for all backtranslation of
    braille symbols 
     Uses information (via btMethod) supplied by 
    parse tree walker to choose appropriate method
     Symbols that are found to be indicators
    are passed to the indicator logic in BackInd  
    by the method responsible for backtranslating 
    non-indicators symbols in the category
   *************************************************
*/
public String backTrans( String brl, Trans btMethod, 
                        SymbolsSequence symSeq ){

    initBackTrans( brl, btMethod );
    if (btMethod == Trans.GENERIC_TOKEN){
      String ink =  backInd.processIndicators( brl );
      //System.out.println( "KeepTrack bt token: |"+ink+"|");
      if (ink != null) {
        symSeq.prTokenGotInd( ink );
        return ink;
      }
      return addAfter( backTransToken( brl, symSeq ), brl );
    } else {
      System.out.println( "KT LOGIC ERROR, not GENERIC_TOKEN" );
      System.exit( 0 );
    }
  return (String) null;
}

void initBackTrans( String brl, Trans btMethod ){
 KeepTrack2.checkNumMode( brl );
 KeepTrack2.checkSpecialG1Mode( brl );
 if (traceG1){ 
   boolean inGrade1Mode = KeepTrack2.useGrade1();
   if (inGrade1Mode){
     System.out.println( "KT.backTrans()--G1 mode is active. " );
   }
  }

  //IF_AFTER should go somewhere else ?
 if (btMethod != Trans.IF_AFTER ){
  if (KeepTrack2.getLastWasSubSup()) updateSubSup( brl );
 }

}
public String backTrans( String brl, Trans btMethod ){

 initBackTrans( brl, btMethod );

 switch (btMethod){
  case SA_PREFIX:
    //Standalone uses strict parser grammar, might be a start ind.
   if (trace) System.out.println(  "KT.backTrans()--SA_PREFIX" );
   Indicator indToken = checkSAPrefix( brl );
   if (indToken != null) return saPrefixInd( indToken );
   return addAfter( handleSAPrefix( brl ), brl );
  case SA_SEQ:
   return addAfter( backTransSAseq( brl ), brl );
  case SA_POSTFIX:
   indToken = checkSAPostfix( brl );
   if (indToken != null) return saPostfixInd( indToken );
   //System.out.println(  "KT.backTrans()--SA_POSTFIX INDY???" );
   return addAfter( handleSAPostfix( brl ), brl );
  case INDICATOR:
   return backInd.processIndicators( brl );
  case NEM_DISPLAY_IND:
  case NEM_INLINE_IND:
   System.out.println( "KeepTrack--going to process Nemeth ind." );
   return backInd.processIndicators( brl );
  case NUMERIC_SEQ:  // Check for "vulgar fraction"  
   return tryVulgFrac( brl );
  case NUMERIC_SYM:
   if (traceNum) System.out.println( "Keeptrack bt -- numericMode()");
   return numericMode( brl );
  case IF_AFTER:
   return afterSymbol( );
  case EOL_AFTER:
      //String ssEnd = SubSupIndicator.afterAtEOL();
   String ssEnd = info4KT.afterAtEOL();
   return info4KT.tfAfterAtEOL( ssEnd );
   //return TypeformsHandler.afterAtEOL( ssEnd );
  //case GENERIC_TOKEN:
   //String ink =  backInd.processIndicators( brl );
     //System.out.println( "KeepTrack bt token: |"+ink+"|");
   //if (ink != null) return ink;
   //return addAfter( backTransToken( brl ), brl );
  case SEPARATOR:
   return backTransSeparator( brl );
 }
  System.out.println( "KeepTracd.BackTrans() **ERROR** did not handle: "+
   btMethod );
  return "";
}
  

    //IMPROVE THIS
String brlDots( String brl ){
 return "[sim]"+brl+"[sim]";
}

// For end tags added after just done symbol 
// when context ends scope  --  all SYMBOL scoped
// typeform and possibly script

private String addAfter( String ink, String brl ){
 KeepTrack2.cancelG1SymbolMode();
 String after = finishSubSup( brl ); //script end tag
 if (traceAfter){
  System.out.println( "KT--addAfter: |"+after+"| brl:"+brl );
 }
 StringBuilder buf = new StringBuilder();
 if (after != null){
  buf.append( ink );
  buf.append( after );
  after = afterSymbol(); //Any TF end tags
  if (after != null){
   return buf.append( after ).toString();
  } else {
   return buf.toString();
  }
 }
 after = afterSymbol(); //No subsup, any TF end tags?
 if (after == null) return ink;
 buf.append( ink );
 return buf.append( after ).toString();
}

            //**Numeric mode**//

  /** The parser grammar recognizes this sequence as 1. numeric mode.
  numind: ((DOTS3456) (updigs| DOT2 | DOTS256 )); 
  numfrag: numind (updigs | DOT2 | DOTS256 | DOTS34 | numspacedig )*;

    There seems to be other numeric cases not addressed here.
  2. Numeric passage/terminator Rulebook Sec. 6.9
      Mainly used for worked examples
      Sets grade 1 (no contractions). Anyetters a-j 
      must each[?] a leading dots-56.
  3. The spaced numeric indicator
   TODO set special g1 mode
  */

private String tryVulgFrac( String brl ){
 String ink = UpperNumber.getVFrac( brl );
 if (traceNum) System.out.println( "KT:numMode -- vfrac ink: "+ ink );

 if (ink != null){
  info4KT.setLastWasVulgarFraction();
  if (traceG1) 
   System.out.println( "G1 mode set by numeric mode start." );
  KeepTrack2.setNumericMode( true );
  backInd.processIndicators( g1SpecBrl );
  return ink;
 } else {
  return "";
 }
}

private String numericMode( String brl ){

 if (KeepTrack2.getDlMention( )) return handleMention( brl );

 //  "Vulgar fractions" need to be backtranslated in
 //   entirety but always start with a numeric indicator.
 //  Not clear if they can end a sub-sup
 //  RuleBook 11.3.2 Mixed numbers should be treated as 
 //two unspaced numeric items. The fraction part is
 //sometimes a vulgar fraction in print. Could a
 //mixed number be used as a subscript or superscript?
 //    x<sup>21/2</2) where the 1/2 is a single character

 Indicator ind = backInd.check4Ind( brl );
 if (traceNum){
  System.out.println( "KT nummode--brl, ind: "+brl+" "+ind );
 }
 // Note that some numeric symbols just represent numeric
 //signs in print but the 12 basic numeric (start) indicators
 //are both indicators and for numeric signs; these are addressed here.
 if (ind != null){
    boolean upNum = backInd.handleNumericIndicator( brl, ind );
 }
 //Just a numeric symbol, not (also) an indicator
 return UpperNumber.getInk( brl );
}

          //***Standing Alone***//
  //Parser recognizes standing alone constructs
  // (Not essential for uncontracted braille but
  //  simpler to support both with same grammar.)

  //  Symbols allowed before letter(s) that
  //are considered to be "standing alone"
 private Indicator checkSAPrefix( String brl ){
  Indicator ind = backInd.check4Ind( brl );
  return ind;
 }
 private String  saPrefixInd( Indicator ind ){
   //capInfo.notALetter( brl );
   String fromInd = backInd.handleIndicator( ind );
   System.out.println( "KT.handleSAPre--fromInd: "+fromInd );
   return fromInd;
 } 

  //Prefix can contain indicators as well as symbols
  //Taken care of by backTrans entry point
 private String handleSAPrefix( String brl ){
  if (KeepTrack2.getDlMention()) return handleMention( brl );
  return StandingAlone.backPre( brl );
 }

  //A Latin letter or a sequence corresponding to a
  //shortform that is "standing alone"
  //G1--Affected by a pending g1 start indicator
  // FIX CON/UNCON flag???
 private String backTransSAseq( String brl ){
  if (KeepTrack2.getDlMention()) return handleMention( brl );
  String ink = saLetterBT.backTransLetter( brl, wwContractions );
    //  Per the parser grammar this is the entire sequence and thus  
    // the last of any (print) letters before the postfix or separator. 
    // Any non-alphabetic symbols are part of the allowed postfix.
  capInfo.clearCapWordInd();
  return ink;
  }
  
  //   Symbols, including certain indicators,
  // allowed after possible whole word and
  // shortform contractions that
  // are considered to be "standing alone"
 private Indicator checkSAPostfix( String brl ){
  Indicator ind = backInd.check4Ind( brl );
  return ind;
 }
private String saPostfixInd( Indicator ind ){
   String fromInd = backInd.handleIndicator( ind );
   System.out.println( "KT.handleSAPosts--fromInd: "+fromInd );
   return fromInd;
 } 
private String handleSAPostfix( String brl ){
  //Indicator ind = backInd.check4Ind( brl );
  //if (ind != null) return backInd.handleIndicator( ind );
  if (KeepTrack2.getDlMention()) return handleMention( brl );
  return StandingAlone.backPost( brl );
 }

        // ***Generic token per parser grammar*** //
        // Indicator check handled by caller 
 private String backTransToken( String brl, SymbolsSequence symSeq ) {
 
 if (KeepTrack2.getDlMention()) return handleMention( brl );

   //I think rootless token takes care of this now???
 //Most prefix root symbols are a single braille symbol
 //but might also be a one-cell symbol indicator
 //followed by a one-cell symbol???
  if (brl.length() == 1){
   String pre = brl.substring(0,1);
   if (pre.equals( g1SymInd )){
    
    //do something
   }
  }

  String ink;
  boolean isAPrepunc = Punctuation.isPrePunc( brl );
  if (isAPrepunc){
   String pre = Punctuation.getPrePunc( brl );
   System.out.println( "KT--PR got PrePunc: "+pre );
   symSeq.prGotPrepunc( brl, pre );
   return pre;
  }
  boolean isALetter = Letter.isLetter( brl );

  if (isALetter){
   if (trace){
    System.out.println( "KeepTrack, will try input: "+
                         brl+" as letter." );
    }
  //  FIX ??? G1--Affected by a pending g1 start indicator
  ink = backTransLetter( brl );
  if (ink != null) return ink;
  }

  if (trace){
    System.out.println( 
     "KeepTrack, not letter trying new con. handler." );
  }
  ink= conHandler.backTransCon( brl, PartWordUse.ANYWHERE );
  if (ink != null) return ink;

  capInfo.notALetter( brl );
  ink = anyPunc( brl );
  if (ink == null){
   System.out.println( "KeepTrack--WARNING: cannot backtrans "+
     "braille token: "+brl );
   }
  return ink;
}

//Letter translator gets latest cap ind info
//G1--Affected by a pending g1 start indicator
 private String backTransLetter( String brl ){
   String ink = letterBT.backTransLetter( brl );
   boolean ok = true;
   if (ink == null){
    ok = false;
   }
   capInfo.handleLetterTransInfo( ok );
   return ink;
}

private String handleMention( String brl ){
  KeepTrack2.setDlMention( false );  //ASSUMED SCOPE
  return brlDots( brl );
}

private String anyPunc( String brl ){
 return Punctuation.getAnyPunc( brl );
}

// if we try upper numbers and it fails then what
//  could be a g1 prefix to a-j in letters or
//pretty much anything else



private String backTransSeparator( String brl ){
 if (KeepTrack2.getDlMention() ) return handleMention( brl );
 String ink = Separator.backTrans( brl );
 if (ink == null) return ink;

 if (ink.equals( " ")){
   //Informs before inserting space
  String upInk = spaceEncountered( ink );
  System.out.println( "KT.BackTransSep upink |"+upInk+"|");
  return upInk;
 } else {
   separatorEncountered( true );
 }
 return ink;
}
public static void makeTables( boolean report, boolean display ){ 
 InitTranstables.makeTables( report, display );
 InitializeIndicators.makeIndicators( report,
                  display, g1SymInd );
} 

}//End Class.

