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
}

fun main() {
    val person1 = Person.Loader.fromJSON("{name: 'Dmitry'}")
    println(person1.name)

    val person2 = Person.fromJSON("{name: 'eoni'}")
    println(person2.name)

    // Dmitry
}