package com.example.studyKotlin.domain

class Rectangle(
    val height: Int,
    val width: Int
) {

    // isSquare 프로퍼티에는 자체 값을 저장하는 필드가 필요 없음 -> 자체 구현을 통한 게터로 프로퍼티 값을 계산해 제공 (커스텀 접근자)
    val isSquare: Boolean
        get() {
            return height == width
        }
}