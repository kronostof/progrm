package myapp.module.manager;

import myapp.model.Shape;
import myapp.module.moduleFixation;
import myapp.module.action.moduleChangerCouleur;

public class ModuleManagerType2 extends ModuleManager{
	
	public ModuleManagerType2(Shape shape,int type) {
		super(shape);
		chainnage(new moduleFixation(shape.getNom(),shape,1));
		chainnage(new moduleChangerCouleur(shape,type));
	}

}
