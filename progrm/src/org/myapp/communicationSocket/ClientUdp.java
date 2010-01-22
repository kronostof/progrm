package org.myapp.communicationSocket;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.myapp.event.Position;

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
public class ClientUdp extends DatagramSocket implements Runnable {

// declaration section:
    /** 
     * Addresse de la machine SMI
     */
    private String hostname = "192.168.0.1";
    /**
     * port d'écoute de la machine SMI
     */
    private int port = 5555;
    private static DatagramSocket xviewSocket = null;
    private static DatagramSocket xviewSocketEnvoie = null;
    private byte[] buffer = new byte[1024];
    private DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
    private String chaine_reçut = null;
    private Message message = new Message();
    private Position position = new Position();


    
    /**
     * Constructeur de la classe<p>
     * Initialise la connexion avec le systeme SMI. Effectue l'ouverture des sockets,
     *
     * @throws SocketException
     * @throws UnknownHostException
     */
    public ClientUdp() throws SocketException, UnknownHostException {
        if (xviewSocket == null) {
            // TODO: verbose
            System.out.println("creation de socket pour reception");
            try {
                xviewSocket = (new DatagramSocket(5555));
            } catch (SocketException ex) {
                Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (xviewSocketEnvoie == null) {
            // TODO: verbose
            System.out.println("creation de socket pour emission");
            try {
                xviewSocketEnvoie = (new DatagramSocket(4444));
            } catch (SocketException ex) {
                xviewSocketEnvoie.connect(InetAddress.getByName("192.168.0.1"), 4444);
            }
        }
    }

    public Position getPosition() {
        return position;
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
            System.out.println("\n XXX<" + chaine_reçut+ ">XXX");

            /// On met a jour les attribut de la classe conservant certaine information.

            if (message.getType() == Message.Type_de_message.ET_SPL) {

                // <editor-fold defaultstate="collapsed" desc="Le Message reçut est décomposé et les informations pertinantes stockées dans la variable position">
                position.set(
                        Integer.parseInt(
                        chaine_reçut.substring(6).split(" ")[1]),
                        Integer.parseInt(
                        chaine_reçut.substring(6).split(" ")[3]));
                // </editor-fold>
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Récupere la derniere information en les stokant dans les instance passée en paramètre.
     * @param tête  instance stokant le type de message.
     * @param corps instance stokant le corps du message.
     * /
    public void getMessage(Message.Type_de_message tête, StringTokenizer corps) {
    message.read(tête, corps);
    }
     */
    public void run() {
        while (true) {
            receive();
        }
    }

    @Override
    public void close() {
        try {
            // clean up:
            // close the output stream
            // close the input stream
            // close the socket
            xviewSocket.close();
            xviewSocket = null;
            xviewSocketEnvoie.close();
            xviewSocketEnvoie = null;

        } catch (Exception e) {
            System.err.println("public void close()  " + e);
        }
    }

    public void write(String message) {
        DatagramPacket dataSent = null;
        try {
            dataSent = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("192.168.0.1"), 4444);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.send(dataSent);
        } catch (IOException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Renvoi la derniere position du regard récupéré.
     * @return
     */
    public Position getGazeposition() {
        return position;
    }
}
