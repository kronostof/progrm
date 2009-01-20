package org.asma;
import javax.swing.JPanel;


public class Forme {
	int position_x	= 10;
	int position_y = 10;
	int longueur = 10;
	int largeur = 10;
	
	public Forme(){
	
	}
    public Forme(int position_x,int position_y, int longueur, int largeur){
    	this.position_x = position_x; 
    	this.position_y = position_y;
    	this.longueur = longueur;
    	this.largeur = largeur;
    }
    public void setPositionX(int position_x){
        this.position_x = position_x;
    }
    public void setPositionY(int position_y){
    	this.position_y = position_y;
    }
    public void setLongueur(int longueur){
    	this.longueur = longueur	;
    }
    public void setLargeur(int largeur){
    	this.largeur = largeur	;
    }
    public int getPositionX(){
    	return position_x	;
    }
    public int getPositionY(){
    	return position_y	;
    }
    public int getLongueur(){
    	return longueur	;
    }
    public int getLargeur(){
    	return largeur	;
    }
    public void draw(JPanel panel){
    	
    }
}
