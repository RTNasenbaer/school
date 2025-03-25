package Kotlin

class Verbraucher(private val name: String, private var kuehlschrank: Kuehlschrank): Thread() {

    override fun run() {
        while (true) {
            sleep((Math.random()*2000).toLong())
        if (kuehlschrank.istLeer()) {
            println("Verbraucher $name: Kühlschrank ist leer.")
            return
        }
        println("Verbraucher $name ${kuehlschrank.entnehmen()}")
        }
    }
    
}