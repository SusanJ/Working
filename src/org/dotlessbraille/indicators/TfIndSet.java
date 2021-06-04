package org.dotlessbraille.indicators;
import java.util.ArrayList;

/** An object of this class is the set of four typeform 
    indicators (symbol, word, passage, and terminator)
    for a particular typeform.
*/
class TfIndSet{

 String name;
 ArrayList <TypeformIndicator> mySet = 
  new ArrayList<TypeformIndicator>();
 IndicatorType indType;

 TypeformIndicator pendingStart = null;
 
TfIndSet( String name,
          ArrayList<TypeformIndicator> mySet,
          IndicatorType indType ) { 
 this.name = name;
 this.mySet = mySet;
 this.indType = indType;
}

  //Expecting start only!!!
boolean checkInd( TypeformIndicator ind ){
 if (ind.scope != Scope.TERMINATOR){
  if (pendingStart == null){
    pendingStart = ind;
    return true;
  } else {
    System.out.println( "TfIndset.checkInd --TF ind. of type "+
      indType+" already active." );
    System.out.println( "Will ignore braille symbol: "+ind.getBrl() );
    return false;
  }
 } else {
  //Handle terminator ....
  return false;
 }
}
}//End Class TfIndSet.
