package org.lamia.src;

import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Gestion ouverture fermeture
 * adresse ,port.
 * @author Silex
 *
 */
public class OuvrirSocket extends DatagramSocket{

	public OuvrirSocket() throws SocketException {
		super(5555);
		
	}

}
