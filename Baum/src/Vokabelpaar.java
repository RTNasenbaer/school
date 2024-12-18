public class Vokabelpaar implements Datenelement {

    public Datenelement first;
    public Datenelement second;

    public Vokabelpaar(Datenelement first, Datenelement second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean check(Datenelement element) {
        if (element instanceof Vokabelpaar) if (first.ausgeben().compareTo(((Vokabelpaar) element).first.ausgeben()) > 0)
            return true;
        if (element instanceof Vokabel) if (first.ausgeben().compareTo(((Vokabel) element).ausgeben()) > 0)
            return true;
        return false;
    }

    public Vokabelpaar switchFirstAndSecond() {
    return new Vokabelpaar(this.second, this.first);
}

    @Override
    public String ausgeben() {
        return first.ausgeben() + " - " + second.ausgeben();
    }

}
