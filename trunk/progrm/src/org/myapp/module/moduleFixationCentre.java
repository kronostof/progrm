
package org.myapp.module;

import java.util.HashMap;
import org.myapp.event.Bbool;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxFixation;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;


public class moduleFixationCentre  extends module<FluxFixation ,FluxBool > implements UpdateListener{

	
	
	// CHK UML 28 EPServiceProvider epService;
	
	public moduleFixationCentre(String string, int i, FluxFixation fluxe, FluxBool fluxs) {


		fluxEntrant = fluxe;
        fluxSortant = fluxs;
        expression =  new String("select posX,posY from org.myapp.module.moduleFixationCentre.win:time(30 sec) "+
        						" where posX < 1248 and posX > 212 and posY< 492 and posY>105");
	}

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		
	        fluxSortant.set(new Bbool());
	        System.out.println("\t module Fixation Centre => "+ fluxSortant.data.toString());
	}

	//@Override	public void init(EPServiceProvider nepService) {		this.epService=nepService;	}

	public void run(){
		while(true){
	    	try {
	    		// on verifie la fraicheur de l info
	    		if(fluxEntrant.isFresh(20))
	    		epService.getEPRuntime().sendEvent(this);
	    		sleep(20);
	    	}
	    	catch (InterruptedException e) { e.printStackTrace();	}
		}
	}


	 public float getPosX() {
	        return fluxEntrant.data.getPosX();
	    }
	    
    public float getPosY() {
    	return fluxEntrant.data.getPosY();
    }

	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}
}
