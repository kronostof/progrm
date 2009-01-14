package org.myapp.event;
 


public class Fixation extends Information {

	
	private Position position;
	private long temps;						// Durée de la fixation en milliseconde


	public Fixation(){
		super();
		this.position = new Position();
		this.temps = 0;
	}
	
	public Fixation(Position p){
		super();
		position = new Position(p);
		temps = 0;
	}
	
	public void init(){
		position.init();
		temps = 0;
	}
	
	/*  getter	 */
	public float getPosX(){
    	return position.getPosX();
	}
	
	public float getPosY(){
		return position.getPosY();
	}
	
	public Position getPosition() {
		return position;
	}
	
	public long getTemps() {
		temps = System.currentTimeMillis() - release;
		return temps;
	}
	/*  setter	 */
	
	/**
	 * @param x :Position en x
	 * @param y :Position en y
	 */
	public void set(float x,float y){
		upToDate = true;

		if((position.posX != x ) | (position.posY != y )){
			position.posX = x;
			position.posY = y;
			this.release = System.currentTimeMillis();
		}
	}

	/* To string */
	@Override	public String toString() {	
		return position.toString() + " temps:" + getTemps()+ " millisecondes";
	}

	@Override	public Fixation get() {	return this;	}
}