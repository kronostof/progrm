package myapp.model;

import javax.swing.event.EventListenerList;

import drawing.shape.FormeListener;
import myapp.event.Position;
import myapp.factory.ShapeFactory.ShapeType;
import myapp.flux.FluxPosition;
import myapp.module.manager.ModuleManager;

import com.espertech.esper.client.EPServiceProvider;
import drawing.shape.VueForme.ShapeForme;
import java.awt.Color;
/*
 *
 *
 *
 */
abstract public class Abstract_Shape extends Thread implements FormeListener {

    EPServiceProvider epService;
    private EventListenerList listeners = new EventListenerList();
    private String nom;

    /**
    * Identidiant de la forme associé a l'instance
    */
    //private int forme;
    private Position position;	// la position dans le monde.
    public Color color;
    public FluxPosition Gaze = new FluxPosition();
    public ModuleManager poolModule;

    private ShapeType shapeType;
    private ShapeForme forme;

    public static final int CURSOR   = 1;
    public static final int SQUARE = 2;
    public static final int CIRCLE = 3;
    public static final int TRANGLE = 4;

    abstract Position getPosition() ;
    abstract void addFormeListener(FormeListener listener);
    abstract FormeListener[] getFormeListeners();
    abstract void firePositionChangee();
    abstract void fireCouleurChangee();
    /*abstract void positionChangee(FormeListener Fl);*/
    abstract String getNom();
    abstract FluxPosition getGaze();
    abstract Color getColor();
    /*abstract Point getPoint();*/
    abstract void setForme(ShapeForme forme);
    abstract void setType(ShapeType shapeType);
    abstract ShapeForme getForme();
    abstract ShapeType getType();
    abstract void eloigne(Position data, int paramPas);
}
