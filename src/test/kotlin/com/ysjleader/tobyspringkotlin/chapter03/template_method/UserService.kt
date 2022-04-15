package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository

class UserService(
    userRepository: UserRepository
): AbstractUserService(
    userRepository = userRepository
) {
    override fun convertToUser(userDTO: UserDTO): User {
        return User(
            userId = userDTO.userId,
            userName = userDTO.userName,
            userAddress = userDTO.userAddress
        )
    }

    override fun convertToUserDTO(user: User): UserDTO {
        return UserDTO(
            userId = user.userId,
            userName = user.userName,
            userAddress = user.userAddress
        )
    }
}