package org.myapp.module;

import org.myapp.event.Information;

 
/**
 * 
 * @author Moncy christophe 10304320 
 * <br>Ucb Lyon1 
 *
 * @param <E extends Information> de type Data, contient les donnée composant le flux.
 */
abstract class Flux<E extends Information> extends Thread{
	

	public E data ;
	
	
	/** @return renvoi l'élément courant du flux	 */
	abstract public E get();
	abstract public void set(E fe);
	
	public void init(){
		data.init();
	}
}
