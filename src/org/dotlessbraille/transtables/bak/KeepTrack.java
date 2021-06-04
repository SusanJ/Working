package org.dotlessbraille.transtables;

import java.util.Stack;
import org.dotlessbraille.indicatoruse.BackInd;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.indicatoruse.CapsHandler;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicatoruse.TypeformsHandler;
import org.dotlessbraille.indicators.InitializeIndicators;

//Should be implementing Status??
//Working on single point of inter-token communication
// This class manages all backtranslation and any 
//communication among symbols

public class KeepTrack{ 
 
 // Tree walker uses these enums to request appropriate
 //backtranslation            
 public enum Trans { SA_PREFIX, SA_SEQ, SA_POSTFIX, INDICATOR, 
                     NUMERIC_SEQ, NUMERIC_SYM, LAST_NUMERIC_SYM,
                     IF_AFTER, EOL_AFTER, GENERIC_TOKEN, SEPARATOR }

 //static String brlOpenGroup = "<";
 //static String brlCloseGroup = ">";

  //Uncontracted braille uses no contractions
  //Grade 1 is a mode in contracted braille
 public static boolean uncontracted = true;

 public static String g1SpecBrl = ";;;;";
 public static String g1SymInd = ";";
 //boolean trace = true;
 boolean showUseDLinInk = true;
 boolean showMenDLinInk = true;
 
 LetterBT letterBT;
 SALetterBT saLetterBT;
 PendingCapInds capInfo;
 CapsHandler capsHandler;

 boolean traceG1 = true;
 boolean nummode = false;
 boolean defaultUEB = true;
 boolean trace = true;
 boolean wwContractions = true;
 boolean dlMention = false;
 boolean showDL = true;
 boolean lastWasSubSup = false;

 //private boolean isOpenEncl( String brl ){
  //return false;
 //}
 //private boolean isCloseEncl( String brl ){
  //return false;
 //}

BackInd backInd;
Info4KT info4KT = new Info4KT();

     //====Constructor====//
 
 public KeepTrack( PendingCapInds capInfo,
            boolean isUncontracted ){
  this.capInfo = capInfo;
  this.letterBT = new LetterBT( capInfo );
  this.saLetterBT = new SALetterBT( capInfo );
  capsHandler = new CapsHandler( capInfo );
  setUncon( isUncontracted );
  backInd = new BackInd ( capInfo,
                          isUncontracted );
 }

           //**Communication**//

void setLastWasSubSup( boolean toSet ){
 System.out.println( "KT--Set lastWasSubSup: "+toSet );
 lastWasSubSup = toSet;
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
}
private String spaceEncountered( String ink ){
 StringBuilder after = new StringBuilder();
 //String endTag = SubSupIndicator.spaceEncountered();
 String endTag = info4KT.spaceEncountered4SS();
 System.out.println( "KT.spaceEnc. -- SS endTag: "+ endTag );
 if (endTag != null) after.append( endTag );
 String tfEndStack = TypeformsHandler.tfEndTagsAfterWord();
 if (tfEndStack != null) after.append( tfEndStack );
 after.append( ink );
 return after.toString();
}
private void spaceEncountered(){
 System.out.println( "Space encountered...." );
 capInfo.separatorEncountered( true );
 info4KT.spaceEncountered4G1();
 //Grade1Indicator.spaceEncountered();
}

private String afterSymbol(){
 String ink = TypeformsHandler.afterSymbol();
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
 System.out.println( "KT updateSS lastWasSubsup: "+ lastWasSubSup );
 if (!lastWasSubSup) return;
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
 //pending script
private String finishSubSup( String brl ){
 //return SubSupIndicator.getAfterTag( brl );
 return info4KT.getAfterTagSS( brl );
}
private void finishSubSup( ){
 //if (!SubSupIndicator.subSupIsPending()) return;
 if (!info4KT.subSupIsPending()) return;
}


  //Last numeric character, backtrans and check
  //if it terminates a script
public String numfragDone( String brl ){
 String ink = UpperNumber.getInk( brl );
 if (ink == null) return null;
 //String tag = SubSupIndicator.afterNumfrag();
 String tag = info4KT.afterNumfrag();
 if (tag == null) return ink;
 StringBuilder buf = new StringBuilder( ink );
 return buf.append( tag).toString();
  //Imaginary token used to ensure g1 flags set
 //processIndicators( g1SpecBrl );

}


//***********************************************
   // Main entry point for all backtranslation of
   //braille symbols that represent print signs
   //Uses information supplied parse tree walker
   // Items that might possibly be indicators
   //passed to the indicator logic by the 
   //relevant item method
//***********************************************
public String backTrans( String brl, Trans btMethod ){

  System.out.println( "KT.backTrans()--Some G1 mode active: "+
  //Grade1Indicator.useGrade1() );
  info4KT.useGrade1() );
  //IF_AFTER should go somewhere else
 if (btMethod != Trans.IF_AFTER ){
  if (lastWasSubSup) updateSubSup( brl );
 }
 switch (btMethod){
  case SA_PREFIX:
    //Standalone is strict grammar, might be a start ind.
   System.out.println(  "KT.backTrans()--SA_PREFIX" );
   Indicator indToken = checkSAPrefix( brl );
   if (indToken != null) return saPrefixInd( indToken );
   return addAfter( handleSAPrefix( brl ), brl );
  case SA_SEQ:
   return addAfter( backTransSAseq( brl ), brl );
  case SA_POSTFIX:
   return addAfter( handleSAPostfix( brl ), brl );
  case INDICATOR:
   return backInd.processIndicators( brl );
  case NUMERIC_SEQ:  // Check for "vulgar fraction"
   return numericMode( brl );
  case NUMERIC_SYM:
   return numericMode( brl );
  case IF_AFTER:
   return afterSymbol( );
  case EOL_AFTER:
   //String ssEnd = SubSupIndicator.afterAtEOL();
   String ssEnd = info4KT.afterAtEOL();
   return TypeformsHandler.afterAtEOL( ssEnd );
  case GENERIC_TOKEN:
   String ink =  backInd.processIndicators( brl );
   //System.out.println( "KeepTrack bt token: |"+ink+"|");
   if (ink != null) return ink;
   return addAfter( backTransToken( brl ), brl );
  case SEPARATOR:
   return backTransSeparator( brl );
 }
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
 //check g1 mode
 String after = finishSubSup( brl ); //script end tag
 System.out.println( "KT--addAfter: |"+after+"| brl:"+brl );
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
 after = afterSymbol(); //Any TF end tags
 if (after == null) return ink;
 buf.append( ink );
 return buf.append( after ).toString();
}

            //**Numeric mode**//

  //  The parser grammar recognizes this sequence as 1. numeric mode.
  //numind: ((DOTS3456) (updigs| DOT2 | DOTS256 )); 
  //numfrag: numind (updigs | DOT2 | DOTS256 | DOTS34 | numspacedig )*;

  //  There seems to be other numeric cases not addressed here.
  //2. Numeric passage/terminator Rulebook Sec. 6.9
      //Mainly used for worked examples
      //Sets grade 1 (no contractions) and letters a-j 
      //must each[?] a leading dots-56
  //3. The spaced numeric indicator
  //TODO set special g1 mode

private String numericMode( String brl ){

 if (dlMention) return handleMention( brl );

 // "Vulgar fractions" need to be backtranslated in
 // entirety but always start with a numeric indicator.
 //Grammar does recognize them at a lower level
 //But using this might complicate unnecessarily?
 String ink = UpperNumber.getVFrac( brl );
 System.out.println( "KT:numMode -- vfrac ink: "+ ink );

 if (ink != null){
  if (traceG1) 
   System.out.println( "G1 mode set by numeric mode start." );
  backInd.processIndicators( g1SpecBrl );
  return ink;
 }

 Indicator ind = backInd.check4Ind( brl );
 // Note that some numeric symbols just represent numeric
 //signs in print but the 12 basic numeric (start) indicators
 //are also symbols for numeric signs; these are addressed here.
 if (ind != null){
    boolean upNum = backInd.handleNumericIndicator( brl, ind );
 }
 //Just a numeric symbol, not (also) an indicator
 return UpperNumber.getInk( brl );
}

/**  Commented out stuff moved to BackInd;
private String handleNumericIndicator( String brl, Indicator ind ){
 IndicatorClass ic = ind.myIndData.getMyClassEnum();
 if (ic != IndicatorClass.NUMERIC_INDICATOR) {
   System.out.println( "Error in numeric mode for braille: "+brl);
   System.exit( 2 );
 }
 System.out.println( "in KT.handleNumInd" );
 IndicatorType iType = ind.getIndType();
 System.out.println( "KT.handleNumInd()--iType: "+ iType );
 if (iType == IndicatorType.NUMERIC_START){
  if (traceG1) System.out.println( "G1 mode set by numeric mode start." );
  processIndicators( g1SpecBrl );
  return UpperNumber.getInk( brl );
 }
 if (iType == IndicatorType.NUMERIC_TERMINATOR){
   //Do something
   return "";
 }
 if (iType == IndicatorType.NUMERIC_CONTINUE){
   //Do something
   return "";
 }
 //The spaced numeric indicators and the numeric passage
 //indicator have special behavior  FIX THIS

 return "";
} 
*/


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
   String fromInd = backInd.handleIndicator( ind );
   System.out.println( "KT.handleSAPre--fromInd: "+fromInd );
   return fromInd;
 
 }
 //Prefix can contain indicators as well as symbols
 private String handleSAPrefix( String brl ){
  Indicator ind = backInd.check4Ind( brl );
  if (ind != null) {
   String fromInd = backInd.handleIndicator( ind );
   System.out.println( "KT.handleSAPre--fromInd: "+fromInd );
   return fromInd;
  }
  if (dlMention) return handleMention( brl );
  return StandingAlone.backPre( brl );
 }

  //A Latin letter or sequence corresponding to a
  //shortform that is "standing alone"
  //G1--Affected by a pending g1 start indicator
  // FIX CON/UNCON flag???
 private String backTransSAseq( String brl ){
  if (dlMention) return handleMention( brl );
  String ink = saLetterBT.backTransLetter( brl, wwContractions );
  // Per the parser grammar this is the entire sequence and thus  
  // the last of any letters before the postfix or separator. Any 
  // non-alphabetic symbols are part of the postfix.
  capInfo.clearCapWordInd();
  return ink;
  }
  
  //  Symbols allowed after letter(s) that
  //are considered to be "standing alone"
private String handleSAPostfix( String brl ){
  Indicator ind = backInd.check4Ind( brl );
  if (ind != null) return backInd.handleIndicator( ind );
  if (dlMention) return handleMention( brl );
  return StandingAlone.backPost( brl );
 }

//**********************************************
   // ***Explicit (implemented) indicators***//
//**********************************************

/**
private String processIndicators( String brl ){
   if (trace) System.out.println( "Checkif ind: "+ brl );
   boolean isInd = false;
   Indicator indy = check4Ind( brl );
   if (indy == null) {
    if (trace) System.out.println( "Not an indicator." );
    return (String) null;
   }
   return handleIndicator( indy );
}
Indicator check4Ind( String brl ){
 Indicator indy = Indicator.getInd( brl );
 return indy;
}

private String handleIndicator( Indicator indy ){
   IndicatorClass ic = indy.myIndData.getMyClassEnum();
   System.out.println( "KT.handleInd.--IC: "+ic );
     //Symbol mentioned as example, not actually used
   if (dlMention){
    System.out.println( "Indicator was mentioned; not active." );
    dlMention = false;  //ASSUMED SCOPE
    return brlDots( indy.getBrl() );
   }
   switch( ic ){
    case CAPITALIZATION_INDICATOR:
     System.out.println( "Input is cap ind." );
     capsHandler.handleCapIndicator( (CapsIndicator) indy );
     System.out.println( "capInfo capwordind: "+
            capInfo.getCapWordInd() );
     System.out.println( "capInfo cappassind: "+
          capInfo.getCapPassInd() );
     return "";
    case DOT_LOCATOR:
      DotLocatorIndicator dl = (DotLocatorIndicator)indy;
      if (DotLocatorIndicator.isMention( dl )){
        dlMention = true;
      }
      if (showDL) return brlDots( indy.getBrl() );
      return "";
    case GRADE1_INDICATOR:
      if (traceG1) System.out.println( "Input is g1 indicator." );
      Grade1Indicator g1Indy = (Grade1Indicator) indy;
      Scope scope = g1Indy.getScope();
      if (scope == Scope.TERMINATOR){
        Grade1Indicator.handleTerminator( );
      } else {
        //Ensure numeric mode is off (grammar should do this!)
        //It needs to know about "endscope" guys 
        Grade1Indicator.setPending( g1Indy );
      }
    return "";
    case TYPEFORM_INDICATOR:
     System.out.println( "KT.handleInd.--Input is tf ind." );
     TypeformIndicator tfIndy = (TypeformIndicator) indy;
     scope = tfIndy.getScope();
     if (scope == Scope.TERMINATOR){
       return TypeformsHandler.endTag( tfIndy );
     } else {
          //1. Makes indicator active if valid
       boolean ok = tfIndy.setMe();
        //Oops, an indicator in this set was already active
       if (!ok) return "";

        //2. Adds indicator to correct stack for
        //  getting its end tag when required later
       TypeformsHandler.addToStack( tfIndy );

        //3. and now supplies start tag to backtranslator
       return tfIndy.getStartTag();
     }
   case TRANSCRIBER_INDICATOR:
    System.out.println( "Input is tf ind." );
    return ((TranscriberIndicator) indy).getInk();
 
   case SUBSUP_INDICATOR:
    //need to return start tag and also
    //keep checking scope
    SubSupIndicator ssIndy = (SubSupIndicator) indy;
     //Set as pending when identified as an indicator ???
    SubSupIndicator.setPending( ssIndy );
    //lastWasSubSup = true;
    setLastWasSubSup( true );
    return SubSupIndicator.getPendingStartTag();
   }
   System.out.println( "Warning -- logic error in indicator process." );
   return "";
}
*/

        // ***Generic token per parser grammar*** //
 //Possibility of indicator handled by caller 
 private String backTransToken( String brl ) {
  //String ink =  processIndicators( brl );
  //System.out.println( "KeepTrack bt token: |"+ink+"|");
  //if (ink != null) return ink;

  //What if "" for some indicators?

 //Most prefix root symbols are a single braille symbol
 //but might also be a one-cell symbol indicator
 //follwed by a one-cell symbol???
  if (brl.length() == 1){
   String pre = brl.substring(0,1);
   if (pre.equals( g1SymInd )){
    //do something
   }
  }
  String ink;
  if (trace){
    System.out.println( "KeepTrack, will try input: "+
                         brl+" as letter." );
  }

  if (dlMention) return handleMention( brl );
  //G1--Affected by a pending g1 start indicator
  ink = backTransLetter( brl );
  if (ink != null) return ink;
  if (trace){
    System.out.println( "KeepTrack, not letter trying as AnyPunc." );
  }
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
  dlMention = false;  //ASSUMED SCOPE
  return brlDots( brl );
}

private String anyPunc( String brl ){
 return Punctuation.getAnyPunc( brl );
}

// if we try upper numbers and it fails then what
//  could be a g1 prefix to a-j in letters or
//pretty much anything else



private String backTransSeparator( String brl ){
 if (dlMention) return handleMention( brl );
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
 //System.out.println( "CANNOT DO THIS!");
 InitializeIndicators.makeIndicators( report,
                  display, g1SymInd );
} 

}//End Class.

