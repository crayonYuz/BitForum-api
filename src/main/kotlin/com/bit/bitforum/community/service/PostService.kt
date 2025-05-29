package com.bit.bitforum.community.service

import com.bit.bitforum.community.dto.community.PostDto
import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.community.entity.Post
import com.bit.bitforum.community.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository
) {
    @Transactional
    fun createPost(dto: PostDto): PostDto {
        val post = Post(
            title = dto.title,
            content = dto.content,
            category = Category.fromValue(dto.category),
            author = dto.author
        )
        return PostDto.from(postRepository.save(post))
    }

    fun getAllPosts(): List<PostDto> {
        return postRepository.findAll()
            .map { PostDto.from(it) }
    }

    fun getPostById(id: Long): PostDto {
        return postRepository.findById(id)
            .map { PostDto.from(it) }
            .orElseThrow { NoSuchElementException("Post not found") }
    }

    @Transactional
    fun updatePost(id: Long, dto: PostDto): PostDto {
        val post = postRepository.findById(id)
            .orElseThrow { NoSuchElementException("Post not found") }

        post.update(dto.title, dto.content, Category.fromValue(dto.category))
        return PostDto.from(post)
    }

    @Transactional
    fun deletePost(id: Long) {
        postRepository.deleteById(id)
    }
}