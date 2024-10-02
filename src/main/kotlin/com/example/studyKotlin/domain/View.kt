package com.example.studyKotlin.domain

// 코틀린은 기본적으로 final 이므로 open 키워드를 붙혀야 상속이 가능하여 오버라이딩도 가능
open class View {
    open fun click() = println("View Clicked")
}

class Button: View() {
    override fun click() = println("Button Clicked")
}