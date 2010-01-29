package myapp.module;

import myapp.event.Information;
import myapp.flux.Flux;


public interface interfModule{

	public void setFluxEntrant(Flux<? extends Information> fluxEntrant);

}