package org.dotlessbraille.listeners;
class TestRig{
 TestRig(){}
 
 public static void main( String [] args ){

   //The mode event that this processor will update
  ModeEvent myRadio = new ModeBroadcaster( UEBMode.CONTRACTED );

   //Specialized receivers that are the end target of updates
  Tester test1 = new Tester( "Ed" );
  Tester2 test2 = new Tester2( "Susan" );

   //Adapters that listen and pass on the updates to their end targent
  ModeListener ml1 = new TestListener( myRadio, test1 );
  ModeListener ml2 = new Test2Listener( myRadio, test2 );

    //Example of processor updating a mode event
  myRadio.modeChange( UEBMode.NUMERICandSPECG1 );
 }
}