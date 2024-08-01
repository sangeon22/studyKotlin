package com.example.studyKotlin.domain.member

import com.example.studyKotlin.domain.AuditingEntity
import jakarta.persistence.*

@Entity
@Table(name = "Member")
class Member(
        email: String,
        password: String,
        role: Role
) : AuditingEntity() {
    @Column(name = "email", nullable = false)
    var email: String = email
        protected set

    @Column(name = "password")
    var password: String = password
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = role
        protected set
}

enum class Role {
    USER, ADMIN
}