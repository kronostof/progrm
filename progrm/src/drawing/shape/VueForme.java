package drawing.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import org.FormeListener;
import org.myapp.model.Shape;
import drawing.JCanvas;
import drawing.shape.type.graphicsShape;
import drawing.shape.type.graphicsShapeCIRCLE;
import drawing.shape.type.graphicsShapeCURSOR;
import drawing.shape.type.graphicsShapeSQUARE;
import drawing.shape.type.graphicsShapeTRIANGLE;

public class VueForme extends FormDrawable implements FormeListener {

	static public JCanvas Vue;
	private graphicsShape gShape;


	public VueForme(Shape forme,int type) {
		super(forme.color,forme.getPoint(),new Dimension(40,40));

		switch (forme.getForme()) {
		case Shape.CIRCLE:
			this.gShape = new graphicsShapeCIRCLE(); 	
		break;
		case Shape.CURSOR:
			this.gShape = new graphicsShapeCURSOR(); 	
			break;
		case Shape.SQUARE:
			this.gShape = new graphicsShapeSQUARE(); 
		break;
		case Shape.TRANGLE:
			this.gShape = new graphicsShapeTRIANGLE(); 
		break;

		default:
			System.out.println("VueForme:public VueForme(Shape forme,int type) pas d'objet graphiqueShape initialisée !"); 
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
		gShape.draw(g,rect.x, rect.y, rect.width, rect.height);
		g.setColor(c);
	}
	
	@Override
	public void positionChangee(FormeListener FL) {
		 //System.out.println("public class CircleDrawable extends FormDrawable");
		
		this.setPosition(((Shape)FL).getPosition().getPoint());
		this.color = ((Shape)FL).getColor();
		// on fait un repaint de tt la vue et c est moche ! ! !
		Vue.repaint();
	}
	
	
	static public void set(JCanvas nVue){
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
