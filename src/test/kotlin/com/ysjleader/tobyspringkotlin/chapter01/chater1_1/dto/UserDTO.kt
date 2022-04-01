package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.entity.User

data class UserDTO(
    var id: String = "",
    var name: String? = null,
    var password: String? = null
) {
    companion object {
        fun fromEntity(user: User): UserDTO {
            return UserDTO(
                id = user.id,
                name = user.name
            )
        }
    }
}