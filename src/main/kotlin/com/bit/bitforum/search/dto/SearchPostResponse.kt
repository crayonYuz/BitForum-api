package com.bit.bitforum.search.dto

import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.community.entity.Post

data class SearchPostResponse(
    val id: Long,
    val title: String,
    val category: Category
) {
    companion object {
        fun from(post: Post): SearchPostResponse {
            return SearchPostResponse(
                id = post.id,
                title = post.title,
                category = post.category
            )
        }
    }
}