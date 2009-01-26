package org;


import javax.swing.event.EventListenerList;
import org.myapp.Lecteur;
import org.myapp.FormeModel;
import org.myapp.flux.FluxPosition;


public class MondeDesFormeModel {


	private EventListenerList listeners;
	// stockage des données
	Entrepot entrepotDeForme;

	Lecteur lecteur;		// afin de tester j utilise ma propre classe lecteur.

	public MondeDesFormeModel() {
		// 
		listeners = new EventListenerList();


		// juste por tester
		Entrepot entrepotDeForme = new Entrepot();
		FluxPosition fluxgaze = new FluxPosition();
		Lecteur lecteur = new Lecteur(fluxgaze);
		lecteur.start();
		for (int i=0;i<3;i++){
			// creeation des forme
			FormeModel forme = new FormeModel("forme n°"+i,lecteur);
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
}
