package myapp.module;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import myapp.event.Information;
import myapp.event.Position;
import myapp.flux.Flux;
import myapp.flux.FluxPosition;
import myapp.model.Shape;

import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;

/**
 * 
 * 
 * Ce module détermine si le gaze est proche de la position dtéerminé par Focus
 * La principale utilisation est : déterminer si l'utilisateur regarde vers la position Focus
 * @param string
 * @param i
 * @param position la position que l on va considérer
 * @param fluxEntrant
 * @param fluxSortant
 */
public class modulePosition extends module<FluxPosition, FluxPosition> implements UpdateListener {

    Position position;
//    EPServiceProvider epService;

    public modulePosition(Shape shape2, int i) {
        this.shape = shape2;
        this.nom = shape.getName();
        this.position = shape.getPosition();

        this.setFluxEntrant(new FluxPosition());
        this.setFluxSortant(new FluxPosition());

        expression = new String("select name,posX,posY,gposX,gposY from myapp.module.modulePosition where "
                + "(gposX - " + 20 + " ) < posX and posX < (gposX + " + 20 + " ) and "
                + "(gposY - " + 20 + " ) < posY and posY < (gposY + " + 20 + " )");

        init_module();
        start();
    }
    /*
    public modulePosition(String nom, int i, Position position2) {
    this.nom = nom;
    this.position = position2;
    this.setFluxSortant(new FluxPosition());
    expression =  new String("select posX,posY,gposX,gposY from org.myapp.module.modulePosition where "+
    "(gposX - "+20+" ) < posX and posX < (gposX + "+20+" ) and "+
    "(gposY - "+20+" ) < posY and posY < (gposY + "+20+" )");

    }


    public modulePosition(String string, int i,Position position, FluxPosition fluxEntrant, FluxPosition fluxSortant) {

    this.nom = string;
    this.position = position;
    this.setFluxEntrant(fluxEntrant);
    this.setFluxSortant(fluxSortant);
    expression =  new String("select posX,posY,gposX,gposY from org.myapp.module.modulePosition where "+
    "(gposX - "+20+" ) < posX and posX < (gposX + "+20+" ) and "+
    "(gposY - "+20+" ) < posY and posY < (gposY + "+20+" )");

    }

     */

    /**
     *  Cette methode est reéut a chaque envoie d un nvll evenement
     *
     *  les traitements a effectuer en fonction de la nature du flux entrant sont a y placer.
     */
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        //System.out.println(newEvents[0].get("name") + " " + getName());
        if (getName().compareTo(newEvents[0].get("name").toString()) == 0) {
            getFluxSortant().set(getFluxEntrant().get());
        }
        /* Pour recuperer des données propre a un evenement
         * event.get("avg(price)")
         * /!\ il faut que la methodes getXXX existe dans l'objet envoiyer par send donc dans le module.
         */

        //System.out.println("mp update" + shape.getName() + " " +getFluxSortant().data.toString());
        //System.out.println("\t module Position => FE"+ fluxEntrant.data.toString());
        //System.out.println("\t module Position => "+ getFluxSortant().data.toString() +"on regarde vers" + getgposX() + " | " + getgposY()) ;

        // * * * this.fluxSortant.data...
    }

    //@Override	public void init(EPServiceProvider nepService) {		this.epService=nepService;	}
    @Override
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
     *
     * @return
     */
    public float getgposX() {
        return getFluxEntrant().getPosX();
    }

    public float getgposY() {
        return getFluxEntrant().getPosY();
    }

    public float getposX() {
        return position.getPosX();
    }

    public float getposY() {
        return position.getPosY();
    }

    @Override
    public int setup(HashMap<String, Object> conf) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setFluxEntrant(Flux<? extends Information> fluxEntrant) {
        this.fluxEntrant = new FluxPosition();
        this.fluxEntrant.setFromFlux(fluxEntrant);
    }
}
