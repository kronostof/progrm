package myapp.factory;

import myapp.Sarsa.Sarsa_Shape;
import myapp.Sarsa.Sarsa_StateFactory;

import java.awt.Color;
import myapp.module.manager.*;


import drawing.shape.VueForme;
import drawing.shape.VueForme.ShapeForme;

/**
 *
 * @author ter Vincent Bonnier
 */
public class Sarsa_ShapeFactory extends ShapeFactory {

    //SarsaState Factory nécessaire pour créer des newShape
    static public Sarsa_StateFactory stateFactory = null;

    public Sarsa_ShapeFactory() {
        stateFactory = new Sarsa_StateFactory();
    }


    /**
     * On cree des forme en fonction de parametre. en choisissant leur forme, leur comportement et leur couleur
     * @param type
     * @param forme
     * @return
     */
    public static Sarsa_Shape createShape(ShapeType type, ShapeForme forme) {

        Sarsa_Shape nwShape = new Sarsa_Shape("nom" + System.currentTimeMillis());

        nwShape.setType(type);
        nwShape.setForme(forme);

        switch (type) {

            case Gaze0:
                nwModuleManager = new ModuleManagerSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
                break;
            case fuite0:
                nwModuleManager = new ModuleManagerFuite(nwShape, 3);
                break;
            case Fuite1:
                nwModuleManager = new ModuleManagerFuite(nwShape, 8);
                break;
            case Approche0:
                nwModuleManager = new ModuleManagerApproche(nwShape, 2);		// colle la position d'une la forme au gaze.
                break;
            case Approche1:
                nwModuleManager = new ModuleManagerApproche(nwShape, 20);
                break;
            case Type1:
                nwModuleManager = new ModuleManagerType1(nwShape, Color.GRAY.getRGB());
                break;
            case Type2:
                nwModuleManager = new ModuleManagerType1(nwShape, Color.RED.getRGB());
                break;
        }
        //nwShape.setState(stateFactory.get_Sarsa_State_aleatoire());
        VueForme nwVueForme = new VueForme(nwShape);
        nwShape.addFormeListener(nwVueForme);
        nwShape.poolModule = nwModuleManager;
        return nwShape;
    }

    /**
     * on choisis des forme en leur fixant leur comportement. leur couleur et leur forme sont choisis au hazad.
     * @param type
     * @return
     */
     public static Sarsa_Shape createShape(ShapeType type) {

        Sarsa_Shape nwShape = new Sarsa_Shape("nom" + System.currentTimeMillis());

        nwShape.setType(type);

        switch (type) {

            case Gaze0:
                nwModuleManager = new ModuleManagerSuivreGaze(nwShape);		// colle la position d'une la forme au gaze.
                break;
            case fuite0:
                nwModuleManager = new ModuleManagerFuite(nwShape, 3);
                break;
            case Fuite1:
                nwModuleManager = new ModuleManagerFuite(nwShape, 8);
                break;
            case Approche0:
                nwModuleManager = new ModuleManagerApproche(nwShape, 2);		// colle la position d'une la forme au gaze.
                break;
            case Approche1:
                nwModuleManager = new ModuleManagerApproche(nwShape, 20);
                break;
            case Type1:
                nwModuleManager = new ModuleManagerType1(nwShape, Color.GRAY.getRGB());
                break;
            case Type2:
                nwModuleManager = new ModuleManagerType1(nwShape, Color.RED.getRGB());
                break;
        }
        nwShape.setState(stateFactory.get_Sarsa_State_aleatoire());
        VueForme nwVueForme = new VueForme(nwShape);
        nwShape.addFormeListener(nwVueForme);
        nwShape.poolModule = nwModuleManager;
        return nwShape;
    }

}

