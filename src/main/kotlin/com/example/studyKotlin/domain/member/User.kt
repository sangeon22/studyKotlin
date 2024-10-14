package com.example.studyKotlin.domain.member

class User(
    val id: Int,
    val name: String,
    val address: String
)

fun saveUser(user: User) {
//    if (user.name.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//    }
//    if (user.address.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
//    }

    fun validate(
        user: User,
        value: String,
        fieldName: String
    ) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }

    //필드 검증 중복을 로컬 함수를 통해 중복제거
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // insert into tbl_user ...
}