package drawing.interfaceGraphique;

import myapp.Sarsa.Sarsa_Politique;

/**
 * Interface assurant la possibilité pour un objet d'être representé par la fenêtre de présentation de politique
 * @see FenetreDeStatistique
 * 
 * @author Christophe Moncy 10304320
 */
public interface IRepresanteble_pour_stat {

    /**
     * Récupère la politique de l'objet
     * @return
     */
    public Sarsa_Politique getpolicy();

    /**
     * Récupère une representation textuel courte ( principalement pour le label d'un bouton.
     * @return
     */
    public String getNom();
}
