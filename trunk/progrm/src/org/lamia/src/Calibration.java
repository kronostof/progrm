package org.lamia.src;

import java.io.IOException;
import java.net.DatagramPacket;

public class Calibration extends Thread{
    byte[] buffer = new byte[1024]; 
	String msg_recu; 
	DatagramPacket p = new DatagramPacket(buffer, buffer.length); 
	OuvrirSocket socket;
	int compteur = 0;
	int xValeurs[] = {640, 64, 1216, 64 , 1216,	64 , 640, 1216,	640};
	int yValeurs[] = {512, 51, 51  , 973, 973 , 512, 51 , 512 , 973};
	int posX = xValeurs[compteur];
	int posY = yValeurs[compteur];
	Extention f1;
	CalibrationScreen cs;
	
	
	
	public Calibration(OuvrirSocket socket) {
		this.socket = socket;
		
	  }

	
	public void run(){
		
		f1= new Extention();
		cs= new CalibrationScreen(posX,posY);
		
		 while( true) {
			 try {
				sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			    
			    try {
					Send send = new Send("ET_CHG" +"\n" + "\r", socket);
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
		    	msg_recu = new String(buffer, 0, p.getLength()); 
		    	if((msg_recu.substring(0, 8)).equals("ET_CHG 1")) {
		    		 compteur = 0;
		    		 cs.set(posX,	posY);
		    		 cs.repaint();
		    		 f1.add(cs);
		    		 f1.repaint();
		    		 f1.setVisible(true);
		    		 f1.setDefaultLookAndFeelDecorated(true);
		    		 //f1.setUndecorated(true);
		    		 f1.setExtendedState(f1.MAXIMIZED_BOTH);
		    		 f1.setResizable(true);
		    	}
		    	
		        
		    	System.out.println(msg_recu);
		    	if((msg_recu.substring(0, 6)).equals("ET_ACC")){
		    		compteur++;
			    	posX = xValeurs[compteur];  
			    	posY = yValeurs[compteur];
			    	cs.set(posX, posY);
			    	cs.repaint();
					f1.add(cs);
					f1.repaint();
					f1.setVisible(true);
			    	System.out.println(compteur+" "+posX+" "+posY);      
		            
			    	
			    }
		    	if((msg_recu.substring(0, 8)).equals("ET_FIN 1")){
		    		f1.dispose();
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
