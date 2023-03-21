package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports.ArticleRepository
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entities.ArticleDbEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entities.fromDomain
import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entities.toDomain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface DbArticleRepositoryInterface : JpaRepository<ArticleDbEntity, Int>

@Component
class ArticleRepositoryImpl :
    ArticleRepository {

    @Autowired
    lateinit var articleRepository: DbArticleRepositoryInterface

    override fun findByIdOrNull(id: Int) =
        articleRepository.findByIdOrNull(id).takeIf { it != null }?.toDomain()

    override fun create(article: ArticleEntity) = articleRepository.save(fromDomain(article)).toDomain()
}
