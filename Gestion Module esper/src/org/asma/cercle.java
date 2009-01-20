package org.asma;
import java.awt.Graphics;

import javax.swing.JPanel;


public class cercle extends Forme{
	private Graphics g;
	public void draw(JPanel panel){
		g = panel.getGraphics();
		g.drawOval(10, 10, 10, 10);
	}
  
}
