package drawing.shape;

import java.awt.Point;


public interface IMovableDrawable extends IDrawable{

	void setPosition(Point p);
	Point getPosition();

}
