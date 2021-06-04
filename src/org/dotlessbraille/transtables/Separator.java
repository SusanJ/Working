package org.dotlessbraille.transtables;
import java.util.HashMap;
import java.util.ArrayList;
class Separator{

/** Braille symbols for characters defined as separators
  according to the "standing alone" specification in
  Rulebook Sec. 2.6.1.
*/

static HashMap<String, String> separatorTable = 
    new HashMap<String, String>();
static ArrayList<Separator>seps = 
     new ArrayList<Separator>();
 
 private String brl;
 private String ink;

Separator( String brl, String ink){
 this.brl = brl;
 this.ink = ink;
}
String getBrl(){
 return brl;
}
String getInk(){
 return ink;
}
  //Separator table  
public static void makeSeparatorTable( boolean report,
      boolean display ){
 Separator sep = new Separator( " ",    " " );
 seps.add( sep );
 sep = new Separator( "-",    "-" );
 seps.add( sep );
 sep = new Separator( ",-",   "&NDASH;" );
 seps.add( sep );
 sep = new Separator( "\",-", "&MDASH;"  );
 seps.add( sep );
 for (Separator s : seps){
  separatorTable.put( s.getBrl(), s.getInk() );
 }
 if (report)
  System.out.println( "   Table for separators complete." );
 if (display) displaySeparators();
}
public static String backTrans( String brl ){
 return separatorTable.get( brl );
}
public static void displaySeparators(){
 for (Separator sep : seps){
  System.out.println( "Separator--brl: |"+sep.getBrl()+
                  "| ink: |"+sep.getInk()+"|");
 }
}
}//End Class
