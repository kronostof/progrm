package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import org.FormeListener;

/**
 * @author duj
 *
 * 
 */
public interface IDrawable extends FormeListener{
	/**
	 * @pre: g!=null
	 * @post: configuration de g inchangée
	 */
	
	public abstract Point getPosition();
	public abstract void draw(Graphics g);

	/**
	 * @pre:
	 * @return le rectangle  qui contient complètement this.
	 */
	public abstract Rectangle getRectangle();
}