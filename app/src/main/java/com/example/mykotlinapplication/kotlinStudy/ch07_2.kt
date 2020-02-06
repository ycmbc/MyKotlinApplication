package com.example.mykotlinapplication.kotlinStudy

class Person7(
    val firstName: String,
    val lastName: String
) : Comparable<Person7> {
    override fun compareTo(other: Person7): Int {
        return compareValuesBy(
            this, other,
            Person7::lastName, Person7::firstName
        )
    }
}

fun main() {
    val p1 = Person7("Alice", "Smith")
    val p2 = Person7("Bob", "Johnson")
    println(p1 < p2)
}