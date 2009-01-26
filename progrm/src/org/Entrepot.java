package org;

import java.util.HashMap;
import org.myapp.ModelForme;

public class Entrepot {

	HashMap<String, ModelForme> stock;
	
	
	public Entrepot() {
		stock = new HashMap<String, ModelForme>();
		
	}
	
	
	public void put(String key,ModelForme value){
		stock.put(key, value);
	}
}
