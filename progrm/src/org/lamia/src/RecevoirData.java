package org.lamia.src;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.myapp.event.Position;

public class RecevoirData {
	Position pos = new Position();
    byte[] buffer = new byte[1024]; 
	String ch; 
	DatagramPacket p = new DatagramPacket(buffer, buffer.length); 
	DatagramSocket socket; 
	
	public RecevoirData 	(DatagramSocket socket) {
		this.socket = socket;
	    Output thread = new Output();
	    
	    thread.start();
	    
	    while( thread.isAlive() ) {
	      
	    	try {
				socket.receive(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	ch = new String(buffer, 0, p.getLength()); 
	    	Lecteur loc = new Lecteur();
	    	float posX = 0;
	    	float posY = 0;
	    	pos.set(posX, posY); 
	    	loc.accroche(pos);
	    	if ((ch.substring(0, 6)).equals("ET_SPL")){
	    	String[] results = ch.split( "#\\s*" );
	    	String[] right = results[1].split( " \\s*" );
	    	String[] left = results[2].split( " \\s*" );
	    	posX = Float.valueOf(right[0]).floatValue();  
	    	posY = Float.valueOf(left[0]).floatValue();
	    	System.out.println(
	    	//"Paquet recu : message = " + ch + 
	    	"position X = " + posX +
	    	" position Y = " + posY 		
	    	//"\n - envoyeur = " + 
	        //p.getAddress().getHostName()+
	    	//"\n - port = " + p.getPort()
	        );
	    	}
	      try {
	        
	        Thread.sleep(0);
	      }
	      catch (InterruptedException ex) {}
	    }
	  }

	
	}