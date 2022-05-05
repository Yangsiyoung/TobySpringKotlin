package com.ysjleader.tobyspringkotlin.chapter03.composition.converter.impl

import com.ysjleader.tobyspringkotlin.chapter03.composition.converter.DtoConverter
import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO

class ConstructorDtoConverter : DtoConverter {
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