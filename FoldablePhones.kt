// EXERCISE 06 - Foldable Phones

fun main(){
    val newFoldablePhone = FoldablePhone()

    //newFoldablePhone.switchOn()
    //newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.openPhone()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()

}
//Primary class. switch is a phone button to switch on/off a phone.
//You would check if the light is on.
open class Phone (var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
// A different switchOn() function behavior than the Phone class so
// that it only turns the screen on when the phone isn't folded.
// FoldablePhone is a subclass. It's a phone, but foldable.
// The light only will be on when the phone is not folded openPhone()
class FoldablePhone(private var phoneIsFolded: Boolean = true): Phone() {
    override fun switchOn() {
        if (!phoneIsFolded) isScreenLightOn = true
        else println("Phone is Closed")
    }
    fun openPhone() {
        phoneIsFolded = false
        println("Phone is open")
    }
}