package org.lamia.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;

public class CalibrationScreen extends JPanel implements MouseListener{
	private int x,y;
	private OuvrirSocket socket;
	private Send send;
	
	public CalibrationScreen(OuvrirSocket socket){
		super();
		this.socket = socket;
		this.setSize(500, 500);
		this.addMouseListener(this);
	}
	
	     // draw rectangles and Strings in different colors
	      public void paintComponent( Graphics g )
	      {
	         super.paintComponent( g ); // call superclass's paintComponent
	 
	         this.setBackground( new Color(0,10,100));
	        
	         g.setColor( Color.YELLOW );
	         g.fillOval( 20, 20, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 28, 28, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 240, 20, 20, 20);  
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 248, 28, 4, 4);
	               
	         g.setColor( Color.YELLOW );
	         g.fillOval( 460, 20, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 468, 28, 4, 4);
	       
	         g.setColor( Color.YELLOW );
	         g.fillOval( 20, 240, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 28, 248, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 20, 440, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 28, 448, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 460, 240, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 468, 248, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 240, 440, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 248, 448, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 460, 440, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 468, 448, 4, 4);
	         
	         g.setColor( Color.YELLOW );
	         g.fillOval( 240, 240, 20, 20);
	         g.setColor( new Color(0,10,100));
	         g.fillOval( 248, 248, 4, 4);
	 
	         this.repaint();
	         
	 
	       
	      }// end method paintComponent

	
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if (((x>= 20) && (x<= 40)) && ((y>= 20) && (y<= 40))){
 			try {
 				send = new Send("ET_PNT 2 64	51" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
		
        if (((x>= 240) && (x<= 260)) && ((y>= 20) && (y<= 40))){
 			try {
 				send = new Send("ET_PNT 7 640	51" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 460) && (x<= 480)) && ((y>= 20) && (y<= 40))){
 			try {
 				send = new Send("ET_PNT 3 1216	51" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 20) && (x<= 40)) && ((y>= 240) && (y<= 260))){
 			try {
 				send = new Send("ET_PNT 6 64	512" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 20) && (x<= 40)) && ((y>= 440) && (y<= 460))){
 			try {
 				send = new Send("ET_PNT 4 64	973" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 460) && (x<= 480)) && ((y>= 240) && (y<= 260))){
 			try {
 				send = new Send("ET_PNT 8 1216	512" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 240) && (x<= 260)) && ((y>= 440) && (y<= 460))){
 			try {
 				send = new Send("ET_PNT 9 640	973" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 460) && (x<= 480)) && ((y>= 440) && (y<= 460))){
 			try {
 				send = new Send("ET_PNT 5 1216	973" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
        if (((x>= 240) && (x<= 260)) && ((y>= 240) && (y<= 260))){
 			try {
 				send = new Send("ET_PNT 1 640	512" +"\n" + "\r", socket);
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			try {
 				send.sending();
 			} catch (IOException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			
		}
			
		 
	}
	public void mouseEntered(MouseEvent e) {
		
		 
	}
	public void mouseExited(MouseEvent e) {
		
		 
	}
	public void mouseReleased(MouseEvent e) {
		
		 
	}
	public void mousePressed(MouseEvent e) {
		
		 
	}
	
	

}
