// Learning Points
// Use of generic Type
// Use o ENUM Class and ENUM Constant
// Use of Data Class
// Use of Singleton object

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

class Quiz {
    val q1 = Question<String>("Name of the bird", "raven", Difficulty.EASY)
    val q2 = Question<Boolean>("Sky is blue?", true, Difficulty.MEDIUM)
    val q3 = Question<Int>("How much is 2+2?", 4, Difficulty.HARD)
    
    // You cannot create instances of the singleton, it's direct access.
	  companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
	}
}

fun main() {
    // Even though these properties are declared in the StudentProgress object, 
    // they can be accessed with dot notation using only the name of the Quiz class.
    println("${Quiz.answered} of ${Quiz.total} answered")
    
}
