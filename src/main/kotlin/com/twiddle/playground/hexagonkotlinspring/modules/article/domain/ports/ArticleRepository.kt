package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entity.ArticleDbEntity

interface ArticleRepository {

    fun findByIdOrNull(id: Int): ArticleDbEntity?
    fun create(article: ArticleEntity): ArticleDbEntity
}
