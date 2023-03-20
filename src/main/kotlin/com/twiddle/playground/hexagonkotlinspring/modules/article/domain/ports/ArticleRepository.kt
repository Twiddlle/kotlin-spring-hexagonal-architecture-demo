package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity

interface ArticleRepository {

    fun findByIdOrNull(id: Int): ArticleEntity?
    fun create(article: ArticleEntity): ArticleEntity
}
