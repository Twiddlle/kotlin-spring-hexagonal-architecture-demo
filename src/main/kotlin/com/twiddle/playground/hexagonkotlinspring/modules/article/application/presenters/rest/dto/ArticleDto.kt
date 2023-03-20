package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto

import java.time.LocalDateTime

data class ArticleDto(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)