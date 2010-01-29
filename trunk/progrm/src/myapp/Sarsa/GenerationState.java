package myapp.Sarsa;

/**
 *  Classe de teste uniquement presenté pour tester la g"neration de state.
 * @author Christophe Moncy 10304320
 */
public class GenerationState {

    public static void main(String[] args) {
        Sarsa_StateFactory sta = new Sarsa_StateFactory();

        System.out.println(Sarsa_StateFactory.listeDesEtat.size());
        System.out.println(Sarsa_StateFactory.listeDesActions.size());

        sta.affichage_listeDesEtat();
        sta.affichage_listeDesAction();
    }
}
