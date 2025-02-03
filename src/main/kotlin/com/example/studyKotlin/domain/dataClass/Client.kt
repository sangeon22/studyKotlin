package com.example.studyKotlin.domain.dataClass

// data class는 컴파일러가 자동으로 equals(), hashCode(), toString() 등 메서드를 자동으로 만들어준다.
// var 프로퍼티로 선언이 가능하나 읽기 전용으로 val 프로퍼티로 선언하여 불변 클래스로 만들라고 권장되긴 함
data class Client(val name: String, val postalCode: Int)

fun main() {
    // 코틀린 컴파일러는 데이터 클래스 인스턴스를 불변 객체로 지정하고 활용할 수 있는 copy() 메서드 제공
    // 다른 생명 주기를 가지므로 원본을 참조하는 부분에 영향 X
    val lee = Client("eoni", 3573)
    println(lee.copy(postalCode = 1000))
}
