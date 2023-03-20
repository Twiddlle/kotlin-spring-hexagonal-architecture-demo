package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities

import java.time.LocalDateTime

data class ArticleEntity(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
