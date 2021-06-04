package org.dotlessbraille.jsonInput;
import java.util.HashMap;
import java.util.ArrayList;

 // Modified Letters
/**NOTE ADDED 5/29/2021 The en-ueb-chardefs.uti files
   has a large number of these as "uplow" rules which
   could be copied here. The braille dots are for the 
   lowercase letter;  dot-6 needs to precede an individual
   uppercase one.

‐‐  uplow \x0100\x0101 4-36-1 Āā
   uplow \x0102\x0103 4-346-1 Ăă
   uplow \x0106\x0107 45-34-14 Ćć
*/


public class ModifiedLetter{

 static HashMap<String, ModifiedLetter> modifierTable =
   new HashMap<String, ModifiedLetter>();
 static ArrayList<ModifiedLetter> modifiers =
   new ArrayList<ModifiedLetter>();

 String brl;
 String unicode;
 String label;

ModifiedLetter( String brl, String unicode, String label){
 this.brl = brl;
 this.unicode = unicode;
 this.label = label;
 modifiers.add( this );
 modifierTable.put( brl, this );
}
String getBrl(){
 return brl;
}
String getUnicode(){
 return unicode;
}
String getLabel(){
 return label;
}
public static String btModLetter( String brl ){
 ModifiedLetter value =  modifierTable.get( brl );
 return value.getUnicode();
}
}//End Class Modifier.
