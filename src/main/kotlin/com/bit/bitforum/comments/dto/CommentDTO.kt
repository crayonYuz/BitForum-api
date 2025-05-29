package com.bit.bitforum.comments.dto

import java.time.LocalDateTime

data class CommentDto(
    val id: Long? = null,
    val content: String,
    val author: String,
    val postId: Long,
    val createdAt: LocalDateTime? = null
)