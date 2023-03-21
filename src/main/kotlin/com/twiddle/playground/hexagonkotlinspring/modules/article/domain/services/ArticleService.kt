package com.twiddle.playground.hexagonkotlinspring.modules.article.domain.services

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.queries.GetUserByIdQuery
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.ArticleRepositoryImpl
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val queryGateway: QueryGateway,
) {

    @Autowired
    lateinit var articleRepo: ArticleRepositoryImpl

    fun findById(id: Int): ArticleEntity {
        val article = articleRepo.findByIdOrNull(id) ?: error("Article with id $id not found")

        val user = queryGateway.query(GetUserByIdQuery, ResponseTypes.instanceOf())

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
