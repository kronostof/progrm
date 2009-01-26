package org;

import drawing.CircleDrawable;
import drawing.JCanvas;

public class MainPROGRM {

	/**
	 * Classe principale du progrm PROGRM
	 */
	public static void main(String[] args) {
		JCanvas Vue = new JCanvas();
			CircleDrawable.set(Vue);
		MondeDesFormeModel model = new MondeDesFormeModel();		
		new MondeDesFormeController(model,Vue);
		model.build();
	}
}