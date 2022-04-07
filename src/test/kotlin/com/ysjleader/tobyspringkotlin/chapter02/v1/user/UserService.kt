package com.ysjleader.tobyspringkotlin.chapter02.v1.user

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import com.ysjleader.tobyspringkotlin.chapter02.v1.login.LoginService

class UserService(
    private val userRepository: FakeUserRepository = FakeUserRepository(),
    private val loginService: LoginService
) {
    fun getUserInfo(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        val responseEntity = loginService.login(userDTO)
        val responseStatus = responseEntity.statusCode
        if(responseStatus.is2xxSuccessful && responseEntity.body!!) {
            return UserDTO.fromEntity(userRepository.findUserById(userDTO.id))
        }else {
            throw IllegalArgumentException("Invalid Input")
        }
    }

    fun updateUserName(userDTO: UserDTO): UserDTO {
        requireNotNull(userDTO.id)
        requireNotNull(userDTO.password)
        requireNotNull(userDTO.name)
        val responseEntity = loginService.login(userDTO)
        val responseStatus = responseEntity.statusCode
        if(responseStatus.is2xxSuccessful && responseEntity.body!!) {
            return UserDTO.fromEntity(userRepository.updateUserName(id = userDTO.id, name = userDTO.name!!))
        }else {
            throw IllegalArgumentException("Invalid Input")
        }
    }
}