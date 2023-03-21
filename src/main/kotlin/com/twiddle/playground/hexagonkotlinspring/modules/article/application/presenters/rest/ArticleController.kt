package com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest

import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.ArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.CreateArticleDto
import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.fromDomain
import com.twiddle.playground.hexagonkotlinspring.modules.article.application.presenters.rest.dto.toDomain
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.services.ArticleService
import org.springframework.beans.factory.annotation.Autowired
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
    lateinit var articleService: ArticleService

    @GetMapping("{id}")
    fun findOne(
        @PathVariable id: Int,
    ): ArticleDto {
        return fromDomain(articleService.findById(id))
    }

    @PostMapping("")
    fun createOne(): ArticleDto {
        return articleService.create(
            CreateArticleDto(
                title = "test",
                body = "test",
                userId = 1,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            ).toDomain(),
        ).let { fromDomain(it) }
    }
}
