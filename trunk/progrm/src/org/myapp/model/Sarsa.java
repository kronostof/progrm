/*
 * Sarsa.java
 *
 * Created on 28 novembre 2004, 22:21
 */

package org.myapp.model;

/**
 *
 * @author  mimi
 */
public class Sarsa extends LearningAlgorithm {
    private ActionValueTable Q;
    private ActionValueTable e;
    private MondeDesFormesMDP mdp;
    
    /** Creates a new instance of Sarsa */
    public Sarsa(MondeDesFormesMDP mdpInit) {
        mdp = mdpInit;
        Q = new ActionValueTable(mdp);
        e = new ActionValueTable(mdp);
        reset();
        newTrial();
    }
    
    public void reset() {
        Q.reset();
    }
    
    public void newTrial() {
        e.reset();
    }
    
    public double step(int state,
                     int action,
                     double reward,
                     int nextState,
                     int nextAction) {
        e.multiply(lambda * mdp.getGamma());
        if (replacingTraces)
            e.setValue(state, action, 1.0);
        else
            e.add(state, action, 1.0);
        double delta = reward +
                       mdp.getGamma() * Q.getActionValue(nextState, nextAction) -
                       Q.getActionValue(state, action);
        Q.add(learningRate * delta, e);
        
        return delta;
    }
    
    public double terminalStep(int state, int action, double reward, double terminalValue) {
        e.multiply(lambda * mdp.getGamma());
        if (replacingTraces)
            e.setValue(state, action, 1.0);
        else
            e.add(state, action, 1.0);
        double delta = reward + mdp.getGamma() * terminalValue - Q.getActionValue(state, action);
        Q.add(learningRate * delta, e);
        
        return delta;
    }
    
    public ValueFunction getValueFunction() {
        return Q;
    }
    
    public ValueFunction getEligibilityTraces() {
        return e;
    }
    
}
