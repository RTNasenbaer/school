public class Node extends QueueElement{

    QueueElement following;
    Element element;

    Node(Element element, QueueElement following) {
        this.element = element;
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
        if (this.element.getInfo().contains(input)) element = this.element;
        else element = following.search(input);
        return element;
    }

    @Override
    public QueueElement remove(Element element) {
        QueueElement output = following;
        if (following.getInfo().equals(element.getInfo())) following = following.remove();
        else output = following.remove(element);
        return output;
    }

    @Override
    public QueueElement remove() {
        return following;
    }

    @Override
    public String display() {
        return getInfo() + "\n" + following.display();
    }

    @Override
    public QueueElement insert(Element element, int value) {
        if (value==1) following = new Node(element, following);
        else following = following.insert(element, value-1);
        return this;
    }

    @Override
    public QueueElement insert(Element element) {
        following = following.insert(element);
        return this;
    }

    @Override
    public String getInfo() {
        return element.getInfo();
    }
}
