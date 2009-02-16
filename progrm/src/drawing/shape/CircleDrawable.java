package drawing.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import org.FormeListener;
import org.myapp.event.Position;
import org.myapp.model.Shape;

import drawing.JCanvas;

/**
 * @author duj
 *
 * 
 */
public class CircleDrawable extends FormDrawable{

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 */
	static public JCanvas Vue;
	
	public CircleDrawable(Color color, Dimension dim) {
		super(color, new Point(), dim);
		//Vue.addDrawable(this);
	}
	
	public CircleDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
		//Vue.addDrawable(this);
	}

	public CircleDrawable(Color color, Position position, Dimension dim) {
		super(color, new Point(position.getPosX(),position.getPosY()), dim);
		Vue.addDrawable(this);
		
	}

	static public void set(JCanvas nVue){
		Vue = nVue;
	}
	/* (non-Javadoc)
	 * @see draw.Drawable#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

	@Override
	public void positionChangee(FormeListener FL) {
		//System.out.println("public class CircleDrawable extends FormDrawable");
		
		this.setPosition(((Shape)FL).getPosition().getPoint());
		// on fait un repaint de tt la vue et c est moche ! ! !
		Vue.repaint();
	}
	
	
	@Override
	public Point getPoint() {
		return getPosition();
	}
}