package org.dotlessbraille.utilities;    	                
import java.util.HashMap;
import java.util.ArrayList;
 
class ReadData{
 ArrayList <String> lines = 
   new ArrayList<String>();
 ReadData(){}
 void putLine( String line ){
  lines.add( line );
 }
 int getCnt(){
  return lines.size();
 }
 void Split( String str ){
  StringBuffer buf = new StringBuffer( "  (");
  String[] splited = str.split("\\s+");
  for (int i=0; i<splited.length; i++){
    buf.append( splited[i] );
    buf.append( ", ");
  } 
  System.out.println( buf );
 }
 void fixArray(){
  for (String val: lines){
   Split ( val );
  }
 }

public static void main( String[] args ) throws Exception {
int cnt = 0;
//int i = 0;
//while (i < 5) {
  //System.out.println(i);
  //i++;
//}
String inputFile = null;
if ( args.length > 0 ) inputFile = args[0];
if (inputFile == null){
 System.out.println( "Please input file name!");
 System.exit(0);
}
Tape5 dataIn = new Tape5( inputFile);
ReadData readData= new ReadData();
String inLine=dataIn.in();
 readData.putLine( inLine) ;
 readData.Split( inLine);
System.out.println( "Read: "+inLine );
 while (inLine != null){
  inLine=dataIn.in();
  if(inLine != null) readData.putLine( inLine) ;
}
int count = readData.getCnt();
System.out.println( "Line count: "+count );
readData.fixArray();
}
}
