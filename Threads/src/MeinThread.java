public class MeinThread {
    public static void main(String[] args) {
        new MeinThread();
    }

    public MeinThread() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello from a thread!");
            }
        });
        t.start();
    }
}