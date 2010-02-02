package myapp.Sarsa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ArrayBlockingQueue;
import myapp.factory.Sarsa_ShapeFactory;


/*
 * @author ter Vincent Bonnier
 */
public class Sarsa_Politique extends Observable {

    Map<Sarsa_State, Sarsa_Quality> HashQualityOfStates = null;
    private Sarsa_State etatCourant = null;
    private int TAILLE_MAX_PILE_ETAT = 5;
    /** liste des dernier état atteint.    */
    public ArrayBlockingQueue<Sarsa_State> liste_état_récents = new ArrayBlockingQueue<Sarsa_State>(TAILLE_MAX_PILE_ETAT);
    /**
     * variable mega temporaire ! ! !
     */
    private double _x = 0;
    private double local_q;
    private int _i;

    /**
     * Constructeur
     */
    public Sarsa_Politique() {

        HashQualityOfStates = new Hashtable(Sarsa_StateFactory.getListeDesEtat().size());                                  //  On crée la hashTable qui contiendra les qualité
        for (Sarsa_State state : Sarsa_StateFactory.getListeDesEtat()) {
            //HashQualityOfStates.put(state, new Sarsa_Quality(0.5));
            HashQualityOfStates.put(state, new Sarsa_Quality(Math.random()/2));
        }
    }

    // AFFICHAGE
    /**
     * fonction debug affiche les qualité des états dans le terminal
     */
    public void affiche_politique() {
        System.out.println("Affichage de la table de la politique");
        for (Sarsa_State a_State : HashQualityOfStates.keySet()) {
            System.out.println("|" + a_State + " \t| " + HashQualityOfStates.get(a_State) + "|");
        }

        for (Sarsa_Action a_action : Sarsa_StateFactory.getListeDesActions()) {
            System.out.println("|" + a_action);
        }
    }

    // GETTER
    /**
     * renvoi l'état courant.
     * @return
     */
    public Sarsa_State getEtatCourant() {
        return etatCourant;
    }

    /**
     * retourne la qualité d'un état passe en paramètre.
     * 
     * @param a_state
     * @return
     */
    public double getQualityOfState(Sarsa_State a_state) {
        return HashQualityOfStates.get(a_state).quality;
    }

    /**
     * 
     * @return
     */
    public Map<Sarsa_State, Sarsa_Quality> getHashQualityOfStates() {
        return HashQualityOfStates;
    }

    /**
     * retourne un nouvelle l'état independament de la liste de état accessible.
     * @param shape
     * @return
     */
    public Sarsa_State getNewState() {
        setEtatCourant(Sarsa_ShapeFactory.stateFactory.get_Sarsa_State_aleatoire());
        return getEtatCourant();
    }

    /**
     * retourne l'état dont la qualité est la meilleur parmi tout les états.
     * @param shape
     * @return
     */
    public Sarsa_State getBestState(Sarsa_Shape shape) {
        Sarsa_State good_state = getEtatCourant();
        local_q = HashQualityOfStates.get(good_state).quality;

        for (Sarsa_State a_state : Sarsa_StateFactory.getListeDesEtat()) {
            if (local_q < HashQualityOfStates.get(a_state).quality) {
                good_state = a_state;
            }
        }
        setEtatCourant(good_state);
        return getEtatCourant();
    }

    /**
     * Renvoi un état suivant parmit les état accessible.
     * @param shape
     * @return
     */
    public Sarsa_State getNextState(Sarsa_Shape shape) {
        ArrayList<Sarsa_State> _liste = getArray_of_NextState(shape);
        setEtatCourant(_liste.get((int) Math.rint(Math.random() * (_liste.size() - 1))));
        return getEtatCourant();
    }

    /**
     * Retourne le meilleur état atteingnable a partir de l'état passé en paramètre.
     * @param shape
     * @return
     */
    public Sarsa_State getNextBetterState(Sarsa_Shape shape) {
        ArrayList<Sarsa_State> _liste = getArray_of_NextBetterState(shape);
        if (_liste.size() > 0) {


            do {
                _i = (int) (Math.random() * _liste.size());
            } while (HashQualityOfStates.get(_liste.get(_i)).quality < HashQualityOfStates.get(getEtatCourant()).quality);
            setEtatCourant(_liste.get(_i));
        }
        return getEtatCourant();
    }

    /**
     * Retourne le meilleur état atteingnable parmis une liste d'état passe en paramètre à partir de l'état passé en paramètre.
     * @param shape
     * @return
     */
    public Sarsa_State getNextBetterState(Sarsa_Shape shape, ArrayList<Sarsa_State> liste_de_state) {
        double q = 0;
        Sarsa_State bestState = liste_de_state.get(0);

        for (Sarsa_State sarsa_State : liste_de_state) {
            if (HashQualityOfStates.get(sarsa_State).quality > q) {
                bestState = sarsa_State;
                q = HashQualityOfStates.get(bestState).quality;
            }
        }
        return bestState;
    }

    /**
     * Retourne une liste de tous les états accesible parmit les états atteignable de l'état passé en argument.
     *
     * @param shape état a partir duquel on construit la liste d'état.
     * @return
     */
    //TODO: Construire une liste une fois pour toutes de toute les états atteignable pour chaque état.
    public ArrayList<Sarsa_State> getArray_of_NextState(Sarsa_Shape shape) {
        ArrayList<Sarsa_State> liste_etat = new ArrayList<Sarsa_State>();
        for (Sarsa_Action action : Sarsa_StateFactory.getListeDesActions()) {
            if (action.state_1 == shape.getSarsaState()) {
                liste_etat.add(action.state_2);
            }
        }
        return liste_etat;
    }

    /**
     * Retourne une liste de tous les états accesible de meilleur qualité parmis les états atteignables de l'état passé en argument.
     *
     * @param shape état a partir duquel on construit la liste d'état.
     * @return
     */
    public ArrayList<Sarsa_State> getArray_of_NextBetterState(Sarsa_Shape shape) {
        ArrayList<Sarsa_State> liste_etat = new ArrayList<Sarsa_State>();
        for (Sarsa_Action action : Sarsa_StateFactory.getListeDesActions()) {
            if (action.state_1 == shape.getSarsaState()
                    && HashQualityOfStates.get(getEtatCourant()).quality < HashQualityOfStates.get(action.state_2).quality) {
                liste_etat.add(action.state_2);
            }
        }
        return liste_etat;
    }

    public ArrayBlockingQueue<Sarsa_State> getListe_état_récent() {
        return liste_état_récents;
    }

    // SETTER
    /**
     * fixe la qualité de l'état passé en paramètre.
     * @param a_state
     * @param q
     */
    public void setQualityOfState(Sarsa_State a_state, double q) {
        HashQualityOfStates.get(a_state).quality = q;
    }

    /**
     * Effectuer un changement d'état.<p>
     * 
     * Le changement d'état doit passer par cette méthode.
     * Afin que les notifications soit faites au observeur.
     * Afin que la liste des états soit mise a jour.
     * @param etatCourant
     */
    public void setEtatCourant(Sarsa_State etatCourant) {
        this.etatCourant = etatCourant;
        if (liste_état_récents.size() >= TAILLE_MAX_PILE_ETAT) {
            liste_état_récents.poll();
        }
        liste_état_récents.add(etatCourant);
        //System.out.println(liste_état.toString());
        setChanged();
        notifyObservers();
    }

    /**
     * nom temporaire
     * si l état atteint est rond rouge on augment la qualitéé et c est cool.
     * @param state
     */
    void modifieQuality(Sarsa_State state) {
        if (Sarsa_State.ShapeColor.JAUNE == state.getShapeColor()
                && Sarsa_State.State_ShapeForme.ROND == state.getShapeType()
                && state.shapeDist == Sarsa_State.ShapeDist.NEUTRE) {
            _x = 0.001;
            for (Sarsa_State sarsa_State : liste_état_récents) {
                HashQualityOfStates.get(sarsa_State).augmenter(_x);
             //   System.out.println(sarsa_State + " " + HashQualityOfStates.get(sarsa_State).quality);
                _x += 0.001;
            }
           // System.out.println("_____________________");
            for (Sarsa_State sarsa_State : HashQualityOfStates.keySet()) {
                HashQualityOfStates.get(sarsa_State).diminuer(0.001);
            }
        }
    }

    public String get_liste_état_toString() {
        String _chaine = new String();
        for (Sarsa_State sarsa_State : liste_état_récents) {
            _chaine += sarsa_State + "<br>";
        }
        return _chaine;
    }
}
