public class Knoten extends Baumelement {

    Baumelement links;
    Baumelement rechts;
    Datenelement daten;

    public Knoten(Datenelement element) {
        daten = element;
        links = new Abschluss();
        rechts = new Abschluss();
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
        return daten.ausgeben() + "/" + links.preOrder() + rechts.preOrder();
    }

    @Override
    public String inOrder() {
        return links.inOrder() + daten.ausgeben() + "/" + rechts.inOrder();
    }

    @Override
    public String postOrder() {
        return links.postOrder() + rechts.postOrder() + daten.ausgeben() + "/";
    }

    @Override
    public String translate(Datenelement element) {
        if (daten.ausgeben().contains(element.ausgeben())) {
            return daten.ausgeben().split(" ")[2];
        }
        if (daten.check(element)) {
            return links.translate(element);
        } else {
            return rechts.translate(element);
        }
    }

    @Override
    public int hoehe() {
        return 1 + Math.max(links.hoehe(), rechts.hoehe());
    }
}
