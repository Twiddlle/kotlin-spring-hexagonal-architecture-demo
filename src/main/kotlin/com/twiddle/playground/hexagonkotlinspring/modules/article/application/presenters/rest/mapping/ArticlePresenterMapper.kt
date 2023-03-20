package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.mapping

import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.ArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.CreateArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity

fun fromDomain(articleEntity: ArticleEntity) = ArticleDto(
    id = articleEntity.id!!,
    title = articleEntity.title,
    body = articleEntity.body,
    userId = articleEntity.userId,
    createdAt = articleEntity.createdAt,
    updatedAt = articleEntity.updatedAt,
)

fun toDomain(articleDto: ArticleDto) = ArticleEntity(
    title = articleDto.title,
    body = articleDto.body,
    userId = articleDto.userId,
    createdAt = articleDto.createdAt,
    updatedAt = articleDto.updatedAt,
)

fun toDomain(articleDto: CreateArticleDto) = ArticleEntity(
    title = articleDto.title,
    body = articleDto.body,
    userId = articleDto.userId,
    createdAt = articleDto.createdAt,
    updatedAt = articleDto.updatedAt,
)
