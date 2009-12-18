package org.myapp.model;

import drawing.shape.VueForme;
import org.myapp.Lecteur;
import org.myapp.controle.MondeDesFormeController;
import org.myapp.controle.MondeDesFormeControllerListener;
import org.myapp.factory.ShapeFactory;

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
        ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0,VueForme.ShapeForme.Cursor);
        for (int i = 0; i < 2; i++) {

            ShapeFactory.createShape(ShapeFactory.ShapeType.Approche1,VueForme.ShapeForme.Circle);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Approche0,VueForme.ShapeForme.Triangle);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Type1,VueForme.ShapeForme.Triangle);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Type2,VueForme.ShapeForme.Triangle);
            ShapeFactory.createShape(ShapeFactory.ShapeType.fuite0, VueForme.ShapeForme.Circle);
        }
    }

    public void addControlleurListner(MondeDesFormeControllerListener Controleur) {
    }
}
