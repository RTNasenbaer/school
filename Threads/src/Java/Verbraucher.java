package Java;

public class Verbraucher extends Thread {
    private String name;
    private Kuehlschrank kuehlschrank;

    public Verbraucher(String name, Kuehlschrank kuehlschrank) {
        this.name = name;
        this.kuehlschrank = kuehlschrank;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (kuehlschrank.istLeer()) {
                System.out.println("Verbraucher " + name + ": Kühlschrank ist leer.");
                return;
            }
            System.out.println("Verbraucher " + name + " " + kuehlschrank.entnehmen());
        }
    }
}
