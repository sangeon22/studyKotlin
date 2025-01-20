package com.example.studyKotlin.domain

import org.springframework.asm.Attribute
import javax.naming.Context

// 코틀린은 기본적으로 final 이므로 open 키워드를 붙혀야 상속이 가능하여 오버라이딩도 가능
open class View {
    open fun click() = println("View Clicked")

    // 부생성자
    constructor(ctx: Context) {

    }

    // 부생성자
    constructor(ctx: Context, attr: Attribute) {

    }

}

//class Button: View {
//    override fun click() = println("Button Clicked")
//}

class MyButton : View {

    // 상위 클래스의 생성자 호출
    constructor(ctx: Context)
            : super(ctx) {

    }

    constructor(ctx: Context, attr: Attribute)
            : super(ctx, attr) {
    }

}