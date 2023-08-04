// Learning Points
// Use of generic Type
// Use o ENUM Class and ENUM Constant
// Use of Data Class
// Use of Singleton object
// Use of Companion Objects
// User of extension properties

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

// extension property user
// Extension properties can't store data, so they must be get-only.
val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered"

fun main() {
    println(Quiz.progressText)
    
}
