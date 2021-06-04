package org.dotlessbraille.indicators;
import java.util.HashMap;

public class TranscriberIndicator extends Indicator{

 static HashMap<String,String> tiTable = 
  new HashMap<String,String>();
 

/** Grammar

    trancriberStartInd: (DOT4 DOTS46 DOTS126);
    transcriberTermInd: (DOT4 DOTS46 DOTS345);

*/

 String ink;
  
TranscriberIndicator( String brl, String name, 
                      Scope scope, String ink ){
 super( brl, name, scope );
 this.ink = ink;
}
public String getInk(){
 return ink;
}
public static String getTrans( String brl ){
 return tiTable.get( brl );
}
public static void makeTI_Table( boolean report, boolean display ){
  String sbrl = "@.<";
  String sInk = "[open tn]";
  TranscriberIndicator tiStart = 
    new TranscriberIndicator( sbrl, sInk, Scope.PASSAGE,
        sInk );
  tiTable.put( sbrl, sInk);

  String tbrl = "@.>";
  String tInk= "[close tn]";
  TranscriberIndicator tiTerm = 
    new TranscriberIndicator( tbrl, "[close tn]", 
        Scope.TERMINATOR, tInk  );
  tiTable.put( tbrl, tInk);
  if (report)
   System.out.println( "   Transcriber indicator table made. ("+
     tiTable.size() +")" );
}
}//Emd Class.