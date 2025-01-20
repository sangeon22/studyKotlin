package com.example.studyKotlin

interface User {
    val nickname: String
}

/*
interface User {
    val email: String
    val nickname: String
        get() = email.substringBefore("@")
}
*/

// 인터페이스의 프로퍼티 구현
class PrivateUser(override val nickname: String) : User  // 주생성자에 있는 프로퍼티로 인터페이스의 추상 프로퍼티 구현

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@") // Custom Getter
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId) // 초기화식 프로퍼티 구성
}

fun getFacebookName(id : Int): String {
    return "Facebook${id}User"
}

fun main() {
    println(PrivateUser("test@google.com").nickname)
    println(SubscribingUser("test@google.com").nickname)
    println(FacebookUser(12).nickname)
}