public class Abschluss extends Baumelement {
    @Override
    public Baumelement einfuegen(Datenelement element) {
        return new Knoten(element);
    }

    @Override
    public String preOrder() {
        return "";
    }

    @Override
    public String inOrder() {
        return "";
    }

    @Override
    public String postOrder() {
        return "";
    }

    @Override
    public String translate(Datenelement element) {
        return "";
    }

    @Override
    public int hoehe() {
        return 0;
    }

}
