package Kotlin

class Kuehlschrank {

    private val yogurt: Array<Yogurt?> = arrayOfNulls(10)
    private var count: Int = 0

    fun hinfzufuegen(ding: Yogurt): String {
        yogurt[count] = ding
        count++
        return "hat Yogurt ${ding.name} hinzugefügt."
    }

    fun entnehmen(): String {
        val removedYogurt = yogurt[count - 1]
        yogurt[count - 1] = null
        count--
        return "hat Yogurt ${removedYogurt?.name} entnommen."
    }

    fun yogurtAnzahl() = count

    fun istLeer(): Boolean = count == 0

    fun nochPlatz(): Boolean = count < yogurt.size
}

class Yogurt(val name: String)