package org.myapp.module;


import java.util.HashMap;
import org.myapp.event.Position;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxPosition;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class modulePosition  extends module<FluxPosition ,FluxBool> implements UpdateListener{

	Position position;
    EPServiceProvider epService;

    /**
	 * 
	 * 
	 * Ce module détermine si le gaze est proche de la position déterminé par Focus
	 * La principale utilisation est : déterminer si l'utilisateur regarde vers la position Focus
	 * @param string
	 * @param i
	 * @param position la position que l on va considérer
	 * @param fluxEntrant
	 * @param fluxSortant
	 */
	public modulePosition(String string, int i,Position position, FluxPosition fluxEntrant, FluxBool fluxSortant) {

		this.position = position;
		this.fluxEntrant = fluxEntrant;
        this.fluxSortant = fluxSortant;
        expression =  new String("select posX,posY,gposX,gposY from org.myapp.module.modulePosition where "+
        						"(gposX - "+20+" ) < posX and posX < (gposX + "+20+" ) and "+
        						"(gposY - "+20+" ) < posY and posY < (gposY + "+20+" )");
	
	}

	

	/**
	 *  Cette methode est reçut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {

		/*
		 * EventBean event = newEvents[0]; 
		 * Pour recuperer des données propre a un evenement
		 * event.get("avg(price)") 
		 * /!\ il faut que la methodes getXXX existe dans l'objet envoiyer par send donc dans le module.
		 */
		fluxSortant.set(true);
		System.out.println("\t module Position => "+ fluxSortant.data.toString() +"on regarde vers" + getgposX() + " | " + getgposY()) ;
		// * * * this.fluxSortant.data...
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
	}


	public void run(){
		while(true){
			if(fluxEntrant.isFresh(20))
				epService.getEPRuntime().sendEvent(this);
	    			    		
	    		 try {
	    		 sleep(vitesseDeTraitement);
	    		 } catch (InterruptedException e) { e.printStackTrace();	}
			}
	}


	/**
	 * 
	 * @return 
	 */
	 public float getgposX() {
	        return fluxEntrant.getPosX();
	    }

	 public float getgposY() {
	        return fluxEntrant.getPosY();
	    }

	 public float getposX() {
	        return position.getPosX();
	    }

	 public float getposY() {
	        return position.getPosY();
	    }


	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}
}
