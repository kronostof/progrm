package myapp.model;

import java.awt.Color;
import java.awt.Point;

import javax.swing.event.EventListenerList;

import drawing.shape.FormeListener;
import myapp.Lecteur;
import myapp.event.Position;
import myapp.factory.ShapeFactory.ShapeType;
import myapp.flux.FluxPosition;
import drawing.shape.VueForme.ShapeForme;

/**
 * model de l'objet forme.
 */
public class Shape extends Abstract_Shape{

    private EventListenerList listeners = new EventListenerList();
    protected String nom;			// Un identifiant- utilis� pour la sortie console.
    /**
     * Identidiant de la forme associé a l'instance
     */
    //private int forme;
    private Position position;	// la position dans le monde.
    private ShapeType shapeType;
    protected ShapeForme shapeForme;

    public Shape(String nom) {
        this.nom = nom;
        Lecteur.accroche(Gaze);
        epService = Lecteur.getInstance();
        color = new Color(10000);
        position = new Position((int) (Math.random() * 1024), (int) (Math.random() * 768));
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

    public void setType(ShapeType shapeType) {
        this.shapeType = shapeType;
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

    public ShapeForme getForme() {
        return shapeForme;
    }

    public void setForme(ShapeForme forme) {
        this.shapeForme = forme;
    }
}
