@file:Suppress("UNUSED_EXPRESSION")

package com.example.studyKotlin

import com.example.studyKotlin.domain.Person
import com.example.studyKotlin.domain.Rectangle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableJpaAuditing
class StudyKotlinApplication

fun main(args: Array<String>) {
    val persons = listOf(Person1("상언"), Person1("철수", age = 28))
    val age = persons.maxBy { it.age ?: 0 }
    println("age: $age")

    println(max1(1, 2))
    println(max2(1, 2))
    println(max3(1, 2))

    println("valMessage: ${valAndVar("S")}")
    println("valMessage: ${valAndVar("F")}")

    println(valRef())

    stringTem(arrayOf("eoni"))
    stringTem(arrayOf())

    // java: Person person = new Person("eoni", false);
    // System.out.println(peron.getName());
    // person.setMarried(true);
    val person = Person("eoni", false)
    println(person.name)
    println(person.isMarried)
    person.isMarried = true
    println(person.isMarried)

    val rectangle = Rectangle(10, 10)
    println("isSquare: ${rectangle.isSquare}")

}

data class Person1(
    val name: String,
    val age: Int? = null
)

fun max1(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b

// 정적 타입 지정 언어인 코틀린 -> 컴파일 시점에 반환 타입을 지정해야하지만 식이 본문인 경우, 컴파일러가 본문을 해석하여 식의 결과 타입을 지정 -> 타입 추론
fun max3(a: Int, b: Int) = if (a > b) a else b

fun valAndVar(flag: String): String {
    // val(value) -> immutable(자바의 final)
    // var(variable) -> mutable

    // val는 한번만 초기화 가능함 블록에 따라 컴파일러가 한번만 초기화
    val message1: String
    var message2: String = "default"
    println("varMessage $message2")

    if (canPerformOperation(flag)) {
        message1 = "Success"
        message2 = "Success"
        println("varMessage = $message2")
    } else {
        message1 = "Failed"
        message2 = "Failed"
        println("varMessage = $message2")
    }
    return message1
}

fun canPerformOperation(flag: String): Boolean {
    return if (flag == "S") true else false
}

fun valRef(): Unit {
    // val이지만 참조가 가리키는 객체 내부는 변경 가능
    val lang = arrayListOf("Java")
    lang.add("Kotlin")
    println("$lang")
}

fun varRef() {
    var answer = 10
//    answer = "TEST"
    //Type mismatch: inferred type is String but Int was expected
}

fun stringTem(args: Array<String>) {
    var name = ""
    if (args.isNotEmpty()) {
        name = args[0]
        println("args[0]: ${args[0]}")
    } else {
        name = "Kotlin"
    }
    println("\${name}, $name!")
    println("\${if}:, ${if (args.isNotEmpty()) args[0] else "Kotlin"}")
}