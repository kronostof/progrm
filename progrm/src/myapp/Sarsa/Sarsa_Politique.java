package myapp.Sarsa;

//package org.myapp.model;
////import java.util.HashMap;
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import myapp.factory.Sarsa_ShapeFactory;
//
//
///*
// * @author ter Vincent Bonnier
// */
public class Sarsa_Politique {

//    //int size ;
//    //int[] elements =  {10,11,12,13,20,21,22,23,30,31,32,33};
//    //double[] quality;
    Map<Sarsa_State, Sarsa_Quality> HashQualityOfStates = new HashMap<Sarsa_State, Sarsa_Quality>();
//
//    int[][] QualityOfStates;
//

    public Sarsa_Politique() {
//        //on cré la hashTable qui contiendra les quality
        HashQualityOfStates = new Hashtable(Sarsa_StateFactory.getListeDesEtat().size());


        for (Sarsa_State state : Sarsa_StateFactory.getListeDesEtat()) {
            HashQualityOfStates.put(state, new Sarsa_Quality(Math.random()));
        }
    }

//    public double getQualityOfState(SARSA_State a_state) {
//        a_state.getState();
//    }
    public void setQualityOfState(Sarsa_State a_state, double q) {
        HashQualityOfStates.get(a_state).quality = q;
    }
    //public SARSA_State getBestState(SARSA_State currentState) {}

    /* fonction debug affiche les qualité des états dans le terminal */
    public void affiche_politique() {
        System.out.println("Affichage de la table de la politique");
        for (Sarsa_State a_State : HashQualityOfStates.keySet()) {
            System.out.println("|" + a_State + " \t| " + HashQualityOfStates.get(a_State) + "|");
        }

        for (Sarsa_Action a_action : Sarsa_StateFactory.getListeDesActions()) {
            System.out.println("|" + a_action);
        }
    }

    /**
     * retourne un nouvelle l'état
     * @param shape
     * @return
     */
    public Sarsa_State getNewState(Sarsa_Shape shape) {
        return Sarsa_ShapeFactory.stateFactory.get_Sarsa_State_aleatoire();
    }

    /**
     * retourne l'état dont la qualité est la meilleur
     * @param shape
     * @return
     */
    public Sarsa_State getBestState(Sarsa_Shape shape) {
        Sarsa_State good_state = shape.getSarsaState();
        double local_q = HashQualityOfStates.get(good_state).quality;

        for (Sarsa_State a_state : Sarsa_StateFactory.getListeDesEtat()) {
            if (local_q < HashQualityOfStates.get(a_state).quality) {
                good_state = a_state;
            }
        }

//        System.out.println(local_q + " " + good_state);
        return good_state;
    }

    /**
     * Renvoi
     * @param shape
     * @return
     */
    public Sarsa_State getNextState(Sarsa_Shape shape) {
        //on construit une liste des état accessible
        ArrayList<Sarsa_State> liste = getArray_of_NextState(shape);
        return liste.get((int) Math.rint(Math.random() * (liste.size()-1)));
    }

    /**
     * Retourne une liste des états accesible parmit les état atteignable de l'état courant.
     * @param shape
     * @return
     */
    public ArrayList<Sarsa_State> getArray_of_NextState(Sarsa_Shape shape) {
        //on construit une liste des état accessible

        ArrayList<Sarsa_State> liste_etat = new ArrayList<Sarsa_State>();
        //System.out.println("construction de la liste " + shape.getSarsaState());
        for (Sarsa_Action action : Sarsa_StateFactory.getListeDesActions()) {
            if (action.state_1 == shape.getSarsaState()) {
                // on ajout a la liste
                liste_etat.add(action.state_2);
                //System.out.println("\t ajout a la liste " + action.state_2);
            }
        }
        return liste_etat;
    }
}
