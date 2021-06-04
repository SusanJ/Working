package org.dotlessbraille.indicators;
public class IndData{
  //Convienience data for Indicator objects so
  // to avoid subclassing
  Scope myScope;
  IndicatorType myType;
  IndicatorClass myClassEnum;
  String ink;

//          -----
IndData( ){}
IndData( Scope myScope, IndicatorType myType,
         IndicatorClass myClassEnum ){
 this.myScope = myScope;
 this.myType = myType;
 this.myClassEnum = myClassEnum;
}
Scope getMyScope(){
 return myScope;
}
IndicatorType getMyType(){
 return myType;
}
public IndicatorClass getMyClassEnum(){
 return myClassEnum;
}
void putMyScope( Scope myScope){
 this.myScope = myScope;
}
void putMyType( IndicatorType myType){
 this.myType = myType;
}
void putMyClassEnum( IndicatorClass myClassEnum ){
 this.myClassEnum = myClassEnum;
}
}//End Class IndData.