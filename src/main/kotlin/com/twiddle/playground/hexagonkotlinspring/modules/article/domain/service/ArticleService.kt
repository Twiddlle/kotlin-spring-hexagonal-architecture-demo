package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.service

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.ArticleRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService {

    @Autowired
    lateinit var articleRepo: ArticleRepositoryImpl

    fun findById(id: Int): ArticleEntity {
        val article = articleRepo.findByIdOrNull(id) ?: throw RuntimeException("Article with id $id not found")
        return ArticleEntity(
            id = article.id!!,
            title = article.title,
            body = article.body,
            userId = article.userId,
            createdAt = article.createdAt,
            updatedAt = article.updatedAt,
        )
    }

    fun create(article: ArticleEntity): ArticleEntity {
        return articleRepo.create(article)
    }
}
