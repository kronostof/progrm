package myapp.model;

import drawing.shape.VueForme;
import java.util.ArrayList;
import myapp.Sarsa.Sarsa_Shape;
import myapp.controle.MondeDesFormeController;
import myapp.factory.Sarsa_ShapeFactory;

/*
 * @author ter Vincent Bonnier
 */
public class NewMondeDesFormeModel extends MondeDesFormeModel {


    public NewMondeDesFormeModel() {
        new Sarsa_ShapeFactory(listeDeShape);
    }

    /**
     * Construction de l'état du monde de départ
     * @param Controleur
     */
    @Override
    public void build(MondeDesFormeController Controleur) {
        
             Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.Gaze0, VueForme.ShapeForme.CIRCLE);//.start();
        for (int i = 1; i < 2; i++) {
            Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.Approche1);//.start();
            Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.Approche0);//.start();
            Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.Type1);//.start();
            Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.Type2);//.start();
            Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.fuite0);//.start();
        }
    }
}
