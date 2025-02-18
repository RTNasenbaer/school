import java.util.ArrayList;

public class Graph {

    public Knoten[] kn;
    public int[][] adj;


    public Graph(int size) {
        kn = new Knoten[size];
        adj = new int[size][size];
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
        System.out.println();
        System.out.println("\u2500".repeat(15*6));
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
    int size = anzahlKnoten();
    int columnWidth = 6;
    int totalWidth = (size + 1) * columnWidth + 1; // Adjusted width for alignment

    // Top border
    System.out.println("+" + "─".repeat(totalWidth) + "+");

    // Header row
    System.out.print("|");
    System.out.printf("%6s", " ");
    for (int i = 0; i < size; i++) {
        System.out.printf("%6s", kn[i].name.substring(0, 4));
    }
    System.out.println(" |");

    // Separator line
    System.out.println("|" + "─".repeat(totalWidth) + "|");

    // Table content
    for (int i = 0; i < size; i++) {
        System.out.print("|");
        System.out.printf("%6s", kn[i].name.substring(0, 4));
        for (int j = 0; j < size; j++) {
            if (adj[i][j] != 0)
                System.out.printf("%6d", adj[i][j]);
            else
                System.out.printf("%6s", "──");
        }
        System.out.println(" |");
    }

    // Bottom border
    System.out.println("+" + "─".repeat(totalWidth) + "+");
}

}
