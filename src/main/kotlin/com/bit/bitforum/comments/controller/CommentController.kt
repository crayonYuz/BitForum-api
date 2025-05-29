package com.bit.bitforum.comments.controller

import com.bit.bitforum.comments.dto.CommentDto
import com.bit.bitforum.comments.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/comments")
class CommentController(
    private val commentService: CommentService
) {
    @PostMapping
    fun createComment(@RequestBody dto: CommentDto): ResponseEntity<CommentDto> {
        return ResponseEntity.ok(commentService.createComment(dto))
    }

    @GetMapping("/posts/{postId}")
    fun getCommentsByPost(@PathVariable postId: Long): ResponseEntity<List<CommentDto>> {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId))
    }

    @DeleteMapping("/{id}")
    fun deleteComment(@PathVariable id: Long): ResponseEntity<Void> {
        commentService.deleteComment(id)
        return ResponseEntity.noContent().build()
    }
}