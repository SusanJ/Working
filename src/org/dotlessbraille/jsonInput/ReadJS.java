package org.dotlessbraille.jsonInput;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ReadJS {
 
    @SuppressWarnings("unchecked")

ReadJS(){}

  public static void readInput( String fileName ){
       
       
       //FileReader inFile = (FileReader) null;

      JSONParser jsonParser = new JSONParser();

       try ( FileReader infile = new FileReader( fileName )){

         // JSONParser jsonParser = new JSONParser();
       Object obj = jsonParser.parse( infile );
       JSONArray ruleList = (JSONArray) obj;
       Iterator<JSONObject> iterator = ruleList.iterator();
       while (iterator.hasNext()) {
        parserRuleObject( iterator.next() );
       }//End while

       } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
       } catch (IOException e) {
            e.printStackTrace();
            return;
       } catch (ParseException e) {
            e.printStackTrace();
       }

       //Object obj = jsonParser.parse( infile );
       //JSONArray ruleList = (JSONArray) obj;
       //Read JSON file
     
       return;
  }

public static void main(String[] args ){
 readInput( args[0] );
}

    public static void oldmain( String[] args ) {

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader( args[0] ))
        {
         
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray ruleList = (JSONArray) obj;
            //System.out.println(ruleList);
             
            //Iterate over rule array

  Iterator<JSONObject> iterator = ruleList.iterator();
  while (iterator.hasNext()) {

     // System.out.println(iterator.next());
      parserRuleObject( iterator.next() );

  }//End while
  //ruleList.forEach( rule -> parseRuleObject( (JSONObject) rule ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
   
}
 

 private static void parserRuleObject(JSONObject rule) 
    {
        //Get the next rule object within list
        JSONObject ruleObject = 
          (JSONObject) rule.get("rule");
         
        //Get braille
        String brl = 
          (String) ruleObject.get ("ASCII_Braille");    
        //System.out.println( brl );
         
        //Get print backtranslation
        String ink = 
         (String) ruleObject.get("Unicode_print");  
        //System.out.println( ink );
         
        //Get information
        String info = (String) ruleObject.get("Name");    
        //System.out.println( info );

        ModifiedLetter modlet = new ModifiedLetter( brl, ink, info );

    }
   
}