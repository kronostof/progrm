package org.myapp.model;

import javax.swing.event.EventListenerList;

import org.FormeListener;
import org.myapp.Lecteur;
import org.myapp.event.Position;
import org.myapp.factory.ShapeFactory.ShapeType;
import org.myapp.flux.FluxPosition;
import org.myapp.module.manager.ModuleManager;

import com.espertech.esper.client.EPServiceProvider;
import drawing.shape.VueForme.ShapeForme;
import java.awt.Color;
import java.awt.Point;
/*
 *
 *
 *
 */
abstract class AbstractShape extends Thread implements FormeListener {

    EPServiceProvider epService;
    private EventListenerList listeners = new EventListenerList();
    private String nom;

    /**
    * Identidiant de la forme associé a l'instance
    */
    private int forme;
    private Position position;	// la position dans le monde.
    public Color color;
    public FluxPosition Gaze = new FluxPosition();
    public ModuleManager poolModule;
    private ShapeType shapeType;
    private ShapeForme forme2;

    public static final int CURSOR = 1;
    public static final int SQUARE = 2;
    public static final int CIRCLE = 3;
    public static final int TRANGLE = 4;

    abstract Position getPosition();
    abstract void addFormeListener(FormeListener listener);
    abstract FormeListener[] getFormeListeners();
    abstract void firePositionChangee();
    abstract void fireCouleurChangee();
    /*abstract void positionChangee(FormeListener Fl);*/
    abstract String getNom();
    abstract FluxPosition getGaze();
    abstract Color getColor();
    /*abstract Point getPoint();*/
    abstract void setForme(int forme);
    abstract void setType(ShapeType shapeType);
    abstract int getForme();
    abstract ShapeType getType();
    abstract void eloigne(Position data, int paramPas);
}
