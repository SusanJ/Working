package org.dotlessbraille.indicatoruse;
import java.util.Stack;
import org.dotlessbraille.indicators.TypeformIndicator;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.IndicatorType;
import org.dotlessbraille.indicators.Scope;
public class TypeformsHandler{


       //-----Typeform Indicators-----

   //Typeform indicators aren't typical indicators; they just
   //indicate start and end "tags" back-translated to print. 
   //At most one of each typeform 
   //is active at any one time. 

   //Tag to be appended to backtrans immediately after symbol preceded by 
   //typeform symbol indicator.  Tag must then be reset to null.

 static String afterTag = "";

   //LIFO stack of any end tags to be appended immediately after item 
   //Note that if a TF word ind is explicitly terminated before the
   //end of an item, its end tag is popped from the stack and appended
   //to the backtranslation at that point

 static Stack<TypeformIndicator> tfSymbolStack = 
    new Stack<TypeformIndicator>();
 static Stack<TypeformIndicator> tfWordStack = 
    new Stack<TypeformIndicator>();
 static Stack<TypeformIndicator> tfPassageStack =
   new Stack<TypeformIndicator>();

 static boolean pendingIword = false;
 static boolean pendingBword = false;
 static boolean pendingUword = false;
 static boolean pendingSword = false;

 static boolean pendingIpassage = false;
 static boolean pendingBpassage = false;
 static boolean pendingUpassage = false;
 static boolean pendingSpassage = false;

//static String endTag = "";
TypeformsHandler(){}

  //Expecting terminator
static String endTag( TypeformIndicator ind ){

 IndicatorType indType = ind.getIndType();
    //logic error if ind not terminator
 TypeformIndicator fo = null;
 if ( !tfWordStack.empty()){
   fo = tfWordStack.peek();
 }
 if (fo != null){
  fo = tfWordStack.pop();
  IndicatorType foType = fo.getIndType();
  if (foType != indType){
   System.out.println( "TF Termination indicator: "+ind.getBrl()+
      " unexpected; expecting: "+fo.getBrl() );
  }
  return fo.getEndTag();
 } else {
   if ( !tfPassageStack.empty()) {
     fo = tfPassageStack.peek();
   }
   if (fo == null){
    System.out.println( "TF Termination indicator: "+ind.getBrl()+
      " unexpected; no prior corresponding start indicator." );
    return "";
   } else {
     IndicatorType foType = fo.getIndType();
     if (foType != indType){
       System.out.println( "TF Termination indicator: "+ind.getBrl()+
       " unexpected; expecting: "+fo.getBrl() );
     }
     tfPassageStack.pop();
     return ind.getEndTag();
   }
 }   
}

static void addToStack( TypeformIndicator ind ){
 Scope scope = ind.getScope();
 switch ( scope ){
  case NEXT_SYMBOL:
   tfSymbolStack.push( ind );
   return;
  case WORD_OR_SEQUENCE:
   tfWordStack.push( ind );
   return;
  case PASSAGE:
   tfPassageStack.push( ind );
   return;
  }
 return;
}
  


static boolean handleTFIndicator( Indicator ind ){
  //Could use new class logic?
 IndicatorType indType = ind.getIndType();
 boolean isTFInd = IndicatorType.isTypeform( indType );
 System.out.println( "indType: "+indType+ " is TF: "+isTFInd );
 return isTFInd; 
}

/**
      //Provides start and end tags for all standard TF markup
static String transTFInd( TypeformIndicator ind ){

 Scope scope = ind.getScope();
 IndicatorType indType = ind.getIndType();
 System.out.println( "From transTFInd Typeform ind: "+
    ind.getBrl()+" scope: "+scope+ "indType: "+indType);

 switch( scope ){

  //The same terminator is used for both word and passage inds for
  //a given typeform.
  //Context could be used to identify which one is present.
  //However the goal here is to handle UEB which may not
  //be strictly correct so this code keeps track of which
  //type of indicator is active.

  case TERMINATOR:
    //Check if the corresponding word indicator is active.
   boolean isWordInd = unsetPendingTFWord( indType );
   System.out.println( "TERMIN case: isWordInd: "+isWordInd );
   //Note that if is terminator was used prior to the end
   // of the word (or symbols-sequence) 
   //terminated at the end of an item
   if (isWordInd){
     //Why can this happen?
    if (tfWordStack.empty() ) return "";
    String expected = tfWordStack.pop().inkEndTag;
    String indyTag = ind.inkEndTag;
    //Warn if not equal
    boolean areEqual = expected.equals( indyTag );
    System.out.println( "are equal: "+expected+" "+indyTag );
    return indyTag;
   } 
   //Must be terminating passage ind., could check? 
   return ind.inkEndTag;

  case NEXT_SYMBOL:
   afterTag = ind.inkEndTag;
   return ind.inkStartTag;

  case WORD_OR_SEQUENCE:
   boolean check = setPendingTFWord( indType );
   if (!check) return "";
   tfWordStack.push( ind );
   return ind.inkStartTag;

  //PASSAGE ??
  default:
   //boolean check = setPendingTFPassage indType );
   tfPassageStack.push( ind );
   return ind.inkStartTag;
  }
 //return null;
}
*/
/**static boolean setPendingTFWord( IndicatorType indType ){
 switch( indType ){
  case ITYPEFORM:
   if( pendingIpassage){
    System.out.println( "Warning, italic passage ind. already active!" );
    System.out.println( "italic word ind. ignored." );
    return false;
   }
   pendingIword = true;
   return true;
  case BTYPEFORM:
   if( pendingBpassage){
    System.out.println( "Warning, bold passage ind. already active!" );
    System.out.println( "bold word ind. ignored." );
    return false;
   }
   pendingBword = true;
   return true;
  case UTYPEFORM:
   if( pendingUpassage){
    System.out.println( "Warning, underline passage ind. already active!" );
    System.out.println( "underline word ind. ignored." );
    return false;
   }
   pendingUword = true;
   return true;
  case STYPEFORM:
  if( pendingSpassage){
    System.out.println( "Warning, script passage ind. already active!" );
    System.out.println( "script word ind. ignored." );
    return false;
   }
   pendingSword = true;
   return true;
  }
 return false;
}
*/
 //Parser does not restrict improper use of typeform indicators
 //In case of conflict the first one encountered is utilized
static boolean setPendingTFPassage( IndicatorType indType){
 switch( indType ){
  case ITYPEFORM:
   if( pendingIword){
    System.out.println( "Warning, italic word ind. already active!" );
    System.out.println( "Italic passage ind. ignored." );
    return false;
   }
   pendingIpassage = true;
   return true;
  case BTYPEFORM:
  if( pendingBword){
    System.out.println( "Warning, bold word ind. already active!" );
    System.out.println( "Bold passage ind. ignored." );
    return false;
   }
   pendingBpassage = true;
   return true;
  case UTYPEFORM:
  if( pendingUword){
    System.out.println( "Warning, underline word ind. already active!" );
    System.out.println( "Underline passage ind. ignored." );
    return false;
   }
   pendingUpassage = true;
   return true;
  case STYPEFORM:
   if( pendingUword){
    System.out.println( "Warning, scripte word ind. already active!" );
    System.out.println( "Script passage ind. ignored." );
    return false;
   }
   pendingSpassage = true;
   return true;
  }
 return false;
}
static boolean unsetPendingTFWord( IndicatorType indType ){
 System.out.println( "indType unset type: "+indType );
 switch( indType ){
  case ITYPEFORM:
   if (!pendingIword) return false;
   pendingIword = false;
   return true;
  case BTYPEFORM:
   if (!pendingBword) return false;
   pendingBword = false;
   return true;
  case UTYPEFORM:
   if (!pendingUword) return false;
   pendingUword = false;
   return true;
  case STYPEFORM:
  if (!pendingSword) return false;
   pendingSword = false;
   return true;
  }
 return false;
}

// Assumes that carried-over word doesn't
//have carried-over TF Word ind???
//Argument is any implicit script terminators
public static String afterAtEOL( String prevAfter ){
 StringBuilder all = new StringBuilder();
 if (prevAfter != null) all.append( prevAfter );
 String symTags = afterSymbol();
 String wrdTags = tfEndTagsAfterWord();
 if (symTags == null && wrdTags == null) return all.toString();
 if (symTags == null) {
   all.append( wrdTags );
   return all.toString();
 }
 if (wrdTags == null) {
   all.append( symTags );
   return all.toString();
 }
 all.append( symTags );
 all.append( wrdTags );
 return all.toString();
}
//Returns any typeform end tags to be used after a symbol
//the typeform isn't explicitly terminated
public static String afterSymbol(){
 if (tfSymbolStack.empty()) return "";
 StringBuilder buf = new StringBuilder();
 while (!tfSymbolStack.empty()){
  buf.append( tfSymbolStack.pop().getEndTag() );
 }
 return buf.toString();
}
//Returns any typeform end tags to be used after a "word" where
//the typeform wasn't already explicitly terminated
public static String tfEndTagsAfterWord(){
 if (tfWordStack.empty()) return "";
 StringBuilder buf = new StringBuilder();
 while (!tfWordStack.empty()){
  buf.append( tfWordStack.pop().getEndTag() );
 }
 return buf.toString();
}

}//End Class.
