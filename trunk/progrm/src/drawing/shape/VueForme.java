package drawing.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import myapp.model.Shape;
import drawing.JCanvas;
import drawing.shape.type.*;
import java.util.ArrayList;

public class VueForme extends FormDrawable implements FormeListener {

    static public JCanvas Vue;
    private graphicsShape gShape;
    static private ArrayList<VueForme> arrayListeOfAllVueForme = new ArrayList<VueForme>();

    public enum ShapeForme {

        CIRCLE, CURSOR, SQUARE, TRIANGLE;
    }

    public VueForme(Shape shape) {
        super(shape.color, shape.getPoint(), new Dimension(40, 40));
        arrayListeOfAllVueForme.add(this);
        this.gShape = GraphicsShape_Factory.getGraphicsShape(shape.getForme());
        Vue.addDrawable(this);
    }

    public static ArrayList<VueForme> getArrayListeOfAllVueForme() {
        return arrayListeOfAllVueForme;
    }

    /* (non-Javadoc)
     * @see draw.Drawable#draw(java.awt.Graphics)
     */
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(color);
        gShape.draw(g, rect.x, rect.y, rect.width, rect.height);
        //g.setColor(c);
    }

    @Override
    public void positionChangee(FormeListener FL) {
        this.setPosition(((Shape) FL).getPosition().getPoint());
        this.color = ((Shape) FL).getColor();
        set_Forme(((Shape) FL).getForme());
        // on fait un repaint de tt la vue et c est moche ! ! !
        //Vue.repaint();
    }

    public void set_Forme(ShapeForme forme) {
        this.gShape = GraphicsShape_Factory.getGraphicsShape(forme);
    }

    static public void set(JCanvas nVue) {
        Vue = nVue;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Point getPoint() {
        return getPosition();
    }
}
