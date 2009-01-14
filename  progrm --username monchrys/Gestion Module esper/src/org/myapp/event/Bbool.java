package org.myapp.event;


public class Bbool extends Information{

	/**
	 * value	:oui ou non on fixe le milieu.
	 * temps 	: combien de temps a fixer le milieu.
	 */
	public boolean value;
	public long temps;
	
	@Override
	public void init() {
		
	}
	
	/**
	 * getter
	 * 
	 * @return
	 */
	public boolean getValue() {
		return value;
	}

	public long getTemps(){
		return temps;
	}
	
	/* setter	 */
	public void set(boolean value) {
		if(this.value != value){
			this.value = value;
		}
	}
	
	public void setOki(boolean value) {
		this.value = value;
	}
	
	
	/* to string	 */
	@Override
	public String toString() {
		return value + " " + temps;
	}

	@Override
	public Bbool get() {
		// TODO Auto-generated method stub
		return null;
	}
}
