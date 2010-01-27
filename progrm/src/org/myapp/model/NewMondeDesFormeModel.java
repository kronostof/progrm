package org.myapp.model;

//import drawing.shape.VueForme;
import drawing.JCanvas;
import drawing.shape.NewVueForme;
import org.myapp.Lecteur;
import org.myapp.Sarsa.Sarsa_StateFactory;
import org.myapp.controle.NewMondeDesFormeController;
import org.myapp.module.manager.ModuleManager;
import org.myapp.module.manager.ModuleManagerFuite;
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
    public void build(NewMondeDesFormeController Controleur, JCanvas vue) {
        //création de la state factory
        Sarsa_StateFactory state_factory = new Sarsa_StateFactory();
        // création de la shape 1
        // on lui fixe un état initial
        // on toString()
        // on lui créé un avatar
        // on associe à la shape un forme listener
        NewShape shape1 = new NewShape("shape1");
        shape1.setState(state_factory.get_Sarsa_State_aleatoire());
        NewVueForme avatar_shape1 = new NewVueForme(shape1);
        shape1.addFormeListener(avatar_shape1);
        ModuleManager nwModuleManager = new ModuleManagerFuite(shape1, 3);
        shape1.poolModule = nwModuleManager;

        //création de la shape 2
        NewShape shape2 = new NewShape("shape2");
        shape2.setState(state_factory.get_Sarsa_State_aleatoire());
        NewVueForme avatar_shape2 = new NewVueForme(shape2);
        shape2.addFormeListener(avatar_shape1);
        ModuleManager nwModuleManager2 = new ModuleManagerFuite(shape2, 3);
        shape2.poolModule = nwModuleManager2;

        //ptite boucle sympa pour tester changement d'états
        for(int i=0; i< 100; i++) {
            System.out.println("int i = " +i);
            shape1.setState(state_factory.get_Sarsa_State_aleatoire());
            //shape1.fireCouleurChangee();
            shape1.firePositionChangee();
            shape2.setState(state_factory.get_Sarsa_State_aleatoire());
            //shape2.fireCouleurChangee();
            shape2.firePositionChangee();
        }
    }
}
