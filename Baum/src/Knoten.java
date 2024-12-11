public class Knoten extends Baumelement {

    Baumelement links;
    Baumelement rechts;
    Datenelement daten;

    public Knoten(Datenelement element) {
        daten = element;
    }

    @Override
    public Baumelement einfuegen(Datenelement element) {
        if (daten.check(element))
            links = links.einfuegen(element);
        else
            rechts = rechts.einfuegen(element);
        return this;
    }

    @Override
    public String preOrder() {
        return links.preOrder() + " " + rechts.preOrder() + " " + daten.ausgeben();
    }

    @Override
    public String inOrder() {
        return links.inOrder() + " " + daten.ausgeben() + rechts.inOrder();
    }

    @Override
    public String postOrder() {
        return daten.ausgeben() + " " + links.postOrder() + " " + rechts.postOrder();
    }
}
