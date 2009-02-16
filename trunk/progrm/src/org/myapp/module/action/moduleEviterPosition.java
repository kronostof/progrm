package org.myapp.module.action;

import java.util.HashMap;

import org.myapp.event.Information;
import org.myapp.event.Position;
import org.myapp.flux.Flux;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxPosition;
import org.myapp.model.Shape;
import org.myapp.module.module;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleEviterPosition   extends module<FluxPosition ,FluxBool> implements UpdateListener,ModuleAction{

    private Position position;
	private int paramPas = -2;


	/**
	 * 
	 * 
	 * Model de module.
	 * 
	 * @param string
	 * @param i
	 * @param fluxEntrant
	 * @param fluxSortant
	 */
	public moduleEviterPosition (Shape shape2, int i, Position position,FluxPosition fluxEntrant) {
		super();
		shape = shape2;
		this.position = position;
		setFluxEntrant(fluxEntrant);
		setFluxSortant(new FluxBool());
        expression =  "select name,posX from org.myapp.module.action.moduleEviterPosition";
        
		init_module();
		start();
	}


	/**
	 *  Cette methode est reçut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (getName().compareTo(newEvents[0].get("name").toString()) == 0){
			position.eloigne(getFluxEntrant().data,paramPas );
			shape.firePositionChangee();
		}
	}

	/**
	 * Le coeur du module.
	 * On peut en choisir le rythme
	 *  la ligne "epService.getEPRuntime().sendEvent(this);"
	 *  envoie l'évenement 'MODEL' au gestionnaire d'évenement
	 *  
	 *  les traitement a effectuer independament de la nature des flux entrant et sortant sont a y placer.
	 */
	public void run(){
		while(true){	    	
	    		//System.out.println(getFluxEntrant().get().toString() + "\t" + position.toString());
	    		if (getFluxEntrant().isFresh(20)) 
	    		epService.getEPRuntime().sendEvent(this);
	    		
	    		try {
	    		sleep(vitesseDeTraitement);
	    		} catch (InterruptedException e) { e.printStackTrace();	}
			}
	}


	public int getposX() {
	        return position.getPosX();
	    }


	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant){
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}

}