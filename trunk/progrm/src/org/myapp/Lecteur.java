package org.myapp;
import java.awt.MouseInfo;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 *
 * Cette classe constitue le pr�-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet d�rivant de module) 
 * et 	son ajout au evennement list�e ( ajoutStatement() )
 * 
 * la vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arriv�
 * elle rythme l'envoie de la requete de mise a jour des listener
 * @author Moncy christophe
 */
public class Lecteur extends Thread{

	static public EPServiceProvider epService;
	private long vitesseDelecture;
	private FluxPosition fluxdata;
	
	
	public Lecteur(FluxPosition position) {
		vitesseDelecture = 200;
		epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = position;
	}

	/**
	 * le flux de position pass� sera le m�me flux de position fournie par Lecteur.
	 * @param f
	 */
	public void accroche(FluxPosition f){
		f.data = fluxdata.data ;
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
