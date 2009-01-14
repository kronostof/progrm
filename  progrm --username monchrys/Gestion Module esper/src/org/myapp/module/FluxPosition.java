package org.myapp.module;


import java.awt.MouseInfo;
import org.myapp.event.Position;




	// lecture d'un fichier en fait en attendant de pouvoir lre ds la socket


 public class FluxPosition extends Flux<Position>
{
	
	
	public FluxPosition(){
		
		data = new Position();
		
	}
	
	public void run(){
		while(true){
			try {
				liremouse();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		
	}
	
    private void liremouse() throws InterruptedException {
    	data.set(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
    	//System.out.println(data.getPosX());
    	sleep(20);
	}
/*	public void lireFichier(String nomFichier) throws InterruptedException {
	        try {
	            FileReader reader = new FileReader(nomFichier);
	            int lu;
	            //char c;
	            do {
	                // on lit un caractère sous forme d'un entier:
	                lu = reader.read(); 
	                if (lu != -1) { // si on est pas à la fin du fichier
	                    //c = (char) lu;
	                    posX = (char)lu;
	                    //System.out.println("\t" + posX);
	                    sleep(100);
	                }
	            } while (lu != -1); // tant que l'on est pas à la fin du fichier
	            reader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Impossible de lire le fichier "
	                                    +nomFichier+" !");
	        } catch (IOException e) {
	            System.out.println("Erreur de lecture !");
	        }
	    }
  */
    
    public float getPosX(){
    	return data.getPosX();
    }

    public float getPosY(){
    	return data.getPosY();
    	
    }
    	
	@Override
	public synchronized Position get() {
		return data;
	}

 
	@Override
	public void init() {
		this.data = new Position();	
	}

	@Override
	public void set(Position fe) {
		// TODO Auto-generated method stub
		
	}

}
