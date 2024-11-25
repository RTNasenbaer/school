public class Node extends QueueElement{

    QueueElement following;
    Element element;

    Node(Element element, QueueElement following) {
        this.element = element;
        this.following = following;
    }

    @Override
    public int getAnzahl() {
        return 1 + following.getAnzahl();
    }

    @Override
    public boolean listeLeer() {
        return false;
    }

    @Override
    public Element suche(String input) {
        Element element = null;
        if (this.element.getInfo().contains(input)) element = this.element;
        else element = following.suche(input);
        return element;
    }

    @Override
    public QueueElement entnehmen(Element element) {
        QueueElement output = following;
        if (following.getInfo().equals(element.getInfo())) following = following.entnehmen();
        else output = following.entnehmen(element);
        return output;
    }

    @Override
    public QueueElement entnehmen() {
        return following;
    }

    @Override
    public String anzeigen() {
        return getInfo() + "\n" + following.anzeigen();
    }

    @Override
    public QueueElement einfuegen(Element element, int value) {
        if (value==1) following = new Node(element, following);
        else following = following.einfuegen(element, value-1);
        return this;
    }

    @Override
    public QueueElement einfuegen(Element element) {
        following = following.einfuegen(element);
        return this;
    }

    @Override
    public String getInfo() {
        return element.getInfo();
    }
}
