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
	
	public Fixation(Fixation f){
		super();
		position = new Position(f.getPosition());
		release = f.release;
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
	public void set(int x,int y){
		//upToDate = true;

		//if((position.posX != x ) | (position.posY != y )){
			position.posX = x;
			position.posY = y;
		//	this.release = System.currentTimeMillis();
		//}
	}

	/* To string */
	@Override	public String toString() {	
		return position.toString() + " temps:" + getTemps()+ " millisecondes \t" + "date : " + getDate();
	}

	@Override	public Fixation get() {	return this;	}


	/**
	 * repond vrai si les position passer en parametre sont diff de celle presentes
	 * @param position2
	 * @return
	 */
	public boolean setPosition(Position position2) {
		boolean T = ((this.getPosX() != position2.getPosX()) | (this.getPosY() != position2.getPosY()));
		if (T) this.set(position2.getPosX(), position2.getPosY());
		return T;
	}
	
	public boolean setPosition(int x, int y) {
		boolean T = ((this.getPosX() != x) | (this.getPosY() != y));
		if (T) this.set(x, y);
		return T;
	}
	

}