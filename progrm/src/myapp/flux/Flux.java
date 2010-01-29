package myapp.flux;

import myapp.event.Information;

 
/**
 * 
 * @author Moncy christophe 10304320 
 * <br>Ucb Lyon1 
 *
 * @param <E extends Information> de type Data, contient les donnée composant le flux.
 */
public abstract class Flux<E extends Information> implements interfSetFromFlux{
	

	public E data ;
	
	public E get(){
		return data;
	}
	
	abstract public void set(E fe);
	
	
	public long getDate(){
		return data.getDate();
	}
	
	public long getTemps(){
		return data.getTemps();
	}
	
	public void resetTemps() {
		data.resetTemps();	
	}
	
	public boolean isFresh(long marge){
		return data.isFresh(marge);
	}
}