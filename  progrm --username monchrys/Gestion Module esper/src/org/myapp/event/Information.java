package org.myapp.event;

/**
 * @param upToDate : Indique que l'information contenue ds le flux est � jour.</br>
 * @param release :  Indique la date de cr�eation de l'information.</br>
 * </br>
 * Toutes recuperation d'information devrons �tre faite en passant par les methodes </br>
 * getNOM_PARAMETRE()</br>
 * sous peine de recuperer des informations erronn�ees
 * 
 * @author Silex
 *
 */
public abstract class Information {

	protected long upToDate;
	protected long release;
	
	
	public Information() {
		release = System.currentTimeMillis();
		upToDate= System.currentTimeMillis();;
	}
	
	
	abstract public Information get();
  
	@Override
	abstract public String toString();
	
	public void resetTemps() {
		release = System.currentTimeMillis();	
	}
	
	// Depuis combien de temps cette info est disponible
	public long getTemps() {
		return System.currentTimeMillis() - release;	
	}
	
	// La date de publication de cette information
	public long getDate() {
		return release;
	}
	
	
	public void upDate(){
		upToDate = System.currentTimeMillis();
	}
	
	public boolean isFresh(long marge){
		return ((System.currentTimeMillis() - upToDate) < marge);
	}
}
