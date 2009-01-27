package org;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.EventListenerList;
import org.myapp.Lecteur;
import org.myapp.ModelForme;
import org.myapp.flux.FluxPosition;

import drawing.CircleDrawable;


public class MondeDesFormeModel {


	private EventListenerList listeners;
	Entrepot entrepotDeForme;

	Lecteur lecteur;		// afin de tester j utilise ma propre classe lecteur.
	
	private MondeDesFormeControllerListener Controleur;

	public MondeDesFormeModel() {
		// 
		listeners = new EventListenerList();


		// juste por tester
		entrepotDeForme = new Entrepot();
		FluxPosition fluxgaze = new FluxPosition();
		lecteur = new Lecteur(fluxgaze);
		lecteur.start();
	}
	
	public void build(MondeDesFormeController Controleur){
		this.Controleur = Controleur;
		for (int i=0;i<1;i++){
			// creeation des forme
			ModelForme forme = new ModelForme("forme n°"+i,lecteur);
			// on averti le truc 
		 
			Controleur.addFormeListener(forme);
			//forme.addFormeListener(new CircleDrawable(Color.BLUE,forme.getPosition(),new Dimension(40,40)));
			forme.addMonFormeListener(new CircleDrawable(Color.BLUE,forme.getPosition(),new Dimension(40,40)));
			entrepotDeForme.put(new String("forme n°"+i), forme);
		}
		// juste pour tester
	}


	public void addModelListener(ModelListener listener){
		listeners.add(ModelListener.class, listener);
	}
	


	public void removeModelListener(ModelListener l){
		 listeners.remove(ModelListener.class, l);
	}


	public void addControlleurListner(MondeDesFormeControllerListener Controller) {
		this.Controleur = Controleur;
		
	}
}
