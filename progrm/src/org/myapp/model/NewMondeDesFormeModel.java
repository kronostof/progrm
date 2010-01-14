package org.myapp.model;

//import drawing.shape.VueForme;
import org.myapp.Lecteur;
import org.myapp.controle.NewMondeDesFormeController;
//import org.myapp.controle.MondeDesFormeControllerListener;
import org.myapp.factory.NewShapeFactory;
/*
 * @author ter Vincent Bonnier
 */
public class NewMondeDesFormeModel {

    public NewMondeDesFormeModel() {
        // Lecteur est un thread Singloton. Cette instruction est nécéssaire.
        new Lecteur();
    }

    /**
     * Construction de l'état du monde de départ
     * @param Controleur
     */
    public void build(NewMondeDesFormeController Controleur) {
        NewShapeFactory.createShape();
        NewShapeFactory.createShape();
        NewShapeFactory.createShape();
        NewShapeFactory.createShape();
        NewShapeFactory.createShape();
        NewShapeFactory.createShape();
    }
}
