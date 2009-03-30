package org.myapp.module.manager;

import org.myapp.model.Shape;
import org.myapp.module.moduleFixation;
import org.myapp.module.action.moduleChangerCouleur;

public class ModuleManagerType2 extends ModuleManager{
	
	public ModuleManagerType2(Shape shape,int type) {
		super(shape);
		chainnage(new moduleFixation(shape.getNom(),1));
		chainnage(new moduleChangerCouleur(shape,type));
	}

}
