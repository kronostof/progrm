/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package drawing.interfaceGraphique;

import myapp.Sarsa.Sarsa_Politique;

/**
 *
 * @author BOB
 */
public interface IRepresanteble_pour_stat{

    public Sarsa_Politique getpolicy();
    public String getNom();
    public String getdata();
}
