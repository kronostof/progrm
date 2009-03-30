package org.myapp.flux;

import org.myapp.event.Fixation;
import org.myapp.event.Information;
//import org.myapp.event.Position;


public class FluxFixation extends Flux<Fixation> {

	
	public FluxFixation(){
		data = new Fixation();
	}
	


	/** setter 
	 * c est principalement par cette methode que le flux sera modifié
	 * @param info : l'information represante ce que l'on veut inserer dans le flux <br>
	 * la pertinance de l information est traitée ici.<br>
	 *
	 * ¤  si les position de fixation sont differante on les modifie on indique quand on les a modifié
	 */
	
/*	public void set(Position fe) {
		// TODO Auto-generated method stub
		
	}
	*/
	@Override
	public void set(Fixation fe) {
		if(data.setPosition(fe.getPosition())) 
			data.resetTemps();
		data.upDate();
	}
	
	public void set(FluxFixation fe) {
		if(data.setPosition(fe.data.getPosition())) 
			data.resetTemps();
		data.upDate();
	}
	/*
	public void set(FluxPosition fe) {
		if(data.setPosition(fe.data)) 
			data.resetTemps();
		data.upDate();
	}
	
	*/
	public void set(int x,int y) {
		//if(
				data.setPosition(x,y);
		//) 
		data.resetTemps();
		data.upDate();
		
		data.getPosition().resetTemps();
		data.getPosition().upDate();
	}
	
	
    public int getPosX(){
    	return data.getPosX();
    }

    public int getPosY(){
    	return data.getPosY();
    	
    }

	
	@Override
	public void setFromFlux(Flux<? extends Information> flux) {
		//System.out.println(flux.getClass().getSimpleName());
		if((new String(flux.getClass().getSimpleName()).compareTo(new String("FluxFixation"))== 0))
		set(((FluxFixation) flux));
	}

}