package com.example.mykotlinapplication.kotlinStudy

fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit
) {
    /*...*/
}

//8.1.2_1_CallingFunctionsPassedAsArguments.kt
fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

//8.1.2_2_CallingFunctionsPassedAsArguments1.kt
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

//8.1.5_2_ReturningFunctionsFromFunctions1.kt
data class Persona(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Persona) -> Boolean {
        val startsWithPrefix = { p: Persona ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return {
            startsWithPrefix(it)
                    && it.phoneNumber != null
        }
    }
}

//8.2.3_2_InliningCollectionOperations1.kt
data class Persons(val name: String, val age: Int)


fun main() {
    val url = "http://kotl.in"
    performRequest(url) { code, content -> /*...*/ }
    performRequest(url) { code, page -> /*...*/ }

    //test 8.1.2_1
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }

    //test 8.1.2_2
    println("ab1c".filter { it in 'a'..'z' })

    //test 8.1.5_2
    val contacts = listOf(
        Persona("Dmitry", "Jemerov", "123-4567"),
        Persona("Svetlana", "Isakova", null)
    )
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))


    //test 8.2.3_2
    val people = listOf(Persons("Alice", 29), Persons("Bob", 31))
    println(people.filter { it.age > 30 }
        .map(Persons::name))


    //test 8.3.1_1_LookForAlice.kt
    val people1 = listOf(Persons("Alice", 29), Persons("Bob", 31))

    fun lookForAlice(people: List<Persons>) {
        for (person in people) {
            if (person.name == "Alice") {
                println("Found!")
                return
            }
        }
        println("Alice is not found")
    }
    lookForAlice(people1)


    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            this@sb.append(this.toString())
        }
    })

    //test 8.3.3_AnonymousFunctions.kt
    fun lookForAlices(people: List<Persons>) {
        people.forEach(fun (person) {
            if (person.name == "Alice") return
            println("${person.name} is not Alice")
        })
    }
    lookForAlices(people1)


}