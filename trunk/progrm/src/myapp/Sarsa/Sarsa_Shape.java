/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
package myapp.Sarsa;

import drawing.interfaceGraphique.IRepresanteble_pour_stat;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.model.Shape;
import drawing.shape.VueForme.ShapeForme;
import myapp.communicationSocket.CommunicationSMI;

/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
public class Sarsa_Shape extends Shape implements IRepresanteble_pour_stat {


    private Sarsa_State state;
    private Sarsa_Politique politique = new Sarsa_Politique();
    private double alpha = 0.8;
    //private MondeDesFormesMDP mdp = new MondeDesFormesMDP(0,1);
    //private LearningAlgorithm learningalgo = new Sarsa(mdp); // algo d'apprentissage
    //gestion du regard de l'utilisateur

    /**
     * Modifie l'état de la forme en l'unifiant a l'état passé en paramètre.
     *
     * @param state
     */
    public void setState(Sarsa_State state) {
        if (state != null) {
            this.state = state;
            fire_StateChanged();
        }
    }

    public void setState() {
        for (Sarsa_State object : Sarsa_StateFactory.getListeDesEtat()) {
            if (object.getAWTShapeColor() == color
                    && shapeForme == object.getShapeForme()) {
                state = object;
                //System.out.println("etat trouvé " + state.toString());
            }
        }
    }

    public Sarsa_Shape(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        int nbr_iteration = 0, Max_iteration = 100000;

        //TODO il faut faire remonter cette partie au moins à la methode construisant les shape.
        while (Sarsa_StateFactory.goodToGo != 1 || state == null) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sarsa_Shape.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        politique.setEtatCourant(state);

        while (true) {
            while (!ASLEEP) {


                try {
                    sleep(40);
//                setState(politique.getNewState(this));

                    // ballance entre UN état suivant et LE meilleur etat suivant
//                if (Math.random() > alpha) {
//                    setState(politique.getNextState(this));
//                } else {
//                    setState(politique.getNextBetterState(this));
//                }

                    politique.modifieQuality(politique.getEtatCourant());
                } catch (InterruptedException ex) {
                    System.err.println("ERREUR dans Sarsa_Shape => " + ex);
                }
            }
            while (ASLEEP) {
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    System.err.println("ERREUR dans Sarsa_Shape => " + ex);
                }
            }

        }
    }


    /**
     * A chaque modification de l'état de la shape, cette methode doit etre appellé.
     */
    public void fire_StateChanged() {
        // On modifie les attribut de l'instance afin de représenter les valeur de l'état.(donc en fonction de l'état).
        this.color = get_from_State_Color(state);
        setForme(get_from_State_Forme(state));

        firePositionChangee();
    }

    /**
     * récupérer la couleur de la shape associé a un état.
     * @param state
     * @return
     */
    private Color get_from_State_Color(Sarsa_State state) {
        return state.getAWTShapeColor();
    }

    /**
     * * récupérer la forme de la shape associé a un état.
     * @param state état a parti
     * @return
     */
    private ShapeForme get_from_State_Forme(Sarsa_State state) {
        return state.getShapeForme();

    }

    /**
     * retourne l'état de la shape.
     * @return  état de la shape.
     */
    public Sarsa_State getSarsaState() {
        return state;
    }

    public Sarsa_Politique getpolicy() {
        return politique;
    }
}
