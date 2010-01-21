/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myapp.communicationSocket;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe servant a la connexion au system smi x view en singleton.
 * @author christophe Moncy 10304320
 */
public class ClientUdp extends DatagramSocket implements Runnable {

// declaration section:
    /**
     * Addresse de la machine SMI
     */
    String hostname = "192.168.0.1";
    /**
     * port d'écoute de la machine SMI
     */
    int port = 5555;
    private static DatagramSocket xviewSocket = null;
    private static DatagramSocket xviewSocketEnvoie = null;
    byte[] buffer = new byte[1024];
    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
    private String chaine_reçut = null;
    private Message message = new Message();
    int[] position = new int[2];

    @Override
    public synchronized void receive(DatagramPacket p) throws IOException {
        xviewSocket.receive(p);
    }

    public ClientUdp() throws SocketException, UnknownHostException {
        if (xviewSocket == null) {
            System.out.println("creation de socket pour reception");
            try {
                xviewSocket = (new DatagramSocket(5555));
            } catch (SocketException ex) {
                Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (xviewSocketEnvoie == null) {
            System.out.println("creation de socket pour emission");
            try {
                xviewSocketEnvoie = (new DatagramSocket(4444));
            } catch (SocketException ex) {
                //Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
                xviewSocketEnvoie.connect(InetAddress.getByName("192.168.0.1"), 4444);
            }
        }
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
            //System.out.println("\n XXX<" + chaine_reçut+ ">XXX");
           // System.out.println("<" + chaine_reçut + ">");
            /**
             * On met a jour les attribut de la classe conservant certaine information.
             */
            if (message.getType() == Message.Type_de_message.ET_SPL) {
                //System.out.println("\n XXX<" + chaine_reçut.substring(6).split(" ")[1] + " " + chaine_reçut.substring(6).split(" ")[3] + ">XXX");//.substring(6).split("#\\s*")[1]);
                position[0] = Integer.parseInt(chaine_reçut.substring(6).split(" ")[1]);
                position[1] = Integer.parseInt(chaine_reçut.substring(6).split(" ")[3]);
                System.out.println(" \n<" + position[0] + "> <" + position[1]+">");
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientUdp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Récupere la derniere information en les stokant dans les instance passée en paramètre.
     * @param tête  instance stokant le type de message.
     * @param corps instance stokant le corps du message.
     */
    public void getMessage(Message.Type_de_message tête, StringTokenizer corps) {
        message.read(tête, corps);
    }

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


        } catch (Exception e) {
            System.err.println("public void close()  " + e);
        }
    }

    public void write(String message) {
        // If everything has been initialized then we want to write some data
        // to the socket we have opened a connection to on port
        /*if (xviewSocketEnvoie != null) {
        try {
        System.out.println(xviewSocketEnvoie.getInetAddress() + " " + xviewSocketEnvoie.getPort());
        xviewSocketEnvoie.send(new DatagramPacket(message.getBytes(), message.length()));
        //xviewSocket.send(new DatagramPacket(message.toString().getBytes(), message.toString().length()));
        } catch (IOException e) {
        System.err.println("IOException:  " + e);

        }
        }
         */

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

    void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }
}
