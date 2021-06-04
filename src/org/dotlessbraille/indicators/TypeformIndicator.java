package org.dotlessbraille.indicators;
import java.util.ArrayList;
import java.util.HashMap;


//Constructs translation information objects for all 4
//default sets of 4 UEB Typeform Indicators per xxx/
//TODO -- Transcriber-defined inidcators;
//Transcriber-defined symbols don't have HTML tags?


public class TypeformIndicator extends Indicator{

 static boolean display = false;

  //Indices for internal use
 static int symbolIndIndex   = 0;
 static int wordIndIndex     = 1;
 static int passageIndIndex  = 2;
 static int terminationIndIndex = 3;

    //ASCII Braille for UEB TF Indicators

    //Prefixes
  static String DOTS46   = "."; //Italics prefix
  static String DOTS45   = "^"; //Bold prefix
  static String DOTS456  = "_"; //Underlined prefix
  static String DOT4     = "@"; //Script prefix
  
  static String DOT4_HASH = "@#";    //1st transcrber def. prefix
  static String DOTS45_HASH = "^#";  //2nd transcrber def. prefix
  static String DOTS456_HASH = "_#"; //3rd transcrber def. prefix
  static String DOT5_HASH = "\"#";   //4th transcrber def. prefix
  static String DOTS46_HASH = ".#";  //5th transcrber def. prefix

/**
      Parser Grammar

  d4_hash:   DOT4 DOTS3456;
  d45_hash:  DOTS45 DOTS3456;
  d456_hash: DOTS456 DOTS3456;
  d5_hash:   DOT5 DOTS3456;
  d46_hash:  DOTS46 DOTS3456;

  tfPrefix: DOTS46|DOTS45|DOTS456|DOT4|
            d4_hash|d45_hash|d456_hash|
            d5_hash|d46_hash;
  tfStartRoot: DOTS23|DOT2|DOTS2356;
  tfTermRoot:  DOT3;
  tfStartIndicator: ((tfPrefix)(tfStartRoot));
  tfTermIndicator:  ((tfPrefix)(tfTermRoot));

*/


   //Roots
  static String DOTS23   = "2";  //Symbol root
  static String DOT2     = "1";  //Word/Sequence
  static String DOTS2356 = "7";  //Passage root
  static String DOT3     = "'";  //Terminator root

 static HashMap <String, String> tfTransTable = 
    new HashMap <String, String>();
 static ArrayList<TypeformIndicator> tfInds = 
    new ArrayList<TypeformIndicator>();

  //Same parameters for all sets of 4 TF indicators
 static Scope setScope = Scope.TF_SET;
 static Scope[] scopes = new Scope[4];
 static String[] names = new String [4];
 
  //Trailing part of symbol for default TFIs
 static String [] defTrailing = new String [4];
  //Trailing part of symbol for transcriber defined TFIs
 static String [] tDsTrailing = new String [4];


 String inkStartTag;
 String inkEndTag;
 IndicatorType indType;
 ArrayList <TypeformIndicator> mySet = 
  new ArrayList<TypeformIndicator>();
 String ink;
 TfIndSet myTFset;

TypeformIndicator( String brl, String name, Scope scope,
                   String inkStartTag, String inkEndTag, 
                   IndicatorType indType, TfIndSet myTFset ){
 super( brl, name, scope);
 this.inkStartTag = inkStartTag;
 this.inkEndTag = inkEndTag;
 this.indType = indType;
 this.myTFset = myTFset;
 if (scope != Scope.TERMINATOR ) {
   tfTransTable.put( brl, inkStartTag );
   this.ink = inkStartTag;
   if (display) System.out.println( "TF brl: "+brl+" ink: "+inkStartTag );
 } else {
   tfTransTable.put( brl, inkEndTag );
   this.ink = inkEndTag;
   if (display) System.out.println( "TF brl: "+brl+" ink: "+inkEndTag );
 }
 
}

// This indicator needs to report to its myTFset 
public boolean setMe( ){
 return myTFset.checkInd( this );
}
TypeformIndicator( String brl, String name, Scope scope,
                   ArrayList<TypeformIndicator> mySet,
                   IndicatorType indType ) { 
 super( brl, name, scope);
 this.mySet = mySet;
 this.indType = indType;
}
//Constructor to allow additional TF info later
//  Might be useful for transcriber-defined TFs
    TypeformIndicator( String brl, String name, Scope scope,
        IndicatorType indType ){  
  super( brl, name, scope); 
  this.indType = indType;             
}

//------------------------------------------------------
//Can be used to set tags are reset default tags
void setInkTags( String inkStartTag, String inkEndTag ){
  this.inkStartTag = inkStartTag;
  this.inkEndTag = inkEndTag;
}
public IndicatorType getIndType(){
 return indType;
}
public String getStartTag(){
 return inkStartTag;
}
public String getEndTag(){
 return inkEndTag;
}

//=====================================================
static void makeSetParams( boolean report ){
   scopes[symbolIndIndex] = Scope.NEXT_SYMBOL;
   names[symbolIndIndex] = " Symbol indicator";

   scopes[wordIndIndex] = Scope.WORD_OR_SEQUENCE;
   names[wordIndIndex] = " Word indicator";

   scopes[passageIndIndex] = Scope.PASSAGE;
   names[passageIndIndex] = " Passage indicator";

   scopes[terminationIndIndex] = Scope.TERMINATOR;
   names[terminationIndIndex] = " Terminator";
}

//Information hard-wired per UEB Manual
//  HTML Tags hard-wired for convenience FIX???
//In addition to the set of four tf indicators for each tf,
// there is an extra "indicator" that keeps track of the
// set if necessary
static void makeDefs( boolean report ){

  //System.out.println( "Starting TypeformIndicator.makeDefs()..." );
  makeDefTFTrailing();

  String groupName0 = "Italics";
  ArrayList <TypeformIndicator> itSet =
     new ArrayList<TypeformIndicator>();
  TfIndSet iSet = new TfIndSet( groupName0, itSet, 
       IndicatorType.ITYPEFORM );
  makeTfSet( groupName0,    DOTS46, true, "<i>", "</i>", itSet,
    IndicatorType.ITYPEFORM, iSet);
    //Not needed???
  TypeformIndicator itSetInd = 
    new TypeformIndicator("italic", groupName0, setScope, itSet,
     IndicatorType.ITYPEFORM );
  
  String groupName1 = "Bold";
  ArrayList <TypeformIndicator> bfSet =
     new ArrayList<TypeformIndicator>();
  TfIndSet bSet = new TfIndSet( groupName1, bfSet, 
       IndicatorType.BTYPEFORM );
  makeTfSet( "Bold",  DOTS45, true, "<b>", "</b>", bfSet,
     IndicatorType.BTYPEFORM, bSet );
  TypeformIndicator bfSetInd = 
   new TypeformIndicator("bold", groupName1, setScope, bfSet,
      IndicatorType.BTYPEFORM);
  
  String groupName2 = "Underlined";
  ArrayList <TypeformIndicator> unSet =
     new ArrayList<TypeformIndicator>();
  TfIndSet uSet = new TfIndSet( groupName2, unSet, 
       IndicatorType.UTYPEFORM ); 
  makeTfSet( "Underlined", DOTS456 , true, "<u>", "</u>", unSet,
     IndicatorType.UTYPEFORM, uSet );
  TypeformIndicator underSetInd = 
   new TypeformIndicator("under", groupName2, setScope, unSet,
     IndicatorType.UTYPEFORM  );
 
  String groupName3 = "Script";
  ArrayList <TypeformIndicator> scrSet =
     new ArrayList<TypeformIndicator>();
  TfIndSet sSet = new TfIndSet( groupName3, scrSet, 
       IndicatorType.STYPEFORM );
  TypeformIndicator scrSetInd = 
   new TypeformIndicator("script", groupName3, setScope, scrSet,
   IndicatorType.STYPEFORM );  
  makeTfSet( "Script", DOT4 , true, "<s>", "</s>", scrSet, 
    IndicatorType.STYPEFORM, sSet );

  ArrayList <TypeformIndicator> td1Set =
     new ArrayList<TypeformIndicator>();
  String groupName4 = "Trans.Def.1";
  ArrayList <TypeformIndicator> td2Set =
     new ArrayList<TypeformIndicator>();
  String groupName5 = "Trans.Def.2";

  if (report) System.out.println( "   Typeform indicators table made." );
 }



 //Makes the 4 indicators in a set and saves them in
 //the list of all tf indicators and also in the
 //list associated with the particular set.
 //TO_DO???  the mySet guys could just be arrays
static void makeTfSet( String groupName, String lead,
                        boolean useTags,
                        String inkStart, String inkEnd,
                        ArrayList <TypeformIndicator> mySet,
                        IndicatorType indType,
                        TfIndSet myTFset
                        ){
 
   StringBuilder brl;
   StringBuilder name;
   for (int i=0; i<4; i++){
    brl = new StringBuilder();
    brl.append( lead );
    brl.append( defTrailing[i]);
    name = new StringBuilder();
    name.append( groupName );
    name.append( names[i] );
    TypeformIndicator tmp;
    if (useTags){
      //System.out.println( "TFIND scope: "+scopes[i] );
      tmp = new TypeformIndicator( brl.toString(), name.toString(), 
                         scopes[i], inkStart, inkEnd, indType,
            myTFset );
    } else {
      tmp = new TypeformIndicator( brl.toString(), name.toString(), 
                          scopes[i], indType  ); 
    }  
    mySet.add( tmp );
    tfInds.add( tmp );
     
    
   } 
}

 //Trailing information hard-wired per UEB Manual
static void makeDefTFTrailing(){
  defTrailing [symbolIndIndex] = DOTS23;
  defTrailing [wordIndIndex] = DOT2;
  defTrailing [2] = DOTS2356;
  defTrailing [3] = DOT3;
}
 //Trailing information hard-wired per UEB Manual
 //Actually the same as for the default ones
static void maketDsTrailing(){
  tDsTrailing [symbolIndIndex] = DOTS23;   // DOTS23
  tDsTrailing [wordIndIndex] = DOT2;     // DOT2
  tDsTrailing [2] = DOTS2356; // DOTS2356
  tDsTrailing [3] = DOT3;   // DOTS25
}

//Information hard-wired per UEB Manual
//One Transcriber-defined one just for fun!
static void makeTDss(){ 
  maketDsTrailing();

  ArrayList <TypeformIndicator> firstSet =
     new ArrayList<TypeformIndicator>();
   TfIndSet tf1Set = new TfIndSet( "groupName", firstSet, 
       IndicatorType.TDTYPEFORM );
  String groupName = "First def tf";
  makeTfSet( "groupName", DOT4_HASH, false, "", "", firstSet, 
  IndicatorType.TDTYPEFORM, tf1Set );
  TypeformIndicator firstSetInd = 
    new TypeformIndicator("italic", groupName, setScope,
      IndicatorType.TDTYPEFORM     );
} 
//Information hard-wired per UEB Manual
static void makeTfInds( boolean report, boolean display ){
 makeSetParams( report );
 makeDefs( report );
 makeTDss();
 if (display) displayTFInds();
}
static boolean isTFind( Indicator ind ){
 if (tfInds.contains( ind )) return true;
 return false;
}
static boolean isOpeningTFind( String brl ){
 String ink = tfTransTable.get( brl );
 if (ink == null) return false;
 //if (tfInds.contains( ind )) return true;
 return false;
}
 static void displayTFInds(){
  for (TypeformIndicator tf : tfInds){
   System.out.println( "Type: "+ tf.getIndType()+
                       " Braille: "+tf.getBrl() );
  } 
 }
}//End Class TypeformIndicators.