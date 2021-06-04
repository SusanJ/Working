package org.dotlessbraille.transtables;
import java.util.HashMap;
public class UpperNumber{

 /**Numeric mode allowed symbols per UEB Manual 6.2
 [comma is dot2, full_stop is dots256, simple fracline is dots34]
  num_mode_symbols: 
 (upper_num|comma|full_stop|simple_fracline|num_space_digit);
num_item: ni (num_mode_symbols)*(numeric_line_cont_ind)?;
*/

  public static HashMap<String,String>  upperNumBtTable =
     new HashMap<String,String> ();

  public static HashMap<String,String>  specialFracTable =
     new HashMap<String,String> ();


 static boolean makeUpperNumBtTable( boolean report, boolean display){
     upperNumBtTable.put( "#", "" );   //Consistent with Parser Grammar
     upperNumBtTable.put( "#a", "1" );
     upperNumBtTable.put( "#b", "2" );
     upperNumBtTable.put( "#c", "3" );
     upperNumBtTable.put( "#d", "4" );
     upperNumBtTable.put( "#e", "5" );
     upperNumBtTable.put( "#f", "6" );
     upperNumBtTable.put( "#g", "7" );
     upperNumBtTable.put( "#h", "8" );
     upperNumBtTable.put( "#i", "9" );
     upperNumBtTable.put( "#j", "0" );
     upperNumBtTable.put( "#1", "," );
     upperNumBtTable.put( "#4", "." );
     upperNumBtTable.put( "a", "1" );
     upperNumBtTable.put( "b", "2" );
     upperNumBtTable.put( "c", "3" );
     upperNumBtTable.put( "d", "4" );
     upperNumBtTable.put( "e", "5" );
     upperNumBtTable.put( "f", "6" );
     upperNumBtTable.put( "g", "7" );
     upperNumBtTable.put( "h", "8" );
     upperNumBtTable.put( "i", "9" );
     upperNumBtTable.put( "j", "0" );
     upperNumBtTable.put( "1", "," );
     upperNumBtTable.put( "4", "." );
     upperNumBtTable.put( "/", "/" );
     upperNumBtTable.put( "\"a", " 1" );
     upperNumBtTable.put( "\"b", " 2" );
     upperNumBtTable.put( "\"c", " 3" );
     upperNumBtTable.put( "\"d", " 4" );
     upperNumBtTable.put( "\"e", " 5" );
     upperNumBtTable.put( "\"f", " 6" );
     upperNumBtTable.put( "\"g", " 7" );
     upperNumBtTable.put( "\"h", " 8" );
     upperNumBtTable.put( "\"i", " 9" );
     upperNumBtTable.put( "\"j", " 0" );

     specialFracTable.put( "#c/h", "&#x215C;" ); //Vulgar 3/8
     specialFracTable.put( "#a/b", "&#x00BD;" ); //Vulgar 1/2

     if (report)
      System.out.println( "   Upper number backtrans table complete." );
     return true;
    }

public static String backTrans( String brl ){
  String ink;
  if (brl.length() == 4){
    ink = getVFrac( brl );
    if (ink != null) return ink;
  }
  StringBuffer buf = new StringBuffer();
  
  int i0 = 0;
  if (brl.startsWith( "#")) i0=1;
  for (int i=i0;i<brl.length();i++){
   ink = upperNumBtTable.get( brl.substring(i,i+1 ));
   System.out.println( brl.substring(i,i+1)+"  "+ink );
   buf.append(ink);
  }
  return buf.toString();
}
static String getInk( String brl){
 
  return upperNumBtTable.get( brl );
}
static String getVFrac( String brl ){
  //System.out.println( "UpNum--getVFrac table size: "+
  // specialFracTable.size()+" brl: "+brl );
  return specialFracTable.get( brl );
}

}//End Class UpperNumber.