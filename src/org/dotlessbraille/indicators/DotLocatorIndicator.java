package org.dotlessbraille.indicators;
import java.util.HashMap;
import java.util.ArrayList;
//Note that symbols are hard-wired.
public class DotLocatorIndicator extends Indicator{

/**  UEB dot locators act like indicators although they
    are not officially indicators. The "use" locator
    has no semantic meaning and is optionally 
    omitted/kept in print for convenience.
     The "mention" locator deactivates any action the
    affected symbol would otherwise invoke, e.g.
    setting a mode or typeform.

   ""= dot locator for "use" (see 3.14)
  May be used in braille if a braille symbol would
  otherwise be difficult to recognize, e.g. all lower dots
  in isolation.
  Not shown in print.

   .= dot locator for "mention" (see 3.13)
  Mention not shown in print. In braille it applies
  only to the immediately following braille symbol which,
  of course, does not have its usual function.
*/

static HashMap<String, String> dotLocTable = 
    new HashMap<String, String>();
static ArrayList<DotLocatorIndicator>dotLocs = 
     new ArrayList<DotLocatorIndicator>();

 static DotLocatorIndicator mentionInd;
 
 private String brl;
 private String ink;

DotLocatorIndicator( String brl, String name,
    Scope scope ){
 super( brl, name, scope );
}
//String getBrl(){
 //return brl;
//}
String getInk(){
 return ink;
}
  //Translation table  
public static void makeTranslationTable( boolean report,
      boolean display ){

 DotLocatorIndicator useDL = 
    new DotLocatorIndicator( "\"\"=", "dot locator use", 
      Scope.NEXT_SYMBOL );
 useDL.ink = "[DL-use in braille.";
 dotLocs.add( useDL );

 DotLocatorIndicator mentionDL = 
  new DotLocatorIndicator( ".=", 
    "dot locator mention",
      Scope.NEXT_SYMBOL  );
 dotLocs.add( mentionDL );
 mentionDL.ink = "[DL-mention in braille.]";
 mentionInd = mentionDL;
 for (DotLocatorIndicator dl : dotLocs){
  dotLocTable.put( dl.getBrl(), dl.getInk() );
 }
 if (report)
  System.out.println( "   Table for dot locators complete. ("+
  dotLocs.size()+")" );
 if (display) displayDotLocators();
}
public static String backTrans( String brl ){
 return dotLocTable.get( brl );
}
public static void displayDotLocators(){
 for (DotLocatorIndicator dl : dotLocs){
  System.out.println( "DotLocator--brl: |"+dl.getBrl()+
                  "| ink: |"+dl.getInk()+"|");
 }
}
public static boolean isMention(DotLocatorIndicator dl ){
 if (dl == mentionInd) return true;
 return false;
}
}//End Class
