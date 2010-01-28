package org.myapp.communicationSocket;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.myapp.flux.FluxPosition;

/**
 * Classe assurant la comunication avec le système smi.<p>
 * Cette classe utilise une instance de la classe Client Udp permetant la communication a travers une socket
 * vers le materiel SMI.
 *
 * @author christophe Moncy p0304320
 */
public class CommunicationSMI extends Thread {

    /**
     * Flux de positions récupérés a partir du matériel.<p>
     * En cas d'erreur de lecture a travers le matériel, la position sera initialisé a la valeur (-1;-1).
     */
    static FluxPosition fluxGazePosition = new FluxPosition();
    /**
     * Indique le nombre d'instance de la classe en cours d'xecution.
     */
    static int nombre_instance_en_cours = 0;
    static private ClientUdp client = null;


    // faire passer la valeur de cette variable entre vrai et faux règle pas mal de probleme
    static boolean ERREUR_COMMUNICATION_SMI = true;

    /**
     * Constructeur Unique de la classe.
     */
    public CommunicationSMI() {
        System.out.println("   public CommunicationSMI() \n voir initialisation de la variable <ERREUR_COMMUNICATION_SMI>");

        try {
            if (client == null) {
                nombre_instance_en_cours++;
                fluxGazePosition = new FluxPosition();
                client = new ClientUdp();
                client.write(new String("ET_FRM \"%SX %SY\" \n\r"));
                this.start();
            }
        } catch (SocketException ex) {
            System.err.println("package org.myapp.communicationSocket\n|public CommunicationSMI()\n : Erreur de soquet");
            ERREUR_COMMUNICATION_SMI  = true;
        }
         catch (UnknownHostException ex) {
            System.err.println("package org.myapp.communicationSocket\n|public CommunicationSMI()\n : Erreur : l'adresse de l'hote est inconu du systeme");
            ERREUR_COMMUNICATION_SMI  = true;
        }
    }

    /**
     * @return Le Flux de position du regard recupéré du matériel.
     */
    public static FluxPosition getFlux() {
        if (ERREUR_COMMUNICATION_SMI) {
            System.err.println("La classe CommunicationSMI n'pas été correctement initialisé.");
            return null;
        }
        return fluxGazePosition;

    }

    @Override
    public void run() {
        if (nombre_instance_en_cours == 1) {

            while (true) {
                client.receive();
                fluxGazePosition.set(client.getGazeposition());
            }
            // TODO: Pour une version ultérieur, il sera possible de sortir de cette boucle proprement, de gérer le nombre d'instance,...
            //nombre_instance_en_cours--;
        }
    }
}
