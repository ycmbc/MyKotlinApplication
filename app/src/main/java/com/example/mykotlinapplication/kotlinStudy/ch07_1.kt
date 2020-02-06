package com.example.mykotlinapplication.kotlinStudy

import java.math.BigDecimal

//7.1.1_1_PointPlusMember.kt
data class Point(val x: Int, val y: Int) {
//    operator fun plus(other: Point): Point {
//        return Point(x + other.x, y + other.y)
//    }
}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}


//7.1.1_3_BinaryOperators2.kt
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

//7.1.3_1_UnaryOperators.kt
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}


//7.1.3_2_UnaryOperators1.kt
operator fun BigDecimal.inc() = this + BigDecimal.ONE

//7.2.1_EqualityOperators.kt
class Point1(val x: Int, val y: Int) {
    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point1) return false
        return obj.x == x && obj.y == y
    }
}

//7.3.1_1_IndexOperator.kt
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}


//7.3.1_2_IndexOperator1.kt
data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

//7.5.2_1_LazyEmails.kt
class Email { /*...*/ }

fun loadEmails(person: Person9): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

//class Person8(val name: String) {
//    private var _emails: List<Email>? = null
//
//    val emails: List<Email>
//        get() {
//            if (_emails == null) {
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//}

class Person9(val name: String) {
    val emails by lazy { loadEmails(this) }
}

//7.5.5_1_ExpandoObject.kt
class Person11 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!

    val company: String
        get() = _attributes["company"]!!
}

//7.5.5_2_StoringPropertyValuesInAMap1.kt
class Person12 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes
}

fun main() {

    //test 7.1.1_1
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1.plus(p2))
    //test 7.1.1_3
    val p = Point(10, 20)
    println(p * 1.5)

    val numbers = ArrayList<Int>()
    numbers += 42
    numbers += 43
    numbers += 44
    println(numbers[2])
    //集合
    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

    //test 7.1.3_1
    val p3 = Point(10, 20)
    println(-p3) //
    println(p3.unaryMinus())

    //test 7.1.3_2
    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)

    //test 7.2.1_EqualityOperators.kt
    println(Point1(10, 20) == Point1(10, 20))
    println(Point1(10, 20) != Point1(5, 5))
    println(null == Point1(1, 2))

    //test 7.3.1_1
    val p4 = Point(10, 20)
    println(p4[1])

    //test 7.3.1_2_IndexOperator1.kt
    val p5 = MutablePoint(10, 20)
    p5[1] = 42
    println(p5)

    //test 7.3.3_RangePriority.kt
    val n = 9
    println(0..(n + 1))
    (0..n).forEach { print(it) }

    println()
    //7.4_1_DestructuringDeclarations.kt
    val p6 = Point(10, 20)
    val (x, y) = p6
    println(x)
    println(y)


    //test 7.5.2_1
    val p8 = Person9("Alice")
    println(p8.emails)

    //test 7.5.5_1_ExpandoObject.kt
    val p11 = Person11()
    val data = mapOf("name" to "yangchong", "company" to "soda")
    for ((attrName, value) in data)
        p11.setAttribute(attrName, value)
    println(p11.name)
    println(p11.company)

    //test 7.5.5_2_StoringPropertyValuesInAMap1.kt
    val p12 = Person12()
    val data12 = mapOf("name" to "yangchong", "company" to "soda")
    for ((attrName, value) in data12)
        p12.setAttribute(attrName, value)
    println(p12.name)

}