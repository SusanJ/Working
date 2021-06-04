package org.dotlessbraille.utilities;
import java.io.*;
/**INPUT: Manages input files using Java FileReader
   and BufferedReader per Eitan Gurari. */

public class Tape5 {

/**Java FileReader; see API.*/
   FileReader file;

/**Java BufferedReader; see API.*/
   BufferedReader myIn; 

/**Name of file.*/
   String filename;

/**Last line read in. [Not made use of.]*/
   String line;

//=============================================
/**Creates new input file.

   @param filename  Local name of file including 
                    any extension.
*/
    public Tape5 (String filename){
	try {  
	    file = new FileReader( filename );  
	    myIn = new BufferedReader( file );
	} catch(java.io.IOException e){  
	    System.out.println ("Problem opening "+filename); 
	    System.exit(0);
	}  
    }
/**Reads next line of this file.
   @return Next line or null if end-of-file has
           been reached.
*/
    public String in (){
	try{ 
   
	    line = myIn.readLine();  

	} catch(java.io.IOException e){  
	    System.out.println ("Problem reading" +filename); 
	    System.exit(0);
	}  
	return line; 
    }
/**Closes current file.  This is only necessary
   if one wishes to read the file again.
*/
    public void finish (){
	try{
	    myIn.close(); 

	} catch(java.io.IOException e){  
	    System.out.println ("Problem closing" +filename); 
	}    
        return; 
    }
}//End Class Tape5.