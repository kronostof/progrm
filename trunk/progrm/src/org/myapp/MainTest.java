package org.myapp;

import org.myapp.flux.FluxFixation;
import org.myapp.flux.FluxPosition;
import org.myapp.module.*;
import com.espertech.esper.client.EPStatement;


public class MainTest  extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args){
	
		

		FluxPosition position = new FluxPosition();
		FluxFixation fixation= new FluxFixation();
		//FluxBool fixeCentre= new FluxBool();
		//FluxBool versBas= new FluxBool();
		
		new Lecteur(position);
		//EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();

		
		moduleFixation listener =  new moduleFixation("tset", 33,position,fixation);
		//moduleFixationCentre listener2 =  new moduleFixationCentre("tset", 33,fixation,fixeCentre);
		//moduleBas listener3 =  new moduleBas("tset", 33,position,versBas);
		
		
		//epService = Lecteur.getInstance();
		//listener2.init(epService);
		//listener3.init(epService);

		EPStatement statement = Lecteur.getInstance().getEPAdministrator().createEPL(listener.expression);
		//EPStatement statement2 = epService.getEPAdministrator().createEPL(listener2.expression);
		//EPStatement statement3 = epService.getEPAdministrator().createEPL(listener3.expression);
		
		statement.addListener(listener);
		//statement2.addListener(listener2);
		//statement3.addListener(listener3);
		
		listener.start();
		//listener2.start();
		//listener3.start();	


// les dix modules 
/*
		ArrayList<FluxBool> ListeFluxBool= new ArrayList<FluxBool>();
		ArrayList<modulePosition> ListModuleRegion = new ArrayList<modulePosition>();
		ArrayList<EPStatement> ListStatement = new ArrayList<EPStatement>();

		modulePosition mR;
		FluxBool Fb;
		for( int i=0;i<10;i++){
			Fb = new FluxBool();
			mR = new modulePosition(new String("numero"+i),i,new Position(0,0),position,Fb);
			HashMap<String, Object> conf = new HashMap<String, Object>();
			String str = new String("select posX from org.myapp.module.moduleRegion where "+100*i+"<posX and posX<"+100*(i+1));
			 
			System.out.println(str);
			conf.put("expression",str);
			mR.setup(conf);
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
		}
	*/
		}
}