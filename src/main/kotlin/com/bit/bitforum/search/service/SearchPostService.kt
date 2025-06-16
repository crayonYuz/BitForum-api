package com.bit.bitforum.search.service

import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.search.repository.SearchPostRepository

import com.bit.bitforum.search.dto.SearchPostResponse
import org.springframework.stereotype.Service

@Service
class SearchPostService(
    private val searchPostRepository: SearchPostRepository
) {
    fun searchPosts(q: String, board: String): List<SearchPostResponse> {
        val categories = when (board) {
            "all", "community" -> listOf(
                Category.free,
                Category.coin_info,
                Category.exchange_info,
                Category.beginner_guide,
                Category.notice
            )
            else -> emptyList()
        }

        val posts = searchPostRepository.searchByKeywordAndCategories(q, categories)
        return posts.map { SearchPostResponse.from(it) }
    }
}