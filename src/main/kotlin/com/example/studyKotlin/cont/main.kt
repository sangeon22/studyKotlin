package com.example.studyKotlin.cont

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

const val MAIN_URL = "/main"

@RestController
class main{
    @GetMapping(MAIN_URL)
    fun main(): String {
        return "test"
    }
}