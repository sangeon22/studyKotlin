@file:JvmName("StringFunctions")

package strings

fun <T> joinToStringKotlin2(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((idx, em) in collection.withIndex()) {
        if (idx > 0) result.append(separator)
        result.append(em)
    }
    result.append(postfix)
    return result.toString()
}


// 확장함수
// String Class를 선언함 -> 수신 객체 타입
// this -> 수신 객체
fun String.lastChar(): Char = this[this.length - 1]

// this(수신 객체) 없이도 접근 가능
fun String.lastChar2(): Char = get(length - 1)

// 확장 함수로 인해 클래스의 캡슐화가 깨지진 않는다 -> private, protected 멤버를 사용할 수 없음

fun <T> Collection<T>.joinToStringKotlin(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((idx, em) in this.withIndex()) {
        if (idx > 0) result.append(separator)
        result.append(em)
    }
    result.append(postfix)
    return result.toString()
}