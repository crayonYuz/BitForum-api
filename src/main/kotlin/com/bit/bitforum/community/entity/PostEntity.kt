package com.bit.bitforum.community.entity

import com.bit.bitforum.community.dto.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "posts")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    var content: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    var category: Category,
) : BaseEntity() {
    fun update(title: String, content: String, category: Category) {
        this.title = title
        this.content = content
        this.category = category
    }
}

enum class Category(val value: String) {
    free("free"),
    coin_info("coin-info"),
    beginner_guide("beginner-guide");

    override fun toString(): String = value

    companion object {
        fun fromValue(value: String): Category =
            entries.find { it.value == value }
                ?: throw IllegalArgumentException("Unknown category: $value")
    }
}