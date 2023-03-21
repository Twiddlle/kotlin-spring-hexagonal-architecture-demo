package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.aggregates.ArticleUserAggregate

data class ArticleUserDto(
    val article: ArticleDto,
    val user: UserDto,
) {
    data class UserDto(
        val name: String,
    )
}

fun fromDomain(articleUserAggregate: ArticleUserAggregate) = ArticleUserDto(
    article = fromDomain(
        articleUserAggregate.article,
    ),
    user = ArticleUserDto.UserDto(
        name = articleUserAggregate.user.name,
    ),
)
