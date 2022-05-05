package com.ysjleader.tobyspringkotlin.chapter03.composition.converter.impl

import com.ysjleader.tobyspringkotlin.chapter03.composition.converter.DtoConverter
import com.ysjleader.tobyspringkotlin.chapter03.config.ModelMapperFactory
import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import org.modelmapper.ModelMapper

class ModelMapperDtoConverter: DtoConverter {

    private val modelMapper: ModelMapper = ModelMapperFactory.getInstance()

    override fun convertToUser(userDTO: UserDTO): User {
        return modelMapper.map(userDTO, User::class.java)
    }

    override fun convertToUserDTO(user: User): UserDTO {
        return modelMapper.map(user, UserDTO::class.java)
    }
}