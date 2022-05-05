package com.ysjleader.tobyspringkotlin.chapter03.composition

import com.ysjleader.tobyspringkotlin.chapter03.composition.converter.DtoConverter
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository

class UserService(
    private val userRepository: UserRepository,
    private val dtoConverter: DtoConverter
) {
    fun createUser(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.userId)
        requireNotNull(userDTO.userName)
        requireNotNull(userDTO.userAddress)
        val user = dtoConverter.convertToUser(userDTO)
        val savedUser = userRepository.save(user)
        return dtoConverter.convertToUserDTO(savedUser)
    }

    fun changeUserInfo(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.userId)
        requireNotNull(userDTO.userName)
        requireNotNull(userDTO.userAddress)
        val user = dtoConverter.convertToUser(userDTO)
        val updatedUser = userRepository.update(user)
        return dtoConverter.convertToUserDTO(updatedUser)
    }

}