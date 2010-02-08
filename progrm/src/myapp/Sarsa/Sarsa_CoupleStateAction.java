/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Sarsa;

/**
 *
 * @author BOB
 */
class Sarsa_CoupleStateAction {

    private Sarsa_State state;
    private Sarsa_Action action;

    public Sarsa_CoupleStateAction(Sarsa_State state, Sarsa_Action action) {
        this.state = state;
        this.action = action;
    }

    public Sarsa_Action getAction() {
        return action;
    }

    public Sarsa_State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "s:" + state + " a:" + action;
    }



}
