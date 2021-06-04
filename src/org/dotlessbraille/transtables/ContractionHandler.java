package org.dotlessbraille.transtables;
import org.dotlessbraille.indicatoruse.PendingCapInds;
import org.dotlessbraille.indicatoruse.CapsFlag;

 //  Obtains backtranslation of braille symbols that
 // are contractions
class ContractionHandler{

 static boolean trace = true;
 PendingCapInds capInfo;

 ContractionHandler(){}

 ContractionHandler( PendingCapInds capInfo ){
  this.capInfo = capInfo;
 }
static void setTrace( boolean b ){
 trace = b;
}
static boolean getTrace(){
 return trace;
}
boolean isContraction( String brl, PartWordUse pwu, boolean trace ){
 boolean oldTrace = getTrace();
 setTrace( trace );
 boolean result = isContraction( brl, pwu );
 setTrace( oldTrace );
 return result;
}

String backTransCon( String brl, PartWordUse pwu, boolean trace ){
 boolean oldTrace = getTrace();
 setTrace( trace );
 String result = backTransCon( brl, pwu );
 setTrace( oldTrace );
 return result;
}

boolean isContraction( String brl, PartWordUse pwu ){

  //Check words also used as contractions
 if (trace){
  System.out.println( "ConHandler--Checking large wd, letter, or ilc." );
 }
 boolean b = LargeWord.isLargeWord( brl );
 if (b) return true;
 b = Letter.isLetter( brl );
 if (b) return true;
 b = WordOrPartWord.isILC( brl );
 if (b) return true;

 if (trace){
  System.out.println( "Not large wd, letter, or ilc." );
 }
 //Check symbols that can be alphabetic contractions
 //without regard for position
 // MAY GET FALSE POSITIVE
 System.out.println( "ConHandler--Checking brl: |"+brl+"|" );
 b = PartWord.isBegOkCon( brl );
 if (b) return true;
 b = PartWord.isMidOkCon( brl );
 if (b) return true;
 b = PartWord.isEndOkCon( brl );
 if (b) return true;

 
 return false;
}

//OBEYS FlAG -- what about is con?
//Does not do shortforms!
String backTransCon( String brl, PartWordUse pwu ){

  //How do I get dot6  rootless guy?
  CapsFlag cf = capInfo.getCapsFlag();
  String ink;
  switch( cf ){
  case LC: 
    ink = tryLC( brl, pwu );
    if (ink == null){
     System.out.println( "ContractionHandler.backTransCon()--");
     System.out.println( " Cannot backtranslate brl to lc: "+brl );
    }
    return ink;
  case TC: 
    ink = tryTC( brl, pwu );
    if (ink == null){
     System.out.println( "ContractionHandler.backTransCon()--");
     System.out.println( " Cannot backtranslate brl to tc: "+brl );
    }
    return ink;
  case UC: 
    ink = tryUC( brl, pwu );
    if (ink == null){
     System.out.println( "ContractionHandler.backTransCon()--");
     System.out.println( " Cannot backtranslate brl to uc: "+brl );
    }
    return ink;
  }
  System.out.println( "ContractionsHandler.backTransCon() cf: "+ cf );
  System.out.println( "LOGIC ERROR!" );
  System.exit( 0 );
  return "";
}
String tryLC( String brl, PartWordUse pwu ){
  String ink = LargeWord.backLC( brl );
  if (ink != null) return ink;
  ink = WordOrPartWord.ilcBackLC( brl );
  if (ink != null) return ink;
  ink = Letter.backTrans2lc( brl );
  if (ink != null) return ink;
   //Note that PartWord is programmed to include 
   //"ANYWHERE" contractions in any of the categories
   switch (pwu){
    case ANYWHERE:
     return PartWord.backSG2LC( brl );
    case BEG_WORD:
     return PartWord.backBeg2LC( brl );  
    case MID_WORD:
     return PartWord.backMid2LC( brl ); 
    case END_WORD:
     return PartWord.backEnd2LC( brl ); 
   }
  System.out.println( "CH.tryLC--bad pwu: "+pwu );

  return (String) null;
} 
String tryTC( String brl, PartWordUse pwu ){

  String ink = LargeWord.backTC( brl );
  if (ink != null) return ink;
  ink = WordOrPartWord.ilcBackTC( brl );
  if (ink != null) return ink;
  ink = Letter.backTrans2UC( brl );
  if (ink != null) return ink;
 
   //Note that PartWord is programmed to return 
   //"ANYWHERE" in any of the last 3 categories
   switch (pwu){
    case ANYWHERE:
     return PartWord.backSG2TC( brl );
    case BEG_WORD:
     return PartWord.backBeg2TC( brl );  
    case MID_WORD:
     return PartWord.backMid2TC( brl ); 
    case END_WORD:
     return PartWord.backEnd2TC( brl ); 
   }
  System.out.println( "CH.tryTC--bad pwu: "+pwu );
  return (String)null;
}
String tryUC( String brl, PartWordUse pwu ){

  String ink = LargeWord.backUC( brl );
  if (ink != null) return ink;
  ink = WordOrPartWord.ilcBackUC( brl );
  if (ink != null) return ink;
  ink = Letter.backTrans2UC( brl );
  if (ink != null) return ink;

   //Note that PartWord is programmed to return 
   //"ANYWHERE" in any of the last 3 categories
   switch (pwu){
    case ANYWHERE:
     return PartWord.backSG2UC( brl );
    case BEG_WORD:
     return PartWord.backBeg2UC( brl );  
    case MID_WORD:
     return PartWord.backMid2UC( brl ); 
    case END_WORD:
     return PartWord.backEnd2UC( brl ); 
   }
  System.out.println( "CH.tryOC--bad pwu: "+pwu );
  return (String)null;
} 
  //Checks if valid starting symbol
  //Assumes contracted braille
  //Assumes NOT standing alone
  //Goal is concat and get a valid word
boolean checkIfStart( String brlSymbol ){
 return true;

/**
  Not one-symbol words:
   alphabetic wordsigns, strong wordsigns, 
   shortforms since NOT standing alone
   So need to say NO if one symbol!!!
   Backtrans should know this???

  But could be a one-symbol large-sign word or ilc word
  or lower wordsign (be, in, enough, ...) if context right

  Otherwise more than one syllable it is part of a word

    ANYWHERE GUYS
   large-sign con
   ilc con
   A letter everywhere

   strong groupsigns everywhere
   shortforms (not the ones never in words!)

     restricted guys
   the mid-only guys are a problem???
   lower groupsigns vatious
   flc mid-end
*/


 
}
public static void main( String [] args ){
}
}//End Class ContractionHandler;