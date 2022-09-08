// EXERCISE 04 - Song Catalog (Option 02)

class SongCatalog(val title: String, val artist: String, val yearPublished: Int, val playCount: Int) {
    fun playSong(){
        when (playCount >= 1000){
        true -> println("This song is Popular")
        else -> {}
        }
    println("${title}, performed by ${artist}, was released in ${yearPublished}.")
    }
}

fun main() {
    val callingTheBand = SongCatalog(
        readln(),
        readln(),
        readln().toInt(),
        readln().toInt())
    callingTheBand.playSong()
}