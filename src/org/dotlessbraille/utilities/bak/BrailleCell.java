package org.dotlessbraille.utilities;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import java.lang.Character;
import java.lang.Character.UnicodeBlock;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**<p>Instances of this class provide various
    representaions for a given six-dot braille 
    cell:
    <ul>
    <li>the cell's position number in the standard order,</li>
    <li>the cell's North American ASCII Braille transliteration,</li>
    <li>the cell's computer braille transliteration,</li>
    <li>the cell's NumBrl (octal braille),</li>
    <li>a list of the cell's filled dot positions,</li>  
    <li>and the character code for the cell's Unicode
        Braille Pattern.</li>
    </ul></p>

<p>TECHNICAL NOTE. Not all of these representations are
   independent.  ASCII braille and computer braille can
   be interconverted algorithmically as can NumBrl,
   Unicode, and the list of filled dot positions. 
   The standard order convention is independent of
   the others.
*/ 

public class BrailleCell {

 /**Array of filled dot positions indexed by octal equivalent
    for left column of dots. (See also <code>numbrl</code> */
 static final String [] leftDots  = {
  new String( " " ),  new String( "1" ), new String( "2" ),
  new String( "12" ), new String( "3" ), new String( "13" ),
  new String( "23" ), new String( "123" )};

 /**Array of filled dot positions indexed by octal equivalent
    for right column of dots. */
 static final String [] rightDots  = {
  new String( " " ),  new String( "4" ), new String( "5" ),
  new String( "45" ), new String( "6" ), new String( "46" ),
  new String( "56" ), new String( "456" )};

 /**Array of filled dot positions indexed by hex/octal/decimal equivalent
    for left column of dots per APH convention: 1, 2, 4 */
 static final String [] leftHexDots  = {
  new String( " " ),  new String( "1" ), new String( "2" ),
  new String( "12" ), new String( "3" ), new String( "13" ),
  new String( "23" ), new String( "123" )};

 /**Array of filled dot positions indexed by decimal equivalent/8
    for right column of dots per APH hex convention: 8, 16, 32 */
 static final String [] rightHexDots  = {
  new String( " " ),  new String( "4" ), new String( "5" ),
  new String( "45" ), new String( "6" ), new String( "46" ),
  new String( "56" ), new String( "456" )};

                         /**All 63 six-dot cells. */
 static final public BrailleCell [] sixDotCells = {
  new BrailleCell(  1, "A", "a", "10", "2801" ),
  new BrailleCell(  2, "B", "b", "30", "2803" ),
  new BrailleCell(  3, "C", "c", "11", "2809" ),
  new BrailleCell(  4, "D", "d", "13", "2819" ),
  new BrailleCell(  5, "E", "e", "12", "2811" ),
  new BrailleCell(  6, "F", "f", "31", "280B" ),
  new BrailleCell(  7, "G", "g", "33", "281B" ),
  new BrailleCell(  8, "H", "h", "32", "2813" ),
  new BrailleCell(  9, "I", "i", "21", "280A" ),
  new BrailleCell( 10, "J", "j", "23", "281A" ),
  new BrailleCell( 11, "K", "k", "50", "2805" ),
  new BrailleCell( 12, "L", "l", "70", "2807" ),
  new BrailleCell( 13, "M", "m", "51", "280D" ),
  new BrailleCell( 14, "N", "n", "53", "281D" ),
  new BrailleCell( 15, "O", "o", "52", "2815" ),
  new BrailleCell( 16, "P", "p", "71", "280F" ),
  new BrailleCell( 17, "Q", "q", "73", "281F" ),
  new BrailleCell( 18, "R", "r", "72", "2817" ),
  new BrailleCell( 19, "S", "s", "61", "280E" ),
  new BrailleCell( 20, "T", "t", "63", "281E" ),
  new BrailleCell( 21, "U", "u", "54", "2825" ),
  new BrailleCell( 22, "V", "v", "74", "2827" ),
  new BrailleCell( 23, "X", "x", "55", "282D" ),
  new BrailleCell( 24, "Y", "y", "57", "283D" ),
  new BrailleCell( 25, "Z", "z", "56", "2835" ),
  new BrailleCell( 26, "&", "&", "75", "282F" ),
  new BrailleCell( 27, "=", "=", "77", "283F" ),
  new BrailleCell( 28, "(", "(", "76", "2837" ),
  new BrailleCell( 29, "!", "!", "65", "282E" ),
  new BrailleCell( 30, ")", ")", "67", "283E" ),
  new BrailleCell( 31, "*", "*", "14", "2821" ),
  new BrailleCell( 32, "<", "<", "34", "2823" ),
  new BrailleCell( 33, "%", "%", "15", "2829" ),
  new BrailleCell( 34, "?", "?", "17", "2839" ),
  new BrailleCell( 35, ":", ":", "16", "2831" ),
  new BrailleCell( 36, "$", "$", "35", "282B" ),
  new BrailleCell( 37, "]", "}", "37", "283B" ),
  new BrailleCell( 38, "\\", "|", "36", "2833" ),
  new BrailleCell( 39, "[", "{", "25", "282A" ),
  new BrailleCell( 40, "W", "w", "27", "283A" ),
  new BrailleCell( 41, "1", "1", "20", "2802" ),
  new BrailleCell( 42, "2", "2", "60", "2806" ),
  new BrailleCell( 43, "3", "3", "22", "2812" ),
  new BrailleCell( 44, "4", "4", "26", "2832" ),
  new BrailleCell( 45, "5", "5", "24", "2822" ),
  new BrailleCell( 46, "6", "6", "62", "2816" ),
  new BrailleCell( 47, "7", "7", "66", "2836" ),
  new BrailleCell( 48, "8", "8", "64", "2826" ),
  new BrailleCell( 49, "9", "9", "42", "2814" ),
  new BrailleCell( 50, "0", "0", "46", "2834" ),
  new BrailleCell( 51, "/", "/", "41", "280C" ),
  new BrailleCell( 52, "+", "+", "45", "282C" ),
  new BrailleCell( 53, "#", "#", "47", "283C" ),
  new BrailleCell( 54, ">", ">", "43", "281C" ),
  new BrailleCell( 55, "'", "'", "40", "2804" ),
  new BrailleCell( 56, "-", "-", "44", "2824" ),
  new BrailleCell( 57, "@", "`", "01", "2808" ),
  new BrailleCell( 58, "^", "~", "03", "2818" ),
  new BrailleCell( 59, "_", "_", "07", "2838" ),
  new BrailleCell( 60, "\"", "\"", "02", "2810" ),
  new BrailleCell( 61, ".", ".", "05", "2828" ),
  new BrailleCell( 62, ";", ";", "06", "2830" ),
  new BrailleCell( 63, ",", ",", "04", "2820" ),
 };

 

 static final public BrailleCell SPACE = new BrailleCell( 0, " ", " ", "00", "0020" );

          /**XML entity for apostrophe character.*/
 static final String XML_APOS = "&apos;";

          /**XML entity for ampersand character.*/
 static final String XML_AMP  = "&amp;";

          /**XML entity for greater than character.*/
 static final String XML_GT   = "&gt;";

          /**XML entity for less than character.*/
 static final String XML_LT   = "&lt;";

          /**XML entity for neutral double quotes character.*/
 static final String XML_QUOT = "&quot;";

          /**Hash table for locating braille cell object
             using ASCII Braille as a key. */
 private static HashMap aBrlKey = new HashMap();

 //public static TransList cellList; 
 

 

          /**Hash table for locating braille cell object
             using list of dots as key. */
 private static HashMap dotsKey = new HashMap();
 private static HashMap<String, BrailleCell>  numbrlKey = new HashMap();

 private static boolean madeTables = makeTables();

                           //Fields
 
          /**Ordinal position of braille cell in
             standard order. */  
 int standardOrder;

          /**North American ASCII Braille transliteration. */
 String asciiBrl;

          /**"Computer braille" transliteration used by BrailleLite
             and BrailleNote. */
 String computerBrl;

          /**Octal value obtained from summing values of filled 
             dot positions where positions 1-2-3-4-5-6 have the
             the values 10-20-40-1-2-4, respectively. */
 String numBrl;

          /**Unicode character code. */
 String unicodeBraillePattern;

           /**Unicode character. */
 char uniBP;

           /**List of filled dot positions. */
 String dots;

           /**ASCII Braille with XML reserved characters
              escaped as character entities. */
 String aBrl4XML;

//=======================================================
private BrailleCell( int standardOrder,  String asciiBrl, 
                     String computerBrl, String numBrl,
                     String unicodeBraillePattern ){

 this.standardOrder         = standardOrder;
 this.asciiBrl              = asciiBrl.toUpperCase();
 this.computerBrl           = computerBrl;
 this.numBrl                = numBrl;
 this.unicodeBraillePattern = unicodeBraillePattern;

 uniBP = toJavaUniChar( unicodeBraillePattern );
 boolean b = isBraillePattern (uniBP) || asciiBrl.equals( " " );
 if (!b){
   System.out.println( "BrailleCell Constructor: "+
                       "Bad Unicode for :" +asciiBrl );
 }
 checkOctHex();
 this.dots          = toDots( numBrl );
 aBrl4XML           = fixABrl( asciiBrl.charAt( 0 ) );
}
public String aBrl(){
 return asciiBrl;
}
public String getUniPat(){
 return "&#x"+unicodeBraillePattern+";";
}
//--------------------------------------------------------
/**Ensures that an octal NumBrl value (for a six-dot cell)
   is consistent with the hexadecimal Unicode value. 
   (This consistency check helps ensure that
    the input is correct.)
*/
private void checkOctHex(){
   if (asciiBrl.equals( " " )) return;
   if (!oct2Uni( numBrl ).equals( unicodeBraillePattern )){
    System.out.println
       ("BrailleCells internal error--"+
        "octal and Unicode values inconsistent for: "+
        "dots-"+dots);
    System.exit(0);
   }
}
//--------------------------------------------------------
/**Converts ASCII Braille to XML entities as necessary
   for escaping &, ', <, >, and ".

   @param a  ASCII Braille character.
*/
static String fixABrl( char a ){
 switch (a){
  case '&':
   return XML_AMP;
  case '\'':
   return XML_APOS;
  case '>':
   return XML_GT;
  case '<':
   return XML_LT;
  case '"':
   return XML_QUOT;
  default:
   return String.valueOf( a );
 }
}
//--------------------------------------------------------
/**Returns the braille cell object for a braille cell
   specified as Braille ASCII. 

   @param aBrl  ASCII Braille transliteration.

*/
public static BrailleCell getCellForBA( String aBrl ) {
 return (BrailleCell) aBrlKey.get( aBrl );
}
//--------------------------------------------------------
/**Returns the braille cell object for a braille cell
   specified by an ordered list of filled
   dot positions.

   @param dots  List of filled dot positions, e.g. 1246.

*/
public static BrailleCell getCellForDots( String dots ) {
 return (BrailleCell) dotsKey.get( dots );
}
//--------------------------------------------------------
/**Outputs two-column display correlating ASCII
   braille with Unicode.

   @param out  File for output.

*/
static void display( Tape6 out ){
out.println ("      The Braille Cells");
out.println ("  ASCII Braille        Unicode ");
 for (int i = 0; i<sixDotCells.length; i++){
   out.println ("   "+sixDotCells[i].asciiBrl+"       "+
                sixDotCells[i].unicodeBraillePattern);
 }
}
//--------------------------------------------------------
/** Ensures that hash tables are initialized. */
static boolean makeTables(){
 if (!madeTables){

 //BrlCellSign [] cells = new BrlCellSign [sixDotCells.length];
  
  for (int i = 0; i<sixDotCells.length; i++){
   aBrlKey.put( sixDotCells[i].asciiBrl, sixDotCells[i] );
   dotsKey.put( sixDotCells[i].dots    , sixDotCells[i] );
   numbrlKey.put( sixDotCells[i].numBrl, sixDotCells[i] );
   //cells[i] = new BrlCellSign( sixDotCells[i].asciiBrl,
                               //sixDotCells[i] );
  }
 //cellList = new TransList( cells, Sign.BRAILLE_CELLS,
                            //"braille cells" );
 }

 return true;
}
//--------------------------------------------------------
/**Converts the NumBrl for a cell to list
   of filled dot positions.

   @param numBrl  Octal braille specification.
*/
static String toDots( String numBrl ){

 int lCol = Integer.parseInt( numBrl.substring(0,1), 8 );
 int rCol = Integer.parseInt( numBrl.substring(1,2), 8 );
 if (lCol < 0 || lCol > 7 || 
     rCol < 0 || rCol > 7) {
   System.out.println( "toDots--bad input: "+numBrl );
   return (String) null;
 }
 if (lCol == 0) return rightDots[rCol];
 if (rCol == 0) return leftDots[lCol];
 return leftDots[lCol] + rightDots[rCol];
}
static int toOctBrl( int hexBrl ){
 //int dec = hexBrl;
 //System.out.println( "dec, hex: "+dec+" "+hexBrl );
 int lhcol = hexBrl%8;
 int rhcol = (hexBrl - lhcol)/8;
 System.out.println( "lh, rh "+lhcol+" "+rhcol );
 //int lCol = Integer.parseInt( hexBrl.substring(0,1), 16 );
 //int rCol = Integer.parseInt( hexBrl.substring(1,2), 16 );
 if (lhcol < 0 || lhcol > 7 || 
     rhcol < 0 || rhcol > 7) {
   System.out.println( "toDots--bad input: "+hexBrl );
   return -1;
 }
 int octBrl = lhcol*10 + rhcol;
 return octBrl;
}
//--------------------------------------------------------
/**Convert the NumBrl (octal braille) for a six-dot 
   braille cell to the Unicode character code for the
   the same eight-dot Braille Pattern assuming that the
   unfilled dots seven and eight are the bottom row of
   the cell. 

   @param numBrl  Octal braille specification.
*/
static String oct2Uni( String numBrl ){
 int col1 = Integer.parseInt(numBrl.substring(0,1), 8);
 int col2 = Integer.parseInt(numBrl.substring(1,2), 8);

                     //Reverse columns; 
                     //convert to octal value
 int rev = 8*col2 + col1;

                     //Convert to hex string
 String hex = Integer.toHexString (rev);
 if (hex.length() == 1) {
    return "280" + hex.toUpperCase();
 } else {
    return "28" + hex.toUpperCase();
 }
}
//-----------------------------------------------------
/**Reports whether a character is in the Unicode
   Braille Patterns block.

   @param c  Java UTF-16 character.
*/
static boolean isBraillePattern( char c ){
 UnicodeBlock check = UnicodeBlock.of( c );
 if (check == UnicodeBlock.BRAILLE_PATTERNS) return true;
 return false;
}
//--------------------------------------------------------
/**Outputs the various forms of all 63
   six-dot braille cells as an XHTML table. 

   @param page             File to receive output.
   @param brlFontStartTag  The start tag to be used to
                           mark the start of entries
                           using a braille font.
   @param brlFontEndTag    The end tag to be used to
                           mark the end of entries
                           using a braille font.
*/
static void toHTML( Tape6 page, String brlFontStartTag,
                    String brlFontEndTag ){

 page.out( "<table border=\"1\">" );
 page.out( "<tr>" );
 page.out( "<th> Standard<br/>Order </th>"+
           "<th> ASCII Braille </th>"+
           "<th> Computer<br/>Braille  </th>"+
           "<th> SimBraille  </th>"+
           "<th> NumBrl </th>"+
           "<th> Unicode<br/>BraillePatterns<br/></th>"+
           "<th> Dots</th>"
          );
 page.out( "</tr>" );

 String row;
 for (int i = 0; i<sixDotCells.length; i++){
  page.out( "<tr>" );
  row = "<td>"+sixDotCells[i].standardOrder+"</td>" +
        "<td>"+sixDotCells[i].asciiBrl+"</td>"      +
        "<td>"+sixDotCells[i].computerBrl+"</td>"   +
        "<td>"+brlFontStartTag        +
              sixDotCells[i].asciiBrl +
              brlFontEndTag+"</td>"                           +
        "<td>"+sixDotCells[i].numBrl+"</td>"        +
        "<td>"+sixDotCells[i].unicodeBraillePattern+"</td>"+
        "<td>"+sixDotCells[i].dots +"</td>";
  page.out( row ); 
  page.out( "</tr>" );      
 }
 page.out( "</table>" );
}
public static BrailleCell [] sixDotCells(){
 return sixDotCells;
}
/**Normalize ASCIIBraille used in tables. */
public static String normalizeASCIIBraille( String aBrl ){
 String normal = aBrl.toUpperCase();
 return normal;
}

//=========================================================
public static void main (String[] args) throws Exception {
//=========================================================

   BrailleCell.makeTables();
   Tape6 myOutput = new Tape6( "brlpat.txt" );
   System.out.println( "\n    -->Enter North Am. ASCII Braille; "+
                        "using small or capital letters." );
   System.out.println( "    -->End input with CTRL-z "+
                      "as only symbol on last line.\n" );
 Scanner scanner = new Scanner( System.in ); 

 String input;
 for (int i=0; i<10; i++){
 if (!scanner.hasNext()) {
  myOutput.finish();
  System.exit( 0 ); 
 }
 input = scanner.nextLine();
 System.out.println( "Input: "+input );
 //BrailleCell bc = BrailleCell.getCellForBA( "X" );
 //if (bc != null){
   //System.out.println( "Unicode: "+bc.getUniPat() );
 //} else{
   //System.out.println( "No BC for X" );
 //}

 String result = lineToBP( input, false, "" );
 System.out.println( result );
 myOutput.println( input );
 myOutput.println( result );
 }

 //myOutput.finish();
 System.exit( 0 );

}
//Converts an ASCII string to HTML Unicode Braille
static String lineToBP( String input, boolean useSep, String sep ){
 BrailleCell bc;
 StringBuilder buf;
 if (useSep){
  buf  = new StringBuilder( sep );
 } else {
  buf = new StringBuilder();
 }

 String str;
 for (int i = 0; i<input.length(); i++){
  str = input.substring(i,i+1);
  if (str.equals(" ")){
   buf.append( str );
  } else {
   bc = BrailleCell.getCellForBA( str.toUpperCase() );
   if (bc != null){
    buf.append( bc.getUniPat() );
    if (useSep) buf.append( sep );
   //System.out.println( "Unicode: "+bc.getUniPat() );
   } else {
    System.out.println( "No BC for: |"+str+"|" );
    System.exit( 0 );
   }
  }
 }
 if (useSep) buf.append( sep );
 return buf.toString();  
}   
//=========================================================

public static void mayne(  String [] args ) throws Exception{
 String inputFile = null;
 CharStream input = null;
 Reader myReader = null;
 if ( args.length > 0 ) inputFile = args[0];
 if (inputFile == null){
    System.out.println( "\n    -->Enter North Am. ASCII Braille; "+
                        "use small letters." );
    System.out.println( "    -->End input with CTRL-z "+
                      "as only symbol on last line.\n" );
    myReader = new InputStreamReader( System.in, "UTF-8");
   //CodePointCharStream cpcs = CharStreams.fromReader( myReader );
    //input = cpcs;
 } else {
    File f = new File( inputFile );
    if (f.exists() && !f.isDirectory() )  {
       input = CharStreams.fromFileName( inputFile );
    } else {
       System.out.println( "\n OOPS! Cannot find input file: "
                           +inputFile );
       System.exit( 0 );
    }
  }
  int achar = myReader.read();
  System.out.println( "achar: "+achar);

 //demo();
}

public static void demo(){
 String abrl = ",\"STEXT4";

 BrailleCell bc;
 for (int i=0; i<abrl.length(); i++){
  bc = BrailleCell.getCellForBA( abrl.substring(i,i+1) );
  System.out.println( abrl.substring(i,i+1)+" "+bc.dots+"        "+bc.unicodeBraillePattern );
 }

 int numbrl = 010;
 System.out.println( "Numbrl as decimal int: "+
              numbrl+" "+"same as Octal String: "+
             numbrlToOctalString( numbrl ) );

 int numbrl2 = numbrl+051;
 System.out.println( "Numbrl as decimal int: "+
                      numbrl2+" "+"same as Octal String: "+
                      numbrlToOctalString( numbrl2 ) );
 System.out.println( numbrlToAbrl( numbrl2 ) );

 int hexb = 0x20;
 System.out.println( "hexb: "+hexb );
 System.out.println( "HEX: "+hexb+" "+toOctBrl( hexb ));

 hexb = 0x21;
 System.out.println( "hexb: "+hexb );
 System.out.println( "HEX: "+hexb+" "+toOctBrl( hexb ));

}// End main.
/** Convert numbrl octal integer to asciiBrl */
public static String numbrlToAbrl( int oct){
  BrailleCell bc = numbrlKey.get( numbrlToOctalString( oct ) );
  return bc.asciiBrl;
}
/** Convert octal integer, i.e. 01, 07, sum of octal integers to
  octal String. */
public static String numbrlToOctalString( int oct ){
  return Integer.toOctalString( oct );
} 
/**Converts a string representing a hexadecimal
   number to Java's internal representation for
   Unicode characters.
*/
static char toJavaUniChar( String hex ){
 return (char) Integer.parseInt( hex, 16 );
}
//-----------------------------------------------------
/**Converts a mixed string to Java Unicode.  (A 
   <dfn>mixed string</dfn>
   has ASCII letters mixed
   with XML-style character references.  It must not
   include  ASCII characters that are not letters.)
*/
public static String toUni (String mixed){

 String working = new String(mixed);
 StringBuilder sb = new StringBuilder();
 int ic;

 while (true){

  if (working.startsWith("&#")){

   ic = working.indexOf (";");
   //String hex = working.substring(3,ic);
   sb.append (toJavaUniChar(working.substring(3,ic)));
   if (working.length() == ic+1) break;
   working = working.substring(ic+1);

  } else {

   sb.append (working.charAt(0));
   if (working.length() == 1) break;
   working = working.substring(1);

  }

 }//End while.
 return sb.toString();
}
//-----------------------------------------------------


}//End Class BrailleCells.