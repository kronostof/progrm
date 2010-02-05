package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import myapp.controle.MondeDesFormeControllerListener;
import drawing.shape.IDrawable;

/* surface sur laquelle les forme s'affichent
 * possède une liste d'objet qu'elle dessine
 * @author Moncy Christophe 10304320
 */
public class JCanvas extends JPanel {

    public class Raffraichissement extends Thread {
        private final JCanvas canvas;

        private Raffraichissement(JCanvas aThis) {
            canvas = aThis;
            start();
        }

        @Override
        public void run() {

            while (true) {
                try {
                    sleep(10);
                    canvas.repaint();

                } catch (InterruptedException ex) {
                    Logger.getLogger(JCanvas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private static final long serialVersionUID = 4949577436530106152L;
    /**liste d'élément à dessiner*/
    private List<IDrawable> drawables = new LinkedList<IDrawable>();
    Raffraichissement refrech = new Raffraichissement(this);

    public JCanvas() {
        super();
    }

    public JCanvas(List<IDrawable> _drawables) {
        drawables = new LinkedList<IDrawable>(_drawables);
    }

    public List<IDrawable> getDrawables() {
        return drawables;
    }

    /** ajouter un élémnt a dessiner */
    public void addDrawable(IDrawable d) {
        drawables.add(d);
    }

    /**
     * Enlever un des élément de la liste de dessin de celle-ci.
     * @pre:  d!= null
     * @post: d est retiré de this
     */
    public void removeDrawable(IDrawable d) {
        drawables.remove(d);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (IDrawable iDrawable : drawables) {
            iDrawable.draw(g);
        }
    }

    /**
     * Enlever tous les éléments de la liste de dessin.
     */
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

    /**
     * Determine si il y a collision entre deux rectangle.
     * @param rect
     * @return
     */
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

    /**
     * Determine si il y a collision entre deux élément a dessiner.
     * @param rect
     * @return
     */
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

    public void addControlleurListner(MondeDesFormeControllerListener Controller) {
    }
}
