package org.dotlessbraille.listeners;
//Example of class that really needs to know.
class Tester2{
 static UEBMode latest;
 String name;
 Tester2( String name ){ this.name = name;}
 void setTransMode( UEBMode aMode ){
  latest = aMode;
  System.out.println( name+ " just heard --> "+latest );
 }
}