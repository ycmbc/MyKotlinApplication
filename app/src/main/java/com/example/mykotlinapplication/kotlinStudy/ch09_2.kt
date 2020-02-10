package com.example.mykotlinapplication.kotlinStudy

fun <T> copyData1(source: MutableList<out T>,
                 destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}


fun <T> copyData2(source: MutableList<T>,
                 destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}


fun main() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
//    copyData1(ints, anyItems)
//    println(anyItems)

    copyData2(ints, anyItems)
    println(anyItems)
}