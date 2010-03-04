package myapp.module.action;

import java.util.HashMap;

import myapp.event.Information;
import myapp.event.Position;
import myapp.flux.Flux;
import myapp.flux.FluxBool;
import myapp.flux.FluxPosition;
import myapp.model.Shape;
import myapp.module.module;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

public class ModuleSetToPosition extends module<FluxPosition, FluxBool> implements UpdateListener, ModuleAction {

    Shape shape;
    double distance = 0;

    public ModuleSetToPosition(Shape shape2, int i, Position position, FluxPosition fluxEntrant) {
        super();
        shape = shape2;
        this.setFluxEntrant(fluxEntrant);

        setFluxSortant(new FluxBool());
        expression = "select name,distance from myapp.module.action.ModuleSetToPosition where distance>5";

        init_module();
        start();
    }

    /**
     *  Cette methode est re�ut a chaque envoie d un nvll evenement
     *
     *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
     */
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        //if (getName().compareTo(newEvents[0].get("name").toString()) == 0)
        {
            shape.getPosition().set(getFluxEntrant().data);
            shape.firePositionChangee();
        }
    }

    /**
     * Le coeur du module.
     * On peut en choisir le rythme
     *  la ligne "epService.getEPRuntime().sendEvent(this);"
     *  envoie l'�venement 'MODEL' au gestionnaire d'�venement
     *
     *  les traitement a effectuer independament de la nature des flux entrant et sortant sont a y placer.
     */
    public void run() {
        while (true) {

            //if (getFluxEntrant().isFresh(20))
            epService.getEPRuntime().sendEvent(this);

            try {
                sleep(vitesseDeTraitement);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sleepNow();
        }
    }

    public int getposX() {
        return shape.getPosition().getPosX();
    }

    public double getdistance() {
        return shape.getPosition().getPoint().distance(getFluxEntrant().get().getPoint());
    }

    @Override
    public int setup(HashMap<String, Object> conf) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
        this.fluxEntrant = new FluxPosition();
        this.fluxEntrant.setFromFlux(fluxEntrant);

    }
}
