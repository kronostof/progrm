/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.myapp.model;

import com.espertech.esper.client.EPServiceProvider;
import java.awt.Point;
import javax.swing.event.EventListenerList;
import org.FormeListener;
import org.myapp.event.Position;
import org.myapp.flux.FluxPosition;
import org.myapp.Lecteur;
/**
 *
 * @author ter Vincent Bonnier
 */
public class newShape extends Thread implements FormeListener {
    private String nom;
    private Position position;	// la position dans le monde.
    //gestion du regard de l'utilisateur 
    EPServiceProvider epService;
    private EventListenerList listeners = new EventListenerList();
    public FluxPosition Gaze = new FluxPosition(); // position du regard de l'utilisateur

    /* nouveautées */
    private MondeDesFormesMDP mdp = new MondeDesFormesMDP(0,1);
    private LearningAlgorithm learningalgo = new Sarsa(mdp); // algo d'apprentissage

    private SARSA_State state; //forme se nomme désormais state
    /*    private int forme;
          private ShapeType shapeType;
          private ShapeForme forme2;
     *    public Color color;
     * Toutes ces informations sont maintenant dans le state de la forme
     * private int state.
     *
     */
    public newShape(String nom) {
        this.nom = nom;
        Lecteur.accroche(Gaze);
        epService = Lecteur.getInstance();
        position = new Position((int) (Math.random() * 1024), (int) (Math.random() * 768));
        state.getInitState();
        this.start();
    }
    @Override
    public void positionChangee(FormeListener Fl) {
        // TODO Auto-generated method stub
    }

    @Override
    public Point getPoint() {
        return position.getPoint();
    }
    public void addFormeListener(FormeListener listener) {
        listeners.add(FormeListener.class, listener);
    }

    public FormeListener[] getFormeListeners() {
        return listeners.getListeners(FormeListener.class);

    }
    @Override
    public void run() {}

    public void firePositionChangee() {
        for (FormeListener listener : getFormeListeners()) {
            listener.positionChangee(this);
        }
    }

    public FluxPosition getGaze() {
        return Gaze;
    }

    public void setGaze(FluxPosition Gaze) {
        this.Gaze = Gaze;
    }

    public EPServiceProvider getEpService() {
        return epService;
    }

    public void setEpService(EPServiceProvider epService) {
        this.epService = epService;
    }

    public EventListenerList getListeners() {
        return listeners;
    }

    public void setListeners(EventListenerList listeners) {
        this.listeners = listeners;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
