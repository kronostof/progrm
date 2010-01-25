package org.myapp.Sarsa;

/**
 *
 * @author christophe Moncy p0304320
 */
public class Sarsa_State {

    // ShapeColor couleur (bleue, rouge, jaune)
    public enum ShapeColor {
        bleue, rouge, jaune
    }
    // ShapeDist distance au regard (proche, eloigné , neutre)
    public enum ShapeDist {
        proche, eloigne, neutre
    }

    // ShapeType forme (triangle, rond, carré)
    public enum ShapeType {
        triangle, rond, carré
    }
    /**
     * Liste des element constituant l'état
     */
    ShapeType shapeType;
    ShapeDist shapeDist;
    ShapeColor shapeColor;

    public void setShapeColor(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void setShapeDist(ShapeDist shapeDist) {
        this.shapeDist = shapeDist;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeColor getShapeColor() {
        return shapeColor;
    }

    public ShapeDist getShapeDist() {
        return shapeDist;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public String toString() {
        return getShapeColor() + " " + getShapeDist() + " " + getShapeType();
    }
}
