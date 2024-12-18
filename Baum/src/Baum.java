public class Baum {

    Baumelement wurzel;

    public Baum() {
        wurzel = new Abschluss();
    }

    public void einfuegen(Datenelement element) {
        wurzel = wurzel.einfuegen(element);
    }

    public String preOrder() {
        return wurzel.preOrder();
    }

    public String inOrder() {
        return wurzel.inOrder();
    }

    public String postOrder() {
        return wurzel.postOrder();
    }

    public String translate(Datenelement element) {
        return element.ausgeben() + " <-> " + wurzel.translate(element);
    }

    public int hoehe() {
        return wurzel.hoehe();
    }
}
