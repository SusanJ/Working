package org.dotlessbraille.transtables;
import java.util.HashMap;
public class Punctuation{

  public static HashMap<String,String> prePunc = 
    new HashMap<String,String>();
  public static HashMap<String,String> postPunc = 
    new HashMap<String,String>();
  public static HashMap<String,String> preEncl = 
    new HashMap<String,String>();
  public static HashMap<String,String> postEncl = 
    new HashMap<String,String>();
  public static HashMap<String,String> prePostPair =
   new HashMap<String,String>();
   


//Actually four: non-specific, directional, italian, and non-directional 
//open_dquote:  (DOTS456|DOTS45)? DOTS236 | DOT6 DOTS2356;
//aposORsquote:  DOT3;
//open_squote:  (DOT6 DOTS236|aposORsquote);
//  ( [ { "
//open_fence: ( (DOT5|DOTS46|DOTS456|DOT4)DOTS126 );I
//misc_start: (hyphen|dash);

public static boolean makePrePuncBTTable( boolean report,
     boolean display ){ 
 
      prePunc.put( "8",  "&dquo;" );  // opening non-specific
      prePunc.put( "_8", "&ldquo;" ); // opening Italian
      prePunc.put( "^8", "&ldquo" );  // opening double
      prePunc.put( ",7",  "\";" );    // non-directional double 
      prePunc.put( "'",  "&squo;" );  // non-directional single; apos
      prePunc.put( ",8", "&lsquo;" ); // opening single

      prePunc.put( ",-", "&mdash;" ); // long dash
      prePunc.put( "-",   "-" );      // hyphen
 
      prePunc.put( "\"<", "(" );      // ( 
      preEncl.put( "\"<", "(" );      // (  
  
      prePunc.put( ".<",  "[" );      // [
      preEncl.put( ".<",  "[" );      // [

      prePunc.put( "_<",  "{" );      // {
      preEncl.put( "_<",  "{" );      // {

      prePunc.put( "@<",  "[" );      // < 

      preEncl.put( "<", "" ); //Braille-only open grouping 

   if (report){
    int cnt = prePunc.size();
    System.out.println( "   Pre-punctuation table complete. ("+cnt+")" );
   } 
    return true;
}

//post_punc:     (DOT2|DOTS23|DOTS25|DOTS256|DOTS235|DOTS236);
//close_fence:   ((DOT5|DOTS46|DOTS456)DOTS345);
//close_dquote:  (DOTS456|DOTS45)?DOTS356 | DOT6 DOTS2356;
//close_squote:  (DOT6 DOTS356|aposORsquote);

 public static void makePostPuncBTTable( boolean report,
  boolean display){ 
      postPunc.put( "1",  ",");
      postPunc.put( "2",  ";");
      postPunc.put( "3",  ":");
      postPunc.put( "4",  ".");
      postPunc.put( "6",  "!");
      postPunc.put( "8",  "?");
      postPunc.put( "0",  "&dquo;" ); //closing non-specific
      postPunc.put( "_0", "&rdquo;" ); //should be close Italian
      postPunc.put( "^0", "&rdquo" );  //closing double
      postPunc.put( ",7", "\"" );   //non-directional double 
      postPunc.put( "'",  "&squo;" ); //non-directional single; apos
      postPunc.put( ",0", "&rsquo;" ); //closing single
      postPunc.put( ",-", "&mdash;" ); //long dash
      postPunc.put( "-",   "-" );      //hyphen

      postPunc.put( "\">", ")" );      //) 
      postEncl.put( "\">", ")" );      //)     
      postPunc.put( ".>",  "]" );      //]
      postEncl.put( ".>",  "]" );      //]
      postPunc.put( "_>",  "}" );      //}
      postEncl.put( "_>",  "}" );      //}
      postPunc.put( "@>",  ">" );      //>

      postEncl.put( ">", "" ); //Braille-only close grouping 

    if (report){
    int cnt = postPunc.size();
    System.out.println( "  Post-punctuation table complete. ("+cnt+")" );
   }  

}
public static void makePrePostPairs( ){
     
      prePostPair.put( "\"<", "\">" );     // ( }   
    
      prePostPair.put( ".<",  ".>" );      // [ ]
      
      prePostPair.put( "_<",  "_>" );      // { }
   
      prePostPair.put( "<", ">" ); //Braille-only grouping 
}
 
public static String getPrePunc( String brl ){
 return prePunc.get( brl );
}
public static boolean isPrePunc( String brl ){
 return prePunc.containsKey( brl );
}
public static boolean isPostPunc( String brl ){
 return postPunc.containsKey( brl );
}
public static String getPostPunc( String brl ){
 return postPunc.get( brl );
}
public static String ifPreGetPost( String brl ){
  return prePostPair.get( brl );
}

public static String getPreEncl( String brl ){
 return prePunc.get( brl );
}
public static boolean isPreEncl( String brl ){
 return preEncl.containsKey( brl );
}
public static String getPostEncl( String brl ){
 return postPunc.get( brl );
}
public static boolean isPostEncl( String brl ){
 return postEncl.containsKey( brl );
}

public static String getAnyPunc( String brl ){
 String tmp = getPrePunc( brl );
 if (tmp != null) return tmp;
 tmp =  getPostPunc( brl );
 if (tmp != null) return tmp;
 return SpecialSymbols.getSpecial( brl );
}
}//End Class Punctuation.