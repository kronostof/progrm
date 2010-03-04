package myapp.controle;

import java.awt.Color;
import drawing.GUIHelper;
import drawing.JCanvas;

import drawing.shape.FormeListener;
import drawing.shape.VueForme;
import myapp.communicationSocket.CommunicationSMI;
import myapp.event.Position;

import myapp.model.MondeDesFormeModel;

public class MondeDesFormeController implements MondeDesFormeControllerListener {

    static public MondeDesFormeModel model;
    static private JCanvas Vue = null;

    private static boolean ENCALIBRATION = false;


    public MondeDesFormeController(MondeDesFormeModel model, JCanvas Vue) {
        //super(Vue);
        this.model = model;
        this.Vue = Vue;
        // On enregistre le controlleur auprès de la vue et du model
        model.addControlleurListner(this);
        Vue.addControlleurListner(this);

        Vue.setBackground(Color.WHITE);
        //Vue.setPreferredSize(Vue.getMaximumSize());
        GUIHelper.showOnFrame(Vue, "Monde des formes");
    }

    public static JCanvas getVue() {
        return Vue;
    }

    @Override
    public void addFormeListener(FormeListener forme) {
        //VueForme nv = new VueForme(forme);
        //ControleForme nc = new ControleForme(forme);
        //Vue.addDrawable(new VueForme(forme));
        // a rectifier: on sait que ce que l on reçoit est une forme
        //((Shape)forme).addFormeListener(nv);
    }
    /*
    public void nouvelleForme(Shape forme) {
    CircleDrawable c = new CircleDrawable(Color.BLUE,forme.getPosition(),new Dimension(40,40));
    forme.addFormeListener(c);

    }
     */
    /*
    public void nouvelleForme(Shape nf ,int type) {
    VueForme c = new VueForme(nf,type);

    moduleFixation mf = new moduleFixation(nf.getNom(),type);
    nf.poolModule.chainnage(mf);

    nf.addFormeListener(c);
    }
     */

    public static void DemarrerCalibration(int n) {

        if (!ENCALIBRATION) {
            ENCALIBRATION = true;
            Vue.notifieCalibrationEnCour();
            model.notifieCalibrationEnCour();
            CommunicationSMI.startCalibration();
        } else {
            System.err.println("DEJA EN CALIBRATION");
        }

    }



    public static void stopCalibration() {
        if (ENCALIBRATION) {
            ENCALIBRATION =false;
            Vue.notifieCalibrationEnCour();
            model.notifieCalibrationEnCour();
        }
    }


}
