@file:Suppress("UNUSED_EXPRESSION")

package com.example.studyKotlin

import com.example.studyKotlin.Color.*
import com.example.studyKotlin.domain.Person
import com.example.studyKotlin.domain.Rectangle
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.BufferedReader
import java.io.StringReader
import java.util.TreeMap

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

    println(Color.BLUE.rgb())
    println(Color.GREEN)
    println(getMnemonic(Color.BLUE))
    println(getWarmth(BLUE))

    println(mix(RED, YELLOW))
    println(mix(YELLOW, RED))
//    println(mix(BLUE, GREEN))

    println(mixOptimized(RED, YELLOW))
    println(mixOptimized(YELLOW, RED))
//    println(mixOptimized(BLUE, GREEN))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalOptimized(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

    for (i in 1..100) print(fizzBuzz(i))
    println()

    // 끝 값 미포함 하려면 until
    for (i in 1 until 100) print(fizzBuzz(i))
    println()

    // 역방향 100 -> 1으로 2씩 증가(역방향이니 -2)
    for (i in 100 downTo 1 step 2) print(fizzBuzz(i))

    mapIterator()
    collectionIterator()

    println(isLetter('A'))
    println(isNotDigit('A'))
    println(isNotDigit('1'))
    println(recognize('1'))
    println(recognize('A'))
    println(recognize('@'))

    println(readNum(BufferedReader(StringReader("234"))))
    println(readNum(BufferedReader(StringReader("abc"))))
    readNum2(BufferedReader(StringReader("abc")))

    collectionFunction()
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

// Java Switch
// break (X)
fun getMnemonic(c: Color) =
    when (c) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(c: Color) =
    when (c) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "natural"
        BLUE, INDIGO, VIOLET -> "cold"
    }

// set 표준 라이브러리 -> 순서 X
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty Color")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr


fun eval(e: Expr): Int {
    // java에서 instanceOf 같은 타입 검사
    if (e is Num) {
        // as Num으로 타입 캐스팅이 자동으로 된다.(is로 검사했으니까 컴파일러가 자동으로 스마트 캐스팅함)
        // 변수는 반드시 val(immutable), 커스텀 접근자 (X)
        val n = e as Num
        return n.value
    }
    if (e is Sum) return eval(e.right) + eval(e.left)
    throw IllegalArgumentException("Unknown expression")
}

fun evalOptimized(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalOptimized(e.left) + evalOptimized(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }

        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            // 블록 마지막이 반환 값이 됨 -> scope 함수 let? 이랑 비슷하게 생각하면 될듯
            left + right
        }

        else -> throw IllegalArgumentException("Unknown expression")
    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}


fun mapIterator() {
    val binaryReps = TreeMap<Char, String>()
    for (i in 'A'..'F') {
        //deprecated toInt()
//        val binary = Integer.toBinaryString(i.toInt())
        val binary = Integer.toBinaryString(i.code)

        //java: binaryReps.put(i, binary)
        binaryReps[i] = binary
    }

    // Map.key -> letter
    // Map.value -> binary
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}

fun collectionIterator() {
    val list = arrayListOf("10", "11", "1001", "11")
    for ((idx, element) in list.withIndex()) {
        println("$idx: $element")
    }

    // document 보다가 궁금해서
    for (element in list.distinct()){
        println(element)
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "no"
}

fun readNum(r: BufferedReader) :Int? {
    try {
        val line = r.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        r.close()
    }
}

fun readNum2(r: BufferedReader) {
    // try 값을 변수에 대입 가능
    val num = try {
        Integer.parseInt(r.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(num)
}

fun collectionFunction() {
    val set = hashSetOf(1, 5, 53)
    val list = listOf(1, 5, 53)
    val map = mapOf(
        // to 는 map 키워드가 아님 -> 일반 함수임 레퍼런스 확인해보기
        1 to "one",
        5 to "five",
        53 to "fifty-three"
    )
    // java에서 getClass()
    // 같은 java.util 클래스를 사용하므로 상호작용이 더 쉬움, 변환 필요 x
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(set)
    println(list)
    println(map)

    // 그러나 코틀린에서는 컬렉션의 더 많은 기능 제공
    println(list.last())
    println(set.min())
}
