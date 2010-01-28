package org;

import org.myapp.controle.NewMondeDesFormeController;
import drawing.JCanvas;
//import drawing.shape.NewVueForme;
import drawing.shape.VueForme;
import org.myapp.model.NewMondeDesFormeModel;

/**
 *
 * @author ter Vincent Bonnier
 */
public class MainGUI {

    public static void main(String[] args) {
        JCanvas vue = new JCanvas();
        VueForme.set(vue);
        NewMondeDesFormeModel model = new NewMondeDesFormeModel();
        NewMondeDesFormeController Controleur = new NewMondeDesFormeController(model, vue);
        model.build(Controleur, vue);
    }
}
