package org.dotlessbraille.transtables;
//import org.dotlessbraille.jsonInput.ReadJS;
public class InitTranstables{

public static void makeTables( boolean report, boolean display ){

  //ReadJS.readInput( "mod.txt" );

  if (report)
    System.out.println( "\n  TRANSLATION TABLES "+
                        "FOR ORDINARY SYMBOLS" );

  App1Word.makeApp1Table( true, display );
  Separator.makeSeparatorTable( report, display );
  LargeWord.makeLargeWordTable( report, display );
  Letter.makeNAAbrlToPrint( report, false );
  UpperNumber.makeUpperNumBtTable( report, false );
  PartWord.makePartWordTables( true, true );
  //PartWord.makePartWordTables( report, display );
  Punctuation.makePrePuncBTTable( report, false );
  Punctuation.makePostPuncBTTable( report, false );
  Punctuation.makePrePostPairs( );
  SpecialSymbols.makeSpecial( report, true );
  StandingAlone.makePreStandingTable( report, false );
  StandingAlone.makePostStandingTable( report, false );
  Word.makeWholeWordTable( report, false );
  WordOrPartWord.makePartWordTable( report, false);
}
public static void main( String [] args ){
  makeTables( true, false );
}
}//End Class.