package com.bit.bitforum.comments.service

import com.bit.bitforum.comments.dto.CommentDto
import com.bit.bitforum.comments.entity.Comment
import com.bit.bitforum.comments.repository.CommentRepository
import com.bit.bitforum.community.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository
) {
    @Transactional
    fun createComment(dto: CommentDto): CommentDto {
        val post = postRepository.findById(dto.postId)
            .orElseThrow { NoSuchElementException("Post not found") }

        val comment = Comment(
            content = dto.content,
            author = dto.author,
            post = post
        )
        return commentRepository.save(comment).let {
            CommentDto(it.id, it.content, it.author, it.post.id, it.createdAt)
        }
    }

    @Transactional
    fun deleteComment(commentId: Long) {
        if (!commentRepository.existsById(commentId)) {
            throw NoSuchElementException("Comment not found")
        }
        commentRepository.deleteById(commentId)
    }

    fun getCommentsByPost(postId: Long): List<CommentDto> {
        return commentRepository.findByPostId(postId).map {
            CommentDto(it.id, it.content, it.author, postId, it.createdAt)
        }
    }
}