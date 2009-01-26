package org.myapp;

import javax.swing.event.EventListenerList;

import org.FormeListener;
import org.ModelListener;
import org.asma.cercle;
import org.myapp.event.Position;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxFixation;
import org.myapp.flux.FluxPosition;
import org.myapp.module.moduleFixation;
import org.myapp.module.modulePosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;


public class FormeModel extends Thread{

	
	Position position;
	FluxPosition Gaze = new FluxPosition();
	
	//cercle vueForme;
	// Angle angle
	//public void avancer(){ ... 
	EPServiceProvider epService;
	private String nom;
	
	public FormeModel(String nom ,Lecteur lecteur) {
		// random de 0 a 1200 CRADE pas de controle !!!
		this.nom = nom;
		lecteur.accroche(Gaze);
		epService = lecteur.epService;
		// on rajoute les listener et tout ça ! ! ! 
		
		// postion hazardeuse
		position = new Position((int)Math.random()*1200,(int)Math.random()*700);
		
		
		// Gestionnaire de module()
		// a la main pr l instant.
		FluxFixation fixation = new FluxFixation();
		FluxPosition fposition = new FluxPosition();
		FluxBool fbool = new FluxBool();
		moduleFixation listener =  new moduleFixation(nom, 33,Gaze,fixation);
		modulePosition listener2 =  new modulePosition(nom, 33,position,new FluxPosition(fixation.data.getPosition()),fbool);
		
		
		listener.init(epService);
		listener2.init(epService);
		//listener3.init(epService);

		EPStatement statement = epService.getEPAdministrator().createEPL(listener.expression);
		EPStatement statement2 = epService.getEPAdministrator().createEPL(listener2.expression);
		//EPStatement statement3 = epService.getEPAdministrator().createEPL(listener3.expression);
		
		statement.addListener(listener);
		statement2.addListener(listener2);
		//statement3.addListener(listener3);
		
		listener.start();
		listener2.start();
		//listener3.start();	
		
		
		// creeation des module de base.
		
		this.start();
	}
	/*
	public void addListener(FormeListener listener){
		listeners.add(FormeListener.class, listener);
	}
	*/
	
	@Override
	public void run(){
		//
		//
		// une forme se gere elle même.
		while(true){
			try {
				sleep(200);
				System.out.println(Gaze.data.toString());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
