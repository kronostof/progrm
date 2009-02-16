package drawing.shape.type;

import java.awt.Graphics;

public class graphicsShapeTRIANGLE extends graphicsShape {

	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.fillPolygon(new int[] {x-20,x,x+20},new int[] {y-20,y+20,y-20}, 3);

	}

}
