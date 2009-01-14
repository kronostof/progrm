package org.myapp.module;

import java.util.Map;

import org.myapp.event.Fixation;
import org.myapp.event.Position;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleFixation extends module<Position ,Fixation > implements UpdateListener{

	/**
	 * parametre
	 */
	public String expression ;
    private Position pos,lastpos;
    //private FluxPosition fluxEntrant;
    EPServiceProvider epService;

    /**
	 * partie faiant l'update
	 */
	@Override
	 public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        EventBean event = newEvents[0];
        System.out.println("\t module Fixation => "  + this.fluxSortant.data.toString() );
        // ici est cree le flux ! ! !
        this.fluxSortant.data.set(((Float) event.get("posX")).floatValue(),((Float) event.get("posY")).floatValue());
    }


    public void init(EPServiceProvider epService){
    	this.epService=epService;
    }
    /**
     * 
     * @param Nom 
     * @param i
     * @param position
     * @param fixation
     */
    public moduleFixation(String nom, int i, Flux<Position> position,Flux<Fixation> fixation) {
        super();
        pos = new Position();
        lastpos = new Position();
        fluxEntrant = position;
        fluxSortant = fixation;
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+2) and  posX > (lastposX-2)" +
        				" and  posY < (lastposY+2) and posY > (lastposY-2)";
	}
    
    public moduleFixation(String string, int i, Flux<Position> position) {
        super();
        pos = new Position();
        lastpos = new Position();
        fluxEntrant = position;
        fluxSortant = new FluxFixation();
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+2) and  posX > (lastposX-2)" +
        				" and  posY < (lastposY+2) and posY > (lastposY-2)";
	}
    

	public void run(){
    	while(true){
	    	try {

	    		//System.out.println(this.fluxSortant.data.toString());
	    		//this.fluxSortant.data.set(-1,-1);
	    		epService.getEPRuntime().sendEvent(this);
	    		lastpos.set(pos);
	    		pos.set(fluxEntrant.data.getPosX(),fluxEntrant.data.getPosY());
	    		sleep(40);
	    		} catch (InterruptedException e) { e.printStackTrace();	}
			}
    }
 
    public float getPosX() {
        return pos.getPosX();
    }
    
    public float getPosY() {
        return pos.getPosY();
    }
    
    public float getlastposX() {
        return lastpos.getPosX();
    }
    public float getlastposY() {
        return lastpos.getPosY();
    }


	@Override
	public int setup(Map<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}



}
