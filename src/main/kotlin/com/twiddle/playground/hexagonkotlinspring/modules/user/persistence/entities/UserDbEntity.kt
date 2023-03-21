package com.twiddle.playground.hexagonkotlinspring.modules.user.persistence.entities

import com.twiddle.playground.hexagonkotlinspring.modules.user.domain.entities.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "Users")
data class UserDbEntity(
    @Id
    @GeneratedValue
    val id: Int,
    val name: String,
    val avatarUrl: String,
)

fun UserDbEntity.toDomain() = UserEntity(
    id,
    name,
    avatarUrl,
)
