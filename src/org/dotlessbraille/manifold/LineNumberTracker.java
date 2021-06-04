package org.dotlessbraille.manifold;
 //Listens for line information from  
 //treelistener/backtranslator
public interface LineNumberTracker{
  //Receive initial line number
 public void startingFirstLine( int line );
  // Receive notice that processing of next line has begun
  //and return its line number
 public int nextLineStarted();
}