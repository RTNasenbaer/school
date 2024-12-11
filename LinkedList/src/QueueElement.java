public abstract class QueueElement {

    public int countLeft() {
        return 0;
    }

    public boolean nonEmptyList() {
        return false;
    }

    public Element search(String input) {
        return new Patient(input + " existiert nicht", 0);
    }

    public QueueElement removeSpecified(Element element) {
        return this;
    }

    public QueueElement removeFirst() {
        return this;
    }

    public QueueElement removeLast() {
        return this;
    }

    public String display() {
        return "";
    }

    public QueueElement insertAtNumber(Element element, int value) {
        return new Node(element, new End());
    }

    public QueueElement insertInBack(Element element) {
        return new Node(element, new End());
    }

    public String getInfo() {
        return "";
    }

    public QueueElement insertInFront(Element element) {
        return new Node(element, new End());
    }

    public QueueElement insertBefore(Element element1, Element element2) {
        return new Node(element1, new End());
    }

    public QueueElement insertSorted(Element element) {
        return new Node(element, new End());
    }

    public QueueElement getEnd() {
        return this;
    }
}
