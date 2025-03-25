package Java;

public class Erzeuger extends Thread {
    private String name;
    private Kuehlschrank kuehlschrank;

    public Erzeuger(String name, Kuehlschrank kuehlschrank) {
        this.name = name;
        this.kuehlschrank = kuehlschrank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!kuehlschrank.nochPlatz()) {
                System.out.println("Erzeuger " + name + ": Kühlschrank ist voll.");
                return;
            }
            System.out.println("Erzeuger " + name + " " + kuehlschrank.hinfzufuegen(new Yogurt("Vanille")));
        }
    }
}
