
package drawing.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import org.FormeListener;



public class RectangleDrawable extends FormDrawable{

	/**
	 * @param color
	 * @param pos
	 * @param dim
	 */
	public RectangleDrawable(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
		
	}

	/* (non-Javadoc)
	 * @see draw.Drawable#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(rect.x,rect.y,rect.height,rect.width);
		g.setColor(c);
	}

	@Override
	public void positionChangee(FormeListener Fl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPoint() {
		return getPosition();
	}
}