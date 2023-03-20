package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "Articles")
data class ArticleDbEntity(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val title: String,
    val body: String,
    val userId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
