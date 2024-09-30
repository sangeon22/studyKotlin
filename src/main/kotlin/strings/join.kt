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