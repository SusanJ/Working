package org.dotlessbraille.indicatoruse;

//import java.util.Stack;
import java.util.ArrayList;

public class PendingCapInds implements CapsEvent,
       ManageCapIndicators, Status { 

  //Keeps track of which caps indicator is active and
  //provides caps status to translators
  // How does it know it is getting all the information
 
 //Sends info to and from caps indicator handler
 boolean dot6 = false;
 boolean capWordInd = false;
 boolean capPassInd = false;
 ArrayList<CapsListener> listeners = 
  new ArrayList<CapsListener>();


 public PendingCapInds(){}

    //Interface requirments
 public void CapStatusChange( CapsInd latest ){
  if (listeners.size() == 0 ) return;
  broadcast( latest );
 };
 private void broadcast(CapsInd latest ) {
  for (CapsListener cl : listeners){
   cl.capModeChanged( latest );
  }
 }
 public void addCapsListener( String name,
                CapsListener listener ){
  listeners.add( listener );
 }

 public void warn( String text ){}
 public void capHandlerReply( boolean ok ){}

 
    //Status setters via CapsHandler
 public void setDot6( boolean dot6){
  }
 public void setCapWordInd( boolean wordInd ){
  //And tell everyone
  capWordInd = wordInd;
  CapStatusChange( CapsInd.CAP_WORD );
 }
public void clearCapWordInd(){
  capWordInd = false;
  CapStatusChange( CapsInd.CAPS_OFF );
 }
public void setCapPassInd( boolean passageInd ){
  //And tell everyone
  capPassInd = passageInd;
  CapStatusChange( CapsInd.CAP_PASSAGE);
 }
 public void clearCapPassInd(){
  capPassInd = false;
 CapStatusChange( CapsInd.CAPS_OFF );
 }


 public boolean getCapWordInd(){
  return capWordInd; 
 }
 public void notALetter( String brl ){
  clearCapWordInd();
 }
 public CapsFlag getCapsFlag(){
  if (capWordInd || capPassInd) return CapsFlag.UC ;
  return CapsFlag.LC;
 }
 public boolean getCapPassInd(){
  return capPassInd;
 }
 

 //Checking if current token is a letter or non-letter--a
 //non-letter ends scope of caps word indicator
 public void handleLetterTransInfo( boolean isLetter ){
   if (getCapWordInd()){
    if (!isLetter) clearCapWordInd();
   }
 }
 //UEB Rulebook says space ends scope of cap word
 //  must be any separator since it is any non-letter
 public void separatorEncountered( boolean isSep ){
    if (isSep && getCapWordInd()) clearCapWordInd();
 }
}//End Class. 