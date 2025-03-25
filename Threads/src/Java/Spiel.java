package Java;

public class Spiel {
    private Erzeuger mami;
    private Erzeuger papi;
    private Erzeuger omi;

    private Verbraucher philipp;
    private Verbraucher finn;
    private Verbraucher lina;

    public Spiel() {
        Kuehlschrank kuehlschrank = new Kuehlschrank();
        mami = new Erzeuger("Mami", kuehlschrank);
        papi = new Erzeuger("Papi", kuehlschrank);
        omi = new Erzeuger("Omi", kuehlschrank);

        philipp = new Verbraucher("Philipp", kuehlschrank);
        finn = new Verbraucher("Finn", kuehlschrank);
        lina = new Verbraucher("Lina", kuehlschrank);

        mami.start();
        papi.start();
        omi.start();

        philipp.start();
        finn.start();
        lina.start();
    }

    public static void main(String[] args) {
        new Spiel();
    }
}