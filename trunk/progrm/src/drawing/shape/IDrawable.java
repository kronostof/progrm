package drawing.shape;

import org.FormeListener;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


/**
 * @author ter Christophe Moncy
 * 
 */
public interface IDrawable extends FormeListener{
  public abstract Point getPosition();
  public abstract void draw(Graphics g);
  /**
   * @pre:
   * @return le rectangle  qui contient complétement this.
   */
  public abstract Rectangle getRectangle();
}