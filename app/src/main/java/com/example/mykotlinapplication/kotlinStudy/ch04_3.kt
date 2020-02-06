package com.example.mykotlinapplication.kotlinStudy

fun getFacebookName(accountId: Int) = "fb:$accountId"


//4.2.3_1_ImplementingPropertiesDeclaredInInterfaces.kt
interface User3{
    val nickname: String
}
class PrivateUser(override val nickname: String) : User3

class SubscribingUser(val email: String) : User3 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : User3 {
    override val nickname = getFacebookName(accountId)
}



//4.2.4_AccessingABackingFieldFromAGetterOrSetter.kt
class User4(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}
//4.3.2.1_DataClassCopy.kt
data class Client(val name: String, val postalCode: Int)

//4.4.1_2_ObjectDeclarations1.kt
data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
}



//4.3.3_ClassDelegationUsingTheByKeyword.kt
class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

//4.4.2_2_CompanionObjects1.kt
fun getFacebookName1(accountId: Int) = "fb:$accountId"

class User5 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User5(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User5(getFacebookName1(accountId))
    }
}


fun main() {

    //test 4.2.3_1_ImplementingPropertiesDeclaredInInterfaces.kt
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)

    //test 4.2.4_AccessingABackingFieldFromAGetterOrSetter.kt
    val user = User4("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    //test data class
    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))

    //test 4.3.3
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")

    //test 4.4.1
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))

    //test4.4.2
    val subscribingUser = User5.newSubscribingUser("bob@gmail.com")
    val facebookUser = User5.newFacebookUser(4)
    println(subscribingUser.nickname)
}