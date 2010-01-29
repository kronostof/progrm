package drawing.shape;

import java.awt.Point;
import java.util.EventListener;



public interface FormeListener extends EventListener{
	void positionChangee(FormeListener Fl);
	Point getPoint();
}
