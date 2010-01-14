/*
 /*
 *
NewShape n'implémente plus AbstractShape qui désormais est dans NewShape
Suppression du constructeur à 2 param NewVueForme(NewShape forme,int nulll) (on garde seulement celui à 1 param)
 */
package org;

import org.myapp.controle.NewMondeDesFormeController;
import drawing.JCanvas;
import drawing.shape.NewVueForme;
import org.myapp.model.NewMondeDesFormeModel;

public class MainSARSA {

	/**
	 * Classe principale du progrm PROGRM
	 */
	public static void main(String[] args) {
		JCanvas Vue = new JCanvas();
		NewVueForme.set(Vue);
		NewMondeDesFormeModel model = new NewMondeDesFormeModel();
		NewMondeDesFormeController Controleur = new NewMondeDesFormeController(model,Vue);
		model.build(Controleur);
	}
}