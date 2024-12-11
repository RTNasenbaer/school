public class Zahlen implements Datenelement{

    public int zahl;

    @Override
    public boolean check(Datenelement element) {
        if (zahl < element.zahl)
            return true;
        return false;
    }

    @Override
    public String ausgeben() {
        return "" + zahl;
    }
}
