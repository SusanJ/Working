package org.dotlessbraille.indicatoruse;
 //Broadcasts information about changes in
 //capitalization mode that it has received
interface CapsEvent{
 public void CapStatusChange( CapsInd latest );
 public void addCapsListener( String name,
                CapsListener listener );
}  