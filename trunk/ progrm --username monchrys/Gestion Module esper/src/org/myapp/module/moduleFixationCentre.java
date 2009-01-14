
package org.myapp.module;

import org.myapp.event.Fixation;
import org.myapp.event.Bbool;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleFixationCentre  extends module<Fixation ,Bbool > implements UpdateListener{

	
	
    EPServiceProvider epService;
	private long lasttemps;
    
    
	public moduleFixationCentre(String string, int i, Flux<Fixation> fluxe, Flux<Bbool> fluxs) {


		fluxEntrant = fluxe;
        fluxSortant = fluxs;
        expression =  new String("select posX,posY from org.myapp.module.moduleFixationCentre.win:time(30 sec) "+
        						" where posX < 600 and posX > 400 and posY< 450 and posY>350");
	}

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		//EventBean event = newEvents[0];
		if (fluxEntrant.data.getTemps() != lasttemps){
			lasttemps = fluxEntrant.data.getTemps();
			System.out.println("\t module Fixation Centre => "+ fluxSortant.data.toString());
	        // ici est cree le flux ! ! !
	        this.fluxSortant.data.setOki(true);
		}
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
		
	}

	public void run(){
		while(true){
	    	try {

	    		//System.out.println(pos.getPosX()+ " " + lastpos.getPosX());
	    		this.fluxSortant.data.setOki(true);
	    		epService.getEPRuntime().sendEvent(this);
	    		//if (this.fluxSortant.data.oki == true) 
	    			this.fluxSortant.data.temps = fluxEntrant.data.getTemps();
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
