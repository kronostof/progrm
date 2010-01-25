package org;

import org.myapp.controle.NewMondeDesFormeController;
import drawing.JCanvas;
import drawing.shape.NewVueForme;
import org.myapp.model.NewMondeDesFormeModel;
/**
 *
 * @author ter Vincent Bonnier
 */
public class MainGUI {
    public static void main(String[] args) {
        JCanvas Vue = new JCanvas();
        NewVueForme.set(Vue);
        NewMondeDesFormeModel model = new NewMondeDesFormeModel();
        NewMondeDesFormeController Controleur = new NewMondeDesFormeController(model,Vue);
        model.build(Controleur);
    }
}
