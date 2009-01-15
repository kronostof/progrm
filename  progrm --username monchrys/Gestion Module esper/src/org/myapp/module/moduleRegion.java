package org.myapp.module;


import java.util.Map;

import org.myapp.event.Bbool;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleRegion extends module<FluxPosition ,FluxBool> implements UpdateListener{

	
	
    EPServiceProvider epService;
    
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
		this.fluxEntrant = fluxEntrant;
        this.fluxSortant = fluxSortant;
        expression =  new String("select posX from org.myapp.module.moduleRegion where posX<850 and posX>50 and posY<850 and posY>50");
	}


	/**
	 *  Cette methode est reçut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {

		fluxSortant.set(true);
		if (fluxEntrant.getPosX()>500) System.out.println(nom + " " + fluxSortant.data.getValue());
		//System.out.println(" module Region " +nom +" => "+fluxEntrant.data.toString() + " =>" + fluxSortant.data.toString());
		
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
		
	}
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
	    		sleep(2000);
	    	}
	    	catch (InterruptedException e) { e.printStackTrace();	}
			}
	}

	public float getPosX() {        return fluxEntrant.getPosX();    }
    public float getPosY() {        return fluxEntrant.getPosY();    }
    

	@Override
	public int setup(Map<String, Object> conf) {
		expression =  new String((String)conf.get("expression"));
		return 0;
	}
}
