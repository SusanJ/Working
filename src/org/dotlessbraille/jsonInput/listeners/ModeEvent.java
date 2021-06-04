package org.dotlessbraille.listeners;
interface ModeEvent{
 public void modeChange( UEBMode latest );
 public void addModeListener( String name,
                ModeListener listener );
}  