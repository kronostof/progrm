package org;



import java.util.EventListener;

import org.myapp.event.Position;



public interface ModelListener extends EventListener {
	public void Changed( );

	public Position getPosition();
	
	
}
