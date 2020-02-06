package com.example.mykotlinapplication.kotlinStudy

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {

    fun validate(user: User,
                 value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty $fieldName")
        }
    }

    println(user.name)
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

//    // Save user to the database
}

fun main() {
    saveUser(User(1, "1", "12"))
    saveUser(User(2, "1", "1"))
    saveUser2(User2(3, "1212", ""))
}


class User2(val id: Int, val name: String, val address: String)

fun saveUser2(user: User2) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user ${user.id}: " +
                        "empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Save user to the database
}
