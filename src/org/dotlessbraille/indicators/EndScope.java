package org.dotlessbraille.indicators;
import java.util.ArrayList;
import java.util.HashMap;

// Manages braille symbols that *do* terminate the scope
//of an active indicator

public class EndScope{

public static HashMap<String,ArrayList<String>> endSymData =
          new HashMap<String,ArrayList<String>> ();

 String name;
 ArrayList<String> endSym = new ArrayList<String>();
 boolean spaceEnds = false;

EndScope( String name ){
 this.name = name;
 endSymData.put( name, endSym );
}
EndScope( String name, boolean spaceEnds ){
 this.name = name;
 this.spaceEnds = spaceEnds;
 endSymData.put( name, endSym );
}
public boolean allowed( String brl ){
 if (endSym.contains( brl )) return false;
 return true;
}
void addSym( String toAdd ){
 endSym.add( toAdd );
}
void addSym( ArrayList<String> toAdd ){
 for (String s : toAdd){
  addSym( s );
 }
}
boolean spaceEncountered(){
 return spaceEnds;
}
boolean done( String s ){
 return endSym.contains( s );
}

void display(){
 for (String s : endSym){
  System.out.println( "Terminating sign: "+s );
 }
}
static ArrayList<String> getTermSigns( String forName ){
 return endSymData.get( forName );
}
 
} //End Class EndScope.
