/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.Sarsa;

/**
 *
 * @author christophe Moncy p0304320
 */
/**
 * Classe representant la qualité d'un état et proposant des méthode permetant de les manipulé
 * @author Christophe Moncy 10304320
 */
public class Sarsa_Quality {

    public double quality = 0;
    protected double MIN_QUALITY = 0, MAX_QUALITY = 1;

    Sarsa_Quality(double q) {
        quality = q;
    }

    /**
     * Augmente la qualité sans quelle ne dépasse sa valeur max
     * @param _x
     */
    public void augmenter(double _x) {
        if (quality < 1) {
            quality += _x;
        }

    }

    /**
     * Diminue la qualité sans quelle ne dépasse sa valeur min
     * @param _x
     */
    public void diminuer(double _x) {
        if (quality > 0) {
            quality -= _x;
        }

    }

    @Override
    public String toString() {
        return quality + "";
    }
}
