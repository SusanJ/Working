package org.dotlessbraille.transtables;
import java.util.HashMap;
import org.dotlessbraille.indicators.Scope;
class StandingAlone{

/** In contracted braille a single letter or a shortform letter sequence
    is only read as a contraction if it is standing alone. However this
    default can be escaped by use of a Grade 1 indicator. A single
    letter or letter sequence that is NOT standing alone is NOT read
    as a contraction.

    A letter or letters-sequence is only considered to be standing 
    alone if it is both preceded and followed by a separator.  {A
    separator is either a space, a hyphen or a dash of any length.)

    One or more of a set of certain symbols can optionally intervene between the 
    required preceding separator and the letter or letters-sequence while
    one or more of a second set can optionally intervene between
    the required following separator and the letter or letters-sequence.

    Both sets include indicators as well as ordinaty symbols.
    This Java class supplies hard-wired hash tables for the ordinary
    symbols while indicators are handled elsewhere. ??
    
There are
    methods which report whether or not a user-supplied braille symbol  
    is a key in the user-specified table or .

*/

  public static HashMap<String,String> preAlone = 
    new HashMap<String,String>();
  public static HashMap<String,String> postAlone = 
    new HashMap<String,String>();


//Actually four: non-specific, directional, italian, and non-directional 
//open_dquote:  (DOTS456|DOTS45)? DOTS236 | DOT6 DOTS2356;
//aposORsquote:  DOT3;
//open_squote:  (DOT6 DOTS236|aposORsquote);
//  ( [ { "
//open_fence: ( (DOT5|DOTS46|DOTS456|DOT4)DOTS126 );I
//misc_start: (hyphen|dash);

/** A letter or letters-sequence is ALSO considered to be
 "standing alone" when [one or more of] the following 
common punctuation and indicator symbols intervene between the letter or 
letters-sequence and the <em>preceding</em> space, hyphen or dash:

• opening parenthesis (round bracket), 
opening square bracket or opening curly bracket (brace bracket)
• opening quotation mark of any kind
• nondirectional quotation mark of any kind
• apostrophe [also see Section 2.6.4  A word with an 
      interior apostrophe is considered to be
      "standing alone" if it would otherwise be so considered. For example
      Since (it'll or it'll is standing alone (x'll or x'll needs a 
      lettersign before the x.]
• opening typeform indicator of any kind
• capitals indicator of any kind
• opening transcriber's note indicator
• or any combination of these

  preAlone: ((DOT5|DOTS46|DOTS456)DOTS126)|    // (. [. {
             ((DOTS456|DOTS45|DOT6)?DOTS236)|  // opening quotes
             (DOT5 DOTS2356|DOT3);             //non-dir quotes or apos 
                                                  \
*/

static void makePreStandingTable( boolean report, boolean display ){ 

      preAlone.put( "\"<", "(" );      // (  Opening round parenthesis  
      preAlone.put( ".<",  "[" );      // [  Opening square bracket
      preAlone.put( "_<",  "{" );      // {  Opening curly bracket
      preAlone.put( "8",  "&dquo;" );  // opening non-specific quote
      preAlone.put( "_8", "&ldquo;" ); // opening Italian quote
      preAlone.put( "^8", "&ldquo" );  // opening double quote
      preAlone.put( ",7",  "\";" );    // non-directional double quote
      preAlone.put( "'",  "&squo;" );  // non-directional single quote; apos
      preAlone.put( ",8", "&lsquo;" ); // opening single quote

      //prePunc.put( ",-", "&mdash;" ); // long dash
      //prePunc.put( "-",   "-" );      // hyphen
      //prePunc.put( "@<",  "[" );      // <  

     if ( report )
    System.out.println( "   Standing alone before table complete." ); 
}

 // Checks for allowed symbols in hash table and 
 //also for opening indicators
public static boolean isPreOK( String brl ){
 String ink =  preAlone.get( brl );
 if (ink != null) return true;
 //If not special symbol, check if it is an allowed opening indicator.
 return Scope.indBefore( brl );
}

public static String backPre( String brl ){
 String ink =  preAlone.get( brl );
 return ink;
}
 

/** A letter or letters-sequence is considered to be "standing alone" 
   when [one or more of] the following common punctuation and 
   indicator symbols intervene between the letter or last
   letter of the letters-sequence and the <em>following</em> space, 
   hyphen or das.h

  • comma, semicolon, colon, full stop (period), 
    ellipsis, exclamation mark or question mark
  • closing parenthesis (round bracket), 
    closing square bracket or closing curly bracket (brace bracket)
  • closing quotation mark of any kind
  • nondirectional quotation mark of any kind
  • apostrophe [also see Section 2.6.4]
  • typeform terminator of any kind
  • capitals mode terminator
  • closing transcriber's note indicator
  • or any combination of these.

 postAlone: (DOT2|DOTS23|DOTS25|DOTS256(DOTS256 DOTS256)?|
             DOTS235|DOTS236) // , ; : . ... ! ?
            ((DOT5|DOTS46|DOTS456)DOTS345)|    // ) ] ]
             ((DOTS456|DOTS45|DOT6)?DOTS356)|  // closing quotes
             (DOT5 DOTS2356|DOT3);             //non-dir quotes or apos 

    Seems like an ellipsis is a multi-root symbol like shortforms?
*/



static void makePostStandingTable( boolean report, boolean display){ 

      postAlone.put( "1",  ",");
      postAlone.put( "2",  ";");
      postAlone.put( "3",  ":");
      postAlone.put( "4",  ".");
      postAlone.put( "6",  "!");
      postAlone.put( "8",  "?");
      postAlone.put( "444",  "..."); //Just a string of full stops!
   // Unicode horizontal ellipse, U+2026,  not common? 

      postAlone.put( "\">", ")" );      //)   
      postAlone.put( ".>",  "]" );      //]
      postAlone.put( "_>",  "}" );      //}
      postAlone.put( "0",  "&dquo;" );  //closing non-specific
      postAlone.put( "_0", "&rdquo;" ); //closing Italian
      postAlone.put( "^0", "&rdquo" );  //closing double
      postAlone.put( ",0", "&rsquo;" ); //closing single
      postAlone.put( ",7", "\"" );      //non-directional double 
      postAlone.put( "'",  "&squo;" );  //non-directional single; apos

      //postAlone.put( "@>",  ">" );      //>
      //postAlone.put( ",-", "&mdash;" ); //long dash
      //postAlone.put( "-",   "-" );      //hyphen
       
     if (report)
      System.out.println( "   Standing alone after table complete." );   
}
public static String backPost( String brl ){
 String ink =  postAlone.get( brl );
 return ink;
}

}//End Class StandingAlone.