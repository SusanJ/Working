parser grammar uebMathParser;
options { tokenVocab = uebMathLexer; }
tokens {LATIN_LETTER, FUN_NAME, SHORTFORM,
  SFA,  SFC}
@parser::header{ package org.dotlessbraille.antlr4; }
@parser::members{ boolean line_cont = false;
                  boolean numericMode = false;
                  boolean specialG1Mode = false;
                  boolean g1Wrd = false;
                  boolean g1Passage = false;
                  boolean g1WrdOrPassage = false;
                  boolean numPassage = false; 
                 }

/** I've chose to use a mix of solutions to dealing with the various modes.
    The lexer and parser rules provide the information to the translator
    that the text is in numeric mode and also uses special symbols
    when in that mode so the translator knows directly how to translate;

    However for the other modes rules sent to the translator are ones that indicates
    explicit starting and ending of modes but not necessary implicit
    ending.
    This means the translator needs to manage mode states. The UEB backtranslator
    of which this is an extension handled all the mode states except
    for numeric passage but this update  includes a more sophisticated approach
    to numeric mode because of its importance in math.
*/

text: (line)+;
//uebMode: uebDefaultMode otherMode;

//uebDefaultMode: STARTING_MODE (nline)+; 
//otherMode:      (nline)+;

lineStart:  ((space|indent)*lowAlone)
            |
            ((separator|g1WrdOrPssg)*  
             (simpleWord|word|standingAlone|item)
            ) 
            ;
lineMiddle: ((space|indent)+lowAlone)
            |
            ((separator)+ (g1WrdOrPssg)*
             (simpleWord|word|standingAlone|item )
            )
            ;
lineEnd:    ((separator)+ (g1WrdOrPssg)*
             (simpleWord|word|standingAlone|item )
             trailingSep*
            )|
            ((space|indent)* lowAlone (space|indent)*)
            ;

lineDone:   (space)* newline; 

line:  (space|indent)* newline
       |lineStart lineDone
       |lineStart lineEnd lineDone
       |lineStart lineMiddle+ lineEnd lineDone
       ;



strong_ws: STRONG_WS;

digits: (START_NUMERIC_MODE|NDIG_SEQ|{numPassage}?DIGITS)+;

lowsigncon: (LOWCON|SPLOW);
lowAlone: preNoQuotes* lowsigncon  postOk*;

standingAlone: 
  (preAlone)*
  ( (CapsPassageInd|CapsWordInd)? standAloneCon )
  (postAlone)*
  ;
   
  // final-letter contractions
flc: {!g1WrdOrPassage}?( FLC46 | FLC56 );
  // initial-letter contractions
ilc: {!g1WrdOrPassage}?( ILC5 | ILC45 | ILC456 );
  //strong groupsigns: ch gh sh th wh ed er ou ow st ing ar 
strong_gs:  {!g1WrdOrPassage}?STRONG_GS;
 
largeSign: {!g1WrdOrPassage}? (AND_ROOT|FOR_ROOT
           |OF_ROOT|THE_ROOT|WITH_ROOT); 

//When the same braille string in more than one lexe mode ns 
//the tokens have different names as here.

newline:   NEWLINE|END_NM_with_WINNL;       //OTHERS??
space:    (END_NM_with_SPACE|NPSPACE|SPACE){g1Wrd = false;};  //GET ALL!!
indent:   INDENT;
separator:  (space|hyphen|dash|long_dash|indent);
trailingSep: separator+;

thismode: STARTING_MODE;
startMode: thismode;
endMode: g1TERM|endNumPassage;

binop: BINOP;
/

//Simple fraction done in Numeric Mode and Numeric Passage

numIndicator: START_NUMERIC_MODE {numericMode=true;};
simpleFraction: (numIndicator  digits*
                 NUM_SIMPLE_FRAC_LINE 
                 digits+
                );

//            +++ frac+++
frac: (fracStart
      //(saLetters
      //|justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //|digits|DOTS56? ROOT)+
      (simpleFraction|expr2+)
      fracLine 
      //(justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //(saLetters|digits|DOTS56? ROOT)+
       (simpleFraction|expr2+)
      fracEnd
      )
      |simpleFraction
      ;

item: 
      (
      numericPassage
      |endNumPassage
      |digits
      |startMode
      //|simpleFraction
      |frac
      |cfrac
      |comp
      //|angleBracket
      // |LETTERS_NOT_DIGITS
      |expr2
      |supExpr
      |subExpr
      |subsupExpr
      |LETTER_NOT_DIGIT 
      |flcERROR
      );

 //@< braille is both left angle bracket and less than


angleBracket: (LEFTangleOrLT|RIGHTangleOrGT)+;
compSymbols: SPACED_SYMBOLS|COMP_SYMBOLS|angleBracket;

comp: expr2 compSymbols expr2;  // '=' '<' '>'

tcAlphaSeq: CapitalLetter ALPHA_SEQ;
alphaSeq: ALPHA_SEQ;
comma: DOT2|COMMA_ROOT;
simpleWord: DOT6?(ilc|largeSign|tcAlphaSeq|alphaSeq|SPLOW)APOS_END?
            (comma|postAlone)?;
ff: DOTS235;
 //Words consisting of two or more tokens, will usuallyhave contractions
word: (      wordStart
             wordMiddle*
             wordEnding
      )(comma|postAlone)?
      ;

wordStart: (DOT6? (tcAlphaSeq|alphaSeq|shortForms|singleLetter
             |LETTERS_NOT_DIGITS|strong_ws|ROOT|UPDIGS
             |SLASH_ROOT|ilc|largeSign|strong_gs|lowsigncon
             ));
wordMiddle:  (alphaSeq|shortForms|singleLetter|ff
             |LETTERS_NOT_DIGITS|strong_ws|ROOT|UPDIGS
             |SLASH_ROOT|flc|ilc|largeSign|strong_gs|lowsigncon
             );
wordEnding: (alphaSeq|shortForms|singleLetter
             |LETTERS_NOT_DIGITS|strong_ws|ROOT|UPDIGS
             |SLASH_ROOT|flc|ilc|largeSign|strong_gs
             )APOS_END?;
flcERROR: DOT6? flc wordEnding*;
//All possible expressions that don't include layout inds.
expr2: //(G1PassageInd{g1Passage = true;g1WrdOrPassage = true;})?
         
         //expr2 SPACED_SYMBOLS expr2  // '=' '<' '>'
         expr2 binop expr2
         |expr2 (expr2)
         //|NDIG_SEQ
         //|START_NUMERIC_MODE 
         |digits
         |comma space?
         |angleBracket
         |(oGroup|OGROUP) expr2 (cGroup|CGROUP)?
         |justALetter
         |singleLetter
         |word
         |PR_TOKEN
         |g1MathRoots
         
         //|oGroup expr2 cGroup
         |oGroup|OGROUP
         |cGroup|CGROUP
         |DOTS56? ROOT
         |brlogrp expr2 brlcgrp
         |brlogrp
         |brlcgrp
         ;




oGroup: {g1WrdOrPassage}? OGROUP;  // ( [ {
cGroup: {g1WrdOrPassage}? CGROUP;  // ) ] }
g1MathRoots: {g1WrdOrPassage}?DOTS235;
//lowcon: SPLOW;

fracStart: OForFRACS|OF_ROOT|MLFRACS;
fracEnd:   END_NM_with_G1? (WITHorFRCE|WITH_ROOT)
          |MLFRACE|NM_FRACE|END_NM_with_FRACE;

fracLine:  MLFRACIL|NMFRACIL;
//Need a root without a slash!!!

//digits: NDIG_SEQ| START_NUMERIC_MODE | DIGITS;

mLsub: (MLSUB
       |{g1WrdOrPassage}?DOTS35
       )
       ;
/**
mLsup: (MLSUP
       |{g1WrdOrPassage}?DOTS26
       )
       ;
*/
mLsup: MLSUP;

brlogrp: (MLROWS
         |{g1WrdOrPassage}?DOTS126
         )
         ;

brlcgrp: (MLROWE
         |{g1WrdOrPassage}?DOTS345
         )
         ;

//???Frac might have a sub in it?
//also subsup?

supExpr: supExpr mLsup supExpr
         |expr2
         //|brlogrp? frac brlcgrp?
         |supExpr supExpr
         |brlogrp? fracStart
            (expr2|supExpr)+
          fracLine 
            (expr2|supExpr)+
          fracEnd brlcgrp?
          ;

subsupExpr: subExpr mLsup expr2
            subsupExpr mLsup expr2
            //|supExpr (mLsub|mLsup) subExpr
            //|subExpr
            //|supExpr
            //|expr2
            ;

subExpr: subExpr mLsub subExpr
         |expr2
         //|brlogrp? frac brlcgrp?
         |subExpr subExpr
         |brlogrp? fracStart
            (expr2|subExpr)+
          fracLine 
            (expr2|subExpr)+
          fracEnd brlcgrp?
         ;




        
/**
frac: fracStart
      //(saLetters
      //|justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //|digits|DOTS56? ROOT)+
      expr2+
      simpleFraction
      fracLine 
      //(justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //(saLetters|digits|DOTS56? ROOT)+
      expr2+
      fracEnd;
*/
cfrac: fracStart
      //(saLetters
      //|justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //|digits|DOTS56? ROOT)+
      (expr2|frac)+
      fracLine 
      //(justALetter|word|PR_TOKEN|binop|spacedSymbol|digits
      //(saLetters|digits|DOTS56? ROOT)+
      (expr2|frac)+
     fracEnd;


numModeItem: START_NUMERIC_MODE numModeContent;
numModeContent: ( NUM_SPACE_DIGIT //has newline
                | NDIG_SEQ             
                | NUM_SIMPLE_FRAC_LINE
                | NUM_CONT_NUM_SPACE
                | NUM_CONT
                );
     
g1WrdOrPssg: (G1PassageInd 
             {g1Passage = true;
              System.out.println("G1Passage");}
             |G1WordInd {g1Wrd = true;
              System.out.println("G1Word");}
             )
             {g1WrdOrPassage = true;}
             ;

g1TERM: (G1TermInd|END_NM_with_G1TERM) {g1WrdOrPassage = false;};




numericPassage: START_NUMERIC_PASSAGE {numPassage = true;
                                       g1Passage = true;};
                
//CONTENT????
 
endNumPassage:  EXIT_NUMERIC_PASSAGE {numPassage = false;
                                      g1Passage = false;};

//Simple fraction done in Numeric Mode and Numeric Passage
/**simpleFraction: (START_NUMERIC_MODE NUM_SIMPLE_FRAC_LINE NDIG_SEQ
                |DIGITS SIMPLE_FRACTION_LINE DIGITS
                );
*/                

//space:  SPACE;
hyphen: DOTS36 | END_NM_with_HYPHEN;
dash:   DOT6 DOTS36 | END_NM_with_DASH;
long_dash: DOT5 DOT6 DOTS36;



//==================================
//   Standing Alone Items
//==================================

 //Strong wordsigns: 
 //  child   shall  this  which  out   still 


 //Shortforms (BESF omitted because of ambiguities)       
shortForms:   (CHSF|SHSF|STSF|OURSELVES|
               THSF|ERSF|ONESELF|THMSLVS|CONCV|SHORTFORM|
               SFA|SFB|SFC|SFCC);

justALetter: ({g1WrdOrPassage}?                
               DOT6?
              (LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK)
             )| 
              DOTS56 DOT6?
             (LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK)
             ;
  //Grade 1, not whole word con

//All 26 lc letters (Some separate for practice.)
singleLetter: {!g1WrdOrPassage}? 
              ((DOT6?(LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK))
              |ucLetters|MODIF
              )
              ;
//letters: (LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK);
//digits: DIGITS;

  //Title-case only, embedded cap would violate "standing alone" criteria
ucLetters: CapitalLetter;

//singleLetter: (letters|ucLetters);
//saLetters: (letters|ucLetters)(letters|ucLetters)+; //two or more letters
saLetters: DOT6?(LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK)
          (LETTERA|LETTERB|UPDIGS|MOST_LETTERS|LETTERK)+;

//NEED TO ADDRESS THIS SOMEWHERE
//okAfterStrongWs: APOS('d'|'ll'|'re'|'s'|'t'|'ve')
//okAfter: DOT3(DOTS145|DOTS123 DOT2123|DOTS1235 DOTS21
          //|DOTS234|DOTS2345|DOTS123521);

/** This  parser rule identifies where contractions that can 
represent whole words do so per the "Standing Alone" context
N.B. Normally special contraction symbols wouldn't be used
in a grade 1 context but single letters are used 
in math and may be easier to handle here than during translation
Need to add lowcon but they have different pre/post rules
 Note that angle brackets prevent standing alone: thus in
  <x, y> the letters are NOT standing alone
"However, the lower wordsign 
is not used when in contact with any punctuation sign, including the 
hyphen and dash, that has only lower dots. For the purposes of this 
rule, any type of quotation mark which may be present is considered 
to have only lower dots."
(This I think means that if the lower sign is surrounded by fences
it could be next to one of the forbidden items? FIX???)
*/

standAloneCon: {!g1WrdOrPassage}?
           (DOT6?(strong_ws //(okAfter)?   Strong wordsigns
                  //|justALetter //lc  or uc letters with g1SymbolInd OMIT A.I.O?
                  |saLetters   //lc or TC letter sequence 
                  |shortForms
                  |{!g1WrdOrPassage}? singleLetter
                  ));

 // preNoQuotes: (DOT5|DOTS46|DOTS456)DOTS126;//(  [  {
 preNoQuotes: OGROUP+;
  preLow:   ( ((DOTS456|DOTS45|DOT6)?DOTS236)|
              (DOT5 DOTS2356|DOT3)
            )? preNoQuotes;
          
  preAlone: ( (preNoQuotes)|                    // (  [  {
              ((DOTS456|DOTS45|DOT6)?DOTS236)| // opening quotes
              (DOT5 DOTS2356|DOT3)|            // non-dir quotes or apos 
               CapsPassageInd
              //tfStartIndicator
            );  

  postOk: (DOT5|DOTS46|DOTS456)DOTS345;
  //postLow
 
  postAlone: ( (comma|DOTS23|DOTS25|DOTS256(DOTS256 DOTS256)*|
                DOTS235|DOTS236)|                 // , ; : . ... ! ?
               (CGROUP)+ |               // ) ] ]
               ((DOTS456|DOTS45|DOT6)? DOTS356)|  // closing quotes
               (DOT5 DOTS2356|DOT3)             //non-dir quotes or apos 
              // tfTermIndicator
             ); 

oops: MISC;



