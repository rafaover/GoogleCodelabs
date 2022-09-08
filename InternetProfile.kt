/* EXERCISE 05 - Internet Profile
Complete the showProfile() function so that the program print the output */

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        when {
            referrer == null -> println("""Name: ${name}
            Age: ${age}
            Likes to ${hobby}. Doesn't have a referrer."""")
            else -> println("""Name: ${name}
Age: ${age}
Likes to ${hobby}. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}""")
        }
    }
}
/*OUTPUT:
Name: Amanda
Age: 33
Likes to play tennis. Doesn't have a referrer.

Name: Atiqah
Age: 28
Likes to climb. Has a referrer named Amanda, who likes to play tennis.
*/