import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice (val name: String, val category: String) {
    private var deviceStatus = "online"
    open val deviceType = "unknown"

    open fun turnOn(){
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }
    fun printDeviceInfo() {
        println("Device Name: $name, Category: $category, Type: $deviceType")
    }
}