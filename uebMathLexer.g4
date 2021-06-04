lexer grammar uebMathLexer; 
@lexer::header {package org.dotlessbraille.antlr4;
import org.dotlessbraille.transtables.WordOrPartWord;
 }
channels{ COMMENTS }
@lexer::members{ 

   public static boolean inSpecialG1Mode = false;
   public static boolean inRegularG1Mode = false;
   public static boolean isSFA( String seq ){
    String tmp = seq.toLowerCase();
    if (tmp.equals( "brl" )) return true;
    if (tmp.equals( "grt" )) return true;
    return false;
   }
   public static boolean isSFC( String seq ){
    if (seq.length()!= 2) return false;
    String tmp = seq.toLowerCase();
      //UEB Rule 10.9.3
    if (tmp.equals( "bl" )) return true;
    if (tmp.equals( "fr" )) return true;
    if (tmp.equals( "gd" )) return true;
    if (tmp.equals( "lt" )) return true;
    if (tmp.equals( "ll" )) return true;
    if (tmp.equals( "qk" )) return true;
    //check for:  bl, fr, gd, lt, ll, qk
    return false;
   }
   public static boolean isShortform( String seq ){
     //{System.out.println( "SEQ: "+seq );
     WordOrPartWord.makePartWordTable( true, true);
     return WordOrPartWord.isShortform( seq );
     }
   public  boolean alone(){
    int i = getCharIndex();
    // System.out.println( "i: "+i); or just check +1?
    if (i < 1 ) return false;
    String chk =
     _input.getText(new Interval( getCharIndex()-1, 
                                  getCharIndex()+1) );
     boolean b = (chk.startsWith(" ") && chk.endsWith(" "));
     return b;} 

public boolean okDenom(){
     String chk1 =
     _input.getText(new Interval( getCharIndex()-1, 
                                  getCharIndex()) );
   //if (!chk1.startsWith("/")) return false;
   //return false;  //x
   return true;
 } 
  public boolean okDenom1(){
    String chk1 =
     _input.getText(new Interval( getCharIndex()-1, 
                                  getCharIndex()) );
   System.out.println( "okDenom--chk1: |"+chk1+"|" );
   String ok = "abcdefghijABCDEFGHIJ14";
   if (!chk1.startsWith("/")) return true;
   int pos = ok.indexOf( chk1.substring( 1,2 ));
    System.out.println( "okDenom--pos: |"+pos+"|" );
   return false;  //Std
   //return true;
 }
   public boolean okDenomx(){
    String ok = "abcdefghijABCDEFGHIJ14";
    String chk1 =
     _input.getText(new Interval( getCharIndex()-1, 
                                  getCharIndex()) );
    //String chk1 = _input.getText(getCharIndex()+1);
    System.out.println( "okDenom--chk1: |"+chk1+"|" );
    if (!chk1.startsWith("/")) return true;
    int pos = ok.indexOf( chk1.substring( 1,2 ));
    System.out.println( "okDenom--pos: |"+pos+"|" );
    System.out.println( "okDenom--chk1ss: "+chk1.substring( 1,2 ));
    boolean b = false;
    if (pos > -1) b = true;
    System.out.println( "okDenom start b: "+b);
     //Numeric character  
     
    if (b) return b;

     System.out.println( "okDenom num space check." );
     //Numeric space
    // b = chk1.startsWith( "\"" );
     b = chk1.substring( 1,2 ).equals("\"");
     if (b) return b;
System.out.println( "okDenom returning false." );
     return false;
    /**System.out.println( "okDenom starting check 2." );
    String chk2 =
     _input.getText(new Interval( getCharIndex()-1, 
                                  getCharIndex()+1) );
    System.out.println( "okDenom--chk2: |"+chk2+"|" );
    
    int pos2 = ok.indexOf( chk2.substring( 0,1 ));
    System.out.println( "okDenom--pos2: |"+pos2+"|" );
    b = false;
    if (pos2 > -1) b = true;
    System.out.println( "okDenom last check returns: "+b);
    return b;}
*/
 }}
    

// Lexer partially based on UEB prefix-root structure
// Braille  input uses the North American 
// ASCII Braille transliteration using
// lower case letters /andor upper case letters
// for braille letters

//  Note that one-character lexer tokens  
// represent individual braille cells

//------------------------------------------------------
STARTING_MODE: ('default_mode'|'g2');
START_NUMERIC_MODE: 
   HASH ('4'|'1'|'a'..'j'|'A'..'J') -> mode(NUMERIC) ;
START_NUMERIC_PASSAGE: HASH HASH ASPACE+ 
                       NEWLINE? -> mode( NUMERIC_PASSAGE );

G1PassageInd:   (DOTS56)(DOTS56)(DOTS56);
G1WordInd:      (DOTS56)(DOTS56);

CapsPassageInd: (DOT6)(DOT6)(DOT6);
CapsWordInd:    (DOT6)(DOT6);  
CapitalLetter:  (DOT6)('a'..'z'|'A'..'Z');

// Modifiers to create "accented" letters
MODIF:  ((DOT6? '@'('*'|'3'|'+'|'-')
         |DOT6? '^'('&'|'*'|'%'|'$'
                  |']'|'3'|'/'|'+')
         |DOT6? '^_'('1'|'2'|'-'))
        ('a'..'z'|'A'..'Z'));


//Low words: be, enough, were, his, in, was
//Use unique "standing alone" criteria 

fragment LOWWORD:  DOT6? (LOW_TWO|LOW_FIVE|LOW_SEVEN
                   |LOW_EIGHT|LOW_NINE|LOW_ZERO);

// A low word is standing alone if adjacent to white
//space at both ends, e.g. SPLOW
// A low word is not standing alone if it is not part of
//another word but at least one end is adjacent
//to a hyphen or dash separator (as is allowed for
//other types of words required to be standing alone)
//A low word is not standing alone if either end is adjacent
//to any type of quotation mark or to a punctuation mark
//such as a comma or period that is comprised entirely of
//lower dots (as is allowed for
//other types of words required to be standing alone)

//FIX -- NEED also list that isn't spaced


SPLOW:  //{System.out.println("Alone1:"+alone() );}
         {alone()}? 
          ((DOT6?)(LOW_ONE|LOW_SEVEN|LOW_EIGHT|LOW_ZERO))
        ;

//
LOWCON: LOWWORD 
        //{System.out.println("Alone2:"+alone() );}
        ;

//  10.7 Two-cell initial-letter contractions
ILC5: NDQUO('d'|'D'|'e'|'E'|'f'|'F'|'h'|'k'|'l'|'m'
           |'n'|'o'|'p'|'q'|'r'|'s'|'t'|'u'|'w'|'y'
           |ASTER|QMARK|COLON|BSLASH|EXCLAM
           );         
ILC45: CARET('u'|'U'|'w'|'W'|ASTER|QMARK|COLON|EXCLAM);
ILC456: USCORE('c'|'C'|'h'|'H'|'m'|'M'|'s'|'S'|'w'|'W'|EXCLAM);


 //  10.8 Two-cell final-letter contractions
FLC46: ABPERIOD ('d'|'D'|'e'|'E'|'n'|'N'|'s'|'S'|'t'|'T'|'y'|'Y');
FLC56: SEMICOLON('e'|'E'|'g'|'G'|'l'|'L'|'n'|'N'|'s'|'S'|'t'|'T'|'y'|'Y');

 // 10.2 Strong  wordsigns:  child, shall, this, which, out, still 
STRONG_WS: DOT6?(DOTS16|DOTS146|DOTS1456|DOTS156|DOTS1256|DOTS34);

 // 10.4 Strong groupsigns: [ch sh th wh ou st see 10.2]
 //      gh ed er ow ing ar   CHECK AND FIX
STRONG_GS:  //DOTS16|DOTS146|DOTS1456|DOTS156|DOTS1256|DOTS34
             (DOTS1246|DOTS12456|DOTS246|DOTS126
             |DOTS346|DOTS345);
  
fragment END_LETTER: ('d'|'D'|'s'|'S'|'t'|'T');
fragment END_PAIR: ('ll'|'LL'|'re'|'RE'|'ve'|'VE');
APOS_END: DOT3(END_PAIR|END_LETTER);
APOS_UC_END: DOT3 (CapsWordInd END_PAIR|DOT6 END_LETTER); 



/**
SPLOW:  //{System.out.println("Alone1:"+alone() );}
        {alone()}? LOWWORD ;

LOWCON: LOWWORD {System.out.println("Alone2:"+alone() );};
*/

//Some prefix-root symbols identified specifically for convenience
//  These rules have precedence over generic PR_TOKEN rule since
// they come before it.
//Also done for consistency with abcbraille approach to identify
//layout indicators ASAP

       // Binary operations like plus
BINOP: DOT5(DOTS235|DOTS36|DOTS34|DOTS236);

MLSQRTO: (DOTS56) DOTS146;   //Sqrt open with g2   
MLSQRTC: (DOTS56) DOTS346;   //Sqrt close with g2

OGROUP: ((DOT5|DOTS46|DOTS456)DOTS126);  // ( [ {
CGROUP: ((DOT5|DOTS46|DOTS456)DOTS345);  // ) ] }

fragment GFRACO: (DOTS56) OPAREN;
fragment GFRACC: (DOTS56) CPAREN;

MLFRACS:  GFRACO;           //General fraction open or "of"
MLFRACIL: (DOTS46) DOTS34;  //General fraction slash
MLFRACE:  GFRACC;           //General fraction close or "with"

fragment SUBSCRIPT: (DOTS56) DOTS26;
MLSUB: SUBSCRIPT;
fragment SUPERSCRIPT: (DOTS56) DOTS35;
MLSUP: SUPERSCRIPT;

MLROWS: DOTS56 DOTS126;    //Braille grouping open in g1 or "gh" in g2
MLROWE: DOTS56 DOTS345;    //Braille grouping close in g1 or "ar"

 //MathML </MROW>
fragment SPECIALSYM: GFRACO|GFRACC;

fragment CompareSigns:
                 (DOT5 DOTS2356); //equals
fragment PossibleAngleBracket:
                (DOT4 DOTS126)  //less than or opening angle bracket
                |(DOT4 DOTS345)  //greater than or closing angle bracket
                ; 


SPACED_SYMBOLS: (ASPACE 
                ((DOT5 DOTS2356 
                   {System.out.println( "LA(1)= "+_input.LA(1));}) //equals
                 |(DOT4 DOTS126)  //less than  (not) opening angle bracket
                 |(DOT4 DOTS345)  //greater than (not) closing angle bracket
                ) 
                ASPACE
                );
                
COMP_SYMBOLS: CompareSigns;
LEFTangleOrLT: (DOT4 DOTS126);
RIGHTangleOrGT: (DOT4 DOTS345);

//Remaining prefix-root symbols--this is all possible
//ones not all of which are defined in UEB
//Does not include dots56 or dot6 as possible prefix
//Need to include all specifically-named root symbols
PR_TOKEN: (NOCAPorG1_PREFIX)+(ROOT
                   |COMMA_ROOT|PERIOD_ROOT|SLASH_ROOT
                   |OF_ROOT|WITH_ROOT
                   |('a'..'z''A'..'Z')
                   );
COMMA_ROOT: DOT2;  // also "ea" 
  // These 8 braille cells are prefix cells in UEB; only dots 56 and 
  // dot 6 can be used to form braille symbols without roots
 fragment HASH: '#';
//DOTS3456: HASH;
 fragment ATSIGN: '@';  
DOT4:     ATSIGN;
 fragment NDQUO: '"';
DOT5:     NDQUO;
 fragment CAPS_IND: ',';
DOT6:     CAPS_IND;
 fragment CARET: '^';
DOTS45:   CARET;
 fragment SEMICOLON: ';';
DOTS56:   SEMICOLON;
 fragment ABPERIOD: '.';
DOTS46:   ABPERIOD;
 fragment USCORE: '_';
DOTS456:  USCORE;

fragment
 COL2_PREFIX: (DOT4|DOT5|DOT6
              |DOTS45|DOTS56|DOTS46|DOTS456
              );
fragment
 NOCAPorG1_PREFIX: (HASH|DOT4|DOT5|
                   DOTS45|DOTS46|DOTS456);
fragment
 PREFIX: (HASH|COL2_PREFIX);

 //Lower cells
 fragment LOW_ONE:   '1';
DOT2:     LOW_ONE;
 fragment LOW_TWO:   '2';
DOTS23:   LOW_TWO;
 fragment LOW_THREE: '3';
DOTS25:   LOW_THREE;
 fragment FULL_STOP: '4';
DOTS256:  FULL_STOP;
 fragment LOW_SIX:   '6';
DOTS235:  LOW_SIX;
 fragment LOW_SEVEN: '7';
DOTS2356: LOW_SEVEN;
 fragment LOW_EIGHT: '8';
DOTS236:  LOW_EIGHT;
 fragment LOW_ZERO:  '0';
DOTS356:  LOW_ZERO;
 fragment LOW_FIVE:  '5';
DOTS26:   LOW_FIVE;
 fragment LOW_NINE:  '9';
DOTS35:   LOW_NINE;
 fragment ANY_LOW:  LOW_ONE|LOW_TWO|LOW_THREE|FULL_STOP|LOW_FIVE
                   |LOW_SIX|LOW_SEVEN|LOW_EIGHT|LOW_NINE|LOW_ZERO;
//Forgot these in 2018: be enough were his in was


//Roots that are punctuation and possibly something else
// comma dot2 semicolon dots23 colon dots25
// period dots245 exclamation dots235 question dots235
//Old rule nonspecific open quote 236
//Old rule nonspecific close quote
//Old rule apostrophe

//26+24+5 = 55;  55+8 roots = 63 six-dot cells
 ROOT: (  //26 other represented by "letters"
        DOTS356|  // "was" alone "by"
        DOTS36|   // hyphen                   //2  cells
        DOTS26|   // "en" "enough" msub[g1]
        DOTS35|   // "in" msup[g1]           //2
        DOTS23|   // "be" "bb" semicolon
        DOTS25|   // "con" "cc" colon        //2  
        DOTS235|  // "ff" exclamation
        DOTS236|  // "his" alone old open quote
        DOTS2356| // "gg" "were"[Stmd alone]   //3   
        //FRAC_LINEorST|
       // DOTS126|  // "gh"
       // DOTS345|  // "ar" 
        //DOTS346|  // "ing"
        DOT3|                                //4  apostrophe
        DOTS12456|DOTS246|DOTS1246|          //3
        //AND|   //1
        //FOR|                                //1
        //OForFRACS|
        //THE|  //1
        //WITHorFRCE                    
        //DOTS16|    //"ch"
        //DOTS1456|  //"th"
        DOTS1256|            //3
       // DOTS146|   //"sh"
        DOTS156);              
                               // Total: 23 
//roots separated for numeric mode and/or ambiguities
//COMMA_ROOT: DOT2;  // also "ea" 
PERIOD_ROOT: DOTS256; // also "dis" "dd" grade2
SLASH_ROOT: FRAC_LINEorST;

//  10.3 Strong (or large sign) Contractions
AND_ROOT: AND;
FOR_ROOT: FOR;
OF_ROOT: OForFRACS;
THE_ROOT: THE;
WITH_ROOT:WITHorFRCE;



//Rootless tokens and their terminators
//CapsPassageInd: (DOT6)(DOT6)(DOT6);
//CapsWordInd:    (DOT6)(DOT6);  
CapsTermInd:    (DOT6)(DOT3);


G1SymInd:       (DOTS56);
G1TermInd:      (DOTS56)(DOT3);



    //   Parser puts these 25 shortforms, which are all the ones 
    // that use other contractions, in "standing-alone" context
    // which simpifies backtranslation logic
    //   The ~50 ones only using letters are automatically
    // included with other alphabetic sequences in
    // the "word" rule.  All braille sequences corresponding
    // to alphabetic print words
    // (including those with contractions) are later 
    // checked in the translator to see if they are shortforms
    // or other available pre-translated  // alphabetic words 

/**10.9.3 Use any of the ten shortforms listed below within a longer word that 
is not on the Shortforms List, provided the word is "standing alone" 
(including any affix with an apostrophe) and that any restrictions for 
the shortform are met. 
(a) "braille" or "great": Use the shortform wherever it occurs.
(b) "children": Use the shortform provided that it is not followed by a 
vowel or "y". 
(c) "blind", "first", "friend", "good", "letter", "little" or "quick": Use 
the shortform if it begins the word and is not followed by a vowel 
or "y". 
*/  

 // 8 Shortforms that start with the "be" contraction
 //because, before, behind, below, 
 //beneath, beside, between, beyong
//BESF: LOW_TWO('c'|'C'|'f'|'F'|'h'|'H'|'l'|'L'
             //|'n'|'N'|'s'|'S'|'t'|'T'|'y'|'Y');
 // children, much, such
//CHSF: (ASTER 'n') |( ('m'|'s' )ASTER);
// children
SFB: ASTER ('n'|'N');
//much, such
CHSF:  ('m'|'M'|'s'|'S' )ASTER;
 // should
SHSF: PCENT ('d'|'D');
SFCC: ('f'|'F')FRAC_LINEorST;
 // against, must
STSF: ('a''g'|'A''G')FRAC_LINEorST|
      ('M'|'m')FRAC_LINEorST;
 //ourselves
OURSELVES: BSLASH ('r''v''s'|'R''V''S');
 // although thyself
THSF: ('a''l'|'A''L')QMARK|QMARK( 'y''f'|'Y''F');
 // perhaps perceiving herself
ERSF: (('p' CBRAK)('h'|'c''v''g'))|('h' CBRAK 'f');
 // oneself
ONESELF: DOT5 ('o''f'|'O''F');
 // themselves
THMSLVS: EXCLAM ('m''v''s'|'M''V''S');
 // conceive, conceiving
CONCV: '3''c''v'('g')?;

  //UEB Braille letters
fragment LETA: ('a'|'A');
fragment LETB: ('b'|'B');
fragment UPD: [c-j]|[C-J];
fragment LETK: ('k'|'K');
fragment MOST: [l-zL-Z];

//FIX  test should be "starts with"???
// finding sf as words and a few as partwords
ALPHA_SEQ: (LETA| LETB|UPD|LETK|MOST|END_NM_with_ALPHA)
           (LETA|LETB|UPD|LETK|MOST)+
           { if (isSFA( getText() )){
             setType( uebMathParser.SFA ); 
            } else if (isSFC( getText() )){
               setType( uebMathParser.SFC );
            } else if (isShortform( getText() )){
               setType( uebMathParser.SHORTFORM );
            } 
           };
 
LETTERA: ('a'|'A');
LETTERB: ('b'|'B');
UPDIGS: [c-j]|[C-J];
LETTERK: 'k'|'K';
MOST_LETTERS: [l-zL-Z]|END_NM_with_K2Z;


//TWO MANY DIFFERENT NAMES FOR SAME ITEM???
//LOWER_ROOT: LOW_FIVE|LOW_NINE; //26+10=36; 36+8=44
//Remaining 20 cells (including space)
//Apparently input needs to escape a backslash?

 fragment FRAC_LINEorST:   '/';    //1
DOTS34: FRAC_LINEorST;
 fragment HYPorMINUS:  '-';    //2
DOTS36: HYPorMINUS; 
 fragment LESSTHAN:    '<';    //3
DOTS126: LESSTHAN;
 fragment GREATERTHAN: '>';    //4
DOTS345: GREATERTHAN;
 fragment PLUS_SIGN:   '+';    //5
DOTS346: PLUS_SIGN;
 fragment APOS:        '\'';   //6
DOT3:    APOS; 
// Works!  {System.out.println( "apos? :|"+getText()+"|");})
 fragment PCENT:       '%';    //7
DOTS146: PCENT;
 fragment COLON:       ':';    //8
DOTS156: COLON;

 fragment AMPER:       '&';    //9  dots12346 and
 fragment EQSIGN:      '=';    //10 dots123456 for
 fragment OPAREN:      '(';    //11 dots12356 of
 fragment EXCLAM:      '!';    //12 dots2346 the
 fragment CPAREN:      ')';    //13 dots23456 with
 fragment OBRAK:       '[';    //14 dots246 ow
 fragment CBRAK:       ']';    //15 dots12456 er
 fragment DOLLAR:      '$';    //16 dots1246 ed
 fragment ASTER:       '*';    //17 dots16 ch
 fragment QMARK:       '?';    //18 dots1456 th

//April 2018 This works 
 fragment BSLASH: '\\';    //19 dots1256 ou
 

fragment AND: AMPER;   //dots12346
fragment FOR: EQSIGN;  //dots123456
OForFRACS:   OPAREN;   //dots12356
THE:  EXCLAM;          //dots2346
WITHorFRCE: CPAREN;    //dots23456

DOTS16:   ASTER;
DOTS1456: QMARK;
DOTS1256: BSLASH;

DOTS12456: CBRAK;
DOTS246:   OBRAK;
DOTS1246:  DOLLAR;


 fragment        
  ASPACE: ' ';       //20
INDENT: ASPACE ASPACE ASPACE+;
SPACE: ASPACE;
 fragment
  WINNL: [\r\n]+;
NEWLINE: WINNL;
// Unexpected characters
 MISC:  '\u0020'..'\u007F';

//Comments?
//INK_INFO: '//' .*? '//'-> channel( INK_PRINT );

/**
fragment
  NUMIND: '#'(('a'..'j'|'A'..'J')|PERIOD_ROOT|COMMA_ROOT);

fragment
  NUMNUM: (('a'..'j'|'A'..'J')|DOTS256|DOT2);
fragment
  G1SYM: SEMICOLON;
//All tokens except numeric indicators
//Need to gt 
fragment
  ANY_NONNUM_TOKEN: (PREFIX* ROOTm) | PREFIX+('k'..'z'|'K'..'Z')

    56 ROOTS  29+26 = 55
   27 reg roots
    2 could be numeric 1, 4
   10 row1 letters
   16 other letters

     8 col2 prefixe
     1 hash 

     tokens
       What about other num symbols like continuation?  
       43 non-num roots = 27 reg roots + 16 other letters  ENDS NUMERIC MODE (also space)
       12 pos-num roots = 2 could be and 10 row letters  PERSISTS NUMERIC MODE
       (hash pos-num-roots) = NUMERIC_MODE_START  spaced hash???  but what if in mode???
        hash hash+ pos-num root = MISC2 ends numeric mode??
        hash+ non-num roots = MISC1 TOKENS ends numeric mode
        (hash|col2-prefixes)+ non-num-roots



/

  



       
      

          //UEB NUMWEIC MODE -- 2 Ways

//1. Numeric Passage
     /** The numeric passage indicator sets both numeric mode and
         grade 1 mode for the entire passage. (However numbers which are used
         as problem numbers are distinguished from the numeric content by
         use of  a numeric indicator.)
         In a numeric passage the braille cells for the letters a-j are
         interpreted by default as decimal digits. If these cells are
         intended to represent lowercase letters they must be preceded by a grade 1
         indicator, most likely a symbol or word indicator. (I assume that a
         word indicator would be used if there is a sequence of these letters,
         It seems unlikely for there to be a passage of such letters.)

         The documentation suggests this is typically only used for spatial
         arithmetic but I'm not sure why. 

THERE are two many possibilities to treat this as a general mode.  Perhaps
I could at least do arithmetic?
Perhaps binop
Then an error message??
          
*/
//START_NUMERIC_PASSAGE: DOTS3456 DOTS3456 ASPACE  -> mode( NUMERIC_PASSAGE );
mode NUMERIC_PASSAGE;
  EXIT_NUMERIC_PASSAGE: WINNL ASPACE HASH DOT6 -> mode( DEFAULT_MODE );
   //G1WordInd:      (DOTS56)(DOTS56);
   //G1SymInd:       (DOTS56);
  LETTERS_NOT_DIGITS: (DOTS56)(DOTS56)('a'..'j'|'A'..'J')('a'..'j'|'A'..'J')+;
  LETTER_NOT_DIGIT:   DOTS56('a'..'j'|'A'..'J');
  DIGITS: ('a'..'j'|'A'..'J')+;
  //fences:
  NP_NEWLINE: WINNL;
  NUMERIC_LABEL:  HASH ('a'..'j'|'A'..'J')+ DOTS256?;

  SIMPLE_FRACTION_LINE: FRAC_LINEorST;
  MFRACS:  OPAREN;       //General fraction open
  MFRACIL: DOTS46 FRAC_LINEorST;   //General fraction slash
  MFRACE: CPAREN;       //General fraction close

//parser item (lands|lnd|ds|nl|simplefrac|mfracs|mracil:mfrace|sfl)+comp
// simplefrac: digits sfl digits;
// spaced symbols like equals? they are items
  
  NPSPACE: ASPACE;
  NPNEWLINE: WINNL;
  COMMENT: '//' .*? '//'-> channel( COMMENTS );

  //need to add other possibilities such as contuniuation
  // prefix*root?
  //Prefix+ includes possible caps symbol or caps letter indicator
  //Root should include caps term???
  
  NP_PR_TOKEN_1: (PREFIX)+(ROOT||'4'|'1'|('a'..'z'|'A'..'Z')) -> mode( DEFAULT_MODE );
  NP_ROOT:       (ROOT|('a'..'z'|'A'..'Z')) -> mode( DEFAULT_MODE );
 
  // Unexpected characters
  NP_MISC:  '\u0020'..'\u007F' {System.out.println( "Bad input");
                                 System.exit( 0 ); }
          -> mode( DEFAULT_MODE );

//     2. Regular numeric mode
mode NUMERIC;
 
NUM_SIMPLE_FRAC_LINEx: {!okDenom()}? FRAC_LINEorST 
                       -> mode( DEFAULT_MODE );
 NUM_CONT_NUM_SPACE:   DOT5 DOT5 WINNL;
 NUM_CONT:             DOT5 WINNL;
 NUM_SPACE_DIGIT:      DOT5 ('a'..'j'|'A'..'J');  //test???
 NDIG_SEQ:             ('4'|'1'|('a'..'j'|'A'..'J'))+;
 //NUM_SIMPLE_FRAC_LINEx: {!okDenom()}? FRAC_LINEorST 
                      // -> mode( DEFAULT_MODE );
 NUM_SIMPLE_FRAC_LINE: FRAC_LINEorST;


 //End both numeric mode and special g1 mode FIX G1SYM AND G!TERM
  //NOTE -- mode flags need to be set by parser when tokens encountered FIX!!
 //Since still in special g1 mode
 END_NM_with_FRACE:    WITHorFRCE -> mode( DEFAULT_MODE );
 END_NM_with_G1:       DOTS56  -> mode( DEFAULT_MODE );
 END_NM_with_G1TERM:   DOT6 DOT3 {inSpecialG1Mode = false;} -> mode( DEFAULT_MODE );
 END_NM_with_SPACE:    SPACE  {inSpecialG1Mode = false;} -> mode( DEFAULT_MODE );
 END_NM_with_WINNL:    WINNL  {inSpecialG1Mode = false;} -> mode( DEFAULT_MODE );
 END_NM_with_DASH:     DOT6 DOTS36 {inSpecialG1Mode = false;} -> mode( DEFAULT_MODE );
 END_NM_with_HYPHEN:   DOT3 {inSpecialG1Mode = false;}-> mode( DEFAULT_MODE );
 END_NM_with_ALPHA:    ('k'..'z'|'K'..'Z')
                       ('a'..'z'|'A'..'Z')+ -> mode( DEFAULT_MODE );
 END_NM_with_K2Z:      ('k'..'z'|'K'..'Z') -> mode( DEFAULT_MODE );
 
     //Detailed to simplify checking
//  End numeric mode but not special g1 mod-> mode( DEFAULT_MODE );e
//  These symbols do NOT automatically turn off the 
// the special g1 mode set by numeric mode

NM_FRACE: GFRACC -> mode( DEFAULT_MODE );
NMFRACIL: DOTS46 FRAC_LINEorST -> mode( DEFAULT_MODE );   //General fraction slash
     //Symbols with at least one prefix cell and non-numeric roots
 PR_TOKEN_1: (PREFIX)+(ROOT|('k'..'z'|'K'..'Z')|COMMA_ROOT|WITH_ROOT)
  -> mode( DEFAULT_MODE );
   //Numeric roots with a single prefix that is not the "number sign" OR DOT5!!
 PR_TOKEN_2: (COL2_PREFIX) ('4'|'1'|('a'..'z'|'A'..'Z'))
  -> mode( SPECIAL_G1 );
   //Numeric symbols with multiple prefixes are ordinary symbols
 PR_TOKEN_3: (PREFIX)(PREFIX+) ('a' .. 'j'|'4'|'1') 
  -> mode( SPECIAL_G1 );

     //Root character symbols NOT allowed in numeric mode  FIX
 ROOT_1 : ROOT  ->  mode( DEFAULT_MODE );//SHOULD REMOVE G1TERM and DOT3 ??

// Unexpected characters
 NUM_MISC:  '\u0020'..'\u007F' -> mode( DEFAULT_MODE );
 // also with hyphen or dash

 //  Everything else persists g1 mode (which means more code!)
 //  set Java G1 flag I guess
 //END_with_ktoz:  ('k'..'z'|'K'..'Z')  ->  mode( SPECIAL_G1 );                                                      
 
 //NUM_SEQ: ('4'|'1'|('a'..'z'|'A'..'Z'))+;
//======================================================
mode SPECIAL_G1;
 END_SPECG1_with_G1TERM:   DOT6 DOT3  -> mode( DEFAULT_MODE );

   //-> mode( DEFAULT_MODE);
//mode G1:
 // term
 
//Dummy mode to test syntax for more than one mode.       
mode ANOTHER;
 ANOTHER_SPACE: ASPACE -> popMode;
 CAP_ZED: 'Z'; 
  