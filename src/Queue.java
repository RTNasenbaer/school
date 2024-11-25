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

    public String remove(Element element) {
        String output = start.getInfo();
        if (element!=null) if (start.getInfo().equals(element.getInfo())) start = start.remove();
        else output = start.remove(element).getInfo();
        return output;
    }

    public String remove() {
        String output = start.getInfo();
        start = start.remove();
        return output;
    }

    public String display() {
        return start.display();
    }

    public void insert(Element element, int value) {
        if (value==1) start = new Node(element, start);
        else start = start.insert(element, value-1);
    }

    public void insert(Element element) {
        start = start.insert(element);
    }

}
