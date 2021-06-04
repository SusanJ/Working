package org.dotlessbraille.transtables;
import java.util.ArrayList;
import java.util.Stack;
import org.dotlessbraille.indicatoruse.BackInd;
import org.dotlessbraille.indicators.Indicator;
import org.dotlessbraille.indicators.IndicatorClass;
import org.dotlessbraille.indicators.InitializeIndicators;

/**  Records the types of symbols in a symbols-sequence
   so as to support contracted backtranslation of **any 
   words** in the sequence by  
     (1) separating the words from any preceding 
      and/or following punctuation and/or
      indicators and 
     (2) by identifying the positions of
      their beginning, interior, and ending symbols

     This is NOT a final backtranslator as it does not 
   incorporate the effect of indicators
     The logic here is necessary to support using tables of
   already translated words including the required
   Rulebook table listing
   the several hundred words which UEB has specified as 
   those words allowed to use shortforms as part-word contractions
     The reason this is so complex is because this is the
   situation where the parser grammar is very loose to
   allow for arbitrary user input that is simply
   a symbols-sequence using the general definition of
   symbols as prefix-root tokens

   Valid word is alphabetic only!!!
  
*/

public class SymbolsSequence{

 enum SymbolCategory {PREPUNC, NUMBER, WORD, LETTER, 
                      WORDorPARTWORD, POSTPUNC, OTHER,
                      ALPHABETIC, INDICATOR };

 int cnt = 0;      //Number of symbols in sequence
 int prePunc = 0;  //Number of prepunction items found
 int wordItem = 0; //Number of "word" items found
 int postPunc = 0; //Number of postpunction items found
 int ind = 0;      //Number of indicators items found
 int preInds = 0;
 int wordInds = 0;
 int postInds = 0;
 boolean funny = false;   // When true input is NOT a grammatical
                          //pre-word-post sequence
 boolean wordStarted = false;  //First symbol of word not yet found
 int startPos = -1;   //Position of first symbol of word in sequence
 boolean wordEnded = false;  // Position of last symbol of word not
                           //yet defined
 int endPos = -1;     //Position of last symbol of word in sequence

 ArrayList <SymbolCategory> seq = new ArrayList <SymbolCategory> ();
 BackInd backInd = new BackInd();
 ContractionHandler conHandler = new ContractionHandler();
 //Indicator pending = (Indicator) null;

 Stack<Indicator> pendingInds =  new Stack<Indicator> ();
 boolean debug = false;


 public SymbolsSequence(){
  ;
 }

 public void init(){
  seq.clear();
  cnt = 0;
  prePunc  = 0;
  wordItem = 0;
  postPunc = 0;
  ind = 0;
  preInds  = 0;
  wordInds = 0;
  postInds = 0;
  funny = false;
  wordStarted = false;
  startPos = -1;
  wordEnded = false;
  int endPos = -1;
  //pending = (Indicator) null;
 }
 public void prGotPrepunc( String brl, String ink ){  
  prePunc = prePunc + 1;
 }
 public void numfragReport( int myCnt ){
  cnt = cnt + myCnt;
 }
 public void prTokenGotInd( String ink ){
  ind = ind + 1; //Hmmm...
  cnt = cnt + 1;
 }
 public int getCnt(){
  return cnt;
 }
 public void justProcessedPrePunc( boolean what ){
 }


   //Note the LOGIC ERRORS were intended for debugging
   //and hopefully can't occur!!!
 boolean okDetails( int cnt ){

  if (funny) return false;

  int myCnt = prePunc + wordItem + postPunc;
  if (myCnt != cnt ){
   System.out.println( "SymbolsSequence LOGIC ERROR No. 1!" );
   System.out.println( "Cnt input: "+cnt+" calc: "+myCnt );
   System.exit( 1 );
  }

  int preStartPos = -1;
  int postStartPos = -1;
  int preEndPos = -1;
  int postEndPos = -1;

  if (prePunc > 0){
   preStartPos = 0;
   //Check word start position after prepunc for consistency
   if (startPos != preStartPos + prePunc){
    System.out.println( "SymbolsSequence LOGIC ERROR No. 2!" );
    int calc = preStartPos + prePunc;
    System.out.println( "startPos: "+startPos+" calc: "+calc );
    System.exit( 1 );
   }
   //Check word start position when no prepunc 
  } else if (startPos != 0){
    System.out.println( "SymbolsSequence LOGIC ERROR No. 3!" );
    System.out.println( "startPos: "+startPos+" calc: "+0 );
    System.exit( 1 );
  }

  int eCalc = cnt-1;
  if (postPunc <= 0) {
     endPos = startPos + wordItem-1;
     //Check calculated word end position when no postpunc 
     if (endPos != eCalc){
      System.out.println( "SymbolsSequence LOGIC ERROR No. 4!" );
      System.out.println( "endPos: "+endPos+" calc: "+eCalc );
      System.exit( 1 );
     }
  } else {
    postStartPos = endPos+1;
    postEndPos = postStartPos + postPunc - 1;
    //Check calculated postpunc end position 
    if (postEndPos != eCalc){
      System.out.println( "SymbolsSequence LOGIC ERROR No. 5!" );
      System.out.println( "postEndPos: "+postEndPos+" calc: "+eCalc );
      System.exit( 1 );
     }
   }
   if (!debug) return true;

       //Print summary of results
   if (preStartPos == -1){
    System.out.println( "  No prefix." );
   } else{
    preEndPos = startPos-1;
    System.out.println( "  Prefix index from: "+preStartPos+
                        " to: "+preEndPos );
   }
   System.out.println( "  Word index from: "+startPos+
                       " to: "+endPos );

   if (postStartPos == -1){
    System.out.println( "  No postfix." );
   } else {
     eCalc = cnt-1;
     System.out.println( "Postfix index from: "+postStartPos+
       " to: "+ eCalc);
   }
   return true;
 }

      //  *****USER ENTRY POINT*****
 public boolean checkSeq( ArrayList<String> theSeq ){
  int pos = -1;
  boolean first = true;
  boolean last = false;
  int lastIndex = theSeq.size()-1;

 //Identify end to avoid problems with
 //symbols for ea, in middle of word
  int lastPunc = lastIndex;
  int firstPunc = -1;
  boolean postfix = true;
  //int start = lastIndex;
  for (int s = lastIndex; s > -1; s-- ){
   boolean b = isPostfix( theSeq.get( s ) );
   if (!b ){
    firstPunc = s+1;
    if (firstPunc > lastPunc){
      postfix = false;
    }
    break;
   }
  }

   if (postfix){
    //if good word it ends at pos firstPunc-1
    // word end = firstPunc-1
   } 
  

  //Check type of each item
  for ( String seq : theSeq ){
   pos = pos + 1;
   if (pos > 0) first = false;
   if (pos == lastIndex) last = true;
   analyze( seq, pos, first, last );
   if (funny) return false;
  }
  //Found an optional prefix, required word,
  //optional postfix structure so get the
  // indices
  boolean ok = okDetails( theSeq.size() );
 
   //Concatenate the word part to see if its 
   //translation is available -- of course
   //this isn't necessarily final since not
   //processing indicators here
 if (ok){
  StringBuilder buf = new StringBuilder();
  for (int i = startPos;  i < endPos+1; i++ ){
   buf.append( theSeq.get( i ));
  }
  String conCatWord = buf.toString();
  System.out.println( "Entire word item: "+conCatWord );
 } 
 return ok;
}

 //User needs startPos and endPos -- can concatenate
   

//====================================================
 //  Ensure that any prePunc symbols (incl. indicators)
 // precede the first word symbol; that there
 // is at least one word symbol; and that any
 // postPunc symbols (incl. indicators) follow 
 // the last word symbol
 //  Word cannot have embedded indicators since the
 // point is to discover complete words for which 
 // the backtranslation can be looked up in a table
//====================================================

 public void analyze( String brl, int pos, boolean first,
      boolean last ){

  System.out.println( "   SymbolsSequenc.analyze brl: "+brl+" at pos: "+pos );
  //What if there is already an indicator pending???
  Indicator indy = backInd.check4Ind( brl );
  if (indy == null){
    System.out.println( "Not an indicator." );
  } else {
    IndicatorClass ic = indy.myIndData.getMyClassEnum();
    System.out.println( "Input is an indicator--."+ic );
    if (ic == IndicatorClass.NUMERIC_INDICATOR){
     funny = true;
     return;
    }
   ind = ind + 1;
   //Indicator ok as part of prefix
   if (wordItem == 0 && postPunc == 0){
     seq.add( SymbolCategory.INDICATOR );
     prePunc = prePunc + 1;
     preInds = preInds + 1;
     return;
     //Indicator might be part of the word
     //Need to wait and see if word was just finished
     //so indicator (stack) starts postfix 
   } else if (postPunc == 0){
     if (last){
      //if (last) just go ahead pop stack to postfix
     }
     pendingInds.push( indy );
     return;
     //Indicator is additional part of postfix
   } else {
     seq.add( SymbolCategory.INDICATOR );
     postInds = postInds+1;
     postPunc = postPunc+1;
     return;
   }
  } //End indicator logic

        // PRE-PUNCTUATION
  if (wordItem == 0 && postPunc == 0){
   boolean isAPrepunc = Punctuation.isPrePunc( brl );
   if (isAPrepunc){
    prePunc = prePunc+1;
    seq.add( SymbolCategory.PREPUNC );
    return;
   } else {
    System.out.println( "Was not prepunctuation." );
   }
  } //End prepunc logic

        //ALPHABETIC WORD
  if (postPunc == 0){
     PartWordUse used;
     if (!wordStarted){
      used = PartWordUse.BEG_WORD;
     } else {
      used = PartWordUse.MID_WORD; 
      //but what if this is the end, pure mid no good
     }

   // The four midword contractions:   ea  bb  cc   ff
   //represented in ASCII Braille as    1  2    3    6
   //are the same cells as              ,  ;    :    !
   // This complicates finding the end by going forward
   //I used to go backward :)

    if (last) used = PartWordUse.END_WORD;
    boolean isAllowed = conHandler.isContraction( brl, used );

   if (isAllowed){
    System.out.println( "Input can be used in a word." );
    //Indicator stack be embedded since otherwise itt
    //would have been included in the prefix
    //if the word hadn't been started
    if (!pendingInds.empty() ){
     System.out.println( "Oops, word has embedded indicator(s)!" );
     funny = true;
     return;
    }
    //The alphabetic symbol just found is 
    //the first one in the word portion
    if (!wordStarted){
     startPos = pos;
     wordStarted = true;
    }
    wordItem = wordItem+1;
    seq.add( SymbolCategory.ALPHABETIC );
    //The alphabetic symbol just found is 
    //the end of the sequence
    if (last){
     endPos = pos;
     wordEnded = true;
    }
    return;
   } //End "if (isAllowed)"

   System.out.println( "Symbol as not alphabetic." );
  } //End word logic

       // POST-PUNCTUATION
  //Prepunc, indicator, alphabetic already explictly checked!
  //No word portion found 
   if (!wordStarted){
    funny = true;
    return;
   }

   //If one or more word items found, an o.k word ended 
   if (!wordEnded){
    endPos = pos-1;
    wordEnded = true;
    //  Word finished just before this pending indicator 
    // stack identified on previous call(s) to this method
    // so include stack with postfix portion
    if (!pendingInds.empty() ){
     postPunc = postPunc + 1; 
     //pending = (Indicator) null;
     // pop pending!
    }
   }

   boolean isAPostpunc = Punctuation.isPostPunc( brl );
   if (isAPostpunc){
    postPunc = postPunc + 1;
    seq.add( SymbolCategory.POSTPUNC );
    return;
   } 
   funny = true;
   return;
  }

public void analyzeStart( String brl, int pos, boolean first,
      boolean last ){

  System.out.println( "   Analyzing brl: "+brl+" at pos: "+pos );
  Indicator indy = backInd.check4Ind( brl );
  if (indy == null){
    System.out.println( "Not an indicator." );
  } else {
    IndicatorClass ic = indy.myIndData.getMyClassEnum();
    System.out.println( "Input is an indicator--."+ic );
    if (ic == IndicatorClass.NUMERIC_INDICATOR){
     funny = true;
     return;
    }
    ind = ind + 1;
    //Indicator ok as part of prefix (postfix already checked)
    if (wordItem == 0 ){
     seq.add( SymbolCategory.INDICATOR );
     prePunc = prePunc + 1;
     preInds = preInds + 1;
     return;
    } else {
     funny = true;
    }
   return;
  } //End indicator logic

        // PRE-PUNCTUATION
  if (wordItem == 0 ){
   boolean isAPrepunc = Punctuation.isPrePunc( brl );
   if (isAPrepunc){
    prePunc = prePunc+1;
    seq.add( SymbolCategory.PREPUNC );
    return;
   } else {
    System.out.println( "Was not prepunctuation." );
   }
  } //End prepunc logic

        //ALPHABETIC WORD
  
     PartWordUse used;
     if (!wordStarted){
      used = PartWordUse.BEG_WORD;
     } else {
      used = PartWordUse.MID_WORD; 
      //but what if this is the end, pure mid no good
     }

   // The four midword contractions:   ea  bb  cc   ff
   //represented in ASCII Braille as:    1  2    3    6
   //are the same braille cells as:      ,  ;    :    !
   // This complicates finding the end by going forward
   //I used to go backward :)

    if (last) used = PartWordUse.END_WORD;
    boolean isAllowed = conHandler.isContraction( brl, used );
    if (!isAllowed) {
     funny = true;
    }
    System.out.println( "SymbolsSequence--Symbol is not alphabetic." );
    return;
  } //End word logic

//  =======================================
 // Useful for identifying any postfix symbols at the
 //end of a sequence
public boolean isPostfix( String brl ){

 if (Punctuation.isPostPunc( brl )) {
  System.out.println( "Post punc: "+Punctuation.getPostPunc( brl ) );
  return true;
 }
 Indicator indy = backInd.check4Ind( brl );
 if (indy != null){
   return true;
 }
 return false;
}


 public boolean result(){
  return true;
 }

      //  TEST-RIG
public static void main( String [] args ){

 InitTranstables.makeTables( true, true );
 InitializeIndicators. makeIndicators( true,
        false, ",,,," );

 System.out.println( );

 ArrayList<String> theSeq = new ArrayList<String>();
 String input = ",,b";
 theSeq.add( ",," );
 theSeq.add( "b" );
 SymbolsSequence symSeq = new SymbolsSequence();

 symSeq.init();
 boolean ok = symSeq.checkSeq( theSeq );
 System.out.println( "Result: "+ok+" input: "+input );
 System.out.println();


 theSeq.clear();
 input = "x\"d";
 theSeq.add( "x" );
 theSeq.add( "\"d" );
 symSeq.init();
 ok = symSeq.checkSeq( theSeq );
 System.out.println( "Result: "+ok+" input: "+input );
 System.out.println();

 theSeq.clear();
 input = ".<\"oz";
 theSeq.add( ".<" );
 theSeq.add( "\"o" );
 theSeq.add( "z" );
 symSeq.init();
 ok = symSeq.checkSeq( theSeq );
 System.out.println( "Result: "+ok+" input: "+input );
 System.out.println();

 theSeq.clear();
 input = ".<\"fgc";
 theSeq.add( ".<" );
 theSeq.add( "\"f" );
 theSeq.add( "g" );
 theSeq.add( "c" );
 symSeq.init();
 ok = symSeq.checkSeq( theSeq );
System.out.println( "Result: "+ok+" input: "+input );

System.out.println();

 theSeq.clear();
 theSeq.add( ".<" );
 //theSeq.add( "&" );
 theSeq.add( "%" );
 theSeq.add( ";e" );
 theSeq.add( ".>" );
 symSeq.init();
 ok = symSeq.checkSeq( theSeq );
 System.out.println( "Result: "+ok );

System.out.println();

 theSeq.clear();
 theSeq.add( "2" );
 theSeq.add( "v" );
 theSeq.add( "e" );
 theSeq.add( "x" );
 symSeq.init();
 ok = symSeq.checkSeq( theSeq );
 System.out.println( "Result: "+ok );

}

}//End Class.