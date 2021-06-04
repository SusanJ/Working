package org.dotlessbraille.indicators;
import java.util.ArrayList;
import java.util.HashMap;
import org.dotlessbraille.manifold.KeepTrack2;

public class NumericIndicator extends Indicator{

static boolean debug = true;
static boolean trace = false;

//TO_DO  How to handle UC/LC ASCII Braille 

 static HashMap <String, String> indInk = 
   new HashMap <String, String> ();

 static ArrayList <NumericIndicator> allNumInds =
     new ArrayList<NumericIndicator>();

 //There is only one explicit termination tag
 static Indicator endTag;

 ArrayList <NumericIndicator> numInds = 
   new ArrayList<NumericIndicator>();
 //IndicatorType indicatorType = IndicatorType.NUMERIC_START;
 String groupName = "none";
 int setLen = 1;
 String ink = "";

    //CONSTRUCTORS
 


//HACK -- NEEDS FIX
NumericIndicator( String brl, String name, Scope scope){
//                  IndicatorType indicatorType ){
 super( brl, name, scope );
 allNumInds.add( this );
}

NumericIndicator( String brl, String name, Scope scope,
                  IndicatorType indicatorType ){
 super( brl, name, scope );
 allNumInds.add( this );
}
NumericIndicator( String brl, String name, Scope scope,
                  IndicatorType c, int flag ){
 super( brl, name, scope );
 setIndicatorType( c );
 //allNumInds.add( this );
}

//IndicatorType getIndType(){
 //return indicatorType;
//}

void setInk( String ink ){
 this.ink = ink;
}
String getInk(){
 return ink;
}
  //I can't remember why this is here???
public String getEndTag(){
 return endTag.getBrl();
}

//Two-cell symbols all with same leading braille cell
static private void makeNumInds( String lead, String trailers,
          IndicatorType useType, String name ){

     indInk.put( "#a", "1" );
     indInk.put( "#b", "2" );
     indInk.put( "#c", "3" );
     indInk.put( "#d", "4" );
     indInk.put( "#e", "5" );
     indInk.put( "#f", "6" );
     indInk.put( "#g", "7" );
     indInk.put( "#h", "8" );
     indInk.put( "#i", "9" );
     indInk.put( "#j", "0" );
     indInk.put( "#1", "," );
     indInk.put( "#4", "." );

 if (trace) System.out.println( "Starting NI--makeNumInds()" );
 StringBuilder buf;
 
 for (int i=0; i<trailers.length(); i++){
  buf = new StringBuilder();
  buf.append( lead );
  buf.append( trailers.substring(i,i+1) ); //LC or UC?
  NumericIndicator tmp = 
   new NumericIndicator( buf.toString(), name, Scope.SPECIAL,
                         useType, 0  );
  //numInds.add( tmp );
  allNumInds.add( tmp );
  String brl =  buf.toString();//???

    //12 of the numeric start inds are also symbols
    //This couples to the translation table -- not good
    //Needed part of table copies here
  if (useType == IndicatorType.NUMERIC_START){
   String ink = indInk.get( brl );
   tmp.setInk( ink );
  }
  //setLen = trailers.length();
 }//End for loop.

 Grade1Indicator.makeSpecialG1Ind( IndicatorClass.NUMERIC_INDICATOR );
 if (trace)
 System.out.println( "   Made phantom indicator for G1 "+
  "set by numeric mode. (1)" );

 if (trace) System.out.println( "Made a set of "+trailers.length()+
                     " Numerical Indicators." );
 if (trace) System.out.println( 
   "  allNumInds.size() "+allNumInds.size() );


}

  //Checks if string starts with a numerc indicator
static boolean isNUMindi( String test ){
 if (test.length() < 2) return false;
 if (debug ) System.out.println( "Testing in NI: "+test );
 NumericIndicator tmp = isNUMind( test );
 if (tmp == null) return false;
 return true;
}
static NumericIndicator isNUMind( String test ){
 //System.out.println( "Size of allNumInds: "+allNumInds.size() );
 for (NumericIndicator ni : allNumInds){
   if (debug) System.out.println( "Checking against: "+ni.brl );
   if (test.startsWith( ni.brl )) {
     System.out.println( "startsWith: "+ni.brl) ;
     return ni;
   }
 }
 return null;
}
static void display(){
 System.out.println( "  All numeric indicators of all types." );
 for (NumericIndicator ni : allNumInds){
  System.out.println( "Braille symbol: "+ni.brl+" "+ni.name );
 }

}

//Test rig.
//=========================================================
public static void main( String[] args ) throws Exception {
//=========================================================
 
 mayne( true, true );
}

static void mayne( boolean report, boolean details ){

  if (trace) System.out.println( "Starting mayne()...." );

  //Set of braille symbols for numeric indicator

//********************************************
//UEB DATA (hard-wired)      DATA-DATA-DATA
  String digits = "abcdefghij";
  String comma  = "1";
  String period = "4";
  String numericSpace   = "\"";    //Dot-5
  String simpleFractionLine = "/"; //Dots-34

  String hash   = "#";
  String hashWithSpace  = "# ";
  String hashWithNumericSpace  = "#\" ";
  String numericPassage = "##";  //Sec. 6.9

  String numericModeTerminator = "#'"; //Sec. 6.9
  String lineContinuation  = "\"";     //Before EOL; Sec. 6.10
  String lineContPlusSpace = "\"\"";   //Before EOL; Sec. 6.10

  String g1NMTerm = ";";
//******************************************** 

    //NUMERIC MODE INDICATORS per Sec. 6.1

  StringBuffer trailers = new StringBuffer();
  trailers.append( digits );
  trailers.append( comma );
  trailers.append( period );
  String trails = trailers.toString();

  //Note that all 12 "start indicators" are 2-cell symbols 
  //so it is an easy "startswith" hack to check for them

  //  # (dots-3456) followed by any digit,
  // a comma (dec. pt.) , or a period (dec. pt.)
  //NumericIndicator numInd = 
   // new NumericIndicator( hash, trails, "Numerical Indicator", 
           //Scope.SPECIAL, "#+digit/./,");

  makeNumInds( hash, trails, IndicatorType.NUMERIC_START,
     "#+digit/./," );

  //Per Sec. 6.8 # (dots-3456) followed immediately by one
  //or more spaces
  //functions as a Numeric Indicator.  This is generally used for 
  //spatial arithmetic or other situations where it is desired to
  //align numbers.
  NumericIndicator spaceNumInd =
    new NumericIndicator( hashWithSpace, "Spaced Numerical Indicator", 
       Scope.SPECIAL, IndicatorType.SPACED_NUMERIC_START  );

  NumericIndicator numPassInd = 
   new NumericIndicator( numericPassage, "Numeric Passage", Scope.PASSAGE,
      IndicatorType.NUMERIC_PASSAGE);

  NumericIndicator lineContInd =
   new NumericIndicator( lineContinuation, "Numeric Line Cont.", 
                         Scope.END_OF_LINE, IndicatorType.NUMERIC_CONTINUE );

  NumericIndicator SpacePlusLineContInd =
   new NumericIndicator( lineContPlusSpace, "Numeric Space Plus Line Cont.", 
                         Scope.END_OF_LINE, IndicatorType.NUMERIC_CONTINUE) ;


  NumericIndicator numTermInd = 
   new NumericIndicator( numericModeTerminator, 
                         "Numeric Termination", Scope.TERMINATOR,
                         IndicatorType.NUMERIC_TERMINATOR );
   endTag = numTermInd;

  //StringBuilder gTrails = new StringBuilder( digits );
  //NumericIndicator g1NumTermInd = 
    //new NumericIndicator( g1NMTerm, digits, "Numerical Indicator", 
                     //Scope.TERMINATOR, "Dots-56 + digit");

   //endTag = numTermInd;

 

  //Special g1 mode set by N.I. UPDATE == done in Grade1Indicator class
  //Indicator specG1Ind =
     //new Indicator( true, "specG1KeY", numInd );

  if (trace) NumericIndicator.display();
  if (trace) System.out.println( "Size of allNumInds: "+NumericIndicator.allNumInds.size() );

    //PERSIST for Numeric Mode

/**Numeric mode symbols per 6.2.1
   These 25 symbols do NOT terminate the scope of an N.I.
   They can (also?) be recognized as in the trans table???

     the ten digits
     full stop (period)
     comma
     the ten numeric space-digit symbols
     simple numeric fraction line
     the two line continuation indicators
*/
  

    //NOTE APRIL6  PARSER GRAMMAR DOES THIS NOW

 // ArrayList<String> persist = makePersist( "\"", digits);

  Persist numericModeSymbols = new Persist( "numericMode" );
  KeepTrack2.setPersistForNumMode( numericModeSymbols );

    //10 [decimal] digits
  for (int i=0; i<digits.length(); i++){
    numericModeSymbols.addSym( digits.substring(i,i+1) );
  }
  numericModeSymbols.addSym( period );
  numericModeSymbols.addSym( comma );

    //10 numeric space-digit symbols
  StringBuilder buf = new StringBuilder();
  for (int i=0; i<digits.length(); i++){
    buf = new StringBuilder( numericSpace );
    buf.append( digits.substring(i,i+1) );
    numericModeSymbols.addSym( buf.toString() );
  }
  numericModeSymbols.addSym( simpleFractionLine );
  numericModeSymbols.addSym( lineContinuation  );
  numericModeSymbols.addSym( lineContPlusSpace );  
 

 if (trace || report )
  System.out.println( "   Numeric mode indicators table complete. ("+
   NumericIndicator.allNumInds.size()+")" );
if (trace) System.out.println(
  "Size of allNumInds: "+NumericIndicator.allNumInds.size() );
  //return numInd;

}  //End mayne()
}//End Class NumericIndicator