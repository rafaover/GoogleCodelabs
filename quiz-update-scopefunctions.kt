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
    val question1 = Question<String>("Name of the bird", "raven", Difficulty.EASY)
    val question2 = Question<Boolean>("Sky is blue?", true, Difficulty.MEDIUM)
    val question3 = Question<Int>("How much is 2+2?", 4, Difficulty.HARD)
    
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
    	repeat(Quiz.answered) {print("▓")}
        repeat(Quiz.total - Quiz.answered) {print("▒")}
        println()
        println(progressText)
    }
    
    // Scope functions to avoid using long variable names repetitively.
    // In this case let() which permits using "it"
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
     }
}

fun main() {
    // 1. With the scope function, I can now create a instance of Quiz in a variable
	// and call the functions inside the Quiz class.
    val quiz = Quiz()
    quiz.printQuiz()
    quiz.printProgressBar()
    
    // 2. OR The apply() function returns the instance of the Quiz class, but since 
    // you're no longer using it anywhere, remove the quiz variable.
    Quiz().apply {
        printQuiz()
        printProgressBar()   
    }
}
