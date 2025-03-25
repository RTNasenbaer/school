package Kotlin

class Spiel {

    private val kuehlschrank: Kuehlschrank = Kuehlschrank()

    private val mami: Erzeuger = Erzeuger("Mami", kuehlschrank)
    private val papi: Erzeuger = Erzeuger("Papi", kuehlschrank)
    private val omi: Erzeuger = Erzeuger("Omi", kuehlschrank)

    private val philipp: Verbraucher = Verbraucher("Philipp", kuehlschrank)
    private val finn: Verbraucher = Verbraucher("Finn", kuehlschrank)
    private val lina: Verbraucher = Verbraucher("Lina", kuehlschrank)

    init {
        mami.start()
        papi.start()
        omi.start()

        philipp.start()
        finn.start()
        lina.start()
    }
}

// Top-level main function
fun main() {
    Spiel()
}