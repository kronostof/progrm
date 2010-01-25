package org.myapp.model;

//import drawing.shape.VueForme;
import drawing.shape.NewVueForme;
import org.myapp.Lecteur;
import org.myapp.Sarsa.Sarsa_StateFactory;
import org.myapp.controle.NewMondeDesFormeController;
//import org.myapp.controle.MondeDesFormeControllerListener;
//import org.myapp.factory.NewShapeFactory;
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
        //création de la state factory
        Sarsa_StateFactory state_factory = new Sarsa_StateFactory();
        NewShape shape1 = new NewShape("shape1", state_factory);
        shape1.getStateOfShape().toString();
        //ajout de la forme au JCanvas par le biais de son avater newVueForm
        NewVueForme avatar_shape1 = new NewVueForme(shape1);
        NewShape shape2 = new NewShape("shape2", state_factory);
        shape2.getStateOfShape().toString();
        NewVueForme avatar_shape2 = new NewVueForme(shape2);
    }
}
