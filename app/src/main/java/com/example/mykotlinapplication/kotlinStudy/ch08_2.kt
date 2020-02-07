package com.example.mykotlinapplication.kotlinStudy

//8.1.4_1_JoinToStringDefault.kt

//fun <T> Collection<T>.joinToString(
//    separator: String = ", ",
//    prefix: String = "",
//    postfix: String = "",
//    transform: (T) -> String = { it.toString() }
//): String {
//    val result = StringBuilder(prefix)
//
//    for ((index, element) in this.withIndex()) {
//        if (index > 0) result.append(separator)
//        result.append(transform(element))
//    }
//
//    result.append(postfix)
//    return result.toString()
//}

//8.1.4_2_DefaultAndNullValuesForParametersWithFunctionTypes1.kt
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element)
            ?: element.toString()
        result.append(str)
    }

    result.append(postfix)
    return result.toString()
}


fun main() {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase() })
    println(letters.joinToString(separator = "! ", postfix = "! ",
        transform = { it.toUpperCase() }))
}
