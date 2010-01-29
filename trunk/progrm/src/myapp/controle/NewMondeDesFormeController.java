package myapp.controle;

import java.awt.Color;
import drawing.GUIHelper;
import drawing.JCanvas;
//import drawing.shape.VueForme;

import drawing.shape.FormeListener;
//import org.myapp.model.Shape;
//import org.myapp.model.MondeDesFormeModel;
import myapp.model.NewMondeDesFormeModel;
//import org.myapp.module.moduleFixation;

public class NewMondeDesFormeController implements MondeDesFormeControllerListener{

	public NewMondeDesFormeModel model;

	public NewMondeDesFormeController(NewMondeDesFormeModel model,JCanvas Vue) {
		this.model = model;
		// On enregistre le controlleur aupr�s de la vue et du model
		Vue.addControlleurListner(this);
		Vue.setBackground(Color.WHITE);
		//Vue.setPreferredSize(Vue.getMaximumSize());
		GUIHelper.showOnFrame(Vue,"Monde des formes");
	}

    //obligatoir si on implémente MondeDesFormeControllerListener
    public void addFormeListener(FormeListener formeListener) {}
}