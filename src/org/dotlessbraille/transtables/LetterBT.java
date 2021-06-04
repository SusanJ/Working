package org.dotlessbraille.transtables;
import org.dotlessbraille.indicatoruse.PendingCapInds;
public class LetterBT{
   
  //Translator for individual letters taking into
  // capitalization status

 PendingCapInds capInfo;  //Provides information about capitalization
 //Status status;        //Accepts information about translation

 boolean trace = false;

 LetterBT( PendingCapInds capInfo ){
  this.capInfo = capInfo;
  //this.status = status;
 }
 LetterBT( PendingCapInds capInfo,  boolean trace ){
  this.capInfo = capInfo;
  //this.status = status;
  setTrace( trace );
 }
 void setTrace( boolean trace ){
  this.trace = trace;
 }

//Don't need both cap cases if handled by status guy
 String backTransLetter( String aBrl ){
  String ink;
     if (capInfo.getCapWordInd()){
       ink = Letter.backTrans2UC( aBrl );
       if (trace) System.out.println( "bT2UC: "+ink ); 
       //if (ink == null ) capWordInd = false; //non-letters terminate
      } else if (capInfo.getCapPassInd()) {
       // OK if (ink == null ) since non-letters permitted; see below
       ink = Letter.backTrans2UC( aBrl ); 
      } else {
       ink = Letter.backTrans( aBrl );  //lc letter or single caps letter
      } 
 return ink; 
}
}//End Class.

