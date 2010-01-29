package myapp.module.manager;

import myapp.model.Shape;
import myapp.module.action.moduleChangerCouleur;
import myapp.module.moduleFixation;
import myapp.module.modulePosition;
/**
 * fait clignoter la forme.
 * @author christophe
 *
 */
public class ModuleManagerType3 extends ModuleManager{

	public ModuleManagerType3(Shape shape,int type) {
		super(shape);
		//
                chainnage(new moduleFixation("shape",1));
                chainnage(new modulePosition(shape,1));
                //chainnage(new moduleEviterPosition(shape,type,shape.getPosition(),shape.getGaze()));
                chainnage(new moduleChangerCouleur(shape,type));
	}

}
