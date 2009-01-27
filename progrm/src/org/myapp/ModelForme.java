package org.myapp;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.EventListenerList;

import org.FormeListener;
import org.myapp.event.Position;
import org.myapp.flux.FluxBool;
import org.myapp.flux.FluxFixation;
import org.myapp.flux.FluxPosition;
import org.myapp.module.moduleFixation;
import org.myapp.module.modulePosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;

	import drawing.CircleDrawable; //=*
import drawing.IDrawable;


public class ModelForme extends Thread implements FormeListener{

	
	EPServiceProvider epService;
	
	private EventListenerList listeners;
	
	private String nom;			// Un identifiant- utilisé pour la sortie console.
	private Position position;	// la position dans le monde.


	
	//FormeListener VueForme;
	FluxPosition Gaze = new FluxPosition();
	FluxBool fbool;

	
	private FormeListener monlistener;
	
	//cercle vueForme;
	// Angle angle
	//public void avancer(){ ... 
	
	public ModelForme(String nom ,Lecteur lecteur) {
		// random de 0 a 1200 CRADE pas de controle !!!
		this.nom = nom;
		lecteur.accroche(Gaze);									
		epService = lecteur.epService;
		// on rajoute les listener et tout ça ! ! ! 
		position = new Position((int)(Math.random()*2200),(int)(Math.random()*700));
		//System.out.println("creation de " + nom + ": " +position.getPosX()+ " " + position.getPosY() + " " +(int)Math.random() );
		//VueForme = new CircleDrawable(Color.BLUE,position,new Dimension(40,40));
		// postion hazardeuse
		
		
		
		// Gestionnaire de module()
		// a la main pr l instant.
		FluxFixation fixation = new FluxFixation();
		FluxPosition fposition = new FluxPosition();
		fbool = new FluxBool();
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
		
		
		//addFormeListener(VueForme);
		
		this.start();
	}
	
	
	public Position getPosition(){
		return position;
	}
	
	  public void addFormeListener(FormeListener listener) {
	    	listeners.add(FormeListener.class, listener);
	}
	  
    
    public FormeListener[] getFormeListeners() {
        return listeners.getListeners(FormeListener.class);
        
    }

    public void addMonFormeListener(FormeListener listener) {
    //	System.out.println("ICI");
    	monlistener = listener;
    }
	  
    public FormeListener getMonFormeListener() {
    	return monlistener;
        
    }
    
	@Override
	public void run(){
		while(true){
			try {
				sleep(100);
				 //if (!fbool.data.getValue())
				 {
					 // on déplace la forme en fonction de qlq chose
					// System.out.println("GAZE " +Gaze.data.getPosX() + " " + Gaze.data.getPosY());
					 //position.set(Gaze.data.getPosX()+1,position.getPosY()+1);
					 //position.set(Gaze.data);
					 // la position de la forme se rapporche de la position du Gaze
					 FonctionTemp1();
					// FonctionTemp2();
					 // on crie sur ts les toit q l on a changer qlq chose ! ! !
				 	 firePositionChangee();
			}
				
				//System.out.println(position + " " + fbool.data.toString());
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	private void FonctionTemp2() {
		if ((position.getPosX() - Gaze.getPosX()) > 5) 
			position.set(position.getPosX()+1,position.getPosY()); 
		else
			position.set(position.getPosX()-1,position.getPosY()); 
		if ((position.getPosY()- Gaze.getPosY()) > 5) 
			position.set(position.getPosX(),position.getPosY()+1); 
		else 
			position.set(position.getPosX(),position.getPosY()-1); 
		
	}


	/**
	 * la position de la forme se rapporche de la position du Gaze
	 */
	private void FonctionTemp1() {
		if (position.getPosX()< Gaze.getPosX()) 
			position.set(position.getPosX()+3,position.getPosY()); 
		else
			position.set(position.getPosX()-3,position.getPosY()); 
		if (position.getPosY()< Gaze.getPosY()) 
			position.set(position.getPosX(),position.getPosY()+3); 
		else 
			position.set(position.getPosX(),position.getPosY()-3); 
			
		
	}


	public void firePositionChangee() {
		//on avertit tous les listener
        //for(FormeListener listener : getFormeListeners())    listener.positionChangee();
		getMonFormeListener().positionChangee(this);
	}




	@Override
	public void positionChangee(FormeListener Fl) {
		// TODO Auto-generated method stub
		
	}}
