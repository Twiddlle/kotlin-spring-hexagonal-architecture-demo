package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports.ArticleRepository
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entity.ArticleDbEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface DbArticleRepositoryInterface : JpaRepository<ArticleDbEntity, Int>

@Component
class DbArticleRepository : ArticleRepository {

    @Autowired
    lateinit var articleRepository: DbArticleRepositoryInterface

    override fun findByIdOrNull(id: Int) = articleRepository.findByIdOrNull(id)

    override fun create(article: ArticleEntity) = articleRepository.save(
        ArticleDbEntity(
            title = article.title,
            body = article.body,
            userId = article.userId,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        ),
    )
}
