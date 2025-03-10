package com.example.studyKotlin.domain

import com.google.gson.Gson

class Person(
    // val, var 차이에 맞게 val -> getter(), var -> getter(), setter()
    val name: String,
    var isMarried: Boolean
) {
    // 동반객체에 Loader라는 이름을 붙혀서 일반객체처럼 사용
    companion object Loader {
        fun fromJSON(jsonText: String) : Person = Gson().fromJson(jsonText, Person::class.java)
     }
    // 왜 클래스 안에 메서드로 안할까? -> static 처럼 불필요한 객체 생성이 없어짐
    // 그럼 전역 메서드로 하면되지 않나? -> Person과 관계성?이 낮아지기 때문에 companion obejct가 추천되는 듯
     // 그래서 Person에 관련된 기능은 companion object로 묶는 게 더 직관적이고 객체지향적
}

fun main() {
    val person1 = Person.Loader.fromJSON("{name: 'Dmitry'}")
    println(person1.name)

    val person2 = Person.fromJSON("{name: 'eoni'}")
    println(person2.name)

    // Dmitry
}