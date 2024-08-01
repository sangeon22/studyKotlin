package com.example.studyKotlin.domain.post

import com.example.studyKotlin.domain.AuditingEntity
import jakarta.persistence.*
import org.apache.tomcat.util.codec.binary.StringUtils


@Entity
@Table(name = "Post")
class Post(
        title: String,
        content: String
) : AuditingEntity() {

    @Column(name = "title", nullable = false)
    var title: String = title
        protected set

    @Column(name = "content")
    var content: String = content
        protected set
}