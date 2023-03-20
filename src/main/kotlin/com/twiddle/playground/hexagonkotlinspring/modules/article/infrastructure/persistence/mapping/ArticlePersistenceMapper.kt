package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.mapping

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entity.ArticleDbEntity

fun toDomain(articleDbEntity: ArticleDbEntity) = ArticleEntity(
    id = articleDbEntity.id,
    title = articleDbEntity.title,
    body = articleDbEntity.body,
    userId = articleDbEntity.userId,
    createdAt = articleDbEntity.createdAt,
    updatedAt = articleDbEntity.updatedAt,
)

fun fromDomain(articleEntity: ArticleEntity) = ArticleDbEntity(
    id = articleEntity.id,
    title = articleEntity.title,
    body = articleEntity.body,
    userId = articleEntity.userId,
    createdAt = articleEntity.createdAt,
    updatedAt = articleEntity.updatedAt,
)
