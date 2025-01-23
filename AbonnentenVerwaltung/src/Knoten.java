public class Knoten extends Baumelement{

    private Baumelement nachfolgerLi;
    private Baumelement nachfolgerRe;
    private Abonnent abonnent;

    public Knoten(Abonnent abo) {
        abonnent = abo;
        nachfolgerLi = new Abschluss();
        nachfolgerRe = new Abschluss();
    }

    @Override
    public Baumelement einfuegen(Abonnent abo) {
        if (abonnent.istKleinerAls(abo.ausgeben())) nachfolgerLi = nachfolgerLi.einfuegen(abo);
        if (abonnent.istGroeßerAls(abo.ausgeben())) nachfolgerRe = nachfolgerRe.einfuegen(abo);
        return this;
    }

    @Override
    public String eMailsAusgeben() {
        return nachfolgerLi.eMailsAusgeben() + abonnent.ausgeben() + nachfolgerRe.eMailsAusgeben();
    }

}
