package org.calibration;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class CalibrationScreen extends JPanel{
	private int x,y;
    private Polygon p;
	
	public CalibrationScreen(int x,int y){
		super();
        this.x =  x;
        this.y =  y;
	}
	
	public void set(int x,int y){
        this.x =  x;
        this.y =  y;
	}
	
	     // draw rectangles and Strings in different colors
	      public void paintComponent( Graphics g )
	      {
	         
	    	 this.repaint();
	    	 super.paintComponent( g ); // call superclass's paintComponent
	 
	         this.setBackground( new Color(0,10,100));
	         g.setColor( Color.yellow);
	         int valeursX[] = {x+40, x+2 , x+2, x-2, x-2, x-40, x-40, x-2, x-2,x+2, x+2, x+40};
	         int valeursY[] = {y+2, y+2, y+40, y+40, y+2, y+2 , y-2, y-2, y-40,y-40, y-2,y-2};
	         p = new Polygon(valeursX,valeursY,12);
             g.fillPolygon(p);
	         this.repaint();
	         
	 
	       
	      }// end method paintComponent

		

}

