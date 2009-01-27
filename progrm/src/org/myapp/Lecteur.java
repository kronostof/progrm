package org.myapp;
import java.awt.MouseInfo;
import java.net.SocketException;

import org.lamia.src.OuvrirSocket;
import org.lamia.src.RecevoirData;
import org.lamia.src.fenetre;
import org.myapp.event.Position;
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
public class Lecteur extends Thread{

	static public EPServiceProvider epService;
	private long vitesseDelecture;
	private FluxPosition fluxdata;
	
	
	public Lecteur(FluxPosition position) {
		vitesseDelecture = 20;
		epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = position;
		
	   
	}
		public Lecteur() {
			vitesseDelecture = 100;
			epService = EPServiceProviderManager.getDefaultProvider();
			fluxdata = new FluxPosition();
			OuvrirSocket socket;
			try {
				socket = new OuvrirSocket();
				fenetre f = new fenetre(socket);
			    f.setVisible(true);
			    RecevoirData  m = new RecevoirData (socket,fluxdata);
			    m.start();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * le flux de position passé sera le même flux de position fournie par Lecteur.
	 * @param f
	 */
	public void accroche(FluxPosition f){
		System.out.println("ICI");
		f.data = fluxdata.data ;
	}
	
//	public void accroche(Position pos){	}
	
	
	@Override
	public void run() {
		while(true){
			try {
				//liremouse();
				sleep(vitesseDelecture);
			} catch (InterruptedException e) {	e.printStackTrace();	}
		}
	}

	private void liremouse() throws InterruptedException {
		fluxdata.data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
		fluxdata.data.upDate();
	}
}
