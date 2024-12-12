public class Vokabel implements Datenelement {

    public String vokabel;

    public Vokabel(String vokabel) {
        this.vokabel = vokabel;
    }

    @Override
    public boolean check(Datenelement element) {
        if (vokabel.compareTo(((Vokabel) element).vokabel) > 0)
            return true;
        return false;
    }

    @Override
    public String ausgeben() {
        return vokabel;
    }
}
