/** EXERCISE 01 - Phone Notification
fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}


fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
    return
}
// OUTPUT ----
// You have 51 notifications.
// Your phone is blowing up! You have 99+ notifications.
 **/

/** EXERCISE 02 - Movie Ticket Price
fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is  \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    if (age <= 12) return 15
    else if (age in 13..60) {
        if (isMonday) {
            return 25
        }
    return 30
    }
    if (age in 61..100) return 20 else return -1
}
 // OUTPUT
The movie ticket price for a person aged 5 is $15.
The movie ticket price for a person aged 28 is $25.
The movie ticket price for a person aged 87 is $20.
 **/

/** EXERCISE 03 - Temperature Converter
fun main() {
    val celsiusTemp = 27.0
    val fahTemp = 10.0
    val kelvinTemp = 350.0
    val c = "Celsius"
    val f = "Fahrenheit"
    val k = "Kelvin"
    val celsius2Fah: (Double) -> Double = { 1.8 * celsiusTemp + 32 }
    val kelvin2Celsius: (Double) -> Double = { kelvinTemp - 273.15 }
    val fah2Kelvin: (Double) -> Double = { (5 * (fahTemp - 32)) / 9 + 273.15 }

    printFinalTemperature(celsiusTemp, c,  f, celsius2Fah)
    printFinalTemperature(kelvinTemp, k, c, kelvin2Celsius)
    printFinalTemperature(fahTemp, f, k, fah2Kelvin)
}
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

/* OUTPUT ----
27.0 degrees Celsius is 80.60 degrees Fahrenheit.
350.0 degrees Kelvin is 76.85 degrees Celsius.
10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
 */*/

/** EXERCISE 04 - Song Catalog (Option 01)
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
    } **/

/** EXERCISE 04 - Song Catalog (Option 02)

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
} **/

/** EXERCISE 05 - Internet Profile
 * Complete the showProfile() function so that the program print the output

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        when {
            referrer == null -> println("""Name: ${name}
Age: ${age}
Likes to ${hobby}. Doesn't have a referrer."""")
            else -> println("""Name: ${name}
Age: ${age}
Likes to ${hobby}. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}""")
        }
    }
}
/** OUTPUT:
Name: Amanda
Age: 33
Likes to play tennis. Doesn't have a referrer.

Name: Atiqah
Age: 28
Likes to climb. Has a referrer named Amanda, who likes to play tennis.
 */
 **/

/** EXERCISE 06 - Foldable Phones **/

fun main(){
    val newFoldablePhone = FoldablePhone()

    //newFoldablePhone.switchOn()
    //newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.openPhone()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()

}
//main class. switch is a phone button to switch on/off a phone.
//You would check if the light is on.
open class Phone (var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    fun switchOff() {
        isScreenLightOn = false
    }
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
// A different switchOn() function behavior than the Phone class so
// that it only turns the screen on when the phone isn't folded.
// FoldablePhone is a subclass. It's a phone, but foldable.
// The light only will be on when the phone is not folded openPhone()
class FoldablePhone(var phoneIsFolded: Boolean = true): Phone() {
    val fone = Phone()
    override fun switchOn() {
        if (phoneIsFolded == false) isScreenLightOn = true
        else println("Phone is Closed")
    }
    fun foldedPhone() {
        phoneIsFolded = true
    }
    fun openPhone() {
        phoneIsFolded = false
        println("Phone is open")
    }
}