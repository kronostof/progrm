/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myapp.communicationSocket;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christophe Moncy p0304320
 */
public class CommunicationSMI extends Thread {

    ClientUdp client = null;

    public CommunicationSMI() {

        try {
            if (client == null) {
                client = new ClientUdp();
                client.write(new String("ET_FRM \"%SX %SY\" \n\r"));
                this.start();
            }
        } catch (Exception ex) {
            System.err.println("package org.myapp.communicationSocket\n|public CommunicationSMI()\n : Erreur lors de la création de l'instance <client> de <ClientUdp>");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(CommunicationSMI.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.receive();
        }
    }

    public int[] getPosition() {
        return client.getPosition();
    }
}
