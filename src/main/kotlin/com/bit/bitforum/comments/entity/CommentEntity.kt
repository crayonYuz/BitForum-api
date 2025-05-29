package com.bit.bitforum.comments.entity

import com.bit.bitforum.community.entity.Post
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var content: String,

    @Column(nullable = false)
    var author: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    var post: Post,

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
)