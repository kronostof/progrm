package org.myapp.module;

import org.myapp.event.Bbool;
import org.myapp.module.Flux;


public class FluxBool extends Flux<Bbool> {

	
	public FluxBool(){
		data = new Bbool();
	}

	/** setter 
	 * c est principalement par cette methode que le flux sera modifiée
	 * on veut que le flux conserve en memoire la date la plus ancienne du passage a l'état de la valeur boolenne.
	 */
	@Override
	public void set(Bbool b) {
		if(!data.isFresh(40))
			data.resetTemps();
		data.setValue(b.getValue());
		data.upDate();
	}
	
	public void set(boolean b) {
		//data.resetTemps();
		data.setValue(b);
		data.upDate();
	}
	
	public long getDate(){
		return data.getDate();
	}
}
