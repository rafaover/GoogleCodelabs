import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice (val name: String, val category: String) {
    private var deviceStatus = "online"
    open val deviceType = "unknown"
    open fun turnOn(){deviceStatus = "on"}
    open fun turnOff(){deviceStatus = "off"}
    fun printDeviceInfo() {
        println("Device Name: $name, Category: $category, Type: $deviceType")
    }
}

// Created a SmartTvDevice subclass that extends the SmartDevice superclass.
// The constructor definition for SmartTvDevice doesn't specify whether the properties 
// are mutable or immutable (var or val). This means that the  deviceName and deviceCategory 
// parameters are merely constructor parameters instead of class properties. You won't 
// be able to use them in the class, but simply pass them to the superclass constructor.
class SmartTvDevice(deviceName: String, deviceCategory: String):
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    // Delegates from the RageRegulator Class. Instead of using Set and Get.
    // Using the delegate class to define the speakerVolume and channelNumber properties.
    private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
    //method
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }
    //method
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }
}
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // To provide this device-specific behavior, you need to override the turnOn() and turnOff() 
    // method defined in the superclass. To override means to intercept the action, typically 
    // to take manual control. When you override a method, the method in the subclass interrupts 
    // the execution of the method defined in the superclass and provides its own execution.
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
    fun increaseBrightness() {
        brightnessLevel++
    }
    fun decreaseBrightness() {
        brightnessLevel--
    }
}

class SmartHome (
    private val smartTvDevice: SmartTvDevice,
    private val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set
    //method calling methods
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    private fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    private fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }
}

// In the RangeRegulator class's primary constructor, add an initialValue parameter, 
// a private minValue property, and a private maxValue property, all of Int type.
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
    // These types inside the angled brackets represent generic types.
) : ReadWriteProperty<Any?, Int> {

    private var fieldData = initialValue
    // The KProperty is an interface that represents a declared property 
    // and lets you access the metadata on a delegated property.
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    smartHome.turnOnLight()
    smartHome.printSmartLightInfo()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}
