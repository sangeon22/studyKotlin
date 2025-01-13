package com.example.studyKotlin.domain

// 클래스 뒤 중괄호가 주생성자로 파라미터로 프로퍼티 초기화를 수행 (아래 주석 참고 - 명시적으로 표현)
// default 명시 가능
class User(val nickname: String, val isSubscribed: Boolean = true)

/*
class User constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}
*/

/*
class User(nickname: String) {
    val nickname:String
    init {
        this.nickname = nickname
    }
}
 */

/*
class User(_nickname: String) {
    val nickname = _nickname
}
*/

open class BaseUser(val nickname: String) {}
// BaseUser를 상속받아서 기반클래스에 생성자 인자를 넘기는 역할이므로 val, var 필요 X
class TUser(nickname: String): BaseUser(nickname) {}

// 생성자 인자가 없는 클래스
open class BaseButton
// 생성자 인자가 없는 기반클래스이지만 상속한 하위 클래스는 기반클래스의 생성자 호출해야함 ()가 들어가야함
// 인터페이스는 생성자가 없으니 () 필요 없음
class RedButton: BaseButton()

// 클래스 외부에서 인스턴스화를 못하게 막으려면 모든 생성자를 private로 선언
class Secretive private constructor() {}
fun main() {
    val user1 = User("eoni")
    println(user1.isSubscribed)
}

