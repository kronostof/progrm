package org.myapp.model;

import java.awt.Color;
import java.awt.Point;

import javax.swing.event.EventListenerList;

import org.FormeListener;
import org.myapp.Lecteur;
import org.myapp.event.Position;
import org.myapp.factory.ShapeFactory.ShapeType;
import org.myapp.flux.FluxPosition;
import org.myapp.module.manager.ModuleManager;

import com.espertech.esper.client.EPServiceProvider;
import drawing.shape.VueForme.ShapeForme;

/**
 * model de l'objet forme.
 */
public class Shape extends AbstractShape implements FormeListener {

    private EventListenerList listeners = new EventListenerList();
    private String nom;			// Un identifiant- utilis� pour la sortie console.
/** 
 * Identidiant de la forme associé a l'instance
 */
    private int forme;
    private Position position;	// la position dans le monde.
    private ShapeType shapeType;
    private ShapeForme forme2;


    public Shape(String nom) {
        this.nom = nom;
        Lecteur.accroche(Gaze);
        epService = Lecteur.getInstance();
        position = new Position((int) (Math.random() * 1024), (int) (Math.random() * 768));
        color = new Color(50000);
        this.start();
    }

    public Position getPosition() {
        return position;
    }

    public void addFormeListener(FormeListener listener) {
        listeners.add(FormeListener.class, listener);
    }

    public FormeListener[] getFormeListeners() {
        return listeners.getListeners(FormeListener.class);

    }

    /**
     * Le thread de la forme peut donner des indication sur le fonctionnenment de la forme.
     */
    @Override
    public void run() {
        //while (true) {
        // try {
        //  sleep(30);
        //if (!fbool.data.getValue())
        //  {
        // on d�place la forme en fonction de qlq chose
        // System.out.println("GAZE " +Gaze.data.getPosX() + " " + Gaze.data.getPosY());
        //position.set(Gaze.data.getPosX()+1,position.getPosY()+1);
        //position.set(Gaze.data);
        // la position de la forme se rapporche de la position du Gaze
        //FonctionTemp1();
        // FonctionTemp2();
        // on crie sur ts les toit q l on a changer qlq chose ! ! !
        //firePositionChangee();
        //}
        //System.out.println(position + " " + fbool.data.toString());
        // } catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //}
    }

    public void firePositionChangee() {

        for (FormeListener listener : getFormeListeners()) {
            listener.positionChangee(this);
        }

    }

    public void fireCouleurChangee() {
        for (FormeListener listener : getFormeListeners()) {
            listener.positionChangee(this);
     }

    }

    @Override
    public void positionChangee(FormeListener Fl) {
        // TODO Auto-generated method stub
    }

    public String getNom() {
        return nom;
    }

    public FluxPosition getGaze() {
        return Gaze;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Point getPoint() {
        return position.getPoint();
    }

    /**
     * @param forme the forme to set
     */
    
    public void setForme(int forme) {
        this.forme = forme;
    }
    
    public void setType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public int getForme() {
        return forme;
    }
    
    /**
     * @return the forme
     */
    public ShapeType getType() {
        return this.shapeType;
    }

    public void eloigne(Position data, int paramPas) {
        position.eloigne(data, paramPas);
    }

    public void setForme2(ShapeForme shapeForme) {
        this.forme2 = shapeForme;
    }

    public ShapeForme getForme2() {
        return forme2;
    }
}
