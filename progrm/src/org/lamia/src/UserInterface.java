package org.lamia.src;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.myapp.controle.MondeDesFormeController;
import org.myapp.model.MondeDesFormeModel;

//import drawing.CircleDrawable;
import drawing.JCanvas;
import drawing.shape.VueForme;

public class UserInterface extends JFrame implements ActionListener {

    OuvrirSocket socket;
    private JPanel container;
    JButton calibration;
    private JButton recalibration;
    private JButton mondeForme;
    private JButton start;
    private JButton exit;
    private Send send;
    private FlowLayout layout = null;
    Calibration m;



    public UserInterface() {
        super();
        build();
    }

    public UserInterface(OuvrirSocket socket) {
        super();
        build();
        this.socket = socket;
    }

    /**
     * Construction de l'interface utilisateur
     */
    private void build() {
        setTitle("PROGRM");
        setPreferredSize(new Dimension(700, 70));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getContainer());
        pack();
        setVisible(true);
    }

    public JPanel getContainer() {

        layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        container = new JPanel();
        container.setLayout(layout);

        calibration = new JButton("Calibration");
        calibration.setPreferredSize(new Dimension(125, 25));
        calibration.addActionListener(this);
        container.add(calibration);
/*
        recalibration = new JButton("Recalibration");
        recalibration.setPreferredSize(new Dimension(125, 25));
        recalibration.addActionListener(this);
        recalibration.setEnabled(false);
        container.add(recalibration);

        start = new JButton("Start");
        start.setPreferredSize(new Dimension(125, 25));
        start.addActionListener(this);
        container.add(start);
*/
        mondeForme = new JButton("Monde des formes");
        mondeForme.setPreferredSize(new Dimension(125, 25));
        mondeForme.addActionListener(this);
        container.add(mondeForme);

        exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(125, 25));
        exit.addActionListener(this);
        container.add(exit);

        return container;
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == calibration) {
            Execute_calibration();
        }


/*
        if (e.getSource() == recalibration) {
        }
        if (e.getSource() == start) {
        }
  */      if (e.getSource() == mondeForme) {
            JCanvas Vue = new JCanvas();
            VueForme.set(Vue);
            MondeDesFormeModel model = new MondeDesFormeModel();
            MondeDesFormeController Controleur = new MondeDesFormeController(model, Vue);
            model.build(Controleur);
        }
        if (e.getSource() == exit) {
            
        }


    }

    private void Execute_calibration() {
        try {
            send = new Send("ET_CAL" + "\n" + "\r", socket);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            send.sending();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        m = new Calibration(socket);
        m.start();
        /*if (!(recalibration.isEnabled())) {
        recalibration.setEnabled(true);
        } */
    }
}
