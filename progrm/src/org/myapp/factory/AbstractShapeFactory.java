package org.myapp.factory;

import java.awt.Color;
import org.myapp.model.Shape;
import org.myapp.module.manager.*;


import drawing.shape.VueForme;
import drawing.shape.VueForme.ShapeForme;

/**
 * une factory en singleton.<p>
 * la création d'une nouvelle forme passe par l'ajout du nom de la forme dans la liste
 * ShapeType puis par son implemetentation dans creatShape
 *
 * possède une référence vers une SarsaStateFactory nécessaire
 * pour la gestion des états la création des politiques des formes
 * etc...
 * @author christophe et vincent
 */
abstract class AbstractShapeFactory {
     static ModuleManager nwModuleManager;
     public static ShapeFactory instance;

     public enum ShapeType {Gaze0,Type1, Type2,fuite0, Fuite1,Approche0, Approche1}

     abstract Shape createShape(ShapeType type);
}
