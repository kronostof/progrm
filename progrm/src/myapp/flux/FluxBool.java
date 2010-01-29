package myapp.flux;

import myapp.flux.Flux;
import myapp.event.Bbool;
import myapp.event.Information;


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
		data.resetTemps();
		data.setValue(b);
		data.upDate();
	}
	
	public long getDate(){
		return data.getDate();
	}

	@Override
	public void setFromFlux(Flux<? extends Information> flux) {
		if((new String(flux.getClass().getSimpleName()).compareTo(new String("FluxBool"))== 0))
			data = ((FluxBool) flux).data;
		if((new String(flux.getClass().getSimpleName()).compareTo(new String("FluxPosition"))== 0))
			data = new Bbool();
	}
}
