package com.example.mykotlinapplication.kotlinStudy


//9.1.1_2_GenericFunctionsAndProperties1.kt
val <T> List<T>.penultimate: T
    get() = this[size - 2]

//9.1.3_1_TypeParameterConstraints.kt
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

//9.1.3_2_TypeParameterConstraints1.kt
fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}


//9.1.3_3_TypeParameterConstraints2.kt
fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}


//9.2.1_1_GenericsAtRuntimeTypeChecksAndCasts.kt
fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

//9.2.2_1_DeclaringFunctionsWithReifiedTypeParameters.kt
inline fun <reified T> isA(value: Any) = value is T


//9.3.5_1_CopyDataAny.kt
fun <T : R, R> copyData(
    source: MutableList<T>,
    destination: MutableList<R>
) {
    for (item in source) {
        destination.add(item)
    }
}

fun main() {

    //test 9.1.1_1_GenericFunctionsAndProperties.kt
    val letters = ('a'..'z').toList()
    println(letters.slice(0..2))
    println(letters.slice(10..13))


    //test 9.1.1_2
    println(listOf(1, 2, 3, 4).penultimate)

    //test 9.1.3_1
    println(oneHalf(0xff))

    //test 9.1.3_2
    println(max("kotlin", "java"))
    println(max(3, 15))

    //test 9.1.3_3
    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    //test 9.2.1_1
    printSum(listOf(1, 2, 3))

    //test 9.2.2_1
    println(isA<String>("abc"))
    println(isA<String>(123))

    //test 9.2.2_2_DeclaringFunctionsWithReifiedTypeParameters1.kt
    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())


    //test 9.3.1_WhyVarianceExists.kt
    fun printContents(list: List<Any>) {
        println(list.joinToString())
    }

    printContents(listOf("abc", "bac"))

    //test 9.3.5_1_CopyDataAny.kt
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)
    println(anyItems)


    //test 9.3.6.2_1_printFirst.kt
    fun <T> printFirst(list: List<T>) {
        if (list.isNotEmpty()) {
            println(list.first())
        }
    }
    printFirst(listOf("Svetlana", "Dmitry"))


}