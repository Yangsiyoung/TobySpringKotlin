package com.ysjleader.tobyspringkotlin.chapter03.dto

import com.ysjleader.tobyspringkotlin.chapter03.domain.User

data class UserDTO(
    val userId: String = "",
    val userName: String = "",
    val userAddress: String = ""
) {

    companion object {
        fun fromEntity(user: User): UserDTO {
            return UserDTO(
                userId = user.userId,
                userName = user.userName,
                userAddress = user.userAddress,
            )
        }
    }
}