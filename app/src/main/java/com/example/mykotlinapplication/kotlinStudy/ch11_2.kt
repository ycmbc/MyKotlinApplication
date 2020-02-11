package com.example.mykotlinapplication.kotlinStudy

//11.2.2_1_HtmlTags.kt
open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()

    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        child.init()
        children.add(child)
    }

    override fun toString() =
        "<$name>${children.joinToString("")}</$name>"
}

fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")

fun createTable() =
    table {
        tr {
            td {
            }
            td {

            }
        }
    }

fun createAnotherTable() =
    table {
        for (i in 1..2) {
            tr {
                td {
                }
            }
        }
    }

fun main() {
    //输出html标签
    println(createTable())

    println(createAnotherTable())
}