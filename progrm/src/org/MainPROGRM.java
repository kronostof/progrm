package org;

import org.myapp.controle.MondeDesFormeController;
import org.myapp.model.MondeDesFormeModel;
import drawing.JCanvas;
import drawing.shape.VueForme;

public class MainPROGRM {

	/**
	 * Classe principale du progrm PROGRM
	 */
	public static void main(String[] args) {
		JCanvas Vue = new JCanvas();
		VueForme.set(Vue);
		MondeDesFormeModel model = new MondeDesFormeModel();		
		MondeDesFormeController Controleur = new MondeDesFormeController(model,Vue);
		model.build(Controleur);
	}
}