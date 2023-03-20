package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest

import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.ArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity

fun fromDomain(articleEntity: ArticleEntity) = ArticleDto(
    id = articleEntity.id,
    title = articleEntity.title,
    body = articleEntity.body,
    userId = articleEntity.userId,
    createdAt = articleEntity.createdAt,
    updatedAt = articleEntity.updatedAt,
)
