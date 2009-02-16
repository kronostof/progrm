package org.myapp.module.action;

import org.myapp.model.ModuleManager;
import org.myapp.model.Shape;

public class ModuleSuivreGaze extends ModuleManager {

	public ModuleSuivreGaze(Shape shape) {
		super(shape);
		chainnage(new ModuleSetToPosition(shape,100,shape.getPosition(),shape.getGaze()));
	}
}
