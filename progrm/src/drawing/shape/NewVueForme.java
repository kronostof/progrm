//package drawing.shape;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.Point;
//import drawing.JCanvas;
//import drawing.shape.type.*;
//import myapp.Sarsa.Sarsa_Shape;
//
//
//public class NewVueForme extends FormDrawable implements FormeListener {
//
//    static public JCanvas Vue;
//    private graphicsShape gShape;
//
//    public void positionChangee(FormeListener Fl) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
///*
//    public enum ShapeForme {
//
//        Circle, Cursor, Square, Triangle
//    }
//*/
//    public NewVueForme(Sarsa_Shape forme) {
//        super(Color.RED, forme.getPoint(), new Dimension(40, 40));
//
//        switch (forme.getForme()) {
//            case CIRCLE:
//                this.gShape = new graphicsShapeCIRCLE();
//                break;
//            case SQUARE:
//                this.gShape = new graphicsShapeSQUARE();
//                break;
//            case TRIANGLE:
//                this.gShape = new graphicsShapeTRIANGLE();
//                break;
//            default:
//                System.out.println("VueForme:public VueForme(Shape forme,int type) pas d'objet graphiqueShape initialis�e !");
//                break;
//        }
//        Vue.addDrawable(this);
//    }
//
//    /* (non-Javadoc)
//     * @see draw.Drawable#draw(java.awt.Graphics)
//     */
//    public void draw(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(color);
//        gShape.draw(g, rect.x, rect.y, rect.width, rect.height);
//        g.setColor(c);
//    }
//
//
//    static public void set(JCanvas nVue) {
//        Vue = nVue;
//    }
//
//    public Color getColor() {
//        return color;
//    }
//
//    @Override
//    public Point getPoint() {
//        return getPosition();
//    }
//}
