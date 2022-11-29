fun main(){
    val squareCabin = SquareCabin(1)
    val roundHut = RoundHut(3)
    val roundTower = RoundTower(4)
    
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
    
    // You can substitute the class name in every print for the with() method.
    
    with(squareCabin) {
    println("\nSquare Cabin\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
	}
    
    with(roundHut) {
    println("\nRound Hut\n=========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Has room? ${hasRoom()}")
	}
    
    with(roundTower) {
    println("\nRound Tower\n==========")
    println("Material: ${buildingMaterial}")
    println("Capacity: ${capacity}")
    println("Has room? ${hasRoom()}")
	}
   
}

// It's named as abstract because doesn't pass/have any values
abstract class Dwelling(private var residents: Int) {
        
    abstract val buildingMaterial: String 
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}
    
class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "wood"
    override val capacity = 6
}

// Cannot be subclassed (Only abstract or Open classes can) 
// but you can mark as OPEN to be accessed.
open class RoundHut(residents: Int) : Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4
}

class RoundTower(residents: Int, floors: Int = 2) : RoundHut(residents) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
}
