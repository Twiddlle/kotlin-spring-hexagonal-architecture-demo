package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.services

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.aggregates.ArticleUserAggregate
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports.ArticleRepository
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports.ArticleUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService(
    @Autowired private val articleRepo: ArticleRepository,
    @Autowired private val articleUserRepository: ArticleUserRepository,
) {

    fun findById(id: Int): ArticleUserAggregate {
        val article = articleRepo.findByIdOrNull(id) ?: error("Article with id $id not found")

        val user =
            articleUserRepository.findByIdOrNull(article.userId) ?: error("User with id ${article.userId} not found")

        return ArticleUserAggregate(
            article = article,
            user = user,
        )
    }

    fun create(article: ArticleEntity): ArticleEntity {
        return articleRepo.create(article)
    }
}
