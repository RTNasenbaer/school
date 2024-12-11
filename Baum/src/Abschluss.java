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
}
