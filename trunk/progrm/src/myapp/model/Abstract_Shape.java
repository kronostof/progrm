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

    protected boolean ASLEEP = false;
    EPServiceProvider epService;
    private EventListenerList listeners = new EventListenerList();
    private String nom;
    /**
     * Identidiant de la forme associé a l'instance
     */
    //private int forme;
    protected Position position;	// la position dans le monde.
    public Color color;
    public FluxPosition Gaze = new FluxPosition();
    public ModuleManager poolModule;
    protected ShapeType shapeType;
    protected ShapeForme forme;
    protected ShapeForme shapeForme;

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

    abstract void setForme(ShapeForme forme);

    abstract void setType(ShapeType shapeType);

    abstract ShapeForme getForme();

    abstract ShapeType getType();

    abstract void eloigne(Position data, int paramPas);

    public void pause() {
        ASLEEP = !ASLEEP;
        if (poolModule != null) {


            poolModule.pause();
        }
    }
}
