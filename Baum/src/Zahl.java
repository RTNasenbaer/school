public class Zahl implements Datenelement{

    public int zahl;

    public Zahl(int zahl) {
        this.zahl = zahl;
    }

    @Override
    public boolean check(Datenelement element) {
        if (zahl > ((Zahl) element).zahl)
            return true;
        return false;
    }

    @Override
    public String ausgeben() {
        return "" + zahl;
    }
}
