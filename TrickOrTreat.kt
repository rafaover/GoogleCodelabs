//To refer to a function as a value, you need to use the function reference operator (::) before the function name.
fun main() {
    //The Int parameter is named quantity, but could be named anything or
    //omitted like the cupcake function.
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }
    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }
    // Variable calling another function
    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    trickFunction()
    treatFunction()
}