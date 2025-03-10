package com.example.studyKotlin

class A {
    companion object {
        fun bar(s: String) {
            println("Companion Object Called : $s")
        }
    }
}

// AS-IS : 부생성자가 여러개 있는 클래스
class User1 {
    val nickname: String

    // 부생성자
    constructor(email: String) {
        nickname = email.substringBefore("@")
    }

    // 부생성자
    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }

}

// TO-BE: 부생성자를 팩토리 메서드로 개선
class User2 private constructor(val nickName: String) { // 주생성자를 private으로
    companion object {
        fun newSubscribingUser(email: String) = User2(email.substringBefore("@"))
        fun newFacebookUser(accountId: Int) = User2(getFacebookName(accountId))
    }
}


fun main() {
    A.bar("test")
    // 동반 객체는 바깥쪽 클래스의 private 생성자도 호출 가능 -> 팩토리 패턴을 구현하기 적합

    val newSubscribingUser = User2.newSubscribingUser("bob@gmail.com")
    val newFacebookUser = User2.newFacebookUser(4)
    println(newSubscribingUser.nickName)
    println(newFacebookUser.nickName)
}