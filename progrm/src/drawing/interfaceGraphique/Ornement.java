/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.interfaceGraphique;

import drawing.shape.type.graphicsShapeARC;
import drawing.shape.FormDrawable;
import drawing.shape.FormeListener;
import drawing.shape.IDrawable;
import drawing.shape.type.graphicsShape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import myapp.model.Shape;

/**
 *
 * @author BOB
 */
class Ornement extends FormDrawable implements IDrawable,Observer {
    private graphicsShape gShape = new graphicsShapeARC();

    public Ornement() {
        super(Color.BLACK, new Point(0, 0), new Dimension(40, 40));
    }

    public Point getPosition() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(color);
        gShape.draw(g, rect.x, rect.y, rect.width, rect.height);
    }

    public Rectangle getRectangle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void positionChangee(FormeListener Fl) {
        this.setPosition(((Shape) Fl).getPosition().getPoint());
    }

    public Point getPoint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
