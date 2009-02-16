package org.myapp.factory;

import java.awt.Color;

import org.myapp.controle.MondeDesFormeController;
import org.myapp.model.ModuleManager;
import org.myapp.model.Shape;
import org.myapp.module.action.ModuleSuivreGaze;
import org.myapp.module.manager.ModuleManagerApproche;
import org.myapp.module.manager.ModuleManagerFuite;
import org.myapp.module.manager.ModuleManagerType1;

import drawing.shape.VueForme;

public class ShapeFactory {

	
	//public static MondeDesFormeController controleur = null;
	
	
	
	
	public ShapeFactory() {
		
	}
	/*
	public static Shape newShape(){
		//if (null == controleur) System.out.println("ShapeFactory: le controleur n a pas été initialisé");
		
		Shape nwShape = new Shape("nom" + System.currentTimeMillis());
		VueForme nwVueForme = new VueForme(nwShape,1);
		
		nwShape.addFormeListener(nwVueForme);
		
		// par default les forme se comporte ...
		ModuleManager nwModuleManager = new ModuleManagerFuite(nwShape);

		return nwShape; 
	}
	*/
	
	/**
	 * parametre les formes
	 */
	public static Shape newShape(String type){
		//if (null == controleur) System.out.println("ShapeFactory: le controleur n a pas été initialisé");
		
		Shape nwShape = new Shape("nom" + System.currentTimeMillis());
		
		
		// par default les forme se comporte ... comme des caillouuuxxx !!!
		ModuleManager nwModuleManager = null;
		
		
		if (type == "Gaze0"){
			nwShape.color = Color.RED;
			nwShape.setForme(Shape.CURSOR);
			nwModuleManager = new ModuleSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
		}
		
		
		if (type == "fuite0"){
			nwShape.color = Color.BLUE;
			nwShape.setForme(Shape.CIRCLE);
			nwModuleManager = new ModuleManagerFuite(nwShape,3);
		}
		if (type == "fuite1"){
			nwShape.color = Color.CYAN;
			nwShape.setForme(Shape.TRANGLE);
			nwModuleManager = new ModuleManagerFuite(nwShape,8);
		}
		
		
		
		
		
		if (type == "approche0"){
			nwShape.color = Color.BLACK;
			nwShape.setForme(Shape.SQUARE);
			nwModuleManager = new ModuleManagerApproche(nwShape,2);		// colle la position d'une la forme au gaze.
		}
		if (type == "approche1"){
			nwShape.color = Color.RED;
			nwShape.setForme(Shape.SQUARE);
			nwModuleManager = new ModuleManagerApproche(nwShape,20);
		}
		
		if (type == "type1"){
			nwShape.color = Color.YELLOW;
			nwShape.setForme(Shape.TRANGLE);
			nwModuleManager = new ModuleManagerType1(nwShape,Color.GRAY.getRGB());
		}
		if (type == "type2"){
			nwShape.color = Color.GREEN;
			nwShape.setForme(Shape.TRANGLE);
			nwModuleManager = new ModuleManagerType1(nwShape,Color.RED.getRGB());
		}


		VueForme nwVueForme = new VueForme(nwShape,nwShape.getForme());
		
		nwShape.addFormeListener(nwVueForme);
		nwShape.poolModule = nwModuleManager;
		return nwShape; 
	}
	
	

	public void setControlleur(MondeDesFormeController controleur2) {
		//controleur = controleur2;		
	}


}
