package com.example.mykotlinapplication.kotlinStudy

import java.io.Serializable

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }


    fun showOff() = println("I'm focusable!")
}

class Buttonx : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

//4.1.4_1
interface State: Serializable

interface Viewx {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Buttons : Viewx {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { /*...*/ }

    class ButtonState : State { /*...*/ }
}

fun main() {
    val button = Buttonx()
    button.showOff()
    button.setFocus(true)
    button.click()

}