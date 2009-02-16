package org.myapp.module;

import org.myapp.event.Information;
import org.myapp.flux.Flux;


public interface interfModule{

	public void setFluxEntrant(Flux<? extends Information> fluxEntrant);

}