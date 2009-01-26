package org;

public class MainPROGRM {

	/**
	 * Classe principale du progrm PROGRM
	 */
	public static void main(String[] args) {
		
		MondeDesFormeModel model = new MondeDesFormeModel();
		MondeDesFormeController controller = new MondeDesFormeController(model);
		controller.displayView();
	}
}
