package org.lamia.src;

import java.io.*;
import java.net.*;


public class testsocket
{
  final static int taille = 1024;
  static byte buffer[] = new byte[taille];
  static	int length; //= a.length();
  static InetAddress serveur;   

 public static void main(String argv[]) throws Exception
 {
	 
  OuvrirSocket socket = new OuvrirSocket();
  fenetre f = new fenetre(socket);
  f.setVisible(true);


    byte[] buffer = new byte[1024]; 
	String ch; 
	DatagramPacket p = new DatagramPacket(buffer, buffer.length); 
	while(true) { 
	socket.receive(p); 
	ch = new String(buffer, 0, p.getLength()); 
	

	System.out.println("Paquet recu : message = " + ch + 
	" - envoyeur = " + 
  p.getAddress().getHostName()+ 
	" - port = " + p.getPort()); 
	}
 
 		
 }


 

}	
