package org.myapp.module.action;

import java.awt.Color;
import java.util.HashMap;

import org.myapp.event.Information;
import org.myapp.flux.Flux;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxPosition;
import org.myapp.model.Shape;
import org.myapp.module.module;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleChangerCouleur   extends module<FluxPosition ,FluxBool> implements UpdateListener{

   
	Shape shape;
	private boolean boolclignote;
	private long time = 0;
	private Color originalColor;
	private Color alternativeColor;
	private long delay;
	private long speed;

	/**
	 * 
	 * 
	 * Model de module.
	 * 
	 * @param string
	 * @param i
	 * @param color2 
	 * @param fluxEntrant
	 * @param fluxSortant
	 */
	public moduleChangerCouleur (Shape shape2, int type) {
		super();
		this.shape = shape2;
		boolclignote = false;
		originalColor = shape.color;
		alternativeColor = new Color(type);
		setFluxEntrant(new FluxPosition());
		setFluxSortant(new FluxBool());
        expression =  "select name,posX from org.myapp.module.action.moduleChangerCouleur ";
    	
        init_module();
		start();
	}


	/**
	 *  Cette methode est re�ut a chaque envoie d un nvll evenement
	 *  
	 *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		//System.out.println(" " +newEvents[0].get("name") + " " + getName());
		if (getName().compareTo(newEvents[0].get("name").toString()) == 0)
		{
		setClignote(1000,100);
		shape.firePositionChangee();
		}
		//System.out.println("bliblbi");
	}

	private void setClignote(long delay,long speed) {
		if (boolclignote == false){
		this.delay = delay;
		this.speed = speed;
		boolclignote = true;
		time = System.currentTimeMillis();
		}
	}



	private void clignote() {
		//System.out.println(delay + " ici (" + System.currentTimeMillis() + " - " + time+ " ) > " +speed + " " + (System.currentTimeMillis() - time));
		if ( (System.currentTimeMillis() - time ) > speed){
			if (shape.color == originalColor)
				shape.color = alternativeColor;
			else shape.color = originalColor;
			shape.firePositionChangee();
			time = System.currentTimeMillis();
			delay -= speed;
		}
		if ((delay )<= 0) {
			boolclignote = false;
			shape.color = originalColor;
		}	
	}

	/**
	 * Le coeur du module.
	 * On peut en choisir le rythme
	 *  la ligne "epService.getEPRuntime().sendEvent(this);"
	 *  envoie l'�venement 'MODEL' au gestionnaire d'�venement
	 *  
	 *  les traitement a effectuer independament de la nature des flux entrant et sortant sont a y placer.
	 */
	public void run(){
		while(true){
			
    		if (getFluxEntrant().isFresh(40)){
    			//System.out.println(shape.getName()+ " " + fluxEntrant.data.toString() + " " );
	    		epService.getEPRuntime().sendEvent(this);	
    		}
    		if(boolclignote) 	clignote();
    		try {
    		sleep(vitesseDeTraitement);
    		} catch (InterruptedException e) { e.printStackTrace();	}
		}
	}


	public int getposX() {
	        return shape.getPosition().getPosX();
	    }


	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}
}