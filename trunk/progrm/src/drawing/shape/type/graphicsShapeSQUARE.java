package drawing.shape.type;

import java.awt.Graphics;

public class graphicsShapeSQUARE extends graphicsShape {

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }
}
