package com.ysjleader.tobyspringkotlin.chapter03.composition.converter

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO

interface DtoConverter {
    fun convertToUser(userDTO: UserDTO): User
    fun convertToUserDTO(user: User): UserDTO
}