package org.myapp.factory;

//import org.myapp.model.Shape;
import drawing.shape.NewVueForme;
import org.myapp.model.NewShape;
import org.myapp.module.manager.*;

//import drawing.shape.VueForme;
//import org.myapp.factory.ShapeFactory.ShapeType;
/*
 * @author ter Vincent Bonnier
 */
public class NewShapeFactory {
    static ModuleManager nwModuleManager;
    public static NewShapeFactory instance = new NewShapeFactory();

    private NewShapeFactory() {
        nwModuleManager = null;
    }

    public final synchronized static NewShapeFactory getInstance() {
        return instance;
    }

    public static NewShape createShape() {
        //demande de création d'un shape, c'est la factory
        //qui lui créera un currentState
        NewShape newShape = new NewShape("nom" + System.currentTimeMillis());

        //création de sa visualisation
        NewVueForme newVueForme = new NewVueForme(newShape);
        newShape.addFormeListener(newVueForme);
        newShape.poolModule = nwModuleManager;
        return newShape;
    }
}
