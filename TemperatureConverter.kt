//EXERCISE 03 - Temperature Converter
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
*/