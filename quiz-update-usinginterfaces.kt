// ---- Learning Points
// Use of generic Type
// Use o ENUM Class and ENUM Constant
// Use of Data Class
// Use of Singleton object
// Use of Companion Objects
// Use of extension properties
// Use of Interfaces

// Now we have the answer type using the generic and 
// difficulty using the enum class type.
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

// quiz class now extends the ProgressPrintable Interface
class Quiz : ProgressPrintable {
    val q1 = Question<String>("Name of the bird", "raven", Difficulty.EASY)
    val q2 = Question<Boolean>("Sky is blue?", true, Difficulty.MEDIUM)
    val q3 = Question<Int>("How much is 2+2?", 4, Difficulty.HARD)
    
    // You cannot create instances of the singleton, it's direct access.
	companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
	}
    
    // Because it came from the interface, you need to add override to the variable
    // The get extension was removed from the old extension property and added here
    override val progressText: String
    	get() = "${answered} of ${total} answered"
    
    override fun printProgressBar() {
    	repeat(answered) {print("▓")}
        repeat(total - answered) {print("▒")}
        println()
        println(progressText)
    }
}

fun main() {
    // As the printProgressBar() function is now a method of the Quiz class, 
    // you need to first instantiate a Quiz object and 
    // then call printProgressBar()
    Quiz().printProgressBar()
}
