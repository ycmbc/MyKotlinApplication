package com.example.mykotlinapplication.kotlinStudy

//11.2.1_1_LambdasWithReceivers.kt
fun buildString(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

//11.2.1_2_LambdasWithReceivers1.kt
fun buildStrings(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

//11.3.1_InvokeConvention.kt
class Greeter(val greeting: String) {
    operator fun invoke(name: String) {
        println("$greeting, $name!")
    }
}
fun main() {
    //test 11.2.1_1
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)

    //test 11.2.1_2
    val s1 = buildStrings {
        this.append("Hello, ")
        append("World!")
    }
    println(s1)

    //test 11.2.1_3_LambdasWithReceivers2.kt
    val appendExcl: StringBuilder.() -> Unit =
        {
            append("soda")
            this.append("!")
        }
    val stringBuilder = StringBuilder("Hi,")
    stringBuilder.appendExcl()

    println(stringBuilder)
    println(buildString(appendExcl))

    //test 11.2.1_4_LambdasWithReceivers3.kt
    val map = mutableMapOf(1 to "one")
    map.apply {
        this[2] = "two"
    }
    with(map) {
        this[3] = "three"
    }
    println(map)

    //test 11.3.1
    val bavarianGreeter = Greeter("Servus")
    bavarianGreeter("Dmitry")
}