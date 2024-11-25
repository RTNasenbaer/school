public class Queue {

    private QueueElement start;


    Queue() {
        start = new Abschluss();
    }

    public int getAnzahl() {
        return start.getAnzahl();
    }

    public boolean listeLeer() {
        return start.listeLeer();
    }

    public Element suche(String input) {
        return start.suche(input);
    }

    public String entnehmen(Element element) {
        String output = start.getInfo();
        if (element!=null) if (start.getInfo().equals(element.getInfo())) start = start.entnehmen();
        else output = start.entnehmen(element).getInfo();
        return output;
    }

    public String entnehmen() {
        String output = start.getInfo();
        start = start.entnehmen();
        return output;
    }

    public String anzeigen() {
        return start.anzeigen();
    }

    public void einfuegen(Element element, int value) {
        if (value==1) start = new Node(element, start);
        else start = start.einfuegen(element, value-1);
    }

    public void einfuegen(Element element) {
        start = start.einfuegen(element);
    }

}
