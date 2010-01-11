/*
 * ActionValueFunction.java
 *
 * Created on 19 novembre 2004, 14:55
 */

package org.myapp.model;

/**
 *
 * @author  coulom
 */
public class ActionValueTable extends ValueFunction {
    int maxActions;
    double[] Q;
    
    public ActionValueTable(MondeDesFormesMDP mdpInit) {
        super(mdpInit);
        maxActions = mdp.getMaxActions();
        Q = new double[mdp.getStates() * maxActions];
    }
    
    public void setActionValue(int state, int action, double value) {
        Q[state * maxActions + action] = value;
    }
    
    public void reset() {
        for (int i = mdp.getStates() * maxActions; --i >= 0;) {
            Q[i] = 0;
        }
    }
    
    public double maxDiff(ActionValueTable avft) {
        double result = 0;
        for (int state = mdp.getStates(); --state >= 0;)
            for (int action = mdp.getActions(state); --action >= 0;) {
                int i = state * maxActions + action;
                double diff = Q[i] - avft.Q[i];
                if (diff < 0)
                    diff = -diff;
                if (diff > result)
                    result = diff;
            }
        return result;
    }
    
    public void multiply(double x) {
        for (int i = mdp.getStates() * maxActions; --i >= 0;)
            Q[i] *= x;
    }
    
    public void add(int state, int action, double x) {
        Q[state * maxActions + action] += x;
    }
    
    public void add(double x, ActionValueTable e) {
        for (int i = mdp.getStates() * maxActions; --i >= 0;)
            Q[i] += x * e.Q[i];
    }
    
    public void setValue(int state, int action, double x) {
        Q[state * maxActions + action] += x;
    }
    
    public double getActionValue(int state, int action) {
        return Q[state * maxActions + action];
    }
    
    public double getStateValue(int state) {
        if (mdp.getActions(state) == 0) {
            return mdp.getTerminalValue(state);
        }
        else {
            double result = getActionValue(state, 0);
            for (int action = mdp.getActions(state); --action > 0;)
                if (getActionValue(state, action) > result)
                    result = getActionValue(state, action);
            return result;
        }
    }
}