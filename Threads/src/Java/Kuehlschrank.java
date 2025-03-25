package Java;

public class Kuehlschrank {
    private Yogurt[] yogurt;
    private int anzahl;

    public Kuehlschrank() {
        this.yogurt = new Yogurt[10];
        this.anzahl = 0;
    }

    public String hinfzufuegen(Yogurt ding) {
            yogurt[anzahl] = ding;
            anzahl++;
            return "hat Yogurt " + ding.getName() + " hinzugefügt.";
    }

    public String entnehmen() {
            Yogurt removedYogurt = yogurt[anzahl - 1];
            yogurt[anzahl - 1] = null;
            anzahl--;
            return "hat Yogurt " + removedYogurt.getName() + " entnommen.";
    }

    public int yogurtAnzahl() {
        return anzahl;
    }

    public boolean istLeer() {
        return anzahl == 0;
    }

    public boolean nochPlatz() {
        return anzahl < yogurt.length;
    }
}