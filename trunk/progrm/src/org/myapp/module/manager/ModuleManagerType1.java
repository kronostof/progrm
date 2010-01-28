package org.myapp.module.manager;

import org.myapp.model.Shape;
import org.myapp.module.action.*;
import org.myapp.module.*;
/**
 * fait clignoter la forme.
 * @author christophe
 *
 */
public class ModuleManagerType1 extends ModuleManager{
	
	public ModuleManagerType1(Shape shape,int type) {
		super(shape);
		//
                chainnage(new moduleFixation("shape",1));
                chainnage(new modulePosition(shape,1));
                chainnage(new moduleChangerCouleur(shape,type));
	}

}
