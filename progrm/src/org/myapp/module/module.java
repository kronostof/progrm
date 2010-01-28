package org.myapp.module;

import java.util.HashMap;

import org.myapp.Lecteur;
import org.myapp.event.Information;
import org.myapp.flux.Flux;
import org.myapp.model.Shape;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;


/**
 * Reçoit un flux, le traite et en propose un autre.
 * @author Moncy christophe 10304320 
 * <br>Ucb Lyon1 
 * @param <Type de flux entrant, Type de flux Sortant>
 *
 */
public abstract class module<E extends Flux<? extends Information>,F extends Flux<? extends Information>> extends Thread implements UpdateListener,interfModule {
 
	
	public String nom;
	public String expression;
	protected E fluxEntrant;
	protected F fluxSortant;
	public int vitesseDeTraitement = 20;
	public EPStatement statement;
	static public EPServiceProvider epService = Lecteur.getInstance();
	
	public Shape shape = null;
	
	
	public module(){

	}
	abstract public void update(EventBean[] arg0, EventBean[] arg1);
	
	public void init_module(){
    	EPStatement statement = Lecteur.getInstance().getEPAdministrator().createEPL(this.expression);
	statement.addListener(this);
	}

	//abstract public UpdateListener getListener();

	//abstract public void init(EPServiceProvider nepService);

	/**
	 * 
	 * Toutes les classe dérivant de module devrons proposer un fonction setup
	 * prenant en parametre les argument propre au module.
	 * TODO On peut pas faire mieux ???
	 *  
	 * @return
	 */
	abstract public int setup(HashMap<String, Object> conf);
	/**
	 * @param fluxEntrant the fluxEntrant to set
	 *
	 */
	/*
	public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
		System.out.println("\t ds module::setFluxEntrant("+fluxEntrant.getClass()+")");
		this.fluxEntrant.setFromFlux(fluxEntrant);	
	}
	*/
	/**
	 * @return the fluxEntrant
	 */
	public E getFluxEntrant() {
		return fluxEntrant;
	}
	/**
	 * @param fluxSortant the fluxSortant to set
	 */
	public void setFluxSortant(F fluxSortant) {
		this.fluxSortant = fluxSortant;
	}
	/**
	 * @return the fluxSortant
	 */
	public F getFluxSortant() {
		return fluxSortant;
	}
	public void setFluxEntrant(Class<? extends Flux<?>> class1,
			Flux<? extends Information> flxs) {
			System.out.println(class1);
		
	}
}
