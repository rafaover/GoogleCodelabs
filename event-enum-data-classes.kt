enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event (
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

var events = mutableListOf<Event>(
    Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
   	Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
	Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
	Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
    Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
	Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45),
)

fun main() {
    var shortEventsCount = 0
    events.forEach {
    	if (it.durationInMinutes < 60) shortEventsCount++
    }
// val shortEvents = events.filter { it.durationInMinutes < 60 }
// println("You have ${shortEvents.size} short events.")
    println("You have ${shortEventsCount} short events.")
    
    val eventsMorning = events.filter { it.daypart == Daypart.MORNING }.count()
    val eventsArvo = events.filter { it.daypart == Daypart.AFTERNOON }.count()
    val eventsEvening = events.filter { it.daypart == Daypart.EVENING }.count()
    println("""
Morning: ${eventsMorning} events
Afternoon: ${eventsArvo} events
Evening: ${eventsEvening} events
    """)
// 	val groupedEvents = events.groupBy { it.daypart }
// 	groupedEvents.forEach { (daypart, events) ->
//     	println("$daypart: ${events.size} events")
// 	}
}
