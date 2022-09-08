// EXERCISE 04 - Song Catalog (Option 01)
/* Create a class that can represent the structure of a song. The Song class must include these code elements:
Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]." */

class SongCatalog {
    private val title = "Ten"
    private val artist = "Pearl Jam"
    private val yearPublished = 1995
    private val playCount = 40000

    fun playSong(){
        val song = SongCatalog()
        when (song.playCount >= 1000){
            true -> println("This song is Popular")
            else -> {}
        }
    println("${song.title}, performed by ${song.artist}, was released in ${song.yearPublished}")
    }
}

fun main() {
    val songPlay = SongCatalog()
    songPlay.playSong()
}