
package drawing;

import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @author duj
 * 
 */
public class MoveDrawableMouseListener extends JCanvasMouseAdapter {

	protected IMovableDrawable drawable;

	/**
	 * @param canvas
	 */
	public MoveDrawableMouseListener(JCanvas canvas) {
		super(canvas);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
		if (drawable != null) {
			drawable.setPosition(e.getPoint());
			canvas.repaint();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		List<IDrawable> selectedDrawables = canvas.findDrawables(e.getPoint());
		if (selectedDrawables.size() == 0)
			return;
		drawable = (IMovableDrawable) selectedDrawables.get(0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		drawable = null;
	}

}