/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Sarsa;

/**
 *
 * @author christophe Moncy p0304320
 */
class Sarsa_Quality {

    public double quality = 0;

    Sarsa_Quality(double q) {
        quality = q;
    }

     @Override
    public String toString() {
        return quality + "";
    }
}
