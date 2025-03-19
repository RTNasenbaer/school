class Kuehlschrank() {

    private val yogurt: MutableList<Yogurt> = mutableListOf()

    fun hinfzufuegen(ding: Yogurt) {
        if (yogurt.size < 10)
            yogurt.add(ding)
    }

    fun entnehmen() {
        if (yogurt.size > 0)
            yogurt.removeAt(yogurt.size - 1)
    }

    fun yogurtAnzahl() = yogurt.size

    fun nochPlatz():Boolean = yogurt.size < 10

}

class Yogurt(private val name: String) {

}