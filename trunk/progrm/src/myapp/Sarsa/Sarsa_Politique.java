package myapp.Sarsa;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Observable;
import java.util.Stack;
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
    private ArrayBlockingQueue<Sarsa_State> liste_état = new ArrayBlockingQueue<Sarsa_State>(TAILLE_MAX_PILE_ETAT);

    /**
     * Constructeur
     */
    public Sarsa_Politique() {

        HashQualityOfStates = new Hashtable();                                  //  On crée la hashTable qui contiendra les qualité
        for (Sarsa_State state : Sarsa_StateFactory.getListeDesEtat()) {
            HashQualityOfStates.put(state, new Sarsa_Quality(0.5));
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
     * retourne l'état dont la qualité est la meilleur
     * @param shape
     * @return
     */
    public Sarsa_State getBestState(Sarsa_Shape shape) {
        Sarsa_State good_state = shape.getSarsaState();
        double local_q = HashQualityOfStates.get(good_state).quality;

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
        double q = 0;
        Sarsa_State bestState = getEtatCourant();

        for (Sarsa_State sarsa_State : getArray_of_NextState(shape)) {
            if (HashQualityOfStates.get(sarsa_State).quality > q) {
                bestState = sarsa_State;
            }
        }
        setEtatCourant(bestState);
        return getEtatCourant();
    }

    /**
     * Retourne une liste de tous les états accesible parmit les états atteignable de l'état passé en argument.
     *
     * @param shape état a partir duquel on construit la liste d'état.
     * @return
     */
    public ArrayList<Sarsa_State> getArray_of_NextState(Sarsa_Shape shape) {
        //on construit une liste des état accessible

        ArrayList<Sarsa_State> liste_etat = new ArrayList<Sarsa_State>();
        //System.out.println("construction de la liste " + shape.getSarsaState());
        for (Sarsa_Action action : Sarsa_StateFactory.getListeDesActions()) {
            if (action.state_1 == shape.getSarsaState()) {
                // on ajout a la liste
                liste_etat.add(action.state_2);
                //System.out.println("\t ajout a la liste " + action.state_2);
            }
        }
        return liste_etat;
    }

    public ArrayBlockingQueue<Sarsa_State> getListe_état() {
        return liste_état;
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
        if (liste_état.size() >= TAILLE_MAX_PILE_ETAT) {
            liste_état.poll();
        }
        liste_état.add(etatCourant);
        System.out.println(liste_état.toString());
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
                && Sarsa_State.State_ShapeForme.ROND == state.getShapeType()) {
            for (Sarsa_State sarsa_State : liste_état) {
                HashQualityOfStates.get(sarsa_State).quality += 0.05;
            }
        }
    }
}
