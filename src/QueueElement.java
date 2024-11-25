public abstract class QueueElement {

    public int countLeft() {
        return 0;
    }

    public boolean nonEmptyList() {
        return false;
    }

    public Element search(String input) {
        return null;
    }

    public QueueElement remove(Element element) {
        return this;
    }

    public QueueElement remove() {
        return this;
    }

    public String display() {
        return "";
    }

    public QueueElement insert(Element element, int value) {
        return new Node(element, new End());
    }

    public QueueElement insert(Element element) {
        return new Node(element, new End());
    }

    public String getInfo() {
        return "";
    }
}
