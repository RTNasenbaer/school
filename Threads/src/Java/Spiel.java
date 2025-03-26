package Java;

public class Spiel {
    private final Erzeuger mami;
    private final Erzeuger papi;
    private final Erzeuger omi;

    private final Verbraucher philipp;
    private final Verbraucher finn;
    private final Verbraucher lina;

    public Spiel() {
        Kuehlschrank kuehlschrank1 = new Kuehlschrank();
        Kuehlschrank kuehlschrank2 = new Kuehlschrank();
        mami = new Erzeuger("Mami", kuehlschrank1, kuehlschrank2);
        papi = new Erzeuger("Papi", kuehlschrank2, kuehlschrank1);
        omi = new Erzeuger("Omi", kuehlschrank1, kuehlschrank2);

        philipp = new Verbraucher("Philipp", kuehlschrank1, kuehlschrank2);
        finn = new Verbraucher("Finn", kuehlschrank2, kuehlschrank1);
        lina = new Verbraucher("Lina", kuehlschrank1, kuehlschrank2);

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