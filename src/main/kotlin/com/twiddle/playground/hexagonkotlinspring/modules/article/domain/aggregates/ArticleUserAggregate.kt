package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.aggregates

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleUserEntity

data class ArticleUserAggregate(
    val article: ArticleEntity,
    val user: ArticleUserEntity,
)
