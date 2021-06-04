package org.dotlessbraille.listeners;
import java.util.ArrayList;
class ModeBroadcaster implements ModeEvent{

 ArrayList<ModeListener> listeners = 
  new ArrayList<ModeListener>();

 UEBMode theDefault; 
 UEBMode current;
 UEBMode previous;

//------------------------------------
 ModeBroadcaster( UEBMode initial ){
  current = initial;
  theDefault = initial;
 }
 public void modeChange( UEBMode latest ){
  if (latest == current ) return;
  previous = current;
  current = latest;
  broadcast();
 }
 public UEBMode getCurentMode(){
  return current;
 }
 public UEBMode getDefaultMode(){
  return theDefault;
 }
 public void addModeListener( String type, ModeListener listener ){               
   listeners.add( listener );  //Assume only one type?
 }
 void broadcast() {
  for (ModeListener mL : listeners){
   mL.modeChanged( current );
  }
 }
}//End Class ModeBroadcaster.