package org.lamia.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.myapp.Lecteur;
import org.myapp.event.Position;
import org.myapp.flux.FluxPosition;

public class RecevoirData extends Thread {

    FluxPosition fluxposition;
    Position pos = new Position();
    byte[] buffer = new byte[1024];
    String ch;
    DatagramPacket p = new DatagramPacket(buffer, buffer.length);
    DatagramSocket socket;
    private Lecteur loc;
    int posX = 0;
    int posY = 0;

    public RecevoirData(DatagramSocket socket, FluxPosition fluxdata) {
        System.out.println("RecevoirData(DatagramSocket socket, FluxPosition fluxdata)");
        this.socket = socket;
        fluxposition = fluxdata;
    }

    @Override
    public void run() {
        System.out.println("public class RecevoirData extends Thread ");
        while (true) {

            try {
                socket.receive(p);
                sleep(0);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ch = new String(buffer, 0, p.getLength());
            try {
                Send send = new Send("ET_CHG" + "\n" + "\r", socket);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.out.println(ch);
            if ((ch.substring(0, 6)).equals("ET_SPL")) {
                String[] results = ch.split("#\\s*");
                String[] right = results[1].split(" \\s*");
                String[] left = results[2].split(" \\s*");
                posX = (int) Float.valueOf(right[0]).floatValue();
                posY = (int) Float.valueOf(left[0]).floatValue();

                fluxposition.data.set(posX, posY);
                System.out.println("position X = " + posX + " position Y = " + posY);
            }
        }
    }
}
