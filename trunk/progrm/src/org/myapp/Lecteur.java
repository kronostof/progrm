package org.myapp;
import java.awt.MouseInfo;
import java.net.SocketException;
/*
import java.net.SocketException;

import org.lamia.src.OuvrirSocket;
import org.lamia.src.RecevoirData;
import org.lamia.src.fenetre;
import org.myapp.event.Position;
 */
import org.lamia.src.OuvrirSocket;
import org.lamia.src.RecevoirData;
import org.lamia.src.fenetre;
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 * Cette classe constitue le pré-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet dérivant de module) 
 * et 	son ajout au evennement listée ( ajoutStatement() )
 * 
 * la vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arrivé
 * elle rythme l'envoie de la requete de mise a jour des listener
 * 
 * 
 * @author Moncy christophe
 * 
 * 
 * 
 * Designe patern : SINGLETON
 */
public class Lecteur extends Thread{

	//private EPServiceProvider epService;
	private static EPServiceProvider instance;
	//private static Object objetSynchrone__;
	private long vitesseDelecture = 20;
	private static FluxPosition fluxdata;
	private boolean boolEchecSocket = false;


	public Lecteur(FluxPosition position) {
		//vitesseDelecture = 20;
		//	epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = position;
		this.start();
	}

	public Lecteur() {
		//vitesseDelecture = 20;
		//	epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = new FluxPosition();
/*
		OuvrirSocket socket;
		try {
			socket = new OuvrirSocket();
			fenetre f = new fenetre(socket);
			f.setVisible(true);
			RecevoirData  m = new RecevoirData (socket,fluxdata);
			m.start();
		} catch (SocketException e) {
			boolEchecSocket = true;
			System.out.println("echec socket");
			e.printStackTrace();
		}
		*/

		this.start();
	}

	/**
	 * le flux de position passé sera le même flux de position fournie par Lecteur.
	 * @param f
	 */
	public static void accroche(FluxPosition f){
		System.out.println("Lecteur:accroche");
		f.data = fluxdata.data ;
	}

	//	public void accroche(Position pos){	}


	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
		
			e1.printStackTrace();
		}
//		if (boolEchecSocket)
			while(true){
				try {
					liremouse();
					System.out.println(fluxdata.data.toString());
					sleep(vitesseDelecture);
				} catch (InterruptedException e) {	e.printStackTrace();	}
			}
	}


	public static EPServiceProvider getInstance(){
		if (null == instance) { // Premier appel
			//	 synchronized(objetSynchrone__) {
			if (null == instance) {
				instance = EPServiceProviderManager.getDefaultProvider();
				//          }
			}
		}
		return instance;
	}



	// FONCTION TEMPORAIRE
	private void liremouse() throws InterruptedException {
		fluxdata.data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
		fluxdata.data.upDate();
	}
}


/*

Exemple utilisée.

http://smeric.developpez.com/java/uml/singleton/

/ ** Exemple d'implémentation d'un singleton dans le cas du multithreading.<p>
 * Cet exemple ne fait rien.
 * /

public class Singleton {

    / ** Récupère l'instance unique de la class Singleton.<p>
 * Remarque : le constructeur est rendu inaccessible
 * /
    public static Singleton getInstance() {
        if (null == instance) { // Premier appel
            synchronized(objetSynchrone__) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    / ** Constructeur redéfini comme étant privé pour interdire
 * son appel et forcer à passer par la méthode <link
 * /
    private Singleton() {
    }

    / ** L'instance statique * /
    private static Singleton instance;
    / ** objet pour la synchronisation. <p>
 * j'ajoute deux "soulignés" (__) au nom de l'attribut car il n'a
 * qu'un intérêt purement technique.
 * /
    private static Object objetSynchrone__;
}

 */