enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
)

var events = mutableListOf<Event>()

fun main() {
	events.add(
        Event(
            "Study Kotlin",
            "Commit to studying Kotlin at least 15 minutes per day.",
            Daypart.EVENING,
            15
        )
    )
    println(events)
}
