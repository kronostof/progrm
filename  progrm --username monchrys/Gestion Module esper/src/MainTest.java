

import java.util.ArrayList;

import org.myapp.module.*;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;


public class MainTest  extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args){
	
		

		FluxPosition position = new FluxPosition();
		FluxFixation fixation= new FluxFixation();
		FluxBool fixeCentre= new FluxBool();
	//	FluxBool versBas= new FluxBool();
		
		Lecteur lecteur = new Lecteur(position);
		
		
		lecteur.start(); // on recupere la position du pts d attention.
		
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

		
		moduleFixation listener =  new moduleFixation("tset", 33,position,fixation);
		//moduleFixationCentre listener2 =  new moduleFixationCentre("tset", 33,fixation,fixeCentre);
		//moduleBas listener3 =  new moduleBas("tset", 33,position,versBas);
		
		
		listener.init(epService);
		//listener2.init(epService);
		//listener3.init(epService);
		
		EPStatement statement = epService.getEPAdministrator().createEPL(listener.expression);
		//EPStatement statement2 = epService.getEPAdministrator().createEPL(listener2.expression);
		//EPStatement statement3 = epService.getEPAdministrator().createEPL(listener3.expression);
		
		statement.addListener(listener);
		//statement2.addListener(listener2);
		//statement3.addListener(listener3);
		
		listener.start();
		//listener2.start();
		//listener3.start();	
		
		
// les dix modules 
		
		ArrayList<FluxBool> ListeFluxBool= new ArrayList<FluxBool>();
		ArrayList<moduleRegion> ListModuleRegion = new ArrayList<moduleRegion>();
		ArrayList<EPStatement> ListStatement = new ArrayList<EPStatement>();
	
		moduleRegion mR;
		FluxBool Fb;
		for( int i=0;i<30;i++){
			Fb = new FluxBool();
			mR = new moduleRegion(new String("numero"+i),i,position,Fb);
			
			EPStatement St;
			ListeFluxBool.add(Fb);
			ListModuleRegion.add(mR);
			mR.init(epService);
			St =epService.getEPAdministrator().createEPL(mR.expression);
			St.addListener(mR);
			mR.start();
			
			ListeFluxBool.add(Fb);
			ListModuleRegion.add(mR);
			ListStatement.add(St);
			
		//"select posX,posY from org.myapp.module.moduleFixationCentre.win:time(30 sec) where posX < 1248 and posX > 212 and posY< 492 and posY>105"
		}
		
	}
}