package org.myapp.module.manager;

import org.myapp.model.NewShape;
import org.myapp.model.Shape;
import org.myapp.module.moduleFixation;
import org.myapp.module.action.moduleEviterPosition;

public class ModuleManagerFuite extends ModuleManager {

	public ModuleManagerFuite(Shape shape,int type) {
		super(shape);
		chainnage(new moduleFixation(shape.getNom(),1));
		chainnage(new moduleEviterPosition(shape,type,shape.getPosition(),shape.getGaze()));
		
	}

    public ModuleManagerFuite(NewShape shape1, int type) {
        super(shape1);
	chainnage(new moduleFixation(shape1.getNom(),1));
	//chainnage(new moduleEviterPosition(shape1,type,shape1.getPosition(),shape1.getGaze()));
    }
}
