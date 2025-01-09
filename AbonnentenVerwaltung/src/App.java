public class App {
    public static void main(String[] args) throws Exception {
        new App().run();
    }

    public void run() {
        Baum baum = new Baum();

        baum.einfuegen(new Abonnent("georg@beispiel.de"));
        baum.einfuegen(new Abonnent("dana@example.com"));
        baum.einfuegen(new Abonnent("paul@example.net"));
        baum.einfuegen(new Abonnent("maja@beispiel.de"));
        baum.einfuegen(new Abonnent("werner@example.org"));
        baum.einfuegen(new Abonnent("silke@infohause.de"));
        baum.einfuegen(new Abonnent("karl@example.edu"));

        System.out.println(baum.eMailsAusgeben());
    }
}
