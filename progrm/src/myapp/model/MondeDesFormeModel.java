package myapp.model;

import drawing.shape.VueForme;
import myapp.Lecteur;
import myapp.controle.MondeDesFormeController;
import myapp.controle.MondeDesFormeControllerListener;
import myapp.factory.ShapeFactory;

public class MondeDesFormeModel {

    public MondeDesFormeModel() {
        // Lecteur est un thread Singloton. Cette instruction est nécéssaire.
        new Lecteur();
    }

    /**
     * Construction de l'état du monde de départ
     * @param Controleur
     */
    public void build(MondeDesFormeController Controleur) {
        ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0, VueForme.ShapeForme.CURSOR);
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
}
