package org.myapp.module;

import java.util.HashMap;

//import org.myapp.event.Fixation;
//import org.myapp.Lecteur;
import org.myapp.event.Information;
import org.myapp.event.Position;
import org.myapp.flux.Flux;
import org.myapp.flux.FluxFixation;
import org.myapp.flux.FluxPosition;

//import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleFixation extends module<FluxPosition ,FluxFixation > implements UpdateListener{
 
	/**
	 * parametre
	 */
    private Position pos,lastpos;
    //private FluxPosition fluxEntrant;
    //EPServiceProvider epService;

    /**
	 * partie faiant l'update
	 * on ne rajoute ds le flux que de nouvelle information
	 */
	@Override
	 public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        this.getFluxSortant().set(this.getFluxEntrant().getPosX(),this.getFluxEntrant().getPosY());
       // System.out.println("\t"+nom+"\t module Fixation FXE:=> "  + this.fluxEntrant.data.toString());
       // System.out.println("\t"+nom+"\t module Fixation FXS:=> "  + this.fluxSortant.data.toString());
       // System.out.println(" ICI " + this.getFluxEntrant().getPosX()+ " | " +this.getFluxEntrant().getPosY());
	}

    //public void init(EPServiceProvider epService){    	this.epService=Lecteur.getInstance();    }
    
	
	public moduleFixation(String nom, int i) {
	    super();
        this.nom = nom;
        pos = new Position();
        lastpos = new Position();
        setFluxEntrant(new FluxPosition());
        setFluxSortant(new FluxFixation());
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+30) and  posX > (lastposX-30)" +
        				" and  posY < (lastposY+30) and posY > (lastposY-30)";
        init_module();
        start();
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
        setFluxEntrant(position);
        setFluxSortant(fixation);
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+30) and  posX > (lastposX-30)" +
        				" and  posY < (lastposY+30) and posY > (lastposY-30)";
	}
    
    public moduleFixation(String string, int i, FluxPosition position) {
        super();
        pos = new Position();
        lastpos = new Position();        
        setFluxSortant(new FluxFixation());
        expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
        				"where posX < (lastposX+30) and  posX > (lastposX-30)" +
        				" and  posY < (lastposY+30) and posY > (lastposY-30)";
	}
    

	

	public void run(){
    	while(true){
	    	try {   
	    		if(getFluxEntrant().isFresh(20)){
					epService.getEPRuntime().sendEvent(this);
		    		lastpos.set(pos);
		    		pos.set(getFluxEntrant().data);
					//System.out.println(pos.toString() + " " + lastpos.toString());
					}
				else{
					//System.out.println("old info MFixation ! ! ! ");
					sleep(vitesseDeTraitement);
				}
	    		sleep(vitesseDeTraitement);
	    		} catch (InterruptedException e) { e.printStackTrace();	}
			}
    }
 
    public float getPosX() {
        return getFluxEntrant().getPosX();
    }
    
    public float getPosY() {
        return getFluxEntrant().getPosY();
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

	public void setFluxEntrant(Flux<? extends Information> fluxEntrant){
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}

}
