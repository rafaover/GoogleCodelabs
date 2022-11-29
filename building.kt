/**
* Program that implements classes in different types of constructions
* Shows how to:
* Create class hierarchy, variables and functions with inheritance,
* abstract class, overriding, and private vs. public variables.
*/

import kotlin.math.*

fun main(){
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
    println("Floor area: ${squareCabin.floorArea()}")
    
    // You can substitute the class name in every print for the with() method.
    
    with(squareCabin) {
    println("\nSquare Cabin\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
    println("Floor area: %.2f".format(floorArea()))
	}
    
    with(roundHut) {
    println("\nRound Hut\n=========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Has room? ${hasRoom()}")
    getRoom()
    println("Has room? ${hasRoom()}")
    getRoom()
    println("Floor area: %.2f".format(floorArea()))
    println("Carpet Length: ${calculateMaxCarpetLength()}")
	}
    
    with(roundTower) {
    println("\nRound Tower\n==========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Floor area: ${floorArea()}")
    println("Floor area: %.2f".format(floorArea()))
    println("Carpet Length: ${calculateMaxCarpetLength()}")
	}
   
}

/**
* Defines properties common to all dwellings.
* All dwellings have floorspace,
* but its calculation is specific to the subclass.
* Checking and getting a room are implemented here
* because they are the same for all Dwelling subclasses.
*
* @param residents --> Current number of residents
*/

// It's named as abstract because doesn't pass/have any values
abstract class Dwelling(private var residents: Int) {
        
    abstract val buildingMaterial: String 
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
    
    abstract fun floorArea(): Double
    
    /**
    * Compares the capacity to the number of residents and
    * if capacity is larger than number of residents,
    * add resident by increasing the number of residents.
    */
    fun getroom() {
        if (hasRoom()) {
            residents++
            println("You got a room!")
        } else {
        	println("Sorry, at capacity and no rooms left.")
        }
    }
}
    
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "wood"
    override val capacity = 6
    override fun floorArea(): Double { 
        return length * length 
    }
    
}

// Cannot be subclassed (Only abstract or Open classes can) 
// but you can mark as OPEN to be accessed.
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
    override fun floorArea(): Double { 
        return PI * radius * radius 
    }
    
    fun calculateMaxCarpetLength(): Double {
    	return sqrt(2.0) * radius
	}
    
}

class RoundTower(residents: Int, radius: Double, 
                 val floors: Int = 2
                ) : RoundHut(residents, radius) {
    
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double { 
        return super.floorArea() * floors 
    }
}
