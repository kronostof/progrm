package org.myapp;

import org.myapp.event.Position;
import org.myapp.flux.FluxPosition;

public class ModelForme extends Thread{

	// la position de la forme a chq instant
	private Position position;
	// le flux d'in formation fourni par le ptsAttention
	private FluxPosition fluxPosition;
	
	
	
	
	public ModelForme(Lecteur lecteur) {
		lecteur.accroche(fluxPosition);
	}
	
	
	/**
	 * gestion des déplacement des formes
	 */
	public void GestionnaireDeplacement(){
		// choissir un angle
		// avancer
		// si on sort du cadre changer d angle
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
}
