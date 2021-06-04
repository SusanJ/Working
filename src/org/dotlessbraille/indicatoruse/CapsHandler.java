package org.dotlessbraille.indicatoruse;
import org.dotlessbraille.indicators.CapsIndicator;
import org.dotlessbraille.indicators.IndicatorType;
public class CapsHandler{

  //Logic for actions for capitalization indicators
  //Transfers information to and from other processes
  //indirectly via a PendingCapInds object

  PendingCapInds myManager;
 
  public CapsHandler( PendingCapInds myManager){
   this.myManager = myManager;
  }

//Returns any print equivalent for the indicator
//Normally this would be an empty string
public String handleCapIndicator( CapsIndicator ind ){
 IndicatorType indType = ind.getIndType();
 String ink = ind.getBrl();  
 switch( indType){

  case CAPITAL_WORD:
   if (myManager.getCapWordInd()){
       myManager.warn( "Warning, caps word already active!" );
   } else if (myManager.getCapPassInd()) {
       myManager.warn( "Error, caps word ignored, not allowed when "+
         "caps passage already active!" );
   } else {
     myManager.setCapWordInd( true );
     //capWordStack.push( ind );
   }
   myManager.capHandlerReply( true );
   return ink;

  case CAPITAL_PASSAGE:
   if (myManager.getCapPassInd()) {
    myManager.warn( "Warning, caps pass already active!" );
   } else if (myManager.getCapWordInd()){
    myManager.warn( "Error, caps pass ignored, not allowed when "+
                     "caps word already active!" );
   } else {
     myManager.setCapPassInd( true );
   }
   myManager.capHandlerReply( true );
   return ink;

  case CAPITAL_TERMINATOR:
   myManager.setCapWordInd( false );
   myManager.setCapPassInd( false);
   myManager.capHandlerReply( true );
   return ink;
 }
 //System.out.println( "handleIndicator -- not available: "+ ind );
  myManager.capHandlerReply( false );
  return "Logic Error";
}
}//End Class.