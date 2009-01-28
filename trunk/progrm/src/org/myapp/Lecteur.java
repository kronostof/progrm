package org.myapp;
import java.awt.MouseInfo;
/*
import java.net.SocketException;

import org.lamia.src.OuvrirSocket;
import org.lamia.src.RecevoirData;
import org.lamia.src.fenetre;
import org.myapp.event.Position;
*/
import org.myapp.flux.FluxPosition;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

/**
 * Cette classe constitue le pr�-lecteur du flux elle offre le "EPServiceProvider"
 * sa conception modulaire permet l'ajout de nouveau module de comprehention du flux
 * par 	la construction du module (objet d�rivant de module) 
 * et 	son ajout au evennement list�e ( ajoutStatement() )
 * 
 * la vitesse de lecture est celle a laquel on considere qu'une nouvelle info est arriv�
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
	private long vitesseDelecture;
	private FluxPosition fluxdata;
	
	
	public Lecteur(FluxPosition position) {
		vitesseDelecture = 20;
	//	epService = EPServiceProviderManager.getDefaultProvider();
		fluxdata = position; 
	}
	
	public Lecteur() {
		vitesseDelecture = 100;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	/**
	 * le flux de position pass� sera le m�me flux de position fournie par Lecteur.
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
				liremouse();
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

Exemple utilis�e.

http://smeric.developpez.com/java/uml/singleton/

/ ** Exemple d'impl�mentation d'un singleton dans le cas du multithreading.<p>
  * Cet exemple ne fait rien.
  * /

public class Singleton {

    / ** R�cup�re l'instance unique de la class Singleton.<p>
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

    / ** Constructeur red�fini comme �tant priv� pour interdire
    * son appel et forcer � passer par la m�thode <link
    * /
    private Singleton() {
    }

    / ** L'instance statique * /
    private static Singleton instance;
    / ** objet pour la synchronisation. <p>
     * j'ajoute deux "soulign�s" (__) au nom de l'attribut car il n'a
     * qu'un int�r�t purement technique.
     * /
    private static Object objetSynchrone__;
}

*/