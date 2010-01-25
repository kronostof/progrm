package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

import org.myapp.controle.MondeDesFormeControllerListener;
import drawing.shape.IDrawable;

/* surface sur laquelle tout s'affiche
 * possède une liste d'objet qu'elle dessine
 * @author ter Christophe Moncy
 */
public class JCanvas extends JPanel {
    private static final long serialVersionUID = 4949577436530106152L;
    //liste d'élément à dessiner
    private List<IDrawable> drawables = new LinkedList<IDrawable>();

    public void addDrawable(IDrawable d) {
        drawables.add(d);
        repaint();
    }

    /**
     * @pre:d!= null
     * @post: d est retiré de this
     */
    public void removeDrawable(IDrawable d) {
        drawables.remove(d);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Iterator<IDrawable> iter = drawables.iterator(); iter.hasNext();) {
            ((IDrawable) iter.next()).draw(g);
        }
    }

    public void clear() {
        drawables.clear();
        repaint();
    }

    public List<IDrawable> findDrawables(Point p) {
        List<IDrawable> l = new ArrayList<IDrawable>();
        for (Iterator<IDrawable> iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            if (element.getRectangle().contains(p)) {
                l.add(element);
            }
        }
        return l;
    }

    public boolean isFree(Rectangle rect) {
        for (Iterator<IDrawable> iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            System.out.println(element.getRectangle());
            if (element.getRectangle().intersects(rect)) {
                return false;
            }
        }
        return true;
    }
 
    public boolean isAlone(IDrawable drawable) {
        Rectangle rect = drawable.getRectangle();
        for (Iterator<IDrawable> iter = drawables.iterator(); iter.hasNext();) {
            IDrawable element = (IDrawable) iter.next();
            System.out.println(element.getRectangle());
            if (!element.equals(drawable)
                    && element.getRectangle().intersects(rect)) {
                return false;
            }
        }
        return true;
    }

    public void addControlleurListner(MondeDesFormeControllerListener Controller) {}
}