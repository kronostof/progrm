/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Sarsa;

import drawing.shape.VueForme.ShapeForme;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import myapp.Sarsa.Sarsa_State.*;

/**
 * L'implementation se base en partie sur le Document <p>
 * Formulaire d’apprentissage par renforcement
 * Rémi Coulom
 * 14 novembre 2008
 * On s'attachera a implementé les élément en suivant la même terminologie.

 * @author Christophe Moncy 10304320
 */
public class Sarsa_StateFactory {

    static public ArrayList<Sarsa_State> Ensemble_Des_Etats = new ArrayList<Sarsa_State>();
    static public ArrayList<Sarsa_Action> Ensemble_Des_Actions = new ArrayList<Sarsa_Action>();
    //static public ArrayList<ArrayList<Sarsa_Action>> Ensemble_Des_Ensemble_D_Actions_NEW = new ArrayList<ArrayList<Sarsa_Action>>();
    static public HashMap<Sarsa_State,ArrayList<Sarsa_Action>> CoupleStateActions = new HashMap<Sarsa_State, ArrayList<Sarsa_Action>>();

    static double goodToGo = 0;
    private boolean bool_Generer_tout_les_etats = false;
    private boolean bool_Generer_tout_les_action = false;
    ShapeForme shapeForme;
    ShapeDist shapeDist;
    ShapeColor shapeColor;

    public Sarsa_StateFactory() {
        Generer_tout_les_etats();
        Generer_toutes_les_action();
        goodToGo = 1;
    }

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_tout_les_etats() {
        if (bool_Generer_tout_les_etats == true) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() doit être appelle une unique fois");
        } else {

            for (ShapeColor Shape_c : ShapeColor.values()) {
                for (ShapeForme Shape_t : ShapeForme.values()) {
                    for (ShapeDist Shape_d : ShapeDist.values()) {
                        Ensemble_Des_Etats.add(new Sarsa_State(Shape_t, Shape_d, Shape_c));
                    }
                }
            }
            bool_Generer_tout_les_etats = true;
        }
    }

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_toutes_les_action() {
        char[] test = new char[1];
        ArrayList<Sarsa_Action> _liste_d_action_par_etat;
        Sarsa_State temp = null;
        if (bool_Generer_tout_les_action == true) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_toutes_les_action() doit être appelle une unique fois");
        } else {
            bool_Generer_tout_les_action = true;
            Field[] fields = Sarsa_State.class.getDeclaredFields();

            for (Sarsa_State sarsa_State : Ensemble_Des_Etats) {
                _liste_d_action_par_etat = new ArrayList<Sarsa_Action>();
                for (Field field : fields) {
                    for (Field field1 : field.getType().getDeclaredFields()) {
                        field1.getName().getChars(0, 1, test, 0);
                        if (test[0] != '$') {
                            // on construit les action posible pour chaque états.
                            if (field.getType().getSimpleName().compareTo("ShapeForme") == 0) {
                                temp = trouverEtat(sarsa_State.shapeForme.valueOf(field1.getName()), sarsa_State.getShapeDist(), sarsa_State.getShapeColor());
                            } else if (field.getType().getSimpleName().compareTo("ShapeDist") == 0) {
                                temp = trouverEtat(sarsa_State.getShapeType(), sarsa_State.shapeDist.valueOf(field1.getName()), sarsa_State.getShapeColor());
                            } else if (field.getType().getSimpleName().compareTo("ShapeColor") == 0) {
                                temp = trouverEtat(sarsa_State.getShapeType(), sarsa_State.getShapeDist(), sarsa_State.shapeColor.valueOf(field1.getName()));
                            }
                            if (sarsa_State != temp && temp != null) {
                                Ensemble_Des_Actions.add(new Sarsa_Action(field1, sarsa_State, temp));
                                _liste_d_action_par_etat.add(Ensemble_Des_Actions.get(Ensemble_Des_Actions.size() - 1));
                            }
                        }
                    }
                }
               
                CoupleStateActions.put(sarsa_State, _liste_d_action_par_etat);
            }
        }
    }

    public void affichage_listeDesEtat() {

        if (bool_Generer_tout_les_etats == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() n'a pas encore été appellé");
        } else {

            System.out.println("il y a " + Ensemble_Des_Etats.size() + " états possible");
            for (Sarsa_State sarsa_State : Ensemble_Des_Etats) {
                System.out.println(sarsa_State);
            }
        }
    }

    public void affichage_listeDesAction() {

        if (bool_Generer_tout_les_action == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void actions() n'a pas encore été appellé");
        } else {
            System.out.println("il y a " + Ensemble_Des_Actions.size() + " action possible");
            for (Sarsa_Action sarsa_Action : Ensemble_Des_Actions) {
                System.out.println(sarsa_Action);
            }
        }
    }

    /**
     *  Renvoi un états complètement aléatoire.
     * @return
     */
    public static Sarsa_State get_Sarsa_State_aleatoire() {
        int rnd = 0;
        do {
            float random = ((float) Math.random()) * ((float) Ensemble_Des_Etats.size());
            float roundRandom = (float) Math.round(random);
            rnd = Math.round(roundRandom);
        } while (rnd >= Ensemble_Des_Etats.size());
        return Ensemble_Des_Etats.get(rnd);
//        return listeDesEtat.get(Math.round((float) Math.random() * listeDesEtat.size()));
    }

    /**
     * La liste de toutes les actions.
     * @return
     */
    public static ArrayList<Sarsa_Action> getListeDesActions() {
        return Ensemble_Des_Actions;
    }

    /**
     * La liste de tous les états.
     * @return
     */
    public static ArrayList<Sarsa_State> getListeDesEtat() {
        return Ensemble_Des_Etats;
    }

    public static double isGoodToGo() {
        return goodToGo;
    }

    private Sarsa_State trouverEtat(ShapeForme shapeForme, ShapeDist shapeDist, ShapeColor shapeColor) {
        for (Sarsa_State rch_state : Ensemble_Des_Etats) {
            if (shapeColor == rch_state.getShapeColor()
                    && shapeDist == rch_state.getShapeDist()
                    && shapeForme == rch_state.getShapeType()) {
                return rch_state;
            }
        }
        System.err.println("ON NE DREVRAI JAMAIS PASSER PAR LA !");
        return null;
    }
}
