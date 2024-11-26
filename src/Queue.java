public class Queue {

    private QueueElement start;


    Queue() {
        start = new End();
    }

    public int count() {
        return start.countLeft();
    }

    public boolean nonEmptyList() {
        return start.nonEmptyList();
    }

    public Element search(String input) {
        return start.search(input);
    }

    public QueueElement removeSpecified(Element element) {
        if (start.getInfo().equals(element.getInfo())) return start = start.removeFirst();
        else return start.removeSpecified(element);
    }

    public QueueElement removeFirst() {
        return start = start.removeFirst();
    }

    public QueueElement removeLast() {
        QueueElement end = start.getEnd();
        start = start.removeLast();
        return end;
    }

    public String display() {
        return start.display();
    }

    public void insertAtNumber(Element element, int value) {
        if (value==1) start = new Node(element, start);
        else start = start.insertAtNumber(element, value-1);
    }

    public void insertInBack(Element element) {
        start = start.insertInBack(element);
    }

    public void insertInFront(Element element) {
        start = start.insertInFront(element);
    }

    public void insertBefore(Element element1, Element element2) {
        start = start.insertBefore(element1, element2);
    }

    public void insertSorted(Element element) {
        start = start.insertSorted(element);
    }

}
