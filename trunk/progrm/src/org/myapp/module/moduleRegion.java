package org.myapp.module;


import java.util.HashMap;

import org.myapp.event.Information;
import org.myapp.flux.Flux;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxPosition;

//import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleRegion extends module<FluxPosition ,FluxBool> implements UpdateListener{

	
	
   // CHK UML 28 EPServiceProvider epService;
    
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
	public moduleRegion(String string, int i, FluxPosition fluxEntrant, FluxBool fluxSortant) {

		this.nom = string;
		this.setFluxEntrant(fluxEntrant);
        this.setFluxSortant(fluxSortant);
        expression =  new String("select posX from org.myapp.module.moduleRegion where posX<850 and posX>50 and posY<850 and posY>50");
	}


	/**
	 *  Cette methode est reçut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {

		getFluxSortant().set(true);
		//if (fluxEntrant.getPosX()>500) System.out.println(nom + " " + fluxSortant.data.getValue());
		if(getFluxEntrant().isFresh(20));
		System.out.println(" module Region " +nom +" => "+getFluxEntrant().data.toString() + " =>" + getFluxSortant().data.toString());
	}

	//@Override	public void init(EPServiceProvider nepService) {		this.epService=nepService;			}
	/**
	 * Le coeur du module.
	 * On peut en choisir le rythme
	 *  la ligne "epService.getEPRuntime().sendEvent(this);"
	 *  envoie l'évenement 'Region' au gestionnaire d'évenement
	 *  
	 *  les traitement a effectuer independament de la nature des flux entrant et sortant sont a y placer.
	 */
	public void run(){
		while(true){	    	
			try {
	    		// on verifie la fraicheur de l info
				//System.out.println(fluxEntrant.data.toString());
	    		//if(fluxEntrant.isFresh(20))
	    		epService.getEPRuntime().sendEvent(this);
	    		sleep(200);
	    	}
	    	catch (InterruptedException e) { e.printStackTrace();	}
			}
	}

	public float getPosX() {        return getFluxEntrant().getPosX();    }
    public float getPosY() {        return getFluxEntrant().getPosY();    }
    
/**
 * Cette methode est utilisée afin de modifier l'expression utilisée par ce module par défault l expression designe 
 * le point 0 0
 */
	@Override
	public int setup(HashMap<String, Object> conf) {
		expression =  new String((String)conf.get("expression"));
		return 0;
	}
	
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant){
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}
}
