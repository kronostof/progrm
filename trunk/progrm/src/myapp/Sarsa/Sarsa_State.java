package myapp.Sarsa;

import drawing.shape.VueForme.ShapeForme;
import java.awt.Color;

/**
 *
 * @author christophe Moncy p0304320
 */
public class Sarsa_State {

    // ShapeColor couleur (bleue, rouge, jaune)
    public enum ShapeColor {

        BLEUE, ROUGE, JAUNE
    }
    // ShapeDist distance au regard (proche, eloigné , neutre)

    public enum ShapeDist {

        PROCHE, ELOIGNE, NEUTRE
    }

    // ShapeType forme (triangle, rond, carré)
    public enum State_ShapeForme {

        TRIANGLE, ROND, CARRE
    }
    /**
     * Liste des element constituant l'état
     */
    State_ShapeForme shapeType;
    ShapeDist shapeDist;
    ShapeColor shapeColor;

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void setShapeDist(ShapeDist shapeDist) {
        this.shapeDist = shapeDist;
    }

    public void setShapeType(State_ShapeForme shapeType) {
        this.shapeType = shapeType;
    }

    public Color getAWTShapeColor() {
        Color couleurOfShape;
        switch (shapeColor) {
            case BLEUE:
                couleurOfShape = Color.BLUE;
                break;
            case ROUGE:
                couleurOfShape = Color.RED;
                break;
            case JAUNE:
                couleurOfShape = Color.YELLOW;
                break;
            default:
                couleurOfShape = Color.BLACK;
        }
        return couleurOfShape;
    }

    public ShapeColor getShapeColor() {
        return shapeColor;

    }

    public ShapeDist getShapeDist() {
        return shapeDist;
    }

    public State_ShapeForme getShapeType() {
        return shapeType;
    }

    public ShapeForme getShapeForme() {

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
            default:
                forme = ShapeForme.CIRCLE;
        }
        return forme;
    }

    @Override
    public String toString() {
        return "(" + getShapeColor() + "," + getShapeDist() + "," + getShapeType() + ")";
    }
}
