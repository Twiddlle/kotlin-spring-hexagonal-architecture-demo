package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleUserEntity

interface ArticleUserRepository {

    fun findByIdOrNull(id: Int): ArticleUserEntity?
}
