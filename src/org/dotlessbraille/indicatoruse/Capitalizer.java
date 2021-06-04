package org.dotlessbraille.indicatoruse;
import java.util.ArrayList;
import java.lang.Character;
import org.dotlessbraille.indicators.IndicatorType;
import org.dotlessbraille.indicators.Scope;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.CapsIndicator;

//Capitalizes back-translated print per Caps Indicator
class Capitalizer{

/** UEB has three types of capitalization indicators 
    which have quite different behavior. These are
    described in great detail in Section 8 of the UEB Manual.

    Capital letters
    ---------------
    Capital letters in UEB are a prefix-root sign consisting 
    (typically) of DOT6 followed immediately by a letter that
    represents a single capital letter or by a contraction where
    only the first letter is capitalized in print. 
    However, in order
    to represent an uppercase ligature it is necessary that
    the ligature indicator (between the first the 
    second letter) is
    **preceded** by the DOT6. (The first letter is just an
    ordinary capital letter but the 5-cell 2-symbol construct
    represents a single print symbol.)

    Capital "words"
    ---------------
    The "Capitalised Word Indicator", DOT6 DOT6, capitalizes
    the following sequence of two or more letters.  It is 
    terminated by any braille sign that doesn't represent a 
    sequence of two or more print letters. Thus it is not 
    terminated by most contractions but is terminated by
    by default by an apostrophe or other punctuation mark, 
    a capital letter, a space, etc. It can also be
    terminated explicitly by the "Capitals Terminator", DOT6 DOT3,
    in cases where a small letter follows a capital sequence.

    Note that if an apostrophe is followed by a capital letter,
    a capital letter sign must be used to represent that letter.
   
    Capital passage
    ---------------
    The "Capitalised Pasage Indicator", DOT6 DOT6 DOT6, sets
    capitals mode for the next passage and is only terminated
    by a Capitals Terminator immediately following the passage.
 
    A passage is defined as a sequence of three or more items
    where an item is a symbols-sequence or "an unbroken string of
    braille signs, whether alphabetic or non-alphabetic, 
    preceded and followed by a space." It seems that in
    practice a passage indicator can be preceded by another
    passage indicator as well as by a space.

    Per the examples, the first item should start with a capital
    letter but the remaining signs in the first item and all
    of the signs in the remaining items can be anything other
    than small letters.  

*/

 static ArrayList <Indicator> capInds = new ArrayList<Indicator>();
 static IndicatorType indicatorType = IndicatorType.CAPITAL;

//TO-DO set elsewhere?
 static String capWordInd = ",,";
 static String capLetterInd = ",";

 String working;
 int start;
 boolean done = false;
 StringBuilder buf;

Capitalizer( String working, int start ){
 this.working = working;
 this.start = start;
 buf = new StringBuilder();
}
String getWorking(){ return working; }
void setWorking( String working){
 this.working = working;
}
int getStart(){ return start; }
void setStart( int startPos ){
 this.start = startPos;
}

void setDone( boolean done){
  this.done = done;
}

static String capIt( String seq ){
 CapsIndicator capInd = (CapsIndicator)
   PendingInds.getPending( IndicatorType.CAPITAL );
 if (capInd == null) return seq;
 return capIt( capInd, seq );
}
static String capIt( CapsIndicator capInd, String seq ){
 Scope scope = capInd.getScope();
 return cap4Scope( scope, seq );
}
static String cap4Scope( Scope scope, String seq ){

 switch( scope ){
  case NEXT_LETTER:
   return capSym( seq );

  case ALPHABETIC: 
   return capWordSeq( seq );
  
  case PASSAGE:
   return capPass( seq );
 
    //  A terminator could terminate either a passage
    // or an alphabetic seq
  case TERMINATOR:
   if (seq != null){
     System.out.println( "Capitalizer.capit warning: "+
     "Term ind associated with text???" );
   } 
   PendingInds.clearPending( indicatorType );
   return seq; 
  }

  System.out.println( "Bad cap ind." );
  return "";
}

// Does English locale support capitalizing a ligature?
static String capSym( String alphabetic ){
 StringBuilder buf = new StringBuilder();
 buf.append( alphabetic.substring(0,1).toUpperCase() );
 for (int i=1; i<alphabetic.length(); i++){
  buf.append( alphabetic.substring(i,i+1).toLowerCase() );
 }
 PendingInds.clearPending( indicatorType );
 return buf.toString();
}


//  Capitalizes back-translated, i.e. print, letters
// that are single characters. The Character.isLowerCase()
// should work for any Unicode letter including those
// backtranslated from letters preceded by UEB modifiers.
// The capitalisation indicator with the word (or sequence)
// scope is terminated by any character that is
// not a lowercase letter

//The caps passage indicator is not terminated by
//any characters and is thus incorrectly used
//if the intended print passage contains a lower case letter

public static String capWordSeq( String seq ){
 if (seq == null) return seq;
 CapsIndicator capInd = (CapsIndicator)
   PendingInds.getPending( IndicatorType.CAPITAL );
 if (capInd == null) return seq;
 if (capInd.getScope() != Scope.ALPHABETIC ) return seq;

 StringBuilder buf = new StringBuilder();
 //boolean capit = true;
 int inext = 0;
 for (int i= 0; i<seq.length(); i++){
   
     if (Character.isLowerCase( seq.charAt( i ))){
       buf.append( seq.substring(i,i+1).toUpperCase() );
     } else {
       PendingInds.clearPending( IndicatorType.CAPITAL );
       inext = i;
       break;
     }
 }
 //String cseq = buf.toString();
 if (buf.length() == seq.length()) return buf.toString();
 buf.append( seq.substring( inext ) );
 return buf.toString();
}
//This needs to be more sophisticated somewhere
//  what if you ABCabcABCabc
 
void xcapWordSeqs( ){
 //Capitalizes a backtranslated to print sequence following 
 //a UEB caps word indicator.  The sequence may
 //contain previously capitalized letters and/or
 //one or more additional caps word indicators.
 //The string to be processed starts with the character
 //after the caps word indicator
 boolean go = true;
 for (int i= getStart(); i<working.length(); i++){
   if (go){
     if (Character.isLowerCase( working.charAt( i ))){
       buf.append( working.substring(i,i+1).toUpperCase() );
     } else {
       buf.append( working.substring(i,i+1) );  //capterm is ,'??
       setStart( i );
       if (xisCapsWInd()) return; 
       go = false;
     }
  } else {
    buf.append( working.substring(i,i+1) );
    setStart( i );
    if (xisCapsWInd()) return; 
   }
 }
 setDone( true );
}

boolean xisCapsWInd(){
 if (isCapWordInd()) return true;
 return false;
}
//Check for subsequent letter rules out caps terminator...
boolean xisCapLetterInd( ){
 int i = getStart();
 String tmp = working.substring( i );
 if (tmp.length() < 2) return false;
 if (tmp.startsWith( capLetterInd ) &&
     Character.isLetter( tmp.charAt(1)) ){
     return true;
 }
 return false;
}
boolean isCapWordInd( ){
 int i = getStart();
 String tmp = working.substring( i );
 if (tmp.length() < 3) return false;
 if (tmp.startsWith( capWordInd )){ 
     buf.append( working.substring(i+1,i+2) );
     setStart( i+2 );
     return true;
 }
 return false;
}



static String capPass( String printSeq ){
 System.out.println( "Capitalizer.capPass() printSeq: "
   +printSeq );
 StringBuilder buf = new StringBuilder();
 for (int i=0; i<printSeq.length(); i++){
   if (Character.isLowerCase( printSeq.charAt( i ))){
    System.out.println( "Capitalizer.capPass WARNING: "+
     "passage has lower case letter: "+printSeq.charAt( i ) );
   }
   if (Character.isLetter( printSeq.charAt( i ))){
    buf.append( printSeq.substring(i,i+1).toUpperCase() );
   } else {
   buf.append( printSeq.substring(i,i+1) );
   }
  }
  return buf.toString();
}

public static void main (String [] args){
 System.out.println( "Hi!" );

}    
    
}//End Class Capitalizer