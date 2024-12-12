public class Vokabelpaar implements Datenelement {

    public Vokabel deutsch;
    public Vokabel englisch;

    public Vokabelpaar(String deutsch, String englisch) {
        this.deutsch = new Vokabel(deutsch);
        this.englisch = new Vokabel(englisch);
    }

    @Override
    public boolean check(Datenelement element) {
        return false;
    }

    @Override
    public String ausgeben() {
        return "";
    }
}
