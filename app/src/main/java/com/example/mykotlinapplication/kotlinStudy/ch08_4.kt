package com.example.mykotlinapplication.kotlinStudy

//8.1.6_1_RemovingDuplicationThroughLambdas.kt

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

val averageWindowsDuration = log
    .filter { it.os == OS.WINDOWS }
    .map(SiteVisit::duration)
    .average()


//8.1.6_4_RemovingDuplicationThroughLambdas3.kt
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main() {
    println(averageWindowsDuration)

    println(log.averageDurationFor {
        it.os in setOf(OS.ANDROID, OS.IOS) })

    println(log.averageDurationFor {
        it.os == OS.IOS && it.path == "/signup" })
}