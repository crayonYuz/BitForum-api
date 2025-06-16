package com.bit.bitforum.search.repository

import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.community.entity.Post

interface CustomPostRepository {
    fun searchByKeywordAndCategories(keyword: String, categories: List<Category>): List<Post>
}