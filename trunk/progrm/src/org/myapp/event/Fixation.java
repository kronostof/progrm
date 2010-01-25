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

	
	/**
	 * 
	 * @return La valeur de la position en X
	 */
	public int getPosX(){
    	return position.getPosX();
	}
	/**
	 * 
	 * @return La valeur de la position en Y.
	 */
	public int getPosY(){
		return position.getPosY();
	}
	
	/**
	 * 
	 * @return La position de la derniere fixation
	 */
	public Position getPosition() {
		return position;
	}
	
	public long getTemps() {
		temps = System.currentTimeMillis() - release;
		return temps;
	}
	/*  setter	 */
	
	/**
	 * Place les coordonnée de la position en x,y.
	 * @param x :Position en x
	 * @param y :Position en y
	 */
	public void set(int x,int y){
			position.set(x, y);
	}

	
	@Override	public String toString() {	
		return position.toString() + "\t temps:" + getTemps()+ " millisecondes \t" + "date : " + getDate();
	}

	@Override	public Fixation get() {	return this;	}


	/**
	 * repond vrai si les position passée en parametre sont diff de celle presentes
	 * @param position2
	 * @return -True Uniquement si les coordonnée de la position parametre sont diff de l objet.
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