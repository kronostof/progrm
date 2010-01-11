/*
 * StateValueFunctionInterface.java
 *
 * Created on 19 novembre 2004, 14:34
 */

package org.myapp.model;

/**
 *
 * @author  coulom
 */
public abstract class ValueFunction {
    protected MondeDesFormesMDP mdp;
    
    public ValueFunction(MondeDesFormesMDP mdpInit) {
        mdp = mdpInit;
    }
    
    public abstract double getStateValue(int state);
    public abstract double getActionValue(int state, int action);
    
    public double getMaxStateValue() {
        double result = getStateValue(0);
        for (int state = mdp.getStates(); --state > 0;) {
            double V = getStateValue(state);
            if (V > result)
                result = V;
        }
        return result;
    }
    
    public double getMinStateValue() {
        double result = getStateValue(0);
        for (int state = mdp.getStates(); --state > 0;) {
            double V = getStateValue(state);
            if (V < result)
                result = V;
        }
        return result;        
    }
    
    public double getMaxActionValue() {
        double result = 0;
        boolean firstAction = true;
        for (int state = mdp.getStates(); --state >= 0;)
            for (int action = mdp.getActions(state); --action >= 0;) {
                double Q = getActionValue(state, action);
                if (firstAction) {
                    result = Q;
                    firstAction = false;
                }
                else if (Q > result)
                    result = Q;
            }
        return result;
    }
    
    public double getMinActionValue() {
        double result = 0;
        boolean firstAction = true;
        for (int state = mdp.getStates(); --state >= 0;)
            for (int action = mdp.getActions(state); --action >= 0;) {
                double Q = getActionValue(state, action);
                if (firstAction) {
                    result = Q;
                    firstAction = false;
                }
                else if (Q < result)
                    result = Q;
            }
        return result;
    }
}
