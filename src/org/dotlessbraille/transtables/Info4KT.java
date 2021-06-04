package org.dotlessbraille.transtables;
import org.dotlessbraille.indicators.SubSupIndicator;
//import org.dotlessbraille.indicators.Grade1Indicator;
import org.dotlessbraille.indicatoruse.TypeformsHandler;
import org.dotlessbraille.manifold.KeepTrack2;

//First cut at minimizing direct coupling from KeepTrack
//String tfEndStack = TypeformsHandler.tfEndTagsAfterWord();

public class Info4KT{
 public Info4KT(){}

 //Pass info

 static int inputLinesDone;
 static boolean lastWasVulgarFraction = false;
 static int conseqNumindCount = 0;
 //static boolean inNumericMode = false;
 
 static boolean traceSubSup = false;

//--------------------------

 public static void setLinesDone( int linesDone ){
  inputLinesDone = linesDone;
 }
 public static void incLinesDone( ){
  inputLinesDone = inputLinesDone + 1; 
 }
 public void setLastWasVulgarFraction(){
  lastWasVulgarFraction = true;
 }

  //  There are can be more than one numeric indicator
  // in a numeric sequence
 public static void XincrementNumindCount(){
  conseqNumindCount = conseqNumindCount+1;
 }
 public static void XclearNumindCount(){
  conseqNumindCount = 0;
 }

  

    //STUFF IT BROADCASTS

 public void setWaitingFor( String close ){
  SubSupIndicator.setWaitingFor( close );
 }
 
       
     //ITS OWN STUFF
 public static int getLinesDone(){
  return inputLinesDone;
 }


 

      //Listens to  SUBSUP and then broadcasts
 public String afterNumfrag(){
  return SubSupIndicator.afterNumfrag();
 }
 public String spaceEncountered4SS(){
  return SubSupIndicator.spaceEncountered();
 }
 public String getAfterTagSS( String brl ){
  return SubSupIndicator.getAfterTag( brl, traceSubSup );
 }
 public boolean subSupIsPending(){
  return SubSupIndicator.subSupIsPending();
 }
 public String afterAtEOL(){
  return SubSupIndicator.afterAtEOL();
 }
       //Listens to TF and then broadcasts
 public String tfEndTagsAfterWord(){
  return TypeformsHandler.tfEndTagsAfterWord();
 }
 public String tfAfterSymbol(){
  return TypeformsHandler.afterSymbol();
 }
 public String tfAfterAtEOL( String ssEnd ){
  return TypeformsHandler.afterAtEOL( ssEnd );
 }
}//End Class.



