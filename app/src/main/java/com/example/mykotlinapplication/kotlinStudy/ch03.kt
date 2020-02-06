package com.example.mykotlinapplication.kotlinStudy

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ((index,value) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToStrings(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main() {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.max())
    val list = listOf(1, 2, 3)
    println(list)
    println(joinToString(list, "; ", "(", ")"))
    println(list.joinToStrings())
    println(list.joinToStrings(" "))
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))

}