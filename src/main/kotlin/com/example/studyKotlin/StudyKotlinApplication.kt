package com.example.studyKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableJpaAuditing
class StudyKotlinApplication

fun main() {
    val persons = listOf(Person("상언"), Person("철수", age = 28))
    val age = persons.maxBy { it.age ?: 0 }
    println("age: $age")

    println(max1(1, 2))
    println(max2(1, 2))
    println(max3(1, 2))

}

data class Person(
    val name: String,
    val age: Int? = null
)

fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

// 정적 타입 지정 언어인 코틀린 -> 컴파일 시점에 반환 타입을 지정해야하지만 식이 본문인 경우, 컴파일러가 본문을 해석하여 식의 결과 타입을 지정 -> 타입 추론
fun max3(a: Int, b: Int) = if (a > b) a else b