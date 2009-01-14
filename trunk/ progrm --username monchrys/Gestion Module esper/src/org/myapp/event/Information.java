package org.myapp.event;

/**
 * upToDate : Indique que l'information contenue ds le flux est � jour.</br>
 * release :  Indique la date de cr�eation de l'information.</br>
 * </br>
 * Toutes recuperation d'information devra �tre faite en passant par les methodes </br>
 * getNOM_PARAMETRE()</br>
 * sous peine de recuperer des informations erronn�ees
 * 
 * @author Silex
 *
 */
public abstract class Information {

	public boolean upToDate;
	public long release;
	
	public Information() {
		release = System.currentTimeMillis();
		upToDate=true;
	}
	
	abstract public void init();
  
	abstract public Information get();
	// TODO �a devrai marcher,non ???
	// abstract void set( Information fe);
  
	@Override
	abstract public String toString();

}
