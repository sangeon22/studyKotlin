package com.example.studyKotlin.domain.member

class User(
    val id: Int,
    val name: String,
    val address: String
)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    // insert into tbl_user ...
}