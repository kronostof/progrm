package org.myapp.model;

//import java.awt.Color;
//import java.awt.Dimension;

import java.awt.Color;
import java.awt.Point;

import javax.swing.event.EventListenerList;

import org.FormeListener;
import org.myapp.Lecteur;
import org.myapp.event.Position;
import org.myapp.flux.FluxPosition;
import org.myapp.module.manager.ModuleManager;

import com.espertech.esper.client.EPServiceProvider;

//	import drawing.CircleDrawable; //=*
//import drawing.IDrawable;

/**
 * model de l'objet forme.
 */
public class Shape extends Thread implements AbstractShape,FormeListener{

	
	
	EPServiceProvider epService;
	
	private EventListenerList listeners = new EventListenerList();
	
	private String nom;			// Un identifiant- utilisé pour la sortie console.
	private int forme;
	private Position position;	// la position dans le monde.
	public Color color;

	
	//FormeListener VueForme;
	public FluxPosition Gaze = new FluxPosition();
	//FluxBool fbool;

	
//	private FormeListener monlistener;

	public ModuleManager poolModule;

	

	
	
	//cercle vueForme;
	// Angle angle
	//public void avancer(){ ... 
	
	public Shape(String nom,int type) {
		this.nom = nom;
		Lecteur.accroche(Gaze);									
		position = new Position((int)(Math.random()*1024),(int)(Math.random()*768));
		poolModule = new ModuleManager(Gaze);
		color = new Color(50000 * type);
		this.start();
	}
	
	public Shape(String nom) {
		// random de 0 a 1200 CRADE pas de controle !!!
		this.nom = nom;
		Lecteur.accroche(Gaze);									
		epService = Lecteur.getInstance(); 
		position = new Position((int)(Math.random()*1024),(int)(Math.random()*768));

		//poolModule = new ModuleManager(Gaze);
		color = new Color(50000);
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
/*
    public void addMonFormeListener(FormeListener listener) {
    	addFormeListener(listener);
    	monlistener = listener;
    }
	  
    public FormeListener getMonFormeListener() {
    	return monlistener;
        
    }
 */   
	@Override
	public void run(){
		while(true){
			try {
				sleep(30);
				 //if (!fbool.data.getValue())
				 {
					 // on déplace la forme en fonction de qlq chose
					// System.out.println("GAZE " +Gaze.data.getPosX() + " " + Gaze.data.getPosY());
					 //position.set(Gaze.data.getPosX()+1,position.getPosY()+1);
					 //position.set(Gaze.data);
					 // la position de la forme se rapporche de la position du Gaze
					 //FonctionTemp1();
					// FonctionTemp2();
					 // on crie sur ts les toit q l on a changer qlq chose ! ! !
				 	//firePositionChangee();
			}
				
				//System.out.println(position + " " + fbool.data.toString());
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	

	public void firePositionChangee(){
		//on avertit tous les listener
		//System.out.println(nom + "bla " + System.currentTimeMillis());
        for(FormeListener listener : getFormeListeners())    listener.positionChangee(this);
		//if (getMonFormeListener() != null)		getMonFormeListener().positionChangee(this);
	}

	public void fireCouleurChangee() {
		for(FormeListener listener : getFormeListeners())    listener.positionChangee(this);
		
	}


	@Override
	public void positionChangee(FormeListener Fl) {
		// TODO Auto-generated method stub
		
	}

	public String getNom() {
		return nom;
	}
	
	public FluxPosition getGaze() {
		return Gaze;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public Point getPoint() {
		return position.getPoint();
	}

	/**
	 * @param forme the forme to set
	 */
	public void setForme(int forme) {
		this.forme = forme;
	}

	/**
	 * @return the forme
	 */
	public int getForme() {
		return forme;
	}

	public void eloigne(Position data, int paramPas) {
		position.eloigne(data, paramPas);
		
	}


}
