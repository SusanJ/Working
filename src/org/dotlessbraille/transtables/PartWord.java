package org.dotlessbraille.transtables;
import java.util.HashMap;
import org.dotlessbraille.utilities.BrailleCell;

 public class PartWord{

  // I don't remember why I needed these static variables.  Possibly
  //for cross-reference to support learner brailles.

 public static final PartWord CON_PW =
  new PartWord( PartWordUse.BEG_WORD, "&#x00C1;", "3", "con", true );

 public static final PartWord DIS_PW = 
   new PartWord( PartWordUse.BEG_WORD, "&#x00C3;", "4", "dis" );

  
 public static final PartWord ED =  
  new PartWord( PartWordUse.ANYWHERE, "&#x00A3;", "$", "ed" );

 public static final PartWord ST = 
  new PartWord( PartWordUse.ANYWHERE,     "&#x00AB;", "/", "st", true );

 public static final PartWord ING =
  new PartWord( PartWordUse.MID_END_WORD, "&#x00A9;", "+", "ing" );

 //public static final PartWord COM =
  //new PartWord( PartWordUse.BEG_WORD,     "&#x00AA;", "-", "com" );

 public static final PartWord [] lettersigns = {

  new PartWord( PartWordUse.ANYWHERE, "&#x00A8;", "*", "ch", true, true ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00AE;", "<", "gh", 1 ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00A4;", "%", "sh", true ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00B1;", "?", "th", true, true ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00AC;", ":", "wh", false, true ),

  //new PartWord( PartWordUse.ANYWHERE, "&#x00A3;", "$", "ed" ),
  ED,
  new PartWord( PartWordUse.ANYWHERE, "&#x00B4;", "]", "er", true, 1 ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00B3;", "\\", "ou", true, true, 1 ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00B2;", "[", "ow" ),
  ING,
  //new PartWord( PartWordUse.MID_END_WORD, "&#x00A9;", "+", "ing" ),
  //COM,
  //new PartWord( PartWordUse.BEG_WORD,     "&#x00AA;", "-", "com" ),
  //new PartWord( PartWordUse.ANYWHERE,     "&#x00AB;", "/", "st", true ),
  ST,
  //new PartWord( PartWordUse.MID_END_WORD, "&#x00A2;", "#", "ble" ),
  new PartWord( PartWordUse.ANYWHERE,     "&#x00B0;", ">", "ar" ),
 
  new PartWord( PartWordUse.MID_WORD, "&#x00BD;", "1", "ea" ),
  new PartWord( PartWordUse.BEG_WORD, "&#x00BF;", "2", "be" ),
  new PartWord( PartWordUse.MID_WORD, "&#x00BE;", "2", "bb" ),
  //new PartWord( PartWordUse.BEG_WORD, "&#x00C1;", "3", "con", true ),
  CON_PW,
  new PartWord( PartWordUse.MID_WORD, "&#x00C0;", "3", "cc" ),
       //NOTE 

  //new PartWord( PartWordUse.BEG_WORD, "&#x00C3;", "4", "dis" ),
  DIS_PW,
//Nt IN UEB
  //new PartWord( PartWordUse.MID_WORD, "&#x00C2;", "4", "dd" ),
  new PartWord( PartWordUse.ANYWHERE, "&#x00C4;", "5", "en", 1),
  new PartWord( PartWordUse.ANYWHERE, "&#x00C4;", "9", "in", 1),
  new PartWord( PartWordUse.MID_WORD, "&#x00C6;", "6", "ff" ),
  new PartWord( PartWordUse.MID_WORD, "&#x00C8;", "7", "gg"),
  new PartWord( PartWordUse.ANYWHERE, "&#x00AE;", "7;R7", "&#x00AE;"),

       //italicized apostrophe ess
  //new PartWord( PartWordUse.ANYWHERE, "&#x0220;'&#x0220;&#x0221;s", 
                                   //".'.;S", "<i>'s</i>" )   
 };

  //UEB eliminated "ation" and "ally" 
 public static final PartWord [] finalLetterCons = {
  new PartWord( PartWordUse.MID_END_WORD, "&#x0125;&#x0126;", ".d", "ound" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0127;&#x0128;", ".e", "ance" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0129;&#x012A;", ".n", "sion" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x012B;&#x012C;", ".s", "less" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x012D;&#x012E;", ".t", "ount" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x012F;&#x0130;", ";e", "ence" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0131;&#x0132;", ";g", "ong" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0133;&#x0134;", ";l", "ful" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0135;&#x0136;", ";n", "tion" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0137;&#x0138;", ";s", "ness" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x0139;&#x013A;", ";t", "ment" ),
  new PartWord( PartWordUse.MID_END_WORD, "&#x013B;&#x013C;", ";y", "ity" )
  //ATION,
  //ALLY
 };

 public static HashMap<String, PartWord> strongCon2Ink = 
    new HashMap<String, PartWord>();
 public static HashMap<String, PartWord> ink2StrongCon = 
    new HashMap<String, PartWord>();

 public static HashMap<String, PartWord> begOKCon2Ink = 
    new HashMap<String, PartWord>();
 public static HashMap<String, PartWord> ink2BegOKCon = 
    new HashMap<String, PartWord>();

 public static HashMap<String, PartWord> midOKCon2Ink = 
    new HashMap<String, PartWord>();
 public static HashMap<String, PartWord> ink2MidOKCon = 
    new HashMap<String, PartWord>();

 public static HashMap<String, PartWord> endOKCon2Ink = 
    new HashMap<String, PartWord>();
 public static HashMap<String, PartWord> ink2endOKCon = 
    new HashMap<String, PartWord>();

public static HashMap<String, PartWord> flc2Ink = 
    new HashMap<String, PartWord>();




  boolean usedInShortForm;
  int usedInLWFlag;
  boolean usedInSpelledOutLW;
  boolean usedInIlCon;
  PartWordUse used;
  String dbCharRef;
  String aBrl;
  String ink;
  String inkUC;
  String inkTC;
  String xBrl;
 

public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink){
 this.used = used;
 this.dbCharRef = dbCharRef;
 this.aBrl = aBrl;
 //this.aBrl = aBrl.toUpperCase();
 //this.aBrl = BrailleCell.normalizeASCIIBraille( aBrl );
 this.ink = ink;
 this.inkUC = ink.toUpperCase();
 this.inkTC = Word.makeTC( ink );
 
 this.xBrl = BrailleCell.toUni( dbCharRef );
 //unCustom();
 //putSign( this );
}
//..............................................................
public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink, int usedInLWFlag){
 this (used, dbCharRef, aBrl, ink);
 if (usedInLWFlag == 1) this.usedInSpelledOutLW = true;
 //putSign( this );
}
//..............................................................
public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink,
          boolean usedInShortForm){
 this (used, dbCharRef, aBrl, ink);
 this.usedInShortForm = usedInShortForm;
 //putSign( this );
}
//..............................................................
public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink,
          boolean usedInShortForm,
          int usedInLWFlag){
 this (used, dbCharRef, aBrl, ink);
 this.usedInShortForm = usedInShortForm;
 if (usedInLWFlag == 1) this.usedInSpelledOutLW = true;
 //putSign( this );
}
//..............................................................
public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink,
          boolean usedInShortForm,  
          boolean usedInIlCon ){
 this (used, dbCharRef, aBrl, ink, usedInShortForm);
 this.usedInIlCon = usedInIlCon;
 //putSign( this );
}
//..............................................................
public PartWord (PartWordUse used, String dbCharRef, 
          String aBrl, String ink,
          boolean usedInShortForm,  
          boolean usedInIlCon, 
          int usedInLWFlag){
 this (used, dbCharRef, aBrl, ink, usedInShortForm);
 this.usedInIlCon = usedInIlCon;
 if (usedInLWFlag == 1) this.usedInSpelledOutLW = true;
 //putSign( this );
}
String getBrl(){return aBrl;}
String getInk(){return ink;}
String getInkTC(){return inkTC;}
String getInkUC(){return inkUC;}

public static void makePartWordTables( boolean report, boolean display ){

 System.out.println( "Lettersign table: "+lettersigns.length );

 //Strong contractions have their own table and are also
 //grouped with each of the other three types
 for (int ls=0; ls < lettersigns.length; ls++ ){
  PartWord pw = lettersigns[ls];
  PartWordUse used = pw.used;
  if (used == PartWordUse.ANYWHERE){
   //System.out.println( pw.getBrl()+"  "+pw.getInk() );
   strongCon2Ink.put( pw.getBrl(), pw);
   ink2StrongCon.put( pw.getInk(), pw);

   begOKCon2Ink.put( pw.getBrl(), pw);
   ink2BegOKCon.put( pw.getInk(), pw);

   midOKCon2Ink.put( pw.getBrl(), pw);
   ink2MidOKCon.put( pw.getInk(), pw);

   endOKCon2Ink.put( pw.getBrl(), pw);
   ink2endOKCon.put( pw.getInk(), pw);
  }
  if (used == PartWordUse.BEG_WORD){  
   begOKCon2Ink.put( pw.getBrl(), pw);
   ink2BegOKCon.put( pw.getInk(), pw);
  }
  if (used == PartWordUse.MID_WORD){
   midOKCon2Ink.put( pw.getBrl(), pw);
   ink2MidOKCon.put( pw.getInk(), pw);
  }
  if (used == PartWordUse.MID_END_WORD){
   midOKCon2Ink.put( pw.getBrl(), pw);
   ink2MidOKCon.put( pw.getInk(), pw);
   endOKCon2Ink.put( pw.getBrl(), pw);
   ink2endOKCon.put( pw.getInk(), pw);
  }
   
 }
 //report = true;
 if (report){
  int cnt = strongCon2Ink.size();
  System.out.println( "     Strong contractions table complete. ("
    +cnt+")" );
  cnt = begOKCon2Ink.size();
  System.out.println( "     All start-of-word cons. "+
     "table complete. ("+cnt+")" );
  cnt = midOKCon2Ink.size();
  System.out.println( "     All middle-of-word cons. "+
     "table complete. ("+cnt+")" );
 }
 makeFLCTable( report, display );
}
 //Adds to table with ANYWHERE contractions, not a separate table
public static void makeFLCTable( boolean report, boolean display ){

  System.out.println( "Final letter cons. count: "+
                       finalLetterCons.length );

 // Final-lettet contractions only in the MID_END table
 //which also includes the ANYWHERE contractions
 for (int flc=0; flc < finalLetterCons.length; flc++ ){

  
  PartWord pw = finalLetterCons[flc];
//  Extra table that doesn't check for position
  flc2Ink.put( pw.getBrl(), pw );
  PartWordUse used = pw.used;
  if (used == PartWordUse.MID_END_WORD){
   midOKCon2Ink.put( pw.getBrl(), pw);
   ink2MidOKCon.put( pw.getInk(), pw);
   endOKCon2Ink.put( pw.getBrl(), pw);
   ink2endOKCon.put( pw.getInk(), pw);
  } else {
   System.out.println( "PartWord.makeFLCTable()--LOGIC ERROR!" );
   System.out.println( " Wrong use flag: "+used );
   System.exit( 0 );
  }
 }
 if (report){
  int cnt = midOKCon2Ink.size();
  System.out.println( "     All ok in interior-of-word cons. "+
     "table complete. ("+cnt+")" );
  cnt = endOKCon2Ink.size();
  System.out.println( "     All ok at end-of-word cons. "+
     "table complete. ("+cnt+")" );
 }
}

 //Anywhere + beg
public static boolean isBegOkCon( String brl ){
 return begOKCon2Ink.containsKey( brl );
}
 //Anywhere + mid + midend
public static boolean isMidOkCon( String brl ){
 return midOKCon2Ink.containsKey( brl );
}
 //Anywhere + midend
public static boolean isEndOkCon( String brl ){
 return endOKCon2Ink.containsKey( brl );
}
  // Backtranslates only the the strong contractions
  //that can be used anywhere
public static String backSG2LC( String brl ){
 PartWord pw = strongCon2Ink.get( brl );
 if (pw != null) return pw.getInk();
 return (String) null;
}
public static String backSG2TC( String brl ){
 PartWord pw = strongCon2Ink.get( brl );
 if (pw != null) return pw.getInkTC();
 return (String) null;
}
public static String backSG2UC( String brl ){
 PartWord pw = strongCon2Ink.get( brl );
 if (pw != null) return pw.getInkUC();
 return (String) null;
}

 // Backtranslates both the strong contractions that
 //can be used anywhere and the ones that can only
 //be used at the beginning of a word.
public static String backBeg2LC( String brl ){
 PartWord pw = begOKCon2Ink.get( brl );
 if (pw != null) return pw.getInk();
 return (String) null;
}
public static String backBeg2TC( String brl ){
 PartWord pw = begOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkTC();
 return (String) null;
}
public static String backBeg2UC( String brl ){
 PartWord pw = begOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkUC();
 return (String) null;
}

 // Backtranslates the contractions that
 //can be used anywhere, the ones that can only
 //be used in the interior, and those that can be
 //be used in either the interior or end of a word.
public static String backMid2LC( String brl ){
 PartWord pw = midOKCon2Ink.get( brl );
 if (pw != null) return pw.getInk();
 return (String) null;
}
public static String backMid2TC( String brl ){
 PartWord pw = midOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkTC();
 return (String) null;
}
public static String backMid2UC( String brl ){
 PartWord pw = midOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkUC();
 return (String) null;
}

 // Backtranslates both the strong contractions that
 //can be used anywhere and the ones that can only
 //be used in the interior or end of a word.
public static String backEnd2LC( String brl ){
 PartWord pw = endOKCon2Ink.get( brl );
 if (pw != null) return pw.getInk();
 return (String) null;
}
public static String backEnd2TC( String brl ){
 PartWord pw = endOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkTC();
 return (String) null;
}
public static String backEnd2UC( String brl ){
 PartWord pw = endOKCon2Ink.get( brl );
 if (pw != null) return pw.getInkUC();
 return (String) null;
}

public static String backFLC( String brl ){
 PartWord pw = flc2Ink.get( brl );
 if (pw != null) return pw.getInk();
 return (String) null;
}
public static String backStrongGS( String brl, boolean tc ){
 PartWord pw = strongCon2Ink.get( brl );
 if (pw != null) {
  if( !tc ) {
    return pw.getInk();
  } else {
    return pw.getInkTC();
  }
 }
 return (String) null;
}
}//End Class PartWordUse.