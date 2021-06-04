package org.dotlessbraille.indicators;
import java.util.HashMap;
import java.util.ArrayList;
import org.dotlessbraille.manifold.KeepTrack2;

/** The objects of this class are the UEB grade 1 indicators
    per Section 5 of the Rulebook and include the implicit
    special Grade 1 indicator.

    Its static data and methods are used to initialize
    the indicators and also to manage the status of the
    indicators during backtranslation.  **If there is
    a need for more than one set of these indicators
    this logic would need to be generalized as is done
    for the TypeformIndicator class.**

    The Grade 1 symbol indicator prevents a symbol from
    being misread as a contraction.  For example,
    dots-35 would normally be read as "in" but if it is
    meant as a superscript indicator -- such as indicating
    a raised footnote number at the end of a word --
    it needs to be preceded by a Grade 1 symbol indicator.

    "3.24.1 Indicate the subscript or superscript
     position when used in print. In grade 2 braille,
     use grade 1 mode for the subscript and the
     superscript indicators."
    
    The special G1 mode, which in actual UEB braille doesn't
    have an associated indicator, is set automatically when numeric
    mode starts although it doesn't have any possible effect
    until numeric mode ends. The special G1 indicator isn't turned off
    when the numeric mode ends by will be  turned off implicitly
    by a space, hyphen, or dash. If neccessary it can be
    turned off explicity by a Grace 1 terminator.
    (See Rulebook Sec. 6.5.1.) 

    This class uses an imaginary symbol for the special G1
    mode to make it easier to treat like the real G1
    indicators.

    Note that if a symbol that could
    be mistakenly read as a numeric symbol follows a numeric
    fragment in an alphanumeric item, e.g. one of
    the letters a-j, that symbol needs to be preceded
    by the standard G1 symbol indicator.  In that
    case both G1 indicators are active for that symbol.

     5.3.2 The effect of a grade 1 word indicator is
     terminated by a space or a grade 1 terminator.
*/

public class Grade1Indicator extends Indicator{

 static HashMap<String, Grade1Indicator> grade1Table = 
    new HashMap<String, Grade1Indicator>();
 static ArrayList<Grade1Indicator>g1Inds = 
    new ArrayList<Grade1Indicator>();

 static Grade1Indicator pending = null;
 static boolean specialG1pending = false;
 static Grade1Indicator specialG1;

 EndScope myScope;

//--------------------------------------

Grade1Indicator( String brl, String name, Scope scope){
 super( brl, name, scope );
}
Grade1Indicator( boolean mode, String key, 
                 IndicatorClass master ){
 super( mode, key, master);
}

//====================
//void setScope (Scope scope ){
public static boolean setPending( Grade1Indicator g1Ind ){
 if (pending == null ){
  pending = g1Ind;
  return true;
 } else {
  return false;
 }
}
public static boolean clearPending ( Grade1Indicator g1Ind ){
 if (pending == null ) return false;
 pending = null;
return true;
}
/**5.6.2 When grade 1 mode is set by the numeric indicator
         it is terminated by a space, hyphen, dash 
         or grade 1 terminator.
*/
public static boolean handleTerminator(){
 if (specialG1pending) clearSpecialG1();
 if (pending == null) return false;
 if (pending.scope == Scope.WORD_OR_SEQUENCE){
  pending = null;
  return true;
 }
 if (pending.scope == Scope.PASSAGE){
  pending = null;
  return true;
 }
 return false;  //should not happen for SYMBOL
}

 //This works but use of Endscope would be more general
public static void spaceEncountered(){
 clearSpecialG1();
 if (pending != null){
  if (pending.scope == Scope.WORD_OR_SEQUENCE){
   pending = null;
  };
 }
}
public static void setSpecialG1(){
 specialG1pending = true;
}
public static void clearSpecialG1(){
 specialG1pending = false;
}
//Report whether any Grade1 mode is active
public static boolean useGrade1(){
 if ( specialG1pending ) {
  System.out.println( "G1.useG1: special is active." );
  return true;
 }
 if ( pending != null ) {
  System.out.println( "Pending scope: "+pending.scope );
  return true;
 }
 return false;
}

 //FIX == USE ENDSCOPE for all?
public static void XsymbolDone( String brl ){
 if (specialG1pending ){
   if (specialG1.myScope.done( brl )){
    clearSpecialG1();
   }
 }
 if (pending.scope == Scope.NEXT_SIGN ){
   pending = null;
   //return true;
 }
 //return false;
}

void setEndScope( EndScope myScope ){
 this.myScope = myScope;
}
boolean scopeDone( String symbol ){
 return myScope.done( symbol );
}
public static void cancelG1SymbolMode(){
 System.out.println( "G1Ind.--pending: "+pending );
 if (pending == null) return;
 if (pending.scope == Scope.NEXT_SIGN ){
   pending = null;
 }
}

   //========================================
            //   Grade 1 Indicators.
static void makeSpecialG1Ind( IndicatorClass numInd ){

//Special g1 mode will be set when numeric mode starts 

  Grade1Indicator specG1Ind =
   new Grade1Indicator( true, KeepTrack2.g1SpecBrl, 
              IndicatorClass.GRADE1_INDICATOR );
  specG1Ind.setIndicatorType( IndicatorType.SPECIAL_GRADE_1 );
  specG1Ind.setScope( Scope.SPECIAL );
  g1Inds.add( specG1Ind );
  specialG1 = specG1Ind;
  
     //EndSCOPE for special g1 mode

 /** Rulebook Sec. 6.5.1 A numeric indicator also sets grade 
    1 mode. Grade 1 mode, when set by a numeric indicator, 
    is terminated by a space, hyphen, dash or grade 1 terminator.
*/
    EndScope myEnd = new EndScope( "specialG1", true );
    myEnd.addSym( " " );    // space
    myEnd.addSym( "-" );    // hyphen
    myEnd.addSym( ",-" );   // dash
    myEnd.addSym( "\",_" ); // long dash
    myEnd.addSym( ";'");    // Grade 1 terminator
   
    specG1Ind.setEndScope( myEnd );
    KeepTrack2.setEndscopeForSg1Mode( myEnd );
}

static void makeG1Inds( boolean report, boolean details ){

 Grade1Indicator g1SymInd = 
   new Grade1Indicator( ";", "Grade 1 Symbol", Scope.NEXT_SIGN );
   g1SymInd.setIndicatorType( IndicatorType.G1_SYMBOL );
   
   g1Inds.add( g1SymInd );


 Grade1Indicator g1WrdInd = 
   new Grade1Indicator( ";;", "Grade 1 Word", Scope.WORD_OR_SEQUENCE );
   g1WrdInd.setIndicatorType( IndicatorType.G1_WORD );
   g1Inds.add( g1WrdInd );

      //EndSCOPE for g1 Word Indicator
    EndScope myEnd = new EndScope( "Grade 1 Word", true );
    myEnd.addSym( " " );    // space
    myEnd.addSym( ";'");    // Grade 1 terminator
   
     g1WrdInd.setEndScope( myEnd );
    KeepTrack2.setEndscopeForSg1Mode( myEnd );
    g1WrdInd.setEndScope( myEnd );

 Grade1Indicator g1PassInd = 
  new Grade1Indicator( ";;;", "Grade 1 Passage", Scope.PASSAGE );
  g1PassInd.setIndicatorType( IndicatorType.G1_PASSAGE );
  g1Inds.add( g1PassInd );

 Grade1Indicator g1TermInd = 
  new Grade1Indicator( ";'", "Grade 1 Termination", Scope.TERMINATOR );
  g1TermInd.setIndicatorType( IndicatorType.G1_TERMINATOR );
  g1Inds.add( g1TermInd );

 if (report) System.out.println( "   Grade1 Indicators made. ("
              +g1Inds.size()+")" );

}
}//End Class Grade1Indicator.