/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.shape;

import drawing.shape.VueForme.ShapeForme;
import drawing.shape.type.graphicsShape;
import drawing.shape.type.graphicsShapeCIRCLE;
import drawing.shape.type.graphicsShapeCURSOR;
import drawing.shape.type.graphicsShapeSQUARE;
import drawing.shape.type.graphicsShapeTRIANGLE;

/**
 *
 * @author BOB
 */
class GraphicsShape_Factory {

    static graphicsShape getGraphicsShape(ShapeForme shapeForme) {
        switch (shapeForme) {
            case CIRCLE:
                return new graphicsShapeCIRCLE();

            case CURSOR:
                return new graphicsShapeCURSOR();

            case SQUARE:
                return new graphicsShapeSQUARE();

            case TRIANGLE:
                return new graphicsShapeTRIANGLE();
            default:
        }
        System.err.println("Erreur dans la GraphicsShape_Factory\n l'une des enumeration est peut etre pas implementé");
        return null;
    }
}
