package org.myapp.module;

import java.util.HashMap;

import org.myapp.flux.Flux;

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
public abstract class module<E extends Flux,F extends Flux> extends Thread implements UpdateListener {

	public String nom;
	public String expression;
	public E fluxEntrant;
	public F fluxSortant;
	public int vitesseDeTraitement = 20;
	public EPStatement statement;
	static public EPServiceProvider epService;
	
	
	public module(){
		
	}
	abstract public void update(EventBean[] arg0, EventBean[] arg1);

	//abstract public UpdateListener getListener();
	
	abstract public void init(EPServiceProvider nepService);
	
	/**
	 * 
	 * Toutes les classe dérivant de module devrons proposer un fonction setup 
	 * prenant en parametre les argument propre au module.
	 * TODO On peut pas faire mieux ???
	 *  
	 * @return
	 */
	
	abstract public int setup(HashMap<String, Object> conf);
}
