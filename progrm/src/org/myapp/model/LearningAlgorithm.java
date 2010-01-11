/*
 * LearningAlgorithm.java
 *
 * Created on 28 novembre 2004, 22:17
 */

package org.myapp.model;

/**
 * tiré de package MDP de remi Coulom
 * Utilisé ici comme intéligence pour les formes
 * @author  mimi
 * @author ter Bonnier Vincent
 */
public abstract class LearningAlgorithm {
    protected double learningRate;
    protected double lambda;
    protected boolean replacingTraces;
    
    public LearningAlgorithm() {
        learningRate = 1.0;
        lambda = 1.0;
        replacingTraces = true;
    }
    
    public double getLearningRate() {
        return learningRate;
    }
    
    public void setLearningRate(double newLearningRate) {
        learningRate = newLearningRate;        
    }
    
    public double getLambda() {
        return lambda;
    }
    
    public void setLambda(double newLambda) {
        lambda = newLambda;
    }
    
    public void setReplacingTraces(boolean b) {
        replacingTraces = b;
    }
    
    public boolean getReplacingTraces() {
        return replacingTraces;
    }
    
    public abstract void reset();
    public abstract void newTrial();
    public abstract double step(int state,
                                int action,
                                double reward,
                                int nextState,
                                int nextAction);
    public abstract double terminalStep(int state,
                                        int action,
                                        double reward,
                                        double terminalValue);
    public abstract ValueFunction getValueFunction();
    public abstract ValueFunction getEligibilityTraces();
}
