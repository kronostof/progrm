package org.lamia.src;

import javax.swing.JFrame;

public class fenetreCalibration extends JFrame{
	private OuvrirSocket socket;
    private CalibrationScreen cs;  
	
	public  fenetreCalibration(OuvrirSocket socket){
		super();
		this.socket = socket;
		build();
		
	}
	
	public void build(){
		cs = new CalibrationScreen(socket);
		this.add(cs);
	    cs.setVisible(true);
	    this.add(cs);
	    this.setResizable(false);
	    this.setSize(500, 500);
	    this.setVisible(true);
	}
}
