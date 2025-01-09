public class Skipass {

    public int nummer;
    public char art;

    public Skipass(int nummer, char art) {
        this.nummer = nummer;
        this.art = art;
    }

    public void ausgeben() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║        SKIPASS-KARTE       ║");
        System.out.println("╠════════════════════════════╣");
        System.out.printf("║ Skipassnummer: %02d          ║%n", nummer);
        System.out.printf("║ Skipassart: %c              ║%n", art);
        System.out.println("╚════════════════════════════╝");
    }

}
