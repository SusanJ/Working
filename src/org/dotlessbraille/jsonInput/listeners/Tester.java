package org.dotlessbraille.listeners;
//Example of class that really needs to know.
class Tester{
 static UEBMode latest;
 String name;
 Tester( String name ){ this.name = name;}
 void setTransMode( UEBMode aMode ){
  latest = aMode;
  System.out.println( name+ " just heard the latest mode is: "+latest );
 }
}