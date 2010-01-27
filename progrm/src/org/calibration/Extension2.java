package org.calibration;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Extension2 extends JFrame{
	private OuvrirSocket socket;

    
	public  Extension2(){
		super();
		this.setSize(1280/2, 1024/2);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		build();
		
	}
	
	public void build(){
		//this.setDefaultLookAndFeelDecorated(true);
		//this.setUndecorated(true);
		//this.setExtendedState(this.MAXIMIZED_BOTH);
	    this.setResizable(true);
	    this.setVisible(true);
	}
}
