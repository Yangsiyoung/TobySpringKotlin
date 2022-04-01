package com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v4

import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.dto.UserDTO
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.repository.fake.FakeUserRepository
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v4.login.LoginService
import com.ysjleader.tobyspringkotlin.chapter01.chater1_1.v4.login.RestTemplateLoginService

class UserService(
    private val userRepository: FakeUserRepository = FakeUserRepository(),
    private val loginService: LoginService = RestTemplateLoginService()
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