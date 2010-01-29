/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
package myapp.Sarsa;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.model.Shape;
import drawing.shape.VueForme.ShapeForme;


/* Une shape dans le monde des formes est l'agent.
 * C'est lui qui doit apprendre des interactions avec le regard de l'utilsateur
 * il est caractérisé par une association avec un objet de type State, fournit
 * par la classe SarsaStateFactory. Et possède une politique particuliere.
 * Il a également un algorithme d'apprentissage.
 *
 */
public class Sarsa_Shape extends Shape {

    private Sarsa_State state;
    private Sarsa_Politique politique = new Sarsa_Politique();
    //private MondeDesFormesMDP mdp = new MondeDesFormesMDP(0,1);
    //private LearningAlgorithm learningalgo = new Sarsa(mdp); // algo d'apprentissage
    //gestion du regard de l'utilisateur


    /**
     * Modifie l'état de la forme en l'unifiant a l'état passé en paramètre.
     *
     * @param state
     */
    public void setState(Sarsa_State state) {
        this.state = state;
        fire_StateChanged();
    }

    public Sarsa_Shape(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        int nbr_iteration = 0, Max_iteration = 10;
        try {
            sleep(1000);    // TODO: uniquement par manque de sychro => a virrer en gérant la syncro.
        } catch (InterruptedException ex) {
            Logger.getLogger(Sarsa_Shape.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO verbose => politique.affiche_politique();

        while (nbr_iteration++ < Max_iteration) {
            try {
                sleep(1000);
//                setState(politique.getNewState(this));
                setState(politique.getNextState(this));
            } catch (InterruptedException ex) {
                System.err.println("ERREUR dans Sarsa_Shape => " + ex);
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
}