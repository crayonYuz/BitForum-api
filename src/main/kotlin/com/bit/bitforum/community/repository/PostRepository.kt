package com.bit.bitforum.community.repository

import com.bit.bitforum.community.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long>