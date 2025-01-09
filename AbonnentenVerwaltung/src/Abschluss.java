public class Abschluss extends Baumelement{

    @Override
    public Baumelement einfuegen(Abonnent abo) {
        return new Knoten(abo);
    }

    @Override
    public String eMailsAusgeben() {
        return "";
    }

}
