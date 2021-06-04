package org.dotlessbraille.transtables;
import org.dotlessbraille.manifold.Sign;
import java.util.HashMap;
/** Handles the five braille one-cell symbols known as "large words" 
  because they have an above-average number of dots in their
  cells. When used as words these symbols could be sequenced or 
  written unspacde from each other in EBAE and other older English
  braille codes but this is not allowed in UEB. The large signs can
  be used as part word contractions without genereal restriction to
  position with a word.
*/
public class LargeWord extends Sign{
public static final LargeWord [] largeWords = {
  new LargeWord( "&#x0247;", "&", "and",     "&#x00A1;", "&" ),
  new LargeWord( "&#x0248;", "=", "for",     "&#x00AF;", "=" ),
  new LargeWord( "&#x0249;", "(", "of",      "&#x00A6;", "(" ),
  new LargeWord( "&#x024A;", "!", "the",     "&#x00A1;", "!" ),
  new LargeWord( "&#x024B;", ")", "with",    "&#x00A7;", ")" )
 };

 public static HashMap<String, LargeWord> largeCon2Ink = 
    new HashMap<String, LargeWord>();
 public static HashMap<String, LargeWord> ink2LargeCon = 
    new HashMap<String, LargeWord>();

public static boolean debug = false;

/** The two different DotlessBraille glyphs have been 
    retained for historial reasons. The one used now
    is less squashed in appearance than the one designed to
    be used when two or more large words were sequences.
 */
 String oldDbSeq;
 //String aBrl;
 //String ink;
 //String inkTC;
 //String inkUC;
 //String dbCode;
 PartWordUse partWordUse = PartWordUse.ANYWHERE;
//===============================================================
 public LargeWord (String oldDbSeq, String aBrl, String ink, 
                   String dbCode, String aUnseq ){
  this.oldDbSeq = oldDbSeq;
  this.aBrl = aBrl;
  this.ink = ink;
  inkUC = ink.toUpperCase();
  inkTC = Word.makeTC( ink );
  this.dbCode = dbCode;
 }

//String getBrl(){ return aBrl; }
//String getInk(){ return ink; }
//String getInkTC(){ return inkTC; }
//String getInkUC(){ return inkUC; }

   //Hash tables for forward  and backtranslation.
static void makeLargeWordTable( boolean report, boolean display){
 for (int l = 0; l < largeWords.length; l++){
  LargeWord largeWord = largeWords[l];
  largeCon2Ink.put( largeWord.getBrl(), largeWord );
  ink2LargeCon.put( largeWord.getInk(), largeWord );
 }
 if (report){
  int cnt = largeCon2Ink.size();
  System.out.println( "     Large Word Table complete. ("+cnt+")" );
 }
}
public static boolean isLargeWord( String brl ){
 return largeCon2Ink.containsKey( brl );
}
public static String backLC( String brl ){
 LargeWord lw = largeCon2Ink.get( brl );
 if (debug) System.out.println( "lw: "+lw );
 if (lw == null) return (String) null;
 if (debug) System.out.println( "LW--trans: "+lw.getInk() );
 return lw.getInk();
}
public static String backTC( String brl ){
 LargeWord lw = largeCon2Ink.get( brl );
 if (lw == null) return (String) null;
 return lw.getInkTC() ;
}
public static String backUC( String brl ){
 LargeWord lw = largeCon2Ink.get( brl );
 if (lw == null) return (String) null;
 return lw.getInkUC();
}
public static Sign back2Sign( String brl ){
 LargeWord lw = largeCon2Ink.get( brl );
 //System.out.println( "pw: "+pw );
 return lw;
}

}//End Class.