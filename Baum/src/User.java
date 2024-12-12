public class User {

    public static void main(String[] args) {
        new User().runZahlen();
        new User().runWoerterbuch();
    }

    public void runZahlen() {
        int[] zahlen = {31,12,29,19,17,47,38,49};
        Baum baum = new Baum();
        for (int zahl : zahlen) {
            baum.einfuegen(new Zahl(zahl));
        }
        System.out.println(baum.preOrder());
        System.out.println(baum.inOrder());
        System.out.println(baum.postOrder());
    }

    public void runWoerterbuch() {
        Vokabelpaar[] vokabelpaare = {
            new Vokabelpaar("Haus", "house"),
            new Vokabelpaar("Baum", "tree"),
            new Vokabelpaar("Auto", "car"),
            new Vokabelpaar("Stuhl", "chair"),
            new Vokabelpaar("Tisch", "table"),
            new Vokabelpaar("Buch", "book"),
            new Vokabelpaar("Stift", "pen"),
            new Vokabelpaar("Papier", "paper")
        };
        Baum baum1 = new Baum();
        for (Vokabelpaar vokabelpaar : vokabelpaare) {
            baum1.einfuegen(vokabelpaar);
        }
        Baum baum2 = new Baum();

    }

}
