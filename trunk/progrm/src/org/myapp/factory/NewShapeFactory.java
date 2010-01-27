package org.myapp.factory;

import org.myapp.Sarsa.Sarsa_State.ShapeType;
import org.myapp.Sarsa.Sarsa_StateFactory;
import org.myapp.model.NewShape;

/**
 *
 * @author ter Vincent Bonnier
 */
public class NewShapeFactory {

    //SarsaState Factory nécessaire pour créer des newShape
    static Sarsa_StateFactory stateFactory = null;

    public void setStateFactory(Sarsa_StateFactory factory) {
        this.stateFactory = factory;
    }
}

