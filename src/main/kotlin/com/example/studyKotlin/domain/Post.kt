package com.example.studyKotlin.domain

import jakarta.persistence.*
import org.apache.tomcat.util.codec.binary.StringUtils


@Entity
@Table(name = "Post")
class Post(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(name = "title", nullable = false)
        var title: String,

        @Column(name = "content")
        var content: String


) {

}