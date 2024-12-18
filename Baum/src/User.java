public class User {

    public static void main(String[] args) {
        //new User().runZahlen();
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
            new Vokabelpaar(new Vokabel("Baum"), new Vokabel("tree")),
            new Vokabelpaar(new Vokabel("Haus"), new Vokabel("house")),
            new Vokabelpaar(new Vokabel("Auto"), new Vokabel("car")),
            new Vokabelpaar(new Vokabel("Hund"), new Vokabel("dog")),
            new Vokabelpaar(new Vokabel("Katze"), new Vokabel("cat")),
            new Vokabelpaar(new Vokabel("Maus"), new Vokabel("mouse")),
            new Vokabelpaar(new Vokabel("Vogel"), new Vokabel("bird")),
            new Vokabelpaar(new Vokabel("Fisch"), new Vokabel("fish")),
            new Vokabelpaar(new Vokabel("Pferd"), new Vokabel("horse")),
            new Vokabelpaar(new Vokabel("Kuh"), new Vokabel("cow")),
            new Vokabelpaar(new Vokabel("Schwein"), new Vokabel("pig")),
            new Vokabelpaar(new Vokabel("Schaf"), new Vokabel("sheep")),
            new Vokabelpaar(new Vokabel("Ziege"), new Vokabel("goat")),
            new Vokabelpaar(new Vokabel("Huhn"), new Vokabel("chicken")),
            new Vokabelpaar(new Vokabel("Ente"), new Vokabel("duck")),
            new Vokabelpaar(new Vokabel("Gans"), new Vokabel("goose")),
            new Vokabelpaar(new Vokabel("Ei"), new Vokabel("egg")),
            new Vokabelpaar(new Vokabel("Milch"), new Vokabel("milk")),
            new Vokabelpaar(new Vokabel("Butter"), new Vokabel("butter")),
            new Vokabelpaar(new Vokabel("Käse"), new Vokabel("cheese")),
            new Vokabelpaar(new Vokabel("Brot"), new Vokabel("bread")),
            new Vokabelpaar(new Vokabel("Wurst"), new Vokabel("sausage")),
            new Vokabelpaar(new Vokabel("Fleisch"), new Vokabel("meat")),
            new Vokabelpaar(new Vokabel("Gemüse"), new Vokabel("vegetables")),
            new Vokabelpaar(new Vokabel("Obst"), new Vokabel("fruit")),
            new Vokabelpaar(new Vokabel("Kartoffel"), new Vokabel("potato")),
            new Vokabelpaar(new Vokabel("Reis"), new Vokabel("rice")),
            new Vokabelpaar(new Vokabel("Nudeln"), new Vokabel("pasta")),
            new Vokabelpaar(new Vokabel("Suppe"), new Vokabel("soup")),
            new Vokabelpaar(new Vokabel("Salat"), new Vokabel("salad"))
        };
        Baum baum1 = new Baum();
        for (Vokabelpaar vokabelpaar : vokabelpaare) {
            baum1.einfuegen(vokabelpaar);
        }
        Baum baum2 = new Baum();
        for (Vokabelpaar vokabelpaar : vokabelpaare) {
            baum2.einfuegen(vokabelpaar);
        }
        System.out.println(baum1.translate("Baum"));
        System.out.println(baum2.translate("salad"));
        //System.out.println(baum1.inOrder());
        //System.out.println(baum2.inOrder());

    }

}
