package org.dotlessbraille.indicators;
import org.dotlessbraille.manifold.KeepTrack2;
import java.util.HashMap;
public class SubSupIndicator extends Indicator {

 /** Handles simple case of one level indicator at
     a time as the most common or basic case in non-technical
     material.  Does NOT support a simultanous subscript and
     superscript nor a subscripted or superscripted atem that
     carries an additional level indicator.

     In general these indicators are unusual for several reasons.
     First, they are used in both non-technical material,
     e.g. to indicate a footnote number raised above the
     line in print, and in technical material.  Second, their 
     symbols dots-35 and dots-26 they can be confused with
     the contractions for "en" and "in". Thus they require
     a preceding grade 1 symbol indicator, dots-56, when
     used in contracted braille.  The Rulebook states
     that the symbol indicator is not needed in uncontracted
     braille.  This class assumes that it is legal 
     though not required.

Rulebook 11.4.1 The scope of a level change indicator, that is, 
  the symbol(s) affected by it, is the next "item".
  An item is defined as any of the following groupings:
  (1) An entire number, i.e. the initiating numeric symbol 
  and all succeeding symbols within the numeric mode thus 
  established (which would include decimal points,
  commas and simple numeric fraction lines).

  Etc.!!!
*/
 static HashMap <String,SubSupIndicator> ssInds =
    new HashMap <String,SubSupIndicator> ();

 static String supInd = "9";  //DOTS35
 static String subInd = "5";  //DOTS26


 static SubSupIndicator pending = null;
   //In some cases a pending subsup is only
   // closed by a certain symbol
 static boolean waiting4CloseGroup = false;
 static String waiting4Symbol = null;

   //Not needed unless assumption is wrong.
 boolean useAnywhere; 
 boolean notCon;
 String startTag;
 String endTag;
 
 SubSupIndicator( String brl, String name, Scope scope,
        boolean useAnywhere, boolean notCon, 
        String startTag, String endTag){
  super( brl, name, scope ); 
  this.useAnywhere = useAnywhere;
  this.notCon = notCon;
  this.startTag = startTag;
  this.endTag = endTag;
  ssInds.put( brl, this );
 }
public String getStartTag(){
 return startTag;
}
public String getEndTag(){
 return endTag;
}
boolean getUseAnywhere(){ return useAnywhere; }
boolean getNotCon(){ return notCon; }

 //  Assumes that parser grammar always treats a
 //symbol with a preceding g1SymInd (dots-56) as a
 //single token.
 // Note that these indicators can sometimes
 // require the affected item to be enclosed in
 // a pair of grouping symbols 

public static void makeSubSupInds( boolean report,
             boolean display, String g1SymInd ){
       

   //set status guy
   SubSupIndicator anySup = 
    new SubSupIndicator( supInd, "superscript", Scope.SPECIAL,
        false, true, "<sup>", "</sup>" );
   SubSupIndicator anySub =
    new SubSupIndicator( subInd, "subscript", Scope.SPECIAL,
        false, true, "<sub>", "</sub>" );

   String supBrl = g1SymInd + supInd;
   String subBrl = g1SymInd + subInd;
   SubSupIndicator conSup = 
    new SubSupIndicator( supBrl, "superscript", Scope.SPECIAL,
        false, true, "<sup>", "</sup>" );
   SubSupIndicator conSub =
    new SubSupIndicator( subBrl, "subscript", Scope.SPECIAL,
        false, true, "<sub>", "</sub>" );

   if (report)
    System.out.println( "   Super- and sub-script indicators made. ("+
       ssInds.size()+")" ); 
}
  

// Handled in subclass since symbol differs in
// contracted braille.
static boolean isSSInd( String brl ){
 SubSupIndicator ss = ssInds.get( brl );

    //Not a SubSubIndicator
 if (ss == null) return false;

    //Cf. Rulebook 3.24.
    //Must be a contraction, not a SubSupIndicator
 if (KeepTrack2.isContracted() &&
     ss.getNotCon()) return false;

    //  Assumes g1+ss is always valid (although not
    // required in uncontracted braille
 pending = ss;
 return true;
}
public static boolean subSupIsPending(){
 if (pending == null) return false;
 return true;
}
public static String getPendingStartTag(){
 return pending.getStartTag();
}
 // A number not enclosed is an "item"
 //Cf. Rulebook Sec. 11.4.1
static String clearOnNumEnd(){
 if (pending == null) return "";
 if (waiting4CloseGroup) return "";
 String endTag = pending.getEndTag();
 clearPending();
 return endTag;
}
private static void clearPending(){
 pending = null;
 waiting4CloseGroup = false;
 waiting4Symbol = null;
}
static SubSupIndicator getPending(){
 return pending;
}
public static void setPending(  SubSupIndicator ssIndy ){
 pending = ssIndy;
}
 //Caller checks that is needed???
public static void setWaitingFor( String brl ){
 waiting4CloseGroup = true;
 waiting4Symbol = brl;
 System.out.println( "SSI.waiting4: "+brl );
}
 //An unenclosed numeric item ends a script
public static String afterNumfrag(){
 if (pending == null) return "";
 if (waiting4CloseGroup) return "";
 String  endTag = pending.getEndTag();
 clearPending();
 return endTag;
}
public static String spaceEncountered(){
 System.out.println( "SubSupInd.spaceEnc.() pending: "+pending );
 if (pending == null) return "";
 if (waiting4CloseGroup) return ""; //unlikely?
 String  endTag = pending.getEndTag();
 clearPending();
 return endTag;
}

 //Assumes scripted item never continued to
 //next line....
public static String afterAtEOL(){
 if (pending == null) return "";
 String endTag = pending.getEndTag();
 clearPending();
 return endTag;
}
 //Check if the symbol just processed could be the
 //end of a script
public static String getAfterTag( String nextBrl, boolean trace ){
 if (trace)
 System.out.println( "SubSupInd.getATag()-- pending:"+pending+
                     " nextBrl: "+nextBrl );
 if (pending == null) return "";
 String endTag;
 System.out.println( "SS getATag waiting: "+waiting4CloseGroup+
" symbol: "+ waiting4Symbol );
 if (!waiting4CloseGroup  && 
     nextBrl.equals( " " )) {
  endTag = pending.getEndTag();
  pending = null;
  return endTag;
 } else if ( nextBrl.equals( waiting4Symbol)){
   waiting4CloseGroup = false;
   waiting4Symbol = null;
   endTag = pending.getEndTag();
   pending = null;
   return endTag;
 }
 return "";
}

}//End Class.
