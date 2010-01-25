package org.myapp.Sarsa;

/**
 *  Classe de teste uniquement presenté pour tester la g"neration de state.
 * @author Christophe Moncy 10304320
 */
public class GenerationState {

    public static void main(String[] args) {
        Sarsa_StateFactory sta = new Sarsa_StateFactory();
        //sta.Generer_tout_les_etats();
        sta.affichage_listeDesEtat();
        System.out.println(sta.listeDesEtat.size());
        //sta.Generer_toutes_les_action();
        sta.affichage_listeDesAction();
        System.out.println(sta.listeDesActions.size());

    }
}
