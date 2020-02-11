package com.example.mykotlinapplication.kotlinStudy

//11.4.2_ExtensionsOnPrimitiveTypes.kt

import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

val Int.days: Period
    @RequiresApi(Build.VERSION_CODES.O)
    get() = Period.ofDays(this)

val Period.ago: LocalDate
    @RequiresApi(Build.VERSION_CODES.O)
    get() = LocalDate.now() - this

val Period.fromNow: LocalDate
    @RequiresApi(Build.VERSION_CODES.O)
    get() = LocalDate.now() + this

fun main() {
    println(1.days.ago)
    println(1.days.fromNow)
}