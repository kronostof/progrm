/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Sarsa;

import java.lang.reflect.Field;
import java.util.ArrayList;
import myapp.Sarsa.Sarsa_State.*;

/**
 *
 * @author Christophe Moncy 10304320
 */
public class Sarsa_StateFactory {

//    private static int bidon = init();
    static public ArrayList<Sarsa_State> listeDesEtat = new ArrayList<Sarsa_State>();
    static public ArrayList<Sarsa_Action> listeDesActions = new ArrayList<Sarsa_Action>();
    private boolean bool_Generer_tout_les_etats = false;
    private boolean bool_Generer_tout_les_action = false;
    State_ShapeForme shapeType;
    ShapeDist shapeDist;
    ShapeColor shapeColor;
    //chk action
    private Sarsa_State temp;
    //private Sarsa_Action[] temp_liste_action = null;
    //private int TAILLE_MAX_LISTE_ACTION = 4;
    private Sarsa_Action temp_Sarsa_Action;

    public Sarsa_StateFactory() {
        Generer_tout_les_etats();
        Generer_toutes_les_action();
    }

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_tout_les_etats() {
        if (bool_Generer_tout_les_etats == true) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() doit être appelle une unique fois");
        } else {
            bool_Generer_tout_les_etats = true;
            int id = 0;
            Sarsa_State etat_temp;
            for (State_ShapeForme Shape_t : State_ShapeForme.values()) {
                for (ShapeDist Shape_d : ShapeDist.values()) {
                    for (ShapeColor Shape_c : ShapeColor.values()) {
                        etat_temp = new Sarsa_State();
                        // On affecte les valeur de l'état que l'on va ajouter
                        etat_temp.setShapeColor(Shape_c);
                        etat_temp.setShapeDist(Shape_d);
                        etat_temp.setShapeType(Shape_t);

                        listeDesEtat.add(etat_temp);
                    }
                }
            }

        }
    }

    

    /**
     * Cette methode doit etre appellé une unique fois;
     */
    public void Generer_toutes_les_action() {
        char[] test = new char[1];
        if (bool_Generer_tout_les_action == true) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_toutes_les_action() doit être appelle une unique fois");
        } else {
            bool_Generer_tout_les_action = true;
            Field[] fields = Sarsa_State.class.getDeclaredFields();

            for (Sarsa_State sarsa_State : listeDesEtat) {// Pour chaque état
                //System.out.println("états : " + sarsa_State);
                // nouvelle liste d'action
                //temp_liste_action = new Sarsa_Action[TAILLE_MAX_LISTE_ACTION];
                for (Field field : fields) {// pour chaque champ de la forme
                    //System.out.println("\tTraitement du champ " + field.getType().getSimpleName() + " | " + field.getName());
                    for (Field field1 : field.getType().getDeclaredFields()) {
                        field1.getName().getChars(0, 1, test, 0);
                        if (test[0] != '$') {// On vire le champs dont la valeur commence par un $
                            //System.out.println("\t\t" + field1.getType().getSimpleName() + " | " + field1.getName());
                            // on construit les action posible pour chaque états.
                            temp = new Sarsa_State();

                            if (field.getType().getSimpleName().compareTo("State_ShapeForme") == 0) {
                                if (sarsa_State.getShapeType().toString().compareTo(field1.getName()) != 0) { // On vire le cas ou le champs est identique a celui de la forme
                                    temp.setShapeColor(sarsa_State.getShapeColor());
                                    temp.setShapeDist(sarsa_State.getShapeDist());
                                    temp.setShapeType(sarsa_State.shapeType.valueOf(field1.getName()));
                                    // on choppe l'état dont les champ corespondent.
                                    for (Sarsa_State rch_state : listeDesEtat) {
                                        if (temp.getShapeColor() == rch_state.getShapeColor()
                                                && temp.getShapeDist() == rch_state.getShapeDist()
                                                && temp.getShapeType() == rch_state.getShapeType()) {
                                            temp = rch_state;
                                            break;
                                        }
                                    }
                                    if (sarsa_State != temp) {
                                        if (temp == null) {
                                            System.err.println("    public void Generer_toutes_les_action() => temp est null :");
                                        } else {
                                            temp_Sarsa_Action = new Sarsa_Action();
                                            temp_Sarsa_Action.setChamps(field1);
                                            temp_Sarsa_Action.setState_1(sarsa_State);
                                            temp_Sarsa_Action.setState_2(temp);

                                            listeDesActions.add(temp_Sarsa_Action);
                                        }
                                    }
                                }
                            }
                            if (field.getType().getSimpleName().compareTo("ShapeDist") == 0) {
                                if (sarsa_State.getShapeType().toString().compareTo(field1.getName()) != 0) { // On vire le cas ou le champs est identique a celui de la forme
                                    temp.setShapeColor(sarsa_State.getShapeColor());
                                    temp.setShapeType(sarsa_State.getShapeType());
                                    temp.setShapeDist(sarsa_State.shapeDist.valueOf(field1.getName()));
                                    // on choppe l'état dont les champ corespondent.
                                    for (Sarsa_State rch_state : listeDesEtat) {
                                        if (temp.getShapeColor() == rch_state.getShapeColor()
                                                && temp.getShapeDist() == rch_state.getShapeDist()
                                                && temp.getShapeType() == rch_state.getShapeType()) {
                                            temp = rch_state;
                                            break;
                                        }
                                    }
                                    if (sarsa_State != temp) {
                                        if (temp == null) {
                                            System.err.println("    public void Generer_toutes_les_action() => temp est null :");
                                        } else {
                                            temp_Sarsa_Action = new Sarsa_Action();
                                            temp_Sarsa_Action.setChamps(field1);
                                            temp_Sarsa_Action.setState_1(sarsa_State);
                                            temp_Sarsa_Action.setState_2(temp);

                                            listeDesActions.add(temp_Sarsa_Action);
                                        }
                                    }
                                }
                            }
                            if (field.getType().getSimpleName().compareTo("ShapeColor") == 0) {
                                if (sarsa_State.getShapeType().toString().compareTo(field1.getName()) != 0) { // On vire le cas ou le champs est identique a celui de la forme
                                    temp.setShapeType(sarsa_State.getShapeType());
                                    temp.setShapeDist(sarsa_State.getShapeDist());
                                    temp.setShapeColor(sarsa_State.shapeColor.valueOf(field1.getName()));
                                    // on choppe l'état dont les champ corespondent.
                                    for (Sarsa_State rch_state : listeDesEtat) {
                                        if (temp.getShapeColor() == rch_state.getShapeColor()
                                                && temp.getShapeDist() == rch_state.getShapeDist()
                                                && temp.getShapeType() == rch_state.getShapeType()) {
                                            temp = rch_state;
                                            break;
                                        }
                                    }

                                    if (sarsa_State != temp) {
                                        if (temp == null) {
                                            System.err.println("    public void Generer_toutes_les_action() => temp est null :");
                                        } else {
                                            temp_Sarsa_Action = new Sarsa_Action();
                                            temp_Sarsa_Action.setChamps(field1);
                                            temp_Sarsa_Action.setState_1(sarsa_State);
                                            temp_Sarsa_Action.setState_2(temp);

                                            listeDesActions.add(temp_Sarsa_Action);
                                        }
                                    }
                                }
                            }


                        }
                    }
                }
            }
        }
    }


    public void affichage_listeDesEtat() {

        if (bool_Generer_tout_les_etats == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void Generer_tout_les_etats() n'a pas encore été appellé");
        } else {

            System.out.println("il y a " + listeDesEtat.size()+ " états possible");
            for (Sarsa_State sarsa_State : listeDesEtat) {
                System.out.println(sarsa_State);
            }
        }
    }
    
    public void affichage_listeDesAction() {

        if (bool_Generer_tout_les_action == false) {
            System.err.println("package org.myapp.factory;\npublic class StateFactory \nLa methode public void actions() n'a pas encore été appellé");
        } else {
            System.out.println("il y a " + listeDesActions.size()+ " action possible");
            for (Sarsa_Action sarsa_Action : listeDesActions) {
                System.out.println(sarsa_Action);
            }
        }
    }

    public Sarsa_State get_Sarsa_State_aleatoire() {
        //System.out.println(listeDesEtat.size());
        //Math.round demande un float
        //Math.round drenvoi un int
        //Math.random renvoi un double
        //listeDesEtat.size renvoi un int
        int rnd = 0;
        do {
            float random = ((float) Math.random()) * ((float) listeDesEtat.size());
            float roundRandom = (float) Math.round(random);
            rnd = Math.round(roundRandom);
//            System.out.println("rnd = " + rnd + " est ce que ça ira ?");
        } while (rnd >= listeDesEtat.size());

//        System.out.println("on demande dans listeDesEtat l'index : " +rnd);
        return listeDesEtat.get(rnd);
    }

    public static ArrayList<Sarsa_Action> getListeDesActions() {
        return listeDesActions;
    }

    public static ArrayList<Sarsa_State> getListeDesEtat() {
        return listeDesEtat;
    }
}
