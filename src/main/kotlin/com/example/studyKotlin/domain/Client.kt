package com.example.studyKotlin.domain

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean { // Any -> Java에서 Object
        if (other == null || other !is Client) // is -> Java에서 instanceOf
            return false
        return name == other.name && postalCode == other.postalCode // 두 객체의 프로퍼티가 모두 동일한지 검사
    }

    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

fun main() {
    val client1 = Client("eoni", 3573)
    val client2 = Client("eoni", 3573)
    println(client1)
    println(client2)
//    println(client1 == client2) // 코틀린은 ==는 참조 동일성을 검사하지 않고 객체의 동등성을 검사 equals() 호출
//    println(client1 === client2)

    println(client1 == client2) // override해서 true 나옴

    val processed = hashSetOf(Client("eoni", 3573))
    println(processed.contains(Client("eoni",3573))) // true가 아닌 false 나옴
    // equals() 메소드를 오버라이드하는 경우, hashCode()도 꼭 함께 오버라이드 해야한다.
    // equals()에서 true를 반환하는 두 객체가 같은 hasCode()를 반환해야하기 때문
    println(processed.contains(Client("eoni",3573))) // hashCode() 오버라이드하니 true나옴
}