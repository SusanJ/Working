package org.dotlessbraille.indicators;

//Braille symbols for UEB caps indicators are currently hard-wired.

import java.util.ArrayList;
import java.util.HashMap;

public class CapsIndicator extends Indicator{

 static ArrayList <CapsIndicator> capInds = 
   new ArrayList<CapsIndicator>();
 static final String DOT6 = ",";
 static final String capWordInd = ",,";
 static final String capPassageInd = ",,,";
 static final String capTerm = ",'";
 static final int minimumPassageLen = 3;

  //Caps indicators do not appear directly in print
 String ink = "";

CapsIndicator( String brl, String name, Scope scope ){
 super( brl, name, scope );
 capInds.add( this );
}

CapsIndicator( String brl, String name, Scope scope,
               int minItems ){
 super( brl, name, scope, minItems );
 capInds.add( this );
}
//IndicatorType getIndType(){
 //return indicatorType;
//}

String getInk(){
 return ink;
}
 //Capitalisation Indicators (HARD-WIRED!!!)
static void setUEBCapsInds( boolean ifDone, boolean display ){

 // Note that DOT6 is considered as part of a prefix-root symbol  
 //for braille capital letters but is also used as prefix to
 //indicated that the first letter of contraction is 
 //capitalized in print.
 CapsIndicator capSymInd = 
   new CapsIndicator( DOT6, "Single caps", Scope.NEXT_LETTER );
   capSymInd.setIndicatorType( IndicatorType.CAPITAL ); 
 
 CapsIndicator capWrdInd = 
  new CapsIndicator( capWordInd, "Modified double caps", 
                     Scope.ALPHABETIC );
  capWrdInd.setNonLetTerm( true );
  capWrdInd.setIndicatorType( IndicatorType.CAPITAL_WORD );
   
 CapsIndicator capPassInd = 
  new CapsIndicator( capPassageInd, "Caps Passage", Scope.PASSAGE, 
                     minimumPassageLen );
  capPassInd.setIndicatorType( IndicatorType.CAPITAL_PASSAGE );
  
 CapsIndicator capTermInd = 
  new CapsIndicator( capTerm, "Caps Terminator", 
                     Scope.TERMINATOR );
  capTermInd.setIndicatorType( IndicatorType.CAPITAL_TERMINATOR );
  
 if (ifDone) System.out.println( "   Capitalization indicators "+
             "table complete ("+capInds.size()+")" );
 if (display) displayCapsInds();
 } 
 static void displayCapsInds(){
  for (CapsIndicator ci : capInds){
   System.out.println( "Type: "+ ci.getIndType()+
                       " Braille: "+ci.getBrl() );
  } 
 }  
}//End Class CapsIndicator.