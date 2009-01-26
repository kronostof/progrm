package org.myapp;

import org.asma.cercle;

/**
 * 
 * @author christophe
 *
 */
public class ModelMondeDesFormes {

	Lecteur lecteur;
	/**
	 * creation en dur des formes
	 * toutes liées au lecteur.
	 */
	
	public ModelMondeDesFormes(Lecteur lecteur) {

		this.lecteur = lecteur;
	}
	
	public void inittest(){

		for(int i=0;i<10;i++){
			new ModelForme("nom"+i, lecteur);
		}

	}
	
}
