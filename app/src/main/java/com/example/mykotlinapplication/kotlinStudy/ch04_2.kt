package com.example.mykotlinapplication.kotlinStudy

//4.1.4_2_InnerAndNestedClasses
class Outer {

    //
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}


//
interface Expr
//
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

//sealed class
sealed class Expr1 {
    class Num(val value: Int) : Expr1()
    class Sum(val left: Expr1, val right: Expr1) : Expr1()
}

fun eval(e: Expr1): Int =
    when (e) {
        is Expr1.Num -> e.value
        is Expr1.Sum -> eval(e.right) + eval(e.left)
    }


//4.2.1_InitializingClasses.kt
class User1(val nickname: String,
           val isSubscribed: Boolean = true)


fun main() {

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    //test sealed class
    println(eval(Expr1.Sum(Expr1.Sum(Expr1.Num(1), Expr1.Num(2)), Expr1.Num(4))))

    //test 4.2.1
    val alice = User1("Alice")
    println(alice.isSubscribed)
    val bob = User1("Bob", false)
    println(bob.isSubscribed)
    val carol = User1("Carol", isSubscribed = false)
    println(carol.isSubscribed)


}


