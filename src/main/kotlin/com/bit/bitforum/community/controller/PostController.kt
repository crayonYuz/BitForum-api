package com.bit.bitforum.community.controller

import com.bit.bitforum.community.dto.community.PostDto
import com.bit.bitforum.community.service.PostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {

    @PostMapping
    fun createPost(@RequestBody dto: PostDto): ResponseEntity<PostDto> {
        return ResponseEntity.ok(postService.createPost(dto))
    }

    @GetMapping
    fun getAllPosts(): ResponseEntity<List<PostDto>> {
        return ResponseEntity.ok(postService.getAllPosts())
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<PostDto> {
        return ResponseEntity.ok(postService.getPostById(id))
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody dto: PostDto): ResponseEntity<PostDto> {
        return ResponseEntity.ok(postService.updatePost(id, dto))
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> {
        postService.deletePost(id)
        return ResponseEntity.noContent().build()
    }
}