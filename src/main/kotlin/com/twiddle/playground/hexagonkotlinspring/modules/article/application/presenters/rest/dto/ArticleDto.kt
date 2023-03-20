package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import java.time.LocalDateTime

data class ArticleDto(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

fun ArticleDto.toDomain() = ArticleEntity(
    title = title,
    body = body,
    userId = userId,
    createdAt = createdAt,
    updatedAt = updatedAt,
)

fun fromDomain(articleEntity: ArticleEntity) = ArticleDto(
    id = articleEntity.id!!,
    title = articleEntity.title,
    body = articleEntity.body,
    userId = articleEntity.userId,
    createdAt = articleEntity.createdAt,
    updatedAt = articleEntity.updatedAt,
)
