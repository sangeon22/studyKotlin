package com.example.studyKotlin

//enum class Color {
//    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
//}

enum class Color(
    // 상수 프로퍼티 정의
    val r: Int,
    val g: Int,
    val b: Int
) {
    // 각 상수 생성 시, 그에 대한 프로퍼티 값 지정
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // 세미콜론 필수

    fun rgb() = (r * 256 + g) * 256 + b
}