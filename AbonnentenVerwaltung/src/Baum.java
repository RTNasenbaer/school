public class Baum {

    private Baumelement wurzel;

    public Baum() {
        wurzel = new Abschluss();
    }

    public void einfuegen(Abonnent abo) {
        wurzel = wurzel.einfuegen(abo);
    }

    public String eMailsAusgeben() {
        return wurzel.eMailsAusgeben();
    }

}
