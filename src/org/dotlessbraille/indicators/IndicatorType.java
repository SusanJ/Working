package org.dotlessbraille.indicators;
/** Enumerates all the different types of indicators and specific indicators in UEB. 
Differnt indicators have different scopes which in some cases can be implicit as well
as explicit. 
Keeping track of active indicators and taking action when they go out of scope is one
of the difficulties of translating and backtranslating UEB>
*/
public enum IndicatorType{
 UNKNOWN,
 CAPITAL,
 CAPITAL_WORD,
 CAPITAL_PASSAGE,
 CAPITAL_TERMINATOR,
 TYPEFORM,
 ITYPEFORM,
 UTYPEFORM,
 BTYPEFORM,
 STYPEFORM,
 TDTYPEFORM,
 TD1TYPEFORM,
 TD2TYPEFORM,
 TD3TYPEFORM,
 TD4TYPEFORM,
 TD5TYPEFORM,
 NUMERIC_START,
 NUMERIC_CONTINUE,
 SPACED_NUMERIC_START,
 NUMERIC_PASSAGE,
 NUMERIC_TERMINATOR,
 G1_WORD,
 G1_SYMBOL,
 G1_SPECIAL,
 G1_PASSAGE,
 G1_TERMINATOR,
 SPECIAL_GRADE_1,
 TRANSCRiBER_OPEN,
 TRANSCRIBER_CLOSE
;

//Deprecated -- see Scope for using indicator sub-class
public static boolean isTypeform( IndicatorType test ){
 if (test == TYPEFORM) return true;
 if (test == ITYPEFORM) return true;
 if (test == BTYPEFORM) return true;
 if (test == STYPEFORM) return true;
 if (test == UTYPEFORM) return true;
 return false;
}
 //Why not TF terms???
public static boolean isAnyTerminator( IndicatorType test ){
 if (test == CAPITAL_TERMINATOR ) return true;
 if (test == NUMERIC_TERMINATOR ) return true;
 if (test == G1_TERMINATOR ) return true;
 return false;
}
  //This is awkward, I need an object that contains (type and scope!)
  // so I don't need to sub-class Indicator
public static boolean isAnyNumeric( IndicatorType test ){
 if (test == NUMERIC_START ) return true;
 if (test == NUMERIC_CONTINUE ) return true;
 if (test == SPACED_NUMERIC_START ) return true;
 if (test == NUMERIC_PASSAGE ) return true;
 return false;
}
}//End Enum IndicatorType