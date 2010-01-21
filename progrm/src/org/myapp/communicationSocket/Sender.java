package org.myapp.communicationSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author christophe Moncy p0304320
 */
public class Sender {


    public static Sender instance = new Sender();


    private int serverPort;
    private InetAddress serverAddress;

    public Sender() { //int serverPort, String serverAddress)
        this.serverPort = 4444;
        try {
            this.serverAddress = InetAddress.getByName("192.168.0.1");
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /*
    public void sendMessage(String message, String nameLocal, String to) throws SocketException, IOException {
    String msg = Util.MSG + Util.DELIM + nameLocal + Util.DELIM + to + Util.DELIM + message + Util.DELIM;
    send(msg);
    }

    public void sayHallo(int portLocal, String nameLocal) throws SocketException, IOException {
    String msg = Util.HELLO + Util.DELIM + portLocal + Util.DELIM + nameLocal + Util.DELIM;
    send(msg);
    }

     */
    private void send(String msg) throws SocketException, IOException {
        byte[] data = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, this.serverAddress, this.serverPort);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
    }
}
