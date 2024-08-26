package com.example.studyKotlin.domain

class Person(
    // val, var 차이에 맞게 val -> getter(), var -> getter(), setter()
    val name: String,
    var isMarried: Boolean
)