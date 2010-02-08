package myapp.Sarsa;

import drawing.shape.VueForme.ShapeForme;
import java.awt.Color;
import java.util.Observable;

/**
 *
 * @author christophe Moncy p0304320
 */
public class Sarsa_State extends Observable {

    // ShapeColor couleur (bleue, rouge, jaune)
    public enum ShapeColor {

        BLUE, RED, YELLOW,// WHITE, GREEN
    }
    // ShapeDist distance au regard (proche, eloigné , neutre)

    public enum ShapeDist {

        PROCHE, ELOIGNE, NEUTRE
    }
    // ShapeType forme (triangle, rond, carré)
    /*
    public enum State_ShapeForme {

    CIRCLE, CURSOR, SQUARE, TRIANGLE;
    }
     */
    /**
     * Liste des element constituant l'état
     */
    ShapeForme shapeForme;
    ShapeDist shapeDist;
    ShapeColor shapeColor;

    public Sarsa_State() {
    }

    public Sarsa_State(ShapeForme shapeForme, ShapeDist shapeDist, ShapeColor shapeColor) {
        this.shapeForme = shapeForme;
        this.shapeDist = shapeDist;
        this.shapeColor = shapeColor;
    }

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void setShapeDist(ShapeDist shapeDist) {
        this.shapeDist = shapeDist;
    }

    public void setShapeType(ShapeForme shapeForme) {
        this.shapeForme = shapeForme;
    }

    public Color getAWTShapeColor() {
        Color couleurOfShape;
        switch (shapeColor) {
            case BLUE:
                couleurOfShape = Color.BLUE;
                break;
            case RED:
                couleurOfShape = Color.RED;
                break;
            case YELLOW:
                couleurOfShape = Color.YELLOW;
                break;
//            case GREEN:
//                couleurOfShape = Color.GREEN;
//                break;
//            case WHITE:
//                couleurOfShape = Color.WHITE;
//                break;
            default:
                couleurOfShape = Color.YELLOW;
                System.out.println(shapeColor);
        }
        return couleurOfShape;
    }

    public ShapeColor getShapeColor() {
        return shapeColor;

    }

    public ShapeDist getShapeDist() {
        return shapeDist;
    }

    public ShapeForme getShapeType() {
        return shapeForme;
    }

    public ShapeForme getShapeForme() {
        /*
        ShapeForme forme;
        switch (this.shapeType) {
        case CARRE:
        forme = ShapeForme.SQUARE;
        break;
        case ROND:
        forme = ShapeForme.CIRCLE;
        break;
        case TRIANGLE:
        forme = ShapeForme.TRIANGLE;
        break;
        case CURSOR:
        forme = ShapeForme.CURSOR;
        break;
        default:
        forme = ShapeForme.CIRCLE;
        }*/
        return ShapeForme.valueOf(shapeForme.toString());
    }

    @Override
    public String toString() {
        return "(" + getShapeColor() + "," + getShapeDist() + "," + getShapeType() + ")";
    }

    public String toHTML() {
        return "(<a COLOR=" + getShapeColor() + ">" + getShapeColor() + "</a>,<a>" + getShapeDist() + "," + getShapeType() + "</a>)";
    }
}
