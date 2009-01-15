package org.myapp.module;

import org.myapp.event.Fixation;
import org.myapp.event.Position;


public class FluxFixation extends Flux<Fixation> {

	
	public FluxFixation(){
		data = new Fixation();
	}
	
	public void set(Position fe) {
		// TODO Auto-generated method stub
		
	}

	/** setter 
	 * c est principalement par cette methode que le flux sera modifi�
	 * @param info : l'information represante ce que l'on veut inserer dans le flux sous forme d'un element du m�me type que MODEL<br>
	 * la pertinance de l information est trait�e ici.<br>
	 *
	 * �  si les position de fixation sont differante on les modifie on indique quand on les a modifi�
	 */
	@Override
	public void set(Fixation fe) {
		if(data.setPosition(fe.getPosition())) 
			data.resetTemps();
		data.upDate();
	}

	public long getTemps() {
		return data.getTemps();
	}


}
