
import org.myapp.module.*;
import org.myapp.module.moduleFixation;
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
		FluxBool versBas= new FluxBool();
		
		position.start(); // on recupere la position du pts d attention.
		
		EPServiceProvider epService = EPServiceProviderManager.getDefaultProvider();
		
		
		moduleFixation listener =  new moduleFixation("tset", 33,position,fixation);
		moduleFixationCentre listener2 =  new moduleFixationCentre("tset", 33,fixation,fixeCentre);
		moduleBas listener3 =  new moduleBas("tset", 33,position,versBas);
		
		listener.init(epService);
		listener2.init(epService);
		listener3.init(epService);
		
		EPStatement statement = epService.getEPAdministrator().createEPL(listener.expression);
		EPStatement statement2 = epService.getEPAdministrator().createEPL(listener2.expression);
		EPStatement statement3 = epService.getEPAdministrator().createEPL(listener3.expression);
		
		statement.addListener(listener);
		statement2.addListener(listener2);
		statement3.addListener(listener3);
		
		listener.start();
		listener2.start();
		listener3.start();
		
		
		
	}
}