package com.example.studyKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class StudyKotlinApplication

fun main(args: Array<String>) {
	runApplication<StudyKotlinApplication>(*args)
	println("test")
}
