package com.example.studyKotlin.domain.comment

import com.example.studyKotlin.domain.AuditingEntity
import com.example.studyKotlin.domain.member.Member
import com.example.studyKotlin.domain.post.Post
import jakarta.persistence.*

@Entity
@Table(name = "Comment")
class Comment(
        title: String
        , content: String
        , post: Post
) : AuditingEntity() {

    @Column(name = "content", nullable = false)
    var content: String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post: Post = post
        protected set
}