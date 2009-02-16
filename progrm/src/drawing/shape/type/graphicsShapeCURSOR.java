package drawing.shape.type;

import java.awt.Graphics;

public class graphicsShapeCURSOR extends graphicsShape{

	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.fillPolygon(new int[] {x-1,x-1,x+1,x+1}, new int[] {y-20,y+20,y+20,y-20}, 4);
		g.fillPolygon(new int[] {x-20,x-20,x+20,x+20}, new int[] {y-1,y+1,y+1,y-1}, 4);
		//g.fillOval(x, y, width, height);
	}

}
