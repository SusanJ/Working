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

 //static boolean pendingIword = false;
 //static boolean pendingBword = false;
 //static boolean pendingUword = false;
 //static boolean pendingSword = false;

 //static boolean pendingIpassage = false;
 //static boolean pendingBpassage = false;
 //static boolean pendingUpassage = false;
 //static boolean pendingSpassage = false;

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
