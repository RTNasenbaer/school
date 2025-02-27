import java.util.ArrayList;

public class Graph {

    public Knoten[] kn;
    public int[][] adj;
    public double sDis;
    public String sWeg;


    public Graph(int size) {
        kn = new Knoten[size];
        adj = new int[size][size];
        sDis = Double.MAX_VALUE;
        sWeg = "";
    }

    public void knoten_hinzufuegen(String city0) {
        kn[anzahlKnoten()] = new Knoten(city0);
    }

    public void kante_hinzufuegen(String stadt0, String stadt1, int laenge, boolean ungerichtet) {
        int start = findeKnoten(stadt0);
        int ende = findeKnoten(stadt1);
        adj[start][ende] = laenge;
        if (ungerichtet) adj[ende][start] = laenge;
    }

    /* Breitensuche */
    public void breitensuche(String stadt0) {
        // Setup
        for (Knoten k : kn) k.besucht = false;
        System.out.println();
        int start = findeKnoten(stadt0);
        ArrayList<Integer> wSchlange = new ArrayList<>();
        wSchlange.add(start);
        kn[start].besucht = true;
        while (!wSchlange.isEmpty()) {
            int sp = wSchlange.remove(0);
            System.out.printf("%6s", kn[sp].name.substring(0, 4));
            for (int i = 0; i < anzahlKnoten(); i++) {
                if (adj[sp][i] != 0 && !kn[i].besucht) {
                    wSchlange.add(i);
                    kn[i].besucht = true;
                }
            }
        }
        System.out.println();
        for (Knoten k : kn) k.besucht = false;

    }

    public void tiefensuche(String stadt0) {
        tiefensuche(findeKnoten(stadt0));
        for (Knoten k : kn) k.besucht = false;
        System.out.println();
    }

    public void tiefensuche(int stadt0Num) {
        kn[stadt0Num].besucht = true;
        System.out.printf("%6s", kn[stadt0Num].name.substring(0, 4));
        for (int i = 0; i < anzahlKnoten(); i++) {
            if ((adj[stadt0Num][i] != 0) && (!kn[i].besucht)) tiefensuche(i);
        }
    }

    public void sucheAlle(String stadt0, String stadt1) {
        System.out.println();
        sucheAlle(findeKnoten(stadt0), findeKnoten(stadt1), stadt0.substring(0, 4), 0);
        for (Knoten k : kn) k.besucht = false;
        System.out.println();
    }

    private void sucheAlle(int stadt0Num, int stadt1Num, String ausgabe, double gewicht) {
        if (stadt0Num == stadt1Num) {
            String[] aus = ausgabe.split("\\s");
            for (String a : aus) System.out.printf("%6s", a);
            System.out.print(" (" + (int) gewicht + ")");
            System.out.println();
        } else {
            kn[stadt0Num].besucht = true;
            for (int i = 0; i < anzahlKnoten(); i++) {
                if ((adj[stadt0Num][i] != 0) && (!kn[i].besucht)) sucheAlle(i, stadt1Num, ausgabe + " " + kn[i].name.substring(0, 4), gewicht + adj[stadt0Num][i]);
            }
        }
        kn[stadt0Num].besucht = false;
    }

    public void sucheKurz(String stadt0, String stadt1) {
        sucheKurz(findeKnoten(stadt0), findeKnoten(stadt1), stadt0.substring(0, 4), 0);
        String[] aus = sWeg.split("\\s");
        for (String a : aus) System.out.printf("%6s", a);
        System.out.print(" (" + (int) sDis + ")");
        for (Knoten k : kn) k.besucht = false;
        sWeg = "";
        sDis = Double.MAX_VALUE;
        System.out.println();
    }

    public void sucheKurz(int stadt0Num, int stadt1Num, String ausgabe, double gewicht) {
        if (stadt0Num == stadt1Num && gewicht < sDis) {
            sDis = gewicht;
            sWeg = ausgabe;
        } else {
            kn[stadt0Num].besucht = true;
            for (int i = 0; i < anzahlKnoten(); i++) {
                if ((adj[stadt0Num][i] != 0) && (!kn[i].besucht)) sucheKurz(i, stadt1Num, ausgabe + " " + kn[i].name.substring(0, 4), gewicht + adj[stadt0Num][i]);
            }
        }
        kn[stadt0Num].besucht = false;
    }

    public void durchreise(String stadt0, String stadt1) {
        sDis = 0;
        durchreise(findeKnoten(stadt0), findeKnoten(stadt1), stadt0.substring(0, 4), 0);
        String[] aus = sWeg.split("\\s");
        for (String a : aus) System.out.printf("%6s", a);
        System.out.print(" (" + (int) sDis + ")");
        for (Knoten k : kn) k.besucht = false;
        sWeg = "";
        sDis = Double.MAX_VALUE;
        System.out.println();
    }

    private void durchreise(int stadt0Num, int stadt1Num, String ausgabe, double gewicht) {
        if (stadt0Num == stadt1Num && gewicht > sDis) {
            sDis = gewicht;
            sWeg = ausgabe;
        } else {
            kn[stadt0Num].besucht = true;
            for (int i = 0; i < anzahlKnoten(); i++) {
                if ((adj[stadt0Num][i] != 0) && (!kn[i].besucht)) durchreise(i, stadt1Num, ausgabe + " " + kn[i].name.substring(0, 4), gewicht + adj[stadt0Num][i]);
            }
        }
        kn[stadt0Num].besucht = false;
    }

    public int anzahlKnoten() {
        int a = 0;
        for (Knoten knoten : kn) if (knoten != null) a++;
        return a;
    }

    public int findeKnoten(String city0) {
        for (int k = 0; k <= anzahlKnoten(); k++) if (kn[k].name.equals(city0)) return k;
        return -1;
    }

    public void ausgabe() {
        final String RESET = "\u001B[0m";
        final String HEADER_COLOR = "\u001B[34m"; // Blue
        final String NUMBER_COLOR = "\u001B[32m"; // Green
        final String BORDER_COLOR = "\u001B[33m"; // Yellow
        final String DASH = "──"; // Double dash for zero values

        int width = 6; // Fixed column width
        int totalWidth = (anzahlKnoten() + 1) * width;

        // Top border
        System.out.println(BORDER_COLOR + "┌" + "─".repeat(totalWidth) + "┐" + RESET);

        // Header row
        System.out.print(BORDER_COLOR + "│" + RESET);
        System.out.printf("%" + width + "s", " ");
        for (int i = 0; i < anzahlKnoten(); i++) {
            System.out.printf(HEADER_COLOR + "%" + width + "s" + RESET, kn[i].name.substring(0, 4));
        }
        System.out.println(BORDER_COLOR + "│" + RESET);

        // Separator
        System.out.println(BORDER_COLOR + "├" + "─".repeat(totalWidth) + "┤" + RESET);

        // Table rows
        for (int i = 0; i < anzahlKnoten(); i++) {
            System.out.print(BORDER_COLOR + "│" + RESET);
            System.out.printf(HEADER_COLOR + "%" + width + "s" + RESET, kn[i].name.substring(0, 4));

            for (int j = 0; j < anzahlKnoten(); j++) {
                if (adj[i][j] != 0)
                    System.out.printf(NUMBER_COLOR + "%" + width + "d" + RESET, adj[i][j]);
                else
                    System.out.printf("%" + width + "s", DASH);
            }

            System.out.println(BORDER_COLOR + "│" + RESET);
        }

        // Bottom border
        System.out.println(BORDER_COLOR + "└" + "─".repeat(totalWidth) + "┘" + RESET);
    }
}
