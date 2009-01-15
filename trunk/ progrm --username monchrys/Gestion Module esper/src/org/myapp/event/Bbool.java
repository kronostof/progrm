package org.myapp.event;


public class Bbool extends Information{

	/**
	 * value	:oui ou non on fixe le milieu.
	 * temps 	: combien de temps cette information est dans cet état.
	 */
	protected boolean value;
	protected long temps;
	
	/* constructeur */
	
	public Bbool() {
		super();
		value = true;
		temps = 0;
	}
	
	public Bbool(Bbool b) {
		super();
		value = b.getValue();
		temps = b.getTemps();
	}
	
	/* getter  */
	public boolean getValue() {
		return value;
	}

	public long getTemps(){
		temps = System.currentTimeMillis() - release;
		return temps;
	}
	
	public long getDate(){
		return release;
	}
	
	/* setter	 */
	/**@param b 
	 * @return true si la valeur est changée en une autre.
	 */
	public boolean setValue(boolean b) {
		boolean T = (this.value != b);
		if (T)	{
			this.value = b;
			this.release = System.currentTimeMillis();
			}
		return T;
	}
	
	/* to string	 */
	@Override
	public String toString() {
		return value + " temps:" + getTemps()+ " millisecondes \t" + "date : " + getDate();
	}

	@Override
	public Bbool get() {
		// TODO Auto-generated method stub
		return null;
	}
}
