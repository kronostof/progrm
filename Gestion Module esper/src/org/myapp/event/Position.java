package org.myapp.event;


/**
 * @param posX : position en x.</br>
 * @param posY : position en y.</br>
 * </br>
 * 
 */
public class Position extends Information {

	protected float posX;
	protected float posY;

	/* constructeur */
	
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

	/*  getter	 */
	public float getPosX(){	    	return posX;    }
    public float getPosY(){	    	return posY;    }
    
    /*  setter */
    
	/** set a partir des position en x et y
	 * @param posX : position en x.</br>
	 * @param posY :  position en y.</br>
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
