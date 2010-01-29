package drawing.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import org.myapp.model.Shape;
import drawing.JCanvas;
import drawing.shape.type.*;

public class VueForme extends FormDrawable implements FormeListener {

    static public JCanvas Vue;
    private graphicsShape gShape;

    public enum ShapeForme {

        CIRCLE, CURSOR, SQUARE, TRIANGLE;
    }

//    public VueForme(Shape forme) {
//        super(forme.color, forme.getPoint(), new Dimension(40, 40));
//
//        switch (forme.getForme2()) {
//            case CIRCLE:
//                this.gShape = new graphicsShapeCIRCLE();
//                break;
//            case CURSOR:
//                this.gShape = new graphicsShapeCURSOR();
//                break;
//            case SQUARE:
//                this.gShape = new graphicsShapeSQUARE();
//                break;
//            case TRIANGLE:
//                this.gShape = new graphicsShapeTRIANGLE();
//                break;
//
//            default:
//                System.out.println("VueForme:public VueForme(Shape forme,int type) pas d'objet graphiqueShape initialis�e !");
//                break;
//        }
//        Vue.addDrawable(this);
//    }
    public VueForme(Shape shape) {
        super(shape.color, shape.getPoint(), new Dimension(40, 40));

        switch (shape.getForme()) {
            case CIRCLE:
                this.gShape = new graphicsShapeCIRCLE();
                break;
            case CURSOR:
                this.gShape = new graphicsShapeCURSOR();
                break;
            case SQUARE:
                this.gShape = new graphicsShapeSQUARE();
                break;
            case TRIANGLE:
                this.gShape = new graphicsShapeTRIANGLE();
                break;

            default:
                System.out.println("VueForme:public VueForme(Shape forme,int type) pas d'objet graphiqueShape initialis�e !");
                break;
        }
        Vue.addDrawable(this);
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
        Vue.repaint();
    }

    public void set_Forme(ShapeForme forme) {
        switch (forme) {
            case CIRCLE:
                this.gShape = new graphicsShapeCIRCLE();
                break;
            case CURSOR:
                this.gShape = new graphicsShapeCURSOR();
                break;
            case SQUARE:
                this.gShape = new graphicsShapeSQUARE();
                break;
            case TRIANGLE:
                this.gShape = new graphicsShapeTRIANGLE();
                break;
            default:
                System.out.println("VueForme:public VueForme(Shape forme,int type) pas d'objet graphiqueShape initialis�e !");
                break;
        }
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
