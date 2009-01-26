/*
 * Created on Aug 19, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package drawing.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import drawing.IDrawable;
import drawing.JCanvas;
import drawing.JCanvasMouseListener;
import drawing.RectangleDrawable;

/**
 * @author duj
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestML extends JCanvasMouseListener {

	public TestML(JCanvas canvas) {
		super(canvas);

	}

	protected void rightClickAction(MouseEvent e) {
		List selectedDrawables = canvas.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		IDrawable drawable = (IDrawable) selectedDrawables.get(0);
		canvas.removeDrawable(drawable);
	}

	/* (non-Javadoc)
	 * @see draw2.JCanvasMouseListener#rightClickAction(java.awt.event.MouseEvent)
	 */
	protected void leftClickAction(MouseEvent e) {
		Point p = e.getPoint();
		IDrawable rect = createDrawable(e);
		if (canvas.isFree(rect.getRectangle())) {
			canvas.addDrawable(rect);
		}

	}

	private IDrawable createDrawable(MouseEvent e) {
		Point p = e.getPoint();
		Dimension dim = new Dimension(40, 40);
		return new RectangleDrawable(Color.RED, p, dim);

	}

}
