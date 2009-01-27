package org;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import drawing.IDrawable;

public class VueForme implements IDrawable,FormeListener {

	public VueForme(FormeListener forme) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void positionChangee(FormeListener FL) {
		System.out.println("TEST positionChangee() :public class VueForme");
		
	}

}
