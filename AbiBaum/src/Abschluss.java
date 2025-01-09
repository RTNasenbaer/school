public class Abschluss extends BaumElement{

    @Override
    public BaumElement einfuegen(Skipass skipass) {
        return new Knoten(skipass);
    }

    @Override
    public boolean istVorhanden(int skipassnr) {
        return false;
    }

    @Override
    public void sortiertAusgeben(char skipassart) {
        
    }

}
