public class BinBaum {

    private BaumElement wurzel;

    public BinBaum() {
        wurzel = new Abschluss();
    }

    public void einfuegen(Skipass skipass) {
        wurzel = wurzel.einfuegen(skipass);
    }

    public boolean istVorhanden(int skipassnr) {
        return wurzel.istVorhanden(skipassnr);
    }

    public void sortiertAusgeben(char skipassart) {
        wurzel.sortiertAusgeben(skipassart);
    }

}
