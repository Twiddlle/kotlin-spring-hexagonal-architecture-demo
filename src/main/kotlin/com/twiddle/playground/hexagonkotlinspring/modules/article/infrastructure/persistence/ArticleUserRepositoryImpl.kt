package com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.entities.ArticleUserEntity
import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.ports.ArticleUserRepository
import com.twiddle.playground.hexagonkotlinspring.modules.user.persistence.entities.UserRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ArticleUserRepositoryImpl(
    @Autowired private val userRepositoryImpl: UserRepositoryImpl,
) :
    ArticleUserRepository {

    override fun findByIdOrNull(id: Int) =
        userRepositoryImpl.findByIdOrNull(id).takeIf { it != null }?.let {
            ArticleUserEntity(
                id = it.id,
                name = it.name,
            )
        }
}
