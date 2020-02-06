package com.example.mykotlinapplication.kotlinStudy


//7.3.2_InOperator.kt
data class Point7(val x: Int, val y: Int)

data class Rectangle(val upperLeft: Point7, val lowerRight: Point7)

operator fun Rectangle.contains(p: Point7): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
            p.y in upperLeft.y until lowerRight.y
}

fun main() {

    val rect = Rectangle(Point7(10, 20), Point7(50, 50))
    println(Point7(20, 30) in rect)
    println(Point7(5, 5) in rect)
}