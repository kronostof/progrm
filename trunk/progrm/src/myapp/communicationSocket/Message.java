package myapp.communicationSocket;


/**
 *  Cette classe conserve le  dernier message lu.<p>
 * Attention, une lecture du message par la methode read detruit celui-ci.<br>
 * Tout les messages reçut ont la même structure.<br>
 * [ ENTETE | CORPS ]<br>
 * Le formatage du corps peut etre fait en communiquant avec le systeme SMI.<br>
 * @author christophe Moncy p0304320
 */
public class Message {

    private Type_de_message type = null;
    private String donnée = null;
    /*
    Message(Type_de_message type_de_message, StringTokenizer tête) {
    throw new UnsupportedOperationException("Not yet implemented");
    }
     */

    /**
     * enumeration des differants type de messages gérés.
     */
    public enum Type_de_message {

        ET_CHG,
        ET_CSZ,
        ET_FRM,
        ET_PNT,
        ET_SPL;
    }

    public Message() {
    }

    /**
     * Constructeur du message qui sera stocker.
     * @param substring_tête    Chaine utilisé pour déterminer le type de message reçut.
     * @param substring_queud   Corps du message reçut.
     */
    public void set(String substring_tête, String substring_queud) {
        try {
            type = Message.Type_de_message.valueOf(substring_tête);
        } catch (IllegalArgumentException e) {
            System.err.println("L'entête du message n'est pas (encore) reconnut par le programme ! :"
                    + "\nLa chaine lue est " + substring_tête
                    + "\nERREUR " + e);
        }

        donnée = new String(substring_queud);
    }

    public void read(Type_de_message tête, String corps) {
        if (donnée == null) {
            //System.err.println("Aucun message n'a été lue depuis la derniere lecture");
            corps = new String("");
        } else {
            corps = new String(this.donnée + "");
            tête = this.type;
        }
    }

    /**
     * Renvoi les données du dernier message lue.
     * @return Les données du dernier message lue.
     */
    public String getDonnée() {
        return donnée;
    }

    /**
     * Renvoi le type du dernier message lue.
     * @return Le type du dernier message lue.
     */
    public Type_de_message getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.toString() + " " + donnée.toString();
    }
}
