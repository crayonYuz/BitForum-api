package com.bit.bitforum.search.repository

import com.bit.bitforum.community.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface SearchPostRepository : JpaRepository<Post, Long>, CustomPostRepository