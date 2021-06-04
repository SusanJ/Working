package org.dotlessbraille.transtables;
import java.util.HashMap;
public class Word{

           /**Single-cell words array. */

//   "single-cell whole words including 'a', 'i' and 'o'" )
// and the six "strong wordsigns"
 public static final Word [] singleCellWords = {
  new Word( "a", "a", "a" ),  
  new Word( "&#x00CC;", "b", "but" ),
  new Word( "&#x00CD;", "c", "can" ),
  new Word( "&#x00CE;", "d", "do" ),
  new Word( "&#x00CF;", "e", "every" ),
  new Word( "&#x00D0;", "f", "from" ),
  new Word( "&#x00D1;", "g", "go" ),
  new Word( "&#x00D2;", "h", "have" ),
  new Word( "i", "i", "i" ),
  new Word( "&#x00D3;", "j", "just" ),
  new Word( "&#x00D4;", "k", "knowledge" ),
  new Word( "&#x00D5;", "l", "like" ),
  new Word( "&#x00D6;", "m", "more" ),
  new Word( "&#x00D7;", "n", "not" ),
  new Word( "o", "o", "o" ),
  new Word( "&#x00D8;", "p", "people" ),
  new Word( "&#x00D9;", "q", "quite" ),
  new Word( "&#x00DA;", "r", "rather" ),
  new Word( "&#x00DB;", "s", "so" ),
  new Word( "&#x00DC;", "t", "that" ),
  new Word( "&#x00DD;", "u", "us" ),
  new Word( "&#x00DE;", "v", "very" ),
  new Word( "&#x00DF;", "w", "will" ),
  new Word( "&#x00E0;", "x", "it" ),
  new Word( "&#x00E1;", "y", "you" ),
  new Word( "&#x00E2;", "z", "as" ),
  new Word( "&#x00B5;", "%", "shall" ),
  new Word( "&#x00B6;", "*", "child" ),
  new Word( "&#x00B7;", "/", "still" ),
  new Word( "&#x00B8;", ":", "which" ),
  new Word( "&#x00B9;", "?", "this" ),
  new Word( "&#x00BA;", "\\", "out" ),
 };

 public static HashMap<String, Word> wwCon2Ink = 
    new HashMap<String, Word>();
 public static HashMap<String, Word> Ink2wwCon = 
    new HashMap<String, Word>();

 String db;
 String brl;
 String ink;
 String inkTC;
 String inkUC;

Word( String db, String brl, String ink ){
 this.db = db;
 this.brl = brl;
 this.ink = ink;
 this.inkTC = makeTC( ink );
 this.inkUC = ink.toUpperCase();
 //wwCon2Ink.put( brl, this );
 //Ink2wwCon.put( ink, this );
 }
static void makeWholeWordTable( boolean report, boolean display){
 for (int w = 0; w<singleCellWords.length; w++){
  Word slw = singleCellWords[w];
  wwCon2Ink.put( slw.getBrl(), slw );
  Ink2wwCon.put( slw.getInk(), slw);
 }
 if (report)
  System.out.println( "     Whole Word Table complete." );
}
String getBrl(){
 return brl;
}
String getInk(){
 return ink;
}
String getInkTC(){
 return inkTC;
}
String getInkUC(){
 return inkUC;
}
static String makeTC( String ink ){
   //Expected length > 1 in UEB!
 if (ink.length() == 1) return ink.toUpperCase();
 StringBuilder buf = new StringBuilder();
 buf.append( ink.substring( 0, 1 ).toUpperCase() );
 buf.append( ink.substring( 1 ) );
 return buf.toString();
}
//public static void init(){
 //Word tmp = new Word( "tmp", "tmp", "tmp" );
 //System.out.println( "Word init." );
//}
public static Word getWord4Brl( String brl ){
 return wwCon2Ink.get( brl );
}
public static Word getWord4Ink( String ink ){
 return Ink2wwCon.get( ink.toLowerCase() );
}
  //Convert brl to LC to support UC ASCII Braille
public static String backLC( String brl ){
 return wwCon2Ink.get( brl.toLowerCase() ).getInk();
}
public static String backTC( String brl ){
 return wwCon2Ink.get( brl.toLowerCase() ).getInkTC() ;
}
public static String backUC( String brl ){
 return wwCon2Ink.get( brl.toLowerCase() ).getInkUC();
}
}//End Class Word.