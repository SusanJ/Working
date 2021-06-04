package org.dotlessbraille.transtables;
import java.util.HashMap;
import org.dotlessbraille.utilities.BrailleCell;

  /** Short-form words and
    initial letter contractions translation tables.
    Originally developed for EBAE, updated for UEB.

 TO-DO Support the following rule from App. 1
      "When an "s" or apostrophe "s" is added to any
      word on the list, use the shortform with the
      following three exceptions:
        abouts ab\ts
        almosts almo/s
        hims hims
*/
public class WordOrPartWord{

public static String CON = "3";
public static String BE = "2";

                          //Short-form word cross-referenced by
                          //'one' initial-letter contraction.
 public static final WordOrPartWord oneself =
  new WordOrPartWord( "&#x01CD;&#x01CE;&#x01CF;", 
                      "\"of", "oneself" );

 //These three shortforms have numerous exceptions as to whether they
 //can be used as a part-word at the start of a word.  The problem
 //word list thus needs to be consistent with the strategy.
 //that use the shortform at the start of a word must be included
 //in an exceptions list

/** UEB Rules

10.9.3 Use any of the ten shortforms listed below within a longer word that 
is not on the Shortforms List, provided the word is "standing alone" 
(including any affix with an apostrophe) and that any restrictions for 
the shortform are met. 
(a) "braille" or "great": Use the shortform wherever it occurs.
(b) "children": Use the shortform provided that it is not followed by a 
vowel or "y". 
(c) "blind", "first", "friend", "good", "letter", "little" or "quick": Use 
the shortform if it begins the word and is not followed by a vowel 
or "y".
*/

 // Note, if the last item in the declaration is an integer (flag)
 //then the item is not used as a part word. (EBAE guess; in UEB
 //there is an explicit list.) Yes, see the class App1Word.

 public static final WordOrPartWord BLIND =
  new WordOrPartWord( "&#x015B;&#x015C;", "bl", "blind", 1 );

 public static final WordOrPartWord MUST =
  new WordOrPartWord( "&#x0169;&#x016A;", "m/", "must" );

 public static final WordOrPartWord SHOULD =
  new WordOrPartWord( "&#x0173;&#x0174;", "%d", "should" );

 //--------------------

 public static final WordOrPartWord [] shortFormWords = {
  new WordOrPartWord( "&#x0206;&#x0207;&#x0208;&#x0209;&#x020A;", 
      "p]cvg", "perceiving" ),
  new WordOrPartWord( "&#x01E2;&#x01E3;&#x01E4;&#x01E5;",
      "yrvs", "yourselves" ),
  new WordOrPartWord( "&#x01E6;&#x01E7;&#x01E8;&#x01E9;",
      "\\rvs", "ourselves" ),
  new WordOrPartWord( "&#x01EA;&#x01EB;&#x01EC;&#x01ED;",
      "!mvs", "themselves" ),
  new WordOrPartWord( "&#x01EE;&#x01EF;&#x01F0;&#x01F1;",
      "dclg", "declaring" ),
  new WordOrPartWord( "&#x01F2;&#x01F3;&#x01F4;&#x01F5;",
      "rjcg", "rejoicing" ),
  new WordOrPartWord( "&#x01F6;&#x01F7;&#x01F8;&#x01F9;", 
      CON+"cvg", "conceiving", true ),
  new WordOrPartWord( "&#x01FA;&#x01FB;&#x01FC;&#x01FD;",
      "dcvg", "deceiving" ),
  new WordOrPartWord( "&#x01FE;&#x01FF;&#x0200;&#x0201;",
      "p]cv", "perceive" ),
  new WordOrPartWord( "&#x0202;&#x0203;&#x0204;&#x0205;",
      "rcvg", "receiving" ),
 
  new WordOrPartWord( "&#x018B;&#x018C;&#x018D;",
      "abv", "above" ),
  new WordOrPartWord( "&#x018E;&#x018F;&#x0190;",
       "acr", "across", 1 ),
  new WordOrPartWord( "&#x0191;&#x0192;&#x0193;",
       "afn", "afternoon" ),
  new WordOrPartWord( "&#x0194;&#x0195;&#x0196;",
       "afw", "afterward" ),
  new WordOrPartWord( "&#x0197;&#x0198;&#x0199;",
       "ag/", "against", 1 ),
  new WordOrPartWord( "&#x019A;&#x019B;&#x019C;",
       "alm", "almost", 1 ),
  new WordOrPartWord( "&#x019D;&#x019E;&#x019F;",
       "alr", "already" ),
  new WordOrPartWord( "&#x01A0;&#x01A1;&#x01A2;",
       "al?", "although" ),
  new WordOrPartWord( "&#x01A3;&#x01A4;&#x01A5;",
      "alt", "altogether", 1 ),
  new WordOrPartWord( "&#x01A6;&#x01A7;&#x01A8;",
      "alw", "always" ),
  new WordOrPartWord( "&#x01A9;&#x01AA;&#x01AB;",
      "brl", "braille" ),
  new WordOrPartWord( "&#x01AC;&#x01AD;&#x01AE;",
      "grt", "great" ),
  new WordOrPartWord( "&#x01AF;&#x01B0;&#x01B1;",
      "imm", "immediate", 1 ),
  new WordOrPartWord( "&#x01B2;&#x01B3;&#x01B4;",
      "nec", "necessary", 1 ),
  //new WordOrPartWord( "&#x01B5;&#x01B6;&#x01B7;", "o'c", "o'clock" ),
  new WordOrPartWord( "&#x01B8;&#x01B9;&#x01BA;", "p]h",
      "perhaps" ),
  new WordOrPartWord( "&#x01BB;&#x01BC;&#x01BD;", "tgr",
      "together" ),  //Had word flag???
  new WordOrPartWord( "&#x01BE;&#x01BF;&#x01C0;", "nei",
      "neither", 1 ),
  new WordOrPartWord( "&#x01C1;&#x01C2;&#x01C3;", "hmf", 
      "himself" ),
  new WordOrPartWord( "&#x01C4;&#x01C5;&#x01C6;", "yrf", 
     "yourself" ),
  new WordOrPartWord( "&#x01C7;&#x01C8;&#x01C9;", "h]f",
      "herself" ),
  new WordOrPartWord( "&#x01CA;&#x01CB;&#x01CC;", "myf",
      "myself" ),
  new WordOrPartWord( "&#x01CD;&#x01CE;&#x01CF;", "\"of",
     "oneself" ),
  new WordOrPartWord( "&#x01D0;&#x01D1;&#x01D2;", "?yf",
      "thyself" ),
  new WordOrPartWord( "&#x01D3;&#x01D4;&#x01D5;",
      "dcl", "declare" ),
  new WordOrPartWord( "&#x01D6;&#x01D7;&#x01D8;",
      "rjc", "rejoice" ),
  new WordOrPartWord( "&#x01D9;&#x01DA;&#x01DB;", 
                      CON+"cv", "conceive", true ),
  new WordOrPartWord( "&#x01DC;&#x01DD;&#x01DE;", "dcv", "deceive" ),
  new WordOrPartWord( "&#x01DF;&#x01E0;&#x01E1;", "rcv", "receive" ),
  new WordOrPartWord( "&#x0141;&#x0142;", "ab", "about", 1 ),
  new WordOrPartWord( "&#x0143;&#x0144;", "ac", "according", 1 ),
  new WordOrPartWord( "&#x0145;&#x0146;", "af", "after" ), //Had word flag???
  new WordOrPartWord( "&#x0147;&#x0148;", "ag", "again", 1),
  new WordOrPartWord( "&#x0149;&#x014A;", "al", "also", 1),
    // BE words can only be used as partwords at 
    //the begining of a word, e.g. beforehand
    // Those permitted by UEB are flagged with the "true" 
    //parameter and use a special constructor
  new WordOrPartWord( "&#x014B;&#x014C;", BE+"c",
      "because", 1 ),
  new WordOrPartWord( "&#x014D;&#x014E;", BE+"f", "before",
      true ),
  new WordOrPartWord( "&#x014F;&#x0150;", BE+"h", "behind",
      true ),
  new WordOrPartWord( "&#x0151;&#x0152;", BE+"l", "below", 
      true ),
  new WordOrPartWord( "&#x0153;&#x0154;", BE+"n", "beneath",
      true ),
  new WordOrPartWord( "&#x0155;&#x0156;", BE+"s",
      "beside",  true ),
  new WordOrPartWord( "&#x0157;&#x0158;", BE+"t",
      "between", true ),
  new WordOrPartWord( "&#x0159;&#x015A;", BE+"y",
      "beyond",  true ),
  new WordOrPartWord( "&#x015B;&#x015C;", "bl",
      "blind", 1 ),
  new WordOrPartWord( "&#x015D;&#x015E;", "*n",
      "children"), //Had word flag???
  new WordOrPartWord( "&#x015F;&#x0160;", "f/",
      "first" ),

  new WordOrPartWord( "&#x0161;&#x0162;", "fr",
      "friend", 1 ),
  new WordOrPartWord( "&#x0163;&#x0164;", "gd", "good" ),
  new WordOrPartWord( "&#x0165;&#x0166;", "lr", "letter" ),
  new WordOrPartWord( "&#x0167;&#x0168;", "ll", "little", 1 ),
  new WordOrPartWord( "&#x0169;&#x016A;", "m/", "must" , 1),
  new WordOrPartWord( "&#x016B;&#x016C;", "pd", "paid", 1 ),
  new WordOrPartWord( "&#x016D;&#x016E;", "qk", "quick" ),
  new WordOrPartWord( "&#x016F;&#x0170;", "sd", "said", 1 ),
  new WordOrPartWord( "&#x0171;&#x0172;", "cd", "could" ),
  new WordOrPartWord( "&#x0173;&#x0174;", "%d", "should", 1 ),
  new WordOrPartWord( "&#x0175;&#x0176;", "wd", "would" ),
  new WordOrPartWord( "&#x0177;&#x0178;", "ei", "either", 1 ),
  new WordOrPartWord( "&#x0179;&#x017A;", "m*", "much" ),
  new WordOrPartWord( "&#x017B;&#x017C;",
      "s*", "such" ), //Had word flag??? 
  new WordOrPartWord( "&#x017D;&#x017E;",
      "td", "today" ), //Had word flag???
  new WordOrPartWord( "&#x017F;&#x0180;",
      "tn", "tonight" ),
  new WordOrPartWord( "&#x0181;&#x0182;", "tm", "tomorrow" ),
  new WordOrPartWord( "&#x0183;&#x0184;",
      "hm", "him" ),
  new WordOrPartWord( "&#x0187;&#x0188;",
      "xf", "itself" ),
  new WordOrPartWord( "&#x0185;&#x0186;",
      "xs", "its" ),
  new WordOrPartWord( "&#x0189;&#x018A;",
      "yr", "your")
 };

                  /**Initial-letter contractions list. */
public static final WordOrPartWord[] initLetterWords = {
  new WordOrPartWord( "&#x00E3;&#x00E4;", "\"d", "day" ),
  new WordOrPartWord( "&#x00E5;&#x00E6;", "\"e", "ever" ),
  new WordOrPartWord( "&#x00E7;&#x00E8;", "\"f", "father" ),
  new WordOrPartWord( "&#x00E9;&#x00EA;", "\"h", "here" ),
  new WordOrPartWord( "&#x00EB;&#x00EC;", "\"k", "know" ),
  new WordOrPartWord( "&#x00ED;&#x00EE;", "\"l", "lord" ),
  new WordOrPartWord( "&#x00EF;&#x00F0;", "\"m", "mother" ),
  new WordOrPartWord( "&#x00F1;&#x00F2;", "\"n", "name" ),
  new WordOrPartWord( "&#x00F3;&#x00F4;", "\"o", "one", oneself),
  new WordOrPartWord( "&#x00F5;&#x00F6;", "\"p", "part" ),
  new WordOrPartWord( "&#x00F7;&#x00F8;", "\"q", "question" ),
  new WordOrPartWord( "&#x00F9;&#x00FA;", "\"r", "right" ),
  new WordOrPartWord( "&#x00FB;&#x00FC;", "\"s", "some" ),
  new WordOrPartWord( "&#x00FD;&#x00FE;", "\"t", "time" ),
  new WordOrPartWord( "&#x00FF;&#x0100;", "\"u", "under" ),
  new WordOrPartWord( "&#x0101;&#x0102;", "\"w", "work" ),
  new WordOrPartWord( "&#x0103;&#x0104;", "\"y", "young" ),
  new WordOrPartWord( "&#x0105;&#x0106;", "\"*", "character" ),
  new WordOrPartWord( "&#x0107;&#x0108;", "\"?", "through" ),
  new WordOrPartWord( "&#x0109;&#x010A;", "\":", "where" ),
  new WordOrPartWord( "&#x010B;&#x010C;", "\"\\", "ought" ),
  new WordOrPartWord( "&#x010D;&#x010E;", "\"!", "there" ),
  new WordOrPartWord( "&#x010F;&#x0110;", "^u", "upon" ),
  new WordOrPartWord( "&#x0111;&#x0112;", "^w", "word" ),
  new WordOrPartWord( "&#x0113;&#x0114;", "^?", "those" ),
  new WordOrPartWord( "&#x0115;&#x0116;", "^:", "whose" ),
  new WordOrPartWord( "&#x0117;&#x0118;", "^!", "these" ),
  new WordOrPartWord( "&#x0119;&#x011A;", "_c", "cannot" ),
  new WordOrPartWord( "&#x011B;&#x011C;", "_h", "had" ),
  new WordOrPartWord( "&#x011D;&#x011E;", "_m", "many" ),
  new WordOrPartWord( "&#x011F;&#x0120;", "_s", "spirit" ),
  new WordOrPartWord( "&#x0121;&#x0122;", "_w", "world" ),
  new WordOrPartWord( "&#x0123;&#x0124;", "_!", "their")
 };

public static WordOrPartWord [] lowWords = {

  new WordOrPartWord( "2", "be" ),
  new WordOrPartWord( "5", "enough" ),
  new WordOrPartWord( "7", "were" ),
  new WordOrPartWord( "8", "his" ),
  new WordOrPartWord( "9", "in" ),
  new WordOrPartWord( "0", "was" ) 
};

 public static HashMap<String, WordOrPartWord> sfCon2Ink = 
    new HashMap<String, WordOrPartWord>();
 public static HashMap<String, WordOrPartWord> Ink2sfCon = 
    new HashMap<String, WordOrPartWord>();

 public static HashMap<String, WordOrPartWord> ilcCon2Ink = 
    new HashMap<String, WordOrPartWord>();
 public static HashMap<String, WordOrPartWord> Ink2ilcCon = 
    new HashMap<String, WordOrPartWord>();

 public static HashMap<String, WordOrPartWord> lowCon2Ink = 
    new HashMap<String, WordOrPartWord>();
 public static HashMap<String, WordOrPartWord> Ink2lowCon = 
    new HashMap<String, WordOrPartWord>();



public static boolean tablesDone = false;


        /**Where item can be used as partword. */
PartWordUse used = PartWordUse.ANYWHERE;

 String dbCharRef;
 String aBrl;
 String ink;
 String xBrl;
 String inkUC;
 String inkTC;

//=====================================================

public WordOrPartWord( String aBrl, String ink ){
 this.aBrl = aBrl;
 this.ink  = ink;
 inkUC = ink.toUpperCase();
 inkTC = Word.makeTC( ink );
}
public WordOrPartWord( String dbCharRef, String aBrl, 
                       String ink ){
 this.dbCharRef = dbCharRef;
 this.aBrl = aBrl;
 //this.aBrl = aBrl.toUpperCase();
 //this.aBrl = BrailleCell.normalizeASCIIBraille( aBrl );
 this.ink  = ink;
 inkUC = ink.toUpperCase();
 inkTC = Word.makeTC( ink );
 this.xBrl = BrailleCell.toUni( dbCharRef );
  //This was used to initialize a custom transcription
  //to the default [?]  4/202018
 //unCustom(); implements in Sign abstract superclass
 //putSign( this );
}
//.....................................................
/**Special constructor for the initial-letter 
   contraction that is incorporated 
   in a short-form word.
*/
public WordOrPartWord( String dbCharRef, String aBrl, 
                String ink, WordOrPartWord shortForm ){
 this( dbCharRef, aBrl, ink );
 //myList.setSigns( shortForm );
}
//.....................................................
public WordOrPartWord( String dbCharRef, String aBrl, 
                String ink, boolean startOnly ){
 this( dbCharRef, aBrl, ink );
 if (startOnly) this.used = PartWordUse.BEG_WORD;
}
//.....................................................
public WordOrPartWord( String dbCharRef, String aBrl, 
                String ink, int wordOnly ){
 this( dbCharRef, aBrl, ink );
 this.used = PartWordUse.WORD_ONLY;
 //System.out.println( aBrl +" only for word: "+ink );
}
String getBrl(){ return aBrl; }
String getInk(){ return ink; }
String getInkTC(){ return inkTC; }
String getInkUC(){ return inkUC; }

   // BACKTRANSLATION TABLES

public static void makePartWordTable( boolean report, boolean display){
 if (tablesDone) return;
 System.out.println( "makePartWord SF Table: "+shortFormWords.length );
 for (int sf=0; sf < shortFormWords.length; sf++ ){
  WordOrPartWord pw = shortFormWords[sf];
  sfCon2Ink.put( pw.getBrl(), pw );
  Ink2sfCon.put( pw.getInk(), pw);
 }
 //report = true;
 if (report){
  int cnt = sfCon2Ink.size();
  System.out.println( "     Shortforms Table complete. ("+cnt+")" );
 }
 makeILCTable( report, display );
 makeLOWTable( report, display );
 tablesDone = true;
}
static void makeLOWTable( boolean report, boolean display){
 if (tablesDone) return;
 System.out.println( "makeLowTable: "+lowWords.length );

 for (int lw=0; lw < lowWords.length; lw++ ){
  WordOrPartWord pw = lowWords[lw];
  //System.out.println("pwLOWTable brl: "+pw.getBrl());
  lowCon2Ink.put( pw.getBrl(), pw );
  Ink2lowCon.put( pw.getInk(), pw);
 }
 report = true;
 if (report){
  int cnt = lowCon2Ink.size();
  System.out.println( "     LowWord Cons. Table complete. ("+cnt+")" );
 }
 tablesDone = true;
}
static void makeILCTable( boolean report, boolean display){
 if (tablesDone) return;
 System.out.println( "makePartWord ILC Table: "+initLetterWords.length );

 for (int ilc=0; ilc < initLetterWords.length; ilc++ ){
  WordOrPartWord pw = initLetterWords[ilc];
  //System.out.println("pwILCtable- brl: "+pw.getBrl());
  ilcCon2Ink.put( pw.getBrl(), pw );
  Ink2ilcCon.put( pw.getInk(), pw);
 }
 report = true;
 if (report){
  int cnt = ilcCon2Ink.size();
  System.out.println( "     Init. Letter Cons. Table complete. ("+cnt+")" );
 }
 //tablesDone = true;
}
public static WordOrPartWord getSf4Brl( String brl ){
 return sfCon2Ink.get( brl.toLowerCase( ));
}
public static WordOrPartWord  getBrl4Sf( String ink ){
 return Ink2sfCon.get( ink.toLowerCase() );
}
public static boolean isILC( String brl ){
 return ilcCon2Ink.containsKey( brl.toLowerCase() );
}
public static boolean isShortform( String brl ){
 return sfCon2Ink.containsKey( brl.toLowerCase() );
}

   //Translate print input to UEB ILC or Shortform
public static String toBrl( String ink ){
 WordOrPartWord pw = Ink2sfCon.get( ink );
 if (pw != null) return pw.getBrl();
 pw = Ink2ilcCon.get( ink );
 if (pw != null) return pw.getBrl();
 return (String) null;
}
 
  //Convert brl to LC to support UC ASCII Braille
public static String backLC( String brl ){
 //System.out.println( "wopw backlC brl: "+brl );
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 //System.out.println( "pw: "+pw );
 if (pw == null) pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInk();
}
public static String backTC( String brl ){
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 if (pw == null) pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkTC();
}
public static String backUC( String brl ){ 
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 if (pw == null) pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkUC();
}
      //Initial letter contractions
 //Convert brl to LC to support UC ASCII Braille
public static String ilcBackLC( String brl ){
 WordOrPartWord pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInk();
}
public static String ilcBackTC( String brl ){
 WordOrPartWord pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkTC();
}
public static String ilcBackUC( String brl ){ 
 WordOrPartWord pw = ilcCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkUC();
}
      //Low words
 //Convert brl to LC to support UC ASCII Braille
public static String lowBackLC( String brl ){
 WordOrPartWord pw = lowCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInk();
}
public static String lowBackTC( String brl ){
 WordOrPartWord pw = lowCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkTC();
}
public static String lowBackUC( String brl ){ 
 WordOrPartWord pw = lowCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkUC();
}
    //Just shortforms
 //Convert brl to LC to support UC ASCII Braille
public static String sfBackLC( String brl ){
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInk();
}
public static String sfBackTC( String brl ){
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkTC();
}
public static String sfBackUC( String brl ){ 
 WordOrPartWord pw = sfCon2Ink.get( brl.toLowerCase() );
 if (pw == null ) return (String) null;
 return pw.getInkUC();
}
}//End Class.
 