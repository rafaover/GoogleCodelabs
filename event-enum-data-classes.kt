enum class Daypart {
    Morning, Afternoon, Evening
}

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)

fun main() {
   val event = Event(
       "Study Kotlin",
       "Commit to studying Kotlin at least 15 minutes per day.",
       Daypart.Evening,
       15
   )
   println(event)
}

// Event(title=Study Kotlin, description=Commit to studying Kotlin at least 15 minutes per day., daypart=Evening, durationInMinutes=15)
