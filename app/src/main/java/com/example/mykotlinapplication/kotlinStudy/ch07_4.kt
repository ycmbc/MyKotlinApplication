package com.example.mykotlinapplication.kotlinStudy

//7.3.4_IteratorConvention.kt
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start

        override fun hasNext() =
            current <= endInclusive

        @RequiresApi(Build.VERSION_CODES.O)
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val newYear = LocalDate.ofYearDay(2020, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}