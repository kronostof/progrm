package myapp.module;

import java.util.HashMap;

import myapp.event.Information;
import myapp.event.Position;
import myapp.flux.Flux;
import myapp.flux.FluxFixation;
import myapp.flux.FluxPosition;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.EventBean;
import myapp.model.Shape;


public class moduleFixation extends module<FluxPosition, FluxFixation> implements UpdateListener {

    /**
     * parametre
     */
    private Position pos, lastpos;
    //private FluxPosition fluxEntrant;
    //EPServiceProvider epService;

    /**
     * partie faiant l'update
     * on ne rajoute ds le flux que de nouvelle information
     */
    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        this.getFluxSortant().set(this.getFluxEntrant().getPosX(), this.getFluxEntrant().getPosY());
        // System.out.println("\t"+nom+"\t module Fixation FXE:=> "  + this.fluxEntrant.data.toString());
        // System.out.println("\t"+nom+"\t module Fixation FXS:=> "  + this.fluxSortant.data.toString());
        // System.out.println(" ICI " + this.getFluxEntrant().getPosX()+ " | " +this.getFluxEntrant().getPosY());
        shape.firePositionChangee();
    }

    //public void init(EPServiceProvider epService){    	this.epService=Lecteur.getInstance();    }
    public moduleFixation(String nom,Shape shape2, int i) {
        super();
        this.nom = nom;
        this.shape = shape2;
        pos = new Position();
        lastpos = new Position();
        setFluxEntrant(new FluxPosition());
        setFluxSortant(new FluxFixation());
        expression = "select name,posX,posY,lastposX,lastposY from myapp.module.moduleFixation.win:time(5 sec) "
                + "where posX < (lastposX+3) and  posX > (lastposX-3)"
                + " and  posY < (lastposY+3) and posY > (lastposY-3)";
        init_module();
        start();
    }

    /**
     * 
     * @param Nom 
     * @param i
     * @param position
     * @param fixation
     */
    /*
    public moduleFixation(String nom, int i, FluxPosition position,FluxFixation fixation) {
    super();
    this.nom = nom;
    pos = new Position();
    lastpos = new Position();
    setFluxEntrant(position);
    setFluxSortant(fixation);
    expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
    "where posX < (lastposX+30) and  posX > (lastposX-30)" +
    " and  posY < (lastposY+30) and posY > (lastposY-30)";
    }
    
    public moduleFixation(String string, int i, FluxPosition position) {
    super();
    pos = new Position();
    lastpos = new Position();
    setFluxSortant(new FluxFixation());
    expression =  "select posX,posY,lastposX,lastposY from org.myapp.module.moduleFixation.win:time(5 sec) "+
    "where posX < (lastposX+30) and  posX > (lastposX-30)" +
    " and  posY < (lastposY+30) and posY > (lastposY-30)";
    }
    
     */
    public void run() {
        while (true) {
            try {
                if (getFluxEntrant().isFresh(40)) {
                    epService.getEPRuntime().sendEvent(this);
                    lastpos.set(pos);
                    pos.set(getFluxEntrant().data);
                    //System.out.println(pos.toString() + " " + lastpos.toString());
                }

                sleep(vitesseDeTraitement);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public float getPosX() {
        return getFluxEntrant().getPosX();
    }

    public float getPosY() {
        return getFluxEntrant().getPosY();
    }

    public float getlastposX() {
        return lastpos.getPosX();
    }

    public float getlastposY() {
        return lastpos.getPosY();
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
