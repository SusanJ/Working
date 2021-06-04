package org.dotlessbraille.indicators;
import java.util.HashMap;
import java.util.ArrayList;
//import org.dotlessbraille.manifold.KeepTrack2;
/** Implements Rulebook Sec. 14 Nemeth code switch
    indicators.
*/
public class NemethIndicator extends Indicator{
/**
  Code switching indicators for Nemeth Code
  _% opening Nemeth Code indicator followed by space
  _: Nemeth Code terminator preceded by space
  Note: The Nemeth Code terminator is a Nemeth Code
  indicator, not a UEB indicator.

  Example of inline use from Sec. 14.6.2: 

  He said, "4x+3y is the numerator."

  ,he sd1 8_% #4x+3y _: is ! num]ator40

  Example of displayed use:

_%
 #4x^3"-12x^2"-x+3
   .k #4x^2"(x-3)-(x-3)
_:

*/

 static ArrayList<NemethIndicator>nemInds = 
    new ArrayList<NemethIndicator>();

 boolean inline;
 String startTag = "";
 String endTag = "";

NemethIndicator( String brl, String name, Scope scope,
                 boolean inline){
 super( brl, name, scope );
 this.inline = inline;
}
void setStartTag( String myStartTag ){
 //System.out.println( "NemInd  before setStartTag: "+startTag );
 startTag = myStartTag;
 //System.out.println( "NemInd setStartTag: "+startTag );
 getStartTag();
}
void setEndTag( String endTag ){
 this.endTag = endTag;
}
//String getStartTag(){
public String getStartTag(){
 //System.out.println( "NemInd.getStartTag(): |"+startTag+"|" );
 return startTag;
}
public String getEndTag(){
 return endTag;
}

public static void makeNemethIndicators( boolean report,
                                         boolean display ){
 NemethIndicator nemStartIn = 
  new NemethIndicator( "_% ", "BNEM", Scope.TERMINATOR, true );
  nemStartIn.setStartTag( "Nem inline...." );
 nemInds.add( nemStartIn );

  //Grammar uses correct symbol
  //Translator prepends extra "D" (still multiple maintenaince FIX)S
 NemethIndicator nemStartDis = 
  new NemethIndicator( "D_% ", "BNEM", Scope.TERMINATOR, false );
 nemStartDis.setStartTag( "Nem display!" );
 nemInds.add( nemStartDis );

 NemethIndicator nemEndIn = 
  new NemethIndicator( "_: ", "ENEM", Scope.DONE, true );
 nemInds.add( nemEndIn );

 NemethIndicator nemEndDis = 
  new NemethIndicator( "D_: ", "eNEM", Scope.END_OF_LINE, false );
  nemInds.add( nemEndDis );

 if(report){
  System.out.println( "Made Nemeth indicators ("+nemInds.size()+")");
 }

}

}//End Class.

