package org.dotlessbraille.indicatoruse;
interface ManageCapIndicators{

   //Inconsistent indicators
  public void warn( String text );
   //Not caps indicator (not needed as should throw cast error)
  public void capHandlerReply( boolean ok );

   //Status setters and getters
  public void setCapWordInd( boolean wordInd);
  public boolean getCapWordInd();
  public void clearCapWordInd();

  public void setCapPassInd( boolean wordInd);
  public boolean getCapPassInd();
  public void clearCapPassInd();

 
  //public void handleLetterTransInfo( boolean ok);
}//End Interface.
