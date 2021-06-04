package org.dotlessbraille.indicatoruse;
import org.dotlessbraille.manifold.KeepTrack2;
import org.dotlessbraille.indicators.IndicatorType;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.IndicatorClass;
import org.dotlessbraille.indicators.DotLocatorIndicator;
import org.dotlessbraille.indicators.Grade1Indicator;
import org.dotlessbraille.indicators.NemethIndicator;
import org.dotlessbraille.indicators.CapsIndicator;
import org.dotlessbraille.indicators.TranscriberIndicator;
import org.dotlessbraille.indicators.TypeformIndicator;
import org.dotlessbraille.indicators.SubSupIndicator;
import org.dotlessbraille.indicators.Scope;

  // Directs the processing of all indicators during
  //backtranslation.  These are discovered in KeepTrack
  //which passes information to methods in this class
  //and gets information back as return values
  

public class BackInd{

 
 boolean showDL = true;
 PendingCapInds capInfo;
 CapsHandler capsHandler;

 boolean trace = true;
 boolean traceG1 = false;
 boolean traceNum = false;

 //boolean dlMention = false;
// boolean lastWasSubSup = false;
 public static boolean uncontracted = true;

public BackInd(){}

public BackInd ( PendingCapInds capInfo,
          boolean isUncontracted ){
  this.capInfo = capInfo;
  //this.letterBT = new LetterBT( capInfo );
  //this.saLetterBT = new SALetterBT( capInfo );
  capsHandler = new CapsHandler( capInfo );
  setUncon( isUncontracted );
 }

static boolean getDlMention(){
 return KeepTrack2.getDlMention();
}

    //IMPROVE THIS (SimBraille?)
String brlDots( String brl ){
 return "[sim]"+brl+"[sim]";
}
           //**Communication**//

static void setUncon( boolean isUncon ){
  uncontracted = isUncon;
}
static boolean getUncon(){
 return uncontracted;
}
static boolean isContracted(){
 return !uncontracted;
}

//**********************************************
   // ***Explicit (implemented) indicators***//
//**********************************************
//public String processIndicators( String brl, ParseTree ctx );

public String processIndicators( String brl ){
   System.out.println( "BackInd--Check if ind: "+ brl );
   boolean isInd = false;
   Indicator indy = check4Ind( brl );
   if (indy == null) {
    if (trace) System.out.println( "Not an indicator." );
    return (String) null;
   }
   return handleIndicator( indy );
}
public Indicator check4Ind( String brl ){
 Indicator indy = Indicator.getInd( brl );
 return indy;
}

    //NUMERIC INDICATORS
 //The basic 12 Numeric Start Indicators are both
 //indicators and numeric symbols so need special
 //treatment.  The backtrans logic in KeepTrack
 //hands over the information needed to handle the
 //the indicator portion. 
 // Does not go through handle indicator
public boolean handleNumericIndicator( String brl, Indicator ind ){
 if (traceNum){
   System.out.println( "In BackInd.handleNumInd ind: " +ind );
 }

 IndicatorClass ic = ind.myIndData.getMyClassEnum();
 if (ic != IndicatorClass.NUMERIC_INDICATOR) {
   System.out.println( " Error in numeric mode for braille: "+brl);
   System.out.println( "ic: "+ic );
   System.exit( 2 );
 }
 //System.out.println( "In BackInd.handleNumInd" );

 IndicatorType iType = ind.getIndType();

 if (traceNum){
   System.out.println( "In BackInd.handleNumInd()--iType: "
                       + iType );
 }

 if (iType == IndicatorType.NUMERIC_START){
  KeepTrack2.setNumericMode( true );
  if (traceG1) 
   System.out.println( "BackInd.G1 mode to beset by numeric mode start." );
  processIndicators( KeepTrack2.g1SpecBrl );
  // return UpperNumber.getInk( brl );
  return true;
 }
 if (iType == IndicatorType.NUMERIC_TERMINATOR){
   KeepTrack2.setNumericMode( false ) ;
   //Do something
   //return "";
 }
 if (iType == IndicatorType.NUMERIC_CONTINUE){
   //Do something
   //return "";
 }
 //The spaced numeric indicators and the numeric passage
 //indicator have special behavior  FIX THIS

 return false;
} 

public String handleIndicator( Indicator indy ){
   IndicatorClass ic = indy.myIndData.getMyClassEnum();
   if (trace)
    System.out.println( "BackInd.handleInd.--IC: "+ic );
     //Symbol mentioned as example, not actually used
   if (KeepTrack2.getDlMention()){
    System.out.println( "Indicator was mentioned; not active." );
    KeepTrack2.setDlMention( false ); //ASSUMED SCOPE
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
        KeepTrack2.setDlMention( true );
      }
      if (showDL) return brlDots( indy.getBrl() );
      return "";
    case GRADE1_INDICATOR:
      if (traceG1) System.out.println( "BackInd.--Input is g1 indicator." );
      Grade1Indicator g1Indy = (Grade1Indicator) indy;
      Scope scope = g1Indy.getScope();
      if (scope == Scope.TERMINATOR){
        Grade1Indicator.handleTerminator( );
      } else {
  //Oops -- special g1 set when num mode STARTs since it can
  //end at same point as num mode and also both special g1
  // and g1 symbol can be active at the same time!!!
        //Ensure numeric mode is off (grammar should do this!)
        //It needs to know about "endscope" guys 
   if (traceG1){
    System.out.println( "BackInd. g1_found scope: " + scope );
   }
        //Grade1Indicator.setPending( g1Indy );
        KeepTrack2.setPendingG1( g1Indy, scope );
      }
    return "";
    case NEMETH_INDICATOR:
     NemethIndicator nemIndy = (NemethIndicator) indy;
     String tmp = nemIndy.getStartTag();
     System.out.println( "Back ind tmp: "+tmp );
     return tmp;
     //return nemIndy.getStartTag();
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
    KeepTrack2.setLastWasSubSup( true );
    return SubSupIndicator.getPendingStartTag();
   }
   System.out.println( "BackInd--*WARNING*--logic error in indicator process." );
   return "";
}
}