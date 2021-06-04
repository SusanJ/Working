package org.dotlessbraille.listeners;
class TestListener implements ModeListener{

 //Adapter for sending messages to Tester

 UEBMode current;
 ModeEvent mySender;
 Tester myReceiver;

 TestListener( ModeEvent mySender, Tester myReceiver ){
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