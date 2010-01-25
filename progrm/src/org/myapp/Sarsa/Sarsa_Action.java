/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myapp.Sarsa;

import java.lang.reflect.Field;

/**
 *
 * @author christophe Moncy p0304320
 */
public class Sarsa_Action {

    /**
     * champ sur lequelle l'action agit.
     */
    Field champs = null;
    Sarsa_State state_1 = null;
    Sarsa_State state_2 = null;

    public Field getChamps() {
        return champs;
    }

    public Sarsa_State getState_1() {
        return state_1;
    }

    public Sarsa_State getState_2() {
        return state_2;
    }

    public void setChamps(Field champs) {
        this.champs = champs;
    }

    public void setState_1(Sarsa_State state_1) {
        this.state_1 = state_1;
    }

    public void setState_2(Sarsa_State state_2) {
        this.state_2 = state_2;
    }

    @Override
    public String toString() {
        return " De " + state_1 + " a " + state_2 + "";
    }
}
