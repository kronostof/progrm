package org.myapp.module;


import java.util.Map;

import org.myapp.event.Information;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleMODEL  extends module<Information ,Information > implements UpdateListener{

	
	
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
	public moduleMODEL(String string, int i, Flux<Information> fluxEntrant, Flux<Information> fluxSortant) {


		this.fluxEntrant = fluxEntrant;
        this.fluxSortant = fluxSortant;
        expression =  new String("select posX from test.moduleMODEL.win:time(30 sec) "+
        						" where posX>350");
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
		System.out.println("\t module MODEL => "+ fluxSortant.data.toString());
		// * * * this.fluxSortant.data...
	}

	@Override
	public void init(EPServiceProvider nepService) {
		this.epService=nepService;
		
	}

	
	
	
	/**
	 * Le coeur du module.
	 * On peut en choisir le rythme
	 *  la ligne "epService.getEPRuntime().sendEvent(this);"
	 *  envoie l'évenement 'MODEL' au gestionnaire d'évenement
	 *  
	 *  les traitement a effectuer independament de la nature des flux entrant et sortant sont a y placer.
	 */
	public void run(){
		while(true){	    	
	    		System.out.println(fluxEntrant.get().toString());
	    		/**
	    		 * traitement sur le flux entrant
	    		 * 
	    		 * this.fluxSortant.data = XXX;
	    		 */
	    		
	    		/**
	    		 * envoi de l évenement afin d'être traité par la requete en utilisant ESPER
	    		 * 
	    		 * epService.getEPRuntime().sendEvent(this);
	    		 */
	    		
	    		/**
	    		 * Attente
	    		 * 
	    		 * try {
	    		 * sleep(vitesseDeTraitement);
	    		 * } catch (InterruptedException e) { e.printStackTrace();	}
	    		 */
			}
	}


	/**
	 * 
	 * @return 
	 */
	 public Information getXXX() {
	        return fluxEntrant.get();
	    }


	@Override
	public int setup(Map<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}
}
