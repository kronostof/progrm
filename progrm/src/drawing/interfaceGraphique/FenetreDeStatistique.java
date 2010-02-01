/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.interfaceGraphique;

import drawing.shape.IDrawable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import javax.swing.*;
import java.util.Observer;
import myapp.Lecteur;
import myapp.Sarsa.Sarsa_Action;
import myapp.Sarsa.Sarsa_Politique;
import myapp.Sarsa.Sarsa_Shape;
import myapp.Sarsa.Sarsa_State;
import myapp.Sarsa.Sarsa_StateFactory;
import myapp.factory.Sarsa_ShapeFactory;
//import logo2.controleur.Controler;

/**
 * représentation des donnée d'un objet implementant l'interface IRepresanteble_pour_stat.
 *
 * cette classe présente les information interne d'une instance ayant l'inteface IRepresanteble_pour_stat.
 * @author chris
 */
public class FenetreDeStatistique implements Observer, ActionListener {

    private JPanel statLabel = null, statLabelC = null, statLabelSouth = null;
    private JLabel texteStatLabel, texteStatLabelC,texteStatLabelSouth;
    String texte = null;
    /**
     * liste d'élement dessinable.
     */
    private Collection<IRepresanteble_pour_stat> list_irepresanteble_pour_stat = new ArrayList<IRepresanteble_pour_stat>();
    private Sarsa_Politique observableStat = null;


    public FenetreDeStatistique() {
        //<XXX
        for (Sarsa_Shape shape : Sarsa_ShapeFactory.getListe_de_shape()) {
            list_irepresanteble_pour_stat.add(shape);
        }
        //XXX<


        démarrerFenêtreDeStatistique(new Dimension(800, 600));
    }

    private void démarrerFenêtreDeStatistique(Dimension d) {

        JFrame FrameStat = new JFrame("FenêtreDeStatistique");
        FrameStat.setVisible(false);
        FrameStat.setPreferredSize(d/*new Dimension(600, 400)*/);


        FrameStat.getContentPane().removeAll();
        FrameStat.getContentPane().setLayout(new BorderLayout(1, 1));

        JPanel panel = new JPanel(new GridLayout(0, 2));

        for (IRepresanteble_pour_stat tempEstRepresantable : list_irepresanteble_pour_stat) {
            addButton(panel, tempEstRepresantable.getNom(), "test", "test");
        }
        FrameStat.add(panel, BorderLayout.EAST);


        statLabel = new JPanel();//new FlowLayout());
        FrameStat.add(statLabel, BorderLayout.CENTER);
        texteStatLabel = new JLabel();
        statLabel.add(texteStatLabel);



        statLabelC = new JPanel();//new FlowLayout());
        FrameStat.add(statLabelC, BorderLayout.WEST);
        texteStatLabelC = new JLabel();
        statLabelC.add(texteStatLabelC);

        statLabelSouth = new JPanel();//new FlowLayout());
        FrameStat.add(statLabelSouth, BorderLayout.SOUTH);
        texteStatLabelSouth = new JLabel();
        statLabelSouth.add(texteStatLabelSouth);

        FrameStat.pack();
        FrameStat.setVisible(true);

    }

    public void update(Observable o, Object arg) {
        if (observableStat != null) {



            texte = "<html>";
            for (Sarsa_State a_State : observableStat.getHashQualityOfStates().keySet()) {
                texte +=  a_State;
                if (observableStat.getEtatCourant() == a_State) {
                    texte += "X<br>";
                }else{
                texte += "<br>";
                }
            }
            texteStatLabel.setText(texte + "</html>");



            texte = "<html>";
            for (Sarsa_State a_State : observableStat.getHashQualityOfStates().keySet()) {
                texte += observableStat.getHashQualityOfStates().get(a_State) + "<br>";
            }
            texte += observableStat.getEtatCourant().toString();
            texteStatLabelC.setText(texte + "</html>");



            texte = "<html>";
            for (Sarsa_State a_State : observableStat.getListe_état()) {
                texte +=  a_State;
                if (observableStat.getEtatCourant() == a_State) {
                    texte += "X " + observableStat.getHashQualityOfStates().get(a_State) + "<br>";
                }else{
                texte += observableStat.getHashQualityOfStates().get(a_State) + "<br>";
                }
            }
            texteStatLabelSouth.setText(texte + "</html>");



        }
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        Sarsa_Politique temp = null;
        for (IRepresanteble_pour_stat tmpEstDessinable : list_irepresanteble_pour_stat) {
            if (tmpEstDessinable.getNom().compareTo(c) == 0) {
                if (observableStat != null) {
                    observableStat.deleteObserver(this);
                    observableStat = null;
                }
//                observableStat.setObserverFenetreStat(false);

                temp = tmpEstDessinable.getpolicy();
//                observableStat.setObserverFenetreStat(true);
                break;
            }
        }
        observableStat = temp;
        observableStat.addObserver(this);
        //this.update(null, c);
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
