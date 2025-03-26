package Java;

public class Verbraucher extends Thread {
    private final String name;
    private final Kuehlschrank kuehlschrank1;
    private final Kuehlschrank kuehlschrank2;

    public Verbraucher(String name, Kuehlschrank kuehlschrank1, Kuehlschrank kuehlschrank2) {
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
                if (kuehlschrank1.istLeer()) {
                    System.out.println("Verbraucher " + name + ": Kühlschrank1 ist leer.");
                    synchronized (kuehlschrank2) {
                        if (kuehlschrank2.istLeer()) {
                            System.out.println("Verbraucher " + name + ": Kühlschrank ist leer.");
                        } else
                            System.out.println("Verbraucher " + name + " " + kuehlschrank2.entnehmen());
                    }
                } else
                    System.out.println("Verbraucher " + name + " " + kuehlschrank1.entnehmen());
            }
        }
    }
}
