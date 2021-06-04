package org.dotlessbraille.indicatoruse;
interface Status{

 //Manage information that needs to be passed around.
 //Needs to listen when info appears how???
 void handleLetterTransInfo( boolean ok );

 public void separatorEncountered( boolean isSep);
}//End Interface.

