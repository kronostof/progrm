package org.lamia.src;

import java.io.IOException;
import java.net.DatagramPacket;

public class VerificationCadre extends Thread{
	int posX;
	int posY;
	int last_x;
	int last_y;
	byte[] buffer = new byte[1024]; 
	String msg_recu; 
	DatagramPacket p = new DatagramPacket(buffer, buffer.length); 
	OuvrirSocket socket;
	Extension2 f1= new Extension2();
	Eyes eyes;

	
	public VerificationCadre(OuvrirSocket socket) {
		this.socket = socket;
		eyes = new Eyes();
		f1.add(eyes);
		
	  }
	
	public void run(){
		
		 while( true) {
			    try {
					Send send = new Send("ET_SPL" +"\n" + "\r", socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	try {
					socket.receive(p);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				try {
					sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	msg_recu = new String(buffer, 0, p.getLength()); 
		    	if (posX != 0 && posY != 0){
		    	last_x = posX;
		    	last_y = posY;
		    	}
		    	if((msg_recu.substring(0, 6)).equals("ET_SPL")) {
		    		String[] results = msg_recu.split( "#\\s*" );
			    	String[] right = results[1].split( " \\s*" );
			    	String[] left = results[2].split( " \\s*" );
			    	posX = (int) Float.valueOf(right[0]).floatValue();  
			    	posY = (int) Float.valueOf(left[0]).floatValue();
			    	System.out.println("position X = " + posX +" position Y = " + posY);
			    	eyes.setPos(posX,posY);
			    	eyes.repaint();
			    	f1.setVisible(true);
			    	
			    	if (posX == 0 && posY == 0){
			    		if (last_y>(1024-300) ){
			    			eyes.affiche_fleche_bas = true;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		else{
			    			eyes.affiche_fleche_bas = false;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		if (last_y<(100) ){
			    			eyes.affiche_fleche_haut = true;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		else{
			    			eyes.affiche_fleche_haut = false;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		if (last_x>(1280-100) ){
			    			eyes.affiche_fleche_droite = true;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		else{
			    			eyes.affiche_fleche_droite = false;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		if (last_x<(150) ){
			    			eyes.affiche_fleche_gauche = true;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    		else{
			    			eyes.affiche_fleche_gauche = false;
			    			eyes.repaint();
			    			f1.setVisible(true);
			    		}
			    	}
			    	else{
			    		 eyes.affiche_fleche_bas = false;
			    		 eyes.affiche_fleche_haut = false;
			    		 eyes.affiche_fleche_gauche = false;
			    		 eyes.affiche_fleche_droite = false;
			    		 eyes.repaint();
			    		 f1.setVisible(true);
			    	}

		    	}
		    	
		        
		    	
		    	if((msg_recu.substring(0, 8)).equals("ET_FIN 1")){
		    		//f1.dispose();
		    		//this.destroy();
		    	}
		    	
		    	/*try {
					sleep(1000);
					CalibrationScreen c = new CalibrationScreen(64, 51);
					f1.add(c);
					//f1.repaint();
					f1.setVisible(true);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		    	
		    	
		    }
	}
}
