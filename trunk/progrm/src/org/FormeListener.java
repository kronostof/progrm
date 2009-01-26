package org;

import java.awt.Color;
import java.awt.Graphics;
import java.util.EventListener;

import org.myapp.event.Position;

public class FormeListener implements EventListener {

	private Graphics g;
	
	
	public void draw(Position p){
	// la partie qui va effectuer le dessin
	g.setColor(Color.ORANGE);
	g.drawOval(p.getPosX(), p.getPosY(), 40, 50);
	}
}
