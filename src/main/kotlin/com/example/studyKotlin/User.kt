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

fun getFacebookName(id: Int): String {
    return "Facebook${id}User"
}

class CUser(val name: String) {
    // 프로퍼티가 초기화 될 때 마다 Custom Setter 동작하도록
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent()
            )
            field = value
        }
}

class LengthCount {
    var count: Int = 0
        private set //private setter 이 클래스 밖에서 이 프로퍼티의 값을 바꿀 수 있음

    // lateinit?

    fun addWord(word: String) {
        count += word.length
    }
}

fun main() {
    println(PrivateUser("test@google.com").nickname)
    println(SubscribingUser("test@google.com").nickname)
    println(FacebookUser(12).nickname)

    val user = CUser("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
    println(user.address)

    val lengthCount = LengthCount()
    lengthCount.addWord("Test!")
    println(lengthCount.count)
}