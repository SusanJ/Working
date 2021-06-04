package org.dotlessbraille.driver;
import org.dotlessbraille.transtables.App1Word;
import org.dotlessbraille.transtables.LargeWord;
import org.dotlessbraille.transtables.Letter;
import org.dotlessbraille.transtables.PartWord;
import org.dotlessbraille.transtables.Word;
import org.dotlessbraille.transtables.WordOrPartWord;

//Adapter for using classes frp, transtables package for backtranslation
// of words

class TransWrapper{

 enum wordCase{ LC, TC, UC };
 enum itemType{APP1, FLC, ILC };
 public static final String upperCells =
  "abcdefghijABCDEFGHIJ1\"@^3)";  //15 ASCII Braille cells
 //Cells with no dots in top row
 public static final String lowerCells =
  "1234567890'\",;-";
 public static final String capLetter = ",";
 public static final String capWord = ",,"; 

//=================================================

TransWrapper(){}

  //FIX -- placeholder for switch on itemType
public static String bakTrans( String brl, itemType iT ){
 return null;
}
  //Section 10.1 Alphabetic Wordsigns (Standing Alone)
  //Section 10.2 Strong Wordsigns
public static String bakLetterAsWord( String brl ){
 int len = brl.length();
 if (len == 1) return Word.backLC( brl );
 if (len == 2){
  if (brl.startsWith( capLetter )){
    return Word.backTC( brl.substring( 1 ) );
  } else {
   System.out.println( "TransWrapper--backLetterAsWord "+
    "unexpected braille input: "+brl );
   return null;
  }
 }
 if (len == 3){
  if (brl.startsWith( capWord )){
    return Word.backTC( brl.substring( 2 ) );
  } else {
   System.out.println( "TransWrapper--backLetterAsWord "+
    "unexpected braille input: "+brl );
   return null;
  }
 }
 return null;
}

  //10.3 Strong or (Large Sign) Contractons
 public static String bakLarge( String brl, String cap ){
  String ink = null;
  if (cap == null){
   ink = LargeWord.backLC( brl );
  } else if (cap.equals( capLetter )){
   ink = LargeWord.backTC( brl );
  }
 return ink;
}
/**
public static String btLarge( String brl, wordCase opt ){
 switch (opt){ 
  case LC:
   return LargeWord.backLC( brl );
  case TC:
   return LargeWord.backTC( brl );
  case UC:
   return LargeWord.backUC( brl );
 }
 return null;
}
*/ 

//  Section 10.4 Strong Groupsigns
// The strong groupsigns are single-cell contractions
// that can be used anywhere in a word with the same
// meaning.
public static String btStrongGS( String brl, boolean tc ){
 return PartWord.backStrongGS( brl, tc);
}

// 10.5 Lower Wordsigns
// 10.6 Lower GroupSigns
//  Section 10.7 Initial-letter contractions
//   (Input the 2-cell braille contraction, no indicators)
public static String btILC( String brl, wordCase opt ){
 switch (opt){ 
  case LC:
   return WordOrPartWord.ilcBackLC( brl );
  case TC:
   return WordOrPartWord.ilcBackTC( brl );
  case UC:
   return WordOrPartWord.ilcBackUC( brl );
 }
 return null;

//  Section 10.8 Final-letter groupsigns
public static String backFLC( String brl ){
 return PartWord.backFLC( brl );
}

//  Section 10.9 Shortforms

   public static boolean isShortform( String seq ){
     //{System.out.println( "SEQ: "+seq );
     //WordOrPartWord.makePartWordTable( true, true);
     return WordOrPartWord.isShortform( seq );
     }

//       ===================================
//           Miscellaneous Words

      //Word consisting of just letters, lc or tc
      //[Assumes already tested as not an Appendix 1 word.)
public static String backAlphaSeq( String brl, boolean tc ){
 return Letter.backTransAlphaSeq( brl, tc );
}
      //Alpha sequence with leading CapitalLetter token
public static String backAlphaSeq( String capLetter, String rest ){
  StringBuilder buf = new StringBuilder( capLetter.substring( 1 ) );
  buf.append( rest );
  String ink = backAlphaSeq( buf.toString(), false );
  if (ink == null) return null;
  return toTC( ink );
 }

// Words with one or more contractions and possibly letters

      //Appendix 1 Words (Words in UEB official list of words that
      // contain one or more shortform contractions) 
 public static boolean isApp1Word( String brl ){
   String ink = App1Word.getApp14Brl( brl );
   if (ink == null) return false;
   return true;
}
 public static String btApp1Word( String brl ){
  return App1Word.getApp14Brl( brl );
 }
 public static String btApp1Word( String capLetter, String rest ){
  StringBuilder buf = new StringBuilder( capLetter.substring( 1 ) );
  buf.append( rest );
  String ink = btApp1Word( buf.toString() );
  if (ink == null) return null;
  return toTC( ink );
 }
 
/**
static String backILClc( String brl ){
 return WordOrPartWord.ilcBackLC( brl );
}
static String backILCtc( String brl ){
 return WordOrPartWord.ilcBackTC( brl );
}
static String backILCuc( String brl ){
 return WordOrPartWord.ilcBackUC( brl );
}
*/
 

static String backLetOrGSAsWord( String brl, wordCase opt ){

 switch (opt){ 
  case LC:
   return Word.backLC( brl );
  case TC:
   return Word.backTC( brl );
  case UC:
   return Word.backUC( brl );
 }
 return null;
}

//----------------------------------------------
public static String toTC( String word ){
 StringBuilder buf = new StringBuilder( word.substring(0,1).toUpperCase() );
 if (word.length() == 1) return buf.toString();
 buf.append( word.substring( 1 ) );
 return buf.toString();
}

}//End Class TransWrapper