package com.example.mykotlinapplication.kotlinStudy

//11.3.3_InvokeConventionInDSLs.kt
class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(
        body: DependencyHandler.() -> Unit
    ) {
        body()
    }
}

fun main() {
    val dependencies = DependencyHandler()
    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.0.0")
    dependencies {
        compile("org.jetbrains.kotlin:kotlin-reflect:1.0.0")
    }
}