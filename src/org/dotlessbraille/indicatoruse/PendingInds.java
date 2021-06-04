package org.dotlessbraille.indicatoruse;
import org.dotlessbraille.indicators.CapsIndicator;
import org.dotlessbraille.indicators.TypeformIndicator;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.NumericIndicator;
import org.dotlessbraille.indicators.IndicatorType;
import org.dotlessbraille.indicators.Scope;
import java.util.Stack;

//Manages UEB indicator sets with various scopes
class PendingInds{

 static boolean cdebug = true;

 //Keeps track of pending indicators of each kind -- only
 //one member of a set should be pending at any one
 //time

 //Does not check o proper nesting -- could do that with stack

 static CapsIndicator pendingCaps = (CapsIndicator) null;

 static TypeformIndicator pendingITF = (TypeformIndicator) null;
 static TypeformIndicator pendingBTF = (TypeformIndicator) null;
 static TypeformIndicator pendingUTF = (TypeformIndicator) null;
 static TypeformIndicator pendingSTF = (TypeformIndicator) null;

 static NumericIndicator pendingNum = (NumericIndicator) null;
  //Set by NumericIndicator
 static NumericIndicator pendingSpecialG1 = 
   null;

 //NEED TO ADD G1INDICATOR

  //Stack keeps track of word or sequence indicators
  //so if several are cleared at the same time they
  //can (optionally) be done in LIFO order
 static Stack<Indicator> seqStack = new Stack<Indicator>();

 static Stack<String> optionalEndTags = new Stack<String>();

 static Scope restricted = Scope.UNKNOWN;
 
public PendingInds(){}

 //Debug helper
static void checkPendingCaps(){
 System.out.println( "Checking: "+pendingCaps );
 if (pendingCaps == null){
   System.out.println( "   is null." );
 } else {
   System.out.println( "   is NOT null" );
 }
}
 
//Attempts to handle a just-encountered
//passage indicator terminator and returns any end
//tag. (Note that passage indicators, unlike word or
//or sequence indicators are always
//cleared explicitly.) 
public static String clearPassageInd( Indicator tmp ){

  if (tmp == null) return "";

  IndicatorType it = tmp.getIndType();
  Scope sc = tmp.getScope();
  System.out.println( "PendingInds.clearPassageInd(): "+
                      "type: "+it+ " scope: "+sc );
    if (sc != Scope.TERMINATOR) {
     return "";
    }

    //Need to set this here to limit clearing to other indicators.
    restricted = Scope.PASSAGE;

    String ret =  clearPending( it ); 
    restricted =  Scope.UNKNOWN;  
    return ret; 
} 
  
//  Method takes care of handling **implicit**
// termination of any remaining pending indicators
// with a word or sequence scope
// Caller determines when this is appropriate
public static String clearWordInd(){
 return popSeqInds();
}
static String popSeqInds(){
 StringBuilder tags = new StringBuilder();
 Indicator ind;
 String endTag;
 while (!seqStack.isEmpty()){
   ind = seqStack.pop();
   if (ind != null){
    endTag = ind.getEndTag();
    if (endTag != null) tags.append( endTag );
    ind = null;
   }
 }
 return tags.toString();
}

//Capitalizes input per possible pendingCaps indicator
static String doPendingCaps( String seq ){

 System.out.println( "PendingInds.doPendingCaps seq: "+seq );
 if ((seq == null) | (seq == "")) return seq;

 if (pendingCaps ==  null) {
   if (cdebug) System.out.println( "pendingCaps is null." );
     return seq;
 }

 System.out.println( "pendingCaps scope: "+
       pendingCaps.getScope() );

 if (pendingCaps.getScope() == Scope.PASSAGE ){
     if (cdebug) System.out.println( "PASSAGE scope." );
     return Capitalizer.capIt( pendingCaps, seq );
 }
 if (pendingCaps.getScope() == Scope.ALPHABETIC ){
     if (cdebug) System.out.println( "ALPHABETIC scope." );
     return Capitalizer.capIt( pendingCaps, seq );
 }
 return seq;
}

//MORE ACTIONS NEEDED?

//         Setters
static boolean setOrDoPending( CapsIndicator capsInd, 
    String seq ){

 //When indicator activated, will clear its user?
 if (capsInd == null) {
    if (pendingCaps == null) return false;
    doPendingCaps( seq );
    return true;
 }
 if (capsInd.getScope() == Scope.TERMINATOR) {
    doPendingCaps( seq );
    pendingCaps = (CapsIndicator) null;
    return true;
 }
 if (pendingCaps == (CapsIndicator) null){
    pendingCaps = capsInd;
    doPendingCaps( seq );
    //if the just set pendingCaps was a wordInd
    //then we can clear because the entire seq
    //should have been processed??
    if (pendingCaps.getScope() == Scope.ALPHABETIC){
      pendingCaps = (CapsIndicator) null;
    }  
    return true;
 }
 return false;
}

//Pushes any word or sequence indicator onto LIFO
//stack.  
static boolean pushSeq( Indicator ind ){
 if (Scope.isSeq( ind.getScope() ) ){
   seqStack.push( ind );
   return true;
 }
 return false;
}

          //Setters
//Setters set pendingInd for particular indicators
// Word/seq indicators are pushed onto
// LIFO stack

static boolean setPending( Indicator any ){
  System.out.println( "PendingInds.setPending() -- any???" );
  return false;
}

    //Setter for caps ind
static boolean setPending( CapsIndicator capsInd ){
 if (pendingCaps != null){    
  System.out.println( "PendingInds.setPending() "+
                      "can't set caps Ind as already set." ); 
  return false;
 }
 pendingCaps = capsInd;
 pushSeq( capsInd );
 return true;
}

     //Setter for any Typeform ind
static boolean setPending( TypeformIndicator tfInd ){
 
 IndicatorType indType = tfInd.getIndType();
 switch (indType){
  case ITYPEFORM:
   if (pendingITF != null) return false;
   pendingITF = tfInd;
   pushSeq( pendingITF );
   return true;
  case BTYPEFORM:
   if (pendingBTF != null) return false;
   pendingBTF = tfInd;
   pushSeq( pendingBTF );
   return true;
  case STYPEFORM:
   if (pendingSTF != null) return false;
   pendingSTF = tfInd;
   pushSeq( pendingSTF );
   return true;
  case UTYPEFORM:
   if (pendingUTF != null) return false;
   pendingUTF = tfInd;
   pushSeq( pendingUTF );
   return true;
}
 return false;
}

//Setter for Numeric Indicator and associated
// speciaal grade 1 indicator
static boolean setPending( NumericIndicator numInd ){
 if (pendingNum == (NumericIndicator) null) {
   pendingNum = numInd;
   pendingSpecialG1 = numInd;
   pushSeq( pendingNum );
   pushSeq( pendingSpecialG1 );
   return true;
 }
 return false;
}

//  Explicit clear for indicator
static String clearPending( IndicatorType indType){
 String tag= "";
 switch( indType){
  case CAPITAL:
   pendingCaps = (CapsIndicator) null;
   return tag;
  case ITYPEFORM:
   return helpClearTF( pendingITF );
  case BTYPEFORM:
   return helpClearTF( pendingBTF );
  case STYPEFORM:
   return helpClearTF( pendingSTF );
  case UTYPEFORM:
   return helpClearTF( pendingUTF );
  case NUMERIC_START:
   pendingNum = (NumericIndicator) null;
  case G1_WORD:
  case SPECIAL_GRADE_1:
 }
 return "";
}

//Clear any word or sequence typeform indicators 
//that were not explicitly cleared and/or any passage typeform
//indicators are cleared at caller's request

static String helpClearTF( Indicator pendingInd ){
                          
  String tag = "";
  if (pendingInd == null){
    System.out.println( "PendingInds.clearPending()--Warning "+
      "\n attempt to clear tf ind "+pendingInd.getName()+
      "\nthat hadn't been set. ");
    return tag;
   }

   Scope sc = pendingInd.getScope();

   //Option to limit must be set by caller
   if ( !(restricted == Scope.UNKNOWN ||
          sc == restricted ) ) return tag;

   tag = pendingInd.getEndTag();
   System.out.println( "PendingInds.helpClearTF()"+
       "tag: "+tag );
   pendingInd = (TypeformIndicator) null;
   return tag;
}


//   Getter for a particular type of pending indicator
static Indicator getPending( IndicatorType indType ){
 switch( indType){
  case CAPITAL:
   return pendingCaps;
  case ITYPEFORM:
   return pendingITF;
  case BTYPEFORM:
   return pendingBTF;
  case STYPEFORM:
   return pendingSTF;
  case UTYPEFORM:
   return pendingUTF;
  case NUMERIC_START:
   return pendingNum;
  case G1_WORD:
  case SPECIAL_GRADE_1:
 }
 return null;
}

}//End Class PendingInds;