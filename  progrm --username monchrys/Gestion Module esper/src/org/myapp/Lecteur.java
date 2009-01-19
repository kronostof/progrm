package org.myapp;
import java.awt.MouseInfo;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 *
 * Cette classe constitue le pré-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet dérivant de module) 
 * et 	son ajout au evennement listée ( ajoutStatement() )
 * 
 * la vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arrivé
 * elle rythme l'envoie de la requete de mise a jour des listener
 * @author Moncy christophe
 */
class Lecteur extends Thread{

	static public EPServiceProvider epService;
	private long vitesseDelecture;
	private FluxPosition fluxdata;
	
	
	public Lecteur(FluxPosition position) {
		vitesseDelecture = 200;
		epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = position;
	}

	public void accroche(FluxPosition f){
		fluxdata = f;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				liremouse();
				sleep(vitesseDelecture);
			} catch (InterruptedException e) {	e.printStackTrace();	}
		}
	}

	private void liremouse() throws InterruptedException {
		fluxdata.data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
		fluxdata.data.upDate();
	}
}
