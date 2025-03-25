package Kotlin

class Erzeuger(private val name: String, private var kuehlschrank: Kuehlschrank): Thread() {

    override fun run() {
        while (true) {
            sleep((Math.random()*2000).toLong())
        if (!kuehlschrank.nochPlatz()) {
            println("Erzeuger $name: Kühlschrank ist voll.")
            return
        }
        println("Erzeuger $name ${kuehlschrank.hinfzufuegen(Yogurt("Vanille"))}")
        }
    }

}