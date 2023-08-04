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

// You cannot create instances of the singleton, it's direct access.
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

fun main() {
	val q1 = Question<String>("Name of the bird", "raven", Difficulty.EASY)
    val q2 = Question<Boolean>("Sky is blue?", true, Difficulty.MEDIUM)
    val q3 = Question<Int>("How much is 2+2?", 4, Difficulty.HARD)
    
    println(q1)
    println("${StudentProgress.answered} of ${StudentProgress.total} answered")    
}
