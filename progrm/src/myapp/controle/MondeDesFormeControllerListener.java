package myapp.controle;

import java.util.EventListener;

import drawing.shape.FormeListener;


public interface MondeDesFormeControllerListener extends EventListener{

	void addFormeListener(FormeListener formeListener);
		
}
