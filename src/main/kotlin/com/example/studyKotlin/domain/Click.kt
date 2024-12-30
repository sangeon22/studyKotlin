package com.example.studyKotlin.domain

interface Clickable {
    fun click()

    // java > default method
    fun showOff() = println("I'm clickable")
}


interface Focusable {
    fun setFocus(bool: Boolean) = println("I ${if (bool) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable")
}

// java > implements, extends 처럼 상속, 구현
class ClickButton :Clickable, Focusable{

    // java > @Override
    override fun click() = println("I was clicked")

//    두 인터페이스에서 이름이 같은 디폴트 메서드를 함께 구현하면 컴파일 에러 발생
//    override fun showOff() {
//        println("test")
//    }
//
//    override fun showOff() {
//      println("test")
//    }

    // 위 같은 케이스를 방지하려면 하위클래스에서 명시적으로 재구현해야함
    override fun showOff() {
        // java > Clickable.super.showOff()
        super<Clickable>.showOff()
        super<Focusable>.showOff()

    }

//     상속한 구현 중 하나만 호출해도 되면 아래처럼 가능
//    override fun showOff() = super<Clickable>.showOff()
}

// 코틀린에서 클래스와 메서드는 final default
// open 키워드로 상속 가능을 명시
open class RichButton : Clickable {

    // final method
    fun disable() {}

    // final method x
    open fun animate() {}

    // override method는 기본적으로 open 상태이므로 final을 선언하여 하위 클래스에서 오버라이드 금지
    final override fun click() {}
}

// 추상 클래스는 인스턴스화 X -> 하위 클래스에서 추상 메서드를 오버라이드 해야 한다 그러므로 open이 default
abstract class Animated {
    abstract fun animate()

    // 비추상 메서드도 open 가능
    open fun stopAnimating() {}

    fun animateTwice() {}
}