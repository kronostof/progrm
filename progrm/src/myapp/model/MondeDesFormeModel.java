package myapp.model;

import drawing.shape.VueForme;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.Lecteur;
import myapp.controle.MondeDesFormeController;
import myapp.controle.MondeDesFormeControllerListener;
import myapp.factory.ShapeFactory;

public class MondeDesFormeModel {

    /**
     * Un liste conservant toutes les shape du monde des forme.
     */
    protected ArrayList<Shape> listeDeShape = new ArrayList<Shape>();

    public MondeDesFormeModel() {
        // Lecteur est un thread Singloton. Cette instruction est nécéssaire.
        new Lecteur();

    }

    /**
     * Construction de l'état du monde de départ
     * @param Controleur
     */
    public void build(MondeDesFormeController Controleur) {
        new ShapeFactory(listeDeShape);
        //   ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0, VueForme.ShapeForme.CURSOR);
        for (int i = 0; i < 2; i++) {

            ShapeFactory.createShape(ShapeFactory.ShapeType.Approche1, VueForme.ShapeForme.CIRCLE);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Approche0, VueForme.ShapeForme.TRIANGLE);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Type1, VueForme.ShapeForme.TRIANGLE);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Type2, VueForme.ShapeForme.TRIANGLE);
            ShapeFactory.createShape(ShapeFactory.ShapeType.fuite0, VueForme.ShapeForme.CIRCLE);
        }
    }

    public void addControlleurListner(MondeDesFormeControllerListener Controleur) {
    }

    public void notifieCalibrationEnCour() {
        System.out.println(" endormir tout les thread qui y jouent.");
        for (Shape shape : listeDeShape) {
            shape.pause();
        }
    }
}
