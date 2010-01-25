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

public class moduleSuivrePosition   extends module<FluxPosition ,FluxBool> implements UpdateListener{

	private int paramPas = 2;

	Shape shape;
	double distance = 0;
	public moduleSuivrePosition (Shape shape2, int i, Position position,FluxPosition fluxEntrant) {
		super();
		shape =shape2;
		this.setFluxEntrant(fluxEntrant);
		
		paramPas = i;
		
		setFluxSortant(new FluxBool());
		expression =  "select name,distance from org.myapp.module.action.moduleSuivrePosition where distance>100";
		
		init_module();
		start();
	}


	/**
	 *  Cette methode est re�ut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		if (getName().compareTo(newEvents[0].get("name").toString()) == 0){
		//System.out.println("\t module SuivrePosition=> ");
		shape.getPosition().approche(getFluxEntrant().data,paramPas );
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
	    		//if (getFluxEntrant().isFresh(20)) 
	    		epService.getEPRuntime().sendEvent(this);
	    		
	    		try {
	    		sleep(vitesseDeTraitement);
	    		} catch (InterruptedException e) { e.printStackTrace();	}
			}
	}


	public int getposX() {
	        return shape.getPosition().getPosX();
	    }
	

	public double getdistance() {
	        return shape.getPosition().getPoint().distance(getFluxEntrant().get().getPoint());
	    }
	
	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}
/*
	@Override
	public void setFluxEntrant(FluxPosition fluxEntrant) {
		this.fluxEntrant = fluxEntrant;
		
		
	}
	*/
	@Override
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}
	/*
	public void setFluxEntrant(FluxFixation fluxEntrant) {
		this.fluxEntrant = new FluxPosition(fluxEntrant.data.getPosition());
		
	}
	*/
}