package org.lamia.src;

import java.net.DatagramPacket;
import java.net.InetAddress;

import org.myapp.event.Position;


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

    Position pos = new Position();
    byte[] buffer = new byte[1024]; 
	String ch; 
	DatagramPacket p = new DatagramPacket(buffer, buffer.length); 
	while(true) { 
	socket.receive(p); 
	ch = new String(buffer, 0,0, p.getLength()); 
	Lecteur loc = new Lecteur();
	float posX = 0;
	float posY = 0;
	String[] results = ch.split( "#\\s*" );
    
	String[] right = results[1].split( " \\s*" );
	String[] left = results[2].split( " \\s*" );
	posX = Float.valueOf(right[0]).floatValue();  
	posY = Float.valueOf(left[0]).floatValue();
	pos.set(posX, posY); 
	loc.accroche(pos);
	System.out.println("Paquet recu : message = " + ch + 
	"position X = " + posX +
	" position Y = " + posY +		
	"\n - envoyeur = " + 
  p.getAddress().getHostName()+
	"\n - port = " + p.getPort());
	}
 
 		
 }


 

}	
