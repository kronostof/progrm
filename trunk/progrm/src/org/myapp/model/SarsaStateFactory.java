/*
 * SarsaStateFactory génère les états possibles du mondes des formes.
 *
 */
package org.myapp.model;

import java.awt.Color;
/*
 *  NOTHING :   0 : ne rien faire
 *  BLUE :      1 : bleu
 *  RED :       2 : rouge
 *  GREEN :     3 : vert
 *  HIDEN :     4 : invisible
 *  TRIANGE :   5 : triange
 *  RECTANGLE : 6 : rectangle
 * @author ter Vincent Bonnier
 */
public class SarsaStateFactory {

    // pour l'affichage graphique
    private Color couleur ;
    private ShapeType shapeType;
    public enum ShapeType { Gaze0, Type1, Type2, fuite0, Fuite1, Approche0, Approche1 }

    // Liste des états
    public static int table_state[] = {10,11,12,13,20,21,22,23,30,31,32,33};

    //color
    public static final int BLUE = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int HIDEN = 3;
    //forme
    public static final int TRIANGE = 10;
    public static final int RECTANGLE = 20;
    public static final int CIRCLE = 30;
    //comportement
    //public static final int NOTHING = 100;


    private int state; // shape + color
    private int color ;
    private int shape ;
    private int forme;

    public enum ShapeColor { BLUE, RED, GREEN, HIDDEN };
    public enum ShapeForme { TRIANGLE, RECTANGLE, CIRCLE};
    //public enum ShapeBehavior {NOTHING };

    public SarsaStateFactory() {
        // a red circle .
        forme = 3 ;
        couleur = Color.RED;

        // nouveau état
        shape = CIRCLE;
        color = BLUE ;
        setState();
    }

    public void setState() {
        state = shape + color; 
    }

    public ShapeType getType() { return this.shapeType; }
    public Color getColor() { return couleur; }
    public int getForme() { return forme; }
    public int getState() { return state; }

    /*
     * génère une liste de tout les états possible
     * utile pour construire la politique des formes
     * (10,11,12,13,20,21,22,23,30,31,32,33)
     */
    public static int[] getStates() {
        return table_state;
    }
}
