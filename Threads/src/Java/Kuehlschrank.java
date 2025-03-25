package Java;

import java.util.ArrayList;
import java.util.List;

public class Kuehlschrank {
    private final List<Yogurt> yogurt;

    public Kuehlschrank() {
        this.yogurt = new ArrayList<>();
    }

    public String hinfzufuegen(Yogurt ding) {
        yogurt.add(ding);
        return "hat Yogurt " + ding.getName() + " hinzugefügt.";
    }

    public String entnehmen() {
        return "hat Yogurt " + yogurt.remove(yogurt.size() - 1).getName() + " entnommen.";
    }

    public int yogurtAnzahl() {
        return yogurt.size();
    }

    public boolean istLeer() {
        return yogurt.isEmpty();
    }

    public boolean nochPlatz() {
        return yogurt.size() < 10;
    }
}
