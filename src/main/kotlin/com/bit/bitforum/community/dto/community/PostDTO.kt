package com.bit.bitforum.community.dto

import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.community.entity.Post
import java.time.LocalDateTime

data class PostDto(
    val id: Long? = null,
    val title: String,
    val content: String,
    val category: String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val author: String? = null
) {
    companion object {
        fun from(post: Post): PostDto = PostDto(
            id = post.id,
            title = post.title,
            content = post.content,
            category = post.category.value,
            createdAt = post.createdAt,
            updatedAt = post.updatedAt
        )
    }
}