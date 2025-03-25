package Java;

public class Erzeuger extends Thread {
    private final String name;
    private final Kuehlschrank kuehlschrank;

    public Erzeuger(String name, Kuehlschrank kuehlschrank) {
        this.name = name;
        this.kuehlschrank = kuehlschrank;
    }

    @Override
    public void run() {
        while (true) {

            if (kuehlschrank.nochPlatz()) {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Erzeuger " + name + " " + kuehlschrank.hinfzufuegen(new Yogurt("Vanille")));
                return;
            }
            System.out.println("Erzeuger " + name + ": Kühlschrank ist voll.");
        }
    }
}
