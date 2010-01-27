package drawing.shape;

import org.FormeListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import drawing.JCanvas;
import drawing.shape.type.*;
import org.myapp.model.NewShape;

public class NewVueForme extends FormDrawable implements FormeListener {

    static public JCanvas Vue;
    private graphicsShape gShape;
    public enum ShapeForme { Circle, Cursor, Square, Triangle }

    public NewVueForme(NewShape forme) {
        super(forme.getStateOfShape().getAWTShapeColor(), forme.getPoint(), new Dimension(40, 40));
        
        switch (forme.getStateOfShape().getShapeType()) {
            case ROND :
                this.gShape = new graphicsShapeCIRCLE();
                break;
            case CARRE:
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
        g.setColor(c);  
    }

    @Override
    public void positionChangee(FormeListener FL) {
        //System.out.println("public class CircleDrawable extends FormDrawable");

        this.setPosition(((NewShape) FL).getPosition().getPoint());
        this.color = ((NewShape) FL).getStateOfShape().getAWTShapeColor();
        // on fait un repaint de tt la vue et c est moche ! ! !
        Vue.repaint();
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
