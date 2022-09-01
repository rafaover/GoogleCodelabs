//To refer to a function as a value, you need to use the function reference operator (::) before the function name.
fun main() {
    //The Int parameter is named quantity, but could be named anything or
    //omitted like the cupcake function.
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    // Variable calling another function
    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    }
    else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

//lambda expression -- { } inside a variable, which turns in a function.
//"trick" is a function in this lambda expression.
val trick = {
    println("No treats!")
}
//Specifying a data type. "Unit" in this case is the RETURN TYPE of the function.
val treat: () -> Unit = {
    println("Have a treat!")
}