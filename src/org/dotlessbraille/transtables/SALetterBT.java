package org.dotlessbraille.transtables;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.indicatoruse.CapsFlag;;
class SALetterBT{
   
  //Backtranslator for a single Latin letter or a sequence
  //of Latin letters  "standing alone" such that they
  //represent whole word contractions in contracted
  //braille but will be translated correctly in 
  //either uncontracted  or contracted braille

 PendingCapInds capInfo;  //Provides information about capitalization
 //Status status;        //Accepts information about translation

 static final String DOT6 = ",";
 boolean trace = true;

 SALetterBT( PendingCapInds capInfo ){
  this.capInfo = capInfo;
  //this.status = status;
 }
 SALetterBT( PendingCapInds capInfo,  boolean trace ){
  this.capInfo = capInfo;
  //this.status = status;
  setTrace( trace );
 }
 void setTrace( boolean trace ){
  this.trace = trace;
 }

     //BACK-TRANSLATION FOR STANDING ALONE ITEMS
//Don't need both cap cases if handled by status guy
String backTransLetter( String aBrl, boolean grade2 ){

 boolean tc = false;
 int is = 0;
 if ( DOT6.equals( aBrl.substring(0,1) ) ){
  tc = true;
  is = 1;
 }
 int lentest = 1;

 if ( grade2 ){
   if (tc){
    lentest = 2;
   }
   if (aBrl.length() > lentest ){
      return btSeq( aBrl, grade2);
     //System.out.println( "SALetterBT grade2 not available for shortforms." );
   } else {
      //Single-letter whole-word contracionts
     String ww;
     if (tc){
       ww = Word.backTC( aBrl.substring( is ) );
     } else {
       //Need to use cap passage/word info here!
       CapsFlag cf = capInfo.getCapsFlag();
       if (cf == CapsFlag.UC){
        ww = Word.backUC( aBrl.substring( is ) );
       } else {
        ww = Word.backLC( aBrl.substring( is ) );
       }
     }
     return ww;
   }

 } //End grade 2 backtanslation

 //if (aBrl.length() > lentest) return btSeq( aBrl, grade2);

  //Individual letter when uncontracted
 String ink = null;
 if (aBrl.length() == 1 ){
     if (capInfo.getCapWordInd()){
       ink = Letter.backTrans2UC( aBrl );
       if (trace) System.out.println( "bT2UC: "+ink ); 
      } else if (capInfo.getCapPassInd()) {
       // OK if (ink == null ) since non-letters permitted; see below
       ink = Letter.backTrans2UC( aBrl ); 
      } else {
       ink = Letter.backTrans( aBrl );  //lc letter or single caps letter
      } 
 } else if (tc ){
   ink = Letter.backTrans2UC( aBrl.substring(1 ) );
 } else {
   System.out.println( "SALetterBT logic error input: "+aBrl );
   System.exit( 1 );
  }
 return ink; 
}

    //TOO MUCH HARD-WIRED???
    //Sequences of more than one letter, could be a shortform
String btSeq( String brl, boolean grade2 ){

  //This logic is repeated since may want to start here???
 trace = true;
 String ink;
 boolean tc = false;
 int is = 0;

 //Handling special case of TC contraction
 // for backtrans at entire sequence level
 if ( DOT6.equals( brl.substring(0,1) ) ){
  tc = true;
  is = 1;
 }
 if (trace){
  System.out.println( "SALetterBT brl btSeq() tc, is: "
                      +brl+" "+tc+" "+is );
 }
 if (grade2) {
  ink = tryShortform( brl.substring( is ), tc );
  System.out.println( "Tried sf in BTseq--ink: |"+ink+"|");
  if (ink != null) return ink;
 } 
 System.out.println( "btSeq -- not a shortform." );
 StringBuilder buf = new StringBuilder();
 for (int i=is; i<brl.length(); i++){
  String tmp = brl.substring(i, i+1);
  if (trace) System.out.println( "SALetterBT brl letter: "+tmp );
  ink = Letter.backTrans( tmp );
  if (tc && i==is){
   ink = ink.toUpperCase() ;
  }
  buf.append( ink );
 }
 if (capInfo.getCapPassInd() ||
     capInfo.getCapWordInd()   ){ 
   return buf.toString().toUpperCase();
 }
 if (trace) System.out.println( "SALetterBT ink: "+buf.toString() );
 return buf.toString();
}
 //Method assumes any leading dot-6 removed and tc flag is true
private String tryShortform( String brl, boolean tc ){
 if (tc) return WordOrPartWord.backTC( brl );
 String ink;
 if (capInfo.getCapWordInd()){
       ink = WordOrPartWord.backUC( brl );
       if (trace) System.out.println( "bT2UC: "+ink ); 
 } else if (capInfo.getCapPassInd()) {
       // OK if (ink == null ) since non-letters permitted; see below
       ink = WordOrPartWord.backUC( brl );
 } else {
       ink = WordOrPartWord.backLC( brl );  
 } 
 return ink;
} 
//String backWW( String brl ){
  //Check for single letter
  //return wwCon2Ink.get( brl.toLowerCase() ).getInk();
 //return "";
//}
}//End Class.

