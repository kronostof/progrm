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
	
	// reset le tmp indiquant depuis combien de temps cette nvll info est disponible
	// nvll ds le sens " l information pr�c. �tait diff.
	// @param release
	public Information() {
		release = System.currentTimeMillis();
		upToDate= System.currentTimeMillis();;
	}
	
	
	abstract public Information get();
  
	@Override
	abstract public String toString();
	

	/**
	 * fixe la date de r�alisation a l'heure courante.
	 */
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
