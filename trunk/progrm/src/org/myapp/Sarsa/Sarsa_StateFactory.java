/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myapp.Sarsa;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.myapp.Sarsa.Sarsa_State.*;

/**
 *
 * @author Christophe Moncy 10304320
 */
public class Sarsa_StateFactory {

    Map<Integer, Sarsa_State> listeDesEtat = new HashMap<Integer, Sarsa_State>();
    Map<Integer, Sarsa_Action[]> listeDesActions = new HashMap<Integer, Sarsa_Action[]>();
    private boolean bool_Generer_tout_les_etats = false;
    private boolean bool_Generer_tout_les_action = false;
    ShapeType shapeType;
    ShapeDist shapeDist;
    ShapeColor shapeColor;
    //chk action
    Sarsa_State temp;

    public Sarsa_StateFactory() {
    }

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_tout_les_etats() {
        if (bool_Generer_tout_les_etats) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() doit être appelle une unique fois");
        } else {

            int id = 0;
            Sarsa_State etat_temp;
            for (ShapeType Shape_t : ShapeType.values()) {
                for (ShapeDist Shape_d : ShapeDist.values()) {
                    for (ShapeColor Shape_c : ShapeColor.values()) {
                        etat_temp = new Sarsa_State();
                        // On affecte les valeur de l'état que l'on va ajouter
                        etat_temp.setShapeColor(Shape_c);
                        etat_temp.setShapeDist(Shape_d);
                        etat_temp.setShapeType(Shape_t);

                        listeDesEtat.put(id++, etat_temp);
                    }
                }
            }

        }
    }

    public void affichage_listeDesEtat() {

        if (bool_Generer_tout_les_etats == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() n'a pas encore été appellé");
        }

        for (Sarsa_State sarsa_State : listeDesEtat.values()) {
            System.out.print(sarsa_State.getShapeColor() + " ");
            System.out.print(sarsa_State.getShapeDist() + " ");
            System.out.print(sarsa_State.getShapeType() + " ");
            System.out.println(" ");
        }
    }

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_toutes_les_action() {

        if (bool_Generer_tout_les_action) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_toutes_les_action() doit être appelle une unique fois");
        } else {

            Field[] fields = Sarsa_State.class.getDeclaredFields();

            for (Sarsa_State sarsa_State : listeDesEtat.values()) {
                System.out.println("états : " + sarsa_State);
                for (Field field : fields) {
                    System.out.println("Traitement du champ " + field.getType().getSimpleName() + " | " + field.getName());
                    for (Field field1 : field.getType().getDeclaredFields()) {
                        System.out.println(" " + field1.getType().getSimpleName() + " | " + field1.getName());
                        // on construit les action posible pour chaque états.

                        // System.out.println(sarsa_State);
                        temp = new Sarsa_State();

                        temp.setShapeColor(sarsa_State.getShapeColor());
                        temp.setShapeDist(sarsa_State.getShapeDist());
                        temp.setShapeType(sarsa_State.getShapeType());

                        if (field.getType().getSimpleName().compareTo("ShapeType") == 0) {
                            if (sarsa_State.getShapeType().toString().compareTo(field1.getName()) != 0) {
                                //System.out.println("nouvelle action : action de " + sarsa_State.getShapeType() + " a " + field1.getName());
                                //System.out.println("champs de l' action : " + field1.getName());


                                temp.setShapeType(sarsa_State.shapeType.valueOf(field1.getName()));

                                System.out.println("nouvelle action :\n\tetat sur lequel cette action agit => (" + sarsa_State + ") vers (" + temp + ")");
                                //System.out.println(" : " + field1.getName());
                                //System.out.println("champs de l' action : " + field1.getName());
                            }
                        }
                        /*   if (field.getType().getSimpleName().compareTo("ShapeDist") == 0) {
                        System.out.println("nouvelle action : action de " + sarsa_State.getShapeDist() + " a " + field1.getName());
                        }
                        if (field.getType().getSimpleName().compareTo("ShapeColor") == 0) {
                        System.out.println("nouvelle action : action de " + sarsa_State.getShapeColor() + " a " + field1.getName());
                        }
                         * */

                    }
                }
            }
        }
    }

    public void affichage_listeDesAction() {

        if (bool_Generer_tout_les_etats == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() n'a pas encore été appellé");


        }

        for (Sarsa_State sarsa_State : listeDesEtat.values()) {
            System.out.print(sarsa_State.getShapeColor() + " ");
            System.out.print(sarsa_State.getShapeDist() + " ");
            System.out.print(sarsa_State.getShapeType() + " ");
            System.out.println(" ");

        }
    }
}
