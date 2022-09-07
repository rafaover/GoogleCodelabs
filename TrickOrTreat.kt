//To refer to a function as a value, you need to use the function reference operator (::) before the function name.
fun main() {
    //The Int parameter is named quantity, but could be named anything or
    //omitted like the cupcake function.
    //It's possible to omit the parameter name (quantity) and the -> symbol, as is a single parameter
    /* val coins: (Int) -> String = { quantity ->
        "$quantity quarters" */

    // Variable calling another function
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
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