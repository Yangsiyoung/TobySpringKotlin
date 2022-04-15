package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.config.ModelMapperFactory
import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository
import org.modelmapper.ModelMapper

class ModelMapperUserService(
    userRepository: UserRepository,
    private val modelMapper: ModelMapper = ModelMapperFactory.getInstance()
): AbstractUserService(
    userRepository = userRepository
) {
    override fun convertToUser(userDTO: UserDTO): User {
        return modelMapper.map(userDTO, User::class.java)
    }

    override fun convertToUserDTO(user: User): UserDTO {
        return modelMapper.map(user, UserDTO::class.java)
    }
}