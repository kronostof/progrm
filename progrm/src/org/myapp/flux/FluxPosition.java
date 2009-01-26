package org.myapp.flux;

//import java.awt.MouseInfo;
import org.myapp.event.Position;


public class FluxPosition extends Flux<Position>{
	
	
	public FluxPosition(){
		data = new Position();
	}
	
	public FluxPosition(Position position){
		data = position;
	}
	
	/*
	public void run(){
		while(true){
			try {
				liremouse();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
    private void liremouse() throws InterruptedException {
    	data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
    	sleep(20);
	}
    */
    public int getPosX(){
    	return data.getPosX();
    }

    public int getPosY(){
    	return data.getPosY();
    	
    }

	@Override
	public void set(Position fe) {
		// TODO Auto-generated method stub
		
	}
}
