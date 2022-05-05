package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository

class MapStructUserService(
    userRepository: UserRepository,
): AbstractUserService(
    userRepository = userRepository
) {
    override fun convertToUser(userDTO: UserDTO): User {
        TODO("Not yet implemented")
    }

    override fun convertToUserDTO(user: User): UserDTO {
        TODO("Not yet implemented")
    }
}