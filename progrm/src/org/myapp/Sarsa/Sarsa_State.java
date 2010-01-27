package org.myapp.Sarsa;

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
    public enum ShapeType {
        TRIANGLE, ROND, CARRE
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
    
    public Color getAWTShapeColor() {
        Color couleurOfShape;
        switch(shapeColor) {
            case BLEUE :
                couleurOfShape = Color.BLUE;
                break;
            case ROUGE :
                couleurOfShape = Color.RED;
                break;
            case JAUNE :
                couleurOfShape = Color.YELLOW;
                break;
            default :
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

    public ShapeType getShapeType() {
        return shapeType;
    }

    @Override
    public String toString() {
        return "(" + getShapeColor() + "," + getShapeDist() + "," + getShapeType() + ")";
    }
}
