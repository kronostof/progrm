/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.interfaceGraphique;

import drawing.JCanvas;
import drawing.shape.FormDrawable;
import drawing.shape.IDrawable;
import drawing.shape.VueForme;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import javax.swing.*;
import java.util.Observer;
import myapp.Sarsa.Sarsa_Politique;
import myapp.Sarsa.Sarsa_Quality;
import myapp.Sarsa.Sarsa_Shape;
import myapp.Sarsa.Sarsa_State;
import myapp.Sarsa.Sarsa_StateFactory;

import myapp.factory.Sarsa_ShapeFactory;

/**
 * représentation des donnée d'un objet implementant l'interface IRepresanteble_pour_stat.
 *
 * cette classe présente les information interne d'une instance ayant l'inteface IRepresanteble_pour_stat.
 * @author chris
 */
public class FenetreDeStatistique implements Observer, ActionListener {

    int _i = 0;
    private JPanel statLabel = null,
            statLabelCenter = null,
            statLabelNorth = null,
            statLabelSouth = null,
            statLabelWest = null,
            statLabelEst = null;
    private JLabel texteStatLabel,
            texteStatLabelCenter,
            texteStatLabelNORTH,
            texteStatLabelWEST,
            texteStatLabelEST,
            texteStatLabelSouth;
    String texte = null, texte2 = null;
    ArrayList<JProgressBar> arrayOf_progressBar = new ArrayList<JProgressBar>(Sarsa_StateFactory.listeDesEtat.size());
    /**
     * liste d'élement dessinable.
     */
    private Collection<IRepresanteble_pour_stat> list_irepresanteble_pour_stat = new ArrayList<IRepresanteble_pour_stat>();
    private Sarsa_Politique politiqueObservé = null;

    public FenetreDeStatistique() {
        //<XXX
        for (Sarsa_Shape shape : Sarsa_ShapeFactory.getListe_de_shape()) {
            list_irepresanteble_pour_stat.add(shape);

        }
        for (Sarsa_State _state : Sarsa_StateFactory.listeDesEtat) {
            arrayOf_progressBar.add(new JProgressBar(0, 100));
        }
        //XXX<


        démarrerFenêtreDeStatistique(new Dimension(800, 600));
    }

    private void démarrerFenêtreDeStatistique(Dimension d) {

        JFrame FrameStat = new JFrame("FenêtreDeStatistique");
        FrameStat.setVisible(false);
        FrameStat.setPreferredSize(d/*new Dimension(600, 400)*/);


        FrameStat.getContentPane().removeAll();
        FrameStat.getContentPane().setLayout(new BorderLayout());


        // bouton vers chaque shape

        JPanel panel = new JPanel(new GridLayout(0, 1));
        JPanel _conteneur;
        JCanvas _canevas ;
        //panel.setSize(new Dimension(50, 100));
        
        for (IRepresanteble_pour_stat tempEstRepresantable : list_irepresanteble_pour_stat) {
            _conteneur = new JPanel(new FlowLayout());
            addButton(_conteneur, tempEstRepresantable.getNom(), "test", "test");
            _canevas = new JCanvas();
            System.out.println((((Sarsa_Shape)tempEstRepresantable).getFormeListeners()[0].getPoint()));
            _canevas.addDrawable((VueForme)(((Sarsa_Shape)tempEstRepresantable).getFormeListeners()[0]));
            _conteneur.add(_canevas);
             panel.add(_conteneur);
        }
        FrameStat.add(panel, BorderLayout.EAST);


        // liste de tout les états

        statLabelCenter = new JPanel(new GridLayout(0, 1));

        _i = 0;
        for (Sarsa_State a_State : Sarsa_StateFactory.getListeDesEtat()) {
            _conteneur = new JPanel(new GridLayout(1, 2));
            _conteneur.add(new JLabel(a_State.toString()));
            _conteneur.add(arrayOf_progressBar.get(_i++));
            statLabelCenter.add(_conteneur);
        }
        FrameStat.add(statLabelCenter, BorderLayout.CENTER);

        FrameStat.pack();
        FrameStat.setVisible(true);

    }

    public void update(Observable o, Object arg) {
        if (politiqueObservé != null) {
            _i = 0;
            for (Sarsa_State a_State : Sarsa_StateFactory.getListeDesEtat()) {
                arrayOf_progressBar.get(_i++).setValue((int) (politiqueObservé.getHashQualityOfStates().get(a_State).quality * 100));
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        Sarsa_Politique temp = null;
        for (IRepresanteble_pour_stat tmpEstDessinable : list_irepresanteble_pour_stat) {
            if (tmpEstDessinable.getNom().compareTo(c) == 0) {
                if (politiqueObservé != null) {
                    politiqueObservé.deleteObserver(this);
                    politiqueObservé = null;
                }
//                observableStat.setObserverFenetreStat(false);

                temp = tmpEstDessinable.getpolicy();
//                observableStat.setObserverFenetreStat(true);
                break;
            }
        }
        politiqueObservé = temp;
        politiqueObservé.addObserver(this);
        this.update(null, c);
        // texteStatLabel.setText("<html>" + c + "</html>");
    }

    void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);

                b = (JButton) p.add(new JButton(im));
            } else {
                b = (JButton) p.add(new JButton(name));
            }
            b.setActionCommand(name);
        }
        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
        b.addActionListener(this);
    }
}
