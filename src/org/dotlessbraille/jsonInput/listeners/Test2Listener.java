package org.dotlessbraille.listeners;
class Test2Listener implements ModeListener{

 //Adapter for sending messages to Tester2

 UEBMode current;
 ModeEvent mySender;
 Tester2 myReceiver;

 Test2Listener( ModeEvent mySender, Tester2 myReceiver ){
  this.mySender = mySender;
  this.myReceiver = myReceiver;
  addMe();
 }
 private void addMe(){
  mySender.addModeListener( "Test", this );
 }

 public void modeChanged( UEBMode aMode ){
  current = aMode;
  myReceiver.setTransMode( aMode );
 }
}//End Class.