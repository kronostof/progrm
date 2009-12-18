package org.myapp.model;

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
        ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0);
        for (int i = 0; i < 2; i++) {
            ShapeFactory.createShape(ShapeFactory.ShapeType.fuite0);
            ShapeFactory.createShape(ShapeFactory.ShapeType.approche1);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0.approche0);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0.type1);
            ShapeFactory.createShape(ShapeFactory.ShapeType.Gaze0.type2);
        }
    }

    public void addControlleurListner(MondeDesFormeControllerListener Controleur) {
//		this.Controleur = Controleur;
    }
}
