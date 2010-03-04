package myapp;

import java.awt.MouseInfo;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import myapp.communicationSocket.CommunicationSMI;
import myapp.event.Position;
import myapp.flux.FluxPosition;

/**
 * Cette classe constitue le pré-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet dérivant de module)
 * et son ajout au evennement liste ( ajoutStatement() )
 *
 * La vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arrivée
 * elle rythme l'envoie de la requete de mise a jour des listener
 *
 * @author Moncy christophe
 *
 * Designe patern : SINGLETON
 */
public class Lecteur extends Thread {

    private static EPServiceProvider instance;
    private long vitesseDelecture = 20;
    private static FluxPosition fluxdata = null;
    private boolean boolEchecSocket = false;

    public Lecteur(FluxPosition position) {
        fluxdata = position;
        this.start();
    }

    public Lecteur() {
        
        new CommunicationSMI();
        CommunicationSMI.setMode("ENRECEPTION");
        if (CommunicationSMI.getFlux() == null) {
            System.out.println("le flux recupérer par le systeme smi est initialisé a null.");
            boolEchecSocket = true;
            fluxdata = new FluxPosition();
            this.start();
        } else {
            fluxdata = CommunicationSMI.getFlux();

        }
    }

    /**
     * Permet de recupérer le flux de donnée trouvée par le lecteur et de l'unifier avec le flux de position passé en paramètre.
     * @param flux_a_unifier
     */
    public static void accroche(FluxPosition flux_a_unifier) {
        flux_a_unifier.data = fluxdata.data;
    }

    @Override
    public void run() {
        if (boolEchecSocket) {
            System.out.println("L'initialisation aveec le système SMI a echoué.\nLa position du regard sera mappé sur le controleur de la souris.");
            while (true) {
                try {
                    liremouse();
                    sleep(vitesseDelecture);
                } catch (InterruptedException e) {
                    fluxdata.set(new Position(50, 50));
                    //e.printStackTrace();
                }
            }
        }
    }

    public static EPServiceProvider getInstance() {
        if (null == instance) {
            if (null == instance) {
                instance = EPServiceProviderManager.getDefaultProvider();
            }
        }
        return instance;
    }

    /**
     * Fonction utilisé en cas d'erreur lors de la tentative de conexion avec le système SMI.
     * @throws InterruptedException
     */
    private void liremouse() {
        fluxdata.data.set(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        fluxdata.data.upDate();
    }
}
