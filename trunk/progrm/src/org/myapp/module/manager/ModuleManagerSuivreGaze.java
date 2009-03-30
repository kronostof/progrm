package org.myapp.module.manager;

import org.myapp.model.Shape;
import org.myapp.module.action.ModuleSetToPosition;

public class ModuleManagerSuivreGaze extends ModuleManager {

	public ModuleManagerSuivreGaze(Shape shape) {
		super(shape);
		chainnage(new ModuleSetToPosition(shape,100,shape.getPosition(),shape.getGaze()));
	}
}
