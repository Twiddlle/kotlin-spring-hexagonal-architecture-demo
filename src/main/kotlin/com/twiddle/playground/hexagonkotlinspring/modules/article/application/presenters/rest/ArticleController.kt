package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest

import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.ArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.DbArticleRepository
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entity.ArticleDbEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController()
@RequestMapping("article")
class ArticleController {

    @Autowired
    lateinit var articleRepo: DbArticleRepository

    @GetMapping("{id}")
    fun findOne(
        @PathVariable id: Int,
    ): ArticleDto {
        val article = articleRepo.findByIdOrNull(id) ?: throw RuntimeException("Article with id $id not found")
        return ArticleDto(
            id = article.id!!,
            title = article.title,
            body = article.body,
            userId = article.userId,
            createdAt = article.createdAt,
            updatedAt = article.updatedAt,
        )
    }

    @PostMapping("")
    fun createOne(): ArticleDbEntity {
        val article = articleRepo.create(
            ArticleEntity(
                id = 1,
                title = "test",
                body = "test",
                userId = 1,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            ),
        )

        return article
    }
}