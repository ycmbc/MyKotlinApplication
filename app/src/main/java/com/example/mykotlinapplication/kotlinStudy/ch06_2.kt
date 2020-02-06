package com.example.mykotlinapplication.kotlinStudy


//6.1.4_2_ElvisOperator1.kt

class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person4(val name: String, val company: Company?)

fun printShippingLabel(person: Person4) {
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(args: Array<String>) {
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person4("Dmitry", jetbrains)
    printShippingLabel(person)
    printShippingLabel(Person4("Alexey", null))
}