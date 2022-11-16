fun main(){
    val myFirstDice = Dice(6)
    println("Your ${myFirstDice.numSides} ${myFirstDice.colour} sided dice rolled ${myFirstDice.roll()}!")
    
    val mySecondDice = Dice(20, "Blue")
    println("Your ${mySecondDice.numSides} ${mySecondDice.colour} sided dice rolled ${mySecondDice.roll()}!")
}

class Dice (var numSides: Int, var colour: String = "Red") {
	
    fun roll(): Int {
       return (1..numSides).random()
    }
}
