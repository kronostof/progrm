package org.myapp.module;

import org.myapp.event.Information;
import org.myapp.module.Flux;


public class FluxMODEL extends Flux<Information> {

	
	public FluxMODEL(){
		//data = new Information();
	}

	/** setter 
	 * c est principalement par cette methode que le flux sera modifi�
	 * @param info : l'information represante ce que l'on veut inserer dans le flux sous forme d'un element du m�me type que MODEL<br>
	 * la pertinance de l information est trait�e ici.<br>
	 * � si elle y est deja on fait �a ...<br>
	 * � si elle est moins recente...<br>
	 * � si elle est pr�c�d� de �a alors ...  autrement...<br>
	 */
	@Override
	public void set(Information info) {
		// TODO Auto-generated method stub
		
	}
}