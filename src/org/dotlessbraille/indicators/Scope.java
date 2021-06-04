package org.dotlessbraille.indicators;
public enum Scope{
 //Indicator scopes
 UNKNOWN,
 DONE,
 TF_SET,
 END_OF_LINE,
 NUM_SET,       //Numeric
 NEXT_SIGN,
 NEXT_LETTER,   //Next (one-cell) a-z
 NEXT_SYMBOL,
 ALPHABETIC,
 WORD_OR_SEQUENCE,
 SPECIAL,
 PASSAGE,
 MOD_PASSAGE,  //Flags old-style passage indicators
 TERMINATOR;   //Requires explicit terminator
public static boolean isSeq( Scope sc ){
 if (sc == ALPHABETIC ) return true;
 if (sc == WORD_OR_SEQUENCE ) return true;
return false;
}
  //  Returns true for opening indicators that
  // allowed by "standing alone" rule. See StandAlone class.
  // HARD-WIRED
public static boolean indBefore( String aBrl ){
 Indicator ind = Indicator.getInd( aBrl );
 if (ind != null) {
  IndicatorClass nameEnum = ind.myIndData.getMyClassEnum();
  Scope myScope = ind.myIndData.getMyScope();
  if (myScope == TERMINATOR ) return false;
  if (nameEnum == IndicatorClass.CAPITALIZATION_INDICATOR ) return true;
  if (nameEnum == IndicatorClass.TYPEFORM_INDICATOR ) return true;
   //Transciber's indicator?
  return false;
 }
 return false;
}
  //  Returns true for closing indicators that
  // allowed by "standing alone" rule. See StandAlone class.
public static boolean indAfter( String aBrl ){
 Indicator ind = Indicator.getInd( aBrl );
 if (ind != null) {
  IndicatorClass nameEnum = ind.myIndData.getMyClassEnum();
  Scope myScope = ind.myIndData.getMyScope();
  if (myScope != TERMINATOR ) return false;
  if (nameEnum == IndicatorClass.CAPITALIZATION_INDICATOR ) return true;
  if (nameEnum == IndicatorClass.TYPEFORM_INDICATOR ) return true;
   //Transciber's indicator?
  return false;
 }
 return false;
}
}//End Enum Scope.