package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entities

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
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

fun ArticleDbEntity.toDomain() = ArticleEntity(
    id = id,
    title = title,
    body = body,
    userId = userId,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun fromDomain(articleEntity: ArticleEntity) = ArticleDbEntity(
    id = articleEntity.id,
    title = articleEntity.title,
    body = articleEntity.body,
    userId = articleEntity.userId,
    createdAt = articleEntity.createdAt,
    updatedAt = articleEntity.updatedAt,
)
