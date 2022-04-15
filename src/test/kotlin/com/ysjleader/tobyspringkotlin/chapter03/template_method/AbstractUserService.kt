package com.ysjleader.tobyspringkotlin.chapter03.template_method

import com.ysjleader.tobyspringkotlin.chapter03.domain.User
import com.ysjleader.tobyspringkotlin.chapter03.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter03.repository.UserRepository

abstract class AbstractUserService(
    private val userRepository: UserRepository
) {

    fun createUser(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.userId)
        requireNotNull(userDTO.userName)
        requireNotNull(userDTO.userAddress)
        val user = convertToUser(userDTO)
        val savedUser = userRepository.save(user)
        return convertToUserDTO(savedUser)
    }

    fun changeUserInfo(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.userId)
        requireNotNull(userDTO.userName)
        requireNotNull(userDTO.userAddress)
        val user = convertToUser(userDTO)
        val updatedUser = userRepository.update(user)
        return convertToUserDTO(updatedUser)
    }

    protected abstract fun convertToUser(userDTO: UserDTO): User
    protected abstract fun convertToUserDTO(user: User): UserDTO

}