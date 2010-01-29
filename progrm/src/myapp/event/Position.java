package myapp.event;

import java.awt.Point;



/**
 * @param posX : position en x.</br>
 * @param posY : position en y.</br>
 * </br>
 * 
 */
public class Position extends Information{

	protected Point point;
	/* constructeur */
	
	public Position(){
		super();
		point = new Point();
	}

	public Position(int posX,int posY){
		super();
		point = new Point(posX,posY);
	}

	public Position(Position position){
		super();
		point = new Point(position.getPoint());
	}

	
	
	
	/**
	 * 
	 * @param pt
	 * @return Returns the distance from this Position to a specified Position.
	 */
	public double distance(Position pt){
		return point.distance(pt.getPoint());
	}
	
	/**
	 * 
	 * @return Retourn la position en x.
	 */
	public int getPosX(){	    	return point.x;    }
	/**
	 * 
	 * @return Retourn la position en y.
	 */
    public int getPosY(){	    	return point.y;    }
    @Override
	public Position get() {
		return this;
	}
    
    public Point getPoint() {
		return point;
	}
    
    
	/** Changes the point to have the specified location.
	 * @param posX : position en x.</br>
	 * @param posY :  position en y.</br>
	 */
 	public void set(int x,int y){
    	point.setLocation(x, y);
    }
	/** Sets the location of the point to the specified location.
	 * @param position
	 */
    public void set(Position position){
    	point.setLocation(position.getPoint());
    	upDate();
    }

	
	
	
	
    /** To string   */
    @Override	public String toString() {		return point.toString() ;/* + " " + this.upToDate + " " + this.release;*/ 	}

    /**
     * Déplace le point vers le point spécfié d'une valeur de
     * @param data
     * @param i
     */
	public void approche(Position data, int i){
		if (distance(data) > 100)
		{			// on s'interesse a la position vers laquelle on va aller
			int cx=0,dx = data.getPosX() - getPosX();
			int cy=0,dy = data.getPosY() - getPosY();
			if (dx != 0) cx = new Integer((int) (dx/distance(data)*i)).intValue();
			if (dy != 0) cy = new Integer((int) (dy/distance(data)*i)).intValue();

			point.translate(cx,cy);
			//System.out.println("hey hey" + dx/distance(data)*i + " " + dx + " " + distance(data) );
		}
	}

	public void eloigne(Position data, int i) {
		if (distance(data) < 100){			// on s'interesse a la position vers laquelle on va aller
			int cx=0,dx = data.getPosX() - getPosX();
			int cy=0,dy = data.getPosY() - getPosY();
			if (dy != 0) cx = new Integer((int) (dx/distance(data)*i)).intValue();
			if (dx != 0) cy = new Integer((int) (dy/distance(data)*i)).intValue();

			point.translate(cx,cy);
			
		}
		
	}

}
