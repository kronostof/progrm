package org.myapp.model;

import org.myapp.Lecteur;
import org.myapp.controle.MondeDesFormeController;
import org.myapp.controle.MondeDesFormeControllerListener;
import org.myapp.factory.ShapeFactory;


public class MondeDesFormeModel {

//	private EventListenerList listeners;
//	private MondeDesFormeControllerListener Controleur;

	
	//private ShapeFactory shapeFactory;
	public MondeDesFormeModel() {
		 
//		listeners = new EventListenerList();
		//entrepotDeForme = new Entrepot();
		new Lecteur();
		new ShapeFactory();
		//shapeFactory.setControlleur(Controleur);
		
	}

/**
 * Construction de l'état du monde de départ
 * @param Controleur
 */
	public void build(MondeDesFormeController Controleur){
//		this.Controleur = Controleur;
		//shapeFactory.setControlleur(Controleur);
		//ShapeFactory.
		ShapeFactory.newShape("Gaze0");
		//Controleur.nouvelleForme(new Shape("name " + System.currentTimeMillis(),10),100);
		
		 for (int i=0;i<3;i++){
			 ShapeFactory.newShape("fuite0");
			 ShapeFactory.newShape("approche1");
			 ShapeFactory.newShape("approche0");
			
			//Controleur.nouvelleForme(new Shape("name " + System.currentTimeMillis(),i%4),i%4);
		}
		 ShapeFactory.newShape("type1");
		 ShapeFactory.newShape("type2");
	}

	public void addControlleurListner(MondeDesFormeControllerListener Controleur) {
//		this.Controleur = Controleur;
		
	}
	
}
