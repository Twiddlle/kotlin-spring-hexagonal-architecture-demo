package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import java.time.LocalDateTime

data class CreateArticleDto(
    val title: String,
    val body: String,
    val userId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

fun CreateArticleDto.toDomain() = ArticleEntity(
    title = title,
    body = body,
    userId = userId,
    createdAt = createdAt,
    updatedAt = updatedAt,
)
