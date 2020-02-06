package com.example.mykotlinapplication.kotlinStudy


//5.1.2_LambdasAndCollections.kt
data class Person1(val name: String, val age: Int)

fun findTheOldest(people: List<Person1>) {
    var maxAge = 0
    var theOldest: Person1? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}


//5.1.3_4_SyntaxForLambdaExpressions3.kt
data class Person2(val name: String, val age: Int)


//5.1.4_2_AccessingVariablesInScope1.kt
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

//5.1.5_2_MemberReferences1.kt
data class Person3(val name: String, val age: Int)

//5.2.4_2_FlatMapFlatten1.kt
class Book(val title: String, val authors: List<String>)

fun main() {
    //test 5.1.2
    val people = listOf(Person1("Alice", 29), Person1("Bob", 31))
    findTheOldest(people)

    //lambdas
    val sum = { x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x + y
    }
    println(sum(1, 2))

    //test 5.1.3_4
    val people2 = listOf(Person2("Alice", 29), Person2("Bob", 31))
    ///**
    // * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
    // *
    // * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
    // * elements will be appended, followed by the [truncated] string (which defaults to "...").
    // *
    // * @sample samples.collections.Collections.Transformations.joinToString
    // */
    val names = people2.joinToString(separator = " ",
        transform = { p: Person2 -> p.name })
    println(names)


    //test 5.1.4_2
    val responses = listOf(
        "200 OK", "418 I'm a teapot",
        "500 Internal Server Error"
    )
    printProblemCounts(responses)

    //5.1.5_1_MemberReferences.kt
    fun salute() = println("Salute!")
    ///**
    // * Calls the specified function [block] and returns its result.
    // *
    // * For detailed usage information see the documentation for [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run).
    // */
    run(::salute)


    //test 5.1.5_2
    val createPerson = ::Person3
    val p = createPerson("Alice", 29)
    println(p)

    //test 5.2.1_3_FilterMap2.kt
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it })
    //5.2.1_5
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })

    //test 5.2.2_2_AllAnyCountFind1.kt
    val list2 = listOf(1, 2, 3)
    println(!list2.all { it == 3 })
    println(list2.any { it != 3 })

    //test 5.2.3_1_GroupBy.kt
    val people3 = listOf(Person2("Alice", 31),
        Person2("Bob", 29), Person2("Carol", 31))
    println(people3.groupBy { it.age })

    val list3 = listOf("a", "ab", "b")
    println(list3.groupBy(String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap {
        it.toList()
    })

    //test 5.2.4_2_FlatMapFlatten1.kt
    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett",
            "Neil Gaiman")))
    println(books.flatMap { it.authors }.toSet())

    //5.3.1_2_ExecutingSequenceOperations1.kt
    listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { println("filter($it) "); it % 2 == 0 }
        .toList()


    //test 5.5.1_3_TheWithFunction2.kt
    fun alphabet() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
    println(alphabet())
}