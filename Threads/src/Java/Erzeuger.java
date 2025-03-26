package Java;

public class Erzeuger extends Thread {
    private final String name;
    private final Kuehlschrank kuehlschrank1;
    private final Kuehlschrank kuehlschrank2;

    public Erzeuger(String name, Kuehlschrank kuehlschrank1, Kuehlschrank kuehlschrank2) {
        this.name = name;
        this.kuehlschrank1 = kuehlschrank1;
        this.kuehlschrank2 = kuehlschrank2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
//                    e.printStackTrace();
            }
            synchronized (kuehlschrank1) {
                if (kuehlschrank1.nochPlatz()) {
                    System.out.println("Erzeuger " + name + " " + kuehlschrank1.hinfzufuegen(new Yogurt("Vanille")));
                } else
                    System.out.println("Erzeuger " + name + ": Kühlschrank ist voll.");
                synchronized (kuehlschrank2) {
                    if (kuehlschrank2.nochPlatz()) {
                        System.out.println("Erzeuger " + name + " " + kuehlschrank2.hinfzufuegen(new Yogurt("Vanille")));
                    } else
                        System.out.println("Erzeuger " + name + ": Kühlschrank ist voll.");
                }
            }
        }
    }
}
