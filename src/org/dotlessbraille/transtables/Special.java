package org.dotlessbraille.transtables;
import java.util.ArrayList;
class Special{

 static ArrayList<Special> allSymbols =
      new ArrayList<Special>();

public enum SymCat {CURRENCY, COMP, BINOP, FENCE};


static Special[] symbols = {
 new Special( "@a",   "@" ),       //at sign

 new Special( "@c",   "&x00a2;" ), //cent
 new Special( "@e",   "&x20ac;" ), //euro
 new Special( "@f",   "&x20a3;" ), //franc  (FIX!)
 new Special( "@l",   "&x00a3;" ), //pound sterling
 new Special( "@s",   "$" ),       //dollar
 new Special( "@y",   "&x00a5;" ), //yen (Japan}  FIX
 new Special( "@n",   "&x20a6;" ), //naira (Nigeria)

 new Special( "^0",   "&x00b0;" ), //degree
 new Special( "^7",   "prime" ),   //foot/minute (prime sign)
 new Special( "^77",  "prime" ),   //inch/second (double prime)
 new Special( ",^na", "Angstrom" ),//angstrom
 new Special( "@<", "" ), //Braille-only open 
 new Special( "@>", "" ), //Braille-only close 
 new Special( "@9", "~" ), 
 new Special( "@?", "TDS3" ), 
 new Special( ".=", "DLOC" ),
 new Special( ".0", "%"    ), //percent
 new Special( ".#?", "TDS7" ),
 new Special( "\"6", "+",   SymCat.BINOP ),  //plus 
 new Special( " \"7 ", "=", SymCat.COMP ),  //spaced equals 
 new Special( "\"7", "=",   SymCat.COMP ),    //equals 
 new Special( "\"-",   "-", SymCat.BINOP ), // minus 
 new Special( "_/", "/" ),    // slash (frac. line horiz. frac)
 //new Special( "<", "" ), //Braille-only open grouping 
 //new Special( ">", "" ), //Braille-only close grouping 
 new Special( "6", "!") //factorial (grade 1 only)
};

String brl;
String ink;
SymCat cat;
boolean g1Only = false;

Special( String brl, String ink ){
 this.brl = brl;
 this.ink = ink;
}
Special( String brl, String ink, SymCat cat ){
 this( brl, ink );
 this.cat = cat;

}
}//End Class.



