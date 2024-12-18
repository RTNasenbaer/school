public class Vokabelpaar implements Datenelement {

    public Datenelement first;
    public Datenelement second;

    public Vokabelpaar(Datenelement first, Datenelement second) {
        this.first = first;
        this.second = second;
    }

    public Datenelement switch() {
        return new Vokabelpaar(second, first);
    }

    @Override
    public boolean check(Datenelement element) {
        return false;
    }

    @Override
    public String ausgeben() {
        return first.ausgeben() + " - " + second.ausgeben();
    }

}
