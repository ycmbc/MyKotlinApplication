package com.example.mykotlinapplication.kotlinStudy

import kotlin.reflect.full.memberProperties

//10.2.1_1_ReflectionAPI.kt
class Person20(val name: String, val age: Int)

//10.2.1_2_ReflectionAPI1.kt
fun foo(x: Int) = println(x)

//10.2.1_3_ReflectionAPI2.kt
var counter = 0

fun main() {

    //test 10.2.1_1
    val person = Person20("Alice", 18)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    //test 10.2.1_2
    val kFunction = ::foo
    kFunction.call(42)


    //test 10.2.1_3
    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())

    val memberProperty = Person20::age
    println(memberProperty.get(person))
}