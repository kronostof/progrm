
package org.myapp.module;

import org.myapp.event.Bbool;
import org.myapp.event.Position;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleBas  extends module<Position ,Bbool > implements UpdateListener{

	
	
    EPServiceProvider epService;
	//private long lasttemps;
    
    
	
	/**
	 * 
	 * 
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
        expression =  new String("select posY from org.myapp.module.moduleBas.win:time(30 sec) "+
        						" where posY>350");
	}

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		//EventBean event = newEvents[0];
			System.out.println("\t module Bas => "+ fluxSortant.data.toString());
	        // ici est cree le flux ! ! !
	        this.fluxSortant.data.set(true);
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
		
	}

	public void run(){
		while(true){
	    	try {

	    		//System.out.println(pos.getPosX()+ " " + lastpos.getPosX());
	    		this.fluxSortant.data.set(false);
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
}
