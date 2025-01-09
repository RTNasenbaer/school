public class Knoten extends BaumElement {

    private Skipass skipass;
    private BaumElement links;
    private BaumElement rechts;

    public Knoten(Skipass skipass) {
        this.skipass = skipass;
        this.links = new Abschluss();
        this.rechts = new Abschluss();
    }

    @Override
    public BaumElement einfuegen(Skipass skipass) {
        if (skipass.nummer < this.skipass.nummer) {
            this.links = this.links.einfuegen(skipass);
        } else {
            this.rechts = this.rechts.einfuegen(skipass);
        }
        return this;
    }

    @Override
    public boolean istVorhanden(int skipassnr) {
        if (skipassnr == this.skipass.nummer) {
            return true;
        } else if (skipassnr < this.skipass.nummer) {
            return this.links.istVorhanden(skipassnr);
        } else {
            return this.rechts.istVorhanden(skipassnr);
        }
    }

    @Override
    public void sortiertAusgeben(char skipassart) {
        this.links.sortiertAusgeben(skipassart);
        this.rechts.sortiertAusgeben(skipassart);
        if (this.skipass.art == skipassart) {
            this.skipass.ausgeben();
        }
    }

}
