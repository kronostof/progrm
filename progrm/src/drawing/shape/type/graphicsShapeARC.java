package drawing.shape.type;

import java.awt.Graphics;

public class graphicsShapeARC extends graphicsShape {

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillPolygon(new int[]{x - 20, x + 19, x + 20, x - 19}, new int[]{y - 19, y + 20, y + 19, y - 20}, 4);
        g.fillPolygon(new int[]{x - 20, x - 19, x + 20, x + 19}, new int[]{y + 19, y + 20, y - 19, y - 20}, 4);
    }
}
