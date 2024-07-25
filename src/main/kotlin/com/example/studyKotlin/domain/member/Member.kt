package com.example.studyKotlin.domain.member

import jakarta.persistence.*

@Entity
@Table(name = "Member")
class Member(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,

        @Column(name = "title", nullable = false)
        var email: String,

        @Column(name = "content")
        var password: String,

        @Enumerated(EnumType.STRING)
        var role: Role

) {

}

enum class Role {
    USER, ADMIN
}