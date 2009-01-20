package org.lamia.src;

import org.myapp.event.Position;

public class Lecteur {

	float x,y;
	
	public void accroche(Position pos){
		pos.set(x, y);
	}
	
}



/********************

package org.myapp;
import java.awt.MouseInfo;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/ **
 *
 * Cette classe constitue le pré-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet dérivant de module) 
 * et 	son ajout au evennement listée ( ajoutStatement() )
 * 
 * la vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arrivé
 * elle rythme l'envoie de la requete de mise a jour des listener
 * @author Moncy christophe
 * /
class Lecteur extends Thread{

	
	private long vitesseDelecture;
	float x,y;
	
	
	public Lecteur() {
		
	}

	public void accroche(Position pos){
		pos.set(this.x,this.y);
	}
	

	
	
	@Override
	public void run() {
		while(true){
			try {
				//TODO
				sleep(vitesseDelecture);
			} catch (InterruptedException e) {	e.printStackTrace();	}
		}
	}

	private void liremouse() throws InterruptedException {
		fluxdata.data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
		fluxdata.data.upDate();
	}
}
*/