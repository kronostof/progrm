package org;

import org.asma.affichage;

public class MondeDesFormeController {

	public MondeDesFormeModel model;
	public affichage vue;
	
	public MondeDesFormeController(MondeDesFormeModel model) {
		this.model = model;
		
		// creeation de la vue
		vue = new affichage();
		vue.setVisible(true);
	}

	public void displayView() {
	
		vue.setVisible(true);
	}
}