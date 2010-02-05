package drawing.interfaceGraphique;

import org.lamia.src.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myapp.controle.MondeDesFormeController;
import drawing.JCanvas;
import drawing.shape.VueForme;
import myapp.model.NewMondeDesFormeModel;

/**
 * Cette classe construit la permiere interface que l'utilisateur rencontre.
 *
 * elle permet de lancer le progremme, de lancer une calibration, et de le quitter.
 *
 * @author Christophe Moncy 10304320
 */
public class UserInterface extends JFrame implements ActionListener {

    private JPanel container;
    JButton calibration;
    private JButton mondeForme;
    private JButton exit;
    private FlowLayout layout = null;
    Calibration m;

    public UserInterface() {
        super();
        build();
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


        if (e.getSource() == mondeForme) {
            JCanvas Vue = new JCanvas();
            VueForme.set(Vue);
            NewMondeDesFormeModel model = new NewMondeDesFormeModel();
            MondeDesFormeController Controleur = new MondeDesFormeController(model, Vue);
            model.build(Controleur);
            new FenetreDeStatistique();
        }
        if (e.getSource() == exit) {
            System.exit(0);
        }


    }

    /**
     * Effectue une calibration.
     */
    private void Execute_calibration() {
        System.err.println("PAS VRAIMENT IMPLEMENTE");
//        try {
//            send = new Send("ET_CAL" + "\n" + "\r", socket);
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        try {
//            send.sending();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        m = new Calibration(socket);
//        m.start();
//        /*if (!(recalibration.isEnabled())) {
//        recalibration.setEnabled(true);
//        } */
    }
}
