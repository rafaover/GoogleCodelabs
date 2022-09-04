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

// EXERCISE 04 - Song Catalog
/* Create a class that can represent the structure of a song. The Song class must include these code elements:

Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]." */
    class SongCatalog {
        val title = "Ten"
        val artist = "Pearl Jam"
        val yearPublished = 1995
        val playCount = 40000

    }
    fun main() {
        val song = SongCatalog()
        when (song.playCount >= 1000){
            true -> println("This song is Popular")
            else -> {}
        }
        println("${song.title}, performed by ${song.artist}, was released in ${song.yearPublished}")
    }