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
		new Lecteur();
		new ShapeFactory();
	}

/**
 * Construction de l'�tat du monde de d�part
 * @param Controleur
 */
	public void build(MondeDesFormeController Controleur){
		ShapeFactory.newShape("Gaze0");
		 for (int i=0;i<5;i++){
			 ShapeFactory.newShape("fuite0");
			 ShapeFactory.newShape("approche1");
			 ShapeFactory.newShape("approche0");
			 ShapeFactory.newShape("type1");
			 ShapeFactory.newShape("type2");
		}
	}

	public void addControlleurListner(MondeDesFormeControllerListener Controleur) {
//		this.Controleur = Controleur;
		
	}
	
}
