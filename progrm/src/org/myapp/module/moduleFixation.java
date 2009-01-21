package org.myapp.module;

import java.util.HashMap;

import org.myapp.event.Fixation;
import org.myapp.event.Position;
import org.myapp.flux.FluxFixation;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleFixation extends module<FluxPosition ,FluxFixation > implements UpdateListener{

	/**
	 * parametre
	 */
	public String expression ;
    private Position pos,lastpos;
    //private FluxPosition fluxEntrant;
    EPServiceProvider epService;

    /**
	 * partie faiant l'update
	 * on ne rajoute ds le flux que de nouvelle information
	 */
	@Override
	 public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        
        this.fluxSortant.set(new Fixation(new Position(this.fluxEntrant.getPosX(),this.fluxEntrant.getPosY())));
        System.out.println("\t"+nom+"\t module Fixation => "  + this.fluxSortant.data.toString());
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
    public moduleFixation(String nom, int i, FluxPosition position,FluxFixation fixation) {
        super();
        this.nom = nom;
        pos = new Position();
        lastpos = new Position();
        fluxEntrant = position;
        fluxSortant = fixation;
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+2) and  posX > (lastposX-2)" +
        				" and  posY < (lastposY+2) and posY > (lastposY-2)";
	}
    
    public moduleFixation(String string, int i, FluxPosition position) {
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
	    		if (fluxEntrant.isFresh(40)){
		    		epService.getEPRuntime().sendEvent(this);
		    		lastpos.set(pos);
		    		pos.set(fluxEntrant.data);
	    		}
	    		sleep(20);
	    		} catch (InterruptedException e) { e.printStackTrace();	}
			}
    }
 
    public float getPosX() {
        return fluxEntrant.getPosX();
    }
    
    public float getPosY() {
        return fluxEntrant.getPosY();
    }
    
    public float getlastposX() {
        return lastpos.getPosX();
    }
    public float getlastposY() {
        return lastpos.getPosY();
    }


	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}



}
