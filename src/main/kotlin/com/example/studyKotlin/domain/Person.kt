package com.example.studyKotlin.domain

import com.fasterxml.jackson.core.JsonFactory
import com.google.gson.Gson

interface JSONFactory<T> {
    fun fromJSON(jsonText: String) : T
}
class Person(
    // val, var 차이에 맞게 val -> getter(), var -> getter(), setter()
    val name: String,
    var isMarried: Boolean
) {
//    // 동반객체에 Loader라는 이름을 붙혀서 일반객체처럼 사용
//    companion object : JSONFactory<Person> {
//        // 동반 객체가 인터페이스 구현 가능
//        override fun fromJSON(jsonText: String) : Person = Gson().fromJson(jsonText, Person::class.java)
//     }
    // 왜 클래스 안에 메서드로 안할까? -> static 처럼 불필요한 객체 생성이 없어짐
    // 그럼 전역 메서드로 하면되지 않나? -> Person과 관계성?이 낮아지기 때문에 companion obejct가 추천되는 듯
     // 그래서 Person에 관련된 기능은 companion object로 묶는 게 더 직관적이고 객체지향적

    companion object {

    }
}

// 동반객체에 대한 확장 함수 정의 - 마치 동반 객체 안에서 fromJSON 함수를 정의한 것처럼 호출 가능
// 보통 확장 함수처럼 클래스 멤버 함수 X
fun Person.Companion.fromJSON(jsonText: String): Person {
    return Gson().fromJson(jsonText, Person::class.java)
}

fun main() {
    val person1 = Person.fromJSON("{name: 'Dmitry'}")
    println(person1.name)

    val person2 = Person.fromJSON("{name: 'eoni'}")
    println(person2.name)

    // Dmitry
}