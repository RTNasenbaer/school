class Spiel {

    private val mami: Erzeuger = Erzeuger("Mami", Kuehlschrank())
    private val papi: Erzeuger = Erzeuger("Papi", Kuehlschrank())
    private val omi: Erzeuger = Erzeuger("Omi", Kuehlschrank())

    private val philipp: Verbraucher = Verbraucher("Philipp", Kuehlschrank())
    private val finn: Verbraucher = Verbraucher("Finn", Kuehlschrank())
    private val lina: Verbraucher = Verbraucher("Lina", Kuehlschrank())

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