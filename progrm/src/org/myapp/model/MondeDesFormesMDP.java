package org.myapp.model;

/**
 *
 * @author ter Vincent Bonnier
 */
public class MondeDesFormesMDP {
    int scale;    
    double gamma;
    
    int width;
    int height;
    int states;
    int[] actions;
    ProbabilityDistribution[] transitions; // pourquoi plusieurs ? 
    int[] directions;
    double[] rewards;
    double[] terminalValues;
    
     
    /** Creates a new instance of MazeMDP */
    public MondeDesFormesMDP(int scaleInit, double gammaInit) {
        scale = scaleInit;
        gamma = gammaInit;
        states = width * height; // le nombre d'états est le nombre de cases
        actions = new int[states]; 
        transitions = new ProbabilityDistribution[states * 4];
        // pour chq case quatre possibilité de déplacement
        rewards = new double[states * 4];
        directions = new int[states * 4];
        terminalValues = new double[states];
        
        setTerminalState(states - 1, 0);
    }
       
    public int getMaxActions() {
        int maxActions = 0;
        for (int state = getStates(); --state >= 0;)
        if (getActions(state) > maxActions)
            maxActions = getActions(state);
        return maxActions;
    }
    public void setTerminalState(int state, double value) {
        actions[state] = 0;                        
        terminalValues[state] = value;
    }
    
     
    public void setGamma(double newGamma) {
        gamma = newGamma;
    }

    /** discount factor */
    public double getGamma() {return gamma;}

    /** return the number of states */
    public int getStates() {return states;}

    /** return the number of actions
     *  @param state State for which the number of actions is returned
     */
    public int getActions(int state) {return actions[state];}
    
    /** reward obtained for performing given action in given state */
    public double getReward(int state, int action) {return rewards[4 * state + action];}
    
    /** value of states that do not have actions */
    public double getTerminalValue(int state) {return terminalValues[state];}
    
    /** return a list of potential next states with their probabilities */
    public ProbabilityDistribution getNextState(int state, int action) {return transitions[4 * state + action];}
}
