package com.example.mykotlinapplication.kotlinStudy

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

private fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")


//3.3.5 扩展属性
val String.lastChar: Char
    get() = get(length - 1)

fun String.lastChar(): Char = this[this.length - 1]

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()
    view.showOff()
    //3.3.5
    println("Kotlin".lastChar)

    println("kotlin".lastChar())

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)


    //3.4.2 varargs
    val list = listOf("args1: ", "args2: ")
    println(list)


    //3.5.1 split
    println("12.34*5-6.A".split("\\.|-|\\*".toRegex()))
    println("12.34*5-6.A".split(".", "-", "*"))

    val strings = arrayOf(".", "-", "*")
    println("12.34*5-6.A".split(*strings, ignoreCase = true, limit = 0))

    //3.5.2
    println("12.345-6.A".split(".", "-"))

    //
    val kotlinLogo = """| //
                       .|//
                       .|/ \""" //原生字符串，可以包含换行和任何其他文本

    val string = "" //转义字符串，类似java string

    println(kotlinLogo.trimMargin("."))


    val stringsss = arrayOf("ss", "s")
    stringsss.forEach {
        println(it)
    }


}
