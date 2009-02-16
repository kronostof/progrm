package org.myapp.controle;

import java.util.EventListener;

import org.FormeListener;


public interface MondeDesFormeControllerListener extends EventListener{

	void addFormeListener(FormeListener formeListener);
		
}
