public class App {
    public static void main(String[] args) throws Exception {
        new App().run();
    }

    public void run() {
        BinBaum baum = new BinBaum();
        baum.einfuegen(new Skipass(30, 'J'));
        baum.einfuegen(new Skipass(15, 'J'));
        baum.einfuegen(new Skipass(45, 'J'));
        baum.einfuegen(new Skipass(8, 'E'));
        baum.einfuegen(new Skipass(23, 'E'));
        baum.einfuegen(new Skipass(37, 'E'));
        baum.einfuegen(new Skipass(52, 'E'));
        baum.einfuegen(new Skipass(5, 'K'));
        baum.einfuegen(new Skipass(12, 'K'));
        baum.einfuegen(new Skipass(18, 'K'));
        baum.einfuegen(new Skipass(27, 'K'));
        baum.einfuegen(new Skipass(34, 'K'));
        baum.einfuegen(new Skipass(41, 'K'));
        baum.einfuegen(new Skipass(48, 'K'));
        baum.einfuegen(new Skipass(55, 'K'));
        baum.sortiertAusgeben('K');
        System.out.println();
        baum.sortiertAusgeben('E');
        System.out.println();
        baum.sortiertAusgeben('J');
        System.out.println();
        
    }
}

