package org;

import java.awt.Color;
import drawing.GUIHelper;
import drawing.IDrawable;
import drawing.JCanvas;


import javax.xml.bind.Marshaller.Listener;

import org.myapp.ModelForme;

public class MondeDesFormeController implements MondeDesFormeControllerListener{

	public MondeDesFormeModel model;
	private JCanvas Vue;
	
	public MondeDesFormeController(MondeDesFormeModel model,JCanvas Vue) {
		//super(Vue);
		this.model = model;
		this.Vue = Vue;
		
		// On enregistre le controlleur auprès de la vue et du model
		model.addControlleurListner(this);
		Vue.addControlleurListner(this);
		
		Vue.setBackground(Color.WHITE);
		Vue.setPreferredSize(Vue.getMaximumSize());
		GUIHelper.showOnFrame(Vue,"Monde des formes");
	}

	
	
	
	
	@Override
	public void addFormeListener(FormeListener forme) {
		
		Vue.addDrawable(new VueForme(forme));
		
	}
	
	
	
	
	
	
	
	
	
	
}