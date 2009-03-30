package org.myapp.module;


import java.util.HashMap;
import org.myapp.event.Information;
import org.myapp.flux.Flux;
import org.myapp.flux.FluxPosition;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class ModuleTrace  extends module<FluxPosition ,FluxPosition> implements UpdateListener{

	
	
   // EPServiceProvider epService;
    
    /**
	 * Ce module permet la construction d'une trace a partir d'un flux d'information
	 * 
	 * @param String string : nom de l'élément appellant ce module
	 * @param Flux fluxEntrant
	 * @param String fluxSortant : nom du fichier ds lequel sera conservé la trace.
	 */
	public ModuleTrace(String string, FluxPosition fluxEntrant, String fluxSortant) {
		this.setFluxEntrant(fluxEntrant);
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {

		// TODO ici on traite le flux entrant afin de l enregistrer ds un fichier
	}

	//@Override	public void init(EPServiceProvider nepService) {		this.epService=nepService;	}
	
	public void run(){
		while(true){	    	
	    		System.out.println(getFluxEntrant().get().toString());
				}
	}


//	@Override
	public int setup(HashMap<String, Object> conf) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant){
		this.fluxEntrant = new FluxPosition();
		this.fluxEntrant.setFromFlux(fluxEntrant);
		
	}
}
