class Kuehlschrank() {

    private val yogurt: MutableList<Yogurt> = mutableListOf()

    fun hinfzufuegen(ding: Yogurt): String {
        yogurt.add(ding)
        return "hat Yogurt ${ding.name} hinzugefügt."
    }

    fun entnehmen(): String {
        return "hat Yogurt ${yogurt.removeAt(yogurt.size - 1).name} entnommen."
    }

    fun yogurtAnzahl() = yogurt.size

    fun istLeer(): Boolean = yogurt.isEmpty()

    fun nochPlatz():Boolean = yogurt.size < 10

}

class Yogurt(val name: String) { // Changed `private` to `val` for public access
}