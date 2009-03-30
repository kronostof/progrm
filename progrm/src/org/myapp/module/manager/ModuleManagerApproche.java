package org.myapp.module.manager;

import org.myapp.model.Shape;
import org.myapp.module.action.moduleSuivrePosition;

public class ModuleManagerApproche extends ModuleManager {

	public ModuleManagerApproche(Shape shape,int type) {
		super(shape);
		//chainnage(new moduleFixation(shape.getNom(),1));
		chainnage(new moduleSuivrePosition(shape,type,shape.getPosition(),shape.getGaze()));
		
	}

}
