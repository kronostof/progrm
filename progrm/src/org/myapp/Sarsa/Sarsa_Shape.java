/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
package org.myapp.Sarsa;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.myapp.model.*;
import com.espertech.esper.client.EPServiceProvider;
import drawing.shape.VueForme.ShapeForme;
import javax.swing.event.EventListenerList;
import org.myapp.event.Position;


/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
public class Sarsa_Shape extends Shape {

    private Sarsa_State state;
    private Sarsa_Politique politique = new Sarsa_Politique();
    private Position position;	// la position dans le monde.
    private EventListenerList listeners = new EventListenerList();
    //private MondeDesFormesMDP mdp = new MondeDesFormesMDP(0,1);
    //private LearningAlgorithm learningalgo = new Sarsa(mdp); // algo d'apprentissage
    //gestion du regard de l'utilisateur
    EPServiceProvider epService;

    public void setState(Sarsa_State state) {
        this.state = state;
        fire_StateChanged();
    }

    public Sarsa_Shape(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        int nbr_iteration = 0, Max_iteration = 10;
        // politique.affiche_politique();
        while (nbr_iteration++ < Max_iteration) {
            try {
                sleep(1000);
                setState(politique.getNewState(this));
            } catch (InterruptedException ex) {
                Logger.getLogger(Sarsa_Shape.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public EventListenerList getListeners() {
//        return listeners;
//    }
//
//    public void setGaze(FluxPosition Gaze) {
//        this.Gaze = Gaze;
//    }
//
//    public EPServiceProvider getEpService() {
//        return epService;
//    }
//
//    public void setEpService(EPServiceProvider epService) {
//        this.epService = epService;
//    }
//
//    public void setListeners(EventListenerList listeners) {
//        this.listeners = listeners;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
    public void fire_StateChanged() {
        this.color = get_from_State_Color(state);
        setForme(get_from_State_Forme(state));

        firePositionChangee();
    }

    private Color get_from_State_Color(Sarsa_State state) {
        return state.getAWTShapeColor();
    }

    private ShapeForme get_from_State_Forme(Sarsa_State state) {
        return state.getShapeForme();

    }

    public Sarsa_State getSarsaState() {
        return state;
    }
}
