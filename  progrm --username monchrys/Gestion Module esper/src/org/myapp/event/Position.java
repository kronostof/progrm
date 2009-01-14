package org.myapp.event;

public class Position extends Information {

	protected float posX;
	protected float posY;

	
	public Position(){
		super();
		posX = 0;
		posY = 0;
	}

	public Position(float posX,float posY){
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public Position(Position position){
		super();
		this.posX = position.getPosX();
		this.posY = position.getPosY();
	}

	@Override
	public void init() {
		release= System.currentTimeMillis();
		posX = 0;
		posY = 0;
	}

	/*  getter	 */
	public float getPosX(){	    	return posX;    }
    public float getPosY(){	    	return posY;    }
    
    /*  setter */
    
    /** set a partir des position en x et y
     * @param x
     * @param y
     */
    public void set(float x,float y){
    	posX = x;
    	posY = y;
    }
    /** set a partir d un objet position; 
     * @param position
     */
    public void set(Position position){
    	posX = position.getPosX();
    	posY = position.getPosY();
    }

	@Override
	public Position get() {
		return null;
	}
	
    /** To string   */
    @Override	public String toString() {		return "X="+posX+" Y="+posY;	}
}
