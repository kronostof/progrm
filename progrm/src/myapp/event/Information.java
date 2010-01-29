package myapp.event;

/**
 * @param upToDate : Indique que l'information contenue ds le flux est à jour.</br>
 * @param release :  Indique la date de créeation de l'information.</br>
 * </br>
 * Toutes recuperation d'information devrons être faite en passant par les methodes </br>
 * getNOM_PARAMETRE()</br>
 * sous peine de recuperer des informations erronnées
 * 
 * @author Silex
 *
 */
public abstract class Information {

	protected long upToDate;
	protected long release;
	
	// reset le tmp indiquant depuis combien de temps cette nvll info est disponible
	// nvll ds le sens " l information prc. était diff.
	// @param release
	public Information() {
		release = System.currentTimeMillis();
		upToDate= System.currentTimeMillis();;
	}
	
	
	abstract public Information get();
  
	@Override
	abstract public String toString();
	

	/**
	 * fixe la date de réalisation a l'heure courante.
	 */
	public void resetTemps() {
		release = System.currentTimeMillis();	
	}
	
	/**
	 * 
	 * @return Depuis combien de temps cette donnée est a cette valeur.
	 */
	public long getTemps() {
		return System.currentTimeMillis() - release;	
	}
	
	/**
	 * 
	 * @return La date de publication de cette information.
	 */
	public long getDate() {
		return release;
	}
	
	/**
	 *  Indique que l'information contenue est récente.
	 */
	public void upDate(){
		upToDate = System.currentTimeMillis();
	}
	
	/**
	 * 
	 * @param delai
	 * @return - true si la donnée date de moins de 'delai' ms.
	 */
	public boolean isFresh(long delai){
		return ((System.currentTimeMillis() - upToDate) < delai);
	}
}
