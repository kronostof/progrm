package myapp.Sarsa;

/**
 *  Classe de teste uniquement presenté pour tester la g"neration de state.
 * @author Christophe Moncy 10304320
 */
public class GenerationState {

    public static void main(String[] args) {
        Sarsa_StateFactory sta = new Sarsa_StateFactory();

        System.out.println(Sarsa_StateFactory.Ensemble_Des_Etats.size());
        System.out.println(Sarsa_StateFactory.Ensemble_Des_Actions.size());

        sta.affichage_listeDesEtat();
        sta.affichage_listeDesAction();
    }
}
