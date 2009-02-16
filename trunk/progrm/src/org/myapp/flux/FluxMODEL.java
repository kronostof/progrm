package org.myapp.flux;

import org.myapp.event.Information;
import org.myapp.flux.Flux;


public class FluxMODEL extends Flux<Information> {

	
	public FluxMODEL(){
		//data = new Information();
	}

	/** 
	 * c est principalement par cette methode que le flux sera modifié dans un module
	 * @param info : l'information represante ce que l'on veut inserer dans le flux sous forme d'un element du même type que le type d'information présante dans le flux<br>
	 * la pertinance de l information est traitée ici.<br>
	 * ¤ si elle y est deja on fait ça ...<br>
	 * ¤ si elle est moins recente...<br>
	 * ¤ si elle est précédé de ça alors ...  autrement...<br>
	 */
	@Override
	public void set(Information info) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Cette méthode permet 
	 * 
	 */
	@Override
	public void setFromFlux(Flux<? extends Information> flux) {
		// TODO Auto-generated method stub
		
	}
}