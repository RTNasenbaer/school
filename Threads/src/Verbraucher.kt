class Verbraucher(private val name: String, private var kuehlschrank: Kuehlschrank): Thread() {

    override fun run() {
        sleep((Math.random()*2000).toLong())
        kuehlschrank.entnehmen()
    }
    
}