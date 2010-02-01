package org;

import myapp.controle.MondeDesFormeController;
import drawing.JCanvas;
import drawing.shape.VueForme;
import myapp.model.NewMondeDesFormeModel;

/**
 *
 * @author ter Vincent Bonnier
 */
public class MainSarsaProgrm {

    public static void main(String[] args) {
        JCanvas vue = new JCanvas();
        VueForme.set(vue);
        NewMondeDesFormeModel model = new NewMondeDesFormeModel();
        MondeDesFormeController Controleur = new MondeDesFormeController(model, vue);
        model.build(Controleur);
    }
}
