package com.example.mykotlinapplication.kotlinStudy

//6.1.1_NullableTypes.kt
fun strLenSafe(s: String?): Int =
    if (s != null) s.length else 0


//6.1.3_2_SafeCallOperator1.kt
class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? = employee.manager?.name


///6.2.2_NullablePrimitiveTypes.kt
data class Person6(val name: String,
                  val age: Int? = null) {

    fun isOlderThan(other: Person6): Boolean? {
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

//6.3.2_ReadonlyAndMutableCollections.kt
fun <T> copyElements(source: Collection<T>,
                     target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main() {
    //test 6.1.1
    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))

    //test 6.1.3_2
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    //6.1.4_1_ElvisOperator.kt
    fun strLenSafe(s: String?): Int = s?.length ?: 0
    println(strLenSafe("abc"))
    println(strLenSafe(null))


    //6.1.6_NotnullAssertions.kt
    fun ignoreNulls(s: String?) {
        val sNotNull: String = s!!
        println(sNotNull.length)
    }
//    ignoreNulls(null)

    //6.1.7_TheLetFunction.kt
    fun sendEmailTo(email: String) {
        println("Sending email to $email")
    }
    var email: String? = "chong.yang@sodacar.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }


    //test 6.2.1_PrimitiveTypes.kt
    fun showProgress(progress: Int) {
        val percent = progress.coerceIn(0, 100)
        println("We're ${percent}% done!")
    }

    showProgress(30)

    //test 6.2.2
    println(Person6("Sam", 35).isOlderThan(Person6("Amy", 42)))
    println(Person6("Sam", 35).isOlderThan(Person6("Jane")))


    //test 6.2.6_NothingType.kt
    fun fail(message: String): Nothing {
        throw IllegalStateException(message)
    }
//    fail("Error occurred")

    //test 6.3.2
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)
    copyElements(source, target)
    println(target)

    //test 6.3.5_3_Arrays2.kt
    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    //test 6.3.5_4_Arrays3.kt
    val squares = IntArray(5) { i -> (i+1) * (i+1) }
    println(squares.joinToString())


}