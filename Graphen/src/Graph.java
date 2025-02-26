import java.util.ArrayList;

public class Graph {

    public Knoten[] kn;
    public int[][] adj;
    public double fastestDistance;
    public String fastestWay;


    public Graph(int size) {
        kn = new Knoten[size];
        adj = new int[size][size];
        fastestDistance = Double.MAX_VALUE;
        fastestWay = "";
    }

    public void knoten_hinzufuegen(String city0) {
        kn[anzahlKnoten()] = new Knoten(city0);
    }

    public void kante_hinzufuegen(String city0, String city1, int length, boolean bidirectional) {
        int start = findeKnoten(city0);
        int end = findeKnoten(city1);
        adj[start][end] = length;
        if (bidirectional) adj[end][start] = length;
    }

    /* Breitensuche */
    public void breitensuche(String city0) {
        // Setup
        for (Knoten k : kn) k.visited = false;
        System.out.println();
        int start = findeKnoten(city0);
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(start);
        kn[start].visited = true;
        while (!queue.isEmpty()) {
            int save = queue.remove(0);
            System.out.printf("%6s", kn[save].name.substring(0, 4));
            for (int i = 0; i < anzahlKnoten(); i++) {
                if (adj[save][i] != 0 && !kn[i].visited) {
                    queue.add(i);
                    kn[i].visited = true;
                }
            }
        }
        System.out.println();



    }

    public void tiefensuche(String city0) {
        for (Knoten k : kn) k.visited = false;
        tiefensuche(findeKnoten(city0));
        System.out.println();
    }

    public void tiefensuche(int city0Num) {
        kn[city0Num].visited = true;
        System.out.printf("%6s", kn[city0Num].name.substring(0, 4));
        for (int i = 0; i < anzahlKnoten(); i++) {
            if ((adj[city0Num][i] != 0) && (!kn[i].visited)) tiefensuche(i);
        }
    }

    public void sucheAlle(String city0, String city1) {
        for (Knoten k : kn) k.visited = false;
        sucheAlle(findeKnoten(city0), findeKnoten(city1), city0.substring(0, 4), 0);
        System.out.println();
    }

    private void sucheAlle(int city0Num, int city1Num, String ausgabe, double gewicht) {
        if (city0Num == city1Num) {
            String[] aus = ausgabe.split("\\s");
            for (String a : aus) System.out.printf("%6s", a);
            System.out.print(" (" + gewicht + ")");
            System.out.println();
        } else {
            kn[city0Num].visited = true;
            for (int i = 0; i < anzahlKnoten(); i++) {
                if ((adj[city0Num][i] != 0) && (!kn[i].visited)) sucheAlle(i, city1Num, ausgabe + " " + kn[i].name.substring(0, 4), gewicht + adj[city0Num][i]);
            }
        }
        kn[city0Num].visited = false;
    }

    public void sucheKurz(String city0, String city1) {
        for (Knoten k : kn) k.visited = false;
        sucheKurz(findeKnoten(city0), findeKnoten(city1), city0.substring(0, 4), 0);
        System.out.println();
    }

    public String sucheKurz(int city0Num, int city1Num, String output, double weight) {
        if (city0Num == city1Num && weight < fastestDistance) {
            fastestDistance = weight;
        } else {
            kn[city0Num].visited = true;
            for (int i = 0; i < anzahlKnoten(); i++) {
                if ((adj[city0Num][i] != 0) && (!kn[i].visited)) sucheKurz(i, city1Num, output + " " + kn[i].name.substring(0, 4), weight + adj[city0Num][i]);
            }
        }
        kn[city0Num].visited = false;
    }

    public int anzahlKnoten() {
        int a = 0;
        for (int k = 0; k < kn.length; k++) if (kn[k] != null) a++;
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
