//import java.util.ArrayList;
//import java.util.List;

//import org.myapp.event.Evenement;
//import org.w3c.dom.Node;

import org.myapp.module.module;
import org.myapp.module.moduleFixation;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
//import com.espertech.esper.client.EPStatement;
//import com.sun.xml.internal.ws.api.server.Module;

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
	@SuppressWarnings("unchecked")
	private module listeEvent[];
	private long vitesseDelecture;
	private boolean ssstop;
	private int nbrEvent = 0;
	
	
	public Lecteur() {
		vitesseDelecture = 5000;
		ssstop = true;
		listeEvent = new module[5];
		epService = EPServiceProviderManager.getDefaultProvider();
	}



	@Override
	public void run() {
		while(ssstop){
			//epService.getEPRuntime().sendEvent(event);
			//epService.getEPRuntime().sendEvent(listeEvent[0]);//SendEvent();
			 try {
				 
				 SendEvent();
				sleep(vitesseDelecture);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				}
	}

	/*
	public void ajoutStatement(String expression) {
		// TODO Auto-generated method stub
		//epService.getEPAdministrator().createEPL(expression);
		EPStatement statement = epService.getEPAdministrator().createEPL(expression);
		
	}
	*/


	public void ajoutEvent(moduleFixation event1) {
		listeEvent[nbrEvent]=event1;
		nbrEvent++;
	}
	
	
	@SuppressWarnings("unchecked")
	public void ajoutModule(module m){
		System.out.println(m.expression);
		m.statement = epService.getEPAdministrator().createEPL(m.expression);
		m.statement.addListener(m);
		listeEvent[nbrEvent]=m;
		nbrEvent++;
	}
	
	/**
	 * trop moche pour etre vrai ! ! !
	 * voir array liste et tout ça
	 * 
	 * doit pouvoir faire "epService.getEPRuntime().sendEvent( X )" avec tout les evenement ajouté 
	 */
	public void SendEvent(){
		//int i=0;
		//while(i<listeEvent.size()){
		//System.out.println(listeEvent[0].expression);
		int i=0;
		while(i<nbrEvent)
		epService.getEPRuntime().sendEvent(listeEvent[i++]);
		//i++;}
	}



	public void sstop() {
		ssstop = false;
		
	}
	
}
