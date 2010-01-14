package org.myapp.model;
//import java.util.HashMap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;


/*
 * @author ter Vincent Bonnier
 */
public class Politique {
    //int size ;
    //int[] elements =  {10,11,12,13,20,21,22,23,30,31,32,33};
    //double[] quality;
    Map<Integer,Double> HashQualityOfStates = new HashMap<Integer, Double>();

    int[][] QualityOfStates;

    public Politique(int nbEtat) {
        //on cré la hashTable qui contiendra les quality
        HashQualityOfStates=new Hashtable(SARSA_State.getStates().length);

        for (int state : SARSA_State.getStates()) {
          double initialQuality = 0.5;
          HashQualityOfStates.put(state,initialQuality);
        }
        //ds qualityOfStates j'ai mes probabilité
    }


//    public double getQualityOfState(SARSA_State a_state) {
//        a_state.getState();
//    }
    public void setQualityOfState(SARSA_State a_state) {}
    //public SARSA_State getBestState(SARSA_State currentState) {}

    /* fonction debug affiche les qualité des états dans le terminal */
    public void PrintQualityOfStates() {
        for (Iterator<Integer> i = HashQualityOfStates.keySet().iterator() ; i.hasNext() ; ){
           System.out.println(i.next());
        }
    }

}
