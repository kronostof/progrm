/*
 * Created on Aug 19, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package drawing.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import drawing.GUIHelper;
import drawing.JCanvas;
import drawing.MoveDrawableMouseListener;
import drawing.shape.CircleDrawable;
import drawing.shape.IDrawable;
import drawing.shape.RectangleDrawable;


/**
 * @author duj
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DemoTestMouseMotionListener {
	
	public static void main(String[] args) {
			JCanvas jc = new JCanvas();
			jc.setBackground(Color.WHITE);
			jc.setPreferredSize(new Dimension(400,200));
			Dimension dim  =new Dimension(40,60);
			IDrawable rect = new RectangleDrawable(Color.RED,new Point(10,10),dim);
			IDrawable circle = new CircleDrawable(Color.BLUE,new Point(60,30),dim);
			jc.addDrawable(rect);
			jc.addDrawable(circle);
			new MoveDrawableMouseListener(jc);
			GUIHelper.showOnFrame(jc,"test JCanvas");
		}

}
