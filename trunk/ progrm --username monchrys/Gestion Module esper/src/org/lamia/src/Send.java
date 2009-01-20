package org.lamia.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Send {
	private final static int taille = 1024;
	private static byte buffer[] = new byte[taille];
	private static	int length;
	private static InetAddress serveur;														
	private String commande;
	private DatagramPacket dataSent;
	private DatagramSocket socket;
	
	

	public Send(String commande, DatagramSocket socket) throws IOException{
		this.commande = commande;
		length = commande.length();
		buffer = commande.getBytes();
		this.socket = socket;
	}

	public void sending() throws IOException {
		serveur = InetAddress.getByName("192.168.0.1");
		DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,4444);
		DatagramSocket socket = new DatagramSocket();
		socket.send(dataSent);
	}
}
