package com.example.studyKotlin

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState() : State

    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonStatus()
    override fun restoreState(state: State) {

    }
    // default java static 중첩 클래스
    // 바깥 클레스에 대한 참조를 포함하게 하고 싶다면 inner 선언
    inner class ButtonStatus : State {
        fun getOuterReference() : Button = this@Button
    }

}
