package drawing.shape.type;

import java.awt.Graphics;

public class graphicsShapeCIRCLE extends graphicsShape {

    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillOval(x - width / 2, y - height / 2, width, height);
    }
}
