package org.myapp.event;


public class Bbool extends Information{


	protected boolean value;
	protected long temps;
	
	/**
	 * Cr�e un nouvelle instance de Bbool initialis�e a true
	 */
	public Bbool() {
		super();
		value = true;
		temps = 0;
	}
	
	/**
	 * Cr�e un nouvelle instance de Bbool initialis�e a la valeur de bValue
	 */
	public Bbool(Bbool bValue) {
		super();
		value = bValue.getValue();
		temps = bValue.getTemps();
	}
	
	/**
	 * Retourne la valeur de cet objet booleen.
	 */
	public boolean getValue() {
		return value;
	}


	/**@param b - La valeur que va prendre l objet booleen 
	 * @return true UNIQUEMENT si la valeur est chang�e en une autre.
	 */
	public boolean setValue(boolean b) {
		boolean T = (this.value != b);
		if (T)	{
			this.value = b;
			this.release = System.currentTimeMillis();
			}
		return T;
	}
	
	@Override
	public String toString() {
		return value + " temps:" + getTemps()+ " millisecondes \t" + "date : " + getDate();
	}

	@Override
	public Bbool get() {
		return this;
	}
}
