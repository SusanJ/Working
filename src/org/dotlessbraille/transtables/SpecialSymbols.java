package org.dotlessbraille.transtables;
import java.util.HashMap;
public class SpecialSymbols{

  public static HashMap<String,String> special = 
    new HashMap<String,String>();
 

public static void makeSpecial( boolean report, boolean display ){

//Table has braille keys and print values

 special.put( "@a",   "@" );       //at sign
 special.put( "@c",   "&x00a2;" ); //cent
 special.put( "@e",   "&x20ac;" ); //euro
 special.put( "@f",   "&x20a3;" ); //franc  (FIX!)
 special.put( "@l",   "&x00a3;" ); //pound sterling
 special.put( "@s",   "$" );       //dollar
 special.put( "@y",   "&x00a5;" ); //yen (Japan}  FIX
 special.put( "@n",   "&x20a6;" ); //naira (Nigeria)
 special.put( "^0",   "&x00b0;" ); //degree
 special.put( "^7",   "prime" );   //foot/minute (prime sign)
 special.put( "^77",  "prime" );   //inch/second (double prime)
 special.put( ",^na", "Angstrom" ); //angstrom
 special.put( "@<", "<" ); //Braille-only open 
 special.put( "@>", ">" ); //Braille-only close 
 special.put( "@9", "~" ); 
 special.put( "@?", "TDS3" ); 
 special.put( ".=", "DLOC" );
 special.put( ".0", "%"    ); //percent
 special.put( ".#?", "TDS7" );
 special.put( "\"6", "+" );  //plus 
 special.put( " \"7 ", "=" );  //spaced equals 
 special.put( "\"7", "=" );    //equals 
 special.put( "\"-",   "-" ); // minus (bt print uses hyphen)
 special.put( "_/", "/" );    // slash (frac. line horiz. frac)
 special.put( "<", "" ); //Braille-only open grouping 
 special.put( ">", "" ); //Braille-only close grouping 
 special.put( "6", "!"); //factorial (grade 1 only)
 //Rand (South Africa) is a normal capital R
 //special.put( "@n", "&" );

 if (report)
  System.out.println( "   Translation table for "+
    "special symbols complete." );
}
public static void putFB(){
}
public static String getSpecial( String brl ){
 return special.get( brl );
}

}//End Class SpecialSymbols.