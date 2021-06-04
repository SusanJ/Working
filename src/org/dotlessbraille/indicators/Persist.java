package org.dotlessbraille.indicators;
import java.util.ArrayList;
import java.util.HashMap;
import org.dotlessbraille.manifold.KeepTrack2;

 //Maintains knowledge of the braille symbols that do NOT change the 
 //scope of an active indicator

public class Persist{

public static HashMap<String,ArrayList<String>> persistData =
           new HashMap<String,ArrayList<String>> ();

 String name;
 ArrayList<String> perSym = new ArrayList<String>() ;

Persist( String name ){
 this.name = name;
 persistData.put( name, perSym );
}

public boolean allowed( String brl ){
 return perSym.contains( brl );
}

void addSym( String toAdd ){
 perSym.add( toAdd );
}

void addSym( ArrayList<String> toAdd ){
 for (String s : toAdd){
  addSym( s );
 }
}

void display(){
 System.out.println( "Allowed braille symbols for: "+name );
 for (String s : perSym){
  System.out.println( "Persistent symbol: "+s);
 }

}
 
} //End Class Persist
