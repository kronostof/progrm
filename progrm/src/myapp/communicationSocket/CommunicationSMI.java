package myapp.communicationSocket;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.controle.MondeDesFormeController;
import myapp.flux.FluxPosition;
import myapp.model.Shape;
import myapp.factory.Sarsa_ShapeFactory;

/**
 * Classe assurant la comunication avec le système smi.<p>
 * Cette classe utilise une instance de la classe Client Udp permetant la communication a travers une socket
 * vers le materiel SMI.
 *
 * @author christophe Moncy p0304320
 */
public class CommunicationSMI extends Thread {

    private static int curent_cal_point = 0;

    public enum MODE {

        ENCALIBRATION,
        ENRECEPTION,
        NONE;
    }
    /**
     * Flux de positions récupérés a partir du matériel.<p>
     * En cas d'erreur de lecture a travers le matériel, la position sera initialisé a la valeur (-1;-1).
     */
    static FluxPosition fluxGazePosition = new FluxPosition();
    /** Indique le nombre d'instance de la classe en cours d'xecution.   */
    static int nombre_instance_en_cours = 0;
    static private ClientUdp client = null;
    // faire passer la valeur de cette variable entre vrai et faux règle pas mal de probleme
    static public boolean ERREUR_COMMUNICATION_SMI = false;
    private static boolean BRK = false;
    public static MODE mode;
    public static String chaine;
    private static Shape cursor;

//    public static String getMessageCalibration() {
//        return client.messageCalibration.toString() + "";
//    }
//
//    public static String getMessage() {
//        return client.message.toString();
//    }
    public static void setMode(String str_mode) {
        inti_SMI();
        mode = MODE.valueOf(str_mode);
        ASLEEP = true;
    }
    private static boolean ASLEEP = true;

    /**
     * Constructeur Unique de la classe.
     */
    public CommunicationSMI() {
        System.out.println("   public CommunicationSMI() \n voir initialisation de la variable <ERREUR_COMMUNICATION_SMI>");

        inti_SMI();

        // si
        if (ERREUR_COMMUNICATION_SMI == false) {
            client.write(new String("ET_FRM \"%SX %SY \""));
            client.write(new String("ET_STR \n\r"));

        }
        this.start();
    }

    static void inti_SMI() {
        try {
            if (client == null) {
                nombre_instance_en_cours++;
                fluxGazePosition = new FluxPosition();
                client = new ClientUdp();
                client.write(new String("ET_FRM \"%SX %SY\" \n\r"));

            }
        } catch (SocketException ex) {
            System.err.println("package org.myapp.communicationSocket  =>  static init_SMI() \n : une instance de ce  programme est en cour d'execution ?");
            ERREUR_COMMUNICATION_SMI = true;
//        } catch (UnknownHostException ex) {
//            System.err.println("package org.myapp.communicationSocket\n|public CommunicationSMI()\n : Erreur : l'adresse de l'hote est inconu du systeme");
//            ERREUR_COMMUNICATION_SMI = true;
        }
        mode = MODE.NONE;
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
            nombre_instance_en_cours++;
            while (true) {
                System.out.println("On est en MODE " + mode);
                switch (mode) {
                    case ENCALIBRATION:
                        System.out.println("MODE ENCALIBRATION");
                        client.write(new String("ET_CAL" + "\n\r"));
                        //client.receive();
                        //client.write(new String("ET_EST" + "\n\r"));
                        System.out.println("STREAMM OFFFFFFFFFFFFFFFFFFFFFFFFFFFn");
                        while (mode == MODE.ENCALIBRATION) {
                            client.receive();
                            cursor.setPosition(client.getCalPointPosition());
                        }
                        System.out.println("STREAMM ONNNNNNNNNNNNNNNNNNNNNNNn");
                        MondeDesFormeController.stopCalibration();

                        break;
                    case ENRECEPTION:
//                        if (ERREUR_COMMUNICATION_SMI == false) {
//                            client.write(new String("ET_FRM \"%SX %SY\" \n\r"));
//                            client.write(new String("ET_STR \n\r"));
                        while (ASLEEP) {
                            client.receive();
                            fluxGazePosition.set(client.getGazeposition());
                            if (BRK) {
                                BRK = false;
                                break;
                            }
                        }
//                        }
                        break;
                    default:
                        while (ASLEEP) {
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CommunicationSMI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (BRK) {
                                BRK = false;
                                break;
                            }
                        }
                        break;

                }
                // TODO: Pour une version ultérieur, il sera possible de sortir de cette boucle proprement, de gérer le nombre d'instance,...
                //nombre_instance_en_cours--;
            }
        }
        System.out.println("AA");
    }

    static void setENCALIBRATION(boolean b) {
        if (b) {
            mode = MODE.ENCALIBRATION;
        } else {
            mode = MODE.NONE;
        }
    }

    public static void startCalibration() {
        curent_cal_point = 0;
        if (cursor == null) {
            cursor = Sarsa_ShapeFactory.createShape(Sarsa_ShapeFactory.ShapeType.STAND);
        }
        setENCALIBRATION(true);
        BRK = true;
    }

    public static void stopCalibration() {
        setENCALIBRATION(false);
        mode = MODE.ENRECEPTION;

    }
}
