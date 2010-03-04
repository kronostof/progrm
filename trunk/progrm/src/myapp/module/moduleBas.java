package myapp.module;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import myapp.event.Bbool;
import myapp.event.Information;
import myapp.flux.Flux;
import myapp.flux.FluxBool;
import myapp.flux.FluxPosition;

//import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class moduleBas extends module<FluxPosition, FluxBool> implements UpdateListener {

    // CHK UML 28 EPServiceProvider epService;
    /**
     * Indique si l'utilisateur regarde en bas !
     *
     * @param string
     * @param i
     * @param fluxe
     * @param fluxs
     */
    public moduleBas(String string, int i, FluxPosition fluxe, FluxBool fluxs) {


        setFluxEntrant(fluxe);
        setFluxSortant(fluxs);

        expression = new String("select posY from myapp.module.moduleBas "
                + " where posY>500");
    }

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        this.getFluxSortant().set(new Bbool());
        System.out.println("\t module Bas => " + getFluxSortant().data.toString());

    }

    //@Override	public void init(EPServiceProvider nepService) {		this.epService=nepService;		}
    public void run() {
        while (true) {

            if (getFluxEntrant().isFresh(40)) {
                epService.getEPRuntime().sendEvent(this);
            }
            try {
                sleep(vitesseDeTraitement);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sleepNow();

        }
    }

    /**
     * @param borneSup: valeur représantant ce que l on considere
     * comme region basse de l'écrant en pourcentage de la surfaces totale.
     *
     * @return
     */
    public int setup(int borneSup) {
        expression = new String("select posY from myapp.module.moduleBas"
                + " where posY>" + borneSup);
        return 0;
    }

    @Override
    public int setup(HashMap<String, Object> conf) {
        // TODO Auto-generated method stub
        // expression
        // delai
        return 0;
    }

    public float getPosX() {
        return getFluxEntrant().data.getPosX();
    }

    public float getPosY() {
        return getFluxEntrant().data.getPosY();
    }

    public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
        this.fluxEntrant = new FluxPosition();
        this.fluxEntrant.setFromFlux(fluxEntrant);

    }
}
