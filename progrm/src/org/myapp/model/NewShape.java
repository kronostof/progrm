/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */

package org.myapp.model;

import com.espertech.esper.client.EPServiceProvider;
import java.awt.Color;
import java.awt.Point;
import javax.swing.event.EventListenerList;
import org.FormeListener;
import org.myapp.event.Position;
import org.myapp.factory.ShapeFactory.ShapeType;
import org.myapp.flux.FluxPosition;
import org.myapp.Lecteur;
import org.myapp.Sarsa.Sarsa_State;
import org.myapp.Sarsa.Sarsa_StateFactory;
/**
 * Une shape possède un objet SARSA_State correspondant à son état.
 * (sa couleur, sa forme...)
 * @author ter Vincent Bonnier
 */
public class NewShape extends AbstractShape implements FormeListener {

    private Sarsa_State state;
    private String nom;
    private Position position;	// la position dans le monde.
    private EventListenerList listeners = new EventListenerList();

    public NewShape(String nom, Sarsa_StateFactory stateFactory) {
        this.nom = nom;
        Lecteur.accroche(Gaze);
        epService = Lecteur.getInstance();
        position = new Position((int) (Math.random() * 1024), (int) (Math.random() * 768));
        state = stateFactory.get_Sarsa_State_aleatoire();
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
    public Sarsa_State getStateOfShape()  {return state; }
    public Position getPosition() {return position;}

    public void setGaze(FluxPosition Gaze) {this.Gaze = Gaze; }
    public EPServiceProvider getEpService() { return epService;}
    public void setEpService(EPServiceProvider epService) { this.epService = epService;}
    public void setListeners(EventListenerList listeners) { this.listeners = listeners; }
    public void setNom(String nom) {this.nom = nom;}
    public void setPosition(Position position) {this.position = position;}

    @Override
    void fireCouleurChangee() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    Color getColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void setForme(int forme) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void setType(ShapeType shapeType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    int getForme() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    ShapeType getType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    void eloigne(Position data, int paramPas) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
