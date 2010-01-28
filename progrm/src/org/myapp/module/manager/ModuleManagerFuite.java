package org.myapp.module.manager;

import org.myapp.model.Shape;
import org.myapp.module.moduleFixation;
import org.myapp.module.action.moduleEviterPosition;

public class ModuleManagerFuite extends ModuleManager {

	public ModuleManagerFuite(Shape shape,int type) {
		super(shape);
		chainnage(new moduleFixation(shape.getNom(),1));
		chainnage(new moduleEviterPosition(shape,type,shape.getPosition(),shape.getGaze()));
		
	}
}
