package org.dotlessbraille.manifold;
import java.util.ArrayList;
import org.dotlessbraille.indicators.Persist;
import org.dotlessbraille.indicators.EndScope;
import org.dotlessbraille.indicators.Grade1Indicator;
import org.dotlessbraille.indicators.Scope;


 //  Handles communication between BackInd
 // and KeepTrack which latter does the 
 // backtranslation for non-indicators and
 // for symbols which function as both indicators
 // and symbols, i.e. numeric mode
 // start indicators

public class KeepTrack2 implements LineNumberTracker,
             LineNumberBcaster {

 public static String g1SpecBrl = ";;;;";
 static boolean traceCheck = false;
 static boolean traceNummode = false;

  //  Flag indicating that previous symbol was
  // a subscript or superscript indicator
  // part of logic to determine end of script
 static boolean lastWasSubSup = false;

 static boolean dlMention = false;

 static boolean inNumericMode = false;
 static boolean inSpecialG1Mode = false;
 static boolean inG1SymbolMode = false;
 static Persist numModeSyms;
 static EndScope g1ModeSyms;
 static boolean traceG1 = false;

 public static String aSpace = " ";

 public KeepTrack2( LineNumberProvider lnp ){
  lnp.addTracker( this );
 }
 
/**   What KT listens for
   //from BackInd
public static void setPendingG1( Grade1Indicator g1Indy, Scope scope );
public static void setLastWasSubSup( boolean toSet ){
public static void setDlMention( boolean toSet ){

   //from NumericIndicator
public static void setPersistForNumMode( Persist numModePersist );
public static void setEndscopeForSg1Mode( EndScope sg1ModeEndscope )

public static void spaceEncountered( String ink );
public static void separatorEncountered();
public static void spaceEncountered( );
public static void numfragDone();
public static void cancelG1SymbolMode();
{

public static boolean checkNumMode( String brl );
public static boolean checkSpecialG1Mode( String brl ) ;


      AND LOTS MORE
*/

  //Fulfill LineNumberTracker interface
  int lineNum;
 public void startingFirstLine( int lineNum ){
  this.lineNum = lineNum;
 }
 public int nextLineStarted(){
  lineNum = lineNum+1;
  broadcast( lineNum );
  return lineNum;
 }
 void broadcast( int lineNum ){
  if (lnListeners.size() == 0 ) return;
  for( LineNumberListener lnl: lnListeners){
   lnl.LineNumberUpdate( lineNum ); 
  }
 }

  //Fulfill LineNumberBcaster interface
  ArrayList <LineNumberListener> lnListeners =
   new ArrayList <LineNumberListener>();
 public void addListener( LineNumberListener lnl ){
   lnListeners.add( lnl );
 }

    //Void stuff it just gets

public static void setPendingG1( Grade1Indicator g1Indy, Scope scope ){
 //System.out.println( "KT2 -- supposed to set G1 with scope: "+scope);
 switch (scope){
  case NEXT_SIGN:
   inG1SymbolMode = true;
   return;
  case SPECIAL:
   inSpecialG1Mode = true;
   return;
  }
  Grade1Indicator.setPending( g1Indy );
  return;
}

 public static boolean useGrade1(){
  if (inSpecialG1Mode) {
   if (traceG1) System.out.println( "KT2--special G1 active" );
   return true;
  }
  if (inG1SymbolMode){
   if (traceG1) System.out.println( "KT2--G1 Symbol active" );
   return true;
  }
  boolean g1indUse = Grade1Indicator.useGrade1();
  if (traceG1) System.out.println( "Grade1Ind report: "+g1indUse );
  return g1indUse;
 }

 public static void spaceEncountered( String ink ){
  checkSpecialG1Mode( ink );
  checkNumMode( ink );
 }
 public static void separatorEncountered(){
 }


public static void spaceEncountered( ){
  checkSpecialG1Mode( aSpace );
  checkNumMode( aSpace );
 }
 
public static void numfragDone(){
 if (traceNummode)
   System.out.println( "KT2 last nummode symbol, nummode off now." );
 inNumericMode = false;
}

 //  If currently in numeric mode checks whether
 // input symbol allows numeric mode to continue
 public static boolean checkNumMode( String brl ) {
  if (!inNumericMode ) return false;
  inNumericMode = numModeSyms.allowed( brl );
  if (!inNumericMode){
   System.out.println( "brl: |"+brl+"| just ended numeric mode." );
  }
   //There are some symbols that can turn both modes off
  if (!inNumericMode) checkSpecialG1Mode( brl );
  return inNumericMode;
 }

 //   If currently in SpecialG1Mode but no longer
 // in numeric mode checks whether
 // input symbol allows special g1 mode to continue
  public static boolean checkSpecialG1Mode( String brl ) {

  if (traceCheck){
  System.out.println( "KT2-ckSpG1 nummode, specg1: "+inNumericMode+
   " "+inSpecialG1Mode );}

  if (inNumericMode) return true;
  if (!inSpecialG1Mode ) return false;
  if (traceCheck){
   System.out.println( "KT2 checking brl: |"+brl+"|for G1 Mode" );
  }
  inSpecialG1Mode = g1ModeSyms.allowed( brl );
  if (!inSpecialG1Mode){
   Grade1Indicator.clearSpecialG1();
   System.out.println( "brl symbol: |"
     +brl+"| just ended special G1 mode." );
  }
  return inSpecialG1Mode;
 }
 
  public static void cancelG1SymbolMode(){
   if (inG1SymbolMode){
    System.out.println( "KT2--going to cancel G1Sym. mode" );
   }
   inG1SymbolMode = false;
   //Grade1Indicator.cancelG1SymbolMode();
  }

    //from NumericIndicator
  public static void setPersistForNumMode( Persist numModePersist ){
   numModeSyms = numModePersist;
 }

   //from Grade1Indicator
  public static void setEndscopeForSg1Mode( EndScope sg1ModeEndscope ){
  g1ModeSyms = sg1ModeEndscope;
 }
  public static void setNumericMode( boolean inNumMode ){
  inNumericMode = inNumMode;
  if( inNumericMode) inSpecialG1Mode = true;
 }
 public static void setDlMention( boolean toSet ){
  dlMention = toSet;
 }
 //Set true by BackInd
 //Reset by KeepTrack after observation
 public static void setLastWasSubSup( boolean toSet ){
  lastWasSubSup = toSet;
 }

     //  *** STUFF it COULD BROADCAST ***
 public static boolean getNumericMode( ){
  return inNumericMode;
 }
 public static boolean getGrade1Mode( ){
  return inSpecialG1Mode;
 }
 public static boolean getDlMention(){
  return dlMention;
 }
 public static boolean isContracted(){
  return false;
 }
 //Observed by KeepTrack
 public static boolean getLastWasSubSup(){
  return lastWasSubSup;
 }

}//End Class KeepTrack2.