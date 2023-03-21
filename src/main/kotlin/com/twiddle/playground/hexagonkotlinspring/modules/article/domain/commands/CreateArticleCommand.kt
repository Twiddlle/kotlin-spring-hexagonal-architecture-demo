package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.commands

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity

data class CreateArticleCommand(
    val article: ArticleEntity,
)
