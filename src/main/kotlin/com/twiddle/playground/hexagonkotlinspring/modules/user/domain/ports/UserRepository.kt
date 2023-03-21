package com.twiddle.playground.hexagonkotlinspring.modules.user.domain.ports

import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.entities.UserEntity

interface UserRepository {
    fun findByIdOrNull(id: Int): UserEntity?
}
