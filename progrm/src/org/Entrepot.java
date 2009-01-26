package org;

import java.util.HashMap;

import org.myapp.FormeModel;

public class Entrepot {

	HashMap<String, FormeModel> stock;
	
	
	public Entrepot() {
		stock = new HashMap<String, FormeModel>();
		
	}
	
	
	public void put(String key,FormeModel value){
		stock.put(key, value);
	}
}
