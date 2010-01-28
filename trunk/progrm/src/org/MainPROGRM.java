/*
/*
 *
NewShape n'implémente plus AbstractShape qui désormais est dans NewShape
Suppression du constructeur à 2 param NewVueForme(NewShape forme,int nulll) (on garde seulement celui à 1 param)
 */
package org;

import org.myapp.controle.MondeDesFormeController;
import drawing.JCanvas;
import drawing.shape.VueForme;
import org.myapp.communicationSocket.CommunicationSMI;
import org.myapp.model.MondeDesFormeModel;

public class MainPROGRM {

    /**
     * Classe principale du progrm PROGRM
     *
     */
    public static void main(String[] args) {


        //CommunicationSMI communicationSMI = new CommunicationSMI();

        JCanvas Vue = new JCanvas();
        VueForme.set(Vue);
        MondeDesFormeModel model = new MondeDesFormeModel();
        MondeDesFormeController Controleur = new MondeDesFormeController(model, Vue);
        model.build(Controleur);
    }
}
