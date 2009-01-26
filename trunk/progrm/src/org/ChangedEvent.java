package org;
import java.util.EventObject;

public class ChangedEvent extends EventObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8681372822724854194L;
	private int newVolume;
	
	public ChangedEvent(Object source, int newVolume){
		super(source);
		
		this.newVolume = newVolume;
	}
	
	public int getNewVolume(){
		return newVolume;
	}
}