package myapp.communicationSocket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.event.Position;

/**
 * Classe servant a la connexion au system SMI-X view.<p>
 *
 * La communication se fait en udp.<br>
 * Cette classe gère :<br>
 *      - l'ouverture et la fermeture des socket.<br>
 *      - la reception des paquet reçut.<br>
 *      - la mise a jour et la mise a dispositon des informations reçut.<br>
 *<br>
 * @author christophe Moncy 10304320
 */
public class ClientUdp extends DatagramSocket {// implements Runnable {

    /**  Addresse de la machine SMI    */
    private String hostname = "192.168.0.1";
    /**  Port d'écoute de la machine SMI     */
    private int port = 5555;
    private int portEcoute = 4444;
    private static DatagramSocket xviewSocket = null;
    private byte[] buffer = new byte[1024];
    private DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
    public String chaine_reçut = null;
    /** cette instance stoque les information relative au dernier message reçut  */
    private Message message = new Message();
    private Position position = new Position();
    private int sizeX, sizeY;
    private ArrayList<Position> CalibrationPoint = new ArrayList<Position>(12);
    private int currentCalPoint;
    private String zut = null;

    /**
     * Constructeur de la classe<p>
     * Initialise la connexion avec le systeme SMI. Effectue l'ouverture des sockets,
     *
     * @throws SocketException
     * @throws UnknownHostException
     */
    public ClientUdp() throws SocketException {
        if (xviewSocket == null) {
            // TODO: verbose            System.out.println("creation de socket pour reception");
            xviewSocket = (new DatagramSocket(port));
            for (int i = 0; i < CalibrationPoint.size(); i++) {
                CalibrationPoint.add(new Position());
            }
        }
    }

    @Override
    public synchronized void receive(DatagramPacket p) throws IOException {
        xviewSocket.receive(p);
    }

    /**
     * Effectue une unique lecture sur la socket uilisée. Les données lues sont ensuite accesible par la methode get message.
     * Si le message reçut est une possition de regard alors cette possition est rendu accessible par la methode get position.
     */
    public void receive() {

        try {
            receive(datagramPacket);
            chaine_reçut = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            message.set(chaine_reçut.substring(0, 6), chaine_reçut.substring(6));
            /// On met a jour les attribut de la classe conservant certaine information.

            if (message.getType() == Message.Type_de_message.ET_INF) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                System.out.println(chaine_reçut);
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_ACC) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                System.out.println("ACC");
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_SPL) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                position.set(
                        Integer.parseInt(
                        chaine_reçut.substring(6).split(" ")[1]),
                        Integer.parseInt(
                        chaine_reçut.substring(6).split(" ")[3]));
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_CAL) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                CommunicationSMI.setENCALIBRATION(true);
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_CHG) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                currentCalPoint = Integer.parseInt(chaine_reçut.substring(7, chaine_reçut.length() - 2)) - 1;
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_FIN) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                System.out.println("FIN CAL");
                CommunicationSMI.setENCALIBRATION(false);
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_CSZ) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                zut = new String(chaine_reçut.substring(7, chaine_reçut.length() - 2));
                setCalibrationArea(
                        Integer.parseInt(zut.split("\t")[0]),
                        Integer.parseInt(zut.split("\t")[1]));
                // </editor-fold>
            }
            if (message.getType() == Message.Type_de_message.ET_PNT) {
                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                zut = new String(chaine_reçut.substring(7, chaine_reçut.length() - 2));
                setCalibrationPointPosition(Integer.parseInt(zut.split(" ")[0]),
                        Integer.parseInt(zut.split(" ")[1].split("\t")[0]),
                        Integer.parseInt(zut.split(" ")[1].split("\t")[1]));
                // </editor-fold>
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        try {
            xviewSocket.close();
            xviewSocket = null;
        } catch (Exception e) {
            System.err.println("public void close()  " + e);
        }
    }

    public void write(String message) {
        try {
            xviewSocket.send(new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName(hostname), portEcoute));
        } catch (IOException ex) {
            System.err.println("Erreur: tentative d'envoi message " + message + " " + ex);
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Position getPosition() {
        return position;
    }

    /**
     * Renvoi la derniere position du regard récupéré.
     * @return
     */
    public Position getGazeposition() {
        return position;
    }

    private void setCalibrationArea(int parseInt, int parseInt0) {
        sizeX = parseInt;
        sizeY = parseInt0;
    }

    private void setCalibrationPointPosition(int i, int Xposition, int Yposition) {
        CalibrationPoint.add(new Position(Xposition, Yposition));
    }

    Position getCalPointPosition() {
        if (CalibrationPoint.size() == 0) {
            return new Position();
        }
        return CalibrationPoint.get(currentCalPoint);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }


}
