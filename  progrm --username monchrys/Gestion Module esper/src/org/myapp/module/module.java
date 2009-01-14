package org.myapp.module;



import org.myapp.event.Information;


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
public abstract class module<E extends Information,F extends Information> extends Thread implements UpdateListener {

	public String nom;
	public String expression;
	public Flux<E> fluxEntrant;
	public Flux<F> fluxSortant;
	public int vitesseDeTraitement = 20;
	public EPStatement statement;
	static public EPServiceProvider epService;
	
	
	public module(){
		
	}
	abstract public void update(EventBean[] arg0, EventBean[] arg1);

	//abstract public UpdateListener getListener();
	
	abstract public void init(EPServiceProvider nepService);
}
