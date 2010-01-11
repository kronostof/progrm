/*
 * ProbabilityDistribution.java
 *
 * Created on 23 octobre 2004, 21:22
 */

package org.myapp.model;

/**
 * Le tableau représentant la politique.
 * @author  mimi
 */
public class ProbabilityDistribution { 

    int size; // taille des tableaux
    int[] elements; // les éléments (state)
    double[] probabilities; // les probabilités associé aux actions
 
    /** Creates a new instance of ProbabilityDistribution */
    public ProbabilityDistribution() {size = 0;}
    
    public final int getElements() {return size;}    
    public final int getElement(int i) {return elements[i];}    
    public final double getProbability(int i) {return probabilities[i];}
    
    /** Set the number of elements in the probability distribution */
    public final void setSize(int sizeInit) {
        size = sizeInit;
        elements = new int[size];
        probabilities = new double[size];
    }
    
    /** Set this probability distribution to one single deterministic element */
    public final void setDeterministic(int element) {
        setSize(1);
        elements[0] = element;
        probabilities[0] = 1.0;
    }
 
    /** Set element number i of the probability distribution */
    public final void set(int i, int element, double probability) {
        elements[i] = element;
        probabilities[i] = probability;
    }
    
    public final void setProbability(int i, double probability) {
        probabilities[i] = probability;
    }
    
    /** Select an element at random according to the distribution.Do not
        call this function if getElements() is zero.*/
    public final int select(java.util.Random rnd) {
        double x = rnd.nextDouble();
        for (int i = size; --i >= 0;) {
            x -= probabilities[i];
            if (x < 0)
                return elements[i];
        }
        return elements[0];
    }
}
