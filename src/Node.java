public class Node extends QueueElement{

    QueueElement following;
    Element data;

    Node(Element element, QueueElement following) {
        data = element;
        this.following = following;
    }

    @Override
    public int countLeft() {
        return 1 + following.countLeft();
    }

    @Override
    public boolean nonEmptyList() {
        return true;
    }

    @Override
    public Element search(String input) {
        Element element;
        if (data.getInfo().contains(input)) element = data;
        else element = following.search(input);
        return element;
    }

    @Override
    public QueueElement removeSpecified(Element element) {
        QueueElement output = following;
        if (following.getInfo().equals(element.getInfo())) following = following.removeFirst();
        else output = following.removeSpecified(element);
        return output;
    }

    @Override
    public QueueElement removeFirst() {
        return following;
    }

    @Override
    public QueueElement removeLast() {
        if (following instanceof End) return new End();
        else{
            following = following.removeLast();
            return this;
        }
    }

    @Override
    public String display() {
        return getInfo() + "\n" + following.display();
    }

    @Override
    public QueueElement insertAtNumber(Element element, int value) {
        if (value==1) following = new Node(element, following);
        else following = following.insertAtNumber(element, value-1);
        return this;
    }

    @Override
    public QueueElement insertInBack(Element element) {
        following = following.insertInBack(element);
        return this;
    }

    @Override
    public QueueElement insertInFront(Element element) {
        return new Node(element, this);
    }

    @Override
    public QueueElement insertBefore(Element element1, Element element2) {
        if(data.getInfo().equals(element2.getInfo())) return new Node(element1, this);
        else {
            following = following.insertBefore(element1, element2);
            return this;
        }
    }

    @Override
    public QueueElement insertSorted(Element element) {
        if (data.getInfo().compareTo(element.getInfo()) > 0) return new Node(element, this);
        else {
            following = following.insertSorted(element);
            return this;
        }
    }

    @Override
    public QueueElement getEnd() {
        if (following instanceof End) return this;
        else return following.getEnd();
    }

    @Override
    public String getInfo() {
        return data.getInfo();
    }
}
