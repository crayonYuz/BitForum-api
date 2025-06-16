package com.bit.bitforum.search.repository

import com.bit.bitforum.community.entity.Category
import com.bit.bitforum.community.entity.Post
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class CustomPostRepositoryImpl : CustomPostRepository {

    @PersistenceContext
    private lateinit var em: EntityManager

    override fun searchByKeywordAndCategories(q: String, categories: List<Category>): List<Post> {
        if (q.isBlank()) return emptyList()

        val query = StringBuilder("SELECT p FROM Post p WHERE (p.title LIKE :q OR p.content LIKE :q)")
        if (categories.isNotEmpty()) {
            query.append(" AND p.category IN :categories")
        }

        val jpql = em.createQuery(query.toString(), Post::class.java)
        jpql.setParameter("q", "%$q%")
        if (categories.isNotEmpty()) {
            jpql.setParameter("categories", categories)
        }

        return jpql.resultList
    }
}