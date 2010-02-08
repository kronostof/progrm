package myapp.module.manager;

import myapp.model.Shape;
import myapp.module.moduleFixation;
import myapp.module.action.moduleEviterPosition;

public class ModuleManagerFuite extends ModuleManager {

	public ModuleManagerFuite(Shape shape,int type) {
		super(shape);
		chainnage(new moduleFixation(shape.getNom(),shape,1));
		chainnage(new moduleEviterPosition(shape,type,shape.getPosition(),shape.getGaze()));
		
	}
}
