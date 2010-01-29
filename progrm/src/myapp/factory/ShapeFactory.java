package myapp.factory;

import java.awt.Color;
import myapp.model.Shape;
import myapp.module.manager.ModuleManager;
import myapp.module.manager.ModuleManagerApproche;
import myapp.module.manager.ModuleManagerFuite;
import myapp.module.manager.ModuleManagerSuivreGaze;
import myapp.module.manager.ModuleManagerType1;


import drawing.shape.VueForme;
import drawing.shape.VueForme.ShapeForme;

/**
 * une factory en singleton.<p>
 * la création d'une nouvelle forme passe par l'ajout du nom de la forme dans la liste
 * ShapeType puis par son implemetentation dans creatShape
 * @author christophe
 */
public class ShapeFactory {// extends AbstractShapeFactory{

    static protected ModuleManager nwModuleManager;
    public static ShapeFactory instance = new ShapeFactory();

    public enum ShapeType {

        Gaze0,
        Type1, Type2,
        fuite0, Fuite1,
        Approche0, Approche1
    }

    public ShapeFactory() {
        nwModuleManager = null;
    }

    public final synchronized static ShapeFactory getInstance() {
        return instance;
    }

    /**
     * Creation des forme <p>
     * Retourne une nouvelle forme crée en fonction du type passe en paramètre
     */
    public static Shape createShape(ShapeType type) {

        Shape nwShape = new Shape("nom" + System.currentTimeMillis());

        nwShape.setType(type);

        switch (type) {

            case Gaze0:
                nwShape.color = Color.RED;
                nwModuleManager = new ModuleManagerSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
                break;

            case fuite0:
                nwShape.color = Color.BLUE;
                nwModuleManager = new ModuleManagerFuite(nwShape, 3);
                break;
            case Fuite1:
                nwShape.color = Color.CYAN;
                nwModuleManager = new ModuleManagerFuite(nwShape, 8);
                break;
            case Approche0:
                nwShape.color = Color.BLACK;
                nwModuleManager = new ModuleManagerApproche(nwShape, 2);		// colle la position d'une la forme au gaze.
                break;
            case Approche1:
                nwShape.color = Color.RED;
                nwModuleManager = new ModuleManagerApproche(nwShape, 20);
                break;

            case Type1:
                nwShape.color = Color.YELLOW;
                nwModuleManager = new ModuleManagerType1(nwShape, Color.GRAY.getRGB());
                break;
            case Type2:
                nwShape.color = Color.GREEN;
                nwModuleManager = new ModuleManagerType1(nwShape, Color.RED.getRGB());
                break;
        }
        VueForme nwVueForme = new VueForme(nwShape);
        nwShape.addFormeListener(nwVueForme);
        nwShape.poolModule = nwModuleManager;
        return nwShape;
    }

    public static Shape createShape(ShapeType type, ShapeForme forme) {

        Shape nwShape = new Shape("nom" + System.currentTimeMillis());

        nwShape.setType(type);
        nwShape.setForme(forme);

        switch (type) {

            case Gaze0:
                nwShape.color = Color.RED;
                nwModuleManager = new ModuleManagerSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
                break;

            case fuite0:
                nwShape.color = Color.BLUE;
                nwModuleManager = new ModuleManagerFuite(nwShape, 3);
                break;
            case Fuite1:
                nwShape.color = Color.CYAN;
                nwModuleManager = new ModuleManagerFuite(nwShape, 8);
                break;
            case Approche0:
                nwShape.color = Color.BLACK;
                nwModuleManager = new ModuleManagerApproche(nwShape, 2);		// colle la position d'une la forme au gaze.
                break;
            case Approche1:
                nwShape.color = Color.RED;
                nwModuleManager = new ModuleManagerApproche(nwShape, 20);
                break;

            case Type1:
                nwShape.color = Color.YELLOW;
                nwModuleManager = new ModuleManagerType1(nwShape, Color.GRAY.getRGB());
                break;
            case Type2:
                nwShape.color = Color.GREEN;
                nwModuleManager = new ModuleManagerType1(nwShape, Color.RED.getRGB());
                break;
        }
        VueForme nwVueForme = new VueForme(nwShape);
        nwShape.addFormeListener(nwVueForme);
        nwShape.poolModule = nwModuleManager;
        return nwShape;
    }
}
