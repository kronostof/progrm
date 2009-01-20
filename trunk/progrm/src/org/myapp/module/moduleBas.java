
package org.myapp.module;

import java.util.HashMap;

import org.myapp.event.Bbool;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleBas  extends module<FluxPosition ,FluxBool > implements UpdateListener{

	
    EPServiceProvider epService;
	/**
	 * Indique si l'utilisateur regarde en bas !
	 * 
	 * @param string
	 * @param i
	 * @param fluxe
	 * @param fluxs
	 */
	public moduleBas(String string, int i, FluxPosition fluxe, FluxBool fluxs) {


		fluxEntrant = fluxe;
        fluxSortant = fluxs;
        
        expression =  new String("select posY from org.myapp.module.moduleBas "+
        						" where posY>500");
    }

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
	        this.fluxSortant.set(new Bbool());
	        System.out.println("\t module Bas => "+ fluxSortant.data.toString() );
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
		
	}

	public void run(){
		while(true){
	    	try {
	    		if (fluxEntrant.isFresh(40))
	    		epService.getEPRuntime().sendEvent(this);
	    		sleep(20);
	    	} catch (InterruptedException e) { e.printStackTrace();	}
		}
	}


	 public float getPosX() {
	        return fluxEntrant.data.getPosX();
    }
    
    public float getPosY() {
    	return fluxEntrant.data.getPosY();
    }

	
	/**
	 * @param borneSup: valeur représantant ce que l on considere 
	 * comme region basse de l'écrant en pourcentage de la surfaces totale. 
	 * 
	 * @return
	 */
	public int setup(int borneSup) {
		expression =  new String("select posY from org.myapp.module.moduleBas"+
								 " where posY>"+borneSup
								);
		return 0;		
	}
	
	

	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		// expression
		// delai
		return 0;
	}
}
