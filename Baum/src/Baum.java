public class Baum {

    Baumelement wurzel;

    public Baum() {
        wurzel = new Abschluss();
    }

    public void einfuegen(Datenelement element) {
        wurzel.einfuegen(element);
    }

}
