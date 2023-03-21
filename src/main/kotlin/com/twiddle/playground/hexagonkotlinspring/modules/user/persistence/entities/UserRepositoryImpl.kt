package com.twiddle.playground.hexagonkotlinspring.modules.user.persistence.entities

import com.twiddle.playground.hexagonkotlinspring.modules.article.infrastructure.persistence.entities.toDomain
import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.entities.UserEntity
import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.ports.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface DbUserRepositoryInterface : JpaRepository<UserDbEntity, Int>

@Component
class UserRepositoryImpl(
    @Autowired private val userRepository: DbUserRepositoryInterface,
) : UserRepository {
    override fun findByIdOrNull(id: Int): UserEntity? {
        return userRepository.findByIdOrNull(id).takeIf { it != null }?.toDomain()
    }
}
