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

    public int anzahlKnoten() {
        int a = 0;
        for (int k = 0; k < kn.length; k++) if (kn[k] != null) a++;
        return a;
    }

    public int findeKnoten(String city0) {
        for (int k = 0; k <= anzahlKnoten(); k++) if (kn[k].name.equals(city0)) return k;
        return -1;
    }
}
