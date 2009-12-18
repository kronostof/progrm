package org.myapp.factory;

import java.awt.Color;
import org.myapp.model.Shape;
import org.myapp.module.manager.*;


import drawing.shape.VueForme;

/**
 * une factory en singleton.<p>
 * la création d'une nouvelle forme passe par l'ajout du nom de la forme dans la liste
 * ShapeType puis par son implemetentation dans creatShape
 * @author christophe
 */
public class ShapeFactory {

    static ModuleManager nwModuleManager;
    public static ShapeFactory instance = new ShapeFactory();

    public enum ShapeType {

        Gaze0,
        type1, type2,
        fuite0, fuite1,
        approche0, approche1,
        Hawaiian
    }

    private ShapeFactory() {
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

        switch (type) {

            case Gaze0:
                nwShape.color = Color.RED;
                nwShape.setForme(Shape.CURSOR);
                nwModuleManager = new ModuleManagerSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
                break;

            case fuite0:
                nwShape.color = Color.BLUE;
                nwShape.setForme(Shape.CIRCLE);
                nwModuleManager = new ModuleManagerFuite(nwShape, 3);
                break;
            case fuite1:
                nwShape.color = Color.CYAN;
                nwShape.setForme(Shape.TRANGLE);
                nwModuleManager = new ModuleManagerFuite(nwShape, 8);
                break;
            case approche0:
                nwShape.color = Color.BLACK;
                nwShape.setForme(Shape.SQUARE);
                nwModuleManager = new ModuleManagerApproche(nwShape, 2);		// colle la position d'une la forme au gaze.
                break;
            case approche1:
                nwShape.color = Color.RED;
                nwShape.setForme(Shape.SQUARE);
                nwModuleManager = new ModuleManagerApproche(nwShape, 20);
                break;

            case type1:
                nwShape.color = Color.YELLOW;
                nwShape.setForme(Shape.TRANGLE);
                nwModuleManager = new ModuleManagerType1(nwShape, Color.GRAY.getRGB());
                break;
            case type2:
                nwShape.color = Color.GREEN;
                nwShape.setForme(Shape.TRANGLE);
                nwModuleManager = new ModuleManagerType1(nwShape, Color.RED.getRGB());
                break;
        }
        VueForme nwVueForme = new VueForme(nwShape, nwShape.getForme());
        nwShape.addFormeListener(nwVueForme);
        nwShape.poolModule = nwModuleManager;
        return nwShape;
    }
}
