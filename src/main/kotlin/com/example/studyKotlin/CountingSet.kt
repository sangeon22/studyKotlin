package com.example.studyKotlin

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    // MutableCollection 구현을 innerSet에게 위임
    var objectsAdded = 0

    // 아래 두 메서드는 위임 X
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main() {
    val cSet = CountingSet<Int>()
    cSet.addAll(listOf(1,2,3))
    println("${cSet.objectsAdded} objects were added, ${cSet.size} remain")
}