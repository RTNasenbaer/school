import java.util.Arrays;

public class DBNetz {

    Graph fahrplan;

    public DBNetz() {
        fahrplanAnlegen();
//        for (Knoten k : fahrplan.kn) System.out.println(k.name);
    }

    public static void main(String[] args) {
        new DBNetz();
    }

    public void fahrplanAnlegen() {

        fahrplan = new Graph(14);
        fahrplan.knoten_hinzufuegen("Berlin");
        fahrplan.knoten_hinzufuegen("Dresden");
        fahrplan.knoten_hinzufuegen("Erfurt");
        fahrplan.knoten_hinzufuegen("Frankfurt");
        fahrplan.knoten_hinzufuegen("Hannover");
        fahrplan.knoten_hinzufuegen("Bremen");
        fahrplan.knoten_hinzufuegen("Hamburg");
        fahrplan.knoten_hinzufuegen("Köln");
        fahrplan.knoten_hinzufuegen("Kassel");
        fahrplan.knoten_hinzufuegen("Leipzig");
        fahrplan.knoten_hinzufuegen("München");
        fahrplan.knoten_hinzufuegen("Nürnberg");
        fahrplan.knoten_hinzufuegen("Stuttgart");
        fahrplan.knoten_hinzufuegen("Würzburg");
        fahrplan.kante_hinzufuegen("Berlin", "Hannover", 260, true);
        fahrplan.kante_hinzufuegen("Berlin", "Hamburg", 280, true);
        fahrplan.kante_hinzufuegen("Berlin", "Leipzig", 180, true);
        fahrplan.kante_hinzufuegen("Dresden", "Leipzig", 140, true);
        fahrplan.kante_hinzufuegen("Erfurt", "Frankfurt", 270, true);
        fahrplan.kante_hinzufuegen("Erfurt", "Kassel", 140, true);
        fahrplan.kante_hinzufuegen("Erfurt", "Leipzig", 170, true);
        fahrplan.kante_hinzufuegen("Erfurt", "Nürnberg", 260, true);
        fahrplan.kante_hinzufuegen("Erfurt", "Würzburg", 300, true);
        fahrplan.kante_hinzufuegen("Frankfurt", "Köln", 190, true);
        fahrplan.kante_hinzufuegen("Frankfurt", "Kassel", 190, true);
        fahrplan.kante_hinzufuegen("Frankfurt", "Stuttgart", 200, true);
        fahrplan.kante_hinzufuegen("Frankfurt", "Würzburg", 130, true);
        fahrplan.kante_hinzufuegen("Hannover", "Bremen", 120, true);
        fahrplan.kante_hinzufuegen("Hannover", "Hamburg", 150, true);
        fahrplan.kante_hinzufuegen("Hannover", "Kassel", 240, true);
        fahrplan.kante_hinzufuegen("Bremen", "Hamburg", 110, true);
        fahrplan.kante_hinzufuegen("München", "Nürnberg", 160, true);
        fahrplan.kante_hinzufuegen("München", "Stuttgart", 210, true);
        fahrplan.kante_hinzufuegen("Nürnberg", "Würzburg", 110, true);

    }
}