package org.myapp.event;

/**
 * upToDate : Indique que l'information contenue ds le flux est à jour.</br>
 * release :  Indique la date de créeation de l'information.</br>
 * </br>
 * Toutes recuperation d'information devra être faite en passant par les methodes </br>
 * getNOM_PARAMETRE()</br>
 * sous peine de recuperer des informations erronnéees
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
	// TODO ça devrai marcher,non ???
	// abstract void set( Information fe);
  
	@Override
	abstract public String toString();

}
