package myapp.flux;

import myapp.event.Information;

public interface interfSetFromFlux {

	public void setFromFlux(Flux<? extends Information> flux);
}
