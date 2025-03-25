package Java;

public class Verbraucher extends Thread {
    private final String name;
    private final Kuehlschrank kuehlschrank;

    public Verbraucher(String name, Kuehlschrank kuehlschrank) {
        this.name = name;
        this.kuehlschrank = kuehlschrank;
    }

    @Override
    public void run() {
        while (true) {

            if (kuehlschrank.istLeer()) {
                try {
                    Thread.sleep((long) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Verbraucher " + name + ": Kühlschrank ist leer.");
                return;
            }
            System.out.println("Verbraucher " + name + " " + kuehlschrank.entnehmen());
        }
    }
}
