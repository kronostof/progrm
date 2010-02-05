/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.interfaceGraphique;

import drawing.JCanvas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import javax.swing.*;
import java.util.Observer;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;
import myapp.Sarsa.Sarsa_Politique;
import myapp.Sarsa.Sarsa_Shape;
import myapp.Sarsa.Sarsa_State;
import myapp.Sarsa.Sarsa_StateFactory;
import myapp.controle.MondeDesFormeController;

import myapp.factory.Sarsa_ShapeFactory;

/**
 * représentation des donnée d'un objet implementant l'interface IRepresanteble_pour_stat.
 *
 * cette classe présente les information interne d'une instance ayant l'inteface IRepresanteble_pour_stat.
 * @author chris
 */
public class FenetreDeStatistique implements Observer, ActionListener {

    int _i = 0;
    String texte = null, texte2 = null;
    ArrayList<JProgressBar> arrayOf_progressBar = new ArrayList<JProgressBar>(Sarsa_StateFactory.Ensemble_Des_Etats.size());
    /**
     * liste d'élement dessinable.
     */
    private Collection<IRepresanteble_pour_stat> list_irepresanteble_pour_stat = new ArrayList<IRepresanteble_pour_stat>();
    private Sarsa_Politique politiqueObservé = null;

    public FenetreDeStatistique() {
        //<XXX
        for (Sarsa_Shape shape : Sarsa_ShapeFactory.getListe_de_shape()) {
            if (!list_irepresanteble_pour_stat.contains(shape)) {
                list_irepresanteble_pour_stat.add(shape);
            }
        }
        System.out.println(list_irepresanteble_pour_stat.size());
        for (Sarsa_State _state : Sarsa_StateFactory.Ensemble_Des_Etats) {
            arrayOf_progressBar.add(new JProgressBar(0, 100));
        }
        //XXX<
        démarrerFenêtreDeStatistique(new Dimension(1024, 600));
    }

    private void démarrerFenêtreDeStatistique(Dimension d) {

        JFrame FrameStat = new JFrame("Fenêtre De Statistique");
        FrameStat.getContentPane().removeAll();
        FrameStat.getContentPane().setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        // On ajoute le menu a la fenetre.
        FrameStat.setJMenuBar(menuBar);

        // LES TROIS PANEL QUI SERONT DANS LES TABED PANE.
        JPanel statLabelCenter = new JPanel(new BorderLayout());
        JPanel mdfLabelCenter = new JCanvas(MondeDesFormeController.getVue().getDrawables());
        JPanel paramLabelCenter = new JPanel(new FlowLayout());

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        //CREATION DES ONGLETS
//        ImageIcon icon = createImageIcon("images/middle.gif");
//        ImageIcon icon = createImageIcon("images/middle.gif");
//        ImageIcon icon = createImageIcon("images/middle.gif");
//        tabbedPane.addTab("Tab 0", icon, panel2,"Does twice as much nothing");

        tabbedPane.addTab("Liste des états", statLabelCenter);
        tabbedPane.addTab("paramètre de l'algo", paramLabelCenter);
        tabbedPane.addTab("visualisation du monde des forme", mdfLabelCenter);

//        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
//        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        FrameStat.setVisible(false);
        //  FrameStat.setPreferredSize(d);




        // Construction du menu

        JMenu menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("(Re)Démarrer l'experience", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Effectuer une calibration", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Enregistrer les données générées", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItem);


        menuItem = new JMenuItem("Quiter", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menu.add(menuItem);





        // BARRE DE BOUTON VERS LES SHAPE
        JPanel panel = new JPanel(new FlowLayout());
        JPanel panelDeBouton = new JPanel(new GridLayout(0, 20));
        JPanel _conteneur, _conteneur1;
        //panel.setSize(new Dimension(50, 100));
        _i = 0;
        for (IRepresanteble_pour_stat tempEstRepresantable : list_irepresanteble_pour_stat) {
            _conteneur = new JPanel(new GridLayout(1, 0));
            addButton(_conteneur, tempEstRepresantable.getNom(), "test" + _i++, "test");
            //  _canevas = new JCanvas();
            //  System.out.println((((Sarsa_Shape)tempEstRepresantable).getFormeListeners()[0].getPoint()));
            //  _canevas.addDrawable((VueForme)(((Sarsa_Shape)tempEstRepresantable).getFormeListeners()[0]));
            //  _conteneur.add(_canevas);
            panelDeBouton.add(_conteneur);
        }
        panel.add(panelDeBouton);


        // ACCES AU PARAMETRE DE L'ALGORITHME.
        _conteneur = new JPanel(new GridLayout(1, 2));
        _conteneur.add(new JTextArea("alpha"));
        _conteneur.add(new JFormattedTextField(NumberFormat.getCurrencyInstance()));
        paramLabelCenter.add(_conteneur);

        _conteneur = new JPanel(new GridLayout(1, 2));
        _conteneur.add(new JTextArea("alpha"));
        _conteneur.add(new JFormattedTextField(NumberFormat.getCurrencyInstance()));
        paramLabelCenter.add(_conteneur);

        FrameStat.add(panel, BorderLayout.NORTH);









        // LISTE DE TOUS LES ETATS


        panel = new JPanel(new GridLayout(Sarsa_StateFactory.getListeDesEtat().size() / 3, Sarsa_StateFactory.getListeDesEtat().size() % 10));
        JScrollPane scrollpan = new JScrollPane(panel);
        _i = 0;
        for (Sarsa_State a_State : Sarsa_StateFactory.getListeDesEtat()) {
            _conteneur = new JPanel(new GridLayout(2, 1));
            addButton(_conteneur, "<html> " + a_State.toHTML() + " </html>", "texte", "texte");

            _conteneur.add(arrayOf_progressBar.get(_i++));
            panel.add(_conteneur);
        }

        statLabelCenter.add(scrollpan, BorderLayout.CENTER);
        FrameStat.add(tabbedPane, BorderLayout.CENTER);










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
        if (temp != null) {
            politiqueObservé = temp;
            politiqueObservé.addObserver(this);
            this.update(null, c);
        } else {
            System.out.println("modifier l'affichage !");
        }
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
