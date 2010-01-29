package myapp.module.manager;

import myapp.model.Shape;
import myapp.module.action.moduleSuivrePosition;

public class ModuleManagerApproche extends ModuleManager {

	public ModuleManagerApproche(Shape shape,int type) {
		super(shape);
		//chainnage(new moduleFixation(shape.getNom(),1));
		chainnage(new moduleSuivrePosition(shape,type,shape.getPosition(),shape.getGaze()));
		
	}

}
