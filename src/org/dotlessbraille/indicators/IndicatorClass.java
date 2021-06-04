package org.dotlessbraille.indicators;
import java.lang.Class;
import java.util.HashMap;

public enum IndicatorClass{

 //Items useful for switch case choices among
 //indicators created by different Indicator subclasses
 
 ANY_INDICATOR      ( "Indicator" ),
 CAPITALIZATION_INDICATOR ( "CapsIndicator" ),
 DOT_LOCATOR ("DotLocatorIndicator" ),
 GRADE1_INDICATOR   ( "Grade1Indicator" ),
 NEMETH_INDICATOR   ( "NemethIndicator" ),
 NUMERIC_INDICATOR  ( "NumericIndicator"),
 SUBSUP_INDICATOR   ( "SubSupIndicator" ),
 TRANSCRIBER_INDICATOR ( "TranscriberIndicator" ),
 TYPEFORM_INDICATOR ( "TypeformIndicator" ),
 UNKNOWN            ( "Not an indicator." );

 private static final HashMap<String, IndicatorClass> str2Enum =
   new HashMap<String, IndicatorClass> ();
 static {
  for ( IndicatorClass ic: values())
   str2Enum.put( ic.className, ic );
}
 String className;  //Must be correct (unqualitified) class name!
 IndicatorClass( String className ){
  this.className = className;
 }

// Returns corresponding enum if input represents 
// an indicator known to this Enum  by its 
// unqualified class name or UNKNOWN if not
public static IndicatorClass  indName( String aBrl ){
 Indicator ind = Indicator.getInd( aBrl );
 return indName( ind );
}
public static IndicatorClass indName( Indicator ind ){
 if (ind != null) {
    Class aClass = ind.getClass();
    String aName = aClass.getName();
    int i = aName.lastIndexOf( "." );
    String unName = aName.substring(i+1);
    //System.out.println( "IC indName() unName: "+unName );
    IndicatorClass ic = str2Enum.get( unName ); 
    if (ic != null) return ic;
 }
 return UNKNOWN;
}

}//End.