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
}

data class Person(
    val name: String,
    val age: Int? = null
)