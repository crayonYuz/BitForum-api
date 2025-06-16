package com.bit.bitforum.search.controller

import com.bit.bitforum.search.dto.SearchPostResponse
import com.bit.bitforum.search.service.SearchPostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class SearchController(
    private val postService: SearchPostService
) {
    @GetMapping("/search")
    fun search(
        @RequestParam("q") q: String,
        @RequestParam("board", defaultValue = "all") board: String
    ): List<SearchPostResponse> {
        return postService.searchPosts(q, board)
    }
}