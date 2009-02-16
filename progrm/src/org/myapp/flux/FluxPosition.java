package org.myapp.flux;

import org.myapp.event.Information;
import org.myapp.event.Position;


public class FluxPosition extends Flux<Position>{


	public FluxPosition(){
		data = new Position();
	}
	
	public FluxPosition(Position position){
		data = position;
	}
	
	@Override
	public void set(Position fe) {
		data.set(fe);
	}
	

    public int getPosX(){
    	return data.getPosX();
    }

    public int getPosY(){
    	return data.getPosY();
    	
    }


	@Override
	public void setFromFlux(Flux<? extends Information> flux) {
		//System.out.println(flux.getClass().getSimpleName());
		if((new String(flux.getClass().getSimpleName()).compareTo(new String("FluxPosition"))== 0))
		data = ((FluxPosition) flux).data;
		if((new String(flux.getClass().getSimpleName()).compareTo(new String("FluxFixation"))== 0))
		data = ((FluxFixation) flux).data.getPosition();
	}


}
