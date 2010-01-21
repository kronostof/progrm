/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */

package org.myapp.model;

import com.espertech.esper.client.EPServiceProvider;
import java.awt.Point;
import javax.swing.event.EventListenerList;
import org.FormeListener;
import org.myapp.event.Position;
import org.myapp.flux.FluxPosition;
import org.myapp.Lecteur;
import org.myapp.module.manager.ModuleManager;
/**
 * Une shape possède un objet SARSA_State correspondant à son état.
 * (sa couleur, sa forme...)
 * @author ter Vincent Bonnier
 */
public class NewShape extends Thread implements FormeListener {
    /* Autrefois dans AbstractShape */
    public static final int CURSOR = 1;
    public static final int SQUARE = 2;
    public static final int CIRCLE = 3;
    public static final int TRANGLE = 4;

    private SarsaStateFactory state;
    private String nom;
    private Position position;	// la position dans le monde.
    private EventListenerList listeners = new EventListenerList();
    //private MondeDesFormesMDP mdp = new MondeDesFormesMDP(0,1);
    //private LearningAlgorithm learningalgo = new Sarsa(mdp); // algo d'apprentissage

    //gestion du regard de l'utilisateur
    EPServiceProvider epService;

    public FluxPosition Gaze = new FluxPosition(); // position du regard de l'utilisateur
    public ModuleManager poolModule;


    public NewShape(String nom) {
        this.nom = nom;
        Lecteur.accroche(Gaze);
        epService = Lecteur.getInstance();
        position = new Position((int) (Math.random() * 1024), (int) (Math.random() * 768));
        state = new SarsaStateFactory();
        this.start();
    }
    @Override
    public void positionChangee(FormeListener Fl) {}

    public void addFormeListener(FormeListener listener) {
        listeners.add(FormeListener.class, listener);
    }

    public void firePositionChangee() {
        for (FormeListener listener : getFormeListeners()) {
            listener.positionChangee(this);
        }
    }

    @Override
    public void run() {}

    @Override
    public Point getPoint() { return position.getPoint(); }
    public FormeListener[] getFormeListeners() { return listeners.getListeners(FormeListener.class); }
    public FluxPosition getGaze() { return Gaze;}
    public EventListenerList getListeners() { return listeners; }
    public String getNom() { return nom;}
    public SarsaStateFactory getStateOfShape() {return state; }
    public Position getPosition() {return position;}

    public void setGaze(FluxPosition Gaze) {this.Gaze = Gaze; }
    public EPServiceProvider getEpService() { return epService;}
    public void setEpService(EPServiceProvider epService) { this.epService = epService;}
    public void setListeners(EventListenerList listeners) { this.listeners = listeners; }
    public void setNom(String nom) {this.nom = nom;}
    public void setPosition(Position position) {this.position = position;}
}
