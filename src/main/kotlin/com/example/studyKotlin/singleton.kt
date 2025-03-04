package com.example.studyKotlin

//import com.example.studyKotlin.domain.Person
import java.io.File

// singleton
//object Payroll {
//    val allEmployees = arrayOf<Person>()
//    fun calculateSalary() {
//        for (person in allEmployees) {
//            TODO()
//        }
//    }
//}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
    // ignoreCase 눌러서 레퍼런스 보면,
    // 사전 차이를 무시하는 두 개의 문자열을 사전 어휘를 비교합니다.
    // ignoreCase 가 된 경우, Char.uppercaseChar().lowercaseChar() 의 결과는 각 문자에 비교됩니다.
}

data class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(person1: Person, person2: Person): Int = person1.name.compareTo(person2.name)
    }
}

fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user1")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    // sortedWith가 레퍼런스를 보면, Comparator를 파라미터로 받는데 CaseInsensitiveFileComparator가 Comparator를 상속받은 싱글턴 객체이므로 가능

    // 중첩 객체 사용하여 Comparator 구현
    val persons = listOf(Person("eoni"), Person("sangeon"))
    println(persons.sortedWith(Person.NameComparator))
}