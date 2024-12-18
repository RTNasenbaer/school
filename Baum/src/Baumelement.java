public abstract class Baumelement {

    public abstract Baumelement einfuegen(Datenelement element);

    public abstract String preOrder();

    public abstract String inOrder();

    public abstract String postOrder();

    public abstract String translate(Datenelement element);

    public abstract int hoehe();
}
