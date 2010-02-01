//package drawing.interfaceGraphique;
//
//import java.awt.*;
//import javax.swing.*;
//import java.util.*;
//import java.util.Timer;
//import logo2.controleur.Controler;
//
///**
// * La classe FeuilleDessin a pour vocation d'etre inseré dans une extension de la classe Fenêtre.
// * c'est a l'aide de cette classe que des objet de type Dessinable sont afichable.
// * @author chris
// */
//public class FeuilleDessin extends JPanel implements Observer {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = -1342625955262171324L;
//    Timer timer = new Timer();
//    Date date = new Date(10);
//    GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
//    boolean showDessinable = true;
//    Graphics g = null;
//    Image drawingImage;
//    Image ImageTerrain;
//    private Controler controleur = null;
//    private Date time;
//    private long newtime = 500, oldtime = 0;
//
//    public FeuilleDessin(Controler c) {
//        this.controleur = c;
//        //ImageTerrain = new Image();//"./bin/tortue20cool.jpg");
//        g = getGraphics();
//        ImageTerrain = getToolkit().getImage("./bin/soccer_field.jpg");
//    }
//
//    public void addDessinable(Dessinable o) {
//        listeDessinable.add(o);
//    }
//
//    void reset() {
//
//        Dimension dim = getPreferredSize();
//
//        drawingImage = this.createImage(dim.width, dim.height);
//        g = drawingImage.getGraphics();
//        Color c = g.getColor();
//        g.setColor(Color.white);
//        g.fillRect(0, 0, dim.width, dim.height);
//        g.setColor(c);
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        if (drawingImage == null) {
//            reset();
//        }
//        g.drawImage(drawingImage, 0, 0, null);
//        if (showDessinable) {
//            showTurtles(g);
//        }
//    }
//
//    public void drawIt() {
//
//        g = getGraphics();
//
//        getImageGraphics().drawImage(ImageTerrain, 0, 0, null);
//        g.drawImage(drawingImage, 0, 0, null);
//        if (showDessinable) {
//            showTurtles(g);
//        }
//    }
//
//    public Graphics getImageGraphics() {
//        if (drawingImage == null) {
//            reset();
//        }
//        return drawingImage.getGraphics();
//    }
//
//    void showTurtles(Graphics g) {
//        for (Iterator<Dessinable> it = listeDessinable.iterator(); it.hasNext();) {
//            Dessinable t = (Dessinable) it.next();
//            t.drawDessinable(g, t.coordonnée);
//        }
//    }
//
//    public void update(Observable arg0, Object arg1) {
//        newtime = GregorianCalendar.getInstance().getTimeInMillis();
//        // Soissante image par seconde.
//        if (newtime > (oldtime + 100)) {
//            oldtime = newtime;
//            drawIt();
//        }
//
//    }
//}
