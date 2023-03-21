package com.twiddle.playground.hexagonkotlinspring.modules.article.application.queryhandlers

import com.twiddle.playground.hexagonkotlinspring.modules.article.domain.queries.GetUserByIdQuery
import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.entities.UserEntity
import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.ports.UserRepository
import org.springframework.stereotype.Component

@Component
class GetUserByIdQueryHandler() {

    lateinit var userRepository: UserRepository

    fun handle(query: GetUserByIdQuery): UserEntity {
        return userRepository.findByIdOrNull(query.userId) ?: error("User with id ${query.userId} not found")
    }
}
