package myapp.module.manager;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myapp.event.Information;
import myapp.flux.Flux;
import myapp.model.Shape;
import myapp.module.module;

/**
 * 
 * @author Moncy Christophe 10304320 UCBLyon1
 *	Cette classe implement les méthode pouvant agir sur un ensemble de module
 */
public class ModuleManager {

	private ArrayList<module<?,?>> arrayListModule = new ArrayList<module<?,?>>();
	private Flux<? extends Information> FLXS;
	
	
	public ModuleManager(Flux<? extends Information> FLXE) {
		// on initialise le gestionnaire de module avec le flux entrant de la forme le créeant.
		this.FLXS = FLXE;
		
	}
	/**
	 * cree une instance de module manager ayant comme flux entrant le Gaze
	 */
	public ModuleManager(Shape shape) {
		this.FLXS = shape.Gaze;
		
	}
	
	public void chainnage(module<?, ?> m){
		// on doit s'assure que les module soient comppatible.
		// On recupere le flux de sortie generale courant et on l utilise
		m.setFluxEntrant(FLXS);
		// On modifie le flux de sortie generale courant
		FLXS = m.getFluxSortant();
		this.arrayListModule.add(m);
	}

    public synchronized void pause() {
        for (module<?, ?> _module : arrayListModule) {
                 _module.pause();

        }
        
    }
}
