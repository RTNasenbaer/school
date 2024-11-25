public abstract class QueueElement {

    public int getAnzahl() {
        return 0;
    }

    public boolean listeLeer() {
        return true;
    }

    public Element suche(String input) {
        return null;
    }

    public QueueElement entnehmen(Element element) {
        return this;
    }

    public QueueElement entnehmen() {
        return this;
    }

    public String anzeigen() {
        return "";
    }

    public QueueElement einfuegen(Element element, int value) {
        return new Node(element, new Abschluss());
    }

    public QueueElement einfuegen(Element element) {
        return new Node(element, new Abschluss());
    }

    public String getInfo() {
        return "";
    }
}
